import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class Mts2 {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/diana/IdeaProjects/L16_1");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div")).click();
    }

    @Test
    public void testPaymentFields() {
        List<WebElement> paymentOptions = driver.findElements(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button"));

        for (WebElement option : paymentOptions) {
            option.click();
            WebElement phoneNumberField = driver.findElement(By.id("internet-phone"));
            WebElement amountField = driver.findElement(By.id("internet-sum"));
            WebElement emailField = driver.findElement(By.id("internet-email"));

            Assertions.assertEquals(phoneNumberField.getAttribute("placeholder"), "Номер телефона");
            Assertions.assertEquals(amountField.getAttribute("placeholder"), "Сумма");
            Assertions.assertEquals(emailField.getAttribute("placeholder"), "E-mail для отправки чека");

            option.click();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}