/*HealthPotion.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	HealthPotion- 1 of the 3 items in the game
 * 			adding on 5 hit points 
 *			Superclass-Item
 */
public class HealthPotion extends Item {

	HealthPotion() {
		super("h");
	}

	public int getEffect() {
		System.out.println("You picked up a health potion!");
		return 5;
	}

}