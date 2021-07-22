package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProblemSituationCardPage {

    private SelenideElement getSourceInput () { return $(By.id("com.abmcloud:id/editTextSource"));}//обращение к полю Source

    public void setSourceInput(String sourceCode) { //ввод в поле Source
        getSourceInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getSourceInput().getWrappedDriver();
        getSourceInput().click();
        getSourceInput().val(sourceCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement textViewDescription () { return $(By.id("com.abmcloud:id/textViewDescription"));}//обращение к табличной части (инфа о ПС)

}
