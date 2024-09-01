import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ExtendedPageObject {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://mts.by/");
    }

    @Test
    @Description("Проверка полей для онлайн пополнения")
    @Story("История: Проверка заполнения полей для услуг связи")
    public void testOnlinePaymentFields() {
        stepEnterPhoneNumber("297777777");

        assertEquals("297777777", homePage.getPhoneNumber());
        assertEquals("100", homePage.getConnectionSum()); // пример значения
        assertEquals("test@example.com", homePage.getEmail()); // пример email
    }

    @Step("Ввод номера телефона {phoneNumber}")
    public void stepEnterPhoneNumber(String phoneNumber) {
        homePage.enterPhoneNumber(phoneNumber);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
