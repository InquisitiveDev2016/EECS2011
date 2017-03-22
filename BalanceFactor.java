import java.io.PrintStream;
import java.util.Scanner;
/**
 * The balance factor of an internal position p of a proper binary tree is the difference between the heights of the right and left subtrees of p.
 * Show how to specialize the Euler tour traversal of Section 8.4.6 to print the balance factors of all the internal nodes of a proper binary tree.
 * @author vishal
 *
 */
public class BalanceFactor<E>{

	//////////////////////////////////////////////////////////////////////
	
	public static class BinarySearchTree<E extends Comparable<? super E>>{
			//////////////////////////////////////////////////	
		/*
		 * This static nested class encapsulates a node in the tree.
		 */
		private class Node<E>{
			private E data;
			private Node<E> parent;
			private Node<E> leftSubTree;
			private Node<E> rightSubTree;

			public Node(E data, Node<E> leftSubTree, Node<E> rightSubTree){
				this.data = data;
				this.leftSubTree = leftSubTree;
				this.rightSubTree = rightSubTree;
			}
		}
		
			////////////////////////////////////////////////////
	// Ensure the parameterized type can be sorted.//
		private Node<E> root;
		/**
		 * Initializes an empty binary search tree.
		 */
		public BinarySearchTree(){
			root = null;
		}
		/**
		 * Adds the passed value to the tree.
		 * @param value the value to add to the tree
		 */
		public void add(E value){
			root = addNode(root, value);
		}
																									// Solves 'add' recursively.//
		private Node<E> addNode(Node<E> root, E value){
			Node<E> result = null;
			if (root == null){ 																		// Base case, add node here.//
				result = new Node<E>(value, null, null);
			}
			else if (root.data.compareTo(value) > 0){ 												// Recursive case, go left.//
				root.leftSubTree = addNode(root.leftSubTree, value);
				result = root;
			}
			else {																					// Recursive case, go right.//
				root.rightSubTree = addNode(root.rightSubTree, value);
				result = root;
			}
			return result;
		}
	
		public int BalanceFactor(Node<E> root){
			if (root == null){
				return 0;
			}
			if (root.leftSubTree == null && root.rightSubTree == null){
				System.out.println("Balance factor:- ["+ root.data+ ", 0]");
				return 0;
			}
			
			int LeftHeight  = BalanceFactor(root.leftSubTree);
			int RightHeight = BalanceFactor(root.rightSubTree);

			System.out.println("Balance factor:- [" + root.data + ", " + Math.abs(LeftHeight - RightHeight) +"]");
			
			
			return RightHeight+LeftHeight+1;
		}
	}
	
	///////////////////////END OF BINERYSEARCHTREE CLASS///////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		PrintStream output = System.out;
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		output.println("Enter number of integers you want a tree to be made of:-");
		int elements = input.nextInt();
		int i=0;
		output.println("Enter list of integers you want to add to tree:-");
		while(i<elements){
			int temp =  input.nextInt();
			bst.add(temp);
			i++;
		}
		System.out.println("\nBalance Factor:- [Element, Factor]\n");
		bst.BalanceFactor(bst.root);
	}
}
