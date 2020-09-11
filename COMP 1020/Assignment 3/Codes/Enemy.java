/*Enemy.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Enemy- with symbol E, with 12 health points,min,max
 * 				   1 of the 3 combatants
 					Superclass-Combatant
 */
public class Enemy extends Combatant {

	Enemy() {
		super("E", 12, 1, 5);
	}

	public String toString() {
		return "Enemy";
	}

}
