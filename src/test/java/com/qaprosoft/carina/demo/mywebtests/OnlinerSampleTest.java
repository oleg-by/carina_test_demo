package com.qaprosoft.carina.demo.mywebtests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.web.model.User;
import com.qaprosoft.carina.demo.web.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class OnlinerSampleTest extends BaseTest {

    @Test(testName = "Default Login Test")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P1)
    public void testLoginDefault() {
        // Please make sure that username and password are provided by customer.
        User user = new User(USERNAME, PASSWORD);
        LoginPage loginPage = loginService.login();
        assertTrue(loginPage.isTitleOpened(), "Login page isn't opened!");
        loginPage.typeUsername(user.getUsername());
        loginPage.typePassword(user.getPassword());
        CaptchaPage captchaPage = loginPage.clickEnterBtn();
        assertTrue(captchaPage.isTitleOpened(), "Captcha page isn't opened!");
    }

    @Test(testName = "Facebook Login Test")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P2)
    public void testLoginFacebook() {
        LoginPage loginPage = loginService.login();
        assertTrue(loginPage.isTitleOpened(), "Login page isn't opened!");
        FacebookLoginPage facebookLoginPage = loginPage.clickFbBtn();
        assertTrue(facebookLoginPage.isPageOpened(), "Facebook login page isn't opened!");
    }

    @Test(testName = "Vkontakte Login Test")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P2)
    public void testLoginVkontakte() {
        LoginPage loginPage = loginService.login();
        assertTrue(loginPage.isTitleOpened(), "Login page isn't opened!");
        VkontakteLoginPage vkontakteLoginPage = loginPage.clickVkBtn();
        assertTrue(vkontakteLoginPage.isPageOpened(), "Vkontakte login page isn't opened!");
    }

    @Test(testName = "Google Login Test")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P2)
    public void testLoginGoogle() {
        LoginPage loginPage = loginService.login();
        assertTrue(loginPage.isTitleOpened(), "Login page isn't opened!");
        GoogleLoginPage googleLoginPage = loginPage.clickGgBtn();
        assertTrue(googleLoginPage.isPageOpened(), "Google login page isn't opened!");
    }

    @Test(testName = "Search Bar Test")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P1)
    public void testSearchProducts() {
        String search = "Apple iPhone 13 Pro Max 1TB (альпийский зеленый)";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page isn't opened!");
        SearchSuggestPage searchSuggestPage = homePage.typeSearchRq(search);
        softAssert.assertTrue(searchSuggestPage.isPageOpened(), "Search suggest page isn't opened!");
        softAssert.assertAll();
    }

    @Test(testName = "Catalog Onliner Test: TV sets")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P1)
    public void testCatalogTVSets() {
        SoftAssert softAssert = new SoftAssert();
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        softAssert.assertTrue(catalogPage.isPageOpened(), "Catalog Page isn't opened!");
        ElectronicCategoryPage electronicCategoryPage = catalogPage.clickElectronicCategoryBtn();
        softAssert.assertTrue(electronicCategoryPage.isTitleOpened(), "Page isn't opened!");
        TVSetsPage tVsetsPage = electronicCategoryPage.clickWidjetTVBtn();
        softAssert.assertTrue(tVsetsPage.isTitleOpened(), "TV Page isn't opened!");
        softAssert.assertAll();
    }

    @Test(testName = "Catalog Onliner Test: PCs")
    @MethodOwner(owner = "oleg-by")
    @TestPriority(Priority.P1)
    public void testCatalogPCs() {
        SoftAssert softAssert = new SoftAssert();
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        softAssert.assertTrue(catalogPage.isPageOpened(), "Catalog Page isn't opened!");
        ComputersCategoryPage computersCategoryPage = catalogPage.clickComputerCategoryBtn();
        softAssert.assertTrue(computersCategoryPage.isTitleOpened(), "Page isn't opened!");
        NotebooksPage notebooksPage = computersCategoryPage.clickWidjetTVBtn();
        softAssert.assertTrue(notebooksPage.isTitleOpened(), "Notebooks Page isn't opened!");
        softAssert.assertAll();
    }

}
