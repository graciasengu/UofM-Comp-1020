/*Main.java 

COMP 1020  SECTION D01
INSTRUCTOR: Robert Guderian
NAME: Gracia Sengutuvan
Assignment: Exercise 2
Method: Main method
	-reads the input of a text file-movies
	-changes the string into a double and formats the ratings to out of 10.0
	-and adds it into the array of movies
	 
    
Method findReviews
	-goes through the arrays of movie(object) 
	-and checks if it matches
	-and return the movie(object)
 */

import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader input;
        String title,ratingText,outOfText;
        double rating=-1,outOf;

        Review[] movies = new Review[100];
        int size = 0;
        Review match;

        try {
            input = new BufferedReader(new FileReader("movies.txt"));

            title = input.readLine();
            while (title != null) {
                ratingText = input.readLine();
                outOfText=input.readLine();

                try {

                    rating = Double.parseDouble(ratingText);
                    outOf = Double.parseDouble(outOfText);
                    rating= (rating/outOf)*10.0;

                    // if the conversion failed and the code below was not in the
                    // "try" block, the rating variable would contain the rating of
                    // the previous movie we read in (bad data)
                    match = findReview(movies, size, title);
                    if (match == null) {
                        // movie that was not previously listed
                        movies[size] = new Review(title, rating);
                        size++;
                    } else {
                        // this movie was already reviewed at least once
                        match.addRating(rating);
                    }

                } catch (NumberFormatException nfe) {
                    if(rating==-1)
                        System.out.println("Invalid rating: " + ratingText );
                    else
                        System.out.println("Invalid out of rating: " + outOfText );
                }

                title = input.readLine();
            }

            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        for (int i = 0; i < size; i++) {
            System.out.println(movies[i]);
        }

        System.out.println("\nFinished processing.");
    }



    public static Review findReview(Review[] movies, int size, String title) {
        Review result = null;
        int pos;

        pos = 0;
        while (pos < size && result == null) {
            if (movies[pos].matchTitle(title)) {
                result = movies[pos];
            } else {
                pos++;
            }
        }

        return result;
    }

}
