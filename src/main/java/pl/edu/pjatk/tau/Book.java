package pl.edu.pjatk.tau;

import pl.edu.pjatk.tau.Helpers.IsbnHelper;

import java.time.LocalDate;

public class Book {
    private int ID = 0;
    private String title;
    private String author;
    private BookCategories category;
    private String ISBN;
    private LocalDate addTime;
    private Boolean addTimeDisabled = false;
    private LocalDate modifyTime;
    private Boolean modifyTimeDisabled = false;
    private LocalDate lastAccessTime;
    private Boolean lastAccessTimeDisabled = false;

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
        return new Book(this.getID(), this.getTitle(), this.getAuthor(), this.getCategoty(), this.getISBN(),
                this.getAddTime(), this.getAddTimeDisabled(),
                this.getModifyTime(), this.getModifyTimeDisabled(),
                this.getLastAccessTime(), this.getLastAccessTimeDisabled());
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

    public Book(int ID, String title, String author, BookCategories category, String ISBN, LocalDate addTime, Boolean addTimeDisabled, LocalDate modifyTime, Boolean modifyTimeDisabled, LocalDate lastAccessTime, Boolean lastAccessTimeDisabled) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.ISBN = ISBN;
        this.addTime = addTime;
        this.addTimeDisabled = addTimeDisabled;
        this.modifyTime = modifyTime;
        this.modifyTimeDisabled = modifyTimeDisabled;
        this.lastAccessTime = lastAccessTime;
        this.lastAccessTimeDisabled = lastAccessTimeDisabled;
    }

    public void updateBook(Book book) {
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setCategoty(book.getCategoty());
        this.setISBN(book.getISBN());
        this.setModifyTime(book.getModifyTime());
    }

    public LocalDate getAddTime() {
        return addTime;
    }

    public LocalDate getModifyTime() {
        return modifyTime;
    }

    public LocalDate getLastAccessTime() {
        return lastAccessTime;
    }

    private void setAddTime(LocalDate addTime) {
        this.addTime = addTime;
    }

    private void setModifyTime(LocalDate modifyTime) {
        this.modifyTime = modifyTime;
    }

    private void setLastAccessTime(LocalDate lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    protected void setAddTimeNow() {
        this.addTime = LocalDate.now();
    }

    protected void setModifyTimeNow() {
        this.modifyTime = LocalDate.now();
    }

    protected void setLastAccessTimeNow() {
        this.lastAccessTime = LocalDate.now();
    }

    public Boolean getAddTimeDisabled() {
        return addTimeDisabled;
    }

    public void setAddTimeDisabled(Boolean addTimeDisabled) {
        this.addTimeDisabled = addTimeDisabled;
    }

    public Boolean getModifyTimeDisabled() {
        return modifyTimeDisabled;
    }

    public void setModifyTimeDisabled(Boolean modifyTimeDisabled) {
        this.modifyTimeDisabled = modifyTimeDisabled;
    }

    public Boolean getLastAccessTimeDisabled() {
        return lastAccessTimeDisabled;
    }

    public void setLastAccessTimeDisabled(Boolean lastAccessTimeDisabled) {
        this.lastAccessTimeDisabled = lastAccessTimeDisabled;
    }
}
