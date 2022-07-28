package com.qaprosoft.carina.demo.mymobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.saucelab.common.DrawingPageBase;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import com.qaprosoft.carina.demo.saucelab.common.MainMenuBase;
import com.qaprosoft.carina.demo.enums.MenuItem;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLabMobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testMainMenu() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        MainMenuBase viewMenu = homePage.clickMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent(MenuItem.WEBVIEW), "Main Menu isn't opened");
        Assert.assertTrue(viewMenu.closeMenu().isLogoPresent(), "App Home page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testDrawingPanel() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        MainMenuBase viewMenu = homePage.clickMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent(MenuItem.DRAWING), "Main Menu isn't opened");
        DrawingPageBase drawingPage = viewMenu.clickDrawingItem(MenuItem.DRAWING);
        Assert.assertTrue(drawingPage.isDrawingPanelPresent(), "Drawing panel isn't opened");
    }





}
