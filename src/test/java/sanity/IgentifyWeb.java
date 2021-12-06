package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class IgentifyWeb extends CommonOpps {

    @Test(description = "Test01 - Home Page: navigate to Session 1")
    @Description("This test verifies user sees home session 1")
    public void test01_verifyHomeSession1() {
        WebFlows.navigateToSessionHome1();
        Verifications.verifyElementDisplayed(igentifyHome.txt_1st);
        Verifications.verifyTextInElement(igentifyHome.txt_1st, "And we’re bringing the future of patient care");
    }

    @Test(description = "Test02 - Home Page: navigate to Session 2")
    @Description("This test verifies user sees home session 2")
    public void test02_verifyHomeSession2() {
        WebFlows.navigateToSessionHome2();
        Verifications.verifyElementDisplayed(igentifyHome.btn_DiscoverAccess);
    }

    @Test(description = "Test03 - Home Page: navigate to Session 3")
    @Description("This test verifies user sees home session 3")
    public void test03_verifyHomeSession3() {
        WebFlows.navigateToSessionHome3();
        Verifications.verifyElementDisplayed(igentifyHome.btn_DiscoverAnalyze);
    }

    @Test(description = "Test04 - Verify Book Demo Flow example")
    @Description("This test verifies that book demo flow for a Genetic Clinic with igentifyCore product is successfully submited")
    public void test04_verifyBookDemo() {
        WebFlows.bookDemo("Tester", "Counselor", "henriquetest2@gmail.com", "");
        Verifications.verifyElementDisplayed(igentifyBookDemo.txt_Response);
        Verifications.verifyTextInElement(igentifyBookDemo.txt_Response, "Thank you for your message. It has been sent.");
    }

    @Test(description = "Test05 - Data Driven - Verify Book Demo", dataProvider = "data-provider-book", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verifies book demo using Data Driven")
    public void test05_verifyBookDemoWithDDT(String name, String job, String organization, String product, String email, String linkedin) {
        WebFlows.bookDemoDDT(name, job, organization, product, email, linkedin);
        Verifications.verifyElementDisplayed(igentifyBookDemo.txt_Response);
        Verifications.verifyTextInElement(igentifyBookDemo.txt_Response, "Thank you for your message. It has been sent.");
    }

    @Test(description = "Test06 - Contact Page - Open map")
    @Description("This test verifies the graphic element of Caesarea PardesHana Train Station picture Using Sikuli Tool")
    public void test06_verifyShowMap() {
        WebFlows.contactUs_showMap();
        Verifications.verifyVisualElement("CaesareaPardesHanaTrainStation");
    }
}
