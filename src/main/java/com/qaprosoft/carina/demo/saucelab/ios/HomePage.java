package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.AbstractViewMenu;
import com.qaprosoft.carina.demo.saucelab.common.AbstractHomePage;
import com.qaprosoft.carina.demo.saucelab.common.AbstractProductPage;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AbstractHomePage.class)
public class HomePage extends AbstractHomePage implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == \"AppTitle Icons\"`]")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`]")
    private ExtendedWebElement sortBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement viewMenuBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS[cd] \"%s\"`]")
    private ExtendedWebElement someGoodImage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractViewMenu viewMenu() {
        viewMenuBtn.click();
        return initPage(getDriver(), AbstractViewMenu.class);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public AbstractProductPage clickGoodImage(String title) {
        if (swipe(someGoodImage.format(title), 10)) {
            someGoodImage.format(title).click();
        }
        return initPage(getDriver(), AbstractProductPage.class);
    }
}
