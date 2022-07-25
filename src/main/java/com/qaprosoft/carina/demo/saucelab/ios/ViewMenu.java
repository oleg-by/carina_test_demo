package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.saucelab.common.AbstractViewMenu;
import com.qaprosoft.carina.demo.saucelab.common.AbstractHomePage;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AbstractViewMenu.class)
public class ViewMenu extends AbstractViewMenu implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name CONTAINS[cd] \"%s\"`]")
    private ExtendedWebElement itemTV;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;

    public ViewMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isViewMenuPresent(String item) {
        return itemTV.format(item).isElementPresent();
    }

    @Override
    public AbstractPage clickItem(String item) {
        itemTV.format(item).click();
        return initPage(getDriver(), AbstractPage.class);
    }

    @Override
    public AbstractHomePage closeViewMenu() {
        catalogBtn.click();
        return initPage(getDriver(), AbstractHomePage.class);
    }

    @Override
    public AbstractHomePage clickCatalogItem(String catalog) {
        return null;
    }
}
