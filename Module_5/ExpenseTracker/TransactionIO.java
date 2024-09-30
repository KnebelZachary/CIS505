package Module_5.ExpenseTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    // Bulk insert transactions into file
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        try {
            if (file.exists()) {
                output = new PrintWriter(new FileOutputStream(file, true));
            } else {
                output = new PrintWriter(file);
            }
            for (Transaction transaction : transactions) {
                output.println(transaction.getDate());
                output.println(transaction.getDescription());
                output.println(transaction.getAmount()); // Save only the number without formatting
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    // Find all transactions from the file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        if (!file.exists()) return transactions;

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String date = input.nextLine();
            String description = input.nextLine();
            double amount = Double.parseDouble(input.nextLine());
            transactions.add(new Transaction(date, description, amount));
        }
        input.close();
        return transactions;
    }
}
