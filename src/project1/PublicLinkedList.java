package project1;

public class PublicLinkedList<T> {
	// the front and the back of the list
	public PublicNode<T> front, back, current;

	// construct an empty linked list
	PublicLinkedList() {
		current = front = back = null;
	}

	// returns the number of elements in the list
	// O(1)
	public int getSize() {
		int count = 0;
		current = front;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// adds an element to the front of the list
	// O(1)
	public boolean add(T element) {
		PublicNode<T> newNode = new PublicNode<T>(element);
		newNode.setNext(front);
		if (getSize() == 0) {
			front = back = newNode;
			return true;
		}
		front = newNode;
		front.getNext().setPrevious(front);
		return true;
	}

	// adds an element to the back of the list
	// O(1)
	public boolean addToEnd(T element) {
		PublicNode<T> newnode = new PublicNode<T>(element);
		if (getSize() == 0) {
			front = back = newnode;
			return true;
		}
		PublicNode<T> current = front;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newnode);
		newnode.setPrevious(current);
		newnode.setNext(null);
		back = newnode;
		return true;
	}

}
