public class TestPhase1
{
	public static void main (String[] args)
	{
		Student s1 = new Student("Miranda", "Frost", 123001);
		Student s2 = new Student("Mister", "Bullion", 123002);
		Student s3 = new Student("Natalya", "Simonova", 123003);
		Student s4 = new Student("Boris", "Grishenko", 123004);
		
		StudentList l1 = new StudentList(3);
		boolean canAdd = false;
		canAdd = l1.addStudent(s1);
		if (!canAdd)
			System.out.println("Cannot add student: " + s1);
		
		System.out.println(l1);
		
		if (l1.contains(s1))
			System.out.println("The list already contains: " + s1 + "\n");
		
		canAdd = l1.addStudent(s2);
		if (!canAdd)
			System.out.println("Cannot add student: " + s2);
		
		System.out.println(l1);
		
		canAdd = l1.addStudent(s3);
		if (!canAdd)
			System.out.println("Cannot add student: " + s3);
		
		System.out.println(l1);
		
		canAdd = l1.addStudent(s4);
		if (!canAdd)
			System.out.println("Cannot add student: " + s4);
		
		System.out.println(l1);
	}
}