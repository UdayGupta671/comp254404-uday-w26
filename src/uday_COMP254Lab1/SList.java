package uday_COMP254Lab1;

public class SList<E> {
	//nested node class
	 public static class Node<E> {        
	        private E element;   //reference to element stored at node
	        private Node<E> next;
	        public Node(E e, Node<E> n) { element = e; next = n; }
	        public E getElement() { return element; }
	        public Node<E> getNext() { return next; }
	        public void setNext(Node<E> n) { next = n; }
	    }
	 //instance variables
	    private Node<E> head = null;    // head node of the list (or null if empty)
	    private Node<E> tail = null;    // last node of the list (or null if empty)
	    private int size = 0;           // number of nodes in the list
        public SList() {} //contructor for empty list
        public void printList() {
            Node<E> walk = head;
            System.out.print("[ ");
            while (walk != null) {
                System.out.print(walk.getElement() + " ");
                walk = walk.getNext();
            }
            System.out.println("]");
        }
        public void addLast(E e) { //add element e to end of list
        	   Node<E> newest = new Node<>(e, null);
               if (head == null) {          // list is empty
                   head = newest;
                   tail = newest;
               } else {
                   tail.setNext(newest);
                   tail = newest;
               }
               size++;  //place before trailer
	    }
        public Node<E> getHead() {
            return head;
        }
   
//Swap methods
        
        public void swapNodes(Node<E> node1, Node<E> node2) {

            //if either node is null, cannot swap
            if (node1 == null || node2 == null) return;

            //if same node, no swap needed
            if (node1 == node2) return;

         //find the nodes that come before node1 and node2
         //singly linked list only points forward
            Node<E> prev1 = null;
            Node<E> prev2 = null;
            Node<E> current = head;     //for traversing current starts at beginning of list
         // Traverse the list to locate prev1 and prev2
            while (current != null /*reach end of list*/ && (prev1 == null || prev2 == null)) {

                // If current.next is node1, then current is prev1
                if (current.getNext() == node1) prev1 = current;

                // If current.next is node2, then current is prev2
                if (current.getNext() == node2) prev2 = current;

                current = current.getNext();
            }
                
                // If node1 is head, prev1 stays null
                if (head == node1) prev1 = null;

                // If node2 is head, prev2 stays null
                if (head == node2) prev2 = null;

                // If node1 or node2 is not actually in the list, do nothing
                if (head != node1 && prev1 == null) return;
                if (head != node2 && prev2 == null) return;
            
         // ---------- Rewire prev nodes ----------
            // If node1 is not head, connect prev1 to node2
            if (prev1 != null) prev1.setNext(node2);
            else head = node2;  // node1 was head, now node2 becomes head

            // If node2 is not head, connect prev2 to node1
            if (prev2 != null) prev2.setNext(node1);
            else head = node1;  // node2 was head, now node1 becomes head
            // ---------- Swap next pointers ----------
            // If nodes are adjacent, handle specially
            if (node1.getNext() == node2) {
                Node<E> after2 = node2.getNext();
                node2.setNext(node1);
                node1.setNext(after2);
            } else if (node2.getNext() == node1) {
                Node<E> after1 = node1.getNext();
                node1.setNext(node2);
                node2.setNext(after1);
            } else {
                // non-adjacent: swap next pointers
                Node<E> temp = node1.getNext();
                node1.setNext(node2.getNext());
                node2.setNext(temp);
            }
        }

public class TestSL {
	
	public static void main(String[] args) {

	    SList<Integer> list = new SList<>();

	    list.addLast(10);
	    list.addLast(20);
	    list.addLast(30);
	    list.addLast(40);
	    list.addLast(50);

	    System.out.println("Before swap:");
	    list.printList();

	    // Get references to nodes with values 2 and 4 (example)
        SList.Node<Integer> node1 = null;
        SList.Node<Integer> node2 = null;

        SList.Node<Integer> curr = list.getHead();
        while (curr != null) {
            if (curr.getElement() == 20) node1 = curr;
            if (curr.getElement() == 50) node2 = curr;
            curr = curr.getNext();
        }

        list.swapNodes(node1, node2);

        System.out.println("After swapping 20 and 50:");
        list.printList();
	}
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


