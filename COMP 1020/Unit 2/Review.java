/*Review.java 

COMP 1020  SECTION D01
INSTRUCTOR: Robert Guderian
NAME: Gracia Sengutuvan
Assignment: Exercise 2
Instance variables- title, total rating of the movies, number of reviews
Method: matchTitle
	check if the two titles match
    
Method addRating
	if they match, add the ratings together

Method toString
	returns total ratings/no. of reviews
	
 */
class Review {
    private String title;
    private double totalRating;
    private int reviewCount;

    public Review(String title, double rating) {
        this.title = title;
        totalRating = rating;
        reviewCount = 1;
    }

    public void addRating(double rating) {
        totalRating += rating;
        reviewCount++;
    }

    public boolean matchTitle(String otherTitle) {
        // returns true if this movie's title matches otherTitle
        return title.equals(otherTitle);
    }

    public String toString() {
        return title + " (rating: " + (totalRating / reviewCount) + ")";
    }
}