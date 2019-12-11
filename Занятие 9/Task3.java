package pvt;

import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.*;

public class Task3 {
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

        Thread.sleep(4000);

        WebElement available = chromeDriver.findElement(By.xpath(".//a[@data-id=\"oos-1\"]"));
        chromeDriver.executeScript("arguments[0].scrollIntoView(true);", available);
        available.click();

        Thread.sleep(4000);

        WebElement chooseRatingOption = chromeDriver.findElement(By.xpath(".//li[@class=\" sort_category   sort_price \"]"));
        chooseRatingOption.click();

        Thread.sleep(4000);

        WebElement cheapestHotel = chromeDriver.findElement(By.xpath("(.//div[@class=\"sr-cta-button-row\"])[1]"));
        cheapestHotel.click();

        for (String handle : chromeDriver.getWindowHandles()) {
            chromeDriver.switchTo().window(handle);
        }

        WebElement chooseRoom = chromeDriver.findElement(By.xpath
                ("(.//select[@class=\"hprt-nos-select\"])[1]"));
        chromeDriver.executeScript("arguments[0].scrollIntoView(true);", chooseRoom);
        Select selectRoom = new Select(chooseRoom);
        selectRoom.selectByValue("1");

        WebElement book = chromeDriver.findElement(By.xpath("(.//div[@class=\"hprt-reservation-cta\"])[2]"));
        book.click();

        WebElement tourist = chromeDriver.findElement(By.xpath(".//input[@id=\"bp_travel_purpose_leasure\"]"));
        tourist.click();

        WebElement status = chromeDriver.findElement(By.xpath
                (".//select[@class=\"bp_input_select bp_form__field__input\"]"));
        Select selectStatus = new Select(status);
        selectStatus.selectByValue("mr");

        WebElement name = chromeDriver.findElement(By.xpath(".//input[@name=\"firstname\"]"));
        name.sendKeys("Ivan");

        WebElement surname = chromeDriver.findElement(By.xpath(".//input[@name=\"lastname\"]"));
        surname.sendKeys("Ivanov");

        WebElement email = chromeDriver.findElement(By.xpath(".//input[@name=\"email\"]"));
        email.sendKeys("timvoevod@gmail.com");

        WebElement emailconfirm = chromeDriver.findElement(By.xpath(".//input[@name=\"email_confirm\"]"));
        emailconfirm.sendKeys("timvoevod@gmail.com");

        WebElement notstayer = chromeDriver.findElement(By.xpath(".//input[@id=\"notstayer_true\"]"));
        notstayer.click();

        WebElement lastButton = chromeDriver.findElement(By.xpath
                (".//button[@name=\"book\"]"));
        chromeDriver.executeScript("arguments[0].scrollIntoView(true);", lastButton);
        lastButton.click();

        WebElement address = chromeDriver.findElement(By.xpath(".//input[@name=\"address1\"]"));
        address.sendKeys("ул. Иванова");

        WebElement city = chromeDriver.findElement(By.xpath(".//input[@name=\"city\"]"));
        city.sendKeys("Иваново");

        WebElement country = chromeDriver.findElement(By.xpath
                (".//select[@name=\"cc1\"]"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("by");

        WebElement zip = chromeDriver.findElement(By.xpath(".//input[@name=\"zip\"]"));
        zip.sendKeys("555555");

        WebElement phone = chromeDriver.findElement(By.xpath(".//input[@name=\"phone\"]"));
        phone.sendKeys("+375555555555");

        WebElement bday = chromeDriver.findElement(By.xpath
                (".//select[@name=\"bday\"]"));
        Select selectDay = new Select(bday);
        selectDay.selectByValue("1");

        WebElement bmonth = chromeDriver.findElement(By.xpath
                (".//select[@name=\"bmonth\"]"));
        Select selectMonth = new Select(bmonth);
        selectMonth.selectByValue("1");

        WebElement byear = chromeDriver.findElement(By.xpath
                (".//select[@name=\"byear\"]"));
        Select selectYear = new Select(byear);
        selectYear.selectByValue("2000");

        WebElement cctype = chromeDriver.findElement(By.xpath
                (".//select[@name=\"cc_type\"]"));
        Select selectCardType = new Select(cctype);
        selectCardType.selectByValue("Visa");

        WebElement ccnumber = chromeDriver.findElement(By.xpath(".//input[@name=\"cc_number\"]"));
        ccnumber.sendKeys("4242 4242 4242 4242");

        WebElement ccyear = chromeDriver.findElement(By.xpath
                (".//select[@name=\"cc_year\"]"));
        Select selectCardYear = new Select(ccyear);
        selectCardYear.selectByValue("2020");

        WebElement cccvc = chromeDriver.findElement(By.xpath(".//input[@name=\"cc_cvc\"]"));
        cccvc.sendKeys("555");

        WebElement reviewButton = chromeDriver.findElement(By.xpath(".//button[@name=\"review\"]"));
        reviewButton.click();
    }
}