package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VkontakteLoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'oauth_head']")
    private ExtendedWebElement title;

    public VkontakteLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened() {
        return title.isElementPresent();
    }
}
