public class TestingPhase5
{
	public static void main (String[] args)
	{
		//Testing the getPreviousNode method
		LinkedList myList = new LinkedList();
		myList.add(-700);
		myList.add("hello");
		myList.add(12);
		myList.add(55);
		myList.add(13000);
		myList.add("world");
		myList.add("pizza");
		myList.add(870);
		
		
		System.out.println("The previous node of the node containing 12 is the Node containing \"hello\":");
		System.out.println(myList.getPreviousNode(myList.getTop().getLink().getLink()).getData());
		System.out.println();
		
		//Testing swap:
		
		System.out.println("The initial list is:");
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Now swapping the first and second nodes, and the result is:");
		myList.swap(myList.getTop(), myList.getTop().getLink());
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Now swapping back the first and second nodes, and the result is:");
		myList.swap(myList.getTop().getLink(), myList.getTop());
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Now swapping the first and third nodes, and the result is:");
		myList.swap(myList.getTop(), myList.getTop().getLink().getLink());
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Now swapping the seventh and eighth nodes, and the result is:");
		myList.swap(myList.getTop().getLink().getLink().getLink().getLink().getLink().getLink(), myList.getTop().getLink().getLink().getLink().getLink().getLink().getLink().getLink());
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Now swapping the second and fifth nodes, and the result is:");
		myList.swap(myList.getTop().getLink().getLink().getLink().getLink(), myList.getTop().getLink());
		System.out.println(myList);
	}
}