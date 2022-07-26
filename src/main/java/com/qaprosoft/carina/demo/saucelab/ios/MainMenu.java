package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.DrawingPageBase;
import com.qaprosoft.carina.demo.saucelab.common.LogInPageBase;
import com.qaprosoft.carina.demo.saucelab.common.MainMenuBase;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
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
    public boolean isViewMenuPresent(String item) {
        return menuItemBtn.format(item).isElementPresent();
    }

    @Override
    public DrawingPageBase clickDrawingItem(String item) {
        menuItemBtn.format(item).click();
        return initPage(getDriver(), DrawingPageBase.class);
    }

    @Override
    public LogInPageBase clickLogInItem(String item) {
        menuItemBtn.format(item).click();
        return initPage(getDriver(), LogInPageBase.class);
    }

    @Override
    public HomePageBase closeMenu() {
        catalogBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePageBase clickCatalogItem(String catalog) {
        return null;
    }
}
