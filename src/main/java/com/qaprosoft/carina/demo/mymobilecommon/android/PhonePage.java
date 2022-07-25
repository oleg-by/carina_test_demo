package com.qaprosoft.carina.demo.mymobilecommon.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mymobilecommon.common.PhonePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhonePageBase.class)
public class PhonePage extends PhonePageBase implements IMobileUtils {

    @FindBy(id = "com.google.android.dialer:id/open_search_bar")
    private ExtendedWebElement openSearchBar;

    public PhonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchBarPresent() {
        return openSearchBar.isElementPresent();
    }
}
