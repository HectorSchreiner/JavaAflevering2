import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BuffonsNeedle {
    public static void main(String[] args) {
        System.out.println(sim(getInput()));
    }

    static double sim(int iterations) {
        int len = 1;
        int dist = 2 * len;
        Random rnd = new Random();
        int successCounter = 0;

        for (int i = 0; i < iterations; i++) {
            double randomAngle = Math.PI * rnd.nextDouble();
            double randomDist = dist * rnd.nextDouble();

            if (randomDist + randomAngle <= dist) {
                successCounter++;
            }
        }

        return (double) iterations/ (double) successCounter;
    }

    static int getInput() {
        System.out.println("Enter ammount of iterations");
        Scanner scanner = new Scanner(System.in);
        int input = 0;

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
