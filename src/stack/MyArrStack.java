package stack;

public class MyArrStack {

	int[] arr;
	int top;
	int maxSize;

	public MyArrStack(int max) {
		this.maxSize = max;
		arr = new int[maxSize];
		top = -1;
	}

	public boolean push(int data) {
		if (top != maxSize - 1) {
			System.out.println(data + " has been pushed!");
			arr[++top] = data;
			return true;
		}
		System.out.println("the stack is full!!");
		return false;
	}

	public int pop() {
		if (!IsEmpty()) {
			int temp = arr[top--];
			System.out.println(temp + " has been poped!");
			return temp;
		}
		System.out.println("the stack is empty!!");
		return Integer.MAX_VALUE;
	}

	public boolean IsEmpty() {
		return (top == -1);
	}

	public int top() {
		if (top != -1)
			return arr[top];
		System.out.println("the stack is empty!");
		return Integer.MAX_VALUE;
	}

	public String toString() {
		if (IsEmpty())
			return "the stack is empty!!";
		String str = "[";
		for (int i = 0; i < top; i++) 
			str = str + arr[i] + ", ";
		str = str + arr[top] + "]";
		return str;
	}
}