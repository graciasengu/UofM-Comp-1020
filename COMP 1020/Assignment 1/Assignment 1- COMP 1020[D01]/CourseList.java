/*
 * CourseList.java
 *
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 1
 * QUESTION: Phase 1-3
 *
 * PURPOSE: Creates a Class of
 * 3 attributes;
 *       1 Course array, an integer of current course number and another final integer
 *       storing the max number of courses
 * 2 functions;
 *  1 boolean function that checks if the course is already in the list of courses
 *  1 void function that adds the course to the list of courses
 *  1 string function that returns all the titles of the courses in the list
 *  1 string function that overrides the toString function in a particular format
 *
 */

public class CourseList {

    private final int maxCourses=100;
    private  int currCourseNo;
    private  Course[] courses;

    CourseList(){
        currCourseNo=0;
        courses = new Course[maxCourses];

    }

    /*checks if the list already contains the course by going through a for loop
     * parameter- object reference variable of class Course
     * returns- boolean value confirming or denying if the course already exists in the list
     */
    public boolean contains(Course c1){
        for(int i=0;i<currCourseNo;i++){
            if(courses[i].getTitles().equals(c1.getTitles()))
                return true;
        }
        return false;
    }

    // add courses to the array of courses
    public void addCourse(Course c1){
        courses[currCourseNo]=c1;
        currCourseNo++;

    }

    public void removeCourse(Course c1){
        for(int i=0;i<currCourseNo;i++) {
            if (courses[i].equals(c1))
                courses[i] = null;
        }
            currCourseNo--;
        //reorder the course array
        for(int j=0;j<currCourseNo;j++) {
            if (courses[j] == null) {
                courses[j] = courses[j + 1];
                courses[j + 1] = null;
            }
        }
    }

    // return all the titles of the courses in the array of courses
    public  String getAllTitles() {
       String result = "";
        for (int i = 0; i < currCourseNo; i++) {
            result += courses[i].getTitles() + "\n";

        }
        return result;
    }

    // returns the titles of the courses in the array of courses
    public String toString(){
        String result="";
        for (int i = 0; i < currCourseNo; i++)
            result += courses[i].toString() + "\n";

        return result;
    }























}
