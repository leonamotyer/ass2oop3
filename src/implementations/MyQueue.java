package implementations;
 
import java.util.NoSuchElementException;
 
import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;
 
/**
 * A generic queue implementation using MyDLL as the internal structure.
 * Supports standard FIFO operations.
 *
 * @param <E> the type of elements in this queue
 */
public class MyQueue<E> implements QueueADT<E> {
 
 	private MyDLL<E> dll;
 	int size = 0;
 
 
	/**
	 * Constructs an empty queue.
	 */
 	public MyQueue() {
 		this.dll = new MyDLL<E>();
 	}
 
 	
    /**
     * Adds an element to the rear of the queue.
     *
     * @param toAdd the element to be added
     * @throws NullPointerException if the element is null
     */
 	@Override
 	public void enqueue(E toAdd) throws NullPointerException {
 		if ( toAdd == null ) {
 			throw new NullPointerException();
 		}
 		this.dll.add(toAdd);
 	}
 
 	
    /**
     * Removes and returns the front element of the queue.
     *
     * @return the front element
     * @throws EmptyQueueException if the queue is empty
     */
 	@Override
 	public E dequeue() throws EmptyQueueException {
 		if ( this.dll.size() == 0 ) {
 			throw new EmptyQueueException();
 		}
 
 		return this.dll.remove(0);
 	}
 
 	
    /**
     * Returns the front element without removing it.
     *
     * @return the front element
     * @throws EmptyQueueException if the queue is empty
     */
 	@Override
 	public E peek() throws EmptyQueueException {
 		if ( this.dll.size() == 0 ) {
 			throw new EmptyQueueException();
 		}
 
 		return this.dll.get(0);
 	}
 	
 	
    /**
     * Removes all elements from the queue.
     */
 	@Override
 	public void dequeueAll() {
 		this.dll.clear();
 	}
 
 	
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
 	@Override
 	public boolean isEmpty() {
 		if ( this.dll.size() == 0 ) {
 			return true;
 		}
 		return false;
 	}
 
 	
    /**
     * Determines if the queue contains a specific element.
     *
     * @param toFind the element to search for
     * @return true if the element exists in the queue, false otherwise
     * @throws NullPointerException if the input is null
     */
 	@Override
 	public boolean contains(E toFind) throws NullPointerException {
 		if ( toFind == null ) {
 			throw new NullPointerException();
 		}
 
 		return this.dll.contains(toFind);
 	}
 
 	
    /**
     * Searches for the element and returns its 1-based position in the queue.
     *
     * @param toFind the element to locate
     * @return the position if found, otherwise -1
     */
 	@Override
 	public int search(E toFind) {
 		if ( this.dll.isEmpty() ) {
 			return -1;
 		}
 		if ( this.dll.getHead().getElement().equals(toFind) ) {
 			return 1;
 		}
 		Iterator<E> it = this.dll.iterator();
 		int position = 1;
 		while ( it.hasNext() ) {
 			if ( toFind.equals(it.next())) {
 				return position;
 			}
 			position++;
 		}
 
 		return -1;
 	}
 
 	
    /**
     * Returns an iterator over the queue.
     *
     * @return an iterator
     */
 	@Override
 	public Iterator<E> iterator() {
 		return this.dll.iterator();
 	}
 
 	
    /**
     * Compares this queue to another for equality.
     *
     * @param that the other queue
     * @return true if equal, false otherwise
     */
 	@Override
 	public boolean equals(QueueADT<E> that) {
 		try {
 			if ( !this.peek().equals(that.peek())) {
 				return false;
 			}
 		}
 		catch ( EmptyQueueException e ) {
 			return false;
 		}
 
 		Iterator<E> queue1 = this.dll.iterator();
 		Iterator<E> queue2 = that.iterator();
 
 		while ( queue1.hasNext() ) {
 			if ( !queue1.next().equals(queue2.next())) {
 				return false;
 			}
 		}
 		return true;
 	}
 
 	
    /**
     * Converts the queue to an array.
     *
     * @return an Object array containing the queue's elements
     */
 	@Override
 	public Object[] toArray() {
 		return this.dll.toArray();
 	}
 
 	
    /**
     * Copies the queue elements into the provided array.
     *
     * @param holder the array to hold the elements
     * @return the filled array
     * @throws NullPointerException if the array is null
     */
 	@Override
 	public E[] toArray(E[] holder) throws NullPointerException {
 		return this.dll.toArray(holder);
 	}
 
 	
    /**
     * Checks whether the queue is full (always false).
     *
     * @return false
     */
 	@Override
 	public boolean isFull() {
 
 		return false;
 	}
 
 	
    /**
     * Returns the number of elements in the queue.
     *
     * @return the queue size
     */
 	@Override
 	public int size() {
 		return this.dll.size();
 	}
 
 }