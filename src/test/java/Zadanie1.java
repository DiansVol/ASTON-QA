import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

public class Zadanie1 {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testTitle() {
        driver.get("https://mts.by/");

        WebElement onlineTopUpBlock = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div"));

        String actualTitle = onlineTopUpBlock.getText();
        String expectedTitle = "Онлайн пополнение без комиссии";
        assertEquals("Название блока не соответствует ожидаемому", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}