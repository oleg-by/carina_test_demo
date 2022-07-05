package com.qaprosoft.carina.demo.web.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.web.pages.HomePage;
import com.qaprosoft.carina.demo.web.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginService implements IDriverPool {

    public LoginPage login(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page isn't opened!");
        return homePage.clickloginBtn();
    }

}
