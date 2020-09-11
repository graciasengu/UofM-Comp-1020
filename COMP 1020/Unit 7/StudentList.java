import java.util.ArrayList;

class StudentList {
	private ArrayList<Student> list;

	public StudentList() {
		list = new ArrayList<Student>();
	}

	public void add(Student student) {
		boolean done = false;
		int pos;

		// find the insertion point (this is just a linear search)
		pos = list.size() - 1;
		while (pos >= 0 && !done) {
			if (student.getNumber() > list.get(pos).getNumber()) {
				done = true;
			} else {
				pos--;
			}
		}

		list.add(pos + 1, student);
	}

	private void sortByName(ArrayList<Student> list) {
		int minPos;
		Student temp;

		for (int i=0; i<list.size()-1;i++) {
			minPos = i;
			for (int j =i+1; j<list.size();j++) {
				if (list.get(j).nameComesBefore(list.get(minPos))){
					minPos = j;
				}
			}
			temp = list.get(i);
			list.set(i,list.get(minPos));
			list.set(minPos,temp);
		}

	}

	public void printByNumber() {
		System.out.println("\nStudents ordered by number:");
		printStudents(list);
	}
	
	public void printByName() {
		ArrayList<Student>list2=(ArrayList<Student>)list.clone();
		sortByName(list2);
		System.out.println("\nStudents ordered by Name:");
		printStudents(list2);
		
	}

	private void printStudents(ArrayList<Student> list) {
		System.out.println("\nList of all students:\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + ": " + list.get(i));
		}
	}
}
