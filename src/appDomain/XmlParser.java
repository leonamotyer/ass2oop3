package appDomain;


import exceptions.EmptyQueueException;
import implementations.MyArrayList;
import implementations.MyQueue;
import implementations.MyStack;


/**
 * XmlParser class validates the structure of XML content.
 * It uses a custom stack and queue to parse and track tag hierarchy.
 */
public class XmlParser {
	
	/** List to store XML parsing errors */
	private MyArrayList<String> errors;
	
	/** Stack used to manage open tags */
    private MyStack<String> tagStack;
    
    /** Queue to manage parsed tags */
    private MyQueue<String> tagQueue;

    
    /**
     * Constructs a new XmlParser instance.
     */    
    public XmlParser() {
        errors = new MyArrayList<>();
        tagStack = new MyStack<>();
        tagQueue = new MyQueue<>();
    }

    
    /**
     * Parses all lines from an XML document.
     * @param lines XML lines to be parsed.
     */
    public void parseXML(MyArrayList<String> lines) {
    	for (int i = 0; i < lines.size(); i++) {
	           parse(lines.get(i), i + 1);
	        }
    	checkUnclosedTags();
    	displayErrors();
    }
    
    
    /**
     * Parses a single line of XML.
     * @param xmlContent line content
     * @param lineNum line number in the XML document
     */
    public void parse(String xmlContent, int lineNum) {
        extractTags(xmlContent, lineNum);
        processTags(lineNum);
    }

    
    /**
     * Extracts tags from a given line of XML content.
     * @param xmlContent line to scan for tags
     * @param lineNum line number for error reporting
     */
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

    
    /**
     * Processes tags stored in the queue.
     * @param lineNum line number for error reporting
     */
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

    
    /**
     * Handles opening tags by pushing them to the stack.
     * @param tag the tag content
     * @param lineNum current line number
     */
    private void handleOpeningTag(String tag, int lineNum) {
        String name = extractTagName(tag);
        if (name.isEmpty() || tag.contains("/")) {
            errors.add("Error on Line " + lineNum +  ": Invalid opening tag '" + tag + "'");
            return;
        }
        tagStack.push(name);
    }

    
    /**
     * Handles closing tags by popping from the stack and matching tag names.
     * @param tag the tag content
     * @param lineNum current line number
     */
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

    
    /**
     * Handles self-closing tags by validating format.
     * @param tag the tag content
     * @param lineNum current line number
     */
    private void handleSelfClosingTag(String tag, int lineNum) {
    	// don't include ' / ' since self-closing
        String name = extractTagName(tag.substring(0, tag.length() - 1)); 
        if (name.isEmpty()) {
            errors.add("Error on Line " + lineNum +  ": Invalid self-closing tag '" + tag + "'");
        }
    }

    
    /**
     * Extracts tag name from tag content, ignoring attributes.
     * @param tagContent tag including attributes
     * @return tag name only
     */
    private String extractTagName(String tagContent) {
        String trimmed = tagContent.trim();
        int firstSpace = trimmed.indexOf(' ');
        return firstSpace == -1 ? trimmed : trimmed.substring(0, firstSpace);
    }

    
    /**
     * Adds remaining unclosed tags in stack to the error list.
     */
    private void checkUnclosedTags() {
        while (!tagStack.isEmpty()) {
            errors.add("Unclosed tag: <" + tagStack.pop() + ">");
        }
    }

    
    /**
     * Prints all XML structure errors to the console.
     */
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