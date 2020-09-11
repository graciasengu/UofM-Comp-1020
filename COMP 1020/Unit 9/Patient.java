/* Patient.Java
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 9
*
*Class: Patient class
*		-instance variables: Name, arrival, severity
*		-methods: isAdmittedbefore and moreSevere
*				  checks which of the patients are more severe and returns a boolean	
*/
public class Patient {
	private String name;
	private int arrival;
	private int severity;

	public Patient(String name, int arrival, int severity) {
		this.name = name;
		this.arrival = arrival;
		this.severity = severity;
	}

	public boolean isAdmittedBefore(Patient other, int lastArrival) {
		boolean before;
		int priority, otherPriority;

		if (severity == 3) {
			// admitted before, unless the other's severity is 3 and arrived earlier
			before = (other.severity != 3) || (other.arrival > arrival);
		} else if (other.severity == 3) {
			before = false;
		} else {
			priority = (lastArrival - arrival) * severity;
			otherPriority = (lastArrival - other.arrival) * other.severity;
			before = (priority > otherPriority) || ((priority == otherPriority) && other.arrival > arrival);
		}

		return before;
	}

	public boolean moreSevere(PatientNode other) {

		return ((other.data.severity > severity) || (other.data.severity == severity && other.data.arrival < arrival));

	}

	public String toString() {
		return name + " arrived at " + arrival + " with severity " + severity;
	}
}
