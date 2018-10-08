package pl.edu.pjatk.tau;

public class Book {
    int ID = 0;
    String title;
    String author;
    BookCategories kategoria;

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
        Book book = new Book();
        book.setID(this.ID);
        book.setAuthor(this.author);
        book.setTitle(this.getTitle());
        book.setKategoria(this.getKategoria());
        return book;
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

    public Book(int ID, String title, String author, BookCategories kategoria) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.kategoria = kategoria;
    }

    public void updateBook(Book book){
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setKategoria(book.getKategoria());
    }
}
