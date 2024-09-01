import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PageObject {
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
    @Description("Проверка заголовка блока онлайн пополнения")
    public void testTitle() {
        String actualTitle = homePage.getOnlineTopUpBlockText();
        String expectedTitle = "Онлайн пополнение без комиссии";
        assertEquals("Название блока не соответствует ожидаемому", expectedTitle, actualTitle);
    }

    @Test
    @Description("Проверка наличия логотипов платежных систем")
    public void testLogos() {
        boolean hasLogos = homePage.hasLogos();
        assertTrue("Блок с логотипами платежных систем пуст", hasLogos);
    }

    @Test
    @Description("Проверка корректности ссылки на пополнение")
    public void testLink() {
        String actualUrl = homePage.getLinkUrl();
        String expectedUrl = "https://mts.by/ru/personal/payments-and-transfers/online-top-up";
        assertEquals("Ссылка ведет на неправильный адрес", expectedUrl, actualUrl);
    }

    @Test
    @Description("Проверка кнопки продолжения после ввода номера телефона")
    public void testContinueButton() {
        driver.findElement(By.xpath("//div[@class='pay__tab-wrapper']//label[contains(text(), 'Услуги связи')]")).click();
        homePage.enterPhoneNumber("297777777");
        homePage.clickContinueButton();

        boolean isNextPageLoaded = driver.getCurrentUrl().contains("pay/connection/check-phone");
        assertTrue("Страница не загрузилась", isNextPageLoaded);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
