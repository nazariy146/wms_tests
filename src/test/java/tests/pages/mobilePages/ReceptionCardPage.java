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
        else if (Field == "editBarcode"){
            return $(By.id("com.abmcloud:id/ib_edit"));
        }
        else if (Field == "selectBarcode"){
            return $(By.id("com.abmcloud:id/tv_barcode"));
        }
        else if (Field == "weightSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_weight"));
        }
        return null;
    }

    public SelenideElement getXpathField(String Field) {
        if (Field == "clearSourceInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]"));
        }
        else if (Field == "clearProductInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]"));
        }
        else if (Field == "clearContainerInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[2]"));
        }
        return null;
    }

    //MNV develop
    public void inputData(String field, String source) {
        AndroidDriver driver = (AndroidDriver) getIdField(field).getWrappedDriver();
        getIdField(field).click();
        getIdField(field).val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        getIdField(field).shouldHave(text(source));
    }

    public void inputSerialNumbers(String serialNumber, int numberOfReps) {
        String Field = "serialNumberInputText";
        AndroidDriver driver = (AndroidDriver) getIdField(Field).getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            String serialNumber1 = serialNumber+i;
            getIdField(Field).click();
            getIdField(Field).val(serialNumber1);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    //MNV develop

    //MNV need to refactor
    public void clickButton(String button) {
        getIdField(button).click();
    }
    public void clearProductInput(String clearProductInput) {
        String Field = clearProductInput;
        getXpathField(Field).click();
    }
    public void clearContainerInput(String clearContainerInput) {
        String Field = clearContainerInput;
        getXpathField(Field).click();
    }
    public void checkSerialNumberInputText(String text) {
        String Field = "serialNumberInputText";
        String serialNumberText = getIdField(Field).getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }
    public void checkAmountAndPackaging(String amount, String packaging) {
        $(By.id("android:id/text1")).shouldHave(exactText(amount));
        $(By.id("com.abmcloud:id/labelHintControl")).shouldHave(exactText(packaging));
    }
    public SelenideElement getNameSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[1]"));//поле наименования СН в колонке Serial number для формы СН
    }
    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]")); //поле количества СН в колонке Qty fact: для формы СН
    }
    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) {
        String Field = "serialNumberInputText";
        AndroidDriver driver = (AndroidDriver) getIdField(Field).getWrappedDriver();
        for (String s : serialNumbers) {
            getIdField(Field).click();
            getIdField(Field).val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        String Field = "serialNumberInputText";
        AndroidDriver driver = (AndroidDriver) getIdField(Field).getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            getIdField(Field).click();
            getIdField(Field).val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }
    public SelenideElement getQuantityInput() {
        return $(By.id("com.abmcloud:id/editTextControlQty"));
    }
    //MNV need to refactor
}