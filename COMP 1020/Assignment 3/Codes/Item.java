/*Item.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Item- Superclass of Amulet,HealthPotion,Trap
 * 				-the 3 items in the game
 * 			
 */
public abstract class Item extends Content {

	Item(String symbol) {
		super(symbol);
	}

	public int getEffect() {
		return 0;
	}
}
