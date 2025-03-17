import java.util.NoSuchElementException;

/**
 * A stack ADT (Last-In-First-Out).
 * @param <E> The type of elements stored in the stack.
 */
public interface StackADT<E> {
    /**
     * Add an item to the top of the stack.
     * @param item The item to add.
     * @throws NullPointerException if the item is null.
     */
    void push(E item) throws NullPointerException;

    /**
     * Remove and return the top item of the stack.
     * @return The top item.
     * @throws NoSuchElementException if the stack is empty.
     */
    E pop() throws NoSuchElementException;

    /**
     * Return the top item without removing it.
     * @return The top item.
     * @throws NoSuchElementException if the stack is empty.
     */
    E peek() throws NoSuchElementException;

    /**
     * Check if the stack is empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Get the number of items in the stack.
     * @return The size.
     */
    int size();
}