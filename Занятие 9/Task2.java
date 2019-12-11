package pvt;

import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.*;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/user/qqq/chromedriver");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.booking.com");

        chromeDriver.manage().window().maximize();

        WebElement destination = chromeDriver.findElement(By.xpath(".//input[@class=" +
                "\"c-autocomplete__input sb-searchbox__input sb-destination__input\"]"));
        destination.clear();
        destination.sendKeys("Париж");

        WebElement startMonth = chromeDriver.findElement(By.xpath
                ("(.//select[@class=\"sb-date-field__select-field js-date-field__select\"])[1]"));
        Select select1 = new Select(startMonth);
        select1.selectByIndex(1);

        WebElement startDay = chromeDriver.findElement(By.xpath
                ("(.//select[@class=\"sb-date-field__select-field js-date-field__select\"])[2]"));
        Select select2 = new Select(startDay);
        select2.selectByIndex(4);

        WebElement endMonth = chromeDriver.findElement(By.xpath
                ("(.//select[@class=\"sb-date-field__select-field js-date-field__select\"])[3]"));
        Select select3 = new Select(endMonth);
        select3.selectByIndex(1);

        WebElement endDay = chromeDriver.findElement(By.xpath
                ("(.//select[@class=\"sb-date-field__select-field js-date-field__select\"])[4]"));
        Select select4 = new Select(endDay);
        select4.selectByIndex(10);

//        WebElement startDate = chromeDriver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[3]"));
//        startDate.click();
//
//        WebElement endDate = chromeDriver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[9]"));
//        endDate.click();

        WebElement guestsAndRooms = chromeDriver.findElement(By.xpath(".//div[@class=\"xp__input-group xp__guests\"]"));
        guestsAndRooms.click();

        WebElement addAdults = chromeDriver.findElement(By.xpath("(.//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"])[1]"));
        addAdults.click();
        addAdults.click();

        WebElement addRooms = chromeDriver.findElement(By.xpath("(.//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"])[3]"));
        addRooms.click();

        WebElement submit = chromeDriver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
        submit.click();

        WebElement lowCost = chromeDriver.findElement(By.xpath(".//a[@data-id=\"pri-5\"]"));
        lowCost.click();

        Thread.sleep(3000);

        WebElement available = chromeDriver.findElement(By.xpath(".//a[@data-id=\"oos-1\"]"));
        chromeDriver.executeScript("arguments[0].scrollIntoView(true);", available);
        available.click();

        Thread.sleep(3000);

        WebElement chooseRatingOption = chromeDriver.findElement(By.xpath(".//li[@class=\" sort_category   sort_price \"]"));
        chooseRatingOption.click();

        Thread.sleep(3000);

        List<WebElement> listOfPrices = chromeDriver.findElements(By.xpath(".//div[@class=\"bui-price-display__value prco-inline-block-maker-helper\"]"));
        int[] pricesInt = new int[listOfPrices.size()];
        Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher;
        for (int i = 0; i<listOfPrices.size(); i++) {
            matcher = pat.matcher(listOfPrices.get(i).getText());
            while (matcher.find()) {
                pricesInt[i] = Integer.parseInt(matcher.group().replace(" ", ""));
            }
        }
        int minPrice = pricesInt[0];
        for (int i = 1; i < pricesInt.length; i++)
        {
            if (pricesInt[i] < minPrice)
            {
                minPrice = pricesInt[i];
            }
        }

        int dailyPrice = minPrice / 7;
        System.out.println(dailyPrice);
        System.out.println(dailyPrice >= 936 ? "Цена в нужном диапазоне." : "Слишком высокая цена");
    }
}