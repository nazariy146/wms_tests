package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FindRestsPage {
    AndroidDriver driver;

    public static SelenideElement getIdField(String Field) {
        if (Field == "product"){
            return $(By.id("com.abmcloud:id/barcode"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/card_view_title"));
        }
        else if (Field == "sourceInfo"){
            return $(By.id("com.abmcloud:id/textViewItem"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/textViewRecord_count"));
        }
        else if (Field == "SeriesInfoString1"){
            return $(By.id("com.abmcloud:id/textViewSeries"));
        }
        else if (Field == "ShelfLifeInfoString1"){
            return $(By.id("com.abmcloud:id/textViewShelfLife"));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        else if (Field == ""){
            return $(By.id(""));
        }

        return null;
    }

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldHave(text(source));
    }

    public void setOnOrOffFreeRemainSwitcher(boolean state) {
        $(By.id("com.abmcloud:id/switchFreeRemains")).shouldBe(visible);
        $(By.id("com.abmcloud:id/switchFreeRemains")).click();
    }

    public SelenideElement getQuantityString1() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
    }
    public SelenideElement getLocationString1() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public SelenideElement getPartyInfoString1() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
    }
    public SelenideElement getLocationString2() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public SelenideElement getPartyInfoString2() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
    }
    public SelenideElement getQuantityString2() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
    }

    public void checkLocationString1(String expectedLocation1) {
        String actualLocation1 = getLocationString1().getText();
        Assert.assertEquals(actualLocation1, expectedLocation1, "Actual shelf life does not match expected shelf life");
    }

    public void checkPartyInfoString1(String partyInfoString1) {
        String actualPartyInfoString1 = getPartyInfoString1().getText();
        Assert.assertEquals(actualPartyInfoString1, partyInfoString1, "Actual shelf life does not match expected shelf life");
    }

    public void checkLocationString2(String expectedLocation2) {
        String actualLocation2 = getLocationString2().getText();
        Assert.assertEquals(actualLocation2, expectedLocation2, "Actual shelf life does not match expected shelf life");
    }

    public void checkPartyInfoString2(String partyInfoString1) {
        String partyInfoString2 = getPartyInfoString2().getText();
        Assert.assertEquals(partyInfoString2, partyInfoString1, "Actual shelf life does not match expected shelf life");
    }
}


