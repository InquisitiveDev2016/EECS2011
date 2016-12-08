import java.util.Arrays;
import java.util.Scanner;

public class Kthsmallest {
	

	public int kthKthsmallest(int[] A1, int[] A2, int k, int index1, int index2, int size1, int size2) {
	    // System.out.println("this is an O(log k) speed algorithm with meaningful variables name");

	    // the base case of (index1 + index2 == k - 1)
	    if (index1 + index2 == k - 1) {
	        if (size1 > index1 && (size2 <= index2 || Integer.compare(A1[index1], A2[index2]) < 0)) {
	            return A1[index1];
	        } else {
	            return A2[index2];
	        }
	    }

	    int step = (k - index1 - index2) / 2;
	    int step1 = index1 + step;
	    int step2 = index2 + step;
	    if (size1 > step1 - 1 && (size2 <= step2 - 1 || Integer.compare(A1[step1 - 1], A2[step2 - 1]) < 0)) {
	        index1 = step1;
	    } else {
	        index2 = step2;
	    }
	    return kthKthsmallest(A1, A2, k, index1, index2, size1, size2);
	}
	
	public static void main(String[] args) {
		
		Kthsmallest f = new Kthsmallest();
		Scanner src= new Scanner(System.in);
		System.out.println("Enter the number of element you want to add to Array A:- ");
		int n = src.nextInt();
		int[] A = new int[n];
		
		int i=0;
		while(i<n){
			int temp = src.nextInt();
			A[i] = temp;
			i++;
		}	
		
		System.out.println("Enter the number of element you want to add to Array B:- ");
		int m = src.nextInt();
		int[] B = new int[m];
		int j = 0;
		while(j<m){
			int temp = src.nextInt();
			B[j] = temp;
			j++;
		}
		System.out.println("Your Array A:- "+Arrays.toString(A));
		System.out.println("===========================");
		System.out.println("Your Array B:- "+Arrays.toString(B));
		System.out.println("===========================");
		System.out.println("Enter the value of K:- ");
		int k = src.nextInt();
		int answer = f.kthKthsmallest(A, B, k, 0, 0, A.length, B.length);
		System.out.println("The K-th smallest element is: " + answer);
	}

}
