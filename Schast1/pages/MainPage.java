package com.example.mts_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = "#pay-section > div > div > div.col-12.col-xl-8 > section > div")
    private WebElement onlineTopUpBlock;

    @FindBy(css = "#pay-section > div > div > div.col-12.col-xl-8 > section > div > a")
    private WebElement moreInfoLink;

    @FindBy(xpath = "//label[@for='connection']")
    private WebElement connectionOption;

    @FindBy(css = "#connection-phone")
    private WebElement phoneNumberField;

    @FindBy(css = "#pay-connection > button")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='payment__step']")
    private WebElement nextStepElement;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOnlineTopUpBlockTitle() {
        return onlineTopUpBlock.getText();
    }

    public String getMoreInfoLinkUrl() {
        return moreInfoLink.getAttribute("href");
    }

    public void selectConnectionOption() {
        connectionOption.click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isNextStepDisplayed() {
        return nextStepElement.isDisplayed();
    }
}
