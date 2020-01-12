package junitcucumber;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "igig1845@mail.ru";
    private static final String PASSWORD = "Chelseatorres9";
    private LoginPage loginPage;
    private WebDriver webDriver;
    private Eyes eyes;

    public LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/qqq/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        EyesRunner runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey("qptIEsUWWlDYBvEzDpzQ2XRyM06zlRnS5F2wuP5DEO4110");
        eyes.open(webDriver, "Mail.ru", "Composing message", new RectangleSize(800, 600));
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
        webDriver.manage().window().maximize();
        eyes.checkWindow("Main");
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        loginPage.enterLogin(LOGIN, eyes);
        loginPage.clickEnterButton();
        loginPage.enterPassword(PASSWORD);
        loginPage.clickEnterButton();
    }

    @Then("I see logout link")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @When("I compose message")
    public void writeMessage() {
        loginPage.composeMessage();
    }

    @Then("I see notification")
    public void seeNotification() {
        eyes.checkWindow("Compose Message");
        Assert.assertTrue(loginPage.notificationPresents());
    }

    @After
    public void afterClass() {
        eyes.closeAsync();
        webDriver.quit();
        eyes.abortIfNotClosed();
    }
}
