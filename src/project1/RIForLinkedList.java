package project1;

import java.util.*;

public class RIForLinkedList<T> implements ReversibleIterator<Object> {
	private PublicLinkedList<T> list;
	private PublicNode<T> current;
	private int previous;// get rid of next, possibly previous
	private boolean frontSwitch, backSwitch; // these help with traversing the
												// list depending on when next()
												// or previous() is called

	// constructor takes a LinkedList
	public RIForLinkedList(PublicLinkedList<T> list) {
		this.list = list;
		current = list.front;
		previous = -2;
		frontSwitch = false;
		backSwitch = false;
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}

	// checks to see if there is a next element in the list
	//O(1)
	public boolean hasNext() {
		return current != null;
	}

	// returns the next element in the list
	//O(1)
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (frontSwitch) {
			T result = current.getNext().getElement();
			current = current.getNext().getNext();
			previous++;
			previous++;
			frontSwitch = false;
			if (current != null) {
				backSwitch = true;
			}
			return result;
		}
		T result = current.getElement();
		current = current.getNext();
		previous++;
		if (current != null) {
			backSwitch = true;
		} else
			backSwitch = false;
		return result;
	}

	//checks to see if there is a previous element in the list
	//O(1)
	public boolean hasPrevious() {
		return previous >= 0;
	}

	// returns the previous element in the list
	//O(1)
	public T previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		if (current != null && backSwitch == true) {
			T result = current.getPrevious().getPrevious().getElement();
			current = current.getPrevious().getPrevious();
			previous--;
			previous--;
			backSwitch = false;
			return result;
		}
		if (current == null) {
			current = list.back;
		}
		T result = current.getPrevious().getElement();
		current = current.getPrevious();
		previous--;
		frontSwitch = true;
		return result;

	}
}
