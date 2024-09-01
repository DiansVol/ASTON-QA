import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    public void testPaymentProcess() {
        String phoneNumber = "297777777";
        String amount = "10";
        mtsPage.fillPaymentFields(phoneNumber, amount);

        mtsPage.clickContinue();
        assertEquals(amount, mtsPage.getDisplayedAmount().trim());
        assertEquals(phoneNumber, mtsPage.getDisplayedPhoneNumber().trim());
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
