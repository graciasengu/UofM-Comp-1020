/*OpenSpace.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	OpenSpace- symbol of . , can be passed into.
 			Subclass of Tile
 */
public class OpenSpace extends Tile {

	OpenSpace() {
		super(".", true);
	}

	OpenSpace(Content c) {
		super(".", true, c);
	}

}
