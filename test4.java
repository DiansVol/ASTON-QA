package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test4 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by/");
    }

    @Test
    public void checkOnlinePayment() {
        WebElement paymentSection = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div"));

        WebElement onlinePaymentButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        onlinePaymentButton.click();


        WebElement servicesField = driver.findElement(By.id("service"));
        servicesField.sendKeys("Услуги связи");

        WebElement phoneNumberField = driver.findElement(By.id("phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/payment/"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}