/*
* DeCesare mod 6.2
* This program implements bubble sort using two generic methods:
* one with the Comparable interface,
* and another with the Comparator interface.
* It sorts arrays of generic types either by natural order or using a custom comparison logic.
*/






import java.util.Comparator;

public class DeCesare_mod_6_2 {

    // Method 1: Sorts using the natural ordering (Comparable)
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;

        // Outer loop controls the number of passes through the array
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            // Inner loop compares adjacent elements and swaps if out of order
            for (int j = 0; j < list.length - 1 - i; j++) {
                // If current element is greater than the next, swap them
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                }
            }

            // Optimization: if no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }

    // Method 2: Sorts using a custom comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;

        // Same bubble sort logic, but using the provided comparator to determine order
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - 1 - i; j++) {
                // Use comparator to check order instead of natural compareTo
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; // Exit early if no swaps were made
        }
    }

    // Main method for testing both sorting methods
    public static void main(String[] args) {
        // Test 1: Using Comparable (Integer array)
        Integer[] numbers = {5, 3, 8, 2, 1};
        bubbleSort(numbers); // Sort using natural order
        System.out.println("Sorted using Comparable:");
        for (int num : numbers) {
            System.out.print(num + " "); // Print sorted array
        }

        System.out.println("\n");

        // Test 2: Using Comparator (String array)
        String[] names = {"Zoe", "Alice", "Eve", "Bob"};
        bubbleSort(names, Comparator.naturalOrder()); // Sort using comparator
        System.out.println("Sorted using Comparator:");
        for (String name : names) {
            System.out.print(name + " "); // Print sorted array
        }
    }
}
