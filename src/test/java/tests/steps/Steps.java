package tests.steps;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.pages.mobilePages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Steps {
    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public static SelenideElement getIdField(String Field) {
        if (Field == "user"){
            return $(By.id("com.abmcloud:id/spn_user"));
        }
        else if (Field == "userSelect"){
            return $(By.id("com.abmcloud:id/text_input_end_icon"));
        }
        else if (Field == "logIn"){
            return $(By.id("com.abmcloud:id/btn_authorize"));
        }
        else if (Field == "password"){
            return $(By.id("com.abmcloud:id/et_password"));
        }

        return null;
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickButton(String button) {
        getIdField(button).click();
    }

    public void selectModalDialog(String field, String source) {
        getIdField(field).click();
        SelenideElement Element1 = $$(By.id("android:id/text1")).find(exactText(source));
        Element1.getId();
        Element1.getClass();
        Element1.click();
    }


    public void loginAsAdmin() {
        andrDriver("user");
        inputData("user","Admin");
        clickButton("password");
        clickButton("logIn");
    }
}