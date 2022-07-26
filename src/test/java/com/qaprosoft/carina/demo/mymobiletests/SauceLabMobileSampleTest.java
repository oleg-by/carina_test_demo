package com.qaprosoft.carina.demo.mymobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.saucelab.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SauceLabMobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testMainMenu() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        MainMenuBase viewMenu = homePage.clickViewMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent("Web"), "Main Menu isn't opened");
        Assert.assertTrue(viewMenu.closeMenu().isLogoPresent(), "App Home page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testProducts() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("Sauce Lab Back Packs");
        if (currentDevice.get().getDeviceType().equals(DeviceType.Type.IOS_PHONE)) {
            titleList.add("Sauce Lab Bike Light");
        }
        titleList.add("Sauce Lab Bolt T-Shirt");
        titleList.add("Sauce Lab Fleece T-Shirt");
        titleList.add("Sauce Lab Onesie");
        titleList.add("Test.");
        for (String title : titleList) {
            ProductPageBase productPage = homePage.clickGood(title);
            Assert.assertTrue(productPage.isTitleOpened(title), title + " isn't opened!");
            productPage.backHome();
        }
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testDrawingPanel() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        MainMenuBase viewMenu = homePage.clickViewMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent("Drawing"), "Main Menu isn't opened");
        DrawingPageBase drawingPage = viewMenu.clickDrawingItem("Drawing");
        Assert.assertTrue(drawingPage.isDrawingPanelPresent(), "Drawing panel isn't opened");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Sign in automatically; Log Out", value = {"mobile", "regression"})
    public void testLoginServices() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        MainMenuBase viewMenu = homePage.clickViewMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent("Log"), "Main Menu isn't opened.");
        LogInPageBase loginPage = viewMenu.clickLogInItem("Log");
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
        loginPage.selectProvidedUsername();
        Assert.assertTrue(loginPage.areFieldsFilled(), "The username and password fields are not filled.");
        Assert.assertTrue(loginPage.clickLoginBtn().isLogoPresent(), "Catalog Page isn't opened.");
        viewMenu = homePage.clickViewMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent("Log"), "Main Menu isn't opened.");
        loginPage = viewMenu.clickLogInItem("Log");
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
    }


}
