/*
 * Anton DeCesare mod 3.2
 * This program generates an ArrayList filled with 50 random integers
 *  ranging from 1 to 20 and then removes any duplicate values.
 *  It uses a generic method to return a new ArrayList containing
 * only the unique elements from the original list.
 *
 */

import java.util.ArrayList;
import java.util.Random;

public class DeCesare_mod_3_2 {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill the list with 50 random integers from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Display original list
        System.out.println("Original List:");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display new list with duplicates removed
        System.out.println("\nList with Duplicates Removed:");
        System.out.println(uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
