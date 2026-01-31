package uday_COMP254Lab1;

//doubly linked list class will use 2 sentiel nodes header and the trailer
public class DList<E> {
	private static class Node<E> {     //nested node class
		private E element;  //reference of stored element at node
		private Node<E> prev;  //reference to previous node
		private Node<E> next;  //reference  to subsequent node
		public Node(E e, Node<E> p, Node<E> n) {
          element = e;
          prev = p;
          next = n;
      }
		public E getElement() { return element; }
      public Node<E> getPrev() { return prev; }
      public Node<E> getNext() { return next; }
      public void setPrev(Node<E> p) { prev = p; }
      public void setNext(Node<E> n) { next = n; }
		//nested node class ends
	}
	    private Node<E> header;   //header sentiel
	    private Node<E> trailer;   //trailersentiel
	    private int size = 0;    //no. of elements inlist
	    
	    public DList() {     //constructor to create empty list
	    	header = new Node<>(null, null, null);  //header created
	        trailer = new Node<>(null, header, null);   //trailer preceded by header
	        header.setNext(trailer);   //header is followed by trailer
	    }
	    
	    public int size() {return size;}    //return no of elements
	    public boolean isEmpty(){ return size == 0; } //check list is empty
	 
	    //private update methods
	    private void addBetween(E e, Node<E> predecessor, Node<E> successor) { //add e between nodes
	        Node<E> newest = new Node<>(e, predecessor, successor);
	        predecessor.setNext(newest);
	        successor.setPrev(newest);
	        size++;
	    }
//public updates methods
	    public void addFirst(E e) {    //add element e to front of list
	        addBetween(e, header, header.getNext());    //place after headeer
	    }

	    public void addLast(E e) { //add element e to end of list
	        addBetween(e, trailer.getPrev(), trailer);  //place before trailer
	    }
	    public void printList() {
	        Node<E> walk = header.getNext();
	        System.out.print("[ ");
	        while (walk != trailer) {
	            System.out.print(walk.getElement() + " ");
	            walk = walk.getNext();
	        }
	        System.out.println("]");
	    }
	    
	    //concatenation method
	    
	    public void concatenate(DList<E> other) {
	        if (other == null || other.isEmpty()) {
	            return;  // Nothing to concatenate
	        }
	        if (this.isEmpty()) {
	            // Just adopt other's internal nodes if current list is empty
	            this.header.setNext(other.header.getNext());
	            this.trailer.setPrev(other.trailer.getPrev());
	            other.header.getNext().setPrev(this.header);
	            other.trailer.getPrev().setNext(this.trailer);
	            this.size = other.size;
	        } else {
	            // Non-empty lists
	            Node<E> lastThis   = this.trailer.getPrev();   // last real node of this
	            Node<E> firstOther = other.header.getNext();   // first real node of other
	            Node<E> lastOther  = other.trailer.getPrev();  // last real node of other

	            // Connect last of this to first of other
	            lastThis.setNext(firstOther);
	            firstOther.setPrev(lastThis);

	            // Connect last of other to this.trailer
	            lastOther.setNext(this.trailer);
	            this.trailer.setPrev(lastOther);

	            this.size += other.size;
	        }
	        // Make other an empty list again
	        other.header.setNext(other.trailer);
	        other.trailer.setPrev(other.header);
	        other.size = 0;
	    }
	    
	    public class TestConcat {

	        public static void main(String[] args) {
	            DList<Integer> L  = new DList<>();
	            DList<Integer> M  = new DList<>();

	            // Fill L
	            L.addLast(1);
	            L.addLast(2);
	            L.addLast(3);

	            // Fill M
	            M.addLast(4);
	            M.addLast(5);

	            System.out.println("L before concat: ");
	            L.printList();
	            System.out.println("M before concat: ");
	            M.printList();

	            L.concatenate(M);

	            System.out.println("L after concat:  ");
	            L.printList();
	            System.out.println("M after concat:  ");
	            M.printList();
	        }	 
	    }	 	    
}
