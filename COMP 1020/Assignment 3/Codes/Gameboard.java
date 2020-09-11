
/*Gameboard.java
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 3
 * QUESTION: Phase 1-6
 * Purpose:	Gameboard- 2D array of Tile
 * 		    Function:Input the text file and pass into the 2d Tile array to create the game board accordingly
 * 					 calHP()-returns the player's health points
 * 					 do round()-Move the player through the game board according to User given input of the direction
 * 					 moveTile()-checks if the tile in the give direction is an Open space, an item or a combatant
 * 							   and performs the appropriate action according to what is in the tile
 * 					 toString()-prints the game board	
 * 					 getDone()- returns if the game is over-boolean
 * 					 getWon()- return if the game is won-boolean			  	
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gameboard {
	public static final int UP = 2;
	public static final int DOWN = 8;
	public static final int LEFT = 4;
	public static final int RIGHT = 6;
	private boolean gameover = false, gameresult = false;
	Tile[][] t1;

	Gameboard(String filename) {
		try {
			FileReader fileReaderIn = new FileReader(filename);
			BufferedReader fileIn = new BufferedReader(fileReaderIn);
			String inputLine = fileIn.readLine();

			inputLine.trim();
			String[] dim = inputLine.split(" ");
			int rows = Integer.parseInt(dim[0]), cols = Integer.parseInt(dim[1]);
			t1 = new Tile[rows][cols];
			inputLine = fileIn.readLine();

			/*
			 * checks the Content of the input in the text file, Add into the tile[][]
			 * accordingly if it's an Item, Combatant,OpenSpace or Wall
			 */

			for (int i = 0; i < rows; i++) {
				inputLine.trim();
				char[] cArray = inputLine.toCharArray();
				for (int j = 0; j < cols; j++) {
					if (cArray[j] == '#')
						t1[i][j] = new Wall();
					else if (cArray[j] == '.')
						t1[i][j] = new OpenSpace();
					else if (cArray[j] == 'Y')
						t1[i][j] = new OpenSpace(new Amulet());
					else if (cArray[j] == 'h')
						t1[i][j] = new OpenSpace(new HealthPotion());
					else if (cArray[j] == '^')
						t1[i][j] = new OpenSpace(new Trap());
					else if (cArray[j] == '@')
						t1[i][j] = new OpenSpace(new Player());
					else if (cArray[j] == 't')
						t1[i][j] = new OpenSpace(new Troll());
					else if (cArray[j] == 'T')
						t1[i][j] = new OpenSpace(new GreaterTroll());
					else if (cArray[j] == '@')
						t1[i][j] = new OpenSpace(new Player());

				}
				inputLine = fileIn.readLine();
			}

			fileIn.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	// calculates the hit points of the Player
	public int calHP(int rows, int cols) {
		int hp = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (t1[i][j].getContent() instanceof Player)
					hp = ((Combatant) t1[i][j].getContent()).getHP();
		return hp;
	}

	// returns true if the Player has won
	public boolean getWon() {
		return gameresult;
	}

	// returns true if the game is over
	public boolean getDone() {
		return gameover;
	}

	// checks if the direction to move player is UP,DOWN,LEFT or RIGHT
	// call the method moveTile according to the game board rows and columns
	public void doRound(int direction) {
		int pRow = -1, pCol = -1;

		for (int i = 0; i < t1.length; i++)
			for (int j = 0; j < t1[0].length; j++)
				if (t1[i][j].getContent() instanceof Player) {
					pRow = i;
					pCol = j;
				}
		if (direction == UP)
			moveTile(pRow, pCol, pRow - 1, pCol);
		else if (direction == DOWN)
			moveTile(pRow, pCol, pRow + 1, pCol);
		else if (direction == LEFT)
			moveTile(pRow, pCol, pRow, pCol - 1);
		else if (direction == RIGHT)
			moveTile(pRow, pCol, pRow, pCol + 1);

	}

	/*
	 * checks if the tile to be moved into is either a 1) OpenSpace-moves the player
	 * into the tile 2) Item- if it's amulet, game is won and over. If it's HP and
	 * and Trap, add/subtract points accordingly 3) Combatant- fight against
	 * combatant to see who can move into the spot(win/lose by hit points)
	 */
	public void moveTile(int pRow, int pCol, int nRow, int nCol) {
		int effectPt = -1;
		// openspace
		if (t1[nRow][nCol].getSymbol().equals(".")) {
			t1[nRow][nCol] = t1[pRow][pCol];
			t1[pRow][pCol] = new OpenSpace();
			// item
		} else if (t1[nRow][nCol].getContent() instanceof Item) {
			if (t1[nRow][nCol].getContent() instanceof Amulet) {
				gameover = true;
				gameresult = true; // game is won and over
			}
			effectPt = ((Item) t1[nRow][nCol].getContent()).getEffect();
			((Combatant) t1[pRow][pCol].getContent()).changeHP(effectPt);

			t1[nRow][nCol] = t1[pRow][pCol];
			t1[pRow][pCol] = new OpenSpace();
			// combatants
		} else if (t1[nRow][nCol].getContent() instanceof Combatant) {
			String typeOfC = ((Combatant) t1[nRow][nCol].getContent()).toString();
			effectPt = ((Combatant) t1[pRow][pCol].getContent()).doAttack();
			System.out.println("Player attacks the " + typeOfC + " for " + effectPt);
			((Combatant) t1[nRow][nCol].getContent()).changeHP(-effectPt);
			int after = ((Combatant) t1[nRow][nCol].getContent()).getHP();
			// combatant is defeated
			if (after <= 0) {
				t1[nRow][nCol] = t1[pRow][pCol];
				t1[pRow][pCol] = new OpenSpace();
				System.out.println(typeOfC + " is vanquished!");
			} // if the combatant survives, combatant will attack the player
			else if (after > 0) {
				effectPt = ((Combatant) t1[nRow][nCol].getContent()).doAttack();
				((Combatant) t1[pRow][pCol].getContent()).changeHP(-effectPt);
				int after2 = ((Combatant) t1[pRow][pCol].getContent()).getHP();
				System.out.println(typeOfC + " attacks the Player for " + effectPt);
				if (after2 <= 0) {
					gameover = true;
					gameresult = false;
				}

				System.out.print("Player health:" + after2 + " ");
				System.out.println(((Combatant) t1[nRow][nCol].getContent()).toString() + "health " + after);
			}

		}
	}

	// Print out the game board with the player's health points
	public String toString() {
		String result = "Health: " + calHP(t1.length, t1[0].length) + "\n";
		for (int i = 0; i < t1.length; i++) {
			for (int j = 0; j < t1[0].length; j++)
				result += t1[i][j].getSymbol();
			result += "\n";
		}
		return result;
	}

}
