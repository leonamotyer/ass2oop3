package linearUtilities;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Iterator<E> implements utilities.Iterator<E> {

	private E[] copyOfElements;
	private int curr = 0;
	@Override
    public boolean hasNext() {
		return next() != null;
    }
	
	@Override
    public E next() {
        if (copyOfElements[curr] != null) throw new NoSuchElementException();
        E toReturn = copyOfElements[curr];
        curr++;
		return toReturn;
    }

}
