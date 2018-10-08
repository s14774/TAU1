package pl.edu.pjatk.tau;

import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryTest {
    @Test
    public void LibraryAddBookTest(){
        Library library = new Library();
        library.addBook(new Book(1,""));
    }

    @Test
    public void LibraryAddBookTitleTest(){
        Library library = new Library();
        library.addBook("Title");
    }

    @Test
    public void LibraryAddBookAuthorTest(){
        Library library = new Library();
        library.addBook("Title","Author");
    }

    @Test
    public void LibraryAddBookCategoryTest(){
        Library library = new Library();
        library.addBook("Title","Author", BookCategories.PIEKNA);
    }

    @Test
    public void LibraryGetBookTest(){
        Library library = new Library();
        Book book = new Book(0,"");
        library.addBook(book);
        assertNotEquals(0,book.getID());
    }

    @Test
    public void LibraryAddMultipleBooksTest(){
        Library library = new Library();
        Book book = new Book("TEST1");
        library.addBook(book);
        Book book2 = new Book("TEST2");
        library.addBook(book2);
        assertEquals(2,library.getBookQuantity());
    }

    @Test
    public void LibraryGetBooksNameTest(){
        Library library = new Library();
        Book book = new Book("TEST1");
        library.addBook(book);
        Book book2 = new Book("TEST2");
        library.addBook(book2);
        Book book3 = new Book("ANIA");
        library.addBook(book3);
        assertEquals(2,library.getBooks("TEST").size());
        assertEquals(3,library.getBookQuantity());
    }

    @Test
    public void LibraryAddBooksTwiceTest(){
        Library library = new Library();
        Book book = new Book("TEST1");
        library.addBook(book);
        library.addBook(book);
        assertNotEquals(2,library.getBookQuantity());
    }

    @Test
    public void LibraryUpdateBookTest(){
        Library library = new Library();
        String title = "TITLE";
        String author = "AUTHOR";
        Book book = new Book(title);
        library.addBook(book);
        book = library.getBooks(title).get(0);
        book.setAuthor(author);
        library.updateBook(book);
        book = library.getBooks(title).get(0);
        assertEquals(author,book.getAuthor());
    }
}
