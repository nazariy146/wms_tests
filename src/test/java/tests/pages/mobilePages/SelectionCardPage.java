package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelectionCardPage {
    AndroidDriver driver;

    public static SelenideElement getIdField(String Field) {
        if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/textViewDescription"));
        }
        else if (Field == "source"){
            return $(By.id("com.abmcloud:id/source_edit"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/ware_barcode"));
        }
        else if (Field == "destination"){
            return $(By.id("com.abmcloud:id/dest_edit"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/editTextQty"));
        }
        else if (Field == "commit"){
            return $(By.id("com.abmcloud:id/buttonCommit"));
        }
        else if (Field == "tareQty"){
            return $(By.id("com.abmcloud:id/editTextTareQty"));
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

    public void clickButton(String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
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
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]"));
    }

    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }
    public SelenideElement getSerialNumberProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo"));
    }
    public SelenideElement getCancelSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCancel"));
    }
    public SelenideElement getCommitSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCommit"));
    }
    public void checkSerialNumberInputText(String text) {
        String serialNumberText = getSerialNumberInput().getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }
    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (String s : serialNumbers) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void clickCommitSerialNumberButton() {
        getCommitSerialNumberButton().click();
    }
    public void checkSerialNumberQtyFactInEveryRow(String qtyFact, int qtyOfQtyFactsRows) {
        for(int i = 0; i < qtyOfQtyFactsRows; i++) {
            String text = $(By.xpath ("//android.widget.EditText[3][@bounds='[995,"+(700+i*95)+"][1440,"+(791+i*95)+"]']")).getText();
            Assert.assertEquals(qtyFact, text);
        }
    }
    //MNV need to refactor
}
