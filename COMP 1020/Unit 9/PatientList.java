/* PatientList.Java
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 9
*
*Class: PatientList class
*		instance variable: Patient nodes, last arrival and size
*		method add-checks the severity and arrival of the patient 
*				   and goes through linked list	to compare and arranges the nodes accordingly
*/
public class PatientList {
	private PatientNode head;
	private int lastArrival;
	private int size;

	public PatientList() {
		head = null;
		lastArrival = 0;
		size = 0;
	}

	public void add(String name, int severity) {
		PatientNode current, previous = null;
		Patient patient = new Patient(name, lastArrival, severity);
		lastArrival++;
		PatientNode highest;

		if (head == null)
			head = new PatientNode(patient, head);
		else {
			current = head;
			while (current != null) {
				if (current.data.moreSevere(head)) {
					highest = new PatientNode(patient, current);
					if (previous == null)
						head = highest;
					else
						previous.next = highest;
					return;
				}
				previous = current;
				current = current.next;
			}
			if (current == null)
				previous.next = new PatientNode(patient, null);
		}
	}

	public Patient nextAdmission() {
		PatientNode current;
		PatientNode previous;
		PatientNode toAdmitCurrent = null;
		PatientNode toAdmitPrevious = null;

		current = head;
		previous = null;
		while (current != null) {
			if (toAdmitCurrent == null) {
				toAdmitCurrent = current;
			} else {
				if (current.data.isAdmittedBefore(toAdmitCurrent.data, lastArrival)) {
					toAdmitCurrent = current;
					toAdmitPrevious = previous;
				}
			}
			previous = current;
			current = current.next;
		}

		if (toAdmitCurrent != null) {

			if (toAdmitPrevious == null) {
				head = toAdmitCurrent.next;
			} else {
				toAdmitPrevious.next = toAdmitCurrent.next;
			}

			return toAdmitCurrent.data;
		} else {
			return null;
		}
	}

	public int getSize() {
		return size;
	}

	public void print() {
		PatientNode current;
		current = head;
		while (current != null) {
			System.out.println(current.data);
			size++;
			current = current.next;
		}

		System.out.println("Size = " + getSize());
		System.out.println("Last arrival = " + lastArrival);
	}

	public PatientList clone() {
		PatientList copy;
		PatientNode current;
		PatientNode copyCurrent;
		PatientNode newNode;

		copy = new PatientList();
		current = head;
		copyCurrent = null;
		while (current != null) {
			newNode = new PatientNode(current.data, null);
			if (copyCurrent == null) {
				copy.head = newNode;
			} else {
				// last node in copy points to the new node
				copyCurrent.next = newNode;
			}
			// move to the next node in both lists
			copyCurrent = newNode;
			current = current.next;
		}
		copy.lastArrival = lastArrival;

		return copy;
	}
}
