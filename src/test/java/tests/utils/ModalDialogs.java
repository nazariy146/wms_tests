package tests.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalDialogs {

    public static SelenideElement getAlertModalDialog() {
        return $(By.id("com.abmcloud:id/alertTitle"));
    }

    public static SelenideElement getMessageModalDialog() {
        return $(By.id("android:id/message"));
    }

    public static void clickSetOkYesButton() {
        $(By.id("android:id/button1")).click();
    }

    public static void clickCancelButton() {
        $(By.id("android:id/button2")).click();
    }

    public static void clickErrorDialogOkButton() {
        $(By.id("android:id/button2")).click();
    }

    public static SelenideElement getControlMessageModalDialog() {
        return $(By.id("com.abmcloud:id/alertTitle"));
    }
}
