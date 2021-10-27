package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccommodationCardPage {

    AndroidDriver driver;

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
        else if (Field == ""){
            return $(By.id(""));
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
        SelenideElement ID = AccommodationCardPage.getIdField(field);
        ID.click();
        ID.val(source);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = AccommodationCardPage.getIdField(field);
        ID.shouldHave(text(source));
    }

    public void clickButton(String field) {
        SelenideElement ID = AccommodationCardPage.getIdField(field);
        ID.click();
    }

    //MNV need to refactor
    public void clearQuantityInput() {
        $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[4]")).click();
    }
    public void checkAmountAndPackaging(String amount, String packaging) {
        $(By.id("android:id/text1")).shouldHave(exactText(amount));
        $(By.id("com.abmcloud:id/textViewLabelHint")).shouldHave(exactText(packaging));
    }
    //MNV need to refactor

}
