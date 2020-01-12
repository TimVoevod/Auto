package junitcucumber;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static final int LINK_PRESENSE_TIMEOUT = 10;

    private WebDriver driver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;

    @FindBy(xpath = ".//span[@class=\"compose-button__wrapper\"]")
    private WebElement composeMessage;

    @FindBy(xpath = "(.//input[@class=\"container--H9L5q size_s--3_M-_\"])[1]")
    private WebElement receiversList;

    @FindBy(xpath = ".//div[@role=\"textbox\"]")
    private WebElement messageContent;

    @FindBy(xpath = ".//span[@title=\"Отправить\"]")
    private  WebElement sendButton;

    @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[2]/span")
    public WebElement notification;

    public LoginPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }

    public void enterLogin(String login, Eyes eyes) {
        loginField.clear();
        loginField.sendKeys(login);
        buttonEnter.click();
        eyes.checkWindow("Login");
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        buttonEnter.click();
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public boolean logoutLinkPresents() {
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink))
                .isDisplayed();
    }

    public void composeMessage() {
        composeMessage.click();
        receiversList.clear();
        receiversList.sendKeys("igig1845@mail.ru");
        messageContent.clear();
        messageContent.sendKeys("Message Text");
        sendButton.click();
    }

    public boolean notificationPresents() {
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(notification))
                .isDisplayed();
    }
}
