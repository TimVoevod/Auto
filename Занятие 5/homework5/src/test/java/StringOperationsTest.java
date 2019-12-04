import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class StringOperationsTest {

    @DataProvider
    public Object[][] dataProviderTestGetSumLength() {
        return new Object[][]{{"abc", "bca", 6}, {"bb", "aa", 4}, {"q", " ", 3}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetMaxLength() {
        return new Object[][]{{"abc", "bca", 3}, {"bb", "a", 2}, {"q", " ", 1}};
    }


    @Test(dataProvider = "dataProviderTestGetSumLength")
    public void testGetSumLength(String str1, String str2, int expected) {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getSumLength(str1, str2);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetMaxLength")
    public void testMaxLength(String str1, String str2, int expected) {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.maxLength(str1, str2);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = ArithmeticException.class)
    public void testSumLengthIsEven() {
        StringOperations stringOperations = new StringOperations();
        boolean expected = true;
        boolean actual = stringOperations.sumLengthIsEven("aa", "bb");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGet2XLine1PlusLine2() {
        StringOperations stringOperations = new StringOperations();
        String actual = stringOperations.get2XLine1PlusLine2("aa", "bb");
        String expected = "aaaabb";
        Assert.assertEquals(actual, expected);
    }

    @Test (enabled = false)
    public void testGetLine1Plus2XLine2() {
        StringOperations stringOperations = new StringOperations();
        String actual = stringOperations.getLine1Plus2XLine2("aa", "bb");
        String expected = "aabbbb";
        Assert.assertEquals(actual, expected);
    }
}