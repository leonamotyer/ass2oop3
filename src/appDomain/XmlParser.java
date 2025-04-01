package appDomain;

import java.util.List;

import implementations.MyQueue;
import implementations.MyStack;

public class XmlParser<E> {
	
	private MyStack<E> stack;
	private MyQueue<E> errorQ;
	private MyQueue<E> extrasQ;
	
	public XmlParser() {
		
	
	}
	
	//public List<String> parseXML(List<String> lines) {
		// for (String line : lines ) {
		//	
		//	for (int i = 0; i <= line.length(); i++) {
		//		String current = line.substring(i, i + 1);
		//		if ( current.equals("/")) {
					// stack.push(current) 
		//		}
		//		else if ( current.equals("<") ) {
					//stack.push(current)
		//		}
		//		else if ( current.equals(">") ) {
					// if ( stack.peek().equals("<") ) {
					// 	 stack.pop();
					// } 
					
					// else if ( errorQueue.peek().equals("<") ) {
					// 	 errorQueue.dequeue();
					// }
					
					// else if ( stack.isEmpty() ) {
					// 	 errorQueue.enqueue();
					// }
					
					// else {
					// 	 if ( stack.search("<") ) {
					//      for (E element : stack) {
					// 			errorQueue.enqueue(stack.pop());
					// 		}
					// 	 errors.add("Error on line " + line + " at index: " + i)
					//   }
					// 	 else {
					// 		extrasQueue.enqueue(current);
					// 	 }
					// }
					// 
		//		}
		//		else {}
				
		//	}
		// }
		// if ( !stack.isEmpty() ) {
		// 	 for (E element : stack) {
		// 	 	errorQueue.enqueue(stack.pop());
		// 	 }
		// }
		// if ( (errorQueue.isEmpty() || extrasQueue.isEmpty()) && !(errorQueue.isEmpty() && extrasQueue.isEmpty()) {
		// 	 for (E element : errorQueue) {
		// 	 	errors.add(element)
		// 	 }
		// 	 for (E element : extrasQueue) {
		// 	 	errors.add(element)
		// 	 }
		// if ( !errorQueue.isEmpty() && !extrasQueue.isEmpty() ) {
		// 	 if ( !errorQueue.peek().equals(extrasQueue.peek()) ) {
		// 	     errors.add(errorQueue.dequeue()) 
		//   }
		//   else {
		//       errorQueue.dequeue();
		//       extrasQueue.dequeue();
		//   }
		// repeat until both are empty 
		
	//}

}
