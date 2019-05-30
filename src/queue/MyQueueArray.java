package queue;
import java.util.Arrays;

public class MyQueueArray {
	private String[] queueArray;
	private int queueSize;
	private int front, rear, numOfItems;

	public MyQueueArray(int size) {
		int front = 0, rear = 0, numOfItems = 0;
		this.queueSize = size;
		this.queueArray = new String[size];
	}

	public boolean enQueue(String input) {
		if (numOfItems + 1 <= queueSize) {
			queueArray[rear] = input;
			rear = (rear + 1) % this.queueSize;
			numOfItems++;
			System.out.println(input + " was added to the queue");
			return true;
		} else {
			System.out.println("sorry but the queue is full");
			return false;
		}
	}

	public boolean deQueue() {
		if (numOfItems > 0) {
			System.out.println(queueArray[front] + " was removed from the queue!");
			front = (front + 1) % this.queueSize;
			numOfItems--;
			return true;
		}
		System.out.println("sorry but the queue is empty!");
		return false;
	}

	public void peek() {
		System.out.println("the first element is: " + queueArray[front]);
	}
	
	public boolean contains(String element) {
		int i = front % queueSize;
		while (i != rear % queueSize) {
			if(element == queueArray[i])
				return true;
			i = (i + 1) % this.queueSize;
		}
		return false;
	}
	
	public String elementAt(int index) {
		if(index < 0 || index > numOfItems || index < front ||index > rear) 
			return "the index is not in in the queue";
		return queueArray[index];
		
	}

	public String toString() {
		String ans = "the queue: [";
		int i = front % queueSize;
		while (i != rear % queueSize - 1) {
			ans = ans + queueArray[i] + ", ";
			i = (i + 1) % this.queueSize;
		}
		ans = ans + queueArray[(rear - 1) % queueSize] + "]";
		return ans;
	}

	public static void main(String[] args) {

		MyQueueArray tor = new MyQueueArray(10);
		tor.enQueue("10");
		System.out.println(tor);
		tor.enQueue("15");
		tor.enQueue("13");
		tor.deQueue();
		System.out.println(tor);
		tor.enQueue("13");
		tor.enQueue("10");
		tor.enQueue("15");
		tor.enQueue("13");
		tor.enQueue("10");
		tor.enQueue("15");
		tor.enQueue("13");
		tor.enQueue("10");
		tor.enQueue("15");
		tor.enQueue("13");
		System.out.println(tor);
		tor.peek();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		tor.deQueue();
		System.out.println(tor.deQueue());
		System.out.println(tor.contains("0"));
		tor.enQueue("13");
		System.out.println(tor.contains("0"));
		System.out.println(tor.contains("13"));
		System.out.println(tor.elementAt(2));
		System.out.println(tor.elementAt(1));
	}
}
