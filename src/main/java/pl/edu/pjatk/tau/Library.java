package pl.edu.pjatk.tau;

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
        books.add(book);
    }

    public void addBook(String title) {
        Book book = new Book(++counter, title);
        books.add(book);
    }

    public void addBook(String title, String author) {
        Book book = new Book(++counter, title, author);
        books.add(book);
    }

    public void addBook(String title, String author, BookCategories category) {
        Book book = new Book(++counter, title, author, category);
        books.add(book);
    }

    public Book getBook(int ID){
        for(Book book : books)
            if(book.getID() == ID)
                return book;
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
            if(book.getTitle().contains(title))
                returnBooks.add(book);

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
}