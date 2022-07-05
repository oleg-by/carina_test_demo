package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='catalog-navigation__title']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//li[@data-id='1']")
    private ExtendedWebElement electronicCategoryBtn;

    @FindBy(xpath = "//li[@data-id='2']")
    private ExtendedWebElement computerCategoryBtn;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://catalog.onliner.by/");
    }

    public ElectronicCategoryPage clickElectronicCategoryBtn(){
        electronicCategoryBtn.click();
        return new ElectronicCategoryPage(getDriver());
    }

    public ComputersCategoryPage clickComputerCategoryBtn(){
        computerCategoryBtn.click();
        return new ComputersCategoryPage(getDriver());
    }
}
