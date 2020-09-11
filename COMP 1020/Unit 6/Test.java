public class Test {
	public static void main(String[] args) {
		Student[] students = new Student[4];

		students[0] = new UndergradStudent(8032, "Casper", 2.78, 2);
		students[1] = new GraduateStudent(3044, "Sheena", 3.92, "Natural Language Processing");
		students[2] = new UndergradStudent(6170, "Yolanda", 4.26, 3);
		students[3] = new GraduateStudent(1755, "Geordi", 3.58, "Human-Computer Interaction");
		students[3] = new VisitingStudent(100, "Gracia", 3.62, "NUS");

		printStudents(students);
		printDeansList(students);

		System.out.println("\nEnd of processing.");
	}

	public static void printStudents(Student[] students) {
		System.out.println("\nList of all students:\n");
		for (int i = 0; i < students.length; i++) {
			System.out.println(i + 1 + ": " + students[i]);
		}
	}

	public static void printDeansList(Student[] students) {
		System.out.println("\nDean's honour list:\n");
		for (int i = 0; i < students.length; i++) {
			if (students[i].deansHonourList()) {
				System.out.println(students[i]);
			}
		}
	}
}
