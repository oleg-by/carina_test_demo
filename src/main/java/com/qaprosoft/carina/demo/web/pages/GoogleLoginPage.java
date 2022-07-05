package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleLoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'xkfVF']")
    private ExtendedWebElement title;

    public GoogleLoginPage(WebDriver driver) {
        super(driver);
    }

}
