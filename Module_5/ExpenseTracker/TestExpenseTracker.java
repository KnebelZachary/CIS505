package Module_5.ExpenseTracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true; 
        while (continueProgram) {
            displayMenu();
            int choice = ValidatorIO.getInt(sc, "Enter your choice: ");
            switch (choice) {
                case 1:
                    displayAllTransactions();
                    break;
                case 2:
                    addNewTransactions(sc);
                    break;
                case 3:
                    displayTotalExpenses();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            continueProgram = ValidatorIO.getInt(sc, "Do you want to continue? (1 for yes, 0 for no): ") == 1;
        }
        sc.close();
    }

    public static void displayMenu() {
        System.out.println("1. View all transactions");
        System.out.println("2. Add new transactions");
        System.out.println("3. View total expenses");
    }

    public static void displayAllTransactions() throws IOException {
        ArrayList<Transaction> transactions = TransactionIO.findAll();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void addNewTransactions(Scanner sc) throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        boolean addMore = true;
        while (addMore) {
            String date = ValidatorIO.getString(sc, "Enter date (MM-dd-yyyy): ");
            String description = ValidatorIO.getString(sc, "Enter description: ");
            double amount = ValidatorIO.getDouble(sc, "Enter amount: ");
            transactions.add(new Transaction(date, description, amount));

            addMore = ValidatorIO.getInt(sc, "Add another transaction? (1 for yes, 0 for no): ") == 1;
        }
        TransactionIO.bulkInsert(transactions);
    }

    public static void displayTotalExpenses() throws IOException {
        ArrayList<Transaction> transactions = TransactionIO.findAll();
        double total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        System.out.printf("Total expenses: $%,.2f%n", total);
    }
}