package implementations;

import java.util.Arrays;
import java.util.NoSuchElementException;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

public class MyQueue<E> implements QueueADT<E> {

	private MyDLL<E> dll;
	int size = 0;
	
	
	public MyQueue() {
		this.dll = new MyDLL<E>();
	}
	
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if ( toAdd == null ) {
			throw new NullPointerException();
		}
		dll.add(toAdd);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if ( dll.size() == 0 ) {
			throw new EmptyQueueException();
		}
		
		return dll.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		if (dll.size() == 0 ) {
			throw new EmptyQueueException();
		}
		
		return dll.get(0);
	}

	@Override
	public void dequeueAll() {
		dll.clear();
	}

	@Override
	public boolean isEmpty() {
		if ( dll.size() == 0 ) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if ( toFind == null ) {
			throw new NullPointerException();
		}
		
		return dll.contains(toFind);
	}

	@Override
	public int search(E toFind) {
		if ( dll.isEmpty() ) {
			return -1;
		}
		
		if ( dll.getHead().getElement().equals(toFind) ) {
			return 1;
		}
		Iterator<E> it = dll.iterator();
		int position = 1;
		while ( it.hasNext() ) {
			if ( toFind.equals(it.next())) {
				return position;
			}
			position++;
		}
		
		return -1;
	}

	@Override
	public Iterator<E> iterator() {
		return dll.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		try {
			if ( !peek().equals(that.peek())) {
				return false;
			}
		}
		catch ( EmptyQueueException e ) {
			return false;
		}
		
		Iterator<E> queue1 = dll.iterator();
		Iterator<E> queue2 = that.iterator();
		
		while ( queue1.hasNext() ) {
			if ( !queue1.next().equals(queue2.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Object[] toArray() {
		
		return dll.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {

		return dll.toArray(holder);
	}

	@Override
	public boolean isFull() {
		
		return false;
	}

	@Override
	public int size() {
		return dll.size();
	}
	
}
