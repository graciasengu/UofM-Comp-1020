/*
* VisitingStudent.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 6
*
*Class: Visiting Student extending Student
*		-additional variable; String of the University of the visiting student
* 
*/
public class VisitingStudent extends Student {
	private String visitingUni;

	// min requirement of the GPA is set to 6, which would be never achieved as GPAs
	// are upon 5.
	public VisitingStudent(int number, String name, double gpa, String visitingUni) {
		super(number, name, gpa, 6.0);
		this.visitingUni = visitingUni;
	}

	public String toString() {
		return "Visiting Student: " + super.toString() + " Visting University: " + visitingUni;
	}

}
