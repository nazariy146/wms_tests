package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement getAlertMessage() {
            return $(By.id("android:id/message"));
    }

    public SelenideElement getOkAlertButton() {
        return $(By.id("android:id/button2"));
    }

    public SettingsPage clickSettingIcon() {
        $(By.id("com.abmcloud:id/buttonSettings")).shouldBe(enabled).click();
        return new SettingsPage();
    }

    public SelenideElement getUserNameInput() {
        return $(By.id("com.abmcloud:id/spinnerUserSel"));
    }

    public SelenideElement getUserPasswordInput() {
        return $(By.id("com.abmcloud:id/passwordUser"));
    }

    public SelenideElement getLoginButton() {
        return $(By.id("com.abmcloud:id/AuthorizationUser"));
    }
}
