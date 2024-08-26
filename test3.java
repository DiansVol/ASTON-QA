package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test3 {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testOnlinePaymentLink() {
        driver.get("https://mts.by");

        WebElement onlinePaymentSection = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a"));
        assertTrue(onlinePaymentSection.isDisplayed());
        String expectedUrl = onlinePaymentSection.getAttribute("href");
        onlinePaymentSection.click();
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
