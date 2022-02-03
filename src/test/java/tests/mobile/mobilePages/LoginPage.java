package tests.mobile.mobilePages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SettingsPage clickSettingIcon() {
        //$(By.id("com.abmcloud:id/buttonSettings")).shouldBe(enabled).click(); - элемент Релиз4
        $(By.id("com.abmcloud:id/ib_settings")).shouldBe(visible, Duration.ofSeconds(25));
        $(By.id("com.abmcloud:id/ib_settings")).shouldBe(enabled).click(); //- элемент Релиз5
        return new SettingsPage();
    }
    //MNV need to dell
//
//    public SelenideElement getUserNameInput() {
//        return $(By.id("com.abmcloud:id/spinnerUserSel"));
//    }
//
//    public SelenideElement getUserPasswordInput() {
//        return $(By.id("com.abmcloud:id/passwordUser"));
//    }
//
//    public SelenideElement getLoginButton() {
//        return $(By.id("com.abmcloud:id/AuthorizationUser"));
//    }
//    public SelenideElement User() {
//        return $(By.id("com.abmcloud:id/layout_user"));
//    }
    //MNV need to dell

}
