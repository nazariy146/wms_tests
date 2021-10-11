package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FindRestsPage {

    private SelenideElement getBarcodeInput() {
        return $(By.id("com.abmcloud:id/barcode"));
    }

    public void setBarcodeInput(String barCode) {
        getBarcodeInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getBarcodeInput().getWrappedDriver();
        getBarcodeInput().click();
        getBarcodeInput().val(barCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void checkFreeRemainSwitchState(boolean expectedSwitchState) {
        /*String actualSwitchStateText = $(By.id("com.abmcloud:id/switchFreeRemains")).getText();

        String expectedSwitchStateText;
        if (expectedSwitchState)
        {
            expectedSwitchStateText = "Free remain ON";
        }

        else {
            expectedSwitchStateText = "Free remain OFF";
        }
        Assert.assertEquals(actualSwitchStateText, expectedSwitchStateText, "Expected switch state "+expectedSwitchState+ " does not match actual switch state");
    */}

    public void setOnOrOffFreeRemainSwitcher(boolean state) {
        $(By.id("com.abmcloud:id/switchFreeRemains")).shouldBe(visible);
        $(By.id("com.abmcloud:id/switchFreeRemains")).click();
    }

    public SelenideElement getProductDescription() {
        return $(By.id("com.abmcloud:id/card_view_title"));
    }

    public void checkProductLocationInfo(String expectedLocation) {
        //String actualLocation = $(By.id("com.abmcloud:id/textViewLocation")).getText();
        String actualLocation = $(By.id("com.abmcloud:id/textViewItem")).getText();
        Assert.assertEquals(actualLocation, expectedLocation, "Actual location does not match expected location");
    }

    public SelenideElement getProductSeriesInfo() {
        return $(By.id("com.abmcloud:id/textViewSeries"));
    }

    public void checkProductSeriesInfo(String expectedSeries) {
        String actualSeries = getProductSeriesInfo().getText();
        Assert.assertEquals(actualSeries, expectedSeries, "Actual series does not match expected series");
    }

    public SelenideElement getProductShelfLifeInfo() {
        return $(By.id("com.abmcloud:id/textViewShelfLife"));
    }

    public void checkProductShelfLifeInfo(String expectedShelfLife) {
        String actualShelfLife = getProductShelfLifeInfo().getText();
        Assert.assertEquals(actualShelfLife, expectedShelfLife, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getProductQuantity() {
        return $(By.id("com.abmcloud:id/textViewRecord_count"));
    }

    public SelenideElement getLocationString1() {
        //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }

    public void checkLocationString1(String expectedLocation1) {
        String actualLocation1 = getLocationString1().getText();
        Assert.assertEquals(actualLocation1, expectedLocation1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getPartyInfoString1() {
        //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
    }

    public void checkPartyInfoString1(String partyInfoString1) {
        String actualPartyInfoString1 = getPartyInfoString1().getText();
        Assert.assertEquals(actualPartyInfoString1, partyInfoString1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getQuantityString1() {
        //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
    }

    public SelenideElement getLocationString2() {
        //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }

    public void checkLocationString2(String expectedLocation2) {
        String actualLocation2 = getLocationString2().getText();
        Assert.assertEquals(actualLocation2, expectedLocation2, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getPartyInfoString2() {
        //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
    }

    public void checkPartyInfoString2(String partyInfoString1) {
        String partyInfoString2 = getPartyInfoString2().getText();
        Assert.assertEquals(partyInfoString2, partyInfoString1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getQuantityString2() {
        //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
    }

}


