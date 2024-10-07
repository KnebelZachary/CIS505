package Module_6.ComposerApp;

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    public static void main(String[] args) {
        MemComposerDao composerDao = new MemComposerDao();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Composer App Menu:");
            System.out.println("1. View all composers");
            System.out.println("2. Find composer by ID");
            System.out.println("3. Add a new composer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    
                    List<Composer> composers = composerDao.findAll();
                    for (Composer composer : composers) {
                        System.out.println(composer);
                        System.out.println();  
                    }
                    break;

                case 2:
                    
                    System.out.print("Enter composer ID: ");
                    int id = scanner.nextInt();
                    Composer composer = composerDao.findBy(id);
                    if (composer != null) {
                        System.out.println(composer);
                    } else {
                        System.out.println("Composer not found.");
                    }
                    break;

                case 3:
                    
                    System.out.print("Enter composer ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter composer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter composer genre: ");
                    String genre = scanner.nextLine();

                    Composer newComposer = new Composer(newId, name, genre);
                    composerDao.insert(newComposer);
                    System.out.println("Composer added.");
                    break;

                case 4:
                   
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}

