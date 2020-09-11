public class TestingPhase3
{
	public static void main (String[] args)
	{
		LinkedList list1 = LinkedList.createLinkedList("list1.txt");
		System.out.println("The next sum should be: 55");
		System.out.println(list1.getSum());
		
		LinkedList list2 = LinkedList.createLinkedList("list2.txt");
		System.out.println("The next sum should be: 78");
		System.out.println(list2.getSum());
		
		LinkedList list3 = LinkedList.createLinkedList("list3.txt");
		System.out.println("The next sum should be: 3044");
		System.out.println(list3.getSum());
		
		LinkedList list4 = new LinkedList();
		list4.add("Pizza");
		list4.add(5);
		list4.add(new LinkedList());
		list4.add(new Node(75, null));
		System.out.println("The next sum should be: 10");
		System.out.println(list4.getSum());
	}
}