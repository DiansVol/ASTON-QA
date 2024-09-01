import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By onlineTopUpBlock = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div");
    private By servicesConnectionSection = By.cssSelector("#connection-phone");
    private By internetServicesSection = By.cssSelector("#internet-phone");
    private By instalmentSection = By.cssSelector("#score-instalment");
    private By arrearsSection = By.cssSelector("#score-arrears");

    private By phoneNumberField = By.cssSelector("#connection-phone");
    private By connectionSumField = By.cssSelector("#connection-sum");
    private By emailField = By.cssSelector("#connection-email");

    private By internetPhoneNumberField = By.cssSelector("#internet-phone");
    private By internetSumField = By.cssSelector("#internet-sum");
    private By internetEmailField = By.cssSelector("#internet-email");

    private By instalmentScoreField = By.cssSelector("#score-instalment");
    private By instalmentSumField = By.cssSelector("#instalment-sum");
    private By instalmentEmailField = By.cssSelector("#instalment-email");

    private By arrearsScoreField = By.cssSelector("#score-arrears");
    private By arrearsSumField = By.cssSelector("#arrears-sum");
    private By arrearsEmailField = By.cssSelector("#arrears-email");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneNumberField).getAttribute("value");
    }

    public String getConnectionSum() {
        return driver.findElement(connectionSumField).getAttribute("value");
    }

    public String getEmail() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getInternetPhoneNumber() {
        return driver.findElement(internetPhoneNumberField).getAttribute("value");
    }

    public String getInternetSum() {
        return driver.findElement(internetSumField).getAttribute("value");
    }

    public String getInternetEmail() {
        return driver.findElement(internetEmailField).getAttribute("value");
    }

    public String getInstalmentScore() {
        return driver.findElement(instalmentScoreField).getAttribute("value");
    }

    public String getInstalmentSum() {
        return driver.findElement(instalmentSumField).getAttribute("value");
    }

    public String getInstalmentEmail() {
        return driver.findElement(instalmentEmailField).getAttribute("value");
    }

    public String getArrearsScore() {
        return driver.findElement(arrearsScoreField).getAttribute("value");
    }

    public String getArrearsSum() {
        return driver.findElement(arrearsSumField).getAttribute("value");
    }

    public String getArrearsEmail() {
        return driver.findElement(arrearsEmailField).getAttribute("value");
    }

    public String getOnlineTopUpBlockText() {
        return driver.findElement(onlineTopUpBlock).getText();
    }

    public boolean hasLogos() {
        WebElement partnersElement = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners"));
        return partnersElement.findElements(By.tagName("img")).size() > 0;
    }

    public String getLinkUrl() {
        return driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a")).getAttribute("href");
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        driver.findElement(By.cssSelector("#pay-connection > button")).click();
    }
}
