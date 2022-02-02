package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;
import tests.steps.Steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ReceptionCardPage {
    Steps steps = new Steps();

    AndroidDriver driver;

    public void andrDriver(String field) {
        SelenideElement ID = getIdField(field);
        ID.shouldBe(visible, Duration.ofSeconds(25));
        driver = (AndroidDriver) ID.getWrappedDriver();
    }

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/editTextControlSource"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "productInfo"){
            //return $(By.id("com.abmcloud:id/textViewControlDescription")); -MNV release4 need dell
            return $(By.id("com.abmcloud:id/textViewDescription")); //- release5
        }
        else if (Field == "container"){
            return $(By.id("com.abmcloud:id/editTextControlDestination"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/editTextControlQty"));
        }
        else if (Field == "commit"){
            return $(By.id("com.abmcloud:id/buttonControlCommit"));
        }
        else if (Field == "newShelfLife"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        else if (Field == "expirationDate"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        else if (Field == "serialNumberInputText"){
            return $(By.id("com.abmcloud:id/editTextSerialNumber"));
        }
        else if (Field == "commitSN"){
            return $(By.id("com.abmcloud:id/buttonSNCommit"));
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
        else if (Field == "heightSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_height"));
        }
        else if (Field == "widthSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_width"));
        }
        else if (Field == "lenghtSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_length"));
        }
        else if (Field == "newSeries"){
            return $(By.id("com.abmcloud:id/et_series"));
        }
        else if (Field == "createNewShelfLife"){
            return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
        }
        else if (Field == "getProductDescription"){
            return $(By.id("com.abmcloud:id/textViewControlDescriptionLayout"));
        }
        else if (Field == "productInfoSN"){
            return $(By.id("com.abmcloud:id/textViewInfo"));
        }
        else if (Field == "cancelSN"){
            SelenideElement a = $(By.id("com.abmcloud:id/buttonSNCancel"));
            return $(By.id("com.abmcloud:id/buttonSNCancel"));
        }
        else if (Field == "cancel"){
            return $(By.id("android:id/button2"));
        }
        else if (Field == "fieldProduct"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "modalDialogTitle"){
            return $(By.id("com.abmcloud:id/alertTitle"));
        }
        else if (Field == "modalDialogOK"){
            return $(By.id("android:id/button1"));
        }
        else if (Field == "modalDialogErrorOK"){
            return $(By.id("android:id/button2"));
        }
        else if (Field == "modalDialogMessage"){
            return $(By.id("android:id/message"));
        }
        else if (Field == "editBarcode"){
            return $(By.id("com.abmcloud:id/ib_edit"));
        }
        else if (Field == "selectBarcode"){
            return $(By.id("com.abmcloud:id/tv_barcode"));
        }
        else if (Field == "weightSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_weight"));
        }
        else if (Field == "clearProductInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]"));
        }
        else if (Field == "clearContainerInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[2]"));
        }
        else if (Field == "unitAmount"){
            return $(By.id("android:id/text1"));
        }
        else if (Field == "packaging"){
            return $(By.id("com.abmcloud:id/labelHintControl"));
        }
        else if (Field == "package"){
            return $(By.id("com.abmcloud:id/tv_packing"));
        }
        else if (Field == "newSku"){
            return $(By.id("com.abmcloud:id/ib_add"));
        }
        else if (Field == "palletFlag"){
            return $(By.id("com.abmcloud:id/sw_pallet"));
        }
        else if (Field == "pallet"){
            return $(By.id("com.abmcloud:id/et_pallet"));
        }
        else if (Field == "palletEdit"){
            return $(By.id("com.abmcloud:id/ib_pallet"));
        }
        else if (Field == "layerFlag"){
            return $(By.id("com.abmcloud:id/sw_layer"));
        }
        else if (Field == "layer"){
            return $(By.id("com.abmcloud:id/et_layer"));
        }
        else if (Field == "boxFlag"){
            return $(By.id("com.abmcloud:id/sw_box"));
        }
        else if (Field == "box"){
            return $(By.id("com.abmcloud:id/et_box"));
        }
        else if (Field == "boxEdit"){
            return $(By.id("com.abmcloud:id/ib_box"));
        }
        else if (Field == "groupFlag"){
            return $(By.id("com.abmcloud:id/sw_group"));
        }
        else if (Field == "group"){
            return $(By.id("com.abmcloud:id/et_group"));
        }
        else if (Field == "groupEdit"){
            return $(By.id("com.abmcloud:id/ib_group"));
        }
        else if (Field == "BaseFlag"){
            return $(By.id("com.abmcloud:id/sw_base"));
        }
        else if (Field == "base"){
            return $(By.id("com.abmcloud:id/et_base"));
        }
        else if (Field == "skuQty"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_ratio"));
        }
        else if (Field == "skuName"){
            return $(By.id("com.abmcloud:id/tv_base_unit"));
        }
        else if (Field == "skuName"){
            return $(By.id("com.abmcloud:id/textinput_placeholder"));
        }
        return null;
    }

    public SelenideElement getXpathField(String field, int row) {
        if (field == "serialNumber"){
            return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText[1]"));
        }
        else if (field == "qty"){
            return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText[2]"));
        }
        else if (field == "qtyFact"){
            return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText[3]"));
        }
        return null;
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        steps.driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldBe(visible, Duration.ofSeconds(25));
        ID.shouldHave(text(source));
    }

    public void clickButton(String button) {
        getIdField(button).click();
    }

    public void inputSN(String typeSN, String SN, int qtySN) {
        if (typeSN == "unique"){
            for (int i = 0, stroka = 2; i < qtySN; i++, stroka++) {
                String nowSN = SN + "serialnumber0" + i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        if (typeSN == "uniqueSn"){
            for (int i = 1, stroka = 3; i <= qtySN; i++, stroka++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "0" + i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        if (typeSN == "qr"){
            for (int i = 0, stroka = 5; i < qtySN; i++, stroka++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "0" + i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        else if (typeSN == "normal"){
            for (int i = 1, stroka = 2; i <= qtySN; i++) {
                    String nowSN = SN + "serialnumber0" + "0";
                    inputData("serialNumberInputText" , nowSN);
                    getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                    getXpathField("qty", stroka).shouldHave(text("0"));
                    getXpathField("qtyFact", stroka).shouldHave(text(""+i));
            }
        }
        else if (typeSN == "sn"){
            for (int i = 2, stroka = 2; i <= qtySN; i++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "00";
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text(""+i));
            }
        }
        clickButton("commitSN");
    }

    public void selectData(String field, String source) {
        getIdField(field).click();
        $$(By.id("android:id/text1")).find(exactText(source)).click();
    }

    //MNV need to develop
    public void selectModalDialog(String field, String source) {
        getIdField(field).click();
        SelenideElement Element1 = $$(By.id("android:id/text1")).find(exactText(source));
        Element1.getId();
        Element1.getClass();
        Element1.click();
    }
    //MNV need to develop

    //MNV need to refactor
    public void checkAmountAndPackaging(String amount, String packaging) {
        verifyData("unitAmount", amount);
        verifyData("packaging", packaging);
    }
    public void clearnQuantity(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.clear();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void inputWidth (String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    //MNV need to refactor

    //MNV need to dell
/*    public void inputBatchProperties(boolean seriesOn, boolean shelfLifeOn, String action, String series, String shelfLife) {
        verifyData("modalDialogTitle", "Batch properties");
        if (action == "input") {
            if (seriesOn == true) {
                inputData("newSeries", series);
            }
            if (shelfLifeOn == true) {
                inputData("newShelfLife", shelfLife);
            }
        }
        if (action == "select") {
            if (seriesOn == true) {
                $$(By.id("com.abmcloud:id/tv_series")).find(exactText(series)).click();
            }
            if (shelfLifeOn == true) {
                $$(By.id("com.abmcloud:id/tv_shelf_life")).find(exactText(shelfLife)).click();
            }
        }
        clickButton("modalDialogOK");
    }*/
    //MNV need to dell
}