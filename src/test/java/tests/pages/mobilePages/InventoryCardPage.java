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
    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/textBoxLocationInv"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/textBoxBarcodeInv"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/textViewInfoProduct"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/textBoxQtyInv"));
        }
        else if (Field == "palletWeight"){
            return $(By.id("com.abmcloud:id/editTextPalletWeight"));
        }
        else if (Field == "tareQty"){
            return $(By.id("com.abmcloud:id/editTextTareQty"));
        }
        else if (Field == "tareWeight"){
            return $(By.id("com.abmcloud:id/editTextTareWeight"));
        }
        else if (Field == "itemViewInfo"){
            return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewItemInv")); //поле наименования номенклатуры в колонке Item
        }
        else if (Field == "quality"){
            return $(By.id("android:id/text1"));
        }
        else if (Field == "modalDialogMessage"){
            return $(By.id("android:id/message"));
        }
        else if (Field == "inventory"){
            return $(By.id("com.abmcloud:id/buttonCommitInv"));
        }
        else if (Field == "ok"){
            return $(By.id("android:id/button1"));
        }
        else if (Field == "modalDialogTitle"){
            return $(By.id("com.abmcloud:id/alertTitle"));
        }
        else if (Field == "qualityInfo"){
            return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewQualityInv")); //поле статуса номенклатуры в колонке Quality
        }
        else if (Field == "qtyViewInfo"){
            return $(By.xpath("//android.widget.ListView/android.view.ViewGroup[2]")).find(By.id("com.abmcloud:id/textViewQtyInv")); //поле количества номенклатуры в колонке Qty
        }
        return null;
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

    public void clickButton(String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
    }

    public void clickButtonAndConfirm(String field) {
        clickButton(field);
        verifyData("modalDialogMessage", "Complete Cell Inventory?");
        clickButton("ok");
    }

    //MNV need to refactor
    public void selectData(String field, String source) {
        getIdField(field).click();
        $$(By.id("android:id/text1")).find(exactText(source)).click();
    }
    public SelenideElement getAvailableSeries() {
        return $(By.xpath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView[1]"));

    }
    public SelenideElement getAvailableSeries1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView"));
    }
    public SelenideElement getAvailableSeries2() {
        return $(By.xpath("//androidx.cardview.widget.CardView[3]/android.view.ViewGroup/android.widget.TextView"));
    }
    public SelenideElement getAvailableSeries(int stroka) {
        return $(By.xpath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+stroka+"]/android.view.ViewGroup/android.widget.TextView")); //поле количества СН в колонке Qty fact: для формы СН
    }
    public SelenideElement getSeriesBox() {
        return $(By.id("com.abmcloud:id/et_series"));
    }
    public SelenideElement getAvailableExpirationDate() {
        return $(By.xpath("//androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView"));
    }
    public SelenideElement getAvailableExpirationDateZ22() {
        return $(By.xpath("//androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView[2]"));
    }
    public SelenideElement getAvailableExpirationDateZ23() {
        return $(By.xpath("//androidx.cardview.widget.CardView[3]/android.view.ViewGroup/android.widget.TextView"));
    }
    public SelenideElement getExpirationDateBox() {
        return $(By.id("com.abmcloud:id/et_shelf_life"));
    }
    public SelenideElement getAvailableExpirationDate2() {
        return $(By.xpath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView"));
    }
    public SelenideElement getProductUnit() {
        return $(By.xpath("//android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout[3]/android.widget.Spinner/android.widget.TextView"));
    }
    //MNV need to refactor
}
