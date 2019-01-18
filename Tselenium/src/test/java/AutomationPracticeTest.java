import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class AutomationPracticeTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
    }

    @Test
    public void registerTest() {
        driver.get("http://automationpractice.com");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")));
        signIn.click();

        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create-account_form\"]/div/div[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(email);
        actions.click();
        actions.sendKeys(RandomStringUtils.randomAlphabetic(10).concat("@s.ss"));
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        assertTrue(email.getAttribute("class").contains("form-ok"));

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        submit.click();

        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());

        WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
        gender.click();

        WebElement customer_firstname = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        WebElement customer_firstname_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[2]"));

        customer_firstname.sendKeys("Mateusz");

        WebElement customer_lastname = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        WebElement customer_lastname_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[3]"));
        customer_lastname.sendKeys("Szy");

        assertTrue(customer_firstname_div.getAttribute("class").contains("form-ok"));

        WebElement email2 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement email2_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[4]"));
        email2.click();

        assertTrue(customer_lastname_div.getAttribute("class").contains("form-ok"));

        WebElement passwd = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        WebElement passwd_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[5]"));
        passwd.sendKeys("haaflv388931@@");

        assertTrue(email2_div.getAttribute("class").contains("form-ok"));

        Select days = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        days.selectByValue("19");

        assertTrue(passwd_div.getAttribute("class").contains("form-ok"));

        Select months = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        months.selectByValue("8");

        Select years = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        years.selectByValue("1999");

        WebElement address1 = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address1.sendKeys("Something");

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("SomethingCity");

        Select id_state = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        id_state.selectByValue("15");

        WebElement postcode = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        postcode.sendKeys("23142");

        WebElement phone_mobile = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        phone_mobile.sendKeys("123456789");

        WebElement submitAccount = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
        submitAccount.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"center_column\"]/h1"), "MY ACCOUNT"));

        WebElement accountName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        assertEquals("Mateusz Szy",accountName.getText());
    }

    @Test
    public void failedRegisterTest() {
        driver.get("http://automationpractice.com");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")));
        signIn.click();

        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create-account_form\"]/div/div[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(email);
        actions.click();
        actions.sendKeys(RandomStringUtils.randomAlphabetic(10).concat("@s.ss"));
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        assertTrue(email.getAttribute("class").contains("form-ok"));

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        submit.click();

        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());

        WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
        gender.click();

        WebElement customer_firstname = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        WebElement customer_firstname_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[2]"));

        customer_firstname.sendKeys("Mateusz");

        WebElement customer_lastname = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        WebElement customer_lastname_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[3]"));
        customer_lastname.sendKeys("Szy");

        assertTrue(customer_firstname_div.getAttribute("class").contains("form-ok"));

        WebElement email2 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement email2_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[4]"));
        email2.click();

        assertTrue(customer_lastname_div.getAttribute("class").contains("form-ok"));

        WebElement passwd = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        WebElement passwd_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[5]"));
        passwd.sendKeys("haaflv388931@@");

        assertTrue(email2_div.getAttribute("class").contains("form-ok"));

        Select days = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        days.selectByValue("19");

        assertTrue(passwd_div.getAttribute("class").contains("form-ok"));

        Select months = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        months.selectByValue("8");

        Select years = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        years.selectByValue("1999");

        WebElement address1 = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address1.sendKeys("Something");

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("SomethingCity");

        Select id_state = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        id_state.selectByValue("15");

        WebElement postcode = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        postcode.sendKeys("23142");

        WebElement submitAccount = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
        submitAccount.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"center_column\"]/h1"), "CREATE AN ACCOUNT"));

        WebElement accountName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
        assertTrue(accountName.getText().contains("error"));
    }

    @Test
    public void registerResolutionTest() {
        driver.manage().window().setSize(new Dimension(200,200));
        driver.get("http://automationpractice.com");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")));
        signIn.click();

        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create-account_form\"]/div/div[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(email);
        actions.click();
        actions.sendKeys(RandomStringUtils.randomAlphabetic(10).concat("@s.ss"));
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        assertTrue(email.getAttribute("class").contains("form-ok"));

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        submit.click();

        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());

        WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
        gender.click();

        WebElement customer_firstname = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        WebElement customer_firstname_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[2]"));

        customer_firstname.sendKeys("Mateusz");

        WebElement customer_lastname = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        WebElement customer_lastname_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[3]"));
        customer_lastname.sendKeys("Szy");

        assertTrue(customer_firstname_div.getAttribute("class").contains("form-ok"));

        WebElement email2 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement email2_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[4]"));
        email2.click();

        assertTrue(customer_lastname_div.getAttribute("class").contains("form-ok"));

        WebElement passwd = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        WebElement passwd_div = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[5]"));
        passwd.sendKeys("haaflv388931@@");

        assertTrue(email2_div.getAttribute("class").contains("form-ok"));

        Select days = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        days.selectByValue("19");

        assertTrue(passwd_div.getAttribute("class").contains("form-ok"));

        Select months = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        months.selectByValue("8");

        Select years = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        years.selectByValue("1999");

        WebElement address1 = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address1.sendKeys("Something");

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("SomethingCity");

        Select id_state = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        id_state.selectByValue("15");

        WebElement postcode = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        postcode.sendKeys("23142");

        WebElement phone_mobile = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        phone_mobile.sendKeys("123456789");

        WebElement submitAccount = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
        submitAccount.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"center_column\"]/h1"), "MY ACCOUNT"));

        WebElement accountName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        assertEquals("Mateusz Szy",accountName.getText());
    }

    @AfterAll
    public static void tearDown() throws Exception {
//        driver.quit();
    }
}
