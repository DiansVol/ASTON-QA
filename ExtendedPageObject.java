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
    public void testOnlinePaymentFields() {
        homePage.enterPhoneNumber("297777777");

        assertEquals("297777777", homePage.getPhoneNumber());
        assertEquals("100", homePage.getConnectionSum());
        assertEquals("test@example.com", homePage.getEmail());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
