package linked_List;


public class Node {
	private int _data;
	private Node _next;

	public Node(int data) {
		this._data = data;
		this._next = null;
	}

	public int getData() {
		return this._data;
	}

	public void setData(int data) {
		this._data = data;
	}

	public void setNext(Node next) {
		this._next = next;
	}

	public Node getNext() {
		return this._next;
	}
}
