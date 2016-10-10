import java.util.ArrayList;
import java.util.Arrays;
/**
 * The purpose of this class is to find the longest plateau of an array of ints.
 * 
 * The main method runs some tests.
 * @author vishal
 *
 */
public class ArrayLongestPlateau {

	/**
	 * longestPlateau() returns the longest plateau of an array of ints.
	 * 
	 * @return an array int[3] of the form {value, start, len} representing the
	 *         longest plateau of ints[] as a length len contiguous subarray
	 *         starting at index start with common element values value.
	 * 
	 *         For example, on the input array [2, 3, 3, 3, 3, 6, 6, 1, 1, 1],
	 *         it returns [6, 5, 2], indicating the longest plateau of this
	 *         array is the subarray [6, 6]; it starts at index 5 and has length
	 *         2.
	 * 
	 * @param ints
	 *            the input array.
	 */

	public static int[] longestPlateau(int[] ints) {

		/*
		 *  My solution for ArrayLongestPlateau takes ints array and make a new k array which have all unique
         *  values inside. While putting unique values in k its also keeping track of length of those unique
         *  elements. It add those length to an ArrayList named length. It also keep track of index of those unique
         *  elements in ints and those index to an ArrayList called index. After this, a for loop iterate through k n
         *  look for plateaus if its find any then it put the index that plateau into an ArrayList called plateau. After
         *  all of this it a for loop iterate through plateau and get the corresponding length from length array and
         *  then compare the length whichever plateaus length is greatest it take that plateau as longest plateau.
         *  It takes corresponding index number of that plateau from index array. At last it assigns these value to
         *  fields called start, length, value
		 *
		 */

		int start =0;
		int value =0;
		int repitation=0;
		//Special case when the length of ints is one.
		if(ints.length == 1){
			start = 0;
			value = ints[0];
			repitation = 1;
		}


		ArrayList<Integer> length = new ArrayList<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<Integer> platue = new ArrayList<Integer>();
		//Initialize the length array
		length.add(1);
		int[] k = new int[ints.length];
		k[0] = ints[0];
		int m = 1;
		index.add(0);

		// Compressing the Ints Array
		for (int i = 1; i < ints.length; ++i) {
			if (ints[i] != ints[i - 1]) {
				k[m] = ints[i];
				m++;
				index.add(i);
				//Initialize the length for 1, because we have a new element. so count the new beginning.
				length.add(1);
			}else if(ints[i]== ints[i - 1]) {
				// Increase the length if it's equal to the previous
				length.add(m-1, length.get(m-1)+1);
				length.remove(m);
			}
		}
		// Gets all possible platues from compressed array
		for (int z = 0; z < k.length - 1; z++) {
			if (z == 0) {
				if (k[z] > k[z + 1]) {
					platue.add(z);
				}
			} else if (z == k.length - 1) {
				if (k[z] > k[z - 1]) {
					platue.add(z);

				}
			} else if (k[z] > k[z + 1] && k[z] > k[z - 1]) {
				platue.add(z);
			}
		}
		
		
		// very special case : when the platue array have only one possible platue in it then we can just do it like this
		if(platue.size() == 1){
			repitation = length.get(platue.get(0));
			start = index.get(platue.get(0));
			value = k[platue.get(0)];
		}
		
		
		
		// Detecting longest platuaes and assigned values
		for(int d = 1; d<platue.size(); d++){
			
			if(length.get(platue.get(d)) > length.get(platue.get(d-1))){
				repitation = length.get(platue.get(d));
				start = index.get(platue.get(d));
				value = k[platue.get(d)];
			}else if(length.get(platue.get(d-1)) > length.get(platue.get(d))){
				repitation = length.get(platue.get(d-1));
				start = index.get(platue.get(d-1));
				value = k[platue.get(d-1)];
			}
		}

		// Arrays checks whether they have desired values or not
		//System.out.println(Arrays.toString(k)+"\n");
		//System.out.println("The platues in the array "+platue);
		//System.out.println("The length of every Element in ints "+length);
		//System.out.println("The indexes of each number in ints "+index);
		int[] result = { value, start, repitation };
		return result;
	}

	/**
	 * main() runs test cases on your longestPlateau() method. Prints summary
	 * information on basic operations and halts with an error (and a stack
	 * trace) if any of the tests fail.
	 */

	public static void main(String[] args) {
		String result;

		System.out.println("Let's find longest plateaus of arrays!\n");
       
		int[] test1 = { 4, 1, 1, 6, 6, 6, 6, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test1) + ":");
		result = TestHelper.stringInts(longestPlateau(test1));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 3 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test2 = { 3, 3, 1, 2, 4, 2, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test2) + ":");
		result = TestHelper.stringInts(longestPlateau(test2));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 3 , 0 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test3 = { 3, 3, 1, 2, 4, 0, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test3) + ":");
		result = TestHelper.stringInts(longestPlateau(test3));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 6 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test4 = { 3, 3, 3, 4, 1, 2, 4, 4, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test4) + ":");
		result = TestHelper.stringInts(longestPlateau(test4));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test5 = { 7, 7, 7, 7, 9, 8, 2, 5, 5, 5, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test5) + ":");
		result = TestHelper.stringInts(longestPlateau(test5));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 7 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test6 = { 4 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test6) + ":");
		result = TestHelper.stringInts(longestPlateau(test6));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 0 , 1 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");
		

		int[] test7 = { 4, 4, 4, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test7) + ":");
		result = TestHelper.stringInts(longestPlateau(test7));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		int[] test8 = { 0, 0, 0, 0, 0, 0, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test8) + ":");
		result = TestHelper.stringInts(longestPlateau(test8));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 7 , 1 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test9 = { -1, -2, -5, -4, -4, -4, -6, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test9) + ":");
		result = TestHelper.stringInts(longestPlateau(test9));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ -4 , 3 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");
		
		int[] test10 = { -1, 0, 0, 0, 0, 0, -6, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test10) + ":");
		result = TestHelper.stringInts(longestPlateau(test10));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 0 , 1 , 5 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");
		
		int[] test11 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test11) + ":");
		result = TestHelper.stringInts(longestPlateau(test11));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 0 , 8 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");
		// Insert your additional test cases here.
	}
}
