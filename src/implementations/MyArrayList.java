package implementations;

import linearUtilities.Iterator;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import utilities.ListADT;


/**
 * A generic ArrayList implementation using an array as the backing structure.
 * Supports dynamic resizing and standard list operations.
 *
 * @param <E> The type of elements stored in this list.
 */
public class MyArrayList<E> implements ListADT<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    
    /**
     * Constructs an empty list with default initial capacity.
     */
    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    
    /**
     * Doubles the size of the internal array when needed.
     */
    private void resize() {
        E[] newElements = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    
    /**
     * Adds an element to the end of the list.
     *
     * @param toAdd the element to add
     * @return true if added successfully
     * @throws NullPointerException if element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        if (size == elements.length) resize();
        elements[size++] = toAdd;
        return true;
    }

    
    /**
     * Adds an element at a specific index.
     *
     * @param index the index to insert the element at
     * @param toAdd the element to add
     * @return true if added successfully
     * @throws NullPointerException if element is null
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index");

        if (size == elements.length) resize();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = toAdd;
        size++;
        return true;
    }

    
    /**
     * Removes an element at a given index.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        E removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    
    /**
     * Retrieves an element by index.
     *
     * @param index the index to access
     * @return the element at that index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        return elements[index];
    }

    
    /**
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    
    /**
     * Clears the list of all elements.
     */
    @Override
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    
    /**
     * @return true if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Adds all elements from another list.
     *
     * @param toAdd list of elements to add
     * @return true if elements were added
     * @throws NullPointerException if the list is null
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("List cannot be null");
        Iterator<? extends E> it = (Iterator<? extends E>) toAdd.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    
    /**
     * Removes a specific element from the list.
     *
     * @param toRemove the element to remove
     * @return the removed element or null if not found
     * @throws NullPointerException if element is null
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException("Cannot remove null element");
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(elements[i])) {
                return remove(i);
            }
        }
        return null;
    }

    
    /**
     * Updates the value at the given index.
     *
     * @param index index of the element to change
     * @param toChange new value
     * @return old value that was replaced
     * @throws NullPointerException if new value is null
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) throw new NullPointerException("Cannot set null element");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        E oldElement = elements[index];
        elements[index] = toChange;
        return oldElement;
    }

    
    /**
     * Checks if a value exists in the list.
     *
     * @param toFind the value to find
     * @return true if found
     * @throws NullPointerException if value is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException("Cannot search for null element");
        for (int i = 0; i < size; i++) {
            if (toFind.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * Copies the elements into a provided array.
     *
     * @param toHold the destination array
     * @return the filled array
     * @throws NullPointerException if array is null
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException("Array cannot be null");
        if (toHold.length < size) {
        	// Added the explicit type conversion for use in the newInstance method
        	Class<?> componentType = toHold.getClass().getComponentType();
            toHold = (E[]) Array.newInstance(componentType, size);
        } else if (toHold.length > size) {
            toHold[size] = null;
        }
        for (int i = 0; i < size; i++) {
            toHold[i] = elements[i];
        }
        return toHold;
    }

    
    /**
     * Converts the list into an Object array.
     *
     * @return an Object array of list elements
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }
    
    
    /**
     * Returns an iterator for the list.
     *
     * @return an iterator
     */
    @Override
    public linearUtilities.Iterator<E> iterator() {
    	E[] copy = (E[]) ( new Object[size()] );

		for (int i = 0; i < size; i++) {
            copy[i] = elements[i];
        }
        return new linearUtilities.Iterator<E>() {
            private int currentIndex = 0;
            private E[] copyOfElements = copy;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return copyOfElements[currentIndex++];
            }
        };
    }

}