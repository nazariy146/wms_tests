package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoadingPage {

    private SelenideElement getRouteSheetInput() {
        return $(By.id("com.abmcloud:id/textBoxRouteSheet"));
    }

    public void setRouteSheetInput(String routeSheetInput) {
        AndroidDriver driver = (AndroidDriver) getRouteSheetInput().getWrappedDriver();
        getRouteSheetInput().click();
        getRouteSheetInput().val(routeSheetInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getGateInput() {
        return $(By.id("com.abmcloud:id/textBoxAdditionalBarcode"));
    }

    public void setGateInput(String gateInput) {
        AndroidDriver driver = (AndroidDriver) getGateInput().getWrappedDriver();
        getGateInput().click();
        getGateInput().val(gateInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private SelenideElement getCargoInput() {
        return $(By.id("com.abmcloud:id/editTextCargo"));
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

    private SelenideElement getPriorityInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/text_resource"));
    }

    private SelenideElement getClientInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/textViewClient"));
    }

    private SelenideElement getLoadedInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/textViewLoaded"));
    }

    private SelenideElement getNotLoadedInfo() {
        return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout")).find(By.id("com.abmcloud:id/textViewNotLoaded"));
    }

    public void clickCommitButton() {
        $(By.id("com.abmcloud:id/buttonCommitLoading")).click();
    }

    public void clickCommitAllCargosButton() {
        $(By.id("com.abmcloud:id/buttonCommitAllCargos")).click();
    }
}
