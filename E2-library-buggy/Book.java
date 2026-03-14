// Book.java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }
    
    // BUG 1: No hay getters/setters para todos los campos
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    // Faltan getIsbn() y isAvailable()
    
    public void borrow() {
        if (!available) {
            System.out.println("ERROR: El libro ya está prestado");
            return;
        }
        available = false;
    }
    
    public void returnBook() {
        if (available) {
            System.out.println("ERROR: El libro ya está disponible");
            return;
        }
        available = true;
    }
}
