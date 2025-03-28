package implementations;


public class MyDLLNode<E> {
	
	private E element;
	private MyDLLNode<E> next;
	private MyDLLNode<E> prev;
	
	public MyDLLNode(E element, MyDLLNode<E> next, MyDLLNode<E> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
	
	public MyDLLNode(E element) {
		this.element = element;
		this.next = null;
		this.prev = null;
	}
	
	public E getElement() {
		return this.element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public MyDLLNode<E> getNext()
	{
		return this.next;
	}
	
	public void setNext( MyDLLNode<E> next )
	{
		this.next = next;
	}	
	
	public MyDLLNode<E> getPrev()
	{
		return this.prev;
	}
	
	public void setPrev( MyDLLNode<E> prev )
	{
		this.prev = prev;
	}
	
	@Override
	public String toString()
	{
		return "Node element: " + this.element + ", next: " + this.next + ", prev: " + this.prev;
	}
}
