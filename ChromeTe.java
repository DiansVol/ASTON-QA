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
        driver.findElement(By.xpath("//form[@class='pay-form opened']//button[@class='button button__default ']")).click();

        // Проверяем отображение суммы
        String expectedAmount = "10";
        String displayedAmount = driver.findElement(By.xpath("//div[@class='pay-description__cost']/span")).getText();
        assertEquals(expectedAmount, displayedAmount, "Отображаемая сумма не совпадает.");

        // Проверяем текст на кнопке
        String buttonText = driver.findElement(By.xpath("//button[@class='colored disabled']")).getText();
        assertEquals(expectedAmount, buttonText, "Текст на кнопке не совпадает.");

        // Проверяем номер телефона
        String displayedPhoneNumber = driver.findElement(By.xpath("//div[@class='pay-description__text']/span")).getText();
        assertEquals("297777777", displayedPhoneNumber, "Номер телефона не совпадает.");

        // Проверяем тексты для ввода карты
        String cardNumberLabel = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']")).getText();
        String expiryDateLabel = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']")).getText();
        String cvcLabel = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']")).getText();
        String cardHolderNameLabel = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']")).getText();

        assertEquals("Номер карты", cardNumberLabel, "Текст для номера карты не совпадает.");
        assertEquals("Срок действия", expiryDateLabel, "Текст для срока действия не совпадает.");
        assertEquals("CVC", cvcLabel, "Текст для CVC не совпадает.");
        assertEquals("Имя держателя (как на карте)", cardHolderNameLabel, "Текст для имени держателя не совпадает.");

        // Проверяем наличие иконок платежных систем
        boolean hasPaymentSystemIcons = driver.findElements(By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']")).isEmpty();
        assertTrue(hasPaymentSystemIcons, "Иконки платежных систем отсутствуют.");


    }
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
