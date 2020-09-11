/* Combatant.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Combatant- contains a symbol,health point, min and max for the combatants
 * 			Superclass of Players, Troll and Greater Troll						
 */
public abstract class Combatant extends Content {
	private int health, min, max;

	Combatant(String symbol, int health, int min, int max) {
		super(symbol);
		this.health = health;
		this.min = min;
		this.max = max;

	}

	public int getHP() {
		return health;
	}

	public int doAttack() {
		return (int) Math.random() * (max - min + 1) + min;

	}

	public void changeHP(int amount) {
		health += amount;
	}

	public String toString() {
		return "Combatant";
	}

}
