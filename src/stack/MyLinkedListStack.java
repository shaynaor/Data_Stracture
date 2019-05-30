package stack;

public class MyLinkedListStack {
	MyLinkedList ll;

	public MyLinkedListStack() {
		ll = new MyLinkedList();
	}

	public void Push(int data) {
		ll.AddFirst(data);
		System.out.println(data + " has been pushed!");
	}

	public int Pop() {
		if (ll.length != 0)
			System.out.println(ll.head.getData() + " has been popped!");
		else
			System.out.println("Stack is empty!");
		return ll.RemoveFirst();
	}

	public int Top() {
		if (ll.length != 0)
			return ll.head.getData();
		System.out.println("Stack is empty!");
		return Integer.MAX_VALUE;
	}

	public boolean IsEmpty() {
		return ll.IsEmpty();
	}

	public String toString() {
		return ll.toString();
	}
}
