package com.epam.mobilegmailtest;

import com.epam.mobilegmail.pages.GmailLoginPage;
import com.epam.mobilegmail.pages.GmailMessagesPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileGmailTest {

    private AppiumDriver driver;
    private static final String sendTo = "sometastypear@gmail.com";
    private static final String subject = "Test";
    private static final String bodyMessage = "Some simple text.";

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.0.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S6");
        capabilities.setCapability("browserName", "Browser");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);
        driver.get("https://mail.google.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void loginAndTestGmail(){
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.signIn();
        gmailLoginPage.enterLoginAndSubmit("sometastycherry");
        gmailLoginPage.enterPasswordAndSubmit("children12345");

        GmailMessagesPage gmailMessagesPage = new GmailMessagesPage(driver);

        Assert.assertTrue(gmailMessagesPage.verifyCompose(), "Compose not displayed.");

        gmailMessagesPage.clickCompose();
        String verifyTo = "To:";

        Assert.assertEquals(verifyTo, gmailMessagesPage.verifyLabelTo(), "Send Mail page not get.");

        gmailMessagesPage.writeMessage(sendTo, subject, bodyMessage);
        gmailMessagesPage.sendMessage();
        gmailMessagesPage.goToMenu();
        gmailMessagesPage.getSendMails();

        Assert.assertEquals(subject, gmailMessagesPage.verifySendMessage(), "Mail didn't sent.");

        gmailMessagesPage.checkMessage();
        gmailMessagesPage.deleteMessage();

        Assert.assertFalse(gmailMessagesPage.verifyDeleteMessage(), "Mail didn't delete.");
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}
