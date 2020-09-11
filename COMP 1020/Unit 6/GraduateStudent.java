/*
* GraduateStudent.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 6
*
*Class: Graduate Student extending Student
*		-passing the min GPA requirement to get into the Dean's List
*		 as a parameter to the Superclass constructor 
* 
*/
class GraduateStudent extends Student {
	private String thesis;

	public GraduateStudent(int number, String name, double gpa, String thesis) {
		super(number, name, gpa, 3.75);
		this.thesis = thesis;
	}

	public String toString() {
		return "Graduate: " + super.toString() + " thesis: " + thesis;
	}
}
