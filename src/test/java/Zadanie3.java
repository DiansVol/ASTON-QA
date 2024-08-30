import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class Zadanie3 {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testLink() {
        driver.get("https://mts.by/");

        WebElement link = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a"));

        String actualUrl = link.getAttribute("href");
        String expectedUrl = "https://mts.by/ru/personal/payments-and-transfers/online-top-up";
        assertEquals("Ссылка ведет на неправильный адрес", expectedUrl, actualUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
