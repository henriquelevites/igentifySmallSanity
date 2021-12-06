package pageObjects.webIgentify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how = How.CSS, using = "a[href='#1']")
    public WebElement nav_1st;

    @FindBy(how = How.CSS, using = "a[href='#2']")
    public WebElement nav_2nd;

    @FindBy(how = How.CSS, using = "a[href='#3']")
    public WebElement nav_3th;

    @FindBy(how = How.ID, using = "get_started_bt")
    public WebElement btn_BookDemo;

    @FindBy(how = How.XPATH, using = "//li[@id='menu-item-172']/a")
    public WebElement btn_Contact;

    @FindBy(how = How.XPATH, using = "//p[text()=\"And we’re bringing the future of patient care\"]")
    public WebElement txt_1st;

    @FindBy(how = How.XPATH, using = "//div[text()='Discover Access™']")
    public WebElement btn_DiscoverAccess;

    @FindBy(how = How.XPATH, using = "//div[text()='Discover Analyze™']")
    public WebElement btn_DiscoverAnalyze;
}
