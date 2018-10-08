package pl.edu.pjatk.tau;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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
        assertTrue(book.getKategoria().equals(category));
    }

    @Test
    public void BookConstructorIsbnTest() {
        int ID = 1;
        BookCategories category = BookCategories.PIEKNA;
        Book book = new Book(ID, "", "", category);
        assertTrue(book.getKategoria().equals(category));
    }
}
