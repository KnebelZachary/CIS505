package Module_3.CustomerAccountApp;

import java.util.Scanner;

public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        boolean exit = false;

        System.out.print("Welcome to the Customer Account App \n \nEnter a customer ID:\n  ex: 1007, 1008, 1009>: ");
        int customerID = scanner.nextInt();
        Customer currentCustomer = CustomerDB.getCustomer(customerID);

        do {
            account.displayMenu();
            String option  = scanner.next();

            switch (option.toLowerCase()) {
                case "d":
                    System.out.print("\nEnter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case "w":
                    System.out.print("\nEnter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case "b":
                    System.out.printf("\nAccount Balance: $%,6.2f\n", account.getBalance());
                    break;
                default:
                    System.out.println("\nError: Invalid Option");
                    break;
            }

            System.out.print("\nWould you like to continue? (y/n): ");
            String response = scanner.next();
            if (response.toLowerCase().equals("n")) {
                exit = true;
            }
        } while (!exit);

        // Display customer details and final balance
        System.out.println("\n--Customer Details--");
        System.out.println(currentCustomer.toString());
        System.out.printf("\nBalance as of %s: $%,6.2f\n\n", account.getTransactionDate(), account.getBalance());
    }
}

