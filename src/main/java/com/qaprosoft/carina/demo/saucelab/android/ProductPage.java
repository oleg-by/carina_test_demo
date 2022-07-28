package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.enums.MenuItem;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import com.qaprosoft.carina.demo.saucelab.common.ProductPageBase;
import com.qaprosoft.carina.demo.saucelab.common.MainMenuBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@resource-id = \"com.saucelabs.mydemoapp.android:id/productTV\" and contains(@text, \"%s\")]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/descTV\"]")
    private ExtendedWebElement productHighlights;

    @ExtendedFindBy(accessibilityId = "View menu")
    private ExtendedWebElement menuBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitleOpened(String title) {
        return productTitle.format(title).isElementPresent();
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
        MainMenuBase menu = this.clickMenuBtn();
        Assert.assertTrue(menu.isViewMenuPresent(MenuItem.CATALOG), "View Menu isn't opened");
        HomePageBase homePage = menu.clickCatalogItem(MenuItem.CATALOG);
        Assert.assertTrue(homePage.isLogoPresent(), "Home Page isn't opened");
    }
}
