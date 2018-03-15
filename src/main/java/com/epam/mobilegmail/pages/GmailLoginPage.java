package com.epam.mobilegmail.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
    @FindBy(xpath = "//nav//a[contains(@class, 'gmail-nav__nav-link__sign-in')]")
    private WebElement signIn;

    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement btnLoginNext;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement btnPasswordNext;

    public GmailLoginPage(AppiumDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void signIn(){
        signIn.click();
    }

    public void enterLoginAndSubmit(String login){
        loginInput.sendKeys(login);
        btnLoginNext.click();
    }

    public void enterPasswordAndSubmit(String password){
        passwordInput.sendKeys(password);
        btnPasswordNext.click();
    }
}
