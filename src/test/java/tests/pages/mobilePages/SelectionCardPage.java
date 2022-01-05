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

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

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
        else if (Field == "serialNumberInputText"){
            return $(By.id("com.abmcloud:id/editTextSerialNumber"));
        }
        else if (Field == "commitSN"){
            return $(By.id("com.abmcloud:id/buttonSNCommit"));
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
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void inputSN(String typeSN, String SN, int qtySN) {
        if (typeSN == "unique"){
            for (int i = 0, stroka = 2; i < qtySN; i++, stroka++) {
                String nowSN = SN+i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        if (typeSN == "uniqueSn"){//необходимо скролить для работы
            for (int i = 0, stroka = 3; i < qtySN; i++, stroka++) {
                String nowSN = SN+i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        if (typeSN == "qr"){//необходимо скролить для работы
            for (int i = 0, stroka = 5; i < qtySN; i++, stroka++) {
                String nowSN = SN+i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        else if (typeSN == "normal"){
            for (int i = 1, stroka = 2; i <= qtySN; i++) {
                String nowSN = SN;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text(""+i));
            }
        }
        else if (typeSN == "sn"){
            for (int i = 2, stroka = 2; i <= qtySN; i++) {
                String nowSN = SN;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text(""+i));
            }
        }
        clickButton("commitSN");
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldHave(text(source));
    }

    public void clickButton(String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
    }

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
    public SelenideElement getCommitSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCommit"));
    }
    //MNV need to refactor

    //MNV need to dell
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
    public void mnvVerifyDataSN(int kolichestvo, String SN) {
        getNameSerialNumber(2).shouldHave(text("serialnumber90"));
        for (int i = 0; i < kolichestvo; i++) {
            int stroka = i+2;
            String qty = "1";
            SelenideElement ID  = getQtySerialNumber(stroka);
            ID.shouldHave(text(qty));

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
    public void checkSerialNumberInputText(String text) {
        String serialNumberText = getSerialNumberInput().getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }
    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        for (int i = 0; i < numberOfReps; i++) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) {
        for (String s : serialNumbers) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public SelenideElement getSerialNumberProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo"));
    }
    public SelenideElement getCancelSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCancel"));
    }
    //MNV need to dell
}
