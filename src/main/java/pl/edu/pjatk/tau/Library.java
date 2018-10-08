package pl.edu.pjatk.tau;

import java.util.List;

public class Library {
    private List<Book> books = new List<Book>;
    private int counter = 0;

    //Dodanie sprawdzenie czy ID nie istnieje obecnie w bazie.
    public void addBook(Book book) {
        if (book.getID() == 0) {
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

    public void addBook(String title, String author, BookCategories kategoria) {
        Book book = new Book(++counter, title, author, kategoria);
        books.add(book);
    }

    public Book getBook(int ID){
        for(Book book : books)
            if(book.getID() == ID)
                return book.clone();
        return null;
    }

    public void updateBook(int ID, Book book) {
        Book updatedBook = this.getBook(ID);
        if (updatedBook == null)
            return;
        if(book == null)
            return;

        updatedBook.updateBook(book);
    }
}