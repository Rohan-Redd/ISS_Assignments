package filehandlingexample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NameModifying {

    public static void main(String[] args) {
        // Specify the text file names (Change the path accordingly)
        String inputFileName = "C:\\Users\\Adavelli Rohan Reddy\\Desktop\\ISS\\Java\\src\\filehandlingexample/input.txt";
        String outputFileName = "C:\\Users\\Adavelli Rohan Reddy\\Desktop\\ISS\\Java\\src\\filehandlingexample/output.txt";

        // Read from input.txt, display the name, and write the full name to output.txt
        readFileDisplayNameAndWriteToFile(inputFileName, outputFileName);
    }

    private static void readFileDisplayNameAndWriteToFile(String inputFileName, String outputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            // Read from input.txt (assuming it contains your name)
            String name = reader.readLine();

            // Display the name
            System.out.println("Read name from input.txt: " + name);

            String fullName = name + " Reddy Adavelli"; // Add your last name
            writer.write(fullName);
            writer.newLine();

            System.out.println("Full name written to output.txt: " + fullName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
