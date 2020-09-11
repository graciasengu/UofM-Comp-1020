/*Tile.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Tile- consists of Symbol,Passable boolean and Content(either Item or Combatant)
 * 			methods- get,set,remove Content and get Symbol
 			Superclass of Wall and OpenSpace
 */
public abstract class Tile {
	private String symbol;
	private boolean passable;
	private Content c;

	Tile(String symbol, boolean passable) {
		this.symbol = symbol;
		this.passable = passable;

	}

	Tile(String symbol, boolean passable, Content c) {
		this.symbol = symbol;
		this.passable = passable;
		this.c = c;
	}

	public boolean isPassable() {
		return passable;
	}

	public String getSymbol() {
		if (c != null)
			return c.getSymbol();
		return symbol;
	}

	public void removeContent() {
		c = null;
	}

	public Content getContent() {
		return c;
	}

	public void setContent(Content c1) {
		c = c1;

	}

}
