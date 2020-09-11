/*
 * Course.java
 *
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 1
 * QUESTION: Phase 1-3
 *
 * PURPOSE: Creates a Course Class
 * 2 functions:
 *  1 string function that returns the title of the course
 *  1 string function that overrides the toString function in a particular format
 *  Register method- to add a Student to the course if they are not already in the course
 *   and there's space to do so. If there's no capacity, add the student to the wait list if there's capacity.
 *  Withdraw method-
 */

public class Course {

    private final static int maxWL = 100;
    private String titleCourse, sTitleCourse;
    private int maxClassSize;
    private StudentList classList;
    private StudentList waitList;
    private int currClassNo;
    private int currWaitNo;

    Course(String titleCourse, String sTitleCourse, int maxClassSize) {

        this.titleCourse = titleCourse;
        this.sTitleCourse = sTitleCourse;
        this.maxClassSize = maxClassSize;

        classList = new StudentList(maxClassSize);
        waitList = new StudentList(maxWL);
        currClassNo = 0;
        currWaitNo = 0;
    }

    //gets the title of the course
    public String getTitles() {
        return sTitleCourse + " - " + titleCourse;
    }

    //returns the the titles of the course and the list of students in the class list and wait list
    public String toString() {
        String result = "";
        result = getTitles() + "\n";
        result += "Class List: " + "\n" + classList.toString();
        result += "Wait List:" + "\n" + waitList.toString();
        return result;
    }

    /* Registers a student into a course if
       -they are already not registered and there's enough space
       -if not- add to wait list if they are not already wait listed and there's enough space
     * parameter- a Student
     * returns- nothing
     */
    public void register(Student r1) {
        boolean registered = false;
        boolean waitListed = false;

        //goes through the class list to find if the student is already registered
        //if registered, output to user as such
        if (classList.contains(r1)) {
            System.out.println("The Student " + r1.toString()
                    + " is already registered to " + sTitleCourse + "!");
            registered = true;
        }

        /*
        if not registered;
         -check if there's a space to register
         -and register the student to the course
         -and add course to to the student's list of courses
        */
        else {
            if (currClassNo < maxClassSize) {
                if (classList.addStudent(r1)) {
                    currClassNo++;
                    System.out.println("The Student " + r1.toString()
                            + " has been registered successfully to " + sTitleCourse + ".");
                    //testing: System.out.println("test"+classList.toString());
                    r1.addCourse(this);
                }
            }
            //if there's no space to register the student; try to wait list the student
            else {
                //goes through the wait list to find if the student is already wait listed
                //if already wait-listed, output as such
                if (waitList.contains(r1)) {
                    System.out.println("The Student " + r1.toString()
                            + " is already on the wait list for " + sTitleCourse + "!");
                    waitListed = true;
                }

                //if not, check if there's space to wait list
                else {

                    if (currWaitNo < maxWL) {
                        if (waitList.addStudent(r1)) {
                            // testing: System.out.println(classList.toString());
                            currWaitNo++;
                            System.out.println("The Student " + r1.toString()
                                    + " has been placed on the wait list for " + sTitleCourse + ".");
                        }
                    } else
                        System.out.println("The wait list is full for " + sTitleCourse + "!");

                }
            }
        }
    }

    /* Withdraw a student from a course
       -from class list or wait list
       -if there are other students in the wait list, they move up the accordingly is space permits
   * parameter- a Student
   * returns- nothing
   */
    public void withdraw(Student r1) {
        /*check is student is in class list
            -remove student
            -move up the list of students in the course
            -remove course from the student's list of course
             -check if the wait-list has students and bring them up to the class-list by registering them.
        */
        if (classList.contains(r1)) {
            if (classList.removeStudent(r1)) {
                currClassNo--;
                System.out.println("The student " + r1 + " has been withdrawn from " + sTitleCourse+".");
                r1.removeCourse(this);

                if (currWaitNo > 0) {

                    if(classList.addStudent( waitList.returnFirst())){
                       currClassNo++;
                       System.out.println("The Student " +  waitList.returnFirst().toString()
                               + " has been registered successfully to " + sTitleCourse + ".");
                       waitList.returnFirst().addCourse(this);

                       if(waitList.removeStudent(waitList.returnFirst()))
                           currWaitNo--;
                   }
               }

            }
        }
        //check if student is in wait list
        else if (waitList.contains(r1)) {
            //remove student in the wait-list
            if (waitList.removeStudent(r1)) {
                currWaitNo--;
                System.out.println("The student " + r1 + " has been withdrawn from the wait list " + sTitleCourse+".");
            }
        }
        //outputs  a string if student is not in this course at all.
        else
            System.out.println("The student " + r1 + " is not on any list of " + sTitleCourse+".");

    }
}




