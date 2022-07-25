package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.AbstractProductPage;
import com.qaprosoft.carina.demo.saucelab.common.AbstarctViewMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AbstractProductPage.class)
public class ProductPage extends AbstractProductPage {

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
    public AbstarctViewMenu viewMenu() {
        viewMenuBtn.click();
        return initPage(getDriver(), AbstarctViewMenu.class);
    }
}
