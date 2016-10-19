import java.util.Scanner;

public class Coins {
	int[] coins = {25, 10, 5, 1};
	int[] result = new int[4];
	String[] singular = {"quater", "dime","nickel","penny"};
	String[] prurals = {"quaters", "dimes","nickels","pennies"};
	private int count;
	public void ways(int money) {
		change(money, 0);
		count=0;
	}

	private  void change(int remaining,  int pos) {
		if (pos >= coins.length){
			return;
		}		
		if (remaining== 0) {	
			print(result);
			//System.out.println(Arrays.toString(result));
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
	public void print(int[] combination){
		StringBuilder res = new StringBuilder();
		res.append(String.format("\t%d) ", ++count));
		for(int i =0; i<=coins.length-1; i++){
			if(result[i] != 0){
				res.append(String.format("%d %s,", result[i],(result[i]==1 ? singular[i] : prurals[i])));
			}
		}
		res.deleteCharAt(res.length()-1);
	    System.out.println(res.toString());
	}
	public static void main(String[] args){
		Scanner src =new Scanner(System.in);
		System.out.println("Enter the Amount in cents: \n");
		int input = src.nextInt();
		Coins a = new Coins();
		System.out.print("This amount can be changed in the following ways:\n");
		a.ways(input);
		
	}
}
