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

