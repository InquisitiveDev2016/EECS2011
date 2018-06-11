public class PointersTest{
	// Private Linked List to Store data.
	
	public class LinkedList<E>{
		private Node head;
		private Tail tail;
		private int size;
		private class Node{
			E data;
			Node next;
			Node prev;
			public Node(E data, Node next, Node prev){
				this.data = data;
				this.next = next;
				this.prev = prev;
			}
		}
		public LinkedList(){
			size = 0;
		}
		public int size(){return size;}
		public boolean isEmpty(){return size == 0;}
		public void addFirst(E element){
			Node temp = new Node(element, head, null);
			if(head != null){head.prev == temp;}
			head = temp;
			if(tail == null){ tail = temp;}
			size++;
		}
		public void addLast(E element){
			Node temp = new Node(element, null, tail);
			if(head != null){ head.next == temp;}
			tail = temp;
			if(tail == null){head = temp;}
			size++;
		}
	}
	private LinkedList<String> dataList;
	private ArrayList<Integer> pointersArray;
	private ArrayList<Integer> resultSet;
	public PointerTest(){
		dataList = new LinkedList<String>();
		pointerArray = new ArrayList<Integter>;
	}
	public PointersTest(E element, int p){
		dataList = new LinkedList<String>();
		pointerArray = new ArrayList<Integter>;
		add(element, p);
	}
	public void add(E element , int p){
		dataList.addLast(element);
		pointerArray.add(p);
	}
	// Given when the input is sorted ( pointerArray is sorted).
	public ArrayList<Integer> Consecutiveness(){
		Node i =0; Node j =1; //  Keep Track of pointers
		resultSet = new ArrayList<Integer>();
		while(i.next == j){
			resultSet.add(i); resultSet.add(j);
			i.next;j.next;
		}
		return resultSet;
	}
}