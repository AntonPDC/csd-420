/**
 * Anton DeCesare mod 8.2
 * This program demonstrates multithreading in Java by using three threads
 * to generate and output 10,000 characters each—letters, digits, and symbols.
 * It then verifies the output using simple manual tests.
 */

import java.util.Random;

public class DeCesare_mod_8_2 {

    private static final int COUNT = 10000;
    private static final StringBuilder letters = new StringBuilder();
    private static final StringBuilder digits = new StringBuilder();
    private static final StringBuilder symbols = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        // Step 1: Create and start three threads to generate each type of character
        Thread letterThread = new Thread(() -> generateLetters());
        Thread digitThread = new Thread(() -> generateDigits());
        Thread symbolThread = new Thread(() -> generateSymbols());

        // Step 2: Start the threads (they run concurrently)
        letterThread.start();
        digitThread.start();
        symbolThread.start();

        // Step 3: Wait for all threads to complete before proceeding
        letterThread.join();
        digitThread.join();
        symbolThread.join();

        // Step 4: Print a sample of each character group for confirmation
        System.out.println("Sample Letters: " + letters.substring(0, 50) + "...");
        System.out.println("Sample Digits:  " + digits.substring(0, 50) + "...");
        System.out.println("Sample Symbols: " + symbols.substring(0, 50) + "...");

        // Step 5: Run manual tests to validate the results
        runManualTests();
    }

    // Generate 10,000 random lowercase letters and store them in the 'letters' StringBuilder
    private static void generateLetters() {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char c = (char) ('a' + rand.nextInt(26));
            synchronized (letters) {
                letters.append(c);
            }
        }
    }

    // Generate 10,000 random digits ('0' to '9') and store them in the 'digits' StringBuilder
    private static void generateDigits() {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char c = (char) ('0' + rand.nextInt(10));
            synchronized (digits) {
                digits.append(c);
            }
        }
    }

    // Generate 10,000 random symbols from the given set and store them in the 'symbols' StringBuilder
    private static void generateSymbols() {
        char[] chars = {'!', '@', '#', '$', '%', '&', '*'};
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char c = chars[rand.nextInt(chars.length)];
            synchronized (symbols) {
                symbols.append(c);
            }
        }
    }

    // Run manual tests to verify correct character counts and types
    private static void runManualTests() {
        System.out.println("\nRunning manual tests...");

        // Test 1: Ensure all 10,000 characters in 'letters' are between 'a' and 'z'
        boolean lettersValid = letters.length() == COUNT && letters.chars().allMatch(c -> c >= 'a' && c <= 'z');

        // Test 2: Ensure all 10,000 characters in 'digits' are between '0' and '9'
        boolean digitsValid = digits.length() == COUNT && digits.chars().allMatch(c -> c >= '0' && c <= '9');

        // Test 3: Ensure all 10,000 characters in 'symbols' are in the allowed set
        boolean symbolsValid = symbols.length() == COUNT && symbols.chars().allMatch(c -> "!@#$%&*".indexOf(c) != -1);

        // Output test results
        System.out.println("Letters Test Passed: " + lettersValid);
        System.out.println("Digits Test Passed:  " + digitsValid);
        System.out.println("Symbols Test Passed: " + symbolsValid);

        // Show total characters generated
        int total = letters.length() + digits.length() + symbols.length();
        System.out.println("Total Characters Generated: " + total);
    }
}
