package implementations;

import utilities.Iterator;
import utilities.ListADT;

public class MyDLL<E> implements ListADT<E> {
	
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private MyDLLNode<E> current;
	private int size;

	
	public MyDLL()
	{
		head = tail = null;
		size = 0;
	}


	public boolean isEmpty() {
		return head == null;
	}
	
	public int size()
	{
		return size;
	}
	
	public void clear()
	{
		head = tail = null;
		size = 0;
	}
	
	public MyDLLNode<E> getHead()  {
		return head;
	}
	
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if ( toAdd == null ) {
			throw new NullPointerException( "Cannot store an null" );
		} 
		if ( index < 0 || index > size ) {
			throw new IndexOutOfBoundsException( "Index is out of bounds, has to be: 0-" + (size) );
		}
		
		if (isEmpty()) {
			head = new MyDLLNode<E>( toAdd );
			tail = head;
			size++;
			return true;
		}
		
		if ( size == 1 && index == 0) {
			MyDLLNode<E> insert = new MyDLLNode<E>( toAdd, tail, head );
			head.setNext(insert);
			tail.setPrev(insert);
			return true;
		}
		
		if ( index == 0 ) {
			current = head;
			head = new MyDLLNode<E>( toAdd, current, tail );
			current.setPrev(head);
			current.getNext().setPrev(current);
			current.setNext(current.getNext());
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


	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if ( toAdd == null )
		{
			throw new NullPointerException( "Cannot store an null" );
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


	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if ( index < 0 || index > size || isEmpty() ) {
			throw new IndexOutOfBoundsException( "Index is out of bounds, has to be: 0-" + (size) );
		}
		
		current = head;
		for( int i = 0; i < ( index ); i++ )
		{
			current = current.getNext();
		}
		
		return current.getElement();
	}


	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if ( index < 0 || index > size || isEmpty() ) {
			throw new IndexOutOfBoundsException( "Index is out of bounds, has to be: 0-" + (size) );
		}
		
		E deletedElement;
		if ( size == 1 )
		{
			deletedElement = head.getElement();
			clear();
			size--;
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


	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
