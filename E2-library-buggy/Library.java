// Library.java
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
    if (findBookByIsbn(book.getIsbn()) != null) {
        System.out.println("ERROR: Libro duplicado por ISBN");
        return;
    }
    books.add(book);
    }
    
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }


    public Book findBookByIsbn(String isbn) {
    for (Book b : books) {
        if (b.getIsbn().equals(isbn)) {
            return b;
        }
    }
    return null;
}
    
    public List<Book> findAvailableBooks() {
    List<Book> availableBooks = new ArrayList<>();
    for (Book book : books) {
        if (book.isAvailable()) {
            availableBooks.add(book);
        }
    }
    return availableBooks;
}
    
    // BUG 8: Falta método para quitar libros
}
