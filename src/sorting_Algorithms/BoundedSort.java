package sorting_Algorithms;



public class BoundedSort {
	
	// This function sorts an array whose values are all in
	// the range 0 - (k-1)
	// Ex: A = {1,2,0,2,0,1,1}, k=3
	// A = {0,0,1,1,1,2,2}
	public static void Bounded_Sort(int[] A, int k) {
		int[] count_array = count(A,k);
		int[] B = new int[A.length];
		int p=0;
		for(int i=0; i<count_array.length; i++) {
			for(int j=0; j<count_array[i]; j++) {
				B[p] = i;
				p++;
			}
		}
		for(int i=0; i<A.length; i++)
			A[i] = B[i];
	}
	
	// This function takes an array with values in the range 0 - (k-1)
	// and returns an array of counters
	// Ex: A = {1,2,0,2,0,1,1}, k=3
	// answer = {2,3,2}, since 0 appears 2x in A, 1 appears 3x in A 
	// and 2 appears 2x in A. 
	private static int[] count(int[] A, int k) {
		int[] answer = new int[k];
		for(int i=0; i<A.length; i++)
			answer[A[i]]++;
		return answer;
	}
		   		
}