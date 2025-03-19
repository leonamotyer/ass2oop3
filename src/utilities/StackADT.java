package utilities;

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
    
    
    /**
     * Method to check if another stack contains the same elements in the same order.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: A boolean value representing if both stacks have the same elements.
     * 
     * @param that The stack to compare against.
     * @return true if both stacks are equal, false otherwise.
     */
    boolean equals(StackADT<E> that);

    
    /**
     * Method to return an iterator over the elements in the stack.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: An iterator is returned to iterate over stack elements.
     * 
     * @return An iterator over the stack.
     */
    Iterator<E> iterator();
    

    /**
     * Method to convert the stack contents to an array.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: The stack elements are stored in an Object array.
     * 
     * @return An array containing all elements in the stack.
     */
    Object[] toArray();
    

    /**
     * Method to copy the stack contents into an existing array.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: The stack elements are copied into the provided array.
     * 
     * @param copy The array to store stack elements.
     * @return The array containing stack elements.
     */
    E[] toArray(E[] copy);
    

    /**
     * Method to search for an item in the stack.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: The position of the item in the stack is returned (1-based index).
     * 
     * @param obj The item to search for.
     * @return The 1-based position of the item, or -1 if not found.
     */
    int search(E obj);
    

    /**
     * Method to check if the stack contains a specific item.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: A boolean value representing if the item is found in the stack.
     * 
     * @param obj The item to check for.
     * @return true if the item is in the stack, false otherwise.
     */
    boolean contains(E obj);
    

    /**
     * Method to remove all elements from the stack.
     * 
     * Precondition: A valid Stack object exists.
     * 
     * Postcondition: The stack is cleared of all elements.
     */
    void clear();
}