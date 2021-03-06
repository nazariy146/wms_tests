package tests.mobile.mobilePagesRefactor;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoadingCardPage {

    //MNV need to refactor
    public SelenideElement getRouteSheetInput() {
        return $(By.id("com.abmcloud:id/textBoxRouteSheet"));
    }
    private SelenideElement getGateInput() {
        return $(By.id("com.abmcloud:id/textBoxAdditionalBarcode"));
    }
    private SelenideElement getCargoInput() {
        return $(By.id("com.abmcloud:id/editTextCargo"));
    }
    private SelenideElement getPriorityInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/text_resource"));
    }
    private SelenideElement getClientInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/textViewClient"));
    }
    private SelenideElement getLoadedInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/textViewLoaded"));
    }
    private SelenideElement getNotLoadedInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/textViewNotLoaded"));
    }
    public void clickCommitButton() {
        $(By.id("com.abmcloud:id/buttonCommitLoading")).click();
    }
    public void checkAndSelectAvailableRouteSheet(String description, String driver) {
        $(By.id("com.abmcloud:id/buttonRouteSheetChoice")).click();
        $(By.id("com.abmcloud:id/select_dialog_listview")).shouldBe(visible);
        $(By.id("com.abmcloud:id/textViewDoc_title")).shouldHave(text(description));
        $(By.id("com.abmcloud:id/textViewDriver")).shouldHave(text(driver)).click();
    }
    public void setRouteSheetInput(String routeSheetInput) {
        AndroidDriver driver = (AndroidDriver) getRouteSheetInput().getWrappedDriver();
        getRouteSheetInput().click();
        getRouteSheetInput().val(routeSheetInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setGateInput(String gateInput) {
        AndroidDriver driver = (AndroidDriver) getGateInput().getWrappedDriver();
        getGateInput().click();
        getGateInput().val(gateInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setSerialCargoInput(String ... serialNumbers) {
        AndroidDriver driver = (AndroidDriver) getCargoInput().getWrappedDriver();
        for (String s : serialNumbers) {
            getCargoInput().click();
            getCargoInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void checkLoadingInfo(String priority, String client, String loaded, String notLoaded) {
        getPriorityInfo().shouldBe(visible).shouldHave(exactText(priority));
        getClientInfo().shouldHave(exactText(client));
        getLoadedInfo().shouldHave(exactText(loaded));
        getNotLoadedInfo().shouldHave(exactText(notLoaded));
    }
    //MNV need to refactor

    //MNV need to dell
    //MNV need to dell
}
