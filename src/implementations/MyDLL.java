package implementations;


import java.util.Arrays;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;


/**
 * A generic doubly linked list implementation using MyDLLNode.
 * Supports indexed access and manipulation of elements.
 *
 * @param <E> the type of elements in this list
 */
public class MyDLL<E> implements ListADT<E> {
	
	
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private MyDLLNode<E> current;
	private int size;

	
	/**
	 * Constructs an empty doubly linked list.
	 */
	public MyDLL()
	{
		head = tail = null;
		size = 0;
	}


	/**
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	
    /**
     * @return the number of elements in the list
     */
	public int size()
	{
		return size;
	}
	
	
    /**
     * Clears all elements from the list.
     */
	public void clear()
	{
		head = tail = null;
		size = 0;
	}
	
	
	/**
	 * @return the head node of the list
	 */
	public MyDLLNode<E> getHead()  {
		return head;
	}
	
	
	 /**
     * Adds an element at a specified index in the list.
     *
     * @param index the position to insert at
     * @param toAdd the element to add
     * @return true if added successfully
     * @throws NullPointerException if element is null
     * @throws IndexOutOfBoundsException if index is invalid
     */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if ( toAdd == null ) {
			throw new NullPointerException( "Cannot store a null value" );
		} 
		if ( index < 0 || index > size ) {
			throw new IndexOutOfBoundsException(
					"The index of " + index + ", is outside the bounds of the list" );
		}
		
		if (isEmpty()) {
			head = new MyDLLNode<E>( toAdd );
			tail = head;
			size++;
			return true;
		}
	
		
		if ( index == 0 ) {
			current = head;
			head = new MyDLLNode<E>( toAdd, current, tail );
			current.setPrev(head);
			tail.setNext(head);
			size++;	
			return true;
		}
		
		if ( index == size ) {
			current = tail;
			tail = new MyDLLNode<E>( toAdd, null, current );
			current.setNext( tail );
			size++;
			return true;
		}
		
		MyDLLNode<E> before = head;
		MyDLLNode<E> after = head.getNext();
		
		for( int i = 0; i < ( index - 1 ); i++ )
		{
			before = before.getNext();
			after = after.getNext();
		}
		
		MyDLLNode<E> insert = new MyDLLNode<E>( toAdd, after, before );
		
		before.setNext(insert);
		after.setPrev(insert);
		size++;
		return true;
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
		if ( toAdd == null )
		{
			throw new NullPointerException( "Cannot store a null value" );
		} 
		
		if (isEmpty()) {
			head = new MyDLLNode<E>( toAdd );
			tail = head;
			size++;
			return true;
		}
		
