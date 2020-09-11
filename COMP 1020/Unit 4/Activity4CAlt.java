import java.util.ArrayList;

public class Activity4CAlt {
	public static void main(String[] args) {
		Portfolio jim, helen;
		Property property;

		jim = new Portfolio("Jim");
		jim.add(new Property(16, 8, 160));
		jim.add(new Property(24, 17, 130));
		jim.add(new Property(129, 180, 35));

		helen = new Portfolio("Helen");
		helen.add(new Property(9, 13, 120));
		helen.add(new Property(15, 15, 210));
		helen.add(new Property(9, 13, 120));

		jim.print();
		helen.print();

		jim.subdivide(0, true);
		jim.subdivide(2, false);
		helen.subdivide(0, false);

		property = jim.transfer(1, helen);
		System.out.println(property + " transferred from Jim to Helen for $" + property.value());
		property = helen.transfer(3, jim);
		System.out.println(property + " transferred from Helen to Jim for $" + property.value());

		jim.print();
		helen.print();

		System.out.println("\nEnd of processing.");
	}
}

class Property {
	private int length, width; // both are in metres
	private int valuePerSqM;   // value in $ per square metre
	
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
		return "Property: " + length + "m long by " + width + "m wide ($" +
			valuePerSqM + " per square metre)";
	}
}

class Portfolio {
	private Property[] list;
	int size;
	private String owner;
	
	public Portfolio(String owner) {
		// assume that a typical portfolio has at most 3 properties
		list = new Property[3];
		// but it has none initially
		size = 0;
		this.owner = owner;
	}
	
	public void add(Property p) {
		if (size >= list.length) {
			// make the new list twice as big as the old
			Property[] newList = new Property[list.length * 2];
			// copy the old contents to the new list
			System.arraycopy(list, 0, newList, 0, list.length);
			// replace the old list with the new one
			list = newList;
		}
		list[size] = p;
		size++;
	}
	
	public void print() {
		int totalValue;

		System.out.println(owner + "'s portfolio:");

		totalValue = 0;
		for (int i = 0; i < size; i++) {
			System.out.println(" " + list[i]);
			totalValue += list[i].value();
		}

		System.out.println("Total value: $" + totalValue);
	}

	public void subdivide(int position, boolean lengthwise) {
		Property toSubdivide;
		Property subdivision;

		toSubdivide = list[position];
		subdivision = toSubdivide.subdivide(lengthwise);

		add(subdivision);
	}
	
	public Property transfer(int position, Portfolio buyer) {
		Property toTransfer;

		toTransfer = list[position];
		remove(position);
		buyer.add(toTransfer);

		return toTransfer;
	}
	
	private void remove(int position) {
		for (int i = position + 1; i < size; i++) {
			list[i - 1] = list[i];
		}
		size--;
	}
}
