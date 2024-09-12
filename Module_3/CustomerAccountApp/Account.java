package Module_3.CustomerAccountApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    
    private double balance = 200;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt){
        balance += amt;
    }

    public void withdraw(double amt){
        if (balance >= amt) {
            balance -= amt;
        } else {
            System.out.println("\nInsufficient balance.");
        }
    }

    public void displayMenu(){
        System.out.print("\nAccount Menu \nEnter <D/d> for deposit \nEnter <W/w> for withdraw \nEnter <B/b> for balance \n  Enter option>: ");
    }

    public String getTransactionDate(){
        DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(formatPattern);
    }
}
