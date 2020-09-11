/*Trap.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Trap- 1 of the 3 items in the game
 * 			subtracting 5 hit points 
 *			Superclass-Item
 */
public class Trap extends Item {

	Trap() {
		super("^");
	}

	public int getEffect() {
		System.out.println("You set off a trap!");
		return -5;
	}

}