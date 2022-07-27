package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.MenuItem;
import com.qaprosoft.carina.demo.saucelab.common.ProductPageBase;
import com.qaprosoft.carina.demo.saucelab.common.MainMenuBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@resource-id = \"com.saucelabs.mydemoapp.android:id/productTV\" and contains(@text, \"%s\")]")
    private ExtendedWebElement goodTitle;

    @FindBy(xpath = "")
    private ExtendedWebElement productHighlights;

    @ExtendedFindBy(accessibilityId = "View menu")
    private ExtendedWebElement menuBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitleOpened(String title) {
        return goodTitle.format(title).isElementPresent();
    }

    @Override
    public boolean scrollPageDown() {
        return swipe(productHighlights, 2);
    }

    @Override
    public MainMenuBase clickMenuBtn() {
        menuBtn.click();
        return initPage(getDriver(), MainMenuBase.class);
    }

    @Override
    public void backHome() {
        MainMenuBase viewMenu = this.clickMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent(MenuItem.CATALOG), "View Menu isn't opened");
        Assert.assertTrue(viewMenu.clickCatalogItem(MenuItem.CATALOG).isLogoPresent(), "Home Page isn't opened");
    }
}
