/*Player.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Player- with symbol @, with 100 health points,min,max
 * 				    1 of the 3 Combatants
 					Superclass-Combatant(Subclass of Content)
 */
public class Player extends Combatant {
	Player() {
		super("@", 100, 5, 10);
	}

	public String toString() {
		return "Player";
	}

}
