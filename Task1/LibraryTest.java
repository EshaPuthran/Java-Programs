package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Book book;

    @BeforeEach
    void setup() {
        library = new Library();
        book = new Book("Test Book", "Test Author", "111");
        library.addBook(book);
    }

    @Test
    void testIssueBook() throws Exception {
        library.issueBook("111");
        assertFalse(book.isAvailable(), "Book should not be available after issuing");
    }

    @Test
    void testReturnBook() throws Exception {
        library.issueBook("111");   // first issue the book
        library.returnBook("111");  // then return the book
        assertTrue(book.isAvailable(), "Book should be available after return");
    }

    @Test
    void testIsBookAvailableInitially() {
        assertTrue(book.isAvailable(), "Book should be available at the start");
    }

    @Test
    void testIssueAlreadyIssuedBookThrowsException() throws Exception {
        library.issueBook("111");
        assertThrows(ExceptionBookNotAvailable.class, () -> library.issueBook("111"));
    }

    @Test
    void testInvalidIsbnThrowsException() {
        assertThrows(BookNotFoundException.class, () -> library.issueBook("999"));
    }
}
