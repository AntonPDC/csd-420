/*
 * Anton DeCesare mod 2.2
 * This program reads the contents of DeCesare_datafile.dat
 *  and displays the data line by line on the screen.
 *  It uses a scanner to read from the file and prints each line,
 *  allowing the user to see all previously written entries.
 *  If the file is not found, the program handles the error and notifies the user.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDataFromFile {
    public static void main(String[] args) {
        String filename = "DeCesare_datafile.dat";

        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("Reading data from file:\n");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
