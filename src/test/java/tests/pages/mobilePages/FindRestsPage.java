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

public class FindRestsPage {
    AndroidDriver driver;

    public static SelenideElement getIdField(String Field) {
        if (Field == "product"){
            return $(By.id("com.abmcloud:id/barcode"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/card_view_title"));
        }
        else if (Field == "sourceInfo"){
            return $(By.id("com.abmcloud:id/textViewItem"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/textViewRecord_count"));
        }
        else if (Field == "SeriesInfoString1"){
            return $(By.id("com.abmcloud:id/textViewSeries"));
        }
        else if (Field == "ShelfLifeInfoString1"){
            return $(By.id("com.abmcloud:id/textViewShelfLife"));
        }
        else if (Field == "checkLocationString1"){
            return $(By.id("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        else if (Field == ""){
            return $(By.id(""));
        }

        return null;
    }

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
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

    //MNV need to refact
    public void setOnOrOffFreeRemainSwitcher(boolean state) {
        $(By.id("com.abmcloud:id/switchFreeRemains")).shouldBe(visible);
        $(By.id("com.abmcloud:id/switchFreeRemains")).click();
    }
    //MNV need to refact
}


