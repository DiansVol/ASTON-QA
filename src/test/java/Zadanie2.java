import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class Zadanie2 {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testLogos() {
        // Открываем сайт mts.by
        driver.get("https://mts.by/");

        WebElement partnersBlock = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners"));

        boolean hasLogos = partnersBlock.findElements(By.tagName("img")).size() > 0;
        assertTrue("Блок с логотипами платежных систем пуст", hasLogos);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
