package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RelocationCardPage {

    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/source_edit"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/ware_barcode"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/textViewDescription"));
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
        else if (Field == "unitAmount"){
            return $(By.id("android:id/text1"));

        }
        else if (Field == "unitPackaging"){
            return $(By.id("com.abmcloud:id/textViewLabelHint"));
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

    //MNV need to refactor
    private SelenideElement getSourceInput() {
        return $(By.id("com.abmcloud:id/textBoxSource"));
    }
    public SelenideElement getProductInput() {
        return $(By.id("com.abmcloud:id/textBoxBarcode"));
    }
    private SelenideElement getQtyInput() {
        return $(By.id("com.abmcloud:id/textBoxQty"));
    }
    private SelenideElement getDestinationInput() {
        return $(By.id("com.abmcloud:id/textBoxDestination"));
    }
    private SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextDestinationContainer"));
    }
    public SelenideElement textDescription () { return $(By.id("com.abmcloud:id/textBoxDescription")); }
    public SelenideElement buttonMoving () { return $(By.id("com.abmcloud:id/buttonCommit"));}
    public SelenideElement buttonCancel () { return  $(By.id("android:id/button2"));}
    //MNV need to refactor

    //MNV need to refactor
    public void setSourceInput(String sourceCode) { //поле Source
        getSourceInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getSourceInput().getWrappedDriver();
        getSourceInput().click();
        getSourceInput().val(sourceCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setProductInput(String productCode) { //поле Product
        getProductInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getProductInput().getWrappedDriver();
        getProductInput().click();
        getProductInput().val(productCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setQtyInput(String qtyCode) {
        getQtyInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getQtyInput().getWrappedDriver();
        getQtyInput().click();
        getQtyInput().val(qtyCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setDestinationInput(String destinationCode) {
        getDestinationInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getDestinationInput().getWrappedDriver();
        getDestinationInput().click();
        getDestinationInput().val(destinationCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setContainerInput(String containerCode) {
        getContainerInput().shouldBe(visible);
        AndroidDriver driver = (AndroidDriver) getContainerInput().getWrappedDriver();
        getContainerInput().click();
        getContainerInput().val(containerCode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    //MNV need to refactor
}
