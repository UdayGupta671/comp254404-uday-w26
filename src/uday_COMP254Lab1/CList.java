package uday_COMP254Lab1;

import uday_COMP254Lab1.SList.Node;

public class CList<E> {
	public static class Node<E>{
	private E element;
	private Node<E> next;
	
	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}
	
	 public E getElement() { return element; }
     public Node<E> getNext() { return next; }
     public void setNext(Node<E> n) { next = n; }
	
	}
    private Node<E> tail = null;    // we store tail (but not head)
    private int size = 0;           // number of nodes in the list
    
    
    public CList() { }   // constructs an initially empty list
    
    public int size() { return size; }
    
    public boolean isEmpty() { return size == 0; }
    
    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement(); // head is after tail
    }
    
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }
    
    public void rotate() {
        if (tail != null)            // if empty, do nothing
            tail = tail.getNext();   // old head becomes new tail
    }
    
    public  void addFirst(E e) {
    	if(size == 0) {
    		tail = new Node<E>(e,null);
    		tail.setNext(tail);
    	}
    	else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) {
        addFirst(e);                 // insert new element at front of list
        tail = tail.getNext();       // now new element becomes the tail
    }
    
    /**
     * Removes and returns the first element
     */
    public E removeFirst() {
        if (isEmpty()) return null;  // nothing to remove
        
        Node<E> head = tail.getNext();
        if (head == tail)            // must be the only node left
            tail = null;             // list becomes empty
        else
            tail.setNext(head.getNext()); // removes "head" from the list
        size--;
        return head.getElement();
    }
    public void printList() {
        Node<E> head = tail.getNext();
    	Node<E> walk = head;
        System.out.print("[ ");
        do {
            System.out.print(walk.getElement() + " ");
            walk = walk.getNext();
        } while (walk != head); // stop when we circle back to head
        System.out.println("]");
    }
    
    public CList<E> clone() {
    	CList<E> other = new CList<>();
    	
    	if(isEmpty() ) { return other; }
    	
    	// head in circular list = tail.next
        Node<E> head = this.tail.getNext();

        // Create first node in clone using head element
        Node<E> newHead = new Node<>(head.getElement(), null);
        newHead.setNext(newHead);     // make it circular for now

        other.tail = newHead;         // currently tail = head (only one node)
        other.size = 1;

        // Copy the rest of the nodes starting from the node AFTER head
        Node<E> walk = head.getNext();
        while (walk != head) {
            Node<E> newest = new Node<>(walk.getElement(), other.tail.getNext());
            other.tail.setNext(newest);
            other.tail = newest;
            other.size++;
            walk = walk.getNext();
        }

        return other;
    }


public static void main(String[] args) {

    CList<Integer> list = new CList<>();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    System.out.println("Original list:");
    list.printList();  // should print 10 20 30

    CList<Integer> cloned = list.clone();

    System.out.println("Cloned list:");
    cloned.printList(); // should print 10 20 30

    // Modify original to prove clone is deep copy
    list.addLast(40);

    System.out.println("After modifying original:");
    System.out.print("Original: ");
    list.printList();  // 10 20 30 40

    System.out.print("Clone: ");
    cloned.printList(); // still 10 20 30
}
}

