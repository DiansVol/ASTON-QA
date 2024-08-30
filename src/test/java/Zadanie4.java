import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class Zadanie4 {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testContinueButton() {
        driver.get("https://mts.by/");

        driver.findElement(By.xpath("//div[@class='pay__tab-wrapper']//label[contains(text(), 'Услуги связи')]")).click();

        WebElement phoneNumberField = driver.findElement(By.cssSelector("#connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        boolean isNextPageLoaded = driver.getCurrentUrl().contains("pay/connection/check-phone");
        assertTrue("Страница не загрузилась", isNextPageLoaded);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}