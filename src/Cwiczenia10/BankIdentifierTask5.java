package Cwiczenia10;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class BankIdentifierTask5 {

    // Method to ask the user for the first three digits of the account number
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first three digits of the account number: ");
        return scanner.nextLine().trim();
    }

    // Method to fetch data from a website
    private static String fetchDataFromUrl(String urlString) {
        StringBuilder data = new StringBuilder();
        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
        return data.toString();
    }

    // Method to find and print the bank name
    private static void findBankInfo(String bankCode, String data) {
        String[] lines = data.split("\n");
        boolean bankFound = false;

        for (String line : lines) {
            if (line.startsWith(bankCode)) {
                // Bank code is at the start of the line, followed by spaces and the bank name
                String bankName = line.substring(10).trim(); // Adjust based on actual format
                System.out.println("Bank Code: " + bankCode);
                System.out.println("Bank Name: " + bankName);
                bankFound = true;
                break;
            }
        }

        if (!bankFound) {
            System.out.println("Bank not found for the provided code.");
        }
    }

    public static void main(String[] args) {
        String bankCode = getUserInput();

        // Validate the user input
        if (bankCode.matches("\\d{3}")) { // Check if input has exactly 3 digits
            String url = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";
            String data = fetchDataFromUrl(url);

            // Check if data was successfully fetched
            if (!data.isEmpty()) {
                findBankInfo(bankCode, data);
            } else {
                System.out.println("Failed to fetch bank data from the website.");
            }
        } else {
            System.out.println("Invalid input. Please enter exactly three digits.");
        }
    }
}
