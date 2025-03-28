package implementations;

import linearUtilities.Iterator;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void resize() {
        E[] newElements = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element");
        if (size == elements.length) resize();
        elements[size++] = toAdd;
        return true;
    }

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

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

      @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("List cannot be null");
        Iterator<? extends E> it = (Iterator<? extends E>) toAdd.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

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

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) throw new NullPointerException("Cannot set null element");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        E oldElement = elements[index];
        elements[index] = toChange;
        return oldElement;
    }

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

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }
    
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