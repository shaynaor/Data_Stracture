package sorting_Algorithms;


import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 19, 36, 5, 0, 57, 23, 18 };
		QuickSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void QuickSort(int[] a) {
		QuickSort(a, 0, a.length - 1); // call function on entire range
	}

	private static void QuickSort(int[] a, int start, int end) {
		if (end - start > 0) { // if the range is more than 1
			int pivot = partition(a, start, end); // divide around pivot
			QuickSort(a, start, pivot - 1); // sort first half
			QuickSort(a, pivot + 1, end); // sort second half
		}
	}

	// Choose a pivot, put smaller numbers on the left,
	// larger numbers on the right.
	// O(n) time
	private static int partition(int[] a, int start, int end) {

		// adding in the next two lines makes the pivot random

		int r = start + (int) (Math.random() * (end - start + 1));
		swap(a, start, r);

		int pivot = start;
		int L = pivot + 1;
		int H = end;

		while (H >= L) {
			if (a[L] <= a[pivot])
				L++; // number on left is small
			else if (a[H] > a[pivot])
				H--; // number on right is large
			else
				swap(a, L, H); // left is big, right is small, so swap
		}

		swap(a, pivot, H); // put pivot in right place
		return H; // return location of pivot
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}