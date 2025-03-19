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
    
    /**
     * Check if the queue is full.
     * (Optional method for fixed-size queues.)
     * 
     * Precondition: A valid Queue object exists.
     * 
     * Postcondition: A boolean value representing if the queue has 
     * reached its maximum capacity is returned.
     * 
     * @return true if the queue is full, false otherwise.
     */
    boolean isFull();
    
    /**
     * Returns an array containing all of the items in this queue.
     * The head of the queue corresponds to the first element of the array.
     * 
     * Precondition: A valid Queue object exists.
     * 
     * Postcondition: An Object array containing all of the items in the queue is returned.
     * 
     * @return an array containing all of the items in this queue.
     */
   
    Object[] toArray();
    
    /**
     * Returns an array containing all of the items in this queue;
     * the runtime type of the returned array is that of the specified array.
     * The head of the queue corresponds to the first element of the array.
     * 
     * Precondition: A valid Queue object exists.
     * 
     * Postcondition: An array containing all of the items in the queue is returned.
     * 
     * @param copy the array into which the elements of the queue are to be stored,
     *             if it is big enough; otherwise, a new array of the same runtime type is allocated.
     * @return an array containing all of the items in this queue.
     */
    E[] toArray(E[] copy);
    
    /**
     * Returns an iterator over the items in this queue.
     * The iterator's remove() method is not supported.
     * 
     * Precondition: A valid Queue object exists.
     * 
     * Postcondition: An Iterator for the items in the queue is returned.
     * 
     * @return an Iterator over the items in this queue.
     */
    Iterator<E> iterator();
    
    /**
     * Compares the specified queue with this queue for equality.
     * Two queues are equal if they contain equal items appearing in the same order.
     * 
     * Precondition: A valid Queue object exists.
     * 
     * Postcondition: A boolean value representing whether the specified queue 
     * is equal to this queue is returned.
     * 
     * @param that the queue to be compared for equality with this queue.
     * @return true if the specified queue is equal to this queue, false otherwise.
     */
    boolean equals(QueueADT<E> that);
    
    /**
     * Removes all items from the queue.
     * 
     * Precondition: A valid Queue object exists.
     * 
     * Postcondition: The queue is empty after all items have been removed.
     */
    void dequeueAll();

}