		current = tail;
		tail = new MyDLLNode<E>( toAdd, null, current );
		current.setNext( tail );
		size++;
		return true;
	}


    /**
     * Adds all elements from another list.
     *
     * @param toAdd the list to add from
     * @return true if added
     * @throws NullPointerException if toAdd is null
     */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if( toAdd == null )
		{
			throw new NullPointerException( "Cannot add a null list" );
		}

		for( int i = 0; i < toAdd.size(); i++ )
		{
			this.add( toAdd.get( i ) );
		}
		return true;
	}


    /**
     * Retrieves an element at a given index.
     *
     * @param index the index to retrieve from
     * @return the element
     * @throws IndexOutOfBoundsException if index is invalid
     */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if ( index < 0 || index > size || isEmpty() ) {
			throw new IndexOutOfBoundsException(
					"The index of " + index + ", is outside the bounds of the list" );
		}
		
		current = head;
		for( int i = 0; i < ( index ); i++ )
		{
			current = current.getNext();
		}
		
		return current.getElement();
	}


    /**
     * Removes the element at a specific index.
     *
     * @param index the index to remove from
     * @return the removed element
     * @throws IndexOutOfBoundsException if index is invalid
     */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if ( index < 0 || index > size() || isEmpty() ) {
			throw new IndexOutOfBoundsException(
					"The index of " + index + ", is outside the bounds of the list" );
		}
		
		E deletedElement;
		if ( size == 1 )
		{
			deletedElement = head.getElement();
			clear();
			return deletedElement;
		}
		
		if ( index == 0 ) {
			deletedElement = head.getElement();
			MyDLLNode<E> newHead = head.getNext();
			newHead.setPrev(tail);
			tail.setNext(newHead);
			head = newHead;
			size--;
			return deletedElement;
		}
		
		if ( index == size ) {
			deletedElement = tail.getElement();
			MyDLLNode<E> newTail = tail.getPrev();
			newTail.setNext(head);
			tail = newTail;
			size--;
			return deletedElement;
		}
		
		current = head;
		for( int i = 0; i < ( index ); i++ )
		{
			current = current.getNext();
		}
		
		MyDLLNode<E> deletedNode = current;
		MyDLLNode<E> before = current.getPrev();
		MyDLLNode<E> after = current.getNext();
		
		before.setNext(after);
		if ( after == null ) {
			tail.setPrev(before);
			size--;
			return deletedNode.getElement();
		}
		after.setPrev(before);
		size--;
		return deletedNode.getElement();
		
	}


    /**
     * Removes a specific element.
     *
     * @param toRemove the element to remove
     * @return the removed element or null if not found
     * @throws NullPointerException if toRemove is null
     */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if ( toRemove == null ) {
			throw new NullPointerException( "Can't remove a null value from the list" );
		}
		
		current = head;
		MyDLLNode<E> deletedNode;
		E deletedElement;
		
		if ( size == 1 && toRemove.equals(current.getElement()) )
		{
			deletedElement = head.getElement();
			clear();
			return deletedElement;
		}
		
		if ( toRemove.equals(current.getElement()) ) {
			deletedElement = head.getElement();
			MyDLLNode<E> newHead = head.getNext();
			newHead.setPrev(tail);
			tail.setNext(newHead);
			head = newHead;
			size--;
			return deletedElement;
		}
		
		if ( toRemove.equals(tail.getElement()) ) {
			deletedElement = tail.getElement();
			MyDLLNode<E> newTail = tail.getPrev();
			newTail.setNext(head);
			tail = newTail;
			size--;
			return deletedElement;
		}
		
		while ( current.getNext() != null )
		{
			if (toRemove.equals(current.getElement())) {
				deletedNode = current;
				MyDLLNode<E> before = current.getPrev();
				MyDLLNode<E> after = current.getNext();
				
				before.setNext(after);
				after.setPrev(before);
				size--;
				return deletedNode.getElement();
			}
			current = current.getNext();
			
		}
		return null;
	}


    /**
     * Updates an element at a specific index.
     *
     * @param index index of element to update
     * @param toChange new value
     * @return the old value replaced
     * @throws NullPointerException if new value is null
     * @throws IndexOutOfBoundsException if index is invalid
     */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if( toChange == null )
		{
			throw new NullPointerException( "Can't remove a null value from the list" );
		}
		if( index < 0 || index >= size() )
		{
			throw new IndexOutOfBoundsException(
					"The index of " + index + ", is outside the bounds of the list" );
		}
		
		E deletedElement;
		if ( index == 0 ) {
			deletedElement = head.getElement();
			head.setElement(toChange);
			return deletedElement;
		}
		
		if ( index == size ) {
			deletedElement = tail.getElement();
			tail.setElement(toChange);
			return deletedElement;
		}
		
		current = head;
		for( int i = 0; i < ( index ); i++ )
		{
			current = current.getNext();
		}
		
		deletedElement = current.getElement();
		current.setElement(toChange);
		return deletedElement;
	}


    /**
     * Checks if the list contains a value.
     *
     * @param toFind value to search
     * @return true if found
     * @throws NullPointerException if value is null
     */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException( "The list cannot have a null value" );
		}
		
		current = head;
		while ( current.getNext() != null )
		{
			if (toFind.equals(current.getElement())) {
				return true;
			}
			current = current.getNext();
		}
		if ( toFind.equals(tail.getElement()) ) {
			return true;
		}
		return false;
			
		
	}

	
    /**
     * Converts the list to an array using a holder.
     *
     * @param toHold the array to fill
     * @return the filled array
     * @throws NullPointerException if array is null
     */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if( toHold == null )
		{
			throw new NullPointerException( "Cannot add to a null array" );
		}

		if( toHold.length < this.size )
		{
			toHold = Arrays.copyOf( toHold, this.size );
		}

		current = head;
		for( int i = 0; i < this.size; i++ )
		{
			toHold[i] = current.getElement();
			current = current.getNext();
		}

		return toHold;
		
	}


    /**
     * Converts the list to a raw Object array.
     *
     * @return the Object array
     */
	@Override
	public Object[] toArray() {
		Object[] toReturn = new Object[this.size];
		
		current = head;
		for( int i = 0; i < this.size; i++ )
		{
			toReturn[i] = current.getElement();
			current = current.getNext();
		}
		return toReturn;
	}


    /**
     * Returns an iterator for the list.
     *
     * @return an iterator instance
     */
	@Override
    public linearUtilities.Iterator<E> iterator() {
		E[] copy = (E[]) ( new Object[size()] );
		current = head;

		for( int i = 0; i < size; i++ )
		{
			copy[i] = current.getElement();
			current = current.getNext();
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
