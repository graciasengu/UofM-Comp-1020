
/*totalDurations.java (a method actually, not a class)

COMP 1020  SECTION D01
INSTRUCTOR: Robert Guderian
NAME: Gracia Sengutuvan
Assignment: Exercise 0
Method: totalDurations
    It creates a new pair of parallel arrays
    where each different incoming phone number is stored exactly once,
    and the duration is the total duration of all the calls from that phone number

    Takes in an array of phone numbers that called and a parallel array with the duration of those calls
    and an integer with the actual size of the array that is filled from the main program

    Return nothing, it's a void method
 */

public static void totalDurations(String[] phoneNumbers, int[]callDurations,int size){

        String[] uniquePhoneNumbers= new String[100];
        int[] totalDuration = new int[uniquePhoneNumbers.length];
        int uniqueSize=0, i=0,
            total=0; //temporary integer to cal. the total duration of the call
        boolean exists = false;

        while(i<size){

             //checking if the phone number already exists in the new array.
            //returns true if it does
            //not using find method as i don't need/want the pos in the array
            for (int j=0;j<uniqueSize;j++)
            {
                if (phoneNumbers[i].equals(uniquePhoneNumbers[j]))
                    exists= true;
            }

            //if it doesn't exist in the new array, making it unique,
            //we proceed to find the total duration of the calls made by the same phone number
            if(!exists) {
                uniquePhoneNumbers[uniqueSize]=phoneNumbers[i];
                for(int r=0;r<size;r++)
                {
                    if (uniquePhoneNumbers[uniqueSize].equals(phoneNumbers[r]))
                        total=total+callDurations[r];
                }

                totalDuration[uniqueSize]=total;
                uniqueSize++;
            }
            //resetting the temporary variables for the next iteration of the loop
            total=0;
            exists=false;
            i++;
        }

        printList(uniquePhoneNumbers, uniqueSize,totalDuration);

    }

    //program normally completed
    // programmed by Gracia Sengutuvan
