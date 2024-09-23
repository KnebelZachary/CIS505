package Module_4.BowlingShopApp;

import java.util.Scanner;


public class TestBowlingShopApp {
    
    public static void displayMenu() {
        System.out.println("MENU OPTIONS");
        System.out.println("1. <b> Bowling Balls");
        System.out.println("2. <s> Bowling Shoes");
        System.out.println("3. <a> Bowling Bags");
        System.out.println("4. <x> Exit");
        System.out.println("Please choose an option:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equals("x")) {
            displayMenu();
            option = scanner.next();
            if (option.equals("x")) {
                System.out.println("Exiting the shop.");
                break;
            }

            GenericQueue<Product> products = ProductDB.getProducts(option);
            while (products.size() > 0) {
                Product product = products.dequeue();
                System.out.println(product);
            }
        }

        scanner.close();
    }

}
