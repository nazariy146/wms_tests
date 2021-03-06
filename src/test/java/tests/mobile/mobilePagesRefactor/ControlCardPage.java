package tests.mobile.mobilePagesRefactor;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.MobileSteps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class ControlCardPage {
    MobileSteps mobileSteps = new MobileSteps();

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/editTextControlCell"));
        }
        else if (Field == "container"){
            return $(By.id("com.abmcloud:id/editTextControlContainer"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/tv_good"));
        }
        else if (Field == "containerInfo"){
            return $(By.id("com.abmcloud:id/tv_container"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/editTextControlBarcode"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/editTextCCIlQty"));
        }
        else if (Field == "commit"){
            return $(By.id("com.abmcloud:id/buttonCommitControlContainer"));
        }
        else if (Field == "seriesInfo"){
            return $(By.id("com.abmcloud:id/tv_series"));
        }
        else if (Field == "modalDialogTitle"){
            return $(By.id("com.abmcloud:id/alertTitle"));
        }
        else if (Field == "modalDialogOK"){
            return $(By.id("android:id/button1"));
        }
        else if (Field == "shelfLifeInfo"){
            return $(By.id("com.abmcloud:id/tv_shelflife"));
        }
        else if (Field == "serialNumberInputText"){
            return $(By.id("com.abmcloud:id/editTextSerialNumber"));
        }
        else if (Field == "commitSN"){
            return $(By.id("com.abmcloud:id/buttonSNCommit"));
        }
        return null;
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        mobileSteps.mobileDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldHave(text(source));
    }

    public void clickButton(String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
    }

    //MNV need to refactor
    public SelenideElement getControlledQty(int row) {
        return $(By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+row+"]")).find((By.id("com.abmcloud:id/tv_qty_controlled")));
    }
    public SelenideElement getQty(int row) {
        return $(By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+row+"]")).find((By.id("com.abmcloud:id/tv_qty")));
    }
    public SelenideElement getControlledQtyString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[3]"));
    }
    public SelenideElement getSeriesInfoString1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public SelenideElement getShelfLifeInfoString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public SelenideElement getContainerInfoString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public SelenideElement getQtyString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[5]"));
    }
    public void scrollElement(SelenideElement element) {
        AndroidDriver driver = (AndroidDriver) element.getWrappedDriver();

        TouchAction touchAction= new TouchAction(driver);

        touchAction.press(point(element.getLocation().x, element.getLocation().y))
                .waitAction(WaitOptions.waitOptions(ofMillis(300)))
                .moveTo(point(element.getLocation().x, element.getLocation().y-854))
                .release().perform();
    }
    //MNV need to refactor

    //MNV need to dell
    //MNV need to dell
}
