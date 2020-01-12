package pvt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SpamPageTest

{

    private ChromeDriver driver;

    private Actions action;

    private SpamPage spamPage;

    private LoginPage loginPage;

    @BeforeClass

    public void beforeClass()

    {
        System.setProperty("webdriver.chrome.driver", "/Users/user/qqq/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        driver.manage().window().maximize();
        spamPage = new SpamPage(driver);
        loginPage = new LoginPage(driver);
        action = new Actions(driver);
    }

    @Test (priority = 1)
    public void loginTest()
    {
        loginPage.Login("igig1845", "Chelseatorres9");
//        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @Test (priority = 2)
    public void moveMessageToSpamTest()
    {
        spamPage.moveMessageToSpam(action);
    }

    @Test (priority = 3)
    public void returnFromSpamTest()
    {
        spamPage.returnFromSpam(action);
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
