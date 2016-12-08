

public class countRange {

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
			private int size;

			public Node(E data, Node<E> leftSubTree, Node<E> rightSubTree){
				this.data = data;
				this.leftSubTree = leftSubTree;
				this.rightSubTree = rightSubTree;
				this.size = 1;
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
				root.size = root.size+1;
				result = root;
			}
			else {																					// Recursive case, go right.//
				root.rightSubTree = addNode(root.rightSubTree, value);
				root.size = root.size+1;
				result = root;
			}
			return result;
		}
		
		
		public int countRange(Node<E> root, int k1, int k2){
		    // Base case
		    if (root == null) {
		    	return 0;
		    }
		    // If current node is in countRange, then include it in count and
		    // recur for left and right children of it
		    if ((int)root.data <= k2 && (int)root.data >= k1){
		    	return countRange(root.leftSubTree,k1, k2) + countRange(root.rightSubTree,k1, k2) +1;
		    	
		    }
		    // If current node is smaller than k1, then recur for right
		    else if ((int)root.data < k1){
		    	return countRange(root.rightSubTree, k1, k2);
		       
		    }
		    // else go left
		    else {
		    	return countRange(root.leftSubTree, k1, k2);
		    	
		    }
		}
		
		public String toString(){
			StringBuffer sb = new StringBuffer();
			infixPrint(root, 0, sb);
			return sb.toString().trim();
		}
		private void infixPrint(Node<E> root, int size ,StringBuffer sb){
			if (root != null){
				sb.append("["+root.data + ", " + root.size + "],");
				infixPrint(root.leftSubTree, root.size,  sb);
				infixPrint(root.rightSubTree, root.size, sb);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(44);
		bst.add(17);
		bst.add(32);
		bst.add(78);
		bst.add(50);
		bst.add(88);
		bst.add(48);
		bst.add(62);
		System.out.println("The Tree with size of each Node");
		System.out.println(bst.toString());
		System.out.println("Range between:- 32, 88");
		System.out.println(bst.countRange(bst.root,32,88));
	}

}
