package stack;

public class MyLinkedList {
	Node head;
	int length;

	public MyLinkedList() {
		head = null;
		length = 0;
	}

	public void AddFirst(int data) {
		if (head == null) {
			head = new Node(data);
			length++;
		} else {
			Node tmp = new Node(data);
			tmp.setNext(head);
			head = tmp;
			length++;
		}
	}

	public int RemoveFirst() {
		if (length == 0)
			return Integer.MAX_VALUE;
		int tmp = head.getData();
		head = head.getNext();
		return tmp;
	}

	public boolean IsEmpty() {
		return (length == 0);
	}

	public String toString() {
		if (IsEmpty())
			return "the stack is empty!";
		String st = "[ ";
		Node runner = head;
		while (runner.getNext() != null) {
			st = st + runner.getData() + ", ";
			runner = runner.getNext();
		}
		st = st + runner.getData() + " ]";
		return st;
	}
}
