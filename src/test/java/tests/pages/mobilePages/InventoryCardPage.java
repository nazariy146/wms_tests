package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryCardPage {

    private SelenideElement getCellInput() {
        return $(By.id("com.abmcloud:id/textBoxLocationInv"));
    }

    public void setCellInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getCellInput().getWrappedDriver();
        getCellInput().click();
        getCellInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getProductInput() {
        return $(By.id("com.abmcloud:id/textBoxBarcodeInv"));
    }

    public void setProductInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getProductInput().getWrappedDriver();
        getProductInput().click();
        getProductInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getQtyInput() {
        return $(By.id("com.abmcloud:id/textBoxQtyInv"));
    }

    public void setQtyInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getQtyInput().getWrappedDriver();
        getQtyInput().click();
        getQtyInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getAlertDialog() {
        return $(By.id("com.abmcloud:id/alertTitle"));
    }

    public SelenideElement getAvailableSeries() {
        return $(By.id("com.abmcloud:id/textViewSeries"));
    }

    public SelenideElement getSeriesBox() {
        return $(By.id("com.abmcloud:id/textBoxSeriesPL"));
    }

    public SelenideElement getAvailableExpirationDate() {
        return $(By.id("com.abmcloud:id/textViewShelfLife"));
    }

    public SelenideElement getExpirationDateBox() {
        return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
    }

    public void clickAlertDialogOkButton() {
        $(By.id("android:id/button1")).click();
    }

    public void selectQuality(String qualityType) {
        $(By.id("android:id/text1")).click();
        $$(By.id("android:id/text1")).find(exactText(qualityType)).click();
    }

    public SelenideElement getProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfoProduct"));
    }

    public SelenideElement getItemViewInfo() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewItemInv"));
    }

    public SelenideElement getQualityViewInfo() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewQualityInv"));
    }

    public SelenideElement getQtyViewInfo() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewQtyInv"));
    }

    public SelenideElement getAlertMessage() {
        return $(By.id("android:id/message"));
    }

    public void clickYesMessageButton() {
        $(By.id("android:id/button1")).click();
    }

    public void clickInventoryButton() {
        $(By.id("com.abmcloud:id/buttonCommitInv")).click();
    }
}
