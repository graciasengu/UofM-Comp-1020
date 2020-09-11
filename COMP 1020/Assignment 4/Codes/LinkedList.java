/*LinkedList.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 4
 * QUESTION: Phase 1-5
 * Purpose:	Linked List- 1 instance variable type Node:top -instantiated as the head of the Linked List
 * 						methods: -getTop() returns the top node
 * 								 -add() and addRec() adds data to the LinkedList with nodes linked recursively
 * 								 -createLinkedList() gets linked list input from a file and creates a linked list
 * 								 -isNumeric() checks if a data in the linked list is numeric
 * 								 -getSum() and getSumRec() returns the total sum of the integers in the list and length of the words
 * 								  in the list recursively
 * 								 -toString() toStringRec() goes through the linked list and prints in recursively
 * 								 -getSmallestNode() returns the smallest node according to the requirements
 * 								 -getPreviousNode() getPreviousNodeRec() returns the previous node of the current node
 * 																		(goes through the list recursively)
 * 								 -swap() swaps the 2 nodes 				
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinkedList {
	private Node top;

	LinkedList() {
		top = null;
	}

	// Accessor for the top Node
	public Node getTop() {
		return top;
	}

	// phase 1
	// checks if the linked list is empty
	// and adds the data and node link to the end of the linked list using recursion
	// using the addrec() method
	public void add(Object data) {
		Node newNode, prevNode = null;
		if (top == null) {
			newNode = new Node(data, null);
			top = newNode;
		}

		else {
			prevNode = addRec(top);
			newNode = new Node(data, prevNode.getLink());
			prevNode.setLink(newNode);
		}
	}

	// phase 1
	// goes through the linked list recursively to get to the end node
	private Node addRec(Node start) {
		if (start.getLink() == null)
			return start;
		else
			return addRec(start.getLink());
	}

	// phase 2
	// creates a Linked List from a file and calls the add() method to add the line
	public static LinkedList createLinkedList(String filename) {
		LinkedList myList = new LinkedList();
		BufferedReader inputFile;
		String line;

		try {
			inputFile = new BufferedReader(new FileReader(filename));
			line = inputFile.readLine();
			while (line != null) {
				if (isNumeric(line)) {
					int primitiveInt = Integer.parseInt(line);
					myList.add(primitiveInt);
				} else
					myList.add(line);

				line = inputFile.readLine();
			}
			inputFile.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return myList;
	}

	// phase 2
	// helper method to check if a line input is numeric
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// phase 3
	// calls getSumRec() to go through the linked list
	// and return the total sum
	public int getSum() {
		int sum = getSumRec(top, 0);
		return sum;
	}

	// phase 3
	// goes through the list recursively
	// and adds the integers,the length of a string and 0 for boolean
	private int getSumRec(Node start, int sum) {
		if (start == null)
			return sum;
		else {
			if (start.getData() instanceof String)
				sum += start.getData().toString().trim().length();

			else if (start.getData() instanceof Integer) {
				int primitiveInt = (int) start.getData();
				sum += primitiveInt;
			}

			return getSumRec(start.getLink(), sum);
		}
	}

	// phase 1
	// calls the toStringRec()method
	// returns the linked list in a string format
	public String toString() {
		String result = "";
		return toStringRec(getTop(), result);
	}

	// phase 1
	// goes through the linked list recursively and returns the list in a string
	// format
	private String toStringRec(Node start, String result) {
		if (start == null)
			return result;
		else {
			result += start.getData() + "\n";
			return toStringRec(start.getLink(), result);
		}
	}

	// phase 4
	// uses the compare to method in the Node class and returns the smallest node
	// goes through list recursively
	public static Node getSmallestNode(Node start, Node smallest) {
		if (smallest == null && start == null)
			return null;
		else if (start == null)
			return smallest;
		else {
			if (start.compareTo(smallest) <= 0)
				smallest = start;
			return getSmallestNode(start.getLink(), smallest);
		}

	}

	// phase 5
	// calls the getPreviousNodeRec
	public Node getPreviousNode(Node toFind) {
		return getPreviousNodeRec(top, toFind, null);
	}

	// phase 5
	// goes through the list recursively until node to find and returns the previous
	// one
	private Node getPreviousNodeRec(Node start, Node toFind, Node prevNode) {
		if (start == null)
			return prevNode;
		else {
			if (start.getLink() == toFind) {
				prevNode = start;
				return prevNode;
			}

			return getPreviousNodeRec(start.getLink(), toFind, prevNode);
		}
	}

	// phase 5
	// swaps the two 2 nodes

	public void swap(Node n1, Node n2) {
		Node n1prev, n1curr, n1next;
		Node n2prev, n2curr, n2next;

		n1prev = getPreviousNode(n1);
		n1curr = n1;
		n1next = n1.getLink();
		n2prev = getPreviousNode(n2);
		n2curr = n2;
		n2next = n2.getLink();

		// if one of the nodes was the first and the other node was the second
		if (n1 == top && n1next == n2curr) {
			top = n2;
			n2.setLink(n1);
			n1.setLink(n2next);
		} else if (n2 == top && n2next == n1curr) {
			top = n1;
			n1.setLink(n2);
			n2.setLink(n1next);
		}
		// if one of the nodes was the first and the other the last
		else if (n1 == top && n2next == null) {
			top = n2;
			n2.setLink(n1next);
			n2prev.setLink(n1);
			n1.setLink(null);

		} else if (n2 == top && n1next == null) {
			top = n1;
			n1.setLink(n2next);
			n1prev.setLink(n2);
			n2.setLink(null);

		}
		// if one of the nodes was the top
		else if (n1 == top) {
			n2.setLink(n1next);
			n1.setLink(n2next);
			top = n2;
			n2prev.setLink(n1);

		} else if (n2 == top) {
			n1.setLink(n2next);
			n2.setLink(n1next);
			top = n1;
			n1prev.setLink(n2);
		}
		// if one of the nodes was the last and second last
		else if (n2next == null && n2prev == n1curr) {
			n1.setLink(null);
			n2.setLink(n1);
			n1prev.setLink(n2);
		} else if (n1next == null && n1prev == n2curr) {
			n2.setLink(null);
			n1.setLink(n1);
			n2prev.setLink(n1);
		}
		// if one of the nodes was the last
		else if (n1next == null) {
			n2.setLink(null);
			n1.setLink(n2next);
			n1prev.setLink(n2);
			n2prev.setLink(n1);
		} else if (n2next == null) {
			n1.setLink(null);
			n2.setLink(n1next);
			n2prev.setLink(n1);
			n1prev.setLink(n2);
		}
		// all other cases
		else {
			n2.setLink(n1next);
			n1.setLink(n2next);
			n1prev.setLink(n2);
			n2prev.setLink(n1);
		}
	}

	public void removeNode(Node del) {
			
		if (del == top)
			top = del.getLink();
		else if (del.getLink() == null)
			getPreviousNode(del).setLink(null);
		else 
			getPreviousNode(del).setLink(del.getLink());	

	}

	public boolean selectionSort() {
		LinkedList newList = new LinkedList();
		return selectionSortRec(top, newList);

	}

	private boolean selectionSortRec(Node start, LinkedList newList) {
		Node min = getTop();
		if (start == null) {
			top = newList.getTop();
			return true;
		} 
		else {
			min = getSmallestNode(start, min);
			newList.add(min.getData());
			removeNode(min);
			return selectionSortRec(getTop(), newList);
		}
	}
}
