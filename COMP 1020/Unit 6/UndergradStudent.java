/*
* UndergradStudent.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 6
*
*Class: Undergrad Student extending Student
* 		-passing the min GPA requirement to get into the Dean's List
*		 as a parameter to the Superclass constructor 
*/
class UndergradStudent extends Student {
	private int year;

	public UndergradStudent(int number, String name, double gpa, int year) {
		super(number, name, gpa, 3.5);
		this.year = year;
	}

	public String toString() {
		return "Undergraduate: " + super.toString() + " year: " + year;
	}
}
