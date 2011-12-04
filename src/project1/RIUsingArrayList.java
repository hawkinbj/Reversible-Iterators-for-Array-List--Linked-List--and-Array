package project1;

import java.util.*;

public class RIUsingArrayList<T> implements ReversibleIterator<T> {
	private Iterator<T> iter;
	private ArrayList<T> list; // list will hold "known" values
	private int previous, next, count; // count keeps track of #times previous()
										// is called. next and previous help
										// with bounds

	// constructor takes Iterator as parameter
	public RIUsingArrayList(Iterator<T> iter) {
		list = new ArrayList<T>();
		this.iter = iter;
		previous = -2;
		next = 0;
		count = 0;
	}

	// checks if there is a next element in the internal ArrayList, if not
	// checks iter.hasNext()
	// O(1)
	public boolean hasNext() {
		if (count < 1)
			return iter.hasNext();
		else
			return next >= 0 && next < list.size();
	}

	// if previous is called, then need to return the next item in the list -
	// not iter.next. When iter has to be called, the element is added to
	// the internal list. Returns the next element in the list.
	// O(1)
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		if (count > 0) {
			count--;
			previous++;
			next++;
			return list.get(next - 1);
		} else {
			list.add(iter.next());
			previous++;
			next++;
			return list.get(next - 1);
		}
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}

	// checks if there is a previous item in the internal ArrayList
	// O(1)
	public boolean hasPrevious() {
		return previous >= 0 && previous < list.size();
	}

	// returns the previous item from the internal ArrayList
	// O(1)
	public T previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();

		previous--;
		next--;
		count++;
		return list.get(next - 1);
	}
}
