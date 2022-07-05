package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TVSetsPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='schema-header__title js-schema-header_title']")
    private ExtendedWebElement title;

    public TVSetsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened(){
        return title.isElementPresent();
    }
}
