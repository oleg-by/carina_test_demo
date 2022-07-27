package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.*;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name CONTAINS[cd] \"%s\"`]")
    private ExtendedWebElement menuItemBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;


    public MainMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isViewMenuPresent(MenuItem item) {
        return menuItemBtn.format(item.getMenu()).isElementPresent();
    }

    @Override
    public DrawingPageBase clickDrawingItem(MenuItem item) {
        menuItemBtn.format(item.getMenu()).click();
        return initPage(getDriver(), DrawingPageBase.class);
    }

    @Override
    public LogInPageBase clickLogInItem(MenuItem item) {
        menuItemBtn.format(item.getMenu()).click();
        return initPage(getDriver(), LogInPageBase.class);
    }

    @Override
    public HomePageBase closeMenu() {
        catalogBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePageBase clickCatalogItem(MenuItem item) {
        return null;
    }
}
