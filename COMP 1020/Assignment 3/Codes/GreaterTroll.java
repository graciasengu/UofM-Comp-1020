/*GreaterTroll.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	GreaterTroll- with symbol T, with 30 health points,min,max
 			Superclass-Combatant(Subclass of Content)
 */
public class GreaterTroll extends Troll {
	GreaterTroll() {
		super();
		this.changeHP(15);
		this.changeSymbol("T");

	}

	public int doAttack() {
		int attack;
		attack = super.doAttack();
		attack += super.doAttack();
		return attack;

	}

	public String toString() {
		return super.toString();
	}

}