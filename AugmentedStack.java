/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2016
 * Assignment 2, Problem 3: AugmentedStack.java
 * Student Name: Vishal Malik	
 * Student cse account: vishal27
 * Student ID number: 214537146
 **********************************************************/

import java.util.Stack;
public class AugmentedStack{

	private Stack<Double> stack;
	private Stack<Double> minStack; 
	public AugmentedStack(){
		this.stack= new Stack<Double>();
		this.minStack= new Stack<Double>();
	}
	
	public void push(double element){	
		stack.push(element);
		if (minStack.empty() || element <= minStack.peek()){
		      minStack.push(element);
		  }
	}
	
	public Double pop(){
	    double value = stack.peek();
		if(value == minStack.peek()){
			minStack.pop();
		}
		return stack.pop();
	}
	
	public Double top(){
		return this.stack.peek();
	}
	
	public Double getMin(){
		if(minStack.isEmpty()){
			return null;
		}else{
			return this.minStack.pop();
		}
	}
	@Override
	public String toString() {
		return "Augmented Stack = "+ stack+"\n" +"Minimum = " + getMin();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test Cases
		AugmentedStack a  = new AugmentedStack();
		a.push(48);
		a.push(9);
		a.push(100);
		a.push(28);
		a.push(18283);
		a.push(3);
		a.push(89);
		a.push(-81);
		a.push(-11);

	/*	a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		
		*/
		System.out.println(a);
	}
}