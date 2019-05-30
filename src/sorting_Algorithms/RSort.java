package sorting_Algorithms;
import java.util.Arrays;

public class RSort {

	public static void selectionSort(int[] arr) {
		int i, j, smallestIndex;
		for (i = 0; i < arr.length; i++) {
			smallestIndex = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[smallestIndex] > arr[j])
					smallestIndex = j;
			}
			swap(arr, smallestIndex, i);
		}

	}

	public static void bubbleSort(int[] arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length && flag; i++) {
			flag = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
		int i, j;
		for (i = 1; i < arr.length; i++) {
			for (j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
				swap(arr, j - 1, j);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 3, 8, 4, 0, 7, 2, 3, 4, 0, 1, 6, 7, 6 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
