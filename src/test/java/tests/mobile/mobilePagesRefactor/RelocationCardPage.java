package tests.mobile.mobilePagesRefactor;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.mobileSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RelocationCardPage {
    mobileSteps mobileSteps = new mobileSteps();

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/source_edit"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/ware_barcode"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/textViewDescription"));
        }
        else if (Field == "destination"){
            return $(By.id("com.abmcloud:id/dest_edit"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/editTextQty"));
        }
        else if (Field == "commit"){
            return $(By.id("com.abmcloud:id/buttonCommit"));
        }
        else if (Field == "unitAmount"){
            return $(By.id("android:id/text1"));
        }
        else if (Field == "unitPackaging"){
            return $(By.id("com.abmcloud:id/textViewLabelHint"));
        }
        else if (Field == "tareQty"){
            return $(By.id("com.abmcloud:id/editTextTareQty"));
        }
        else if (Field == "tareWeight"){
            return $(By.id("com.abmcloud:id/editTextTareWeight"));
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

    public void clickButton(String button) {
        getIdField(button).click();
    }

    //MNV need to dell
/*    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }*/
    //MNV need to dell

}
