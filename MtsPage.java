import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MtsPage {
    private WebDriver driver;

    private By paymentSection = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div");
    private By phoneNumberField = By.cssSelector("#internet-phone");
    private By amountField = By.cssSelector("#connection-sum");
    private By continueButton = By.cssSelector("#pay-connection > button");

    private By popupContainer = By.cssSelector("body > app-root > div > div > div");
    private By displayedAmount = By.cssSelector("app-payment-container > section > div > div > div.pay-description__cost > span:nth-child(1)");
    private By displayedPhoneNumber = By.cssSelector("app-payment-container > section > div > div > div.pay-description__text > span");

    private By cardNumberField = By.cssSelector("app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(1) > app-input > div > div > div.content.ng-tns-c46-1 > label");
    private By expiryDateField = By.cssSelector("app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.expires-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-4 > label");
    private By cvcField = By.cssSelector("app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.cvc-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-5 > label");
    private By cardHolderNameField = By.cssSelector("app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(3) > app-input > div > div > div.content.ng-tns-c46-3 > label");

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPaymentFields(String phoneNumber, String amount) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getDisplayedAmount() {
        return driver.findElement(popupContainer).findElement(displayedAmount).getText();
    }

    public String getDisplayedPhoneNumber() {
        return driver.findElement(popupContainer).findElement(displayedPhoneNumber).getText();
    }

    public String getCardNumberLabel() {
        return driver.findElement(popupContainer).findElement(cardNumberField).getText();
    }

    public String getExpiryDateLabel() {
        return driver.findElement(popupContainer).findElement(expiryDateField).getText();
    }

    public String getCvcLabel() {
        return driver.findElement(popupContainer).findElement(cvcField).getText();
    }

    public String getCardHolderNameLabel() {
        return driver.findElement(popupContainer).findElement(cardHolderNameField).getText();
    }
}
