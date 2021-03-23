package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class ReceptionCardPage {

    private SelenideElement getSourceInput() {
        return $(By.id("com.abmcloud:id/editTextControlSource"));
    }

    public void setSourceInput(String source) {
        AndroidDriver driver = (AndroidDriver) getSourceInput().getWrappedDriver();
        getSourceInput().click();
        getSourceInput().val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getProductInput() {
        return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
    }

    public void setProductInput(String product) {
        AndroidDriver driver = (AndroidDriver) getProductInput().getWrappedDriver();
        getProductInput().click();
        getProductInput().val(product);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getProductDescription() {
        return $(By.id("com.abmcloud:id/textViewControlDescription"));
    }

    public SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextControlDestination"));
    }

    public void clearContainerInput() {
        $(By.id("com.abmcloud:id/text_input_end_icon")).click();
    }

    public void setContainerInput(String container) {
        AndroidDriver driver = (AndroidDriver) getContainerInput().getWrappedDriver();
        getContainerInput().click();
        getContainerInput().val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getQuantityInput() {
        return $(By.id("com.abmcloud:id/editTextControlQty"));
    }

    public void setQuantityInput(String container) {
        AndroidDriver driver = (AndroidDriver) getQuantityInput().getWrappedDriver();
        getQuantityInput().click();
        getQuantityInput().val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getCommitButton() {
        return $(By.id("com.abmcloud:id/buttonControlCommit"));
    }

    public void clickCommitButton() {
        getCommitButton().click();
    }

    public SelenideElement getAlertDialog() {
        return $(By.id("com.abmcloud:id/alertTitle"));
    }

    public SelenideElement getAvailableSeriesInput() {
        return $(By.id("com.abmcloud:id/textViewSeries"));
    }

    public void createNewSeries(String name) {
        $(By.id("com.abmcloud:id/textBoxSeriesPL")).sendKeys(name);
    }

    private SelenideElement getSetButton() {
        return $(By.id("android:id/button1"));
    }

    public void clickSetButton() {
        getSetButton().click();
    }

    public SelenideElement getExpirationDateInput() {
        return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
    }

    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }

    public void checkSerialNumberInputText(String text) {
        String serialNumberText = getSerialNumberInput().getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }

    public void setSerialNumberInput(String serialNumber) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        getSerialNumberInput().click();
        getSerialNumberInput().val(serialNumber);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
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

    public SelenideElement getSerialNumberQty() {
        return $(By.id("com.abmcloud:id/textViewCSNRecord_count"));
    }

    public SelenideElement getCancelSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCancel"));
    }

    public SelenideElement getCommitSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCommit"));
    }

    public void clickCommitSerialNumberButton() {
        getCommitSerialNumberButton().click();
    }
}
