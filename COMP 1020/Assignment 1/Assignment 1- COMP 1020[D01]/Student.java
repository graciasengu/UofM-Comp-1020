/*
 * Student.java
 *
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 1
 * QUESTION: Phase 1-3
 *
 * PURPOSE: Creates a Student class with the attributes of first name, last name and student number
 *          of a University Student.
 *          Has two functions: one checks to see if two students are equal
 *                             the other returns the 3 attributes in a particular format in String
 */

public class Student {
    private  String firstName;
    private  String lastName;
    private  int studentNo;
    private  CourseList courseList;

    Student(String firstName, String lastName, int studentNo){
        this.firstName=firstName;
        this.lastName=lastName;
        this.studentNo=studentNo;
        courseList = new CourseList();
    }


     // Returns a string datatype that contains the 3 attributes
    public String toString(){
        return lastName+", "+firstName+" ("+studentNo+")";
    }

    /*
     * Checks to see if the 2 students are equal
     * parameter- object reference variable of class Student
     * returns- boolean datatype of either true or false
     *          true if the students are the same
     *          false if not.
     */
    public  boolean checkStudent(Student s1) {
        if (firstName.equals(s1.firstName)) {
            if (lastName.equals(s1.lastName)) {
                if (studentNo == s1.studentNo) {
                    return true;
                }
            }
        }

        return false;
    }

    // Returns a string with all the courses registered to the student
    public  String getCourseListString(){
        return "Student "+ lastName+", "+firstName+" ("+studentNo+")"+" is registered to: \n"+courseList.getAllTitles();
    }

    // Adds the course to the student's course list
    // parameter- a Course
    public void addCourse(Course c1){
        courseList.addCourse(c1);
    }

    public void removeCourse(Course c1){
        courseList.removeCourse(c1);
    }

}










