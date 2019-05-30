package skip_List;

public class MySkipList {

	private SLNode head;

	public MySkipList() {
		head = new SLNode(Integer.MIN_VALUE);
	}

	public boolean contains(int x) {
		SLNode current = head;

		while (current != null) {
			if (current.getData() == x)
				return true;

			else if (current.getNext() == null || current.getNext().getData() > x)
				current = current.getDown();

			else
				current = current.getNext();
		}
		return false;
	}

	public SLNode find(int x) {
		SLNode current = head;

		while (current != null) {
			if (current.getData() == x) {
				if (current.getDown() == null)
					return current;
				else
					current = current.getDown();
			}

			else if (current.getNext() == null || current.getNext().getData() > x) {
				if (current.getDown() == null)
					return current;
				current = current.getDown();
			}

			else
				current = current.getNext();
		}
		return null;
	}

	public void add(int x) {
		SLNode newNode = new SLNode(x);
		SLNode current = find(x);

		newNode.setNext(current.getNext());
		current.setNext(newNode);

		newNode.setPrevious(current);
		if (newNode.getNext() != null)
			newNode.getNext().setPrevious(newNode);

		fix(newNode);
	}

	private void fix(SLNode n) {
		SLNode prev = prevUp(n);
		int number = count(prev);

		if (number == 3) {
			SLNode promote = prev.getNext().getNext();

			SLNode newNode = new SLNode(promote.getData());
			prev = prev.getUp();

			newNode.setNext(prev.getNext());
			newNode.setPrevious(prev);

			n.setUp(newNode);
			newNode.setDown(n);

			prev.setNext(newNode);
			if (newNode.getNext() != null)
				newNode.getNext().setPrevious(prev);

			fix(newNode);
		}
	}

	private int count(SLNode n) {
		if (n.getUp() == null)
			return -1;
		SLNode current = n.getNext();
		int count = 0;
		while (current != null && current.getUp() == null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	private SLNode prevUp(SLNode n) {
		if (n.getUp() != null)
			return n;
		else
			return prevUp(n.getPrevious());
	}
}