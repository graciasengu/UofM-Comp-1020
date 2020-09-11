/*
* Test.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 4
*
*Class: 
*	tests the swap method and prints out the appropriate statement.
*	
*/
public class Test {

	public static void main(String[] args) {
		Portfolio jim, helen;
		Property property;


		jim = new Portfolio("Jim");
		jim.add(new Property(16, 8, 160));
		jim.add(new Property(24, 17, 130));
		jim.add(new Property(129, 180, 35));

		helen = new Portfolio("Helen");
		helen.add(new Property(9, 13, 120));
		helen.add(new Property(15, 15, 210));
		helen.add(new Property(9, 13, 120));

		jim.print();
		helen.print();

		jim.subdivide(0, true);
		jim.subdivide(2, false);
		helen.subdivide(0, false);

		property = jim.transfer(1, helen);
		System.out.println(property + " transferred from Jim to Helen for $" + property.value());
		property = helen.transfer(3, jim);
		System.out.println(property + " transferred from Helen to Jim for $" + property.value());

		jim.print();
		helen.print();
	
		//Testing the swap method that returns the difference of the value of the two properties
		System.out.println("Properties swapped between Helen to Jim with a difference in value of $" +helen.swap(jim, 1, 3));
		System.out.println("Properties swapped between Jim to Helen with a difference in value of $" +jim.swap(helen, 2, 2));
		System.out.println("Properties swapped between Helen to Helen with a difference in value of $" +helen.swap(helen, 2, 2));
		
		
		jim.print();
		helen.print();

		System.out.println("\nEnd of processing.");
	}

}
