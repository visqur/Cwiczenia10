import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandlingTask2 {
    public static void main(String[] args) {
        int byteData;

        // Using try-with-resources to handle automatic resource management
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Bartek\\IdeaProjects\\LAB6_2\\plik.txt")) {
            // Reading bytes from the file until the end
            do {
                byteData = fis.read(); // Reading byte from the file
                if (byteData != -1) {
                    System.out.println((char) byteData); // Printing the byte as a character
                }
            } while (byteData != -1); // Loop until end of file

        } catch (FileNotFoundException e) {
            System.out.println("File not found at the specified path.");
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file.");
        }
    }
}