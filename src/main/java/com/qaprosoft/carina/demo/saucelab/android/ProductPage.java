package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.ProductPageBase;
import com.qaprosoft.carina.demo.saucelab.common.ViewMenuBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id = \"com.saucelabs.mydemoapp.android:id/productTV\" and contains(@text, \"%s\")]")
    private ExtendedWebElement goodTitle;

    @ExtendedFindBy(accessibilityId = "View menu")
    private ExtendedWebElement viewMenuBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitleOpened(String title) {
        return goodTitle.format(title).isElementPresent();
    }

    @Override
    public ViewMenuBase clickViewMenuBtn() {
        viewMenuBtn.click();
        return initPage(getDriver(), ViewMenuBase.class);
    }

    @Override
    public void backHome() {
        ViewMenuBase viewMenu = this.clickViewMenuBtn();
        Assert.assertTrue(viewMenu.isViewMenuPresent("Catalog"), "View Menu isn't opened");
        Assert.assertTrue(viewMenu.clickCatalogItem("Catalog").isLogoPresent(), "Home Page isn't opened");
    }
}
