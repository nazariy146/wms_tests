package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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

    public void clearSourceInput() {
        $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]")).click();
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

    public void clearProductInput() {
        $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[2]")).click();
    }

    public SelenideElement getProductDescription() {
        return $(By.id("com.abmcloud:id/textViewControlDescription"));
    }

    public SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextControlDestination"));
    }

    public void clearContainerInput() {
        $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[3]")).click();
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

    public SelenideElement getAvailableSeriesInput() {
        return $(By.id("com.abmcloud:id/textViewSeries"));
    }

    public void createNewSeries(String name) {
        $(By.id("com.abmcloud:id/textBoxSeriesPL")).sendKeys(name);
    }

    public void selectSeries(String series) {
        $$(By.id("com.abmcloud:id/textViewSeries")).find(exactText(series)).click();
    }

    public SelenideElement getExpirationDateInput() {
        return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
    }

    public void selectExpirationDate(String date) {
        $$(By.id("com.abmcloud:id/textViewShelfLife")).find(exactText(date)).click();
    }

    public void setExpirationDate(String date) {
        AndroidDriver driver = (AndroidDriver) getExpirationDateInput().getWrappedDriver();
        getExpirationDateInput().click();
        getExpirationDateInput().val(date);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    }

    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }

    public SelenideElement getSerialNumberProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo"));
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

    public void checkAmountAndPackaging(String amount, String packaging) {
        $(By.id("android:id/text1")).shouldHave(exactText(amount));
        $(By.id("com.abmcloud:id/labelHintControl")).shouldHave(exactText(packaging));
    }

    public SelenideElement getControlItemIcon() {
        return $(By.id("com.abmcloud:id/buttonControlItemChoice"));
    }

    public SelenideElement getPalletWeight() {
        return $(By.id("com.abmcloud:id/editTextPalletWeight"));
    }

    public void setPalletWeight(String PalletWeight) {
        AndroidDriver driver = (AndroidDriver) getPalletWeight().getWrappedDriver();
        getPalletWeight().click();
        getPalletWeight().val(PalletWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getTareQty() {
        return $(By.id("com.abmcloud:id/editTextTareQty"));
    }

    public void setTareQty(String TareQty) {
        AndroidDriver driver = (AndroidDriver) getTareQty().getWrappedDriver();
        getTareQty().val(TareQty);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getTareWeight() {
        return $(By.id("com.abmcloud:id/editTextTareWeight"));
    }

    public void setTareWeight(String TareWeight) {
        AndroidDriver driver = (AndroidDriver) getTareWeight().getWrappedDriver();
        getTareWeight().val(TareWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getParametersHeight() {
        //return $(By.id("com.abmcloud:id/et_ware_parameters_height"));
        return $(By.id("com.abmcloud:id/textBoxHeightWP"));
    }

    public void setParametersHeight(String parametersHeight) {
        AndroidDriver driver = (AndroidDriver) getParametersHeight().getWrappedDriver();
        getParametersHeight().click();
        getParametersHeight().val(parametersHeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getParametersWidth() {
        //return $(By.id("com.abmcloud:id/et_ware_parameters_width"));
        return $(By.id("com.abmcloud:id/textBoxWidthWP"));
    }

    public void setParametersWidth(String parametersWidth) {
        AndroidDriver driver = (AndroidDriver) getParametersWidth().getWrappedDriver();
        getParametersWidth().click();
        getParametersWidth().val(parametersWidth);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getParametersLength() {
        //return $(By.id("com.abmcloud:id/et_ware_parameters_length"));
        return $(By.id("com.abmcloud:id/textBoxLengthWP"));
    }

    public void setParametersLength(String parametersLength) {
        AndroidDriver driver = (AndroidDriver) getParametersLength().getWrappedDriver();
        getParametersLength().click();
        getParametersLength().val(parametersLength);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getParametersCapacity() {
        return $(By.id("com.abmcloud:id/et_ware_parameters_capacity"));
    }

    public void setParametersCapacity(String parametersCapacity) {
        AndroidDriver driver = (AndroidDriver) getParametersCapacity().getWrappedDriver();
        getParametersCapacity().click();
        getParametersCapacity().val(parametersCapacity);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getParametersWeight() {
        //return $(By.id("com.abmcloud:id/et_ware_parameters_weight"));
        return $(By.id("com.abmcloud:id/textBoxWeightWP"));
    }

    public void setParametersWeight(String parametersWeight) {
        AndroidDriver driver = (AndroidDriver) getParametersWeight().getWrappedDriver();
        getParametersWeight().click();
        getParametersWeight().val(parametersWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getParametersStoragePeriod() {
        //return $(By.id("com.abmcloud:id/et_ware_parameters_storage_period"));
        return $(By.id("com.abmcloud:id/textBoxStoragePeriod"));
    }

    public void setParametersStoragePeriod(String parametersStoragePeriod) {
        AndroidDriver driver = (AndroidDriver) getParametersStoragePeriod().getWrappedDriver();
        getParametersStoragePeriod().click();
        getParametersStoragePeriod().val(parametersStoragePeriod);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
