package pageObjects.webIgentify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactUsPage {

    @FindBy(how = How.LINK_TEXT, using = "Show map")
    private WebElement btn_ShowMap;

    /*
      ##################################################################################################################
      The following "getter" methods are used to make sure that above WebElement/List<WebElement> are hidden from users.
      Method description: These methods provide access to private WebElement/List<WebElement>
      Methods parameter: none
      Methods return: public WebElement/List<WebElement>
      ##################################################################################################################
    */
    public WebElement getBtn_ShowMap() {
        return btn_ShowMap;
    }

}
