/*
* Main.Java
*
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 3
*
*Class: 
*	All test cases in read.txt works.
*	Reads the text file. Line by line.
*	Each line is split into an array of tokens separated by ","
*	Convert each reading into their respective data type, integers and strings
*	Assign them to their respective variable names. Eg: int temperature= 3;
*	Add them to the Readings array and print/output them.
*	
*/


import java.io.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader input; 
		String line;
		String[] tokens; // array of strings for the each reading separated by ","
		int temperature; 
		String numeric, direction = ""; 
		int speed;
		int precipitation = 0;
		String unit = "";
		int separation;
		int hours=0;
		int mins=0;
		

		Reading[] readings = new Reading[100]; //array of Readings in the text file, each line is reading
		int size = 0; 

		try {
			input = new BufferedReader(new FileReader("readings.txt"));

			line = input.readLine();
			while (line != null) {
				
				tokens = line.split(",");
				temperature = Integer.parseInt(tokens[0].trim());
				tokens[1] = tokens[1].trim();
				separation = firstNonNumericPosition(tokens[1]);
				
				if (separation == 0 || (separation < 0 && Integer.parseInt(tokens[1]) != 0)) {
					speed = -1;
				} else {
					if (separation < 0) {
						speed = 0;
						direction = "";
					} else {
						numeric = tokens[1].substring(0, separation);
						speed = Integer.parseInt(numeric.trim());
						direction = tokens[1].substring(separation).trim();
					}

					//check if  there is precipitation data
					if (tokens.length > 2) {
					    tokens[2] = tokens[2].trim();
					    separation = firstNonNumericPosition(tokens[2]);
					    if (separation <= 0) {
					      precipitation = -1;
					    } else {
					      numeric = tokens[2].substring(0, separation);
					      precipitation = Integer.parseInt(numeric.trim());
					      unit = tokens[2].substring(separation).trim();
					    }
					  } else {
					    precipitation = 0;
					    unit = "";
					  }
						
					//check if there is data on the duration of the precipitation
					//check if the string is numeric by itself using the isNumeric method
					// if it is, the numeral in the string is = to the number of hours
					// if it is not, separate it by ":" into hours and minutes
					// if the input is not according to standard, set hours and mins to -1 to raise an error alert
					// check to see if the data only consists of minutes, so set the hours to 0 and set the mins accordingly
					//lastly if it's not all the above, set the hours and mins accordingly
					
					if (tokens.length > 3) {
						tokens[3] = tokens[3].trim();
						separation=tokens[3].indexOf(':');
						if(isNumeric(tokens[3])) {
							hours = Integer.parseInt(tokens[3].trim());
						
						}else if (separation < 0) {
					        	hours = -1;
								mins = -1;
					     
						} else if (separation==0) {
							hours=0;
							numeric = tokens[3].substring(separation +1);
							mins = Integer.parseInt(numeric.trim());
						} else {
							numeric = tokens[3].substring(0, separation);
							hours = Integer.parseInt(numeric.trim());
							numeric = tokens[3].substring(separation +1);
							mins = Integer.parseInt(numeric.trim());
						}
							
						
						
					} 
					
					
				}
				//System.out.println(hours); //testing

				if (speed < 0 || precipitation < 0||mins<0) {
					System.out.println("Error in input: " + line);
				} else {
					//System.out.println(hours); //testing
					readings[size] = new Reading(temperature, speed, direction, 
						precipitation, unit.equalsIgnoreCase("cm"),hours,mins);
					size++;
				}
				hours=0;
				mins=0;
				line = input.readLine();
			}

			input.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		for (int i = 0; i < size; i++) {
			System.out.println(readings[i]);
		}

		System.out.println("\nEnd of processing.");
	}

	public static int firstNonNumericPosition(String str) {
		int pos = -1;
		int i = 0;

		while (pos < 0 && i < str.length()) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				pos = i;
			} else {
				i++;
			}
		}

		return pos;
	}
	//Sees if the string is parsable into an integer using a try and catch block
	//returns a boolean 
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
