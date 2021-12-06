package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOpps;

import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOpps {


    @Step("Business Flow: Home page Navigation to Session 1")
    public static void navigateToSessionHome1() {
        UIActions.click(igentifyHome.nav_1st);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Home page Navigation to Session 2")
    public static void navigateToSessionHome2() {
        UIActions.click(igentifyHome.nav_2nd);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Home page Navigation to Session 3")
    public static void navigateToSessionHome3() {
        UIActions.click(igentifyHome.nav_3th);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Book a Demo for a Genetic Clinic with igentifyCore")
    public static void bookDemo(String name, String job, String email, String linkedin) {
        UIActions.click(igentifyHome.btn_BookDemo);
        UIActions.updateText(igentifyBookDemo.txt_Name, name);
        UIActions.updateText(igentifyBookDemo.txt_Job, job);
        UIActions.click(igentifyBookDemo.cntrl_ComboxOrg);
        UIActions.click(igentifyBookDemo.option_GeneticClinic);
        UIActions.click(igentifyBookDemo.cntrl_ComboxProd);
        UIActions.click(igentifyBookDemo.option_IgentifyCore);
        UIActions.updateText(igentifyBookDemo.txt_Email, email);
        UIActions.updateText(igentifyBookDemo.txt_Linkedin, linkedin);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        UIActions.submit(igentifyBookDemo.btn_Submit);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Book a Demo using DDT")
    public static void bookDemoDDT(String name, String job, String organization, String product, String email, String linkedin) {
        UIActions.click(igentifyHome.btn_BookDemo);
        UIActions.updateText(igentifyBookDemo.txt_Name, name);
        UIActions.updateText(igentifyBookDemo.txt_Job, job);

        // ---------- Holding organizations options ----------
        UIActions.click(igentifyBookDemo.cntrl_ComboxOrg);
        if (organization.equalsIgnoreCase("Laboratory"))
            UIActions.click(igentifyBookDemo.option_Laboratory);
        else if (organization.equalsIgnoreCase("Genetic Clinic"))
            UIActions.click(igentifyBookDemo.option_GeneticClinic);
        else if (organization.equalsIgnoreCase("Hospital"))
            UIActions.click(igentifyBookDemo.option_Hospital);
        else if (organization.equalsIgnoreCase("Genetic Test Provider"))
            UIActions.click(igentifyBookDemo.option_GeneticTestProvider);
        else UIActions.click(igentifyBookDemo.option_Other);
        // ---------- Holding products options ----------
        UIActions.click(igentifyBookDemo.cntrl_ComboxProd);
        if (product.equalsIgnoreCase("igentify Plus"))
            UIActions.click(igentifyBookDemo.option_IgentifyPlus);
        else UIActions.click(igentifyBookDemo.option_IgentifyCore);

        UIActions.updateText(igentifyBookDemo.txt_Email, email);
        UIActions.updateText(igentifyBookDemo.txt_Linkedin, linkedin);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        UIActions.submit(igentifyBookDemo.btn_Submit);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Contact Us - Show Map")
    public static void contactUs_showMap() {
        UIActions.click(igentifyHome.btn_Contact);
        UIActions.click(igentifyContactUs.getBtn_ShowMap());
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }
}
