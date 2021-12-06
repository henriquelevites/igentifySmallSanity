package pageObjects.webIgentify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookDemoPage {

    @FindBy(how = How.NAME, using = "your-name")
    public WebElement txt_Name;

    @FindBy(how = How.NAME, using = "your-job")
    public WebElement txt_Job;

    @FindBy(how = How.CSS, using = ".wpcf7-form-control-wrap.menu-442")
    public WebElement cntrl_ComboxOrg;

    @FindBy(how = How.CSS, using = "span[data-value='Laboratory']")
    public WebElement option_Laboratory;

    @FindBy(how = How.CSS, using = "span[data-value='Genetic Clinic']")
    public WebElement option_GeneticClinic;

    @FindBy(how = How.CSS, using = "span[data-value='Hospital']")
    public WebElement option_Hospital;

    @FindBy(how = How.CSS, using = "span[data-value='Genetic Test Provider']")
    public WebElement option_GeneticTestProvider;

    @FindBy(how = How.CSS, using = "span[data-value='Other']")
    public WebElement option_Other;

    @FindBy(how = How.CSS, using = ".wpcf7-form-control-wrap.menu-443")
    public WebElement cntrl_ComboxProd;

    @FindBy(how = How.CSS, using = "span[data-value='igentify Plus']")
    public WebElement option_IgentifyPlus;

    @FindBy(how = How.CSS, using = "span[data-value='igentify Core']")
    public WebElement option_IgentifyCore;

    @FindBy(how = How.NAME, using = "your-email")
    public WebElement txt_Email;

    @FindBy(how = How.NAME, using = "your-linkedin")
    public WebElement txt_Linkedin;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    public WebElement btn_Submit;

    @FindBy(how = How.CSS, using = "div[class='wpcf7-response-output']")
    public WebElement txt_Response;
}