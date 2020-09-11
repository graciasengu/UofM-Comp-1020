/*Amulet.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Amulet- 1 of the 3 items in the game
 * 			Picking up this item will result in winning the game.No HP
 *			Superclass-Item
 */

public class Amulet extends Item {

	Amulet() {
		super("Y");
	}

	public int getEffect() {
		System.out.println("You picked up the Amulet of Yendor!");
		return 0;
	}

}
