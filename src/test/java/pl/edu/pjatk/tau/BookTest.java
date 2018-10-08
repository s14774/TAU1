package pl.edu.pjatk.tau;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void BookConstructorTitleTest(){
        int ID = 1;
        String title = "TEST";
        Book book = new Book(ID, title);
        assertTrue(book.getTitle().equals(title));
    }

    @Test
    public void BookConstructorAuthorTest(){
        int ID = 1;
        String author = "TEST";
        Book book = new Book(ID, "", author);
        assertTrue(book.getAuthor().equals(author));
    }

    @Test
    public void BookConstructorCategoryTest(){
        int ID = 1;
        BookCategories category = BookCategories.PIEKNA;
        Book book = new Book(ID, "", "", category);
        assertTrue(book.getCategoty().equals(category));
    }

    @Test
    public void BookConstructorIsbn10Test() {
        int ID = 1;
        String ISBN = "0306406152";
        Book book = new Book(ID, "", "", BookCategories.PIEKNA, ISBN);
        assertEquals(ISBN,book.getISBN());
    }

    @Test
    public void BookConstructorIsbnWrongLenTest() {
        int ID = 1;
        String ISBN = "6406152";
        Book book = new Book(ID, "", "", BookCategories.PIEKNA, ISBN);
        assertNotEquals(ISBN,book.getISBN());
    }
}
