package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class AccommodationCardPage {

    private SelenideElement getSourceInput() {
        return $(By.id("com.abmcloud:id/source_edit"));
    }

    public void setSourceInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getSourceInput().getWrappedDriver();
        getSourceInput().click();
        getSourceInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getProductInput() {
        return $(By.id("com.abmcloud:id/ware_barcode"));
    }

    public void setProductInput(String productInput) {
        AndroidDriver driver = (AndroidDriver) getProductInput().getWrappedDriver();
        getProductInput().click();
        getProductInput().val(productInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getProductDescription() {
        return $(By.id("com.abmcloud:id/textViewDescription"));
    }

    public SelenideElement getDestinationInput() {
        return $(By.id("com.abmcloud:id/dest_edit"));
    }

    public void setDestinationInput(String destinationInput) {
        AndroidDriver driver = (AndroidDriver) getDestinationInput().getWrappedDriver();
        getDestinationInput().click();
        getDestinationInput().val(destinationInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public SelenideElement getQuantityInput() {
        return $(By.id("com.abmcloud:id/editTextQty"));
    }

    public void setQuantityInput(String quantityInput) {
        AndroidDriver driver = (AndroidDriver) getQuantityInput().getWrappedDriver();
        getQuantityInput().click();
        getQuantityInput().val(quantityInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getCommitButton() {
        return $(By.id("com.abmcloud:id/buttonCommit"));
    }

    public void clickCommitButton() {
        getCommitButton().click();
    }

    public void clearQuantityInput() {
        $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[4]")).click();
    }

    public SelenideElement getControlItemIcon() {
        return $(By.id("com.abmcloud:id/action_more_menu"));
    }

    public void checkAmountAndPackaging(String amount, String packaging) {
        $(By.id("android:id/text1")).shouldHave(exactText(amount));
        $(By.id("com.abmcloud:id/textViewLabelHint")).shouldHave(exactText(packaging));
    }

}
