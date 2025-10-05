/* Marcus Jensen, Hector Schreiner
20100 Indledende programmering og software teknologi
This program takes a String input, and tests if its a palindrome
*/

// we need a scanner object
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter line to check: ");
        String input = scanner.nextLine();
        
        testPalindrome(input);  
        scanner.close();
    }

    public static void testPalindrome(String input) {
        String originalInput = input;
        
        // Regex to remove all other characters than a-z. 
        String parsed_input = input.toLowerCase().replaceAll("[^a-z]",""); 

        // Handle strange parsing cases, where no legitimate (a-z) characters where found (this should not be seen as a palindrome)
        if (parsed_input.equals("")) {
            System.err.println("\"" + input + "\"" + " Could not be parsed.");
            System.exit(0);
        }

        String reverseInput = new StringBuilder(parsed_input).reverse().toString();
        
        if (reverseInput.equals(parsed_input)) {
            System.out.println("\"" + originalInput + "\" is a palindrome!");
        } else {
            System.out.println("\"" + originalInput + "\" is not a palindrome!");
        }
    }
}