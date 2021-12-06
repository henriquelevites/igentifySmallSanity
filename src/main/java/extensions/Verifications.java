package extensions;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOpps;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class Verifications extends CommonOpps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Element Exists")
    public static void verifyElementExists(List<WebElement> elems) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        assertTrue(elems.size() > 0);
    }

    @Step("Verify Element Not Exists")
    public static void verifyElementNotExists(List<WebElement> elems) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(elems));
        assertFalse(elems.size() > 0);
    }

    @Step("Verify Elements Sort Low To High (Soft-Assertion)")
    public static void verifyElementsSortLowToHigh(List<WebElement> elems) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        List<Double> d_list = new ArrayList<>();
        //  ---------- Extract the value of each WebElement and add to a list of double numbers ----------
        for (WebElement elem : elems) {
            d_list.add(Double.parseDouble(elem.getText().substring(1)));
        }
        //  ---------- Compare each value in list to its next value ----------
        for (int i = 0; i < d_list.size() - 2; i++)
            softAssert.assertTrue(d_list.get(i) <= d_list.get(i+1),"Sorry, " + d_list.get(i) + " is higher than " + d_list.get(i+1));

        softAssert.assertAll("Not all items are sorted from low to high");
    }

    @Step("Verify Number Of Mobile Elements")
    public static void verifyNumberOfMobileElements(List<AndroidElement> mobileElems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(mobileElems.get(mobileElems.size()-1)));
        assertEquals(mobileElems.size(), expected);
    }

    @Step("Verify Element Is Displayed")
    public static void verifyElementDisplayed(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify Element Is Not Displayed")
    public static void verifyElementNotDisplayed(WebElement elem) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(elem));
        assertFalse(elem.isDisplayed());
    }

    @Step("Verify Element Is Enabled")
    public static void verifyElementEnabled(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isEnabled());
    }

    @Step("Verify Element Is Selected")
    public static void verifyElementSelected(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isSelected());
    }

    @Step("Verify Element Visually")
    public static void verifyVisualElement(String expectedImageName) {
        try
        {
            screen.find(getConfigData("ImageRepository") + expectedImageName + ".png");
        }
        catch (FindFailed findFailed)
        {
            findFailed.printStackTrace();
            System.out.println("Error Comparing Image File:" + findFailed);
            fail("Error Comparing Image File:" + findFailed);
        }
    }

    @Step("Verify Texts Comparison")
    public static void verifyTexts (String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Numbers Comparison")
    public static void verifyNumbers(int actual, int expected) {
        assertEquals(actual, expected);
    }
}
