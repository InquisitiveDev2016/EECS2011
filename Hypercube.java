/*
@author vishal
*/
import java.util.LinkedList;
import java.util.Scanner;

public class Hypercube {

	/**
	 * This method solves the hypercube problem by iterative method
	 */
	Queue q = new Queue();
	public Queue iterativeWalk(String previous, int n){
		if(n==0){
	            q.enque(0);
	            if(n == 1)
	             q.enque(1);
	            return q;
		}else{
			for(int i =0; i<=n-1; i++){
			 q.enque(previous = previous+"0");
			 q.enque(previous = previous+"1");
			}
			for(int i = 0; i<n-1; i++){
				 q.enque(previous = previous+"1");
				 q.enque(previous = previous+"0");
			}
			return null;
		}
	}
	/**
	 * This problem solve the problem by recursive approach. It uses Grey Code as inpspiration and appends 0 and 1 and it's inverse after 
	 * each iteration till the required dimension is reached.
	 * @param n
	 * @throws InvalidDimensionException 
	 */
	public static void recursiveWalk(int n) throws InvalidDimensionException{
		if(n<0){
			throw new InvalidDimensionException("Please Enter correct Dimension");
		}
		corner("",n);
	}
	//Helper method
	//append dimension n coordinate to end of previous string, and returns or say prints
	public static void corner(String previous, int n) {
		if (n == 0){
			System.out.println(previous);
		}else {
			corner(previous + "0", n - 1);
			revcorner(previous + "1", n - 1);
		}
	}  
	//helper method2
	// append reverse of dimension n coordinate to previous string, and returns or say prints
	// Since the pattern is 0110.
	public static void revcorner(String previous, int n) {
		if (n == 0){ 
			System.out.println(previous);
		}else {
			corner(previous + "1", n - 1);
			revcorner(previous + "0", n - 1);
		}
	}  
	/**
	 * This is the Queue Class which acts as a helper class to iterative method
	 * @author vishal
	 * @param <E>
	 */

	public static class Queue<E>{
		private LinkedList<E> a;
		public Queue(){
			a = new LinkedList<E>();
		}
		public void enque(E element){
			a.addLast(element);
		}
		public E deque(){
			return a.removeFirst();
		}
		
	}
	public static void main(String[] args) throws InvalidDimensionException{
		// Test Cases 
		System.out.println("Recursive Walk \n");
		System.out.println("------------------------------------------------------ \n");
		System.out.println("For 3 dimension \n");
		System.out.println("------------------------------------------------------ \n");
		recursiveWalk(3);
		System.out.println("\n");
		System.out.println("For 4 dimension \n");
		System.out.println("------------------------------------------------------ \n");
		recursiveWalk(4);
		System.out.println("\n");
		System.out.println("For 5 dimension \n");
		System.out.println("------------------------------------------------------ \n");
		recursiveWalk(5);
		System.out.println("\n");
		System.out.println("Please Enter the Dimension  \n");
		Scanner src = new Scanner(System.in);
		int dimension = src.nextInt();
		System.out.println("------------------------------------------------------ \n");
		recursiveWalk(dimension);
		System.out.println("------------------------------------------------------ \n");
		//iterativeWalk(dimension);
	}
}
