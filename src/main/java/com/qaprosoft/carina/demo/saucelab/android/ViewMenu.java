package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.saucelab.common.AbstarctViewMenu;
import com.qaprosoft.carina.demo.saucelab.common.AbstractHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AbstarctViewMenu.class)
public class ViewMenu extends AbstarctViewMenu implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and contains(@text,\"%s\")]")
    private ExtendedWebElement itemTV;

    public ViewMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isViewMenuPresent(String item) {
        return itemTV.format(item).isElementPresent();
    }

    @Override
    public AbstractHomePage clickItem(String item) {
        itemTV.format(item).click();
        return initPage(getDriver(), AbstractHomePage.class);
    }

    @Override
    public AbstractHomePage closeViewMenu() {
        int height = getDriver().manage().window().getSize().getHeight();
        int width = getDriver().manage().window().getSize().getWidth();
        tap(width - 100, height / 2);
        return initPage(getDriver(), AbstractHomePage.class);
    }
}
