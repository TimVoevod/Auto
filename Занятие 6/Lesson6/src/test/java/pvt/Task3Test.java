package pvt;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task3Test {

    @DataProvider
    public Object[][] dataProviderTestGetLength() {
        return new Object[][]{{"abc", 3}, {"", 0}, {"  hhh  ", 7}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetSum() {
        return new Object[][]{{"abc", "bca", "abcbca"}, {"", "", ""}, {"  hhh  ", "  ", "  hhh    "}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetReverseSum() {
        return new Object[][]{{"abc", "bca", "cc", "ccbcaabc"}, {"", "", "", ""}, {"  hhh  ", "  ", "qq", "qq    hhh  "}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetSumLength() {
        return new Object[][]{{"abc", "bca", 6}, {"bb", "aa", 4}, {"q", " ", 2}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetMaxLength() {
        return new Object[][]{{"abc", "bca", 3}, {"bb", "a", 2}, {"q", " ", 1}};
    }

    @Test(dataProvider = "dataProviderTestGetSum")
    public void testGetSum(String str1, String str2, String expected) {
        Task3 task3 = new Task3();
        String actual = task3.getSum(str1, str2);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetReverseSum")
    public void testGetReverseSum(String str1, String str2, String str3, String expected) {
        Task3 task3 = new Task3();
        String actual = task3.getReverseSum(str1, str2, str3);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetLength")
    public void testGetLength(String str, int expected) {
        Task3 task3 = new Task3();
        int actual = task3.getLength(str);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetSumLength")
    public void testGetSumLength(String str1, String str2, int expected) {
        Task3 task3 = new Task3();
        int actual = task3.getSumLength(str1, str2);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetMaxLength")
    public void testMaxLength(String str1, String str2, int expected) {
        Task3 task3 = new Task3();
        int actual = task3.maxLength(str1, str2);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSumLengthIsEven() {
        Task3 task3 = new Task3();
        boolean expected = true;
        boolean actual = task3.sumLengthIsEven("aa", "bb");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGet2XLine1PlusLine2() {
        Task3 task3 = new Task3();
        String actual = task3.get2XLine1PlusLine2("aa", "bb");
        String expected = "aaaabb";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetLine1Plus2XLine2() {
        Task3 task3 = new Task3();
        String actual = task3.getLine1Plus2XLine2("aa", "bb");
        String expected = "aabbbb";
        Assert.assertEquals(actual, expected);
    }
}
