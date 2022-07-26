package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.saucelab.common.ViewMenuBase;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ViewMenuBase.class)
public class ViewMenu extends ViewMenuBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and contains(@text,\"%s\")]")
    private ExtendedWebElement menuItemBtn;

    public ViewMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isViewMenuPresent(String item) {
        return menuItemBtn.format(item).isElementPresent();
    }

    @Override
    public AbstractPage clickMenuItem(String item) {
        return null;
    }

    @Override
    public HomePageBase clickCatalogItem(String item) {
        menuItemBtn.format(item).click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePageBase closeMenu() {
        int height = getDriver().manage().window().getSize().getHeight();
        int width = getDriver().manage().window().getSize().getWidth();
        tap(width - 100, height / 2);
        return initPage(getDriver(), HomePageBase.class);
    }
}
