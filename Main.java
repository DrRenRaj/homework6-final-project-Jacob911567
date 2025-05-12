/*
Name: Jacob Quaintance
Date: 5/10/2025
Class: CS-1050
Assignment: Homework 6
*/


import java.util.List;
import java.util.Scanner;
// Main class to run the library system
// Console menu for user interaction

public class Main {
    public static void main(String[] args) {
        Library library = new Library(); //Create a library instance
        Scanner scanner = new Scanner(System.in); // User input
        boolean exit = false; // Control for menu loop

        // Loop for menu
        while (!exit) {
            System.out.println("\nLibrary Managment System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Check Out Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.println("Choose an option: ");

            String choice = scanner.nextLine().trim(); // Get user choice
            switch (choice) {
                case "1": // add a new book
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    if (library.addBook(book)) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("ISBN already exists. ");
                    }
                    break;
                case "2": // Remove a book by ISBN
                    System.out.println("Enter ISBN of the book to remove: ");
                    if (library.removeBook(scanner.nextLine())) {
                        System.out.println("Book removed successfully. ");
                    } else {
                        System.out.println("Book not found. ");
            }
                     break;
                case "3": // Display all books
                    library.displayAllBooks();
                    break;
                case "4": //Search by title
                    System.out.println("Enter book title: ");
                    List<Book> byTitle = library.searchByTitle(scanner.nextLine());
                    if (byTitle.isEmpty()) {
                        System.out.println("No matches found. ");
                    } else {
                        for (Book b : byTitle) {
                            System.out.println(b);
                        }
                    }
                    break;
                case "5": // Search by author
                    System.out.println("Enter author name: ");
                    List<Book> byAuthor = library.searchByAuthor(scanner.nextLine());
                    if (byAuthor.isEmpty()) {
                        System.out.println("No matches found. ");
                    } else {
                        for (Book b : byAuthor) {
                            System.out.println(b);
                        }
                    }
                    break;
                case "6": // Check out a book
                    System.out.println("Enter ISBN to check out: ");
                    if (library.checkOutBook(scanner.nextLine())) {
                        System.out.println("Book Checked out successfully. ");
                    } else {
                        System.out.println("Book not available. ");
                    }
                    break;
                    case "7": // Return a book
                    System.out.println("Enter ISBN to return: ");
                    if (library.returnBook(scanner.nextLine())) {
                        System.out.println("Returned successfully. ");
                    } else {
                        System.out.println("Book not checked out or not found. ");
                    }
                    break;
                case "8": // Exit
                    exit = true;
                    System.out.println("Exiting the system. ");
                    break;
                default: // Handle invalid options
                    System.out.println("Invalid option. Please try again. ");
            }
        }
        scanner.close(); // Close scanner before exiting
    }
}