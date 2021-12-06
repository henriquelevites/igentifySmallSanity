package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOpps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOpps {

    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Submit on Element")
    public static void submit(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.submit();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update Text Element As Human")
    public static void updateTextHuman(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS); // wait 0.5 seconds
            elem.sendKeys(ch + "");
        }
    }

    @Step("Clear Text Element")
    public static void clearText(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, WebElement text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        wait.until(ExpectedConditions.visibilityOf(text));
        dropDown.selectByVisibleText(text.getText());
    }

    @Step("Date Picker")
    public static void datePicker(List<WebElement> elems, String text) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        for (WebElement elem : elems) {
                if (elem.getText().equals(text)) {
                    elem.click();
                    break;
                }
            }
        }

    @Step("Mouse Hover Element")
    public static void mouseHover (WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
}

