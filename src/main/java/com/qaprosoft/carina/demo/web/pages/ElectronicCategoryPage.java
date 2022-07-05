package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ElectronicCategoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@data-id='1']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[text()='Телевизоры']")
    private ExtendedWebElement widjetTVBtn;

    public ElectronicCategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened(){
        return title.isElementPresent();
    }

    public TVSetsPage clickWidjetTVBtn(){
        widjetTVBtn.click();
        return new TVSetsPage(getDriver());
    }


}
