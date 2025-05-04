public class DeCesare_mod_6_2_TEST1 {

    public static void main(String[] args) {
        // Define a test array and its expected sorted result
        Integer[] testArray = {9, 4, 7, 1, 3};
        Integer[] expected = {1, 3, 4, 7, 9};

        // Call the bubbleSort method from your main class
        DeCesare_mod_6_2.bubbleSort(testArray);

        // Check if the result matches the expected array
        boolean passed = true;
        for (int i = 0; i < testArray.length; i++) {
            if (!testArray[i].equals(expected[i])) {
                passed = false;
                break;
            }
        }

        // Output the result of the manual test
        if (passed) {
            System.out.println("Test Passed: The array was sorted correctly.");
        } else {
            System.out.println("Test Failed: The array was not sorted as expected.");
        }
    }
}
