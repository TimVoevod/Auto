package pvt;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MessagesPageTest {

    private ChromeDriver driver;

    private Actions action;

    private MessagesPage messagesPage;

    private LoginPage loginPage;

    @BeforeClass

    public void beforeClass()

    {
        System.setProperty("webdriver.chrome.driver", "/Users/user/qqq/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        driver.manage().window().maximize();
        messagesPage = new MessagesPage(driver);
        loginPage = new LoginPage(driver);
        action = new Actions(driver);
    }

    @Test (priority = 1)
    public void loginTest()
    {
        loginPage.Login("igig1845", "Chelseatorres9");
    }

    @Test (priority = 4)
    public void composeForGroupTest()
    {
        messagesPage.composeForGroup();
    }

    @Test (priority = 2)
    public void flagThreeMessagesTest()
    {
        messagesPage.flagThreeMessages(action);
    }

    @Test (priority = 3)
    public void setUnFlagAllTest()
    {
        messagesPage.setUnFlagAll();
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
