import java.io.*;
import java.util.Scanner;

// Class for managing data operations
class DataManagement {

    private final String filePath = "C:\\Users\\Bartek\\IdeaProjects\\LAB6_2\\user_data.txt";

    // Method to read data from the user
    public String readData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        return scanner.nextLine();
    }

    // Method to write data to a file
    public void writeDataToFile(String data) {
        try (FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(data);
            bufferedWriter.newLine(); // Move to the next line after writing

        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read data from a file and display it on the console
    public void readDataFromFile() {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            System.out.println("Data from the file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        }
    }
}