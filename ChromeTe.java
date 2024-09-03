
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ChromeTe {
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement button = driver.findElement(By.xpath
                ("//button[@class='btn btn_gray cookie__cancel']"));
        button.click();
    }


    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @Order(1)
    void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath
                ("//div[@class='pay__wrapper']/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии",
                blockTitle.getText(), "Название блока не совпадает.");
    }

    @Test
    @Order(2)
    void testPaymentLogos() {
        List<WebElement> paymentLogos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        assertFalse(paymentLogos.isEmpty(), "Логотипы платёжных систем не найдены.");
    }

    @Test
    @Order(3)
    void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//a[contains(@href,'/help/poryadok-oplaty')]"));
        moreInfoLink.click();

        // Проверка текущего URL
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(),
                "Ссылка «Подробнее о сервисе» не работает.");
    }

    @Test
    @Order(4)
    void testContinueButton() {
        WebElement phoneNumberField = driver.findElement(By.xpath
                ("//input[@placeholder='Номер телефона']"));
        phoneNumberField.sendKeys("297777777");

        WebElement priceField = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        priceField.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath
                ("//form[@class='pay-form opened']//button[@class='button button__default ']"));
        continueButton.click();
    }
}
