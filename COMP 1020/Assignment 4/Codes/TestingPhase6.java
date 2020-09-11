public class TestingPhase6
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
		
		
		System.out.println("The initial list is:");
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Running selection sort results in:");
		myList.selectionSort();
		System.out.println(myList);
		
		System.out.println();
		
		LinkedList list3 = LinkedList.createLinkedList("list3.txt");
		System.out.println("The initial list is:");
		System.out.println(list3);
		
		System.out.println();
		System.out.println("Running selection sort results in:");
		list3.selectionSort();
		System.out.println(list3);
		
	}
}