package tests.steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import tests.pages.mobilePages.LoginPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class Steps {

    LoginPage loginPage = new LoginPage();

    public void loginAsAdmin() {
        loginPage.getUserNameInput().shouldBe(enabled).sendKeys("Admin");
        AndroidDriver driver = (AndroidDriver) loginPage.getUserNameInput().getWrappedDriver();
        loginPage.getUserNameInput().click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        loginPage.getUserPasswordInput().click();
        loginPage.getLoginButton().shouldBe(visible, enabled).click();
    }
}