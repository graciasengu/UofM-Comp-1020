/*Troll.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Troll- with symbol t, with 15 health points,min,max
 			Superclass-Combatant(Subclass of Content)
 */
public class Troll extends Combatant {
	Troll() {
		super("t", 15, 1, 10);
	}

	public String toString() {
		return "Troll";
	}

}
