/*
* GraduateStudent.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 6
*
*Class: Superclass Student
*		-create a double with the minimum GPA requirement 
*		that is passed on from constructor in the subclasses GraduateStudent and UndergradStudent
* 
*/

class Student {
	private int number;
	private String name;
	private double gpa;
	private double minReq;

	public Student(int number, String name, double gpa, double minReq) {
		this.number = number;
		this.name = name;
		this.gpa = gpa;
		this.minReq = minReq;
	}

	public boolean deansHonourList() {
		boolean result = false;
		if (gpa > minReq)
			result = true;
		return result;
	}

	public String toString() {
		return number + " " + name + " (" + gpa + ")";
	}
}
