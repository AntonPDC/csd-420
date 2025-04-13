/**
 * Anton DeCesare mod 5.2
 * This Java program reads a text file named collection_of_words.txt,
 *  extracts all unique words by removing duplicates and punctuation,
 *  and stores them in a HashSet. It then displays the words in both ascending (A–Z)
 *  and descending (Z–A) order.
 *
 **/

import java.io.*;
import java.util.*;

public class DeCesare_mod_5_2 {
    public static void main(String[] args) {
        // File name
        String filename = "collection_of_words.txt";

        // Use a HashSet to store words without duplicates
        HashSet<String> wordSet = new HashSet<>();

        try {
            // Read the file
            File file = new File(filename);
            // Read each word in the file
            try (Scanner input = new Scanner(file)) {
                // Read each word in the file
                while (input.hasNext()) {
                    String word = input.next();
                    // Remove punctuation and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        wordSet.add(word); // Add to set (duplicates are ignored)
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.");
            return;
        }

        // Convert HashSet to ArrayList to sort
        ArrayList<String> wordList = new ArrayList<>(wordSet);

        // Sort in ascending order
        Collections.sort(wordList);
        System.out.println("Words in A - Z order:");
        for (String word : wordList) {
            System.out.println(word);
        }

        // Sort in descending order
        Collections.sort(wordList, Collections.reverseOrder());
        System.out.println("\nWords in Z - A order:");
        for (String word : wordList) {
            System.out.println(word);
        }

        // Simple test output
        System.out.println("\nTotal unique words found: " + wordSet.size());
    }
}
