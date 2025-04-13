import java.io.*;
/**
 * Anton DeCesare mod 5.2
 * This program reads a file named "collection_of_words.txt" and extracts all unique words
 * by removing duplicates and punctuation, and stores them in a HashSet. It then displays the
 * words in both ascending (A–Z) and descending (Z–A) order.
 *
 */

public class DeCesare_mod_5_2_Test {
    public static void main(String[] args) {
        // Step 1: Create sample word file for testing
        createTestFile();

        // Step 2: Run the main program
        System.out.println("=== Running DeCesare_mod_5_2.java ===\n");
        DeCesare_mod_5_2.main(null);  // Call the main method directly
    }

    // Helper method to create the sample file
    public static void createTestFile() {
        String sampleText = "Apple banana! Banana, orange? apple. Grape; Orange grape.";
        try (PrintWriter writer = new PrintWriter("collection_of_words.txt")) {
            writer.println(sampleText);
        } catch (IOException e) {
            System.out.println("Failed to create test file.");
        }
    }
}
