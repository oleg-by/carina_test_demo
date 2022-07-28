package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.enums.MenuItem;
import com.qaprosoft.carina.demo.saucelab.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and contains(@text,\"%s\")]")
    private ExtendedWebElement menuItemBtn;

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
    public HomePageBase clickCatalogItem(MenuItem item) {
        menuItemBtn.format(item.getMenu()).click();
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
