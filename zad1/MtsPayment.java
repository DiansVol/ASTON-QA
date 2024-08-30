import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MtsPayment {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/diana/IdeaProjects/L16_1");
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void testPaymentFields() {
        driver.get("https://www.mts.by/");
        checkServiceLabel();
        checkPhoneField();
        checkSumField();
        checkEmailField();
    }

    private void checkServiceLabel() {
        WebElement serviceLabel = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button > span.select__now"));
        String actualLabel = serviceLabel.getText();
        assertEquals("Услуги связи", actualLabel, "Название услуги связи не соответствует ожидаемому.");
    }

    private void checkPhoneField() {
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        String actualLabel = phoneField.getAttribute("placeholder");
        assertEquals("Номер телефона", actualLabel, "Надпись в поле 'Номер телефона' не соответствует ожидаемой.");
    }

    private void checkSumField() {
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        String actualLabel = sumField.getAttribute("placeholder");
        assertEquals("Сумма", actualLabel, "Надпись в поле 'Сумма' не соответствует ожидаемой.");
    }

    private void checkEmailField() {
        WebElement emailField = driver.findElement(By.id("connection-email"));
        String actualLabel = emailField.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", actualLabel, "Надпись в поле 'E-mail' не соответствует ожидаемой.");
    }
}
