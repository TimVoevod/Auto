package pvt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagesPage {

    @FindBy(xpath = "(.//div[@class=\"ll-av__container\"])[1]")
    private WebElement flagArea;

    @FindBy(xpath = "(.//div[@class=\"ll-av__container\"])[2]")
    private WebElement flagArea2;

    @FindBy(xpath = "(.//div[@class=\"ll-av__container\"])[3]")
    private WebElement flagArea3;

    @FindBy(xpath = "(.//div[@class=\"mb-checkbox__block\"])[4]")
    private WebElement flagButton;

    @FindBy(xpath = ".//span[@class=\"compose-button__wrapper\"]")
    private WebElement composeMessage;

    @FindBy(xpath = "(.//input[@class=\"container--H9L5q size_s--3_M-_\"])[1]")
    private WebElement receiversList;

    @FindBy(xpath = ".//div[@role=\"textbox\"]")
    private WebElement messageContent;

    @FindBy(xpath = ".//span[@title=\"Отправить\"]")
    private  WebElement sendButton;

    @FindBy(xpath = ".//span[@title=\"Выделить все\"]")
    private WebElement flagAll;

    @FindBy(xpath = "(.//span[@class=\"button2__wrapper\"])[2]")
    private WebElement unFlagAll;

    public MessagesPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
    }

    public void composeForGroup()
    {
        composeMessage.click();
        receiversList.clear();
        receiversList.sendKeys("mail1@mail.ru mail2@mail.ru");
        messageContent.clear();
        messageContent.sendKeys("Message Text");
        sendButton.click();
    }

    public void flagThreeMessages(Actions action)
    {
        action.moveToElement(flagArea).build().perform();
        flagArea.click();
        action.moveToElement(flagArea2).build().perform();
        flagArea2.click();
        action.moveToElement(flagArea3).build().perform();
        flagArea3.click();
    }

    public void setUnFlagAll()
    {
        flagAll.click();
        unFlagAll.click();
    }
}
