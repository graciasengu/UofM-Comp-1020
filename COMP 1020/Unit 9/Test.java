public class Test {
	public static void main(String[] args) {
		String[] names = { "Zelma", "Clayton", "Casper", "Ihor", "Edwina" };
		int[] severities = { 1, 2, 3, 1, 3 };
		PatientList list;

		list = new PatientList();
		testPatientList(list, names, severities, 0);

		System.out.println("\nEnd of processing.");
	}

	public static void testPatientList(PatientList list, String[] names, int[] severities, int pos) {
		PatientList copy;

		if (pos < names.length) {
			list.add(names[pos], severities[pos]);
			copy = list.clone();
			
			copy.print();
			System.out.println("Admitting: " + copy.nextAdmission());
			System.out.println();
			
			testPatientList(list, names, severities, pos + 1);
			testPatientList(copy, names, severities, pos + 1);
		}
	}
}
