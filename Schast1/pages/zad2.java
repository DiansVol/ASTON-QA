package com.example.mts_test.pages;

import com.example.mts_test.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class zad2 {

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
    public void testLinkFunctionality() {
        String expectedUrl = "https://mts.by/ru/private/mobile/pay-services/payment-options/";
        String actualUrl = mainPage.getMoreInfoLinkUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
