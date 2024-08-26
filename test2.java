package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test2{

    @Test
    public void checkPaymentLogos() {
        System.setProperty("webdriver.chrome.driver", "/home/diana/IdeaProjects/lesson15/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://mts.by/");

        WebElement paymentSection = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners"));

        List<WebElement> paymentLogos = paymentSection.findElements(By.tagName("img"));

        assert !paymentLogos.isEmpty() : "Логотипы платежных систем не найдены!";

        driver.quit();
    }
}
