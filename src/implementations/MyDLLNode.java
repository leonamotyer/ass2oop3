package implementations;


/**
 * A node class for use in a doubly linked list implementation (MyDLL).
 * Stores element data and links to previous and next nodes.
 *
 * @param <E> the type of element stored in the node
 */
public class MyDLLNode<E> {
	
	private E element;
	private MyDLLNode<E> next;
	private MyDLLNode<E> prev;
	
	
	/**
	 * Constructs a node with element and explicit next and previous nodes.
	 *
	 * @param element the value to store
	 * @param next the next node
	 * @param prev the previous node
	 */

	public MyDLLNode(E element, MyDLLNode<E> next, MyDLLNode<E> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
	
	
	/**
	 * Constructs a node with just the element (no links).
	 *
	 * @param element the value to store
	 */

	public MyDLLNode(E element) {
		this.element = element;
		this.next = null;
		this.prev = null;
	}
	
	
	/**
	 * Gets the element stored in the node.
	 *
	 * @return the element
	 */

	public E getElement() {
		return this.element;
	}
	
	
	/**
	 * Updates the element stored in the node.
	 *
	 * @param element the new value
	 */

	public void setElement(E element) {
		this.element = element;
	}
	
	
	/**
	 * Gets the next node.
	 *
	 * @return the next node
	 */

	public MyDLLNode<E> getNext()
	{
		return this.next;
	}
	
	
	/**
	 * Sets the next node.
	 *
	 * @param next the node to set as next
	 */

	public void setNext( MyDLLNode<E> next )
	{
		this.next = next;
	}	
	
	
	/**
	 * Gets the previous node.
	 *
	 * @return the previous node
	 */

	public MyDLLNode<E> getPrev()
	{
		return this.prev;
	}
	
	
	/**
	 * Sets the previous node.
	 *
	 * @param prev the node to set as previous
	 */

	public void setPrev( MyDLLNode<E> prev )
	{
		this.prev = prev;
	}
	
	
	/**
	 * Returns a string representation of the node.
	 *
	 * @return a string showing element and link references
	 */

	@Override
	public String toString()
	{
		return "Node element: " + this.element + ", next: " + this.next + ", prev: " + this.prev;
	}
}
