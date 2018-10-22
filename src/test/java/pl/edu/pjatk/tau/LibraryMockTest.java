package pl.edu.pjatk.tau;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;


public class LibraryMockTest {
    @Test
    public void BookGetAddTimeMock(){
        Book spyBook = Mockito.spy(new Book());
        LocalDate date = LocalDate.of(2018,10,21);
        when(spyBook.getAddTime()).thenReturn(date);

        spyBook.setID(0);
        spyBook.setAuthor("TEST");

        Library library = new Library();
        library.addBook(spyBook);

        assertEquals(date, spyBook.getAddTime());
    }

//    @Test
//    public void BookGetModifyTimeMock(){
//        Book spyBook = Mockito.spy(new Book());
//        LocalDate date = LocalDate.of(2018,10,21);
//
//        doAnswer((Answer) invocation -> {
//            FieldSetter.setField(spyBook, spyBook.getClass().getDeclaredField("modifyTime"), date);
//            return null;
//        }).when(spyBook).setModifyTimeNow();
//
//        spyBook.setID(0);
//        spyBook.setAuthor("TEST");
//
//        Library library = new Library();
//        library.addBook(spyBook);
//
//        assertEquals(date, spyBook.getModifyTime());
//    }
//    @Test
//    public void cos(){
//        LocalDate date = LocalDate.of(2018,10,21);
//        when(LocalDate.now()).thenReturn(date);
//
//        assertEquals(date,LocalDate.now());
//    }
    @Test
    public void LibraryBooksNotUsed(){
        Book b1 = Mockito.spy(new Book());
        Book b2 = Mockito.spy(new Book());
        Library library = new Library();

        when(b1.getLastAccessTime()).thenReturn(LocalDate.now().minusMonths(4));
        when(b2.getLastAccessTime()).thenReturn(LocalDate.now().minusMonths(2));

        library.addBook(b1);
        library.addBook(b2);

        assertEquals(1, library.getBooksNotUsedMoreThanMonths(3).size());
        assertEquals(b1, library.getBooksNotUsedMoreThanMonths(3).get(0));
        assertEquals(2, library.getBooksNotUsedMoreThanMonths(1).size());
    }

}
