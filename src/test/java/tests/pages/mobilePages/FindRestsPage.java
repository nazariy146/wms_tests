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
        String actualLocation = $(By.id("com.abmcloud:id/textViewLocation")).getText();
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









    public SelenideElement getViewLocation1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public void checkViewLocation1(String expectedViewLocation1) {
        String actualViewLocation1 = getViewLocation1().getText();
        Assert.assertEquals(actualViewLocation1, expectedViewLocation1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewShelfLife1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public void checkViewShelfLife1(String expectedViewShelfLife1) {
        String actualViewShelfLife1 = getViewShelfLife1().getText();
        Assert.assertEquals(actualViewShelfLife1, expectedViewShelfLife1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewRecord_count1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
    }
    public void checkViewRecord_count1(String expectedViewRecord_count1) {
        String actualViewRecord_count1 = getViewRecord_count1().getText();
        Assert.assertEquals(actualViewRecord_count1, expectedViewRecord_count1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewLocation2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public void checkViewLocation2(String expectedViewLocation2) {
        String actualViewLocation2 = getViewLocation2().getText();
        Assert.assertEquals(actualViewLocation2, expectedViewLocation2, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewShelfLife2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public void checkViewShelfLife2(String expectedViewShelfLife2) {
        String actualViewShelfLife2 = getViewShelfLife2().getText();
        Assert.assertEquals(actualViewShelfLife2, expectedViewShelfLife2, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewRecord_count2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
    }
    public void checkViewRecord_count2(String expectedViewRecord_count2) {
        String actualViewRecord_count2 = getViewRecord_count2().getText();
        Assert.assertEquals(actualViewRecord_count2, expectedViewRecord_count2, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewSeries1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public void checkViewSeries1(String expectedViewSeries1) {
        String actualViewSeries1 = getViewSeries1().getText();
        Assert.assertEquals(actualViewSeries1, expectedViewSeries1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getViewSeries2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public void checkViewSeries2(String expectedViewSeries2) {
        String actualViewSeries2 = getViewSeries2().getText();
        Assert.assertEquals(actualViewSeries2, expectedViewSeries2, "Actual shelf life does not match expected shelf life");
    }















    public SelenideElement getProductQuantity() {
        return $(By.id("com.abmcloud:id/textViewRecord_count"));
    }

    public SelenideElement getLocationString1() {
        return $(By.xpath("/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }

    public void checkLocationString1(String expectedLocation1) {
        String actualLocation1 = getLocationString1().getText();
        Assert.assertEquals(actualLocation1, expectedLocation1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getPartyInfoString1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
    }

    public void checkPartyInfoString1(String partyInfoString1) {
        String actualPartyInfoString1 = getPartyInfoString1().getText();
        Assert.assertEquals(actualPartyInfoString1, partyInfoString1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getQuantityString1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
    }

    public SelenideElement getLocationString2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
    }

    public void checkLocationString2(String expectedLocation2) {
        String actualLocation2 = getLocationString2().getText();
        Assert.assertEquals(actualLocation2, expectedLocation2, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getPartyInfoString2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
    }

    public void checkPartyInfoString2(String partyInfoString1) {
        String partyInfoString2 = getPartyInfoString2().getText();
        Assert.assertEquals(partyInfoString2, partyInfoString1, "Actual shelf life does not match expected shelf life");
    }

    public SelenideElement getQuantityString2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
    }

}


