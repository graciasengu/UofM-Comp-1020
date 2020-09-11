/*
* Property.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 4
*No changes done to the Property clas
*/

class Property {
	private int length, width; // both are in metres
	private int valuePerSqM; // value in $ per square metre

	public Property(int length, int width, int valuePerSqM) {
		this.length = length;
		this.width = width;
		this.valuePerSqM = valuePerSqM;
	}

	public int value() {
		return length * width * valuePerSqM;
	}

	public Property subdivide(boolean lengthwise) {
		Property subdivision;

		if (lengthwise) {
			subdivision = new Property(length / 2, width, valuePerSqM);
			length = (length + 1) / 2;
		} else {
			subdivision = new Property(length, width / 2, valuePerSqM);
			width = (width + 1) / 2;
		}

		return subdivision;
	}

	public String toString() {
		return "Property: " + length + "m long by " + width + "m wide ($" + valuePerSqM + " per square metre)";
	}
}
