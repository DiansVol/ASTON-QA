package com.example.mts_test.pages;

import com.example.mts_test.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class zad3 {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testPaymentForm() {
        mainPage.selectConnectionOption();
        mainPage.enterPhoneNumber("297777777");
        mainPage.clickContinueButton();
        assertTrue(mainPage.isNextStepDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
