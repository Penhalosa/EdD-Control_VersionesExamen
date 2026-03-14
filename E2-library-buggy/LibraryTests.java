import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;


public class LibraryTests {
    @Test
    public void testAddDuplicateBook() {
        Library lib = new Library();
        Book b1 = new Book("Clean Code", "Robert Martin", "978-0132350884");
        Book b2 = new Book("Clean Code", "Robert Martin", "978-0132350884"); // duplicado

        lib.addBook(b1);
        lib.addBook(b2); // debería impedirse

        // Debug aquí para ver el estado interno
        // Esperado: solo 1 libro con ese ISBN
        assertEquals(1, lib.findAvailableBooks().size());
    }

    @Test
        public void testFindBookCaseInsensitive() {
        Library lib = new Library();
        lib.addBook(new Book("Clean Code", "Robert Martin", "978-0132350884"));

        Book found = lib.findBookByIsbn("clean code"); // distinto casing

        // Debug aquí para ver comparación
        assertNotNull(found); // debería encontrarlo
    }
    @Test
        public void testBorrowAlreadyBorrowed() {
        Book book = new Book("Clean Code", "Robert Martin", "978-0132350884");

        book.borrow(); // primera vez
        book.borrow(); // segunda vez → debería impedirse

        // Debug aquí para ver el estado interno
        assertFalse(book.isAvailable()); // debería seguir prestado
    }
    @Test
        public void testReturnAlreadyAvailable() {
        Book book = new Book("Clean Code", "Robert Martin", "978-0132350884");

        book.returnBook(); // ya está disponible
        book.returnBook(); // segunda vez → debería impedirse

        // Debug aquí para ver el estado interno
        assertTrue(book.isAvailable());
    }
    @Test
        public void testFindAvailableBooks() {
        Library lib = new Library();
        Book b1 = new Book("Clean Code", "Robert Martin", "978-0132350884");
        Book b2 = new Book("Design Patterns", "Gamma", "978-0201633610");

        lib.addBook(b1);
        lib.addBook(b2);

        b1.borrow(); // este NO debería aparecer como disponible

        // Debug aquí para ver el estado interno
        List<Book> available = lib.findAvailableBooks();

        assertEquals(1, available.size()); // debería haber solo 1 disponible
    }
    @Test
        public void testRemoveBookMissing() {
        Library lib = new Library();
        Book book = new Book("Clean Code", "Robert Martin", "978-0132350884");

        lib.addBook(book);

        // Debug aquí: no existe removeBook()
        // Este test debe fallar al compilar
        // lib.removeBook(b);

        assertEquals(1, lib.findAvailableBooks().size());
    }
    @Test
    public void testMissingGetters() {
    Book book = new Book("Clean Code", "Robert Martin", "978-0132350884");

    // Debug aquí: estos métodos NO existen
    // b.getIsbn();
    // b.isAvailable();

    assertNotNull(book.getTitle()); // único getter disponible
    }

}