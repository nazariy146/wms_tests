package tests.mobile.mobilePagesRefactor;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.mobileSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContainerCardPage {
    mobileSteps mobileSteps = new mobileSteps();

    public static SelenideElement getIdField(String Field) {
        if (Field == "container"){
            return $(By.id("com.abmcloud:id/editTextBoxBarcodeContainerMoving"));
        }
        else if (Field == "containerInfo"){
            return $(By.id("com.abmcloud:id/textViewDescriptionContainerMoving"));
        }
        else if (Field == "destination"){
            return $(By.id("com.abmcloud:id/editTextDestinationContainerMoving"));
        }
        else if (Field == "commit"){
            return $(By.id("com.abmcloud:id/buttonCommitContainerMoving"));
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
    //MNV need to dell
/*    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }*/
/*    AndroidDriver driver;*/
    //MNV need to dell

}
