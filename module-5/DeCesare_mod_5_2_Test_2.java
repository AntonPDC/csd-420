import java.io.*;
/**
 * Anton DeCesare mod 5.2
 * This program reads a file named "collection_of_words.txt" and extracts all unique words
 * by removing duplicates and punctuation, and stores them in a HashSet. It then displays the
 * words in both ascending (A–Z) and descending (Z–A) order.
 * This test file is designed to check the program's performance with a large number of repeated words.
 */

public class DeCesare_mod_5_2_Test_2 {
    public static void main(String[] args) {
        // Step 1: Create a large test file with many repeated words
        createTestFile();

        // Step 2: Run the main program
        System.out.println("=== Running DeCesare_mod_5_2.java with large repeated input ===\n");
        DeCesare_mod_5_2.main(null);  // Call the main method directly
    }

    // Helper method to generate a large test file
    public static void createTestFile() {
        try (PrintWriter writer = new PrintWriter("collection_of_words.txt")) {
            for (int i = 0; i < 10000; i++) {
                writer.print("apple banana orange apple banana orange ");
            }
            writer.println("kiwi grape mango");
        } catch (IOException e) {
            System.out.println("Failed to create test file.");
        }
    }
}
