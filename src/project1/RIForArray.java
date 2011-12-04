package project1;

import java.util.*;

public class RIForArray<T> implements ReversibleIterator<Object> {
	private int previous, next; // indexes of previous and next elements
	private Object[] list; // the array to reversibly iterate

	// constructor takes an array of Objects
	public RIForArray(Object[] list) {
		this.list = list;
		previous = -2; // the current index is inbetween previous and next
		next = 0;
	}

	// if a "next" element exists
	//O(1)
	public boolean hasNext() {
		return next >= 0 && next < list.length;
	}

	// returns the next element in the list
	//O(1)
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		previous++;
		next++;
		return (T) list[next - 1];
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}

	// if a "previous" element exists
	//O(1)
	public boolean hasPrevious() {
		return previous >= 0 && previous < list.length;
	}

	// returns the previous element
	//O(1)
	public Object previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		previous--;
		next--;
		return list[next - 1];
	}
}