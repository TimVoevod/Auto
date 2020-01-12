package pvt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{
    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    public LoginPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
    }
    public void Login(String login, String password)
    {
        loginField.clear();
        loginField.sendKeys(login);
        buttonEnter.click();
        emailField.clear();
        emailField.sendKeys(password);
        buttonEnter.click();
    }

    public boolean logoutLinkPresents()
    {
        return logoutLink.isDisplayed();
    }
}