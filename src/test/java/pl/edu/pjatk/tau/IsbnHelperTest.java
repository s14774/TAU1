package pl.edu.pjatk.tau;

import org.junit.Test;
import pl.edu.pjatk.tau.Helpers.IsbnHelper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsbnHelperTest {
    @Test
    public void Isbn10SimpleTest(){
        String ISBN = "0306406152";
        assertTrue(IsbnHelper.check(ISBN));
    }

    @Test
    public void Isbn10FalseTest(){
        String ISBN = "0306406156";
        assertFalse(IsbnHelper.check(ISBN));
    }

    @Test
    public void IsbnWrongCharsTest(){
        String ISBN = "03064061c2";
        assertFalse(IsbnHelper.check(ISBN));
    }

    @Test
    public void IsbnMultipleTest(){
        String ISBN = "978-83--7181-510-2";
        assertFalse(IsbnHelper.check(ISBN));
    }

    @Test
    public void Isbn10GoodCharsTest(){
        String ISBN = "0-3064-06152";
        assertTrue(IsbnHelper.check(ISBN));
    }

    @Test
    public void Isbn13GoodCharsTest(){
        String ISBN = "978-83-7181-510-2";
        assertTrue(IsbnHelper.check(ISBN));
    }

    @Test
    public void Isbn13ControlSumTest(){
        String ISBN = "978-83-7181-510-6";
        assertFalse(IsbnHelper.check(ISBN));
    }

    @Test
    public void Isbn13EndCharErrTest(){
        String ISBN = "978-83-7181-510-2-";
        assertFalse(IsbnHelper.check(ISBN));
    }
}
