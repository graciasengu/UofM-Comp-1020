/* PatientNode.Java
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 9
*Class: PatientNode class
*		instance variable: Patient and Patient Node
*/
public class PatientNode {
	public Patient data;
	public PatientNode next;
	
	public PatientNode(Patient data, PatientNode next) {
		this.data = data;
		this.next = next;
	}
}
