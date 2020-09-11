/*Content.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Content- contains a symbol for the items and combatants
 * 			Superclass of Item and Combatant						
 */
public abstract class Content {
	protected String symbol;

	Content(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void changeSymbol(String symbol) {
		this.symbol = symbol;
	}

}
