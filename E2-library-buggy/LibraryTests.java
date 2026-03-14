import org.junit.Test;
import static org.junit.Assert.*;


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
}