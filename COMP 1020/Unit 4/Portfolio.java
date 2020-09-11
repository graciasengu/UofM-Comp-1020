/*
* Portfolio.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 4
*
*Class: 
*	Swap method- swaps the properties at the given positions from one list to the other
*	
*/

import java.util.ArrayList;

class Portfolio {
	private ArrayList<Property> list;
	private String owner;

	public Portfolio(String owner) {
		list = new ArrayList<Property>();
		this.owner = owner;
	}

	public void add(Property p) {
		list.add(p);
	}

	public void print() {
		int totalValue;

		System.out.println(owner + "'s portfolio:");

		totalValue = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" " + list.get(i));
			totalValue += list.get(i).value();
		}

		System.out.println("Total value: $" + totalValue);
	}

	public void subdivide(int position, boolean lengthwise) {
		Property toSubdivide;
		Property subdivision;

		toSubdivide = list.get(position);
		subdivision = toSubdivide.subdivide(lengthwise);

		list.add(subdivision);
	}

	public Property transfer(int position, Portfolio buyer) {
		Property toTransfer;

		toTransfer = list.get(position);
		list.remove(position);
		buyer.add(toTransfer);

		return toTransfer;
	}
	
	//swaps the properties of between 2 portfolios
	// using the get and set method from arraylist
	public int swap(Portfolio p,int posA, int posB) {
		
		Property temp1,temp2;
		temp1=this.list.get(posA-1);
		temp2=p.list.get(posB-1);
		this.list.set(posA-1, temp2);
		p.list.set(posB-1, temp1);
		
		return temp1.value()-temp2.value();
	}
}
