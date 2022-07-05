package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='lfloat _ohe']")
    private ExtendedWebElement title;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened() {
        return title.isElementPresent();
    }

}
