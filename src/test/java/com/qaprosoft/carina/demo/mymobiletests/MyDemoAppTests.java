package com.qaprosoft.carina.demo.mymobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.saucelab.common.*;
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
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        Set<String> titleList = new HashSet<>();
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
            Assert.assertTrue(productPage.scrollPageDown(), "Product page isn't scrolled!");
            productPage.backHome();
        }
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Sign in automatically; Log Out", value = {"mobile", "regression"})
    public void testLoginServices() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        MainMenuBase viewMenu = homePage.clickMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent(MenuItem.LOGIN), "Main Menu isn't opened.");
        LogInPageBase loginPage = viewMenu.clickLogInItem(MenuItem.LOGIN);
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
        loginPage.selectProvidedUsername();
        Assert.assertTrue(loginPage.areFieldsFilled(), "The username and password fields are not filled.");
        Assert.assertTrue(loginPage.clickLoginBtn().isLogoPresent(), "Catalog Page isn't opened.");
        viewMenu = homePage.clickMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent(MenuItem.LOGIN), "Main Menu isn't opened.");
        loginPage = viewMenu.clickLogInItem(MenuItem.LOGIN);
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Sort products by name, by price", value = {"mobile", "regression"})
    public void testSortProducts() {
        SoftAssert softAssert = new SoftAssert();
        SortedMap<String, Double> goodsMap = new TreeMap<>();
        goodsMap.put("Sauce Lab Back Packs", 29.99);
        goodsMap.put("Sauce Lab Bike Light", 9.99);
        goodsMap.put("Sauce Lab Bolt T-Shirt", 15.99);
        goodsMap.put("Sauce Lab Fleece T-Shirt", 49.99);
        goodsMap.put("Sauce Lab Onesie", 7.99);
        goodsMap.put("Test.sllTheThings() T-Shirt", 15.99);
        Collection<Double> prices = goodsMap.values();
        Double minPrice = prices
                .stream()
                .min(Comparator.comparingDouble(Double::doubleValue))
                .get();
        Double maxPrice = prices
                .stream()
                .max(Comparator.comparingDouble(Double::doubleValue))
                .get();
        String minPriceTitle = goodsMap.entrySet()
                .stream()
                .filter(entry -> minPrice.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        String maxPriceTitle = goodsMap.entrySet()
                .stream()
                .filter(entry -> maxPrice.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        softAssert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened");
        SortByPopUpPageBase sortByPopUp = homePage.clickSortBtn();
        softAssert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened");
        softAssert.assertTrue(sortByPopUp.clickSortBtn("nameDesc").compareResultOfSort(goodsMap.lastKey()), "Product sorting is wrong");
        sortByPopUp = homePage.clickSortBtn();
        softAssert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened");
        softAssert.assertTrue(sortByPopUp.clickSortBtn("priceAsc").compareResultOfSort(minPriceTitle), "Product sorting is wrong");
        sortByPopUp = homePage.clickSortBtn();
        softAssert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened");
        softAssert.assertTrue(sortByPopUp.clickSortBtn("priceDesc").compareResultOfSort(maxPriceTitle), "Product sorting is wrong");
        softAssert.assertAll();
    }

}
