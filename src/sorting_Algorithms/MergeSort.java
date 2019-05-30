package sorting_Algorithms;


import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 19, 36, 5, 0, 57, 23, 18 ,8,0,6,1,3,4,8,6,0,1};
		MergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void MergeSort(int[] a) {
		MergeSort(a, 0, a.length - 1); // call function on entire range
	}

	// this sort takes an array, and a range to sort
	private static void MergeSort(int[] a, int start, int end) {
		if (end - start > 0) { // if the range is more than 1
			int middle = (start + end) / 2; // split the range
			MergeSort(a, start, middle); // sort first half
			MergeSort(a, middle + 1, end); // sort second half
			Merge(a, start, middle, end); // merge
		}
	}

	// this merge takes an array, and a range to merge:
	// start to middle is increasing, middle+1 to end is increasing
	// merge start to middle, middle+1 to end
	private static void Merge(int[] a, int start, int middle, int end) {
		int[] b = new int[end - start + 1]; // temp array
		int i = start, j = middle + 1, k = 0;
		while (i <= middle && j <= end) { // merge parts into temp
			if (a[i] < a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}

		while (i <= middle) // copy remaining half into temp
			b[k++] = a[i++];

		while (j <= end)
			b[k++] = a[j++];

		for (k = 0; k < b.length; k++) // copy from temp back into array
			a[start + k] = b[k];
	}
}