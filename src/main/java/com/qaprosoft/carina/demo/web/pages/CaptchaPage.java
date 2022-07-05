package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CaptchaPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='auth-form__title auth-form__title_base auth-form__title_condensed-other']")
    private ExtendedWebElement title;

    public CaptchaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened() {
        return title.isElementPresent();
    }
}
