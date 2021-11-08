package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ReceptionCardPage {

    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/editTextControlSource"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/textViewControlDescription"));
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
            return $(By.id("com.abmcloud:id/textinput_placeholder"));
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
        else if (Field == "expirationDate"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
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
        return null;
    }

    public SelenideElement getXpathField(String Field) {
        if (Field == "clearSourceInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]"));
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

    public void clickButton(String button) {
        getIdField(button).click();
    }

    //MNV need to develop
    public void verifyDataSN() {
        getNameSerialNumber(2).shouldHave(text("serialnumber90"));
        getQtySerialNumber(2).shouldHave(text("1"));
        getNameSerialNumber(3).shouldHave(text("serialnumber91"));
        getQtySerialNumber(3).shouldHave(text("1"));
        getNameSerialNumber(4).shouldHave(text("serialnumber92"));
        getQtySerialNumber(4).shouldHave(text("1"));
        getNameSerialNumber(5).shouldHave(text("serialnumber93"));
        getQtySerialNumber(5).shouldHave(text("1"));
        getNameSerialNumber(6).shouldHave(text("serialnumber94"));
        getQtySerialNumber(6).shouldHave(text("1"));
        getNameSerialNumber(7).shouldHave(text("serialnumber95"));
        getQtySerialNumber(7).shouldHave(text("1"));
        getNameSerialNumber(8).shouldHave(text("serialnumber96"));
        getQtySerialNumber(8).shouldHave(text("1"));
        getNameSerialNumber(9).shouldHave(text("serialnumber97"));
        getQtySerialNumber(9).shouldHave(text("1"));
        getNameSerialNumber(10).shouldHave(text("serialnumber98"));
        getQtySerialNumber(10).shouldHave(text("1"));
        getNameSerialNumber(11).shouldHave(text("serialnumber99"));
        getQtySerialNumber(11).shouldHave(text("1"));
    }
    //MNV need to develop

    //MNV need to refactor
    public SelenideElement getNameSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[1]"));
    }
    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]")); //поле количества СН в колонке Qty fact: для формы СН
    }
    public void checkAmountAndPackaging(String amount, String packaging) {
        verifyData("unitAmount", amount);
        verifyData("packaging", packaging);
    }

    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        String field = "serialNumberInputText";
        for (int i = 0; i < numberOfReps; i++) {
            inputData(field , serialNumber);
        }
    }
    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) {
        String field = "serialNumberInputText";
        for (String s : serialNumbers) {
            inputData(field , s);
        }
    }
    public void inputSerialNumbers(String serialNumber, int numberOfReps) {
        String field = "serialNumberInputText";
        for (int i = 0; i < numberOfReps; i++) {
            String serialNumber1 = serialNumber+i;
            inputData(field , serialNumber1);
        }
    }
    //MNV need to refactor
}