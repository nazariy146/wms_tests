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

    public SelenideElement getProductQuantity() {
        return $(By.id("com.abmcloud:id/textViewRecord_count"));
    }
}
