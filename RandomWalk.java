/* Marcus Jensen, Hector Schousbo
20100 Indledende programmering og software teknologi
This program takes a positive whole number as input maps it on a grid.
The program then walks randomly either North, South, East or west. 
Until it walks out of the grid. The steps are drawn as the program is runnin.
*/

/*
we need a scanner object, random numbers 
and the InputMismatchException type (for error handling). 
*/
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class RandomWalk {
    public static void main(String[] args) {
        int gridSize = userInput();
        prepareMapScale(gridSize);
        walkLoop(gridSize);
    }

    // prepare x,y map scale to -grid - 0.5, grid+ 0.5
    static void prepareMapScale(int grid) {

        // adding and subtracting 0.5, making sure that edge of circle is edge of grid.
        StdDraw.setXscale((double) grid - 2 * grid - 0.5, (double) grid + 0.5);
        StdDraw.setYscale((double) grid - 2 * grid - 0.5, (double) grid + 0.5);
    }

    // This method handles the continous walking and when it walks out of the grid.
    static void walkLoop(int grid) {
        int walkCount = 0;
        int[] coords = new int[2]; // make array where index 0 is x coord and index 1 is y coord.
        boolean continueWalk = true;

        System.out.println("Position = (" + coords[0] + "," + coords[1] + ")"); // print (0,0) coord
        StdDraw.point(coords[0], coords[1]);                                    // Draw (0,0)

        while (continueWalk) {
            coords = handleRandom(coords);
            System.out.println("Position = (" + coords[0] + "," + coords[1] + ")");
            walkCount = walkCount + 1;

            // Check if walk is out of grid.
            if (Math.abs(coords[0]) > grid | Math.abs(coords[1]) > grid) {
                continueWalk = false;
            }
        }
        System.out.println("Total number of steps = " + walkCount);
    }

    // Method handles how the program randomly chooses which direction to walk.
    static int[] handleRandom(int[] array) {
        Random random = new Random();
        int directionNumber = random.nextInt(4);
        switch (directionNumber) {
            case 0: // Go North
                array[0] = array[0] + 1;
                break;
            case 1: // Go South
                array[0] = array[0] - 1;
                break;
            case 2: // Go East
                array[1] = array[1] + 1;
                break;
            case 3: // Go West
                array[1] = array[1] - 1;
                break;
        }
        StdDraw.filledCircle((double) array[0], (double) array[1], (double) 0.5); // Draws point at x,y
        return array;
    }

    // Method handles and validates user input
    static int userInput() {
        System.out.print("Enter size of grid: ");
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        try {
            input = scanner.nextInt();
            // Handle if input smaller than 1
            if (input < 1) {
                System.out.println("Grid must be whole number bigger than 0");
                System.exit(0);
            }

        // Handle input not integer or input over max integer size
        } catch (InputMismatchException e) {
            System.out.println("Grid must be whole number between 0 and " + Integer.MAX_VALUE);
            System.exit(0);
        }

        scanner.close();
        return input;
    }
}