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

    @ExtendedFindBy(accessibilityId = "Displays selected product")
    private ExtendedWebElement productImage;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private ExtendedWebElement productPrice;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/start1IV")
    private ExtendedWebElement rateStarSelected;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/start5IV")
    private ExtendedWebElement rateStarUnSelected;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, \"color\")]")
    private ExtendedWebElement colorsBtn;

    @ExtendedFindBy(accessibilityId = "Decrease item quantity")
    private ExtendedWebElement minusIcon;

    @ExtendedFindBy(accessibilityId = "Increase item quantity")
    private ExtendedWebElement plusIcon;

    @ExtendedFindBy(accessibilityId = "Tap to add product to cart")
    private ExtendedWebElement addToCartBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productHeightLightsTV")
    private ExtendedWebElement productHighlightsTitle;

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
    public boolean isImagePresent() {
        return productImage.isElementPresent();
    }

    @Override
    public boolean isPricePresent() {
        return productPrice.isElementPresent();
    }

    @Override
    public boolean isStarSelectedPresent() {
        return rateStarSelected.isElementPresent();
    }

    @Override
    public boolean isStarUnSelectedPresent() {
        return rateStarUnSelected.isElementPresent();
    }

    @Override
    public boolean isColorsPresent() {
        return colorsBtn.isElementPresent();
    }

    @Override
    public boolean isMinusIconPresent() {
        return swipe(minusIcon,2);
    }

    @Override
    public boolean isPlusIconPresent() {
        return swipe(plusIcon,2);
    }

    @Override
    public boolean isAddToCartBtnPresent() {
        return swipe(addToCartBtn,2);
    }

    @Override
    public boolean isHighlightsTitlePresent() {
        return swipe(productHighlightsTitle,2);
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
