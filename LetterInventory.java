/*This class creates LetterInventory objects and will count thier
letters in ahshmap as well as perform a variety of other functions.*/


import java.util.*;

public class LetterInventory {
   private HashMap<Character, Integer> letterCount;
   private char[] charArray;
   private String original;
   
   //constructor method for object
   public LetterInventory(String data) {
      this.original = data;
      this.letterCount = new HashMap<Character, Integer>();
      data = data.toLowerCase();
      data = data.replaceAll("\\s", "");
      //using regex here to eliminate all non
      data = data.replaceAll("[^a-z]", "");
      this.charArray = data.toCharArray();
      
      /*adds each char to the hashmap with a count of 0
      if it is a letter.*/
      for (char c : charArray) {
         if (Character.isLetter(c)) {
            letterCount.put(c, 0); 
         }
      }
      //adds +1 for each instance of each letter to the hasmap
      for (char c : charArray) {
         if (letterCount.containsKey(c)) {
            letterCount.put(c, letterCount.get(c) + 1);
            }
      }
   }//enf of constructor
   
   //accepts a letterinventory object and prints the current
   //lettercount from the hashmap for each letter
   public void viewLetterCount(LetterInventory newString) {
      if(newString.isEmpty()) {
         System.out.println(
         "There are currently no characters left." +
         " You must have subtracted them all away,");
      }
      else {
      System.out.println(newString.letterCount);
      }
   }//enf of viewLetterCount method
  
   //getter method for original string
   public String getOriginal() {
      return this.original;
   }
   
   //getter method for count of specific letter
   public int get (char letter) {
      if (letterCount.containsKey(letter)) {
         return letterCount.get(letter);
      }
      else {
         return 0;
      }
   }
   
   //setter method for count of specific letter
   public void intSet (char c, int newCount) {
      if (letterCount.containsKey(c)) {
         letterCount.put(c, newCount);
      }
      else {
      }
   }
   
   //getter method for string in alphabetical order 
   public String toString() {
      Arrays.sort(charArray);
      return String.valueOf(charArray);
   }
   
   //getter method for if the hashmap is empty
   public boolean isEmpty() {
      if (original.equals(null)) {
         return true;
      }
      else {
         return false;
      }
   }
   
   //subtracts one string from another. accepts a letterinventory object
   //and returns a new object with the new count
   public LetterInventory subtract(LetterInventory other) {
      HashMap<Character, Integer> subtractMap = new HashMap<Character, Integer>(); 
      subtractMap = this.letterCount;
      String subtracted = "";
      for(char c: other.charArray) {
         if (subtractMap.containsKey(c)) {
            subtractMap.put(c, letterCount.get(c)-1);
            if (letterCount.get(c) <= 0) {
               subtractMap.remove(c);
            }
         } 
      }
      
      for (Character key: subtractMap.keySet()) {
         if (subtractMap.get(key) > 1) {
            for (int i = 0; i < subtractMap.get(key); i++) {
               subtracted = subtracted + key;
            }
         }
         else if (subtractMap.get(key) == 1) {
            subtracted = subtracted + key;
         }
      }
      LetterInventory subtractedL = new LetterInventory(subtracted);;
      return subtractedL;
   }//enf of subtract method
   

}//end of class
