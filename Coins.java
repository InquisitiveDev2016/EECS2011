/**
* This class return all possible number and combinations of change given.
@author vishal
**/
import java.util.Scanner;
public class Coins {
	//Initializing denominations of coins
	private int[] coins = {25, 10, 5, 1};
	//Initializing of result array of fixed length which will return the result of coins count
	private int[] result = new int[4];
	//Initializing Strings of Fixed length which will help in plural and singular names of denomination
	private String[] singular = {"quater", "dime","nickel","penny"};
	private String[] plurals = {"quaters", "dimes","nickels","pennies"};
	//This int store and print the total number of ways
	private int count;
	// This is the method which returns all possible combinations of coins 
	public void ways(int money) {
		change(money, 0);
		count=0;
	}
	// This is helper method for ways actually compute the total ways of an amount can be given 
	/**
	 * This method takes amount which have to given an amount and pos is just pointer of coins array which keep track of which coin has been used
	 * and it goes from bigger to smaller coins and return result array with single combination then recursion take place using smaller coin every timee
	 * @param remaining
	 * @param pos
	 */
	private  void change(int remaining,  int pos) {
		if (pos >= coins.length){
			return;
		}		
		if (remaining== 0) {	
			print(result);
			return;
		}
		else {
			if(remaining>=coins[pos]){
				result[pos]++;
				change(remaining - coins[pos], pos);
				result[pos]--;
			}
			change(remaining, pos + 1);		
		}
	}
	 
	/**
	 *This method takes result array and format it as it was asked in assignment. It uses string builder string which is then appended to make the proper format
	 * @param combination
	 */
	private void print(int[] combination){
		StringBuilder res = new StringBuilder();
		res.append(String.format("\t%d) ", ++count));													  // Initializing count which counts the total number of ways
		for(int i =0; i<=coins.length-1; i++){															  // Its a loop which run through result array
			if(result[i] != 0){     																	  // Checks whether result have element value 0. if so it proceed to next element
				res.append(String.format("%d %s,", result[i],(result[i]==1 ? singular[i] : plurals[i]))); // It appends the String res to put result in it and also the  proper name 
																										  // of coins used singular or plurals
			}
		}
		res.deleteCharAt(res.length()-1);                                                                 // Deletes the last comma which we get after string
	    System.out.println(res.toString());
	}
	
	public static void main(String[] args){
		Scanner src =new Scanner(System.in);
		System.out.println("Enter the Amount in cents:");
		int input = src.nextInt();
		Coins a = new Coins();
		System.out.print("This amount can be changed in the following ways:\n");
		a.ways(input);	
	}
}
