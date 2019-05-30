package heap;

import java.util.Arrays;

public class TernaryHeap {
	private int[] arr;
	private int last;
	private int capacity;

	public TernaryHeap(int capacity) {
		if (capacity < 0)
			capacity = 0;
		this.arr = new int[capacity];
		this.capacity = capacity;
		this.last = -1;
	}

	private int right(int i) {
		return (3 * i) + 3;
	}

	private int left(int i) {
		return (3 * i) + 1;
	}

	private int mid(int i) {
		return (3 * i) + 2;
	}

	private int parent(int i) {
		return (i - 1) / 3;
	}

	public boolean insert(int k) {
		if (last + 1 == capacity)
			return false;
		arr[++last] = k;
		HeapifyUp(last);
		return true;
	}

	public int remove_max() {
		if (last == -1)
			return Integer.MAX_VALUE;
		int max = arr[0];
		swap(arr, 0, last);
		last--;
		HeapifyDown(0);
		return max;
	}

	private void HeapifyUp(int position) {////re-orginaized the heap after insert an element.
		boolean flag = true;
		while (flag) {
			int parent = parent(position);
			if (arr[position] > arr[parent]) {
				swap(arr, position, parent);
				position = parent;
			} else
				flag = false;
		}

	}

	private void swap(int[] arr, int position, int parent) {
		int temp = arr[position];
		arr[position] = arr[parent];
		arr[parent] = temp;
	}

	private void HeapifyDown(int position) {//re-orginaized the heap after remove.
		boolean flag = true;
		while (flag) {
			int right = right(position);
			int left = left(position);
			int mid = mid(position);
			if ((left < last) && (mid < last) && (right <= last)) {// in case we have 3 childs.
				if ((arr[right] >= arr[mid]) && (arr[right] >= arr[left])) {// right child is bigger
					if (arr[right] > arr[position]) {
						swap(arr, position, right);
						position = right;
					} else
						flag = false;
				} else if ((arr[left] >= arr[mid]) && (arr[left] >= arr[right])) {// left child is bigger
					if (arr[left] > arr[position]) {
						swap(arr, position, left);
						position = left;
					} else
						flag = false;
				} else {// mid child is bigger
					if (arr[mid] > arr[position]) {
						swap(arr, position, mid);
						position = mid;
					} else
						flag = false;
				}
			} else if ((left < last) && (mid <= last) && (right > last)) {// in case we have 2 childs.
				if (arr[left] >= arr[mid]) {// left child is bigger
					if (arr[left] > arr[position]) {
						swap(arr, position, left);
						position = left;
					} else
						flag = false;
				} else {// mid child is bigger.
					if (arr[mid] > arr[position]) {
						swap(arr, position, mid);
						position = mid;
					} else
						flag = false;
				}
			} else if ((left <= last) && (mid > last) && (right > last)) {// one child case-left child.
				if (arr[left] > arr[position]) {
					swap(arr, position, left);
					position = left;
				} else
					flag = false;
			} else// no child.
				flag = false;
		}
	}

	public static void main(String[] args) {
		int size = 100;
		TernaryHeap h = new TernaryHeap(size);
		for (int i = 0; i < size; i++) {
			if (Math.random() > 0.5)
				h.insert(-1 * ((int) (Math.random() * 2)));
			else
				h.insert(((int) (Math.random() * 2)));
		}
		System.out.println("the unsorted arr:");
		System.out.println(Arrays.toString(h.arr));
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = h.remove_max();
		System.out.println("the arr sorted:");
		System.out.println(Arrays.toString(arr));
		 TernaryHeap h1 = new TernaryHeap(2);
		 System.out.println(h.capacity);
		 System.out.println(h.last);
		 System.out.println(h.insert(6));
		 System.out.println(h.remove_max());
		 System.out.println(h.insert(6));
		 System.out.println(h.insert(6));
		 System.out.println(h.remove_max());
		 System.out.println(h.remove_max());
		 System.out.println(h.remove_max());
	}
}