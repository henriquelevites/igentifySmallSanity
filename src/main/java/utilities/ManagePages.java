package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.webIgentify.BookDemoPage;
import pageObjects.webIgentify.HomePage;
import pageObjects.webIgentify.ContactUsPage;

public class ManagePages extends Base{

    public static void initWebIgentify() {

        igentifyHome = PageFactory.initElements(driver, HomePage.class);
        igentifyBookDemo = PageFactory.initElements(driver, BookDemoPage.class);
        igentifyContactUs = PageFactory.initElements(driver, ContactUsPage.class);
    }

}
