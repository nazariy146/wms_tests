package tests.mobile.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.mobileSteps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class ControlCardPage {
    mobileSteps mobileSteps = new mobileSteps();

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

    public SelenideElement getXpathField(String field, int row) {
        if (field == "serialNumber"){
            return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText[1]"));
        }
        else if (field == "qty"){
            return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText[2]"));
        }
        else if (field == "qtyFact"){
            return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText[3]"));
        }
        return null;
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        mobileSteps.mobileDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void inputSN(String typeSN, String SN, int qtySN) {
        if (typeSN == "unique"){
            for (int i = 0, stroka = 2; i < qtySN; i++, stroka++) {
                String nowSN = SN + "serialnumber0" + i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        if (typeSN == "uniqueSn"){
            for (int i = 1, stroka = 3; i <= qtySN; i++, stroka++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "0" + i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        if (typeSN == "qr"){
            for (int i = 0, stroka = 5; i < qtySN; i++, stroka++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "0" + i;
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                //getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text("1"));
            }
        }
        else if (typeSN == "normal"){
            for (int i = 1, stroka = 2; i <= qtySN; i++) {
                String nowSN = SN + "serialnumber0" + "0";
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text(""+i));
            }
        }
        else if (typeSN == "sn"){
            for (int i = 2, stroka = 2; i <= qtySN; i++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "00";
                inputData("serialNumberInputText" , nowSN);
                getXpathField("serialNumber", stroka).shouldHave(text(nowSN));
                getXpathField("qty", stroka).shouldHave(text("0"));
                getXpathField("qtyFact", stroka).shouldHave(text(""+i));
            }
        }
        clickButton("commitSN");
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
/*    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }*/
/*    private SelenideElement getScrollableTable() {
        return $(By.id("com.abmcloud:id/listViewControlContainer"));
    }*/
    //MNV need to dell
}
