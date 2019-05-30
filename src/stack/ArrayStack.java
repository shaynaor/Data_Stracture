package stack;


public class ArrayStack {
	private String [] arr;
	private int top;
	
	public ArrayStack(int capacity) {
		arr = new String [capacity];
		top = - 1;
	}
	
	public boolean push(String str) {
		if(top + 1 == arr.length) return false;
		arr[++top] = str;
		return true;
	}
	
	public String pop() {
		if(empty()) return null;
		return arr[top--];
	}
	
	public String top() {
		if(empty()) return null;
		return arr[top];
	}
	
	public boolean empty() {
		if(top == -1) return true;
		return false;
	}
	
	public void clear() {
		top = -1;
	}
	
	public boolean contain(String str) {
		if(empty()) return false;
		boolean flag = false;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == str)
				flag = true;
		}
		return flag;
	}
	public String toString() {
		String ans = "[";
		for (int i = 0; i < arr.length-1; i++) {
			ans = ans + arr[i] + ", ";
		}
		if(top>0) ans = ans + arr[top];
		return ans + "]"; 
	}
	
	
	
	
	public static void main(String[] args) {
		ArrayStack a = new ArrayStack(1);
		System.out.println(a.push("a"));
		System.out.println(a.push("b"));
		System.out.println(a.top());
		a.clear();
		System.out.println(a.push("a"));
		System.out.println(a.push("a"));
		System.out.println(a.empty());
		a.clear();
		System.out.println(a.empty());
		System.out.println(a.pop());
	}

}
