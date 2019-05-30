package heap;
import java.util.Arrays;

public class MaxHeap {
	int[] arr;
	int last;
	int size;

	public MaxHeap(int size) {
		this.arr = new int[size];
		this.size = size;
		last = -1;
	}

	public void Add(int data) {
		if (last + 1 == size) {
			System.out.println("The heap is full!!");
			return;
		}
		arr[++last] = data;
		HeapifyUp(last);
	}

	private void HeapifyUp(int position) {
		boolean flag = true;
		while (flag) {
			int parent = (int) ((position - 1) / 2);
			if (arr[position] > arr[parent]) {// violation
				swap(arr, position, parent);// swap
				position = parent; // go up
			} else
				flag = false;
		}
	}

	private void swap(int[] arr, int position, int parent) {
		int temp = arr[position];
		arr[position] = arr[parent];
		arr[parent] = temp;
	}

	public int Delete() {
		int max = arr[0];
		if (last == -1) {
			System.out.println("The heap is empty!!");
			return Integer.MAX_VALUE ;
		}
		swap(arr, 0, last);
		last--;
		HeapifyDown(0);
		return max;
	}

	private void HeapifyDown(int i) {
		int pos = i;
		boolean flag = true;
		while (flag) {
			int left = 2 * pos + 1;
			int right = 2 * pos + 2;
			if ((left < last) && (right <= last)) {// in case we have two childs..
				if (arr[left] > arr[right]) {// we got the max between two cilds..
					if (arr[left] >= arr[pos]) {
						swap(arr, pos, left);
						pos = left;
					} else
						flag = false;
				} else {
					if (arr[right] >= arr[pos]) {
						swap(arr, pos, right);
						pos = right;
					} else
						flag = false;
				}
			} else if ((left <= last)) {// otherwise, in case one child, it has
				// to be left...

				if (arr[left] >= arr[pos]) {
					swap(arr, pos, left);
					pos = left;
				} else
					flag = false;
			} else {
				flag = false;
			}
		}
	}
	

	public static void main(String[] args) {
		int size = 100;
		MaxHeap h = new MaxHeap(size);
		for (int i = 0; i < size; i++) {
			if (Math.random() > 0.5)
				h.Add(-1 * ((int) (Math.random() * 2)));
			else
				h.Add(((int) (Math.random() * 2)));
		}
//		for (int i = 0; i < size - 1; i++) {
//			System.out.print(h.Delete() + ", ");
//
//		}
//		System.out.println(h.Delete());
		int [] arr = new int [size];
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = h.Delete();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(h.arr));
	}
}
