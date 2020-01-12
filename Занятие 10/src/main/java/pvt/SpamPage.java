package pvt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage {
    @FindBy(xpath = "(.//div[@class=\"ll-av__container\"])[1]")
    private WebElement flagArea;

    @FindBy(xpath = "(.//div[@class=\"mb-checkbox__block\"])[4]")
    private WebElement flagButton;

    @FindBy(xpath = ".//span[@title=\"Спам\"]")
    private WebElement moveToSpamButton;

    @FindBy(xpath = ".//a[@href=\"/spam/\"]")
    private WebElement goToSpam;

    @FindBy(xpath = ".//span[@title=\"В папку\"]")
    private WebElement chooseFolder;

    @FindBy(xpath = ".//div[@title=\"Входящие\"]")
    private WebElement inboxFolder;

    public SpamPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
    }

    public void moveMessageToSpam(Actions action)
    {
        action.moveToElement(flagArea).build().perform();
        flagArea.click();
        moveToSpamButton.click();
    }

    public void returnFromSpam(Actions action)
    {
        goToSpam.click();
        action.moveToElement(flagArea).build().perform();
        flagArea.click();
        chooseFolder.click();
        inboxFolder.click();
    }
}
