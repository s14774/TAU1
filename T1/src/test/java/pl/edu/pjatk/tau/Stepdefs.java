package pl.edu.pjatk.tau;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Stepdefs {
    Library library;
    List<Book> bookList = new ArrayList<Book>();

    @Given("^we have library$")
    public void we_have_library() throws Exception {
        library = new Library();
    }

    @Given("^we have book named (.*)$")
    public void we_have_book_named_Book(String arg1) throws Exception {
        bookList.add(new Book(arg1));
    }

    @When("^we add them to library$")
    public void we_add_them_to_library() throws Exception {
        for (Book book:bookList) {
            library.addBook(book);
        }
        bookList.clear();
    }

    @Then("^the result of searching \"([^\"]*)\" should be (\\d+)$")
    public void the_result_of_searching_should_be(String arg1, int arg2) throws Exception {
        assertEquals(arg2,library.getBooks(arg1).size());
    }

    @Then("^the result of searching \"([^\"]*)\" should be Book named \"([^\"]*)\"$")
    public void the_result_of_searching_should_be_Book_named(String arg1, String arg2) throws Exception {
        System.err.println("1:"+arg1+" 2:"+arg2);
        assertTrue(arg2.equals(library.getBooksByRegex(arg1).get(0).getTitle()));
    }

    @Then("^library size should be (\\d+)$")
    public void library_size_should_be(int arg1) throws Exception {
        assertEquals(arg1,library.getBookQuantity());
    }


    @Then("^the result of searching \"([^\"]*)\" shouldn't be Book named \"([^\"]*)\"$")
    public void the_result_of_searching_shouldn_t_be_Book_named(String arg1, String arg2) throws Exception {
        assertFalse(arg2.equals(library.getBooksByRegex(arg1).get(0).getTitle()));

    }


}