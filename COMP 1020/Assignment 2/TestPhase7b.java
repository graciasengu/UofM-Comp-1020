import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPhase7b {
	
	public static void main(String [] args) {
		// play the game!
		Grid g = new Grid(10, 10);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean gotInput = false;
		int row = 0, col = 0, direction = 0;
		String input = "";
		
		// make it stabilize
		g.replaceAll();
		while (g.drop()) {
			g.replaceAll();
		}
		
		while(true) {
			System.out.println(g);
			do {
				gotInput = false;
				System.out.println("Which row?");
				try {
					input = br.readLine();
				} catch (IOException ioe) {
					System.out.println("Something went horribly wrong...");
				}
				try {
					row = Integer.parseInt(input);
					gotInput = true;
				} catch (NumberFormatException nfe){
					System.out.println("Rows are numeric...");
				}
			} while (!gotInput);
			
			do {
				gotInput = false;
				System.out.println("Which column?");
				try {
					input = br.readLine();
				} catch (IOException ioe) {
					System.out.println("Something went horribly wrong...");
				}
				try {
					col = Integer.parseInt(input);
					gotInput = true;
				} catch (NumberFormatException nfe){
					System.out.println("Columns are numeric...");
				}
			} while (!gotInput);
			
			do {
				gotInput = false;
				System.out.println("Which Direction? " + Grid.UP + " - up, " + Grid.DOWN + " - down , " + Grid.RIGHT + " - right, " + Grid.LEFT+ " - left");
				try {
					input = br.readLine();
				} catch (IOException ioe) {
					System.out.println("Something went horribly wrong...");
				}
				try {
					direction = Integer.parseInt(input);
					gotInput = true;
				} catch (NumberFormatException nfe){
					System.out.println("Directions are numeric...");
				}
			} while (!gotInput);
			
			try {
				g.swap(row, col, direction);
				
				g.replaceAll();
				while (g.drop()) {
					g.replaceAll();
				}
			}
			catch (IndexOutOfBoundsException iob) {
				System.out.println(iob);
			}
			
		}
	}
	
	

}
