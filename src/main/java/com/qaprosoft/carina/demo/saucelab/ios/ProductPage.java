package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.MainMenuBase;
import com.qaprosoft.carina.demo.saucelab.common.ProductPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS[cd] \"%s\"`]")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[5]")
    private ExtendedWebElement productImage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"Price\"`]")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarSelected Icons\"`][%s]")
    private ExtendedWebElement rateStarSelected;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarUnSelected Icons\"`]")
    private ExtendedWebElement rateStarUnSelected;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label CONTAINS \"Color\"`]")
    private ExtendedWebElement colorsBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"SubtractMinus Icons\"`]")
    private ExtendedWebElement minusIcon;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"AddPlus Icons\"`]")
    private ExtendedWebElement plusIcon;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Add To Cart\"`]")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Product Highlights\"`]")
    private ExtendedWebElement productHighlightsTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextView")
    private ExtendedWebElement productHighlights;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
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
        return minusIcon.isElementPresent();
    }

    @Override
    public boolean isPlusIconPresent() {
        return plusIcon.isElementPresent();
    }

    @Override
    public boolean isAddToCartBtnPresent() {
        return addToCartBtn.isElementPresent();
    }

    @Override
    public boolean isHighlightsTitlePresent() {
        return swipe(productHighlightsTitle, 2);
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
        catalogBtn.click();
    }
}
