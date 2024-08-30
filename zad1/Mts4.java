import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Mts4 {

    @Test
    public void checkPaymentFields() {

        System.setProperty("webdriver.chrome.driver", "/home/diana/IdeaProjects/L16_1");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement onlinePaymentSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div")));
        onlinePaymentSection.click();

        WebElement paymentSelector = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button > span.select__now")));
        paymentSelector.click();

        WebElement scoreArrearsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("score-arrears")));
        String scoreArrearsText = scoreArrearsLabel.getText();
        assert scoreArrearsText.contains("Номер счета на 2073");

        WebElement arrearsSumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arrears-sum")));
        String arrearsSumText = arrearsSumLabel.getText();
        assert arrearsSumText.contains("Сумма");

        WebElement arrearsEmailLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arrears-email")));
        String arrearsEmailText = arrearsEmailLabel.getText();
        assert arrearsEmailText.contains("E-mail для отправки чека");

        driver.quit();
    }
}