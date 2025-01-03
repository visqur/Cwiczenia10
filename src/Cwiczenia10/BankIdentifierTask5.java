package Cwiczenia10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BankIdentifierTask5 {

    // Method to read the first three digits from the user
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first three digits of the bank account number: ");
        return scanner.nextLine().trim();
    }

    // Method to find and display the bank information
    private static void findBankInfo(String bankCode) {
        String filePath = "plewibnra.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean bankFound = false;

            while ((line = reader.readLine()) != null) {
                // Assuming the file has a specific format where the bank code and name are in known positions
                // Adjust the indices based on the actual file format
                if (line.startsWith(bankCode)) {
                    String bankName = line.substring(10).trim(); // Adjust index as per file structure
                    System.out.println("Bank Code: " + bankCode);
                    System.out.println("Bank Name: " + bankName);
                    bankFound = true;
                    break;
                }
            }

            if (!bankFound) {
                System.out.println("No bank found with the provided code.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("The bank data file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String bankCode = getUserInput();
        if (bankCode.length() == 3 && bankCode.matches("\\d{3}")) {
            findBankInfo(bankCode);
        } else {
            System.out.println("Invalid input. Please enter exactly three digits.");
        }
    }
}
