package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchSuggestPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='modal-content']")
    private ExtendedWebElement title;

    public SearchSuggestPage(WebDriver driver) {
        super(driver);
    }

}
