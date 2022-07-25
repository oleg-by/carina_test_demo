package com.qaprosoft.carina.demo.mymobilecommon.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mymobilecommon.common.CameraPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CameraPageBase.class)
public class CameraPage extends CameraPageBase implements IMobileUtils {

    @FindBy(id = "com.android.camera2:id/mode_options_overlay")
    private ExtendedWebElement image;

    public CameraPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isImagePresent() {
        return image.isElementPresent();
    }
}
