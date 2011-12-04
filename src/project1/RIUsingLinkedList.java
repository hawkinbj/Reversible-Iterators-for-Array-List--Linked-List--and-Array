package project1;

import java.util.*;

public class RIUsingLinkedList<T> implements ReversibleIterator<T> {
	private Iterator<T> iter;
	private PublicLinkedList<T> list; // list will hold "known" values
	private int previous; // marks the bounds of internal array
	private boolean frontSwitch; // helps traversing the internal list when
									// values are known
	private PublicNode<T> current;

	// constructor takes an Iterator
	public RIUsingLinkedList(Iterator<T> iter) {
		this.iter = iter;
		previous = -2;
		list = new PublicLinkedList<T>();
		current = list.front;
		frontSwitch = false;
	}

	// checks if internal list has a next element, if not checks iter.hasNext()
	// O(1)
	public boolean hasNext() {
		if (!frontSwitch)
			return iter.hasNext();
		else
			return current != null;
	}

	// if previous has been called, then need to return the next item in the
	// internal list - not iter.next. When iter has to be called, the element is
	// added to
	// the internal list. Returns the next element in the list.
	// O(1)
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (frontSwitch && current != null) {
			current = current.getPrevious();
			T result = current.getElement();
			previous++;
			if (current == null || current == list.front) {
				frontSwitch = false;
			} else
				frontSwitch = true;
			return result;
		}
		list.add(iter.next());
		current = list.front;
		T result = current.getElement();
		previous++;
		return result;
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}

	// checks if internal list has a known previous element
	// O(1)
	public boolean hasPrevious() {
		return previous >= 0 && previous < list.getSize();
	}

	// returns previous element in internal list if it exists
	// O(1)
	public T previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		current = current.getNext();
		T result = current.getElement();
		previous--;
		frontSwitch = true;
		return result;
	}

}
