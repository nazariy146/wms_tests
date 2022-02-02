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

    //MNV need to refactor
    private SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextFromContainer"));
    }
    public SelenideElement getSourceInfo(int row) {
        //return $(By.xpath("//android.view.ViewGroup["+(row+1)+"]")).find((By.id("com.abmcloud:id/textViewSource")));
        return $(By.xpath("//android.view.ViewGroup["+(row+1)+"]")).find((By.id("com.abmcloud:id/textViewSource"))); //MNV Release5 Case2
    }
    public SelenideElement getDescriptionInfo(int row) {
        return $(By.xpath("//android.view.ViewGroup["+(row+1)+"]")).find((By.id("com.abmcloud:id/textViewDescription")));
    }
    public SelenideElement getReceiverInput() {
        return $(By.id("com.abmcloud:id/editTextInContainer"));
    }
    public void setSeveralConsolidateContainer(boolean value) {
        $(By.id("com.abmcloud:id/checkBoxSeveral")).click();
    }
    public void setCreateConsolidateContainer(boolean value) {
        $(By.id("com.abmcloud:id/checkBoxCreate")).click();
    }
    public void clickConsolidateButton() {
        $(By.id("com.abmcloud:id/buttonConsolidateContainer")).click();
    }
    public void setContainerSeveralTimes(String ... container) {
        AndroidDriver driver = (AndroidDriver) getContainerInput().getWrappedDriver();
        for (String s : container) {
            getContainerInput().click();
            getContainerInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void checkAllProductsInfoAndQty(int row, String source, String description) {
        //Actions.hideKeyboard();
        getSourceInfo(row).shouldHave(text(source));
        getDescriptionInfo(row).shouldHave(text(description));
    }
    private SelenideElement getScrollableTable() {
        return $(By.id("com.abmcloud:id/listViewSource"));
    }
    //MNV need to refactor
}
