// DeCesare mod 4.2
// This program compares how long it takes to go through a LinkedList using an iterator vs. using get(index).
// It tests the time using 50,000 elements and 500,000 elements and shows which method is faster.

import java.util.Iterator;
import java.util.LinkedList;

public class DeCesare_mod_4_2 {

    public static void main(String[] args) {
        // Test with 50,000 elements
        System.out.println("Testing with 50,000 elements:");
        testTraversalTime(50000);

        // Test with 500,000 elements
        System.out.println("\nTesting with 500,000 elements:");
        testTraversalTime(500000);
    }

    // Method to test traversal time
    public static void testTraversalTime(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Step 1: Fill the LinkedList with numbers from 0 to size - 1
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Step 2: Use an iterator to go through each element
        long startIterator = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // Move to next item
        }
        long endIterator = System.nanoTime();
        System.out.println("Time using iterator: " + (endIterator - startIterator) / 1_000_000 + " ms");

        // Step 3: Use get(index) to access each item one by one
        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // This is slower for LinkedList
        }
        long endGet = System.nanoTime();
        System.out.println("Time using get(index): " + (endGet - startGet) / 1_000_000 + " ms");
    }
}
