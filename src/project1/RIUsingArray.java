package project1;

import java.util.*;

public class RIUsingArray<T> implements ReversibleIterator<T> {
	private Iterator<T> iter;
	private T[] list; // list will hold "known" values
	private int previous;
	private int next;
	private int size; // size of the array
	private int count; // keeps track of #times previous() is called

	// constructor takes Iterator as parameter
	public RIUsingArray(Iterator<T> iter) {
		list = (T[]) new Object[1];
		this.iter = iter;
		previous = -2;
		next = 0;
		count = 0;
		size = 0;
	}

	// adds an element to the internal list if it's not already there
	// might need to make it so that can add same element
	//O(n)
	private boolean add(T element) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				if (element.equals(list[i]))
					return false;
			}
		}
		if (size == list.length)
			resize();
		list[size] = element;
		size++;
		return true;
	}

	// resizes the internal array if needed
	// O(n)
	private void resize() {
		// newlist has twice the length
		T[] newlist = (T[]) new Object[2 * list.length];
		// copy the elements over
		for (int i = 0; i < size; i++) {
			newlist[i] = list[i];
		}
		list = newlist;
	}

	// checks if there is a next element in the internal array, if not checks
	// iter.hasNext()
	//O(1)
	public boolean hasNext() {
		if (count < 1)
			return iter.hasNext();
		else
			return next >= 0 && next < list.length;
	}

	// if previous has been called, then need to return the next item in the
	// internal array - not iter.next. When iter has to be called, the element
	// is
	// added to the internal array. Returns the next element in the array.
	//O(1)
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		if (count > 0) {
			count--;
			previous++;
			next++;
			return list[next - 1];
		} else {
			this.add(iter.next());
			previous++;
			next++;
			return list[next - 1];
		}
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}

	// checks to see if there is a previous item in the internal list
	//O(1)
	public boolean hasPrevious() {
		return previous >= 0 && previous < list.length;
	}

	// returns the previous element from the internal list
	//O(1)
	public T previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();

		previous--;
		next--;
		count++;
		return list[next - 1];
	}

}
