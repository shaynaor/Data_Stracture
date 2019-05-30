package linked_List;

public class LinkedList {
	Node _head;

	public LinkedList() {
		this._head = null;
	}

	public void add(Node n) {
		if (this._head == null)
			this._head = new Node(n.getData());
		else {
			Node runner = this._head;
			while (runner.getNext() != null)
				runner = runner.getNext();
			runner.setNext(new Node(n.getData()));
		}
	}

	public LinkedList(LinkedList list) {
		Node runner = list._head;
		while (runner != null) {
			this.add(runner);
			runner = runner.getNext();
		}
	}

	public int size() {
		Node runner = this._head;
		int counter = 0;
		while (runner != null) {
			counter++;
			runner = runner.getNext();
		}
		return counter;
	}

	public boolean isInList(int data) {
		Node runner = this._head;
		while (runner != null) {
			if (runner.getData() == data)
				return true;
			runner = runner.getNext();
		}
		return false;
	}

	public void delete(int data) {
		Node runner = this._head;
		if (runner.getData() == data)
			this._head = runner.getNext();
		while (runner.getNext() != null) {
			if (runner.getNext().getData() == data) {
				runner.setNext(runner.getNext().getNext());
				break;
			}
			runner = runner.getNext();
		}
	}
}
