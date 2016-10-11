/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2016
 * Assignment 2, Problem 3: AugmentedStack.java
 * Student Name: Vishal Malik	
 * Student cse account: vishal27
 * Student ID number: 214537146
 **********************************************************/
/**
 * This is an edited stack which return minimum element of stack in O(1) time.
 * @author Vishal
 */
import java.util.Stack;
public class AugmentedStack{


	private Stack<Double> stack;
	private Stack<Double> minStack; 
	public AugmentedStack(){
		this.stack= new Stack<Double>();
		this.minStack= new Stack<Double>();
	}
	/**
	 * This is an method which adds elements into stack and minStack. it initially adds the first value of element as it is then checks for 
	 * other values if the values are smaller then the minStack.peek() element,if it is then it will add that element into minStack. So that
	 *  minStack only have useful element instead of multiple copies of same element over an over again.
	 * @param element
	 */
	public void push(double element){	
		stack.push(element);
		if (minStack.empty() || element <= minStack.peek()){
			minStack.push(element);
		}
	}

	/**
	 * This method remove the recent  element added into stack. This is a special method since it also remove elements to MinStack as well.
	 * to add initially it checks whether the stack.peek() is same to the minStack or not, if its similar then it pops the minStack element
	 *   
	 * @return stack.pop(); + minStack.pop();
	 */
	public Double pop(){
		if(stack.isEmpty()){
			return null;
		}
		double value = stack.peek();
		if(value == minStack.peek()){
			minStack.pop();
		}
		return stack.pop();
	}
	/**
	 * This is the method which return top element of stack
	 * @return stack.peek();
	 */
	public Double top(){
		return this.stack.peek();
	}
	/**
	 * This is a method which return the minimum value of stack by popping value from minStack.
	 * @return
	 */
	public Double getMin(){
		if(minStack.isEmpty()){
			return null;
		}else{
			return this.minStack.pop();
		}
	}
	@Override
	public String toString() {
		return "Augmented Stack = "+ stack+"\n"+/*"MinStack = "+minStack+*/"\n" +"Minimum = " + getMin();
	}
	/**
	 * This is main method which runs some test on Augmented Stack.
	 * @param args
	 */
	public static void main(String[] args) {

		//Test Cases

		AugmentedStack a  = new AugmentedStack();
		a.push(90);
		a.push(9);
		a.push(100);
		a.push(3);
		a.push(28);
		a.push(18283);
		a.push(-81);
		a.push(89);
		a.push(-11);  

		a.pop();
		a.pop();
		a.pop();

		System.out.println(a);


	}
}
