package tests.mobile.mobilePagesRefactor;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.MobileSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FindRestsPage {
    MobileSteps mobileSteps = new MobileSteps();

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
        else if (Field == "seriesInfo"){
            return $(By.id("com.abmcloud:id/textViewSeries"));//mobileCase1,case2,case4
        }
        else if (Field == "shelfLifeInfo"){
            return $(By.id("com.abmcloud:id/textViewShelfLife"));//mobileCase1,case2,case4
        }
        else if (Field == "shelfLifeInfoString1"){
            //return $(By.id("com.abmcloud:id/textViewShelfLife"));
            //return $(By.xpath("//android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
            return $(By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView[1]"));
        }
        else if (Field == "checkLocationString1"){
            //return $(By.id("//android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
            return $(By.xpath("//android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
        }
        else if (Field == "qtyString1"){
            //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
            //return $(By.xpath("android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
            return $(By.xpath("//android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView"));
        }
        else if (Field == "checkLocationString2"){
            return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
            //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
        }
        else if (Field == "shelfLifeInfoString2"){
            //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
            return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
        }
        else if (Field == "seriesInfoString2"){
            return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
        }
        else if (Field == "qtyString2"){
            return $(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
            //return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
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

    //MNV need to dell
//    AndroidDriver driver;
/*    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }*/
    //MNV need to dell
}


