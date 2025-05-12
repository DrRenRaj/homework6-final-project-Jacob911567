import java.util.ArrayList;
import java.util.List;
// Library class to manage a collection of books
public class Library {
    // ArrayList to store books
    private List<Book> books = new ArrayList<>();
    // Add a book to the library if not in the list
    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                return false; // Book already exists
            }
        }
        books.add(book);
        return true; // Book added successfully
    }
    // Remove a book from the library by ISBN
    public boolean removeBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                books.remove(b);
                return true; // Book removed successfully
            }
        }
        return false; // Book not found
    }
    // Show all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
    // Search for a book by title
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book b: books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(b);
            }
        }
        return results; // Return matching books
    }
    // Search for a book by author
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(b);
            }
        }
        return results; // Return matching books
    }
    // Check out book by ISBN
    public boolean checkOutBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn) && b.isAvailable()) {
                b.setAvailable(false);
                return true; // Book checked out successfully
            }
        }
        return false; // Book not available
    }
    // Return book by ISBN
    public boolean returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn) && !b.isAvailable()) {
                b.setAvailable(true);
                return true; //Book returned successfully
            }
        }
        return false; // Book not found or checked out
    }
}
