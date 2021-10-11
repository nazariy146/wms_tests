package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class SelectionCardPage {

    private SelenideElement getSourceInput() {
        return $(By.id("com.abmcloud:id/source_edit"));
    }
    private SelenideElement getProductInput() {
        return $(By.id("com.abmcloud:id/ware_barcode"));
    }
    public SelenideElement getProductDescription() {
        return $(By.id("com.abmcloud:id/textViewDescription"));
    }
    public SelenideElement getDestinationInput() {
        return $(By.id("com.abmcloud:id/dest_edit"));
    }
    public SelenideElement getQuantityInput() {
        return $(By.id("com.abmcloud:id/editTextQty"));
    }
    private SelenideElement getCommitButton() {
        return $(By.id("com.abmcloud:id/buttonCommit"));
    }
    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }
    public SelenideElement getSerialNumberProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo"));
    }
    public SelenideElement getSerialNumberQty() {
        return $(By.id("com.abmcloud:id/textViewCSNRecord_count"));
    }
    public SelenideElement getCancelSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCancel"));
    }
    public SelenideElement getCommitSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCommit"));
    }
    public SelenideElement getTareQty() {
        return $(By.id("com.abmcloud:id/editTextTareQty"));
    }
    public SelenideElement getTareWeight() {
        return $(By.id("com.abmcloud:id/editTextTareWeight"));
    }

    public SelenideElement getNameSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[1]")); } //поле наименования СН в колонке Serial number для формы СН
    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]")); } //поле количества СН в колонке Qty fact: для формы СН


    public void setSourceInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getSourceInput().getWrappedDriver();
        getSourceInput().click();
        getSourceInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setProductInput(String productInput) {
        AndroidDriver driver = (AndroidDriver) getProductInput().getWrappedDriver();
        getProductInput().click();
        getProductInput().val(productInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setDestinationInput(String destinationInput) {
        AndroidDriver driver = (AndroidDriver) getDestinationInput().getWrappedDriver();
        getDestinationInput().click();
        getDestinationInput().val(destinationInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setQuantityInput(String quantityInput) {
        AndroidDriver driver = (AndroidDriver) getQuantityInput().getWrappedDriver();
        getQuantityInput().click();
        getQuantityInput().val(quantityInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setSerialNumberInput(String serialNumber) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        getSerialNumberInput().click();
        getSerialNumberInput().val(serialNumber);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setTareQty(String TareQty) {
        AndroidDriver driver = (AndroidDriver) getTareQty().getWrappedDriver();
        getTareQty().val(TareQty);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setTareWeight(String TareWeight) {
        AndroidDriver driver = (AndroidDriver) getTareWeight().getWrappedDriver();
        getTareWeight().val(TareWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void checkSerialNumberInputText(String text) {
        String serialNumberText = getSerialNumberInput().getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }
    public void clickCommitButton() {
        getCommitButton().click();
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
    public void checkSerialNumberQtyFactInEveryRow(String qtyFact, int qtyOfQtyFactsRows) {
        for(int i = 0; i < qtyOfQtyFactsRows; i++) {
            String text = $(By.xpath ("//android.widget.EditText[3][@bounds='[995,"+(700+i*95)+"][1440,"+(791+i*95)+"]']")).getText();
            Assert.assertEquals(qtyFact, text);
        }
    }
    public void clickCommitSerialNumberButton() {
        getCommitSerialNumberButton().click();
    }

}
