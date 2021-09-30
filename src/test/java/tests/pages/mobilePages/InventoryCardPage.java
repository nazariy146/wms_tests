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

    public SelenideElement getProductInput() {
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

    public void selectQuality(String qualityType) {
        $(By.id("android:id/text1")).click();
        $$(By.id("android:id/text1")).find(exactText(qualityType)).click();
    }

    public SelenideElement getProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfoProduct"));} // поле наименования номенклатуры на форме Инвентуры

    public SelenideElement getItemViewInfo() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewItemInv")); //поле наименования номенклатуры в колонке Item
    }

    public SelenideElement getQualityViewInfo() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewQualityInv")); //поле статуса номенклатуры в колонке Quality
    }

    public SelenideElement getQtyViewInfo() {
        return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewQtyInv")); //поле количества номенклатуры в колонке Qty
    }

    public void clickInventoryButton() {
        $(By.id("com.abmcloud:id/buttonCommitInv")).click();
    }

    public SelenideElement getAvailableExpirationDate1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[2]"));
    }

    public SelenideElement getAvailableExpirationDate2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView[2]"));
    }

    public SelenideElement getAvailableSeries1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
    }

    public SelenideElement getAvailableSeries2() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
    }


    private SelenideElement getPalletWeight() {
        return $(By.id("com.abmcloud:id/editTextPalletWeight"));
    }
    public void setPalletWeight(String container) {
        AndroidDriver driver = (AndroidDriver) getPalletWeight().getWrappedDriver();
        getPalletWeight().click();
        getPalletWeight().val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    private SelenideElement getTareQty() {
        return $(By.id("com.abmcloud:id/editTextTareQty"));
    }
    public void setTareQty(String container) {
        AndroidDriver driver = (AndroidDriver) getTareQty().getWrappedDriver();
        getTareQty().click();
        getTareQty().val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    private SelenideElement getTareWeight() {
        return $(By.id("com.abmcloud:id/editTextTareWeight"));
    }
    public void setTareWeight(String container) {
        AndroidDriver driver = (AndroidDriver) getTareWeight().getWrappedDriver();
        getTareWeight().click();
        getTareWeight().val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    //////////////////////////////////////
    public SelenideElement getProductUnit() {
        return $(By.id("com.abmcloud:id/labelHintInv"));
    }

    public SelenideElement getProductQuantity() {
        return $(By.id("com.abmcloud:id/textBoxQtyInv"));
    }

    /**
     * Методы для формы СН при Инвентуре по СН
     */
    public SelenideElement getTextViewInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo")); } //поле наименования номенклатуры на форме СН

    public SelenideElement getTextViewCSNSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]")).find(By.id("com.abmcloud:id/textViewCSNSerialNumber")); //поле для СН в колонке Serial number
    }

    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]")); } //поле для количества СН в колонке Qty fact:

    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));} //поле для ввода СН на форме СН

    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) { //метод ввода СН в поле Serial number несколько раз подряд
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }

    public SelenideElement getButtonCommit() {return $(By.id("com.abmcloud:id/buttonSNCommit"));} //кнопка Commit на форме СН

    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) { //метод для ввода уникальных СН
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (String s : serialNumbers) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }

    public void setSerialNumberOrQRcode(String container) { //метод ввода одиночного СН или QR-code в поле Serial number
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        getSerialNumberInput().click();
        getSerialNumberInput().val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
