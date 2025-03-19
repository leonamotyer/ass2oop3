import java.util.NoSuchElementException;

/**
 * A queue ADT (First-In-First-Out).
 * @param <E> The type of elements stored in the queue.
 * 
 * Class Definition: This interface represents the public contract for the
 * implementation of Queue for Assignment 2. 
 */
public interface QueueADT<E> {
    /**
     * Method to add an item to the rear of the queue.
     * 
     * Precondition: A valid Queue object exists and has items in 
     * the Queue.
	 * 
	 * Postcondition: An <E> item specified
	 * in the argument is added to the end of the Queue.
     * 
     * @param item The item to add.
     * @throws NullPointerException if the item is null.
     */
    void enqueue(E item) throws NullPointerException;

    /**
     * Method to remove and return the front item of the queue.
     * 
     * Precondition: A valid Queue object exists and has items in 
     * the Queue.
	 * 
	 * Postcondition: A <E> item representing the current 
	 * first item in the Queue that was removed.
     * 
     * @return The front item.
     * @throws NoSuchElementException if the queue is empty.
     */
    E dequeue() throws NoSuchElementException;

    /**
     * Returns the front item without removing it.
     * 
     * Precondition: A valid Queue object exists and has items in 
     * the Queue.
	 * 
	 * Postcondition: A <E> item representing the current 
	 * top item in the Queue is returned.
     * 
     * @return The front item.
     * @throws NoSuchElementException if the queue is empty.
     */
    E peek() throws NoSuchElementException;

    /**
     * Method to check if the queue is empty.
     * 
     * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: A boolean value representing if there are 
	 * contents in the Queue.
     * 
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Get the number of items in the queue.
     * 
     * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: The size of the Queue object is returned.
     * 
     * @return The size.
     */
    int size();
   
}
