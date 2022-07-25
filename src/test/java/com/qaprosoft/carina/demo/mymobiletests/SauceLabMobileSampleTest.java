package com.qaprosoft.carina.demo.mymobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.saucelab.common.AbstractProductPage;
import com.qaprosoft.carina.demo.saucelab.common.AbstractViewMenu;
import com.qaprosoft.carina.demo.saucelab.common.AbstractHomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class SauceLabMobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testMainMenu() {
        SoftAssert softAssert = new SoftAssert();
        AbstractHomePage homePage = initPage(getDriver(), AbstractHomePage.class);
        softAssert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        AbstractViewMenu viewMenu = homePage.viewMenu();
        softAssert.assertTrue(viewMenu.isViewMenuPresent("Web"), "View Menu isn't opened");
        softAssert.assertTrue(viewMenu.closeViewMenu().isLogoPresent(), "App Home page isn't opened");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testProducts() {
        AbstractHomePage homePage = initPage(getDriver(), AbstractHomePage.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("Sauce Lab Back Packs");
        //titleList.add("Sauce Lab Bike Light"); //the element in Android app with bug (app will be crashed after that)
        titleList.add("Sauce Lab Bolt T-Shirt");
        titleList.add("Sauce Lab Fleece T-Shirt");
        titleList.add("Sauce Lab Onesie");
        titleList.add("Test.");
        SoftAssert softAssert = new SoftAssert();
        for (String title : titleList) {
            AbstractProductPage productPage = homePage.clickGoodImage(title);
            softAssert.assertTrue(productPage.isTitleOpened(title), title + " isn't opened!");
            productPage.backHome();
        }
        softAssert.assertAll();
    }
}
