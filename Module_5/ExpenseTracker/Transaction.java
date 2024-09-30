package Module_5.ExpenseTracker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    
    private String date;
    private String description;
    private double amount;

        // No-argument constructor
        public Transaction() {
            this.date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
            this.description = "";
            this.amount = 0.0;
        }

        // Argument constructor
        public Transaction(String date, String description, double amount) {
            this.date = date;
            this.description = description;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }
    
        public void setDate(String date) {
            this.date = date;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public double getAmount() {
            return amount;
        }
    
        public void setAmount(double amount) {
            this.amount = amount;
        }
    
        @Override
        public String toString() {
            return "Date: " + date + "\nDescription: " + description + "\nAmount: $" + String.format("%.2f", amount);
        }
}
