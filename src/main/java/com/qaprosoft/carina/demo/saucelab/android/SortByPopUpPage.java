package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import com.qaprosoft.carina.demo.saucelab.common.SortByPopUpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SortByPopUpPageBase.class)
public class SortByPopUpPage extends SortByPopUpPageBase implements IMobileUtils {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortTV")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "Ascending order by name")
    private ExtendedWebElement nameAscSort;

    @ExtendedFindBy(accessibilityId = "Descending order by name")
    private ExtendedWebElement nameDescSort;

    @ExtendedFindBy(accessibilityId = "Ascending order by price")
    private ExtendedWebElement priceAscSort;

    @ExtendedFindBy(accessibilityId = "Descending order by price")
    private ExtendedWebElement priceDescSort;

    public SortByPopUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return title.isElementPresent();
    }

    @Override
    public HomePageBase clickSortBtn(String sort) {
        switch (sort) {
            case "nameDesc":
                tap(nameDescSort);
                break;
            case "priceAsc":
                tap(priceAscSort);
                break;
            case "priceDesc":
                tap(priceDescSort);
                break;
            default:
                tap(nameAscSort);
        }
        return initPage(getDriver(), HomePageBase.class);
    }


}
