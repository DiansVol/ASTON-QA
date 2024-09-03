import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    // Конструктор
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Элементы
    private By cookieCancelButton = By.xpath("//button[@class='btn btn_gray cookie__cancel']");
    private By blockTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private By moreInfoLink = By.xpath("//a[contains(@href,'/help/poryadok-oplaty')]");
    private By phoneNumberField = By.xpath("//input[@placeholder='Номер телефона']");
    private By priceField = By.xpath("//input[@placeholder='Сумма']");
    private By continueButton = By.xpath("//form[@class='pay-form opened']//button[@class='button button__default ']");
    private By connectionPhoneField = By.xpath("//*[@id='connection-phone']");
    private By connectionSumField = By.xpath("//*[@id='connection-sum']");
    private By connectionEmailField = By.xpath("//*[@id='connection-email']");

    private By internetPhoneField = By.xpath("//*[@id='internet-phone']");
    private By internetSumField = By.xpath("//*[@id='internet-sum']");
    private By internetEmailField = By.xpath("//*[@id='internet-email']");

    private By instalmentScoreField = By.xpath("//*[@id='score-instalment']");
    private By instalmentSumField = By.xpath("//*[@id='instalment-sum']");
    private By instalmentEmailField = By.xpath("//*[@id='instalment-email']");

    private By arrearsScoreField = By.xpath("//*[@id='score-arrears']");
    private By arrearsSumField = By.xpath("//*[@id='arrears-sum']");
    private By arrearsEmailField = By.xpath("//*[@id='arrears-email']");
    private By continueButton2 = By.xpath("//*[@id='pay-connection']/button");


    // Методы
    public void acceptCookies() {
        driver.findElement(cookieCancelButton).click();
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLink).click();
    }

    public void enterPhoneNumber(String number) {
        driver.findElement(phoneNumberField).sendKeys(number);
    }

    public void enterAmount(String amount) {
        driver.findElement(priceField).sendKeys(amount);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getFieldPlaceholderText(By locator) {
        return driver.findElement(locator).getAttribute("Заполнить");
    }
    public String getPlaceholderText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute("placeholder");
    }


}

