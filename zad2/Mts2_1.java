import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mts2_1 {
    @Test
    public void onlineRecharge() {
        System.setProperty("webdriver.chrome.driver", "/home/diana/IdeaProjects/L16_1");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.mts.by/");

            WebElement paySection = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div"));
            paySection.click();

            WebElement phoneField = driver.findElement(By.cssSelector("#internet-phone"));
            phoneField.sendKeys("297777777");

            WebElement amountField = driver.findElement(By.cssSelector("#connection-sum"));
            amountField.sendKeys("10");

            WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
            continueButton.click();

            WebElement displayedCost = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__cost > span:nth-child(1)"));
            System.out.println("Сумма: " + displayedCost.getText());

            WebElement displayedPhone = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__text > span"));
            System.out.println("Номер телефона: " + displayedPhone.getText());

            WebElement cardNumberLabel = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(1) > app-input > div > div > div.content.ng-tns-c46-1 > label"));
            System.out.println("Поле для номера карты: " + cardNumberLabel.getText());

            WebElement expirationDateLabel = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.expires-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-4 > label"));
            System.out.println("Поле для срока действия карты: " + expirationDateLabel.getText());

            WebElement cvcLabel = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.cvc-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-5 > label"));
            System.out.println("Поле для CVC: " + cvcLabel.getText());

            WebElement cardHolderLabel = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(3) > app-input > div > div > div.content.ng-tns-c46-3 > label"));
            System.out.println("Поле для имени держателя карты: " + cardHolderLabel.getText());

        } finally {
            driver.quit();
        }
    }
}