package com.epam.mobilegmail.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailMessagesPage {
    @FindBy(xpath = "//div[@id='views']//div[@class='lc']//div[@aria-label='Compose']")
    private WebElement buttonCompose;

    @FindBy(xpath = "//div[@id='views']//div[@class='lc']//div[@role='button']")
    private List<WebElement> buttons;

    @FindBy(xpath = "//div[@id='co_']//div[@id='cmal_composeto']")
    private WebElement getLabelTo;

    @FindBy(xpath = "//div[@id='co_']//input[@id='composeto']")
    private WebElement composeTo;

    @FindBy(xpath = "//div[@id='co_']//input[@id='cmcsubj']")
    private WebElement mailSubject;

    @FindBy(xpath = "//div[@id='co_']//div[@id='cmcbody']")
    private WebElement mailMessage;

    @FindBy(xpath = "//div[@id='views']//div[@class='kc']//div[@aria-label='Menu']")
    private WebElement menu;

    @FindBy(xpath = "//div[@id='mn_']//div[@role='menu']//div[@role='menuitem']")
    private List<WebElement> sendMails;

    @FindBy(xpath = "//div[@id='tl_']//div[@role='list']//div[contains(@class, 'ym')]/div[3]/span")
    private WebElement subjSendMessage;

    @FindBy(xpath = "//div[@id='tl_']//div[@role='list']//div[@aria-label='Select']")
    private WebElement sendMassege;

    @FindBy(xpath = "//div[@class='Kt']//div[@class='Bt']//div[@aria-label='Delete']")
    private WebElement deleteIcon;

    public GmailMessagesPage(AppiumDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCompose(){
        return buttonCompose.isDisplayed();
    }

    public void clickCompose(){
        buttonCompose.click();
    }


    public String verifyLabelTo(){
        return getLabelTo.getText();
    }

    public void writeMessage(String to, String subject, String message){
        composeTo.sendKeys(to);
        mailSubject.sendKeys(subject);
        mailMessage.sendKeys(message);
    }

    public void sendMessage(){
        buttons.get(1).click();
    }

    public void goToMenu(){
        menu.click();
    }

    public void getSendMails(){
        sendMails.get(5).click();
    }

    public String verifySendMessage(){
        return subjSendMessage.getText();
    }

    public void checkMessage(){
        sendMassege.click();
    }

    public void deleteMessage(){
        deleteIcon.click();
    }

    public boolean verifyDeleteMessage(){
        String subject = subjSendMessage.getText();
        return subject == "Test";
    }
}
