/*
 * Grid.java
 *
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 2
 * QUESTION: Phase 1-7
 *
 * PURPOSE: Build a version of the game Bejewelled.Bejewelled is a ‘match 3’ game, where you must
			match 3 or more of the same gem by moving the gems on the board.
 * 	8 variables:
 *  2d char array for the board, height(cols),width(rows)
 *  char array with the 4 types of gems
 *  4 directions for the swap; UP,DOWN,LEFT,RIGHT.
 *  
 *  12 functions:
 *  1)Constructors-create the game board
 *  2)fill board- fills the game board with gems using random gem method
 *  3)createGrid-creates the game board using data from text files that are in the appropriate format(numeric dimensions, followed by the the gems)
 *    throws exceptions errors when not in appropriate format	
 *  4)save- saves the grid to an output file
 *  5)isNumeric-checks if the input is a numeral
 *  6)buildGrid- a method to help fill up the board-used in createGrid
 *  7)extractRow- extracting the row from the board
 *  8)extractColumn- extracting the column from the board
 *  9)replaceSets-checks a 1d array of gems to see if >= 3 of the gems are the same with X
 *  10)replaceAll- checks the board and replaces where >3 of the gems are the same with X
 *  11)drop-replaces the X spots with the gems on top of it
 *  12)swap-switching a gem to the right,left,up,down of it
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grid {
	public static final int UP = 2, DOWN = 8, LEFT = 4, RIGHT = 6;
	private char[][] board;
	private int height;
	private int width;
	public static char[] gems = { 'r', 'g', 'b', 'y' };
	private static FileReader fileReaderIn;
	private static BufferedReader fileIn;
	private static String inputLine;

	Grid(int height, int width) {
		this.height = height;
		this.width = width;
		board = new char[height][width];
		fillboard();
	}

	Grid(char[][] someGrid) {
		height = someGrid.length;
		width = someGrid[0].length;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				board = someGrid;

	}

	// fills the board with gems
	public void fillboard() {
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				board[i][j] = getRandomGem();

	}

	// randomly generates the gems
	public static char getRandomGem() {
		int choice = (int) (Math.random() * gems.length);

		return gems[choice];
	}

	/*
	 * Creates a game grid inputs the text file and checks if it already contains
	 * the game board yes- creates a 2d char array with the game board no- checks if
	 * the dimensions are given and are numeric yes-starts creating the game board
	 * with the data(throws error if rows and cols are not according to given
	 * dimensions) no-throws IOE error
	 */

	public static Grid createGrid(String filename) throws IOException {
		char[][] inputGrid = new char[0][0];
		int h = 0, w = 0;
		fileReaderIn = new FileReader(filename);
		fileIn = new BufferedReader(fileReaderIn);
		inputLine = fileIn.readLine();

		// checks if it is already a gameboard
		if (inputLine != null && (inputLine.contains("g") || inputLine.contains("y") || inputLine.contains("r"))) {
			int i = 0;
			inputGrid = new char[10][inputLine.length()];
			while (inputLine != null) {
				inputLine.trim();
				for (int j = 0; j < inputLine.length(); j++)
					inputGrid[i][j] = inputLine.charAt(j);
				i++;
				inputLine = fileIn.readLine();

			}
		// checks the input to see if the first line gives the dimensions
		// by splitting the string and parsing into int
		} else if (inputLine != null) {
			inputLine.trim();
			String[] dim = inputLine.split(" ");
			h = isNumeric(dim[0]);
			w = isNumeric(dim[1]);

			// dimensions are not numeric
			if (h == -1 || w == -1)
				throw new IOException("The size values were not numeric!");
			// dimensions are numeric and can build the 2d char array/game board
			// calls the buildGrid method to fill up the grid with gems
			else if (h != -1) {
				inputLine = fileIn.readLine();
				inputGrid = new char[h][w];
				inputGrid = buildGrid(h, w, inputGrid);
			}
		// if the input file is blank
		} else
			throw new IOException("No dimensions to read");

		fileIn.close();
		Grid g = new Grid(inputGrid);
		return g;
	}

	// saves game board to a textfile
	public void save(String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			String s = this.toString();
			fileWriter.write(s);
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				result += board[i][j];
			}
			result += '\n';
		}
		return result;
	}

	// checks to see if the string can be parsed into integers
	// return -1 if it cannot
	public static int isNumeric(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return -1;
		}

	}

	// fills the grid with gems from the text file
	// if rows and cols are not according to dimensions give, throws error
	public static char[][] buildGrid(int h, int w, char[][] inputGrid) throws IOException {

		for (int i = 0; i < h; i++) {
			if (inputLine != null) {
				inputLine.trim();
				if (inputLine.length() < w)
					throw new IOException("There was not enough colums. Saw " + inputLine.length() + " need " + w);
				for (int j = 0; j < w; j++)
					inputGrid[i][j] = inputLine.charAt(j);
				inputLine = fileIn.readLine();
			} else
				throw new IOException("There was not enough rows! Saw " + i + " need " + h);
		}

		return inputGrid;
	}

	// extracts row of gems from the game board
	public char[] extractRow(int rowNum) {

		char[] row = new char[width];
		for (int j = 0; j < width; j++)
			row[j] = board[rowNum][j];

		return row;
	}

	// extracts cols of gems from the game board
	public char[] extractColumn(int colNum) {

		char[] col = new char[height];
		for (int i = 0; i < height; i++)
			col[i] = board[i][colNum];

		return col;
	}

	// replaces 3 or more gems in a row with X
	public static char[] replaceSets(char[] input) {
		int start = -1, end = -1;
		String s = new String(input);
		for (int i = 1; i < input.length - 1; i++)
			if ((input[i - 1] == input[i]) && (input[i] == input[i + 1])) {
				if (end == -1)
					start = i - 1;
				end = i + 1;
			}
		if (start != -1) {
			for (int j = start; j <= end; j++)
				s = s.substring(0, j) + 'x' + s.substring(j + 1);
		}
		input = s.toCharArray();
		return input;

	}

	// replaces all cols and rows where 3 or more gems consecutively with X
	public char[][] replaceAll() {
		char[][] holding = new char[height][width];

		for (int i = 0; i < height; i++) {
			char[] row = this.extractRow(i);
			row = replaceSets(row);
			for (int y = 0; y < width; y++)
				holding[i][y] = row[y];
		}

		for (int j = 0; j < width; j++) {
			char[] col = this.extractColumn(j);
			col = replaceSets(col);
			for (int x = 0; x < height; x++)
				if (holding[x][j] != 'x')
					holding[x][j] = col[x];
		}

		for (int x = 0; x < height; x++)
			for (int y = 0; y < width; y++)
				board[x][y] = holding[x][y];

		return board;
	}

	// removes all the Xs and replaces them with the gems ontop of it, effectively
	// dropping the gems
	// returns a true boolean if drop takes place
	public boolean drop() {
		boolean dropped = false;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 && board[i][j] == 'x') {
					board[i][j] = getRandomGem();
					dropped = true;
				} else if (board[i][j] == 'x') {
					board[i][j] = board[i - 1][j];
					board[i - 1][j] = getRandomGem();
					dropped = true;
				}
			}
		}

		return dropped;
	}

	// swaps the gem with the gem next(up,down,left,right) to it
	public void swap(int row, int col, int direction) {
		try {
			char temp;
			if (direction == UP) {
				temp = board[row][col];
				board[row][col] = board[row - 1][col];
				board[row - 1][col] = temp;
			} else if (direction == DOWN) {
				temp = board[row][col];
				board[row][col] = board[row + 1][col];
				board[row + 1][col] = temp;
			} else if (direction == LEFT) {
				temp = board[row][col];
				board[row][col] = board[row][col - 1];
				board[row][col - 1] = temp;
			} else if (direction == RIGHT) {
				temp = board[row][col];
				board[row][col] = board[row][col + 1];
				board[row][col + 1] = temp;
			}
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
}
