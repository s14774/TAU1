package pl.edu.pjatk.tau;

import pl.edu.pjatk.tau.Helpers.IsbnHelper;

public class Book {
    private int ID = 0;
    private String title;
    private String author;
    private BookCategories category;
    private String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if(IsbnHelper.check(ISBN)){
            this.ISBN = ISBN;
        }
    }

    public int getID() {
        return ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title!=null && ! title.equals(""))
            this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author!=null && ! author.equals(""))
            this.author = author;
    }

    public BookCategories getCategoty() {
        return category;
    }

    public void setCategoty(BookCategories kategoria) {
        this.category = kategoria;
    }

    public Book clone(){
        return new Book(this.ID, this.getTitle(), this.getAuthor(), this.getCategoty(), this.getISBN());
    }

    public Book() {
    }

    public Book(String title) {
        this.setTitle(title);
    }

    public Book(int ID, String title) {
        this.setID(ID);
        this.setTitle(title);
    }

    public Book(String title, String author) {
        this.setID(ID);
        this.setTitle(title);
        this.setAuthor(author);
    }

    public Book(String title, String author, BookCategories category) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setCategoty(category);
    }

    public Book(String title, String author, BookCategories category, String ISBN) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setCategoty(category);
        this.setISBN(ISBN);
    }

    public Book(int ID, String title, String author) {
        this.setID(ID);
        this.setTitle(title);
        this.setAuthor(author);
    }

    public Book(int ID, String title, String author, BookCategories category) {
        this.setID(ID);
        this.setTitle(title);
        this.setAuthor(author);
        this.setCategoty(category);
    }

    public Book(int ID, String title, String author, BookCategories category, String ISBN) {
        this.setID(ID);
        this.setTitle(title);
        this.setAuthor(author);
        this.setCategoty(category);
        this.setISBN(ISBN);
    }

    public void updateBook(Book book) {
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setCategoty(book.getCategoty());
        this.setISBN(book.getISBN());
    }
}
