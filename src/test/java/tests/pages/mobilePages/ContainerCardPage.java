package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContainerCardPage {

    private SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextBoxBarcodeContainerMoving"));
    }
    public SelenideElement getContainerDescription() {
        return $(By.id("com.abmcloud:id/textViewDescriptionContainerMoving"));
    }
    public SelenideElement getDestinationInput() {
        return $(By.id("com.abmcloud:id/editTextDestinationContainerMoving"));
    }
    private SelenideElement getCommitButton() {
        return $(By.id("com.abmcloud:id/buttonCommitContainerMoving"));
    }
    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }

    public void setContainerInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getContainerInput().getWrappedDriver();
        getContainerInput().click();
        getContainerInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setDestinationInput(String destinationInput) {
        AndroidDriver driver = (AndroidDriver) getDestinationInput().getWrappedDriver();
        getDestinationInput().click();
        getDestinationInput().val(destinationInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickCommitButton() {
        getCommitButton().click();
    }
}
