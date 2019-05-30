package queue;


public class ArrayQueue {
	private String []a;
	private int front , tail , numOfItems;
	
	public ArrayQueue(int capacity) {
		a = new String [capacity];
		int front = tail = numOfItems = 0;
	}
	
	public boolean enQueue(String str) {
		if(numOfItems == a.length) return false;
		a[tail] = str;
		tail = (tail + 1) % a.length;
		numOfItems++;
		return true;
	}
	
	public String deQuque() {
		if(empty()) return null;
		String ans = a[front];
		front = (front + 1) % a.length;
		numOfItems--;
		return  ans;
	}
	
	public String front() {
		if(empty()) return null;
		return a[front];
	}
	
	public boolean empty() {
		return numOfItems == 0;
	}
	
	public void clear() {
		numOfItems = front = tail = 0;
	}

	public int size() {
		return numOfItems;
	}
	
	
	
	
	
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(2);
		System.out.println(q.enQueue("k"));
		System.out.println(q.deQuque());
		System.out.println(q.size());
		System.out.println(q.empty());
		System.out.println(q.front());
		System.out.println(q.enQueue("k"));
		System.out.println(q.size());
		System.out.println(q.empty());
		System.out.println(q.front());
		System.out.println(q.enQueue("2"));
		System.out.println(q.enQueue("k"));
		
	}

}
