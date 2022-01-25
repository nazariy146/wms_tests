package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RelocationTSDCardPage {
    Steps steps = new Steps();

    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

    public static SelenideElement getIdField(String Field) {
        if (Field == "rightMenu"){
            return $(By.id("com.abmcloud:id/action_more_menu"));
        }
        else if (Field == "relocation"){
            return $(By.xpath("//androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView"));
        }
        else if (Field == "source"){
            return $(By.id("com.abmcloud:id/textBoxSource"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/textBoxBarcode"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/textBoxQty"));
        }
        else if (Field == "moving"){
            return $(By.id("com.abmcloud:id/buttonCommit"));
        }
        else if (Field == "productInfo"){
            return $(By.id("com.abmcloud:id/textBoxDescription"));
        }
        else if (Field == "destination"){
            return $(By.id("com.abmcloud:id/textBoxDestination"));
        }
        else if (Field == "modalDialogTitle"){
            return $(By.id("com.abmcloud:id/alertTitle"));
        }
        else if (Field == "modalTab"){
            return $(By.id("com.abmcloud:id/tv_shelf_life"));
        }
        else if (Field == "modalDialogOK"){
            return $(By.id("android:id/button1"));
        }
        else if (Field == ""){
            return $(By.id(""));
        }
        return null;
    }

    public static String getIdFielString(String Field) {
       if (Field == "series"){
            String seriesID = "com.abmcloud:id/tv_series";
            return seriesID ;
       }
       else if (Field == "shelfLife"){
           String seriesID = "com.abmcloud:id/tv_shelf_life";
           return seriesID ;
       }
       return null;
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        steps.driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldHave(text(source));
    }

    public void clickButton(String button) {
        getIdField(button).click();
    }

    public void selectData(String field, String source) {
            String seriesID = getIdFielString(field);
            $$(By.id(seriesID)).find(exactText(source)).click();
        }

        public void inputBatchProperties(boolean seriesOn, boolean shelfLifeOn, String action, String series, String shelfLife) {
        verifyData("modalDialogTitle", "Batch properties");
        if (action == "input") {
            if (seriesOn == true) {
                inputData("newSeries", series);
            }
            if (shelfLifeOn == true) {
                inputData("newShelfLife", shelfLife);
            }
        }
        if (action == "select") {
            if (seriesOn == true) {
                $$(By.id("com.abmcloud:id/tv_series")).find(exactText(series)).click();
            }
            if (shelfLifeOn == true) {
                $$(By.id("com.abmcloud:id/tv_shelf_life")).find(exactText(shelfLife)).click();
            }
        }
        clickButton("modalDialogOK");
    }


}


