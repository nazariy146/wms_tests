package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RelocationCardPage {

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

    public SelenideElement textDescription () { return $(By.id("com.abmcloud:id/textBoxDescription")); }

    public SelenideElement buttonMoving () { return $(By.id("com.abmcloud:id/buttonCommit"));}

    public SelenideElement buttonCancel () { return  $(By.id("android:id/button2"));}
}
