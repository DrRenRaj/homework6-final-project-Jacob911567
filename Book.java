
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor to initialize book details
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }
    // Getters and Setters
    // Title
    public String getTitle() {
        return title;
    }
    // Author
    public String getAuthor() {
        return author;
    }
    // ISBN
    public String getIsbn() {
        return isbn;
    }
    // Availability
    public boolean isAvailable() {
        return isAvailable;
    }
    // Setter Availability
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    // Return book details as a string
    public String toString() {
        String status = isAvailable ? "Available" : "Checked Out";
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", " + status;
    }
    

}
