package tests.mobile.mobileSteps;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MobileSteps {

    public  static AndroidDriver mobileDriver;

    public void mobileDriver(String field) {
        mobileDriver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public void verifyData(SelenideElement resourceId, String data) {
        resourceId.shouldBe(visible, Duration.ofSeconds(25));
        resourceId.shouldHave(text(data));
    }

    public void inputData(SelenideElement resourceId, String data) {
        resourceId.click();
        resourceId.val(data);
        mobileDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickButton(SelenideElement resourceId) {
        resourceId.click();
    }

    //MNV need to refactor
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
    public void selectModalDialog(String field, String source) {
        getIdField(field).click();
        SelenideElement Element1 = $$(By.id("android:id/text1")).find(exactText(source));
        Element1.getId();
        Element1.getClass();
        Element1.click();
    }
    public void loginAsAdmin() {
        SelenideElement idUser = getIdField("user");
        SelenideElement idPassword = getIdField("password");
        SelenideElement idlogIn = getIdField("logIn");

        mobileDriver("user");
        inputData(idUser,"Admin");
        clickButton(idPassword);
        clickButton(idlogIn);
    }
    //MNV need to refactor
}