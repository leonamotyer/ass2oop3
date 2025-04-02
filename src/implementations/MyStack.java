package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;
import utilities.ListADT;

public class MyStack<E> implements StackADT<E> {
	
	private ListADT<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

   
	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) throw new NullPointerException("Cannot push null onto the stack.");
        list.add(toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty())  throw new EmptyStackException();
		return list.remove(list.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty())  throw new EmptyStackException();
		return list.get(list.size() - 1);
	}

	@Override
	public void clear() {
		list.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = list.get(size() - 1 - i); // reverse order
        }
        return arr;
	}

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

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
	        throw new NullPointerException("Cannot search for null in stack.");
	    }
        return list.contains(toFind);
	}

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
		 return list.size();
	}

	@Override
	public boolean stackOverflow() {
		return false;
	}

}
