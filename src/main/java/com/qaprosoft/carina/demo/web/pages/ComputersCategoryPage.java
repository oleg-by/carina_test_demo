package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ComputersCategoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@data-id='2']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[text()='Ноутбуки']")
    private ExtendedWebElement widjetTVBtn;

    public ComputersCategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened(){
        return title.isElementPresent();
    }

    public NotebooksPage clickWidjetTVBtn(){
        widjetTVBtn.click();
        return new NotebooksPage(getDriver());
    }

}
