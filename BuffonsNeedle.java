
/* Marcus Jensen, Hector Schousbo
20100 Indledende programmering
The following program estimates pi via. Buffons Needle algorithm 
*/

/*
we need a scanner object, random numbers 
and the InputMismatchException type (for error handling). 
*/
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BuffonsNeedle {
    public static void main(String[] args) {
        System.out.println(sim(getInput()));
    }

    // This method takes iterations as an input, and returns an approximation of Pi
    /*
     * Loops iterations amm, and generates a needle at a random position between 0-dist
     * It then gives the needle a random angle, and the upper position is calculated.
     * Then it is checked if this position is greater or eq to the dist.
     * The method returns an approximation of Pi as a double
     */
    static double sim(int iterations) {
        Random rnd = new Random();
        int successCounter = 0;

        int needleSize = 1;
        int dist = needleSize * 2;

        for (int i = 0; i < iterations; i++) {
            double randomLowerAngle = Math.PI * rnd.nextDouble();
            double randomPosition = rnd.nextDouble() * dist;
            double upperPosition = Math.sin(randomLowerAngle) * needleSize  + randomPosition;          

            if (upperPosition >= dist) {
                successCounter++;
            }
        }

        return (double) iterations / (double) successCounter;
    }

    // Get input from the user, and handle input errors.
    static int getInput() {
        System.out.print("Enter ammount of iterations: ");
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        // Try-Catch to handle input errors.
        try {
            input = scanner.nextInt();

            if (input<0) {
                System.err.println("Input should be a positive whole number!");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("The input should be a number in the range: [0, "+Integer.MAX_VALUE+"]");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Oops an error occured: " + e);
            System.exit(0);
        }

        scanner.close();
        return input;
    }
}
