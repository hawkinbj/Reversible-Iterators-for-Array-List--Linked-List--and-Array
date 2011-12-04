package project1;

import java.util.*;

public class RIForArrayList<T> implements ReversibleIterator<Object> {
	private int previous, next; // indexes of previous and next elements
	private ArrayList<T> list; // the ArrayList to reversibly iterate

	public RIForArrayList(ArrayList<T> list) {
		this.list = list;
		previous = -2; // the current index is in between previous and next
		next = 0;
	}

	// checks to see if next (previous) are legal indexes
	//O(1)
	public boolean hasNext() {
		return next >= 0 && next < list.size();
	}

	public boolean hasPrevious() {
		return previous >= 0 && previous < list.size();
	}

	// returns the next element in the list
	//O(1)
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		previous++;
		next++;
		return list.get(next - 1);
	}

	// returns the previous element in the list
	//O(1)
	public T previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		previous--;
		next--;
		return list.get(next - 1);
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}
}