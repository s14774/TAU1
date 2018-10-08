package pl.edu.pjatk.tau;

public class Book {
    private int ID = 0;
    private String title;
    private String author;
    private BookCategories kategoria;
    private int ISBN;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
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
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategories getKategoria() {
        return kategoria;
    }

    public void setKategoria(BookCategories kategoria) {
        this.kategoria = kategoria;
    }

    public Book clone(){
        return new Book(this.ID, this.getTitle(), this.getAuthor(), this.getKategoria(), this.getISBN());
    }

    public Book(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }

    public Book(int ID, String title, String author) {
        this.ID = ID;
        this.title = title;
        this.author = author;
    }

    public Book(int ID, String title, String author, BookCategories category) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.kategoria = category;
    }

    public Book(int ID, String title, String author, BookCategories kategoria, int ISBN) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.kategoria = kategoria;
        this.ISBN = ISBN;
    }

    public void updateBook(Book book){
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setKategoria(book.getKategoria());
        this.setISBN(book.getISBN());
    }
}
