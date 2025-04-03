package appDomain;


import exceptions.EmptyQueueException;
import implementations.MyArrayList;
import implementations.MyQueue;
import implementations.MyStack;

public class XmlParser {
	
	private MyArrayList<String> errors;
    private MyStack<String> tagStack;
    private MyQueue<String> tagQueue;

    public XmlParser() {
        errors = new MyArrayList<>();
        tagStack = new MyStack<>();
        tagQueue = new MyQueue<>();
    }

    public void parseXML(MyArrayList<String> lines) {
    	for (int i = 0; i < lines.size(); i++) {
	           parse(lines.get(i), i + 1);
	        }
    	checkUnclosedTags();
    	displayErrors();
    }
    
    public void parse(String xmlContent, int lineNum) {
        extractTags(xmlContent, lineNum);
        processTags(lineNum);
    }

    private void extractTags(String xmlContent, int lineNum) {
        int i = 0;
        int len = xmlContent.length(); // length of the line 
        while (i < len) {
            if (xmlContent.charAt(i) == '<') {  // first character 
                int start = i;
                int end = xmlContent.indexOf('>', i);
                if (end == -1) {  // character doesn't exist 
                    errors.add("Error on Line " + lineNum +  ": Unclosed tag at position " + start);
                    break;
                }
                String tagContent = xmlContent.substring(start + 1, end);
                i = end + 1;
                if (tagContent.startsWith("?") || tagContent.startsWith("!")) continue;
                tagQueue.enqueue(tagContent);
            } 
            else {
                i++;
            }
        }
    }

    private void processTags(int lineNum) {
    	while (!tagQueue.isEmpty()){
            String tag;
			try {
				tag = tagQueue.dequeue();
				if (tag.startsWith("/")) {
	                handleClosingTag(tag, lineNum);
	            } 
	            else if (tag.endsWith("/")) {
	                handleSelfClosingTag(tag, lineNum);
	            } 
	            else {
	                handleOpeningTag(tag, lineNum);
	            }
			} 
			catch (EmptyQueueException e) {}
        }
    }

    private void handleOpeningTag(String tag, int lineNum) {
        String name = extractTagName(tag);
        if (name.isEmpty() || tag.contains("/")) {
            errors.add("Error on Line " + lineNum +  ": Invalid opening tag '" + tag + "'");
            return;
        }
        tagStack.push(name);
    }

    private void handleClosingTag(String tag, int lineNum) {
    	// self closing tag without content
        if (tag.length() == 1 || tag.indexOf('/', 1) != -1) {  
            errors.add("Error on Line " + lineNum +  ": Invalid closing tag '" + tag + "'");
            return;
        }
        // pop is used instead of peek because a closing tag has to match the most recent opening one
        String expected = tagStack.isEmpty() ? null : tagStack.pop();
        String actual = extractTagName(tag.substring(1));
        if (actual.isEmpty()) {
            errors.add("Error on Line " + lineNum +  ": Empty closing tag");
        } 
        else if (!expected.equals(actual)) {
            errors.add("Error on Line " + lineNum +  ": Expected '</" + expected + ">' but found '</" + actual + ">'");
        }
    }

    private void handleSelfClosingTag(String tag, int lineNum) {
    	// don't include ' / ' since self-closing
        String name = extractTagName(tag.substring(0, tag.length() - 1)); 
        if (name.isEmpty()) {
            errors.add("Error on Line " + lineNum +  ": Invalid self-closing tag '" + tag + "'");
        }
    }

    private String extractTagName(String tagContent) {
        String trimmed = tagContent.trim();
        int firstSpace = trimmed.indexOf(' ');
        return firstSpace == -1 ? trimmed : trimmed.substring(0, firstSpace);
    }

    private void checkUnclosedTags() {
        while (!tagStack.isEmpty()) {
            errors.add("Unclosed tag: <" + tagStack.pop() + ">");
        }
    }

    private void displayErrors() {
        if (errors.isEmpty()) {
            System.out.println("XML is valid.");
        } 
        else {
            System.out.println("Errors found:");
            for (int i = 0; i < errors.size(); i++) {
                System.out.println((i + 1) + ". " + errors.get(i));
            }
        }
    }

}