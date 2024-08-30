import java.util.Scanner;

public class FibonacciSequence {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueChecking = true;

        while (continueChecking) {
            try {
                int number = getNumberFromUser();
                checkAndPrintFibonacciStatus(number);

                continueChecking = shouldContinue(scanner);

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the scanner buffer
            }
        }
    }

    // Function to get a number from the user
    public static int getNumberFromUser() {
        System.out.print("Enter a number to check if it belongs to the Fibonacci sequence: ");
        return scanner.nextInt();
    }

    // Function to check if a number belongs to the Fibonacci sequence and print the
    // result
    public static void checkAndPrintFibonacciStatus(int number) {
        if (isFibonacci(number)) {
            System.out.println(number + " belongs to the Fibonacci sequence.");
        } else {
            System.out.println(number + " does not belong to the Fibonacci sequence.");
        }
    }

    // Function to check if a number belongs to the Fibonacci sequence
    public static boolean isFibonacci(int number) {
        if (number < 0) {
            return false;
        }

        int previous = 0;
        int current = 1;

        // Generate Fibonacci sequence and check if the number belongs
        while (previous < number) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return previous == number;
    }

    // Function to ask the user if they want to check another number and return
    // their choice
    public static boolean shouldContinue(Scanner scanner) {
        char response;
        do {
            System.out.print("Do you want to check another number? (y/n): ");
            response = scanner.next().toLowerCase().charAt(0);
            if (response != 'y' && response != 'n') {
                System.out.println("Invalid response. Please enter 'y' for yes or 'n' for no.");
            }
        } while (response != 'y' && response != 'n');

        return response == 'y';
    }
}
