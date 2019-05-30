package sorting_Algorithms;


public class RadixSort {

	public static void Radix_Sort(int[] A, int d) {
		
		
		int[] B = new int[A.length];
		
		for(int i=0; i<d; i++) {
			int p=0;
			for(int k=0; k<10; k++) {
				for(int j=0; j<A.length; j++) {
					int digit = at_digit(A[j], i);
					if(digit == k) {
						B[p] = A[j];
						p++;
					}
				}
			}
			for(int k=0; k<A.length; k++)
				A[k] = B[k];
		}
		
	}
	
	private static int at_digit(int number, int d) {
		int answer=number;
		for(int i=0; i<d; i++) 
			answer = answer/10;
		return answer%10;
	}
		   		
}