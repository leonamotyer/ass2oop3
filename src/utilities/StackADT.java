import java.util.NoSuchElementException;

/**
 * A stack ADT (Last-In-First-Out).
 * @param <E> The type of elements stored in the stack.
 * 
 * Class Definition: This interface represents the public contract for the
 * implementation of Stack for Assignment 2. 
 */
public interface StackADT<E> {
    /**
     * Method to add an item to the top of the stack.
     * 
     * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: An <E> item specified
	 * in the argument is added to the stack.
	 * 
     * @param item The item to add.
     * @throws NullPointerException if the item is null.
     */
    void push(E item) throws NullPointerException;

    /**
     * Method to remove and return the top item of the stack.
     * 
     * Precondition: A valid Stack object exists and has items in 
     * the Stack.
	 * 
	 * Postcondition: A <E> item representing the current 
	 * top item in the Stack that was removed.
     * 
     * @return The top item.
     * @throws NoSuchElementException if the stack is empty.
     */
    E pop() throws NoSuchElementException;

    /**
     * Method to return the top item without removing it.
     * 
     * Precondition: A valid Stack object exists and has items in 
     * the Stack.
	 * 
	 * Postcondition: A <E> item representing the current 
	 * top item in the Stack is returned.
     * 
     * @return The top item.
     * @throws NoSuchElementException if the stack is empty.
     */
    E peek() throws NoSuchElementException;

    /**
     * Method to check if the stack is empty.
     * 
     * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: A boolean value representing if there are 
	 * contents in the Stack.
     * 
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Method to get the number of items in the stack.
     * 
     * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: The size of the Stack object is returned.
     * 
     * @return The size.
     */
    int size();
}