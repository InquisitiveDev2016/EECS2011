import java.util.ArrayList;
/**
 * The purpose of this class is to squeeze an array of ints.
 * 
 * The main method runs some tests.
 * 
 * @author Vishal
 * 
 */
public class ArraySqueeze {
	/**
	 * squeeze() takes an array of ints. On completion the array contains the
	 * same numbers, but wherever the array had two or more consecutive
	 * duplicate numbers, they are replaced by one copy of the number. Hence,
	 * after squeeze() is done, no two consecutive numbers in the array are the
	 * same.
	 * 
	 * Any unused elements at the end of the array are set to -1.
	 * 
	 * For example, if the input array is [ 5 , 7 , 7 , 9 , 9 ,  16 , 1 , 1 ], it
	 * reads [ 5 , 7 , 9 , 16 , 1 , -1 , -1 , -1 ] after squeeze() completes.
	 * 
	 * @param ints
	 *            the input array.
	 */
	public static void squeeze(int[] ints) {

		// Ours takes linear time and is 9 lines long,
		// not counting blank/comment lines or lines already present in this file.
        // Compressing Array of ints 
		int[] compressedInts = new int[ints.length];       // Initializing compressedInts array with length as same as ints
		compressedInts[0] = ints[0];                       // Assigning compressedInts first value to first value of ints
		int m = 1;                                         // Index Iterator for CompressedInts. It is used to add values in CompressedInts array at index of m.
		int pointer = 0;                                   // This pointer which keep track of All interested values or say useful values
		for (int i = 1; i < ints.length; ++i) {            // Iterate through ints 
			if (ints[i] != ints[i - 1]) {                  // checks for unique values in ints
				compressedInts[m] = ints[i];               // assign those values to compressedInts using m as index iterator for compressedInts
				m++;                                       // after adding values it will move m
				pointer = m-1;                             // keeping track of useful elements in compressedInts
			}
		}
		for(int j = 0; j<compressedInts.length; j++){      // Iterate through newly made compressedInts assign all values after useful values to -1
			if(j > pointer)
				compressedInts[j]=-1;

		}
		for(int z = 0; z<ints.length; z++){                // Iterate through ints and assign all compressedInts values to ints
			ints[z] = compressedInts[z];
		}
	}
	/**
	 * main() runs test cases on your squeeze() method. Prints summary
	 * information on basic operations and halts with an error (and a stack
	 * trace) if any of the tests fail.
	 */

	public static void main(String[] args) {
		String result;

		System.out.println("Let's squeeze arrays!\n");

		int[] test1 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
		System.out.println("squeezing " + TestHelper.stringInts(test1) + ":");
		squeeze(test1);
		result = TestHelper.stringInts(test1);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals(
				"[ 3 , 7 , 4 , 5 , 2 , 0 , 8 , 5 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test2 = {6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3};
		System.out.println("squeezing " + TestHelper.stringInts(test2) + ":");
		squeeze(test2);
		result = TestHelper.stringInts(test2);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals(
				"[ 6 , 3 , 6 , 3 , 6 , 3 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test3 = {4, 4, 4, 4, 4};
		System.out.println("squeezing " + TestHelper.stringInts(test3) + ":");
		squeeze(test3);
		result = TestHelper.stringInts(test3);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 4 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test4 = {0, 1, 2, 3, 4, 5, 6};
		System.out.println("squeezing " + TestHelper.stringInts(test4) + ":");
		squeeze(test4);
		result = TestHelper.stringInts(test4);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 0 , 1 , 2 , 3 , 4 , 5 , 6 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test5 = {6, 7, 1, 5, 5, 5, 7, 8, 9, 9, 9, 2, 3, 3, 9, 9};
		System.out.println("squeezing " + TestHelper.stringInts(test5) + ":");
		squeeze(test5);
		result = TestHelper.stringInts(test5);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 6 , 7 , 1 , 5 , 7 , 8 , 9 , 2 , 3 , 9 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test6 = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 5};
		System.out.println("squeezing " + TestHelper.stringInts(test6) + ":");
		squeeze(test6);
		result = TestHelper.stringInts(test6);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 9 , 8 , 7 , 6 , 5 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test7 = {9, 9, 9, 8, 8, 8, 1, 1, 1, 6, 6, 6, 5, 5, 5};
		System.out.println("squeezing " + TestHelper.stringInts(test7) + ":");
		squeeze(test7);
		result = TestHelper.stringInts(test7);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 9 , 8 , 1 , 6 , 5 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");
		
		int[] test8 = {-1, -1, -1, 8, 8, 8, 1, 1, 1, 6, 6, 6, 5, 5, 5};
		System.out.println("squeezing " + TestHelper.stringInts(test8) + ":");
		squeeze(test8);
		result = TestHelper.stringInts(test8);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ -1 , 8 , 1 , 6 , 5 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");
		
	}
}