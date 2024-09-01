import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class Mts2_1 {
    private WebDriver driver;
    private MtsPage mtsPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        mtsPage = new MtsPage(driver);
    }

    @Test
    @Description("Тест на заполнение полей и проверку значений в платежном процессе")
    @DisplayName("Тестировать процесс платежей")
    public void testPaymentProcess() {
        fillPaymentFields("297777777", "10");
        clickContinueButton();

        verifyDisplayedValues("10", "297777777");

        verifyCardFields();
    }

    @Step("Заполнение полей с номером телефона {phoneNumber} и суммой {amount}")
    private void fillPaymentFields(String phoneNumber, String amount) {
        mtsPage.fillPaymentFields(phoneNumber, amount);
    }

    @Step("Нажимаем кнопку 'Продолжить'")
    private void clickContinueButton() {
        mtsPage.clickContinue();
    }

    @Step("Проверка отображаемой суммы и номера телефона")
    private void verifyDisplayedValues(String amount, String phoneNumber) {
        assertEquals(amount, mtsPage.getDisplayedAmount().trim());
        assertEquals(phoneNumber, mtsPage.getDisplayedPhoneNumber().trim());
    }

    @Step("Проверка текстов полей карты")
    private void verifyCardFields() {
        assertEquals("Номер карты", mtsPage.getCardNumberLabel().trim());
        assertEquals("Срок действия", mtsPage.getExpiryDateLabel().trim());
        assertEquals("CVC", mtsPage.getCvcLabel().trim());
        assertEquals("Имя держателя", mtsPage.getCardHolderNameLabel().trim());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
