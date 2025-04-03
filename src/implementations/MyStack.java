package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;
import utilities.ListADT;


/**
 * A generic stack implementation using a custom list as the backing structure.
 * Supports standard LIFO operations.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStack<E> implements StackADT<E> {
	
    /** The internal list storing stack elements */
	private ListADT<E> list;

	
    /**
     * Constructs an empty stack using MyArrayList as the backing list.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }


    /**
     * Adds an element to the top of the stack.
     *
     * @param toAdd the element to push
     * @throws NullPointerException if the element is null
     */

	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) throw new NullPointerException("Cannot push null onto the stack.");
        list.add(toAdd);
	}

	
    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty())  throw new EmptyStackException();
		return list.remove(list.size() - 1);
	}

	
    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */

	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty())  throw new EmptyStackException();
		return list.get(list.size() - 1);
	}

	
    /**
     * Removes all elements from the stack.
     */

	@Override
	public void clear() {
		list.clear();
		
	}

	
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	
    /**
     * Returns an array containing all elements in the stack (top element first).
     *
     * @return an array of elements in reverse order
     */

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = list.get(size() - 1 - i); 
        }
        return arr;
	}

	
    /**
     * Copies stack elements into the given array in reverse order.
     *
     * @param holder the target array
     * @return the filled array
     * @throws NullPointerException if the array is null
     */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) throw new NullPointerException();

	    if (holder.length < size()) {
	        holder =(E[]) java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), size());
	    }

	    for (int i = 0; i < size(); i++) {
	        holder[i] = list.get(size() - 1 - i);
	    }

	    if (holder.length > size()) {
            holder[size()] = null;
        }

	    return holder;
	}

	
    /**
     * Checks if the stack contains the given element.
     *
     * @param toFind the element to search for
     * @return true if found, false otherwise
     * @throws NullPointerException if the element is null
     */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
	        throw new NullPointerException("Cannot search for null in stack.");
	    }
        return list.contains(toFind);
	}

	
    /**
     * Searches for an element and returns its 1-based position from the top.
     *
     * @param toFind the element to find
     * @return position from the top, or -1 if not found
     */
	@Override
	public int search(E toFind) {
		if (toFind == null) return -1;
		for (int i = list.size() -1; i >= 0; i--) {
            if (toFind.equals(list.get(i))) {
                return list.size() - i;
            }
        }
        return -1;
	}

	
    /**
     * Returns an iterator that traverses the stack from top to bottom.
     *
     * @return an iterator for the stack
     */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
            private int current = list.size() - 1;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public E next() {
            	if (!hasNext()) throw new NoSuchElementException();
                return list.get(current--);
            }
        };
	}

	
    /**
     * Compares this stack with another stack for equality.
     *
     * @param that the other stack
     * @return true if both stacks are equal, false otherwise
     */
	@Override
	public boolean equals(StackADT<E> that) {
		if (this == that) return true;
        if (that == null || size() != that.size()) return false;

        Iterator<E> thisIter = this.iterator();
        Iterator<E> thatIter = that.iterator();

        while (thisIter.hasNext() && thatIter.hasNext()) {
            E e1 = thisIter.next();
            E e2 = thatIter.next();
            if (!(e1 == null ? e2 == null : e1.equals(e2))) {
                return false;
            }
        }
        return true;
	}

	
    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
	@Override
	public int size() {
		 return list.size();
	}

	
    /**
     * Indicates if the stack is full. This implementation never overflows.
     *
     * @return false always
     */
	@Override
	public boolean stackOverflow() {
		return false;
	}

}
