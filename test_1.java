package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_1 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "//home/diana/IdeaProjects/lesson15/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://mts.by/");
    }

    @Test
    public void testOnlineTopUpBlockName() {
        WebElement onlineTopUpBlock = driver.findElement(By.xpath("#pay-section > div > div > div.col-12.col-xl-8 > section > div"));

        // Assert the expected name of the block.
        Assert.assertEquals(onlineTopUpBlock.getText(), "Онлайн пополнение без комиссии", "Название блока не соответствует ожидаемому.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
