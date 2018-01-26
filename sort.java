
import java.util.*;
// Sorting of List without accessing Index.
// Solution is Essentially Quick Sort by constructing a InputStream.
public class sort {
	@SuppressWarnings("resource")
	public static String sorting(String list) {
		Integer middle = 0;
		Integer number = 0;
		// Create three strings
		String left = "";
		String right = "";
		String o = "";
		// Get the first element and assign to number middle
		Scanner scan = new Scanner(list);

		if (scan.hasNextInt()) {
			middle = scan.nextInt();
			// Get all the rest elements and assign to number
			while (scan.hasNextInt()) {
				number = scan.nextInt();  			// here it assign the next element in the string to number 
				if (number > middle) {     			// comprasion of first and second element of List
					right += number.toString() + " ";	// Assign the element here if its greater then the pivot
				} else {
					left += number.toString() + " "; 	// Assign the element here if its less then the pivot 
				}
			}
			// Combine the sorted lists together
			o = sorting(left) + middle + " " + sorting(right);	// recursivly call both list till they get sorted
			return o;
		}
		scan.close();
		return "";
	}

	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		String inputString = src.nextLine();
		System.out.println(sorting(inputString));
		src.close();
	}
}
