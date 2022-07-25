package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.AbstractViewMenu;
import com.qaprosoft.carina.demo.saucelab.common.AbstractProductPage;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AbstractProductPage.class)
public class ProductPage extends AbstractProductPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS[cd] \"%s\"`]")
    private ExtendedWebElement goodTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement viewMenuBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitleOpened(String title) {
        return goodTitle.format(title).isElementPresent();
    }

    @Override
    public AbstractViewMenu viewMenu() {
        viewMenuBtn.click();
        return initPage(getDriver(), AbstractViewMenu.class);
    }

    @Override
    public void backHome() {
        catalogBtn.click();
    }
}
