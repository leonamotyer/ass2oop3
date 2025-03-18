import java.util.NoSuchElementException;

/**
 * A queue ADT (First-In-First-Out).
 * @param <E> The type of elements stored in the queue.
 */
public interface QueueADT<E> {
    /**
     * Add an item to the rear of the queue.
     * @param item The item to add.
     * @throws NullPointerException if the item is null.
     */
    void enqueue(E item) throws NullPointerException;

    /**
     * Remove and return the front item of the queue.
     * @return The front item.
     * @throws NoSuchElementException if the queue is empty.
     */
    E dequeue() throws NoSuchElementException;

    /**
     * Return the front item without removing it.
     * @return The front item.
     * @throws NoSuchElementException if the queue is empty.
     */
    E peek() throws NoSuchElementException;

    /**
     * Check if the queue is empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Get the number of items in the queue.
     * @return The size.
     */
    int size();
}
