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
    void testEmptyFieldsPlaceholders() {
        // Проверки для услуги связи
        assertEquals("Номер телефона", homePage.getFieldPlaceholderText(By.xpath("//*[@id='connection-phone']")),
                "Неверный номер телефона");
        assertEquals("Сумма", homePage.getFieldPlaceholderText(By.xpath("//*[@id='connection-sum']")),
                "Это поле обязательно для заполнения");
        assertEquals("E-mail для отправки чека", homePage.getFieldPlaceholderText(By.xpath("//*[@id='connection-email']")),
                "Это поле обязательно для заполнения.");

        // Проверки для домашнего интернета
        assertEquals("Номер абонента", homePage.getFieldPlaceholderText(By.xpath("//*[@id='internet-phone']")),
                "Неверный номер абонента");
        assertEquals("Сумма", homePage.getFieldPlaceholderText(By.xpath("//*[@id='internet-sum']")),
                "Это поле обязательно для заполнения");
        assertEquals("E-mail для отправки чека", homePage.getFieldPlaceholderText(By.xpath("//*[@id='internet-email']")),
                "Это поле обязательно для заполнения");

        // Проверки для рассрочки
        assertEquals("Номер счета на 44", homePage.getFieldPlaceholderText(By.xpath("//*[@id='score-instalment']")),
                "Неверный номер счета");
        assertEquals("Сумма", homePage.getFieldPlaceholderText(By.xpath("//*[@id='instalment-sum']")),
                "Это поле обязательно для заполнения");
        assertEquals("E-mail для отправки чека", homePage.getFieldPlaceholderText(By.xpath("//*[@id='instalment-email']")),
                "Это поле обязательно для заполнения");

        // Проверки для задолженности
        assertEquals("Номер счета на 2073", homePage.getFieldPlaceholderText(By.xpath("//*[@id='score-arrears']")),
                "Unexpected placeholder text for arrears score field.");
        assertEquals("Сумма", homePage.getFieldPlaceholderText(By.xpath("//*[@id='arrears-sum']")),
                "Это поле обязательно для заполнения");
        assertEquals("E-mail для отправки чека", homePage.getFieldPlaceholderText(By.xpath("//*[@id='arrears-email']")),
                "Это поле обязательно для заполнения");
    }

}
