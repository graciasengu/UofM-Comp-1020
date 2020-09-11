/*GreaterEnemy.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	GreaterEnemy-subclass of Enemy, double the Health points:24
 *						 Superclass-Combatant(Subclass of Content)
 */
public class GreaterEnemy extends Enemy {
	GreaterEnemy() {
		super();
	}

	public String toString() {
		return super.toString();
	}

	public void changeHP() {
		super.changeHP(super.getHP());
	}

}
