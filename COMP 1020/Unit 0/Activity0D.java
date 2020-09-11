/*COMP 1020  SECTION D01
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
public class Activity0D {
   public static void main(String[] args) {
      String[] phoneNumbers = new String[100];
      int[] callDurations = new int[phoneNumbers.length];
      int size = 0;

      size = addCall(phoneNumbers, callDurations, size, "555-555-5555", 137);
      size = addCall(phoneNumbers, callDurations, size, "555-555-0000", 12);
      size = addCall(phoneNumbers, callDurations, size, "555-555-1234", 26);
      size = addCall(phoneNumbers, callDurations, size, "555-555-9876", 382);
      size = addCall(phoneNumbers, callDurations, size, "555-555-0000", 32);


      /*System.out.println("Phone numbers (initially):");
      printList(phoneNumbers, callDurations, size);

      size = removeCall(phoneNumbers, callDurations, size, 1); // middle
      size = removeCall(phoneNumbers, callDurations, size, size - 1); // last
      size = removeCall(phoneNumbers, callDurations, size, 0); // first

      System.out.println("\nPhone numbers (after):");
      printList(phoneNumbers, callDurations, size);

      size = removeCall(phoneNumbers, callDurations, size, 0);

      System.out.println("\nPhone numbers (none left):");
      printList(phoneNumbers, callDurations, size);

      System.out.println("\nEnd of processing.");

       */
   }

   public static int addCall(String[] phoneNumbers, int[] callDurations, int size, String newNumber, int newDuration) {
      if (size >= phoneNumbers.length) {
         System.out.println("Error adding " + newNumber + ": array capacity exceeded.");
      } else {
         phoneNumbers[size] = newNumber;
         callDurations[size] = newDuration;
         size++;
      }

      return size;
   }

   public static void printList(String[] phoneNumbers, int[] callDurations, int size) {
      for (int i = 0; i < size; i++) {
         System.out.println(phoneNumbers[i] + " duration: " + callDurations[i] + "s");
      }
   }

   public static int find(String[] list, int size, int start, String target) {
      int pos = start;

      while (pos < size && !target.equals(list[pos])) {
         pos++;
      }

      if (pos == size)
         pos = -1;

      return pos;
   }

   public static void findAllCalls(String[] phoneNumbers, int[] callDurations, int size, String targetNumber) {
      int matchPos;

      System.out.println("Calls from " + targetNumber + ":");
      matchPos = find(phoneNumbers, size, 0, targetNumber);
      while (matchPos >= 0) {
         System.out.println(phoneNumbers[matchPos] + " duration: " + callDurations[matchPos] + "s");

         // Find the next match, starting after the last one
         matchPos = find(phoneNumbers, size, matchPos + 1, targetNumber);
      }
   }

   public static int removeCall(String[] phoneNumbers, int[] callDurations, int size, int posToRemove) {
      for (int i = posToRemove + 1; i < size; i++) {
         phoneNumbers[i - 1] = phoneNumbers[i];
         callDurations[i - 1] = callDurations[i];
      }
      size--;

      return size;
   }


   public static void totalDurations(String[] phoneNumbers, int[]callDurations,size){
      String[] uniquePhoneNumbers= new String[100];
      int[] totalDuration = new int[uniquePhoneNumbers.length];
      int uniqueSize=0, i=0,total=0;
      boolean exists=0;

      while(i<size){
         for (int j=0;j<uniqueSize;j++)
         {
            if (phoneNumbers[i].equals(uniquePhoneNumbers[j]))
               exists = 1;
         }

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


         exists=0;
         i++;
         }

      }

   }

}
