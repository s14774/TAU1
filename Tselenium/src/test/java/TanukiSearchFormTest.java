import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TanukiSearchFormTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void searchFormSingleResultTest(){
        driver.get("http://anime.tanuki.pl/strony/");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement szukaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'sidebar']/div[@id = 'menu']/ul/li[5]")));
        szukaj.click();

        assertEquals("http://anime.tanuki.pl/strony/szukaj",driver.getCurrentUrl());

        //tytul
        driver.findElement(By.xpath("//form[@id = 'titleForm']/table[@class = 'searchtable']/tbody/tr[1]/td[1]/input")).sendKeys("Gundam");
        //studio
        Select studioDdList = new Select(driver.findElement(By.xpath("//form[@id='titleForm']/table[@class='searchtable']/tbody/tr[1]/td[2]/select")));
        studioDdList.selectByVisibleText("Sunrise");

        //rodzaj
        Select rodzajDdList = new Select(driver.findElement(By.xpath("//form[@id = 'titleForm']/table[@class = 'searchtable']/tbody/tr[2]/td[1]/select")));
        rodzajDdList.selectByValue("1"); //TV

        //rok wydania
        driver.findElement(By.xpath("//form[@id = 'titleForm']/table[@class = 'searchtable']/tbody/tr[4]/td[1]/input")).sendKeys("1995");
        //submit
        driver.findElement(By.xpath("//form[@id = 'titleForm']/div[@class = 'center']")).findElement(By.cssSelector("input[name*='do']")).sendKeys(Keys.ENTER);

        WebElement artHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'all']/div[@id = 'content']/div[@id = 'mbody']/div[@class = 'body_n']/div[@class = 'rbody']/div[@id = 'leftcolumn']/h3")));

        assertEquals("http://anime.tanuki.pl/strony/anime/51-gundam-wing/rec/2358",driver.getCurrentUrl());

        String message = artHeader.getText();

        assertNotEquals("Voltron", message);
    }

    @Test
    public void searchFormMultipleResultsTest(){
        driver.get("http://anime.tanuki.pl/strony/");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement szukaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'sidebar']/div[@id = 'menu']/ul/li[5]")));
        szukaj.click();

        //tytul
        driver.findElement(By.xpath("//form[@id = 'titleForm']/table[@class = 'searchtable']/tbody/tr[1]/td[1]/input")).sendKeys("Gundam");
        //studio
        Select studioDdList = new Select(driver.findElement(By.xpath("//form[@id='titleForm']/table[@class='searchtable']/tbody/tr[1]/td[2]/select")));
        studioDdList.selectByVisibleText("Sunrise");
        //submit
        driver.findElement(By.xpath("//form[@id = 'titleForm']/div[@class = 'center']")).findElement(By.cssSelector("input[name*='do']")).sendKeys(Keys.ENTER);

        WebElement pageResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='all']/div[@id='content']/div[@id='mbody']/div[@id='body']/div[@class='rbody']")));
        String message = pageResult.getText();

        assertNotNull(message);
    }

    @AfterAll
    public static void tearDown() throws Exception {

        driver.quit();
    }
}
