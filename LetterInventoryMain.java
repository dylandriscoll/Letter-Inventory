/*This program will prompt the user for a string input and allow 
the user to perform a variety of different functions */

import java.util.*;

public class LetterInventoryMain {
      
      //main method 
      public static void main(String args[]) {
         Scanner input = new Scanner(System.in);
         String userCommand = "";
         LetterInventory newString = newLetterInventory(input);
         while (!userCommand.startsWith("8")) {
            userCommand = menu(input, userCommand);
            userChoice(input, userCommand, newString);
            }
         input.close();
      }//end of main method
      
      /*This method creates a new letterinventory object with a user
      stringand returns said object */
      public static LetterInventory newLetterInventory (Scanner input) {
         System.out.println(
         "This program will manipulate a string of your choice" +
         "in a variety of ways.");
         System.out.println(
         "Please enter the string " +
         "you would like to use for this program.");
         String userString = input.nextLine();
         LetterInventory newLetter = new LetterInventory(userString);
         return newLetter;
      }//end of method
      
      /*This method prints a menu and uses collects and returns the
      user input as a string*/   
      public static String menu(Scanner input, String userCommand) {
         System.out.println();
         System.out.println(
         "Please type the corresponding number " +
         "to what you want to do");
         System.out.println(
         "0. View letter count of your current string");
         System.out.println(
         "1. Print your string in its original state");
         System.out.println(
         "2. Count the number of a specified " +
         "letter in your string");
         System.out.println(
         "3. Set the count for a specified "+ 
         "letter to a specified number");
         System.out.println(
         "4. Check if a string exists already");
         System.out.println(
         "5. Sort your string in alphabetical order");
         System.out.println(
         "6. Add two strings together");
         System.out.println(
         "7. Subtract a string inventory from another");
         System.out.println(
         "8. Quit the program");
         userCommand = input.next();
         return userCommand;
      }//end of menu method
      
      /*depending on the string representing what the user wants to do, this
      method will perform the tasks for each function.*/
      public static void userChoice(Scanner input, 
      String userCommand, LetterInventory newLetter) {
         switch (userCommand) {
            case "0":
               newLetter.viewLetterCount(newLetter);
               return;
            case "1":
               System.out.println(
               newLetter.getOriginal());
               return;
            case "2":
               System.out.println(
               "Enter the letter you wish find the number of");
               System.out.println(
               "This program will use the first character provided:");
               String userFind;
               char userFindChar;
               userFind = input.next();
               userFind.toLowerCase();
               userFindChar = userFind.charAt(0);
               int count = newLetter.get(userFindChar);
               if(Character.isLetter(userFindChar)) {
                  System.out.println(
                  "There are " + count + " " + userFindChar + "'s in your string.");
                  }
               else {
                  System.out.println(
                  "This program only counts letters from a to z.");
               }
               return;
            case "3":
               System.out.println(
               "Enter the letter you wish set the number of:");
               String userFind1;
               char userFindChar1;
               userFind1 = input.next();
               userFindChar1 = userFind1.charAt(0);
               System.out.println(
               "Type the number you wish to set it to:");
               int newCount = input.nextInt();
               newLetter.intSet(userFindChar1, newCount);
               System.out.print(
               "The count for " + userFindChar1 +
                " has been set to " + newCount + ".");
               return;
            case "4":
               System.out.println(
               "Please type the string you would like to check:");
               input.nextLine();
               String newCheck = input.nextLine();
               if (newCheck.equals(newLetter.getOriginal())) {
                  System.out.println(
                  "This string already exists.");
               }
               else {
                  System.out.println(
                  "This string does not exist.");
               }
               return;
            case "5":
                System.out.println(newLetter.toString());
               return;
            case "6":
               System.out.println(
               "Please type the string you would "  +
               "like to add to the current one:");
               input.nextLine();
               String sumString = input.nextLine();
               sumString = sumString + " " + newLetter.getOriginal();
               LetterInventory sum = new LetterInventory(sumString);
               sum.viewLetterCount(sum);
               System.out.println(
               "In alphabetical order:");
               System.out.println(sum.toString());
               System.out.println(
               "In their original form when the strings were combined:");
               System.out.println(sum.getOriginal());
               return;
            case "7":
                System.out.println(
               "Please type the string you would "  +
               "like to subtract from the current one:");
               input.nextLine();
               String subString = input.nextLine();
               LetterInventory sub = new LetterInventory(subString);
               LetterInventory subtractedL = newLetter.subtract(sub);
               subtractedL.viewLetterCount(subtractedL);
               System.out.println(
               "In alphabetical order:");
               System.out.println(
               subtractedL.toString());
               System.out.println(
               newLetter.getOriginal() + " minus the letters in " 
               + subString + ".");
               return; 
            case "8":
               System.out.println(
               "Program will now close.");
               return;
            default: 
               System.out.println(
               "Please choose a command from the menu.");
               return;
         }//enf of userChoice method
      }
}
