package com.qaprosoft.carina.demo.mymobilecommon.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mymobilecommon.common.ChromePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromePageBase.class)
public class ChromePage extends ChromePageBase implements IMobileUtils {

    @FindBy(id = "com.android.chrome:id/terms_accept")
    private ExtendedWebElement acceptBtn;

    public ChromePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAcceptBtnPresent() {
        return acceptBtn.isElementPresent();
    }
}
