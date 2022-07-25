package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.AbstractProductPage;
import com.qaprosoft.carina.demo.saucelab.common.AbstarctViewMenu;
import com.qaprosoft.carina.demo.saucelab.common.AbstractHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AbstractHomePage.class)
public class HomePage extends AbstractHomePage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "App logo and name")
    private ExtendedWebElement logo;
    @ExtendedFindBy(accessibilityId = "View menu")
    private ExtendedWebElement viewMenuBtn;

    @ExtendedFindBy(accessibilityId = "Shows current sorting order and displays available sorting options")
    private ExtendedWebElement sortBtn;

    @ExtendedFindBy(accessibilityId = "View cart")
    private ExtendedWebElement cartBtn;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id = \"com.saucelabs.mydemoapp.android:id/productIV\" and contains(@content-desc, \"%s\")]")
    private ExtendedWebElement someGoodImage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstarctViewMenu viewMenu() {
        viewMenuBtn.click();
        return initPage(getDriver(), AbstarctViewMenu.class);
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
