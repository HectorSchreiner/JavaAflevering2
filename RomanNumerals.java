/* Marcus Jensen, Hector Schousbo
20100 Indledende programmering og software teknologi
This program takes an integer as user input, and makes it to a roman numeral string.
*/

/*
we need a scanner object
and the InputMismatchException type (for error handling). 
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class RomanNumerals {
   public static void main(String[] args) {
      int input = userInput();
      System.out.println(input + " = " + arabicToRoman(input));

   }

   // Method converts an arabic integer to a roman numeral string
   static String arabicToRoman(int arabicinput) {
      String romanString = "";

      while (arabicinput >= 1000) {
         romanString = romanString + "M".repeat(arabicinput / 1000);
         arabicinput = arabicinput % 1000;
      }
      while (arabicinput >= 900) {
         romanString = romanString + "CM".repeat(arabicinput / 900);
         arabicinput = arabicinput % 900;
      }
      while (arabicinput >= 500) {
         romanString = romanString + "D".repeat(arabicinput / 500);
         arabicinput = arabicinput % 500;
      }
      while (arabicinput >= 400) {
         romanString = romanString + "CD".repeat(arabicinput / 400);
         arabicinput = arabicinput % 400;
      }
      while (arabicinput >= 100) {
         romanString = romanString + "C".repeat(arabicinput / 100);
         arabicinput = arabicinput % 100;
      }
      while (arabicinput >= 90) {
         romanString = romanString + "XC".repeat(arabicinput / 90);
         arabicinput = arabicinput % 90;
      }
      while (arabicinput >= 50) {
         romanString = romanString + "L".repeat(arabicinput / 50);
         arabicinput = arabicinput % 50;
      }
      while (arabicinput >= 40) {
         romanString = romanString + "XL".repeat(arabicinput / 40);
         arabicinput = arabicinput % 40;
      }
      while (arabicinput >= 10) {
         romanString = romanString + "X".repeat(arabicinput / 10);
         arabicinput = arabicinput % 10;
      }
      while (arabicinput >= 9) {
         romanString = romanString + "IX".repeat(arabicinput / 9);
         arabicinput = arabicinput % 9;
      }
      while (arabicinput >= 5) {
         romanString = romanString + "V".repeat(arabicinput / 5);
         arabicinput = arabicinput % 5;
      }
      while (arabicinput >= 4) {
         romanString = romanString + "IV".repeat(arabicinput / 4);
         arabicinput = arabicinput % 4;
      }
      while (arabicinput >= 1) {
         romanString = romanString + "I".repeat(arabicinput / 1);
         arabicinput = arabicinput % 1;
      }
      return romanString;
   }

   // Method handles and validates user input
   static int userInput() {
      System.out.print("Enter positive integer to convert: ");
      Scanner scanner = new Scanner(System.in);
      int input = 0;

      // Try-Catch to handle input errors.
      try {
         input = scanner.nextInt();
         // Handle if input smaller than 0 or larger than 3999
         if (input < 1 | input > 3999) {
            System.out.println("Input must be whole number between 1-3999");
            System.exit(0);
         }

         // Handle input not integer
      } catch (InputMismatchException e) {
         System.out.println("Input must be whole number between 1-3999");
         System.exit(0);
      }
      scanner.close();
      return input;
   }
}
