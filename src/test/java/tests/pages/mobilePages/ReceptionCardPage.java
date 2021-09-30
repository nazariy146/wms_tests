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

    public SelenideElement getIDField(String Field) {
        if (Field == "sourceInput"){
            return $(By.id("com.abmcloud:id/editTextControlSource"));
        }
        else if (Field == "productInput"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "productDescription"){
            return $(By.id("com.abmcloud:id/textViewControlDescription"));
        }
        else if (Field == "containerInput"){
            return $(By.id("com.abmcloud:id/editTextControlDestination"));
        }
        else if (Field == "quantityInput"){
            return $(By.id("com.abmcloud:id/editTextControlQty"));
        }
        else if (Field == "commitButton"){
            return $(By.id("com.abmcloud:id/buttonControlCommit"));
        }
        else if (Field == "expirationDate"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        else if (Field == "serialNumberInputText"){
            return $(By.id("com.abmcloud:id/editTextSerialNumber"));
        }
        else if (Field == "commitSerialNumberButton"){
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
            return $(By.id("com.abmcloud:id/et_ware_parameters_height"));
        }
        else if (Field == "widthSKU"){
            return $(By.id("com.abmcloud:id/et_ware_parameters_width"));
        }
        else if (Field == "lenghtSKU"){
            return $(By.id("com.abmcloud:id/et_ware_parameters_length"));
        }
        else if (Field == "createNewSeries"){
            return $(By.id("com.abmcloud:id/et_series"));
        }
        else if (Field == "createNewShelfLife"){
            return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
        }
        else if (Field == "getProductDescription"){
            return $(By.id("com.abmcloud:id/textViewControlDescriptionLayout"));
        }
        else if (Field == "getSerialNumberProductInfo"){
            return $(By.id("com.abmcloud:id/textViewInfo"));
        }
        else if (Field == "getCancelSerialNumberButton"){
            SelenideElement a = $(By.id("com.abmcloud:id/buttonSNCancel"));
            return $(By.id("com.abmcloud:id/buttonSNCancel"));
        }
        else if (Field == "buttonCancel"){
            return $(By.id("android:id/button2"));
        }
        else if (Field == "fieldProduct"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "getExpirationDateInput"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        else if (Field == "alertModalDialog"){
            return $(By.id("com.abmcloud:id/alertTitle"));
        }
        else if (Field == "clickSetOkYesButton"){
            return $(By.id("android:id/button1"));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        else if (Field == ""){
            return $(By.id(""));
        }

        return null;
    }

    public SelenideElement getXpathField(String Field) {
        if (Field == "clearSourceInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]"));
        }
        else if (Field == "clearProductInput"){
            return $(By.xpath("//android.widget.ImageButton[@content-desc=\\\"Clear text\\\"])[2]\""));
        }
        else if (Field == "clearContainerInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[3]"));
        }
        return null;
    }

    public void inputDataTheFields(String field, String source) {
        AndroidDriver driver = (AndroidDriver) getIDField(field).getWrappedDriver();
        getIDField(field).click();
        getIDField(field).val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void inputSerialNumbers(String serialNumber, int numberOfReps) {
        String Field = "serialNumberInputText";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            String serialNumber1 = serialNumber+i;
            getIDField(Field).click();
            getIDField(Field).val(serialNumber1);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    /////////////////////////////////////////////
    public void verifyDataTheFields(String field, String source) {
        //getIDField(field).shouldBe(visible);
        getIDField(field).shouldHave(text(source));
    }
    /////////////////////////////////////////////

    /////////////////////////////////////////////
    public void clearSourceInput() {
        String Field = "clearSourceInput";
        getXpathField(Field).click();
    }

    public void clearProductInput() {
        String Field = "clearProductInput";
        getXpathField(Field).click();
    }

    public void clearContainerInput() {
        String Field = "clearContainerInput";
        getXpathField(Field).click();
    }

    public void createNewSeries(String name) {
        String Field = "createNewSeries";
        getIDField(Field).sendKeys(name);
    }

    public void createNewShelfLife(String name) {
        String Field = "createNewShelfLife";
        getIDField(Field).sendKeys(name);
    }

    public void selectSeries(String series) {
        $$(By.id("com.abmcloud:id/textViewSeries")).find(exactText(series)).click();
    }

    public SelenideElement getProductDescription() {
        String Field = "getProductDescription";
        return getIDField(Field);
    }

    public SelenideElement getSerialNumberProductInfo() {
        String Field = "getSerialNumberProductInfo";
        return getIDField(Field);
    }

    public SelenideElement getCancelSerialNumberButton() {
        String Field = "getCancelSerialNumberButton";
        return getIDField(Field);
    }

    public SelenideElement buttonCancel () {
        String Field = "buttonCancel";
        return getIDField(Field);
    }

    public SelenideElement fieldProduct () {
        String Field = "fieldProduct";
        return getIDField(Field);
    }

    public SelenideElement getExpirationDateInput() {
        String Field = "getExpirationDateInput";
        return getIDField(Field);
    }

    public void clickCommitButton() {
        String Field = "commitButton";
        getIDField(Field).click();
    }

    public void clickCommitSerialNumberButton() {
        String Field = "commitSerialNumberButton";
        getIDField(Field).click();
    }

    public void checkSerialNumberInputText(String text) {
        String Field = "serialNumberInputText";
        String serialNumberText = getIDField(Field).getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }

    /////////////////////////////////////////////после правок
    public void setSourceInput(String source) {
        String Field = "sourceInput";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setExpirationDate(String date) {
        String Field = "expirationDate";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(date);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setProductInput(String product) {
        String Field = "productInput";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(product);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setContainerInput(String container) {
        String Field = "containerInput";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setQuantityInput(String container) {
        String Field = "quantityInput";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(container);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setPalletWeight(String PalletWeight) {
        String Field = "palletWeight";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(PalletWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setHeightSKU(String parametersHeight) { //метод ввода параметров в поле Height
        String Field = "heightSKU";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(parametersHeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setWidthSKU(String parametersWidth) { //метод ввода параметров в поле Width
        String Field = "widthSKU";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(parametersWidth);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setLenghtSKU(String parametersLength) { //метод ввода параметров в поле Length
        String Field = "lenghtSKU";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(parametersLength);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setWeightSKU(String parametersWeight) { //метод ввода параметров в поле Weight
        String Field = "weightSKU";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).click();
        getIDField(Field).val(parametersWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setTareQty(String TareQty) {
        String Field = "tareQty";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).val(TareQty);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setTareWeight(String TareWeight) {
        String Field = "tareWeight";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        getIDField(Field).val(TareWeight);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    /////////////////////////
    public void checkAmountAndPackaging(String amount, String packaging) {
        $(By.id("android:id/text1")).shouldHave(exactText(amount));
        $(By.id("com.abmcloud:id/labelHintControl")).shouldHave(exactText(packaging));
    }

    public void selectExpirationDate(String date) {
        $$(By.id("com.abmcloud:id/textViewShelfLife")).find(exactText(date)).click();
    }

    public SelenideElement getNameSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[1]"));//поле наименования СН в колонке Serial number для формы СН
    }

    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]")); //поле количества СН в колонке Qty fact: для формы СН
    }

    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) {
        String Field = "serialNumberInputText";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        for (String s : serialNumbers) {
            getIDField(Field).click();
            getIDField(Field).val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }

    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        String Field = "serialNumberInputText";
        AndroidDriver driver = (AndroidDriver) getIDField(Field).getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            getIDField(Field).click();
            getIDField(Field).val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
/////////////need to delete/////////////
    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }

    public SelenideElement getCommitSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCommit"));
    }

    public SelenideElement getQuantityInput() {
        return $(By.id("com.abmcloud:id/editTextControlQty"));
    }
/////////////dell/////////////
     private SelenideElement getSourceInput() {
        return $(By.id("com.abmcloud:id/editTextControlSource"));
    }
    private SelenideElement getProductInput() {
        return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
    }

    public SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextControlDestination"));
    }
    private SelenideElement getCommitButton() {
        return $(By.id("com.abmcloud:id/buttonControlCommit"));
    }
     public SelenideElement getPalletWeight() {
        return $(By.id("com.abmcloud:id/editTextPalletWeight"));
    }
    public SelenideElement getTareQty() {
        return $(By.id("com.abmcloud:id/editTextTareQty"));
    }
     public SelenideElement getTareWeight() {
        return $(By.id("com.abmcloud:id/editTextTareWeight"));
    }
     private SelenideElement getHeightSKU() { return $(By.id("com.abmcloud:id/et_ware_parameters_height"));}//обращение к полю Height
     private SelenideElement getWidthSKU() { return $(By.id("com.abmcloud:id/et_ware_parameters_width"));}//обращение к полю Width
    private SelenideElement getLengthSKU() { return $(By.id("com.abmcloud:id/et_ware_parameters_length"));}//обращение к полю Length
     private SelenideElement getWeightSKU() { return $(By.id("com.abmcloud:id/et_ware_parameters_weight"));}//обращение к полю Weight
/////////////not used/////////////
    /*public SelenideElement getAvailableSeriesInput() {
        return $(By.id("com.abmcloud:id/textViewSeries"));
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
    public SelenideElement getControlItemIcon() {
        return $(By.id("com.abmcloud:id/buttonControlItemChoice"));
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
    }*/
}