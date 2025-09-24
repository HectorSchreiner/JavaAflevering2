import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter line to check: ");
        String input = scanner.nextLine();
        
        testPalindrome(input);  
    }

    public static void testPalindrome(String input) {
        String originalInput = input;
        
        // Regex to remove all other characters than a-z. 
        input = input.toLowerCase().replaceAll("[^a-z]",""); 

        // Reverse the string, and convert to lowercase.
        String reverseInput = new StringBuilder(input).reverse().toString().toLowerCase();
        
        if (reverseInput.equals(input)) {
            System.out.println("\"" + originalInput + "\" is a palindrome!");
        } else {
            System.out.println("\"" + originalInput + "\" is not a palindrome!");
        }
    }
}