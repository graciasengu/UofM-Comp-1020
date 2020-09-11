public class TestingPhase4
{
	public static void main (String[] args)
	{
		//Testing the compareTo first
		Node node1 = new Node(1, null);
		Node node2 = new Node(10, null);
		Node node3 = new Node("test", null);
		Node node4 = new Node("wow", null);
		Node node5 = new Node(new LinkedList(), null);
		Node node6 = new Node(new int[5], null);
		
		System.out.println("The next compareTo should return: -9");
		System.out.println(node1.compareTo(node2));
		
		System.out.println("The next compareTo should return: 9");
		System.out.println(node2.compareTo(node1));
		
		System.out.println("The next compareTo should return: -3");
		System.out.println(node3.compareTo(node4));
		
		System.out.println("The next compareTo should return: 3");
		System.out.println(node4.compareTo(node3));
		
		System.out.println("The next compareTo should return: 0");
		System.out.println(node1.compareTo(node1));
		
		System.out.println("The next compareTo should return: 0");
		System.out.println(node4.compareTo(node4));
		
		System.out.println("\nAll the following tests should return true");
		
		System.out.println(node1.compareTo(node2) < 0);
		System.out.println(node1.compareTo(node3) < 0);
		System.out.println(node1.compareTo(node4) < 0);
		System.out.println(node1.compareTo(node5) < 0);
		System.out.println(node1.compareTo(node6) < 0);
		
		System.out.println(node2.compareTo(node3) < 0);
		System.out.println(node2.compareTo(node4) < 0);
		System.out.println(node2.compareTo(node5) < 0);
		System.out.println(node2.compareTo(node6) < 0);
		
		System.out.println(node3.compareTo(node4) < 0);
		System.out.println(node3.compareTo(node5) < 0);
		System.out.println(node3.compareTo(node6) < 0);
		
		System.out.println(node4.compareTo(node5) < 0);
		System.out.println(node4.compareTo(node6) < 0);
		
		System.out.println(node6.compareTo(node1) > 0);
		System.out.println(node5.compareTo(node3) > 0);
		
		System.out.println(node3.compareTo(node1) > 0);
		System.out.println(node4.compareTo(node2) > 0);
		
		System.out.println(node2.compareTo(node1) > 0);
		System.out.println(node4.compareTo(node3) > 0);
		
		
		//Now testing the getSmallestNode
		LinkedList myList = new LinkedList();
		myList.add(-700);
		myList.add("hello");
		myList.add(12);
		LinkedList nested = new LinkedList();
		nested.add("Just one node in the list");
		myList.add(nested);
		myList.add(55);
		myList.add(13000);
		myList.add(new double[55]);
		
		
		System.out.println("\n" + myList + "\n");
		System.out.println("The smallest node is the one with the data = -700");
		System.out.println(LinkedList.getSmallestNode(myList.getTop(), myList.getTop()).getData());
		
		System.out.println("If we skip the first Node, the smallest node is the one with the data = 12");
		System.out.println(LinkedList.getSmallestNode(myList.getTop().getLink(), myList.getTop().getLink()).getData());
		
		LinkedList empty = new LinkedList();
		System.out.println("The smallest node in an empty list is: null");
		System.out.println(LinkedList.getSmallestNode(empty.getTop(), empty.getTop()));
	}
}