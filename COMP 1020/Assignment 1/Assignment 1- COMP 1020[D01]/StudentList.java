/*
 * StudentList.java
 *
 * COMP 1020 SECTION: D01
 * INSTRUCTOR: Robert Guderian
 * NAME: Gracia Sengutuvan
 * ASSIGNMENT: Assignment 1
 * QUESTION: Phase 1-3
 *
 * PURPOSE: Creates a  Class of
 * 3 attributes;
 *      1 Student array, an integer storing maximum number of students
 *      and another integer storing the actual number of students currently in the list
 * 3 functions;
 *      1 to check if the list already has the student
 *      another to add student if it meets the requirement and
 *      another to convert the student list into a string
 */

public class StudentList {

    private  Student[] allStudents;
    private  int maxStudents;
    private  int currStudents;


    StudentList(int maxStudents){
        this.maxStudents=maxStudents;
        allStudents= new Student[maxStudents];
        currStudents=0;
    }

    /* checks if the list already contains the student by going through a for loop
     * parameter- object reference variable of class Student
     * calls the checkStudent method in class Student
     * returns- boolean value confirming or denying if the student already exists in the list
     */
    public  boolean contains(Student s1){
        for(int i=0;i<currStudents;i++)
        {
            if (allStudents[i].checkStudent(s1))
               return true;
        }
        return false;
    }

    /* Adds a student if current number of students in the list does not exceed or is equal to
       the maximum number of students
     * parameter- object reference variable of class Student
     * returns- boolean value confirming or denying if the student is added into the list
     */
    public boolean addStudent(Student s1){
        if(currStudents<maxStudents){
            allStudents[currStudents]=s1;
            currStudents++;
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student s1){
        int i;
        for(i=0;i<currStudents;i++) {
             if (allStudents[i].checkStudent(s1)) {
                 break;
             }
         }
        for(int j=i;j<currStudents-1;j++){
            allStudents[j]=allStudents[j+1];
        }
        currStudents--;
         return true;
    }

    public Student returnFirst(){

        return allStudents[1];
    }


    // Returns a string datatype that contains all the information on the student
    // by going through the array of students via a for loop
    public String toString() {
        String result = "";
        for (int i = 0; i < currStudents; i++) {
            result += allStudents[i].toString() + "\n";
        }
        return result;
    }

}
