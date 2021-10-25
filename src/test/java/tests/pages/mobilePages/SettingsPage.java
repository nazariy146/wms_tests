package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {
    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) ReceptionCardPage.getIdField(field).getWrappedDriver();
    }

    public void inputData(String field, String source) {
        SelenideElement ID = ReceptionCardPage.getIdField(field);
        ID.click();
        ID.val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = ReceptionCardPage.getIdField(field);
        ID.shouldHave(text(source));
    }

    public void clickButton(String field) {
        SelenideElement ID = ReceptionCardPage.getIdField(field);
        ID.click();
    }

    //MNV need to refactor
    public SelenideElement getConnectionStringInput() {
        return $(By.id("com.abmcloud:id/editTextCStr"));
    }
    public SelenideElement getLicenseInput() {
        return $(By.id("com.abmcloud:id/editTextLicenseNumber"));
    }
    public SelenideElement getSaveButton() {
        return $(By.id("com.abmcloud:id/buttonSave"));
    }
    //MNV need to refactor
}
