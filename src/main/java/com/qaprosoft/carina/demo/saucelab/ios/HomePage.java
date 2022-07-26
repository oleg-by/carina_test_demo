package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.MainMenuBase;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import com.qaprosoft.carina.demo.saucelab.common.ProductPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == \"AppTitle Icons\"`]")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`]")
    private ExtendedWebElement sortBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement mainMenuBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS \"%s\"`]")
    private ExtendedWebElement someGoodTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenuBase clickViewMenuBtn() {
        mainMenuBtn.click();
        return initPage(getDriver(), MainMenuBase.class);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public ProductPageBase clickGood(String title) {
        if (swipe(someGoodTitle.format(title), 10)) {
            someGoodTitle.format(title).click();
        }
        return initPage(getDriver(), ProductPageBase.class);
    }
}
