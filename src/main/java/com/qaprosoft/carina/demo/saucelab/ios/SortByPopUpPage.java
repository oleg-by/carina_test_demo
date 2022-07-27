package com.qaprosoft.carina.demo.saucelab.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import com.qaprosoft.carina.demo.saucelab.common.SortByPopUpPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortByPopUpPageBase.class)
public class SortByPopUpPage extends SortByPopUpPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "Sort by:")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Name - Ascending\"`]")
    private ExtendedWebElement nameAscSort;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Name - Descending\"`]")
    private ExtendedWebElement nameDescSort;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Price - Ascending\"`]")
    private ExtendedWebElement priceAscSort;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Price - Descending\"`]")
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
