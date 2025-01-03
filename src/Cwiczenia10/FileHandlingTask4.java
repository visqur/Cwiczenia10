package Cwiczenia10;

// Main class to execute the program
public class FileHandlingTask4 {
    public static void main(String[] args) {
        DataManagement dataManager = new DataManagement();

        // Read data from the user
        String userData = dataManager.readData();

        // Write data to the file
        dataManager.writeDataToFile(userData);

        // Read data from the file and display it
        dataManager.readDataFromFile();
    }
}
