/*Node.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 4
 * QUESTION: Phase 1-5
 * Purpose:	instance variables- an object, node link to the next
 * 			-getData()-returns the data
 * 			-getLink()-returns the next link of node
 * 			-setLink()-sets the link of the node
 * 			-compares the nodes
 */
public class Node {

	private Object data;
	private Node link;

	public Node(Object initData, Node initLink) {
		data = initData;
		link = initLink;
	}

	public Object getData() {
		return data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node newLink) {
		link = newLink;
	}

	// phase 4
	/*
	 * looks through the linked list and returns the smallest node -Integer data is
	 * considered to be smaller than String data -If the two Nodes being compared
	 * contain Integer data, the difference between them will be returned. -If the
	 * two Nodes being compared contain String data, the alphabetical difference
	 * between them will be returned -Any data that is not an Integer and not a
	 * String is considered to be bigger than Integers and Strings.
	 */
	public int compareTo(Node other) {
		if (data instanceof Integer) {
			if (other.getData() instanceof String)
				return -1;
			else if (other.getData() instanceof Integer) {
				int x = (int) data;
				int y = (int) other.getData();
				return x - y;
			} else
				return -1;
		}

		else if (data instanceof String) {
			if (other.getData() instanceof Integer)
				return 1;
			else if (other.getData() instanceof String)
				return ((String) data).compareTo((String) other.getData());
			else
				return -1;

		}
		return 1;

	}
}