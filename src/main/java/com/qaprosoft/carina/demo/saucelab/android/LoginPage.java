package com.qaprosoft.carina.demo.saucelab.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.saucelab.common.HomePageBase;
import com.qaprosoft.carina.demo.saucelab.common.LogInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LoginPage extends LogInPageBase implements IMobileUtils {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private ExtendedWebElement loginTitle;
    @FindBy(xpath = "//android.widget.EditText[@text = \"bod@example.com\"]")
    private ExtendedWebElement textFieldUsername;
    @FindBy(xpath = "//android.widget.EditText[@text = \"••••••••\"]")
    private ExtendedWebElement textFieldPassword;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private ExtendedWebElement testUsername;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void selectProvidedUsername() {
        testUsername.click();
    }

    @Override
    public HomePageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public boolean isLoginTitlePresent() {
        return loginTitle.isElementPresent();
    }

    @Override
    public boolean areFieldsFilled() {
        return textFieldUsername.isElementPresent() && textFieldPassword.isElementPresent();
    }
}
