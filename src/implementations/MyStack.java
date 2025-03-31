package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {
	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_CAPACITY = 100;
    private E[] stack;
    private int top;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public MyStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
    }

	@Override
	public void push(E toAdd) throws NullPointerException {
		 if (toAdd == null) {
	            throw new NullPointerException("Cannot push null to stack.");
	        }
	        if (stackOverflow()) {
	            throw new IllegalStateException("Stack overflow.");
	        }
	        stack[++top] = toAdd;
		
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = stack[top];
        stack[top--] = null; // avoid memory leak
        return item;
	}

	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
	}

	@Override
	public void clear() {
		 for (int i = 0; i <= top; i++) {
	            stack[i] = null;
	        }
	        top = -1;
		
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size()];
        for (int i = 0; i <= top; i++) {
        	 result[i] = stack[top - i];
        }
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) throw new NullPointerException();

	    if (holder.length < size()) {
	        holder = (E[]) java.util.Arrays.copyOf(new Object[size()], size(), holder.getClass());
	    }

	    for (int i = 0; i <= top; i++) {
	        holder[i] = (E) stack[top - i]; 
	    }

	    return holder;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) throw new NullPointerException();
        for (int i = 0; i <= top; i++) {
            if (stack[i].equals(toFind)) return true;
        }
        return false;
	}

	@Override
	public int search(E toFind) {
		for (int i = top; i >= 0; i--) {
            if (stack[i].equals(toFind)) {
                return top - i + 1;
            }
        }
        return -1;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
            private int current = top;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public E next() {
            	if (!hasNext()) throw new NoSuchElementException();
                return stack[current--];
            }
        };
	}

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

	@Override
	public int size() {
		 return top + 1;
	}

	@Override
	public boolean stackOverflow() {
		return size() == stack.length;
	}

}
