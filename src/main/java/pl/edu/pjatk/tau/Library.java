package pl.edu.pjatk.tau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<Book>();
    private int counter = 0;

    public void addBook(Book book) {
        if(books.contains(book))
            return;
        if(book.getID() == 0) {
            book.setID(++counter);
        }
        if(book.getAddTimeDisabled() == false)
            book.setAddTimeNow();
        if(book.getModifyTimeDisabled() == false)
            book.setModifyTimeNow();
        books.add(book);
    }

    public void addBook(String title) {
        addBook(new Book(++counter, title));
    }

    public void addBook(String title, String author) {
        addBook(new Book(++counter, title, author));
    }

    public void addBook(String title, String author, BookCategories category) {
        addBook(new Book(++counter, title, author, category));
    }

    public Book getBook(int ID){
        for(Book book : books)
            if(book.getID() == ID){
                book.setLastAccessTimeNow();
                return book;
            }
        return null;
    }

    public int getBookQuantity(){
        return books.size();
    }

    public List<Book> getBooks(String title){
        List<Book> returnBooks = new ArrayList<Book>();

        if(title==null)
            return returnBooks;
        if(title.equals(""))
            return returnBooks;

        for(Book book : books)
            if(book.getTitle().contains(title)){
                book.setLastAccessTimeNow();
                returnBooks.add(book);
            }

        return returnBooks;
    }

    public void updateBook(Book book){
        if (book != null)
            updateBook(book.getID(), book);
    }

    public void updateBook(int ID, Book book) {
        if(book != null){
            Book updatedBook = this.getBook(ID);
            if (updatedBook == null)
                return;
            if(book == null)
                return;

            if(book.getModifyTimeDisabled() == false)
                book.setModifyTimeNow();
            updatedBook.updateBook(book);
        }
    }

    public void deleteBook(Book book){
        if (book == null){
            return;
        }
        if(books.contains(book)){
            books.remove(book);
        }
    }

    public void deleteBook(int ID){
        this.deleteBook(books.get(ID));
    }

    public List<Book> getBooksNotUsedMoreThanMonths(int months){
        List<Book> bookList = new ArrayList<>();
        if(months < 1) return bookList;
        for(Book book : books)
            if(book.getLastAccessTime().isBefore(LocalDate.now().minusMonths(months))){
                book.setLastAccessTimeNow();
                bookList.add(book);
            }
        return bookList;
    }
}