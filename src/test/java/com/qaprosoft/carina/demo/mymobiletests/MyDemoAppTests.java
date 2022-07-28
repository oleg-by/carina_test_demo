package com.qaprosoft.carina.demo.mymobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.enums.MenuItem;
import com.qaprosoft.carina.demo.enums.SortBy;
import com.qaprosoft.carina.demo.saucelab.common.*;
import com.qaprosoft.carina.demo.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class MyDemoAppTests implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Check each product", value = {"mobile", "regression"})
    public void testEachProduct() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened.");
        Set<String> titleList = new HashSet<>();
        titleList.add("Sauce Lab Back Packs");
        if (MobileUtils.isIOS()) {
            titleList.add("Sauce Lab Bike Light");
        }
        titleList.add("Sauce Lab Bolt T-Shirt");
        titleList.add("Sauce Lab Fleece T-Shirt");
        titleList.add("Sauce Lab Onesie");
        titleList.add("Test.");
        for (String title : titleList) {
            ProductPageBase productPage = homePage.clickGood(title);
            Assert.assertTrue(productPage.isTitleOpened(title), title + " isn't opened.");
            Assert.assertTrue(productPage.scrollPageDown(), "Product page isn't scrolled.");
            productPage.backHome();
        }
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Sign in automatically; Log Out", value = {"mobile", "regression"})
    public void testLoginServices() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened.");
        MainMenuBase menu = homePage.clickMenuBtn();
        Assert.assertTrue(menu.isViewMenuPresent(MenuItem.LOGIN), "Main Menu isn't opened.");
        LogInPageBase loginPage = menu.clickLogInItem(MenuItem.LOGIN);
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
        loginPage.selectProvidedUsername();
        Assert.assertTrue(loginPage.areFieldsFilled(), "The username and password fields are not filled.");
        homePage = loginPage.clickLoginBtn();
        Assert.assertTrue(homePage.isLogoPresent(), "Catalog Page isn't opened.");
        menu = homePage.clickMenuBtn();
        Assert.assertTrue(menu.isViewMenuPresent(MenuItem.LOGIN), "Main Menu isn't opened.");
        loginPage = menu.clickLogInItem(MenuItem.LOGIN);
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Sort products by name, by price", value = {"mobile", "regression"})
    public void testSortProducts() {
        SoftAssert softAssert = new SoftAssert();
        SortedMap<String, Double> productMap = new TreeMap<>();
        productMap.put("Sauce Lab Back Packs", 29.99);
        productMap.put("Sauce Lab Bike Light", 9.99);
        productMap.put("Sauce Lab Bolt T-Shirt", 15.99);
        productMap.put("Sauce Lab Fleece T-Shirt", 49.99);
        productMap.put("Sauce Lab Onesie", 7.99);
        if (MobileUtils.isIOS()) {
            productMap.put("Test.allTheThings() T-Shirt", 15.99);
        } else {
            productMap.put("Test.sllTheThings() T-Shirt", 15.99);
        }
        Collection<Double> prices = productMap.values();
        Double minPrice = prices
                .stream()
                .min(Comparator.comparingDouble(Double::doubleValue))
                .get();
        Double maxPrice = prices
                .stream()
                .max(Comparator.comparingDouble(Double::doubleValue))
                .get();
        String minPriceTitle = productMap.entrySet()
                .stream()
                .filter(entry -> minPrice.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        String maxPriceTitle = productMap.entrySet()
                .stream()
                .filter(entry -> maxPrice.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        softAssert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened.");
        SortByPopUpPageBase sortByPopUp = homePage.clickSortBtn();
        softAssert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened.");
        homePage = sortByPopUp.clickSortingMethodBtn(SortBy.NAME_DESK);
        softAssert.assertEquals(homePage.getFirstSortedProduct(), productMap.lastKey(), "Product sorting is wrong.");
        sortByPopUp = homePage.clickSortBtn();
        softAssert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened.");
        homePage = sortByPopUp.clickSortingMethodBtn(SortBy.PRICE_ASC);
        softAssert.assertEquals(homePage.getFirstSortedProduct(), minPriceTitle, "Product sorting is wrong.");
        sortByPopUp = homePage.clickSortBtn();
        softAssert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened.");
        homePage = sortByPopUp.clickSortingMethodBtn(SortBy.PRICE_DESC);
        softAssert.assertEquals(homePage.getFirstSortedProduct(), maxPriceTitle, "Product sorting is wrong.");
        softAssert.assertAll();
    }

}
