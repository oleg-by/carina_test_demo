package com.qaprosoft.carina.demo.mymobilecommon.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mymobilecommon.common.MessagePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MessagePageBase.class)
public class MessagePage extends MessagePageBase implements IMobileUtils {

    @FindBy(id = "com.google.android.apps.messaging:id/searchbar")
    private ExtendedWebElement searchBar;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchBarPresent() {
        return searchBar.isElementPresent();
    }
}
