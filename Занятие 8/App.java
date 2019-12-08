package pvt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/user/qqq/chromedriver");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.booking.com");

        chromeDriver.manage().window().maximize();

        WebElement destination = chromeDriver.findElement(By.xpath(".//input[@class=" +
                "\"c-autocomplete__input sb-searchbox__input sb-destination__input\"]"));
        destination.sendKeys("Москва");

        WebElement date = chromeDriver.findElement(By.xpath(".//div[@class=\"xp__dates xp__group\"]"));
        date.click();

        WebElement startDate = chromeDriver.findElement(By.xpath(".//span[@aria-label=\"18 Декабрь 2019\"]"));
        startDate.click();

        WebElement endDate = chromeDriver.findElement(By.xpath(".//span[@aria-label=\"20 Декабрь 2019\"]"));
        endDate.click();

        WebElement submit = chromeDriver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
        submit.click();

        WebElement openRatingOptions = chromeDriver.findElement(By.xpath(".//button[@id=\"sortbar_dropdown_button\"]"));
        openRatingOptions.click();

        WebElement chooseRatingOption = chromeDriver.findElement(By.xpath(".//a[@data-category=\"review_score_and_price\"]"));
        chooseRatingOption.click();

        Thread.sleep(3000);

        WebElement bestHotel = chromeDriver.findElement(By.xpath("(.//div[@class=\"sr-cta-button-row\"])[1]"));
        bestHotel.click();

        WebElement bestHotelScore = chromeDriver.findElement(By.xpath("(.//div[@class=\"bui-review-score__badge\"])[1]"));
        String strScore = bestHotelScore.getText();
        int intScore = Integer.parseInt(strScore);
        System.out.println(intScore >= 9 ? "Score is 9 or more." : "Score is less than 9.");

    }
}