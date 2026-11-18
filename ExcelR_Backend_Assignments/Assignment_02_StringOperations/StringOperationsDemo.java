import java.util.Scanner;

public class StringOperationsDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== JAVA STRING OPERATIONS =====");

        // 1. Extract Substring
        System.out.println("\n--- SUBSTRING OPERATION ---");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Input validation
        while (input.trim().isEmpty()) {
            System.out.println("Input cannot be empty!");
            System.out.print("Enter a valid string: ");
            input = sc.nextLine();
        }

        System.out.println("Your string: " + input);
        System.out.println("String length: " + input.length());

        int start = -1;
        int end = -1;

        // Read and validate starting index
        while (true) {
            System.out.print("Enter starting index: ");

            try {
                start = Integer.parseInt(sc.nextLine());

                if (start >= 0 && start < input.length()) {
                    break;
                } else {
                    System.out.println("Invalid starting index!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        // Read and validate ending index
        while (true) {
            System.out.print("Enter ending index: ");

            try {
                end = Integer.parseInt(sc.nextLine());

                if (end > start && end <= input.length()) {
                    break;
                } else {
                    System.out.println("Invalid ending index!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        String result = input.substring(start, end);

        System.out.println("Extracted Substring: " + result);

        // 2. Split a Sentence
        System.out.println("\n--- SPLIT SENTENCE OPERATION ---");

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        while (sentence.trim().isEmpty()) {
            System.out.println("Sentence cannot be empty!");
            System.out.print("Enter a valid sentence: ");
            sentence = sc.nextLine();
        }

        String[] words = sentence.trim().split("\\s+");

        System.out.println("\nWords in the sentence:");

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". " + words[i]);
        }

        System.out.println("\nTotal number of words: " + words.length);

        System.out.println("\n===== PROGRAM COMPLETED =====");

        sc.close();
    }
}
