import java.util.Scanner;

public class StringReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter a string to reverse:");
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Reverse the string
        String reversed = reverseString(input);

        // Display the reversed string
        System.out.println("Reversed string: " + reversed);
    }

    // Method to reverse a string
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters at left and right indices
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }

        // Convert the char array back to a string
        return new String(charArray);
    }
}
