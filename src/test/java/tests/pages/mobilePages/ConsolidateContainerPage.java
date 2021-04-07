package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.utils.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ConsolidateContainerPage {

    public void setSeveralConsolidateContainer(boolean value) {
        $(By.id("com.abmcloud:id/checkBoxSeveral")).click();
    }

    private SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextFromContainer"));
    }

    public void setContainerSeveralTimes(String ... container) {
        AndroidDriver driver = (AndroidDriver) getContainerInput().getWrappedDriver();
        for (String s : container) {
            getContainerInput().click();
            getContainerInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }

    public void setCreateConsolidateContainer(boolean value) {
        $(By.id("com.abmcloud:id/checkBoxCreate")).click();
    }

    public void clickConsolidateButton() {
        $(By.id("com.abmcloud:id/buttonConsolidateContainer")).click();
    }

    public SelenideElement getSourceInfo(int row) {
        return $(By.xpath("//android.view.ViewGroup["+(row+1)+"]")).find((By.id("com.abmcloud:id/textViewSource")));
    }

    public SelenideElement getDescriptionInfo(int row) {
        return $(By.xpath("//android.view.ViewGroup["+(row+1)+"]")).find((By.id("com.abmcloud:id/textViewDescription")));
    }

    private SelenideElement getScrollableTable() {
        return $(By.id("com.abmcloud:id/listViewSource"));
    }

    public void checkAllProductsInfoAndQty(int row, String source, String description) {
        Actions.hideKeyboard(getScrollableTable());

        getSourceInfo(row).shouldHave(text(source));
        getDescriptionInfo(row).shouldHave(text(description));
    }

    public SelenideElement getReceiverInput() {
        return $(By.id("com.abmcloud:id/editTextInContainer"));
    }
}
