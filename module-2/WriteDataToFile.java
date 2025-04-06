/*
 * Anton DeCesare mod 2.2
 * This program creates and stores two arrays—one containing five random integers
 *  and the other containing five random double values. It writes both arrays to a
 *  file named DeCesare_datafile.dat. If the file does not exist, it is created;
 *  if it does exist, the new data is appended to the end of the file. This allows multiple entries to be saved over time.
 *
 */



import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteDataToFile {
    public static void main(String[] args) {
        String filename = "DeCesare_datafile.dat";
        Random rand = new Random();

        try (FileWriter writer = new FileWriter(filename, true)) { // 'true' enables appending
            writer.write("Integers: ");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100); // Random int between 0 and 99
                writer.write(randomInt + " ");
            }

            writer.write("\nDoubles: ");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100; // Random double between 0 and 100
                writer.write(String.format("%.2f ", randomDouble));
            }

            writer.write("\n\n"); // Add space between entries
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
