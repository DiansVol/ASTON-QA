import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ChromeTe {
    WebDriver driver;
    HomePage homePage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @Order(1)
    void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, homePage.getBlockTitle(), "Название блока не совпадает.");
    }

    @Test
    @Order(2)
    void testPaymentLogos() {
        List<WebElement> paymentLogos = homePage.getPaymentLogos();
        assertFalse(paymentLogos.isEmpty(), "Логотипы платёжных систем не найдены.");
    }

    @Test
    @Order(3)
    void testMoreInfoLink() {
        homePage.clickMoreInfoLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, homePage.getCurrentUrl(), "Ссылка «Подробнее о сервисе» не работает.");
    }

    @Test
    @Order(4)
    void testContinueButton() {
        homePage.enterPhoneNumber("297777777");
        homePage.enterAmount("10");
        homePage.clickContinueButton();
    }
    @Test
    @Order(5)
    public void testPlaceholdersForPaymentOptions() {
        // Услуги связи
        assertEquals("Номер телефона", homePage.getPlaceholderText(By.xpath("//input[@placeholder='Номер телефона']")));
        assertEquals("Сумма", homePage.getPlaceholderText(By.xpath("//input[@id='connection-sum'][@placeholder='Сумма']")));
        assertEquals("E-mail для отправки чека", homePage.getPlaceholderText(By.xpath("//input[@id='connection-email']")));

        // Домашний интернет
        assertEquals("Номер абонента", homePage.getPlaceholderText(By.xpath("//input[@placeholder='Номер абонента']")));
        assertEquals("Сумма", homePage.getPlaceholderText(By.xpath("//input[@id='instalment-sum'][@placeholder='Сумма']")));
        assertEquals("E-mail для отправки чека", homePage.getPlaceholderText(By.xpath("//input[@id='instalment-email']")));

        // Рассрочка
        assertEquals("Номер счета на 44", homePage.getPlaceholderText(By.xpath("//input[@placeholder='Номер счета на 44']")));
        assertEquals("Сумма", homePage.getPlaceholderText(By.xpath("//input[@id='instalment-sum']")));
        assertEquals("E-mail для отправки чека", homePage.getPlaceholderText(By.xpath("//input[@id='instalment-email']")));

        // Задолженность
        assertEquals("Номер счета на 2073", homePage.getPlaceholderText(By.xpath("//input[@placeholder='Номер счета на 2073']")));
        assertEquals("Сумма", homePage.getPlaceholderText(By.xpath("//input[@id='arrears-sum']")));
        assertEquals("E-mail для отправки чека", homePage.getPlaceholderText(By.xpath("//input[@id='arrears-email']")));
    }

}
