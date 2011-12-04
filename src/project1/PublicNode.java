package project1;

public class PublicNode<T> {
	// All methods O(1)

	// the element the node will hold
	public T element;

	// tracks the previous and next nodes
	public PublicNode<T> previous, next;

	public PublicNode(T element) {
		this.element = element;
		previous = next = null;
	}

	// returns the next node in the list
	public PublicNode<T> getNext() {
		return next;
	}

	// returns the previous node in the list
	public PublicNode<T> getPrevious() {
		return previous;
	}

	// sets the node to be next in the list
	public void setNext(PublicNode<T> node) {
		next = node;
	}

	// sets the node to be previous in the list
	public void setPrevious(PublicNode<T> node) {
		previous = node;
	}

	// returns the element contained at this node
	public T getElement() {
		return element;
	}

	// sets the element at(in) this node
	public void setElement(T element) {
		this.element = element;
	}
}