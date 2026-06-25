/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;
import java.util.Scanner;
public class menu {

    // Fields ----------------------------------------------------------------------------------------------------------
    private static final Scanner s = new Scanner(System.in);
    private static final library l = new library();

    // Main Method ----------------------------------------------------------------------------------------------------------
    static void main(String[] args) {
        runMenu();
        s.close();
    }

    // Concrete Static methods (shared by all items) --------------------------------------------------------------------------
    private static void printMenu() {
        System.out.print("===== Library Lending System =====\n" +
                "1. Add Item \n" +
                "2. Add Member \n" +
                "3. Borrow Item \n" +
                "4. Return Item \n" +
                "5. List Catalog \n" +
                "6. Report \n" +
                "7. Exit \n");
    }

    private static void runMenu() {
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    addItemMenu();
                    break;
                case 2:
                    addMemberMenu();
                    break;
                case 3:
                    borrowItemMenu();
                    break;
                case 4:
                    returnItemMenu();
                    break;
                case 5:
                    library.listCatalog();
                    break;
                case 6:
                    library.printReport();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }
        }
    }

    private static void addItemMenu() {
        try {
            boolean running = true;
            while (running) {
                System.out.println("Choose item type:");
                System.out.println("1. Book");
                System.out.println("2. Magazine");
                System.out.println("3. DVD");

                System.out.print("Enter item type: ");
                int typeChoice = s.nextInt();
                switch (typeChoice) {
                    case 1: {
                        System.out.print("Enter title: ");
                        String title = s.next();
                        System.out.print("Enter author: ");
                        String author = s.next();
                        System.out.print("Enter pages: ");
                        int pages = s.nextInt();
                        book b = new book(title, author, pages);
                        l.addItem(b);
                        System.out.println("Book added successfully. ID: " + b.getId());
                        running = false;
                        break;
                    }
                    case 2: {
                        System.out.print("Enter title: ");
                        String title = s.next();
                        System.out.print("Enter issue number: ");
                        int issueNumber = s.nextInt();
                        magazine m = new magazine(title, issueNumber);
                        l.addItem(m);
                        System.out.println("Magazine added successfully. ID: " + m.getId());
                        running = false;
                        break;
                    }
                    case 3: {
                        System.out.print("Enter title: ");
                        String title = s.next();
                        System.out.print("Enter runtime in minutes: ");
                        int runtimeMinutes = s.nextInt();
                        dvd d = new dvd(title, runtimeMinutes);
                        l.addItem(d);
                        System.out.println("DVD added successfully. ID: " + d.getId());
                        running = false;
                        break;
                    }
                    default:
                        System.out.println("Invalid item type, please choose form 1 - 3");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add item: " + e.getMessage());
        }
    }

    private static void addMemberMenu() {
        try {
            System.out.print("Enter member name: ");
            String name = s.next();
            System.out.print("Enter max allowed items: ");
            int maxAllowed = s.nextInt();

            member m = new member(name, maxAllowed);
            l.addMember(m);
            System.out.println("Member added successfully. ID: " + m.getMemberId());
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add member: " + e.getMessage());
        }
    }

    private static void borrowItemMenu() {
        System.out.print("Enter member ID: ");
        String memberId = s.next();
        System.out.print("Enter item ID: ");
        String itemId = s.next();
        try {
            l.borrowItem(memberId, itemId);
        } catch (libraryException e) {
            System.out.println("Borrow failed: " + e.getMessage());
        }
    }

    private static void returnItemMenu() {
        System.out.print("Enter member ID: ");
        String memberId = s.next();
        System.out.print("Enter item ID: ");
        String itemId = s.next();
        try {
            l.returnItem(memberId, itemId);
        } catch (libraryException e) {
            System.out.println("Return failed: " + e.getMessage());
        }
    }
}