package Cwiczenia10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopyTask3 {
    public static void main(String[] args) {
        // Paths for input and output files
        String inputFilePath = "C:\\Users\\Bartek\\IdeaProjects\\LAB6_2\\plik.txt";
        String outputFilePath = "C:\\Users\\Bartek\\IdeaProjects\\LAB6_2\\plik_copy.txt";

        // Using try-with-resources to handle automatic resource management
        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath)) {

            int byteData;

            // Reading bytes from the input file and writing to the output file
            while ((byteData = fis.read()) != -1) {
                // Replace spaces (' ') with hyphens ('-')
                if (byteData == ' ') {
                    fos.write('-');
                } else {
                    fos.write(byteData);
                }
            }

            System.out.println("File copied successfully with spaces replaced by hyphens.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred while processing the file: " + e.getMessage());
        }
    }
}
