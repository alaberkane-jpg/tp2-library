package library;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
public class LibraryTest {

    private Library library;
    private Book book;
    private Copy copy;
    private Member member;

    @BeforeEach
    public void setUp() {
        library = new Library();

        book = new Book("9781234567890", "Java Programming", 2024);
        copy = new Copy(1, book);
        member = new Member(101, "Ahmed");

        library.addBook(book);
        library.addCopy(copy);
        library.addMember(member);
    }

    @Test
    public void testAddBook() {
        assertEquals(1, library.getBooks().size());
        assertEquals("Java Programming", library.getBooks().get(0).getTitle());
    }

    @Test
    public void testLendCopy() {
        Loan loan = library.lendCopy(1, 101, LocalDate.of(2026, 11, 5));

        assertNotNull(loan);
        assertFalse(copy.isAvailable());
        assertTrue(loan.isOpen());
    }

    @Test
    public void testReturnCopy() {
        library.lendCopy(1, 101, LocalDate.of(2026, 11, 5));

        library.returnCopy(1, LocalDate.of(2026, 11, 10));

        assertTrue(copy.isAvailable());
        assertFalse(library.getLoans().get(0).isOpen());
    }

    @Test
    public void testCannotLendUnavailableCopy() {
        library.lendCopy(1, 101, LocalDate.of(2026, 11, 5));

        assertThrows(IllegalStateException.class, () -> {
            library.lendCopy(1, 101, LocalDate.of(2026, 11, 6));
        });
    }

    @Test
    public void testMemberCannotBorrowMoreThanFiveBooks() {
        for (int i = 1; i <= 6; i++) {
            Book newBook = new Book("ISBN" + i, "Book " + i, 2024);
            Copy newCopy = new Copy(i, newBook);

            library.addBook(newBook);
            library.addCopy(newCopy);
        }

        for (int i = 1; i <= 5; i++) {
            library.lendCopy(i, 101, LocalDate.of(2026, 11, 5));
        }

        assertThrows(IllegalStateException.class, () -> {
            library.lendCopy(6, 101, LocalDate.of(2026, 11, 5));
        });
    }
    
    
    
    
    
    @Test
    public void testSearchByTitle() {
        List<Book> results = library.searchByTitle("Java");

        assertEquals(1, results.size());
        assertEquals("Java Programming", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitleIgnoreCase() {
        List<Book> results = library.searchByTitle("JAVA");

        assertEquals(1, results.size());
        assertEquals("Java Programming", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitleNotFound() {
        List<Book> results = library.searchByTitle("Python");

        assertTrue(results.isEmpty());
    }
}