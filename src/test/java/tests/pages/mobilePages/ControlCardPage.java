package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import tests.utils.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class ControlCardPage {
    AndroidDriver driver;

    public void andrDriver(String field) {
        driver = (AndroidDriver) getIdField(field).getWrappedDriver();
    }

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
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
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

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldHave(text(source));
    }

    public void clickButton(String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
    }

    //MNV need to refactor
    public SelenideElement getNameSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[1]"));
    }
    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]"));
    }
    public SelenideElement getControlledQty(int row) {
        return $(By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+row+"]")).find((By.id("com.abmcloud:id/tv_qty_controlled")));
    }
    public SelenideElement getQty(int row) {
        return $(By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+row+"]")).find((By.id("com.abmcloud:id/tv_qty")));
    }
    private SelenideElement getScrollableTable() {
        return $(By.id("com.abmcloud:id/listViewControlContainer"));
    }
    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
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
    public void checkAllProductsInfoAndQty(int row, String qty, String productInfo) {
        Actions.hideKeyboard();
        if(!getQty(row).isDisplayed()) {
            scrollElement(getScrollableTable());
        }
        if (row > 7) {
            $(By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+(row-2)+"]")).find((By.id("com.abmcloud:id/tv_good"))).shouldHave(text(productInfo));
            getQty(row-2).shouldHave(text(qty));
            getControlledQty(row-2).shouldNotBe(visible);
        }
        else {
            $(By.xpath("//androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+row+"]")).find((By.id("com.abmcloud:id/tv_good"))).shouldHave(text(productInfo));
            getQty(row).shouldHave(text(qty));
            getControlledQty(row).shouldNotBe(visible);
        }
    }
    public void selectSeries(String series) {
        $$(By.id("com.abmcloud:id/textViewSeries")).find(exactText(series)).click();
    }
    public void checkSerialNumberQtyFactInEveryRow(String qtyFact, int qtyOfQtyFactsRows) {
        for(int i = 0; i < qtyOfQtyFactsRows; i++) {
            String text = $(By.xpath ("//android.widget.EditText[3][@bounds='[995,"+(700+i*95)+"][1440,"+(791+i*95)+"]']")).getText();
            Assert.assertEquals(qtyFact, text);
        }
    }
    public void setSerialNumberInputSeveralTimes(String ... serialNumbers) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (String s : serialNumbers) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(s);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    public void checkSerialNumberInputText(String text) {
        String serialNumberText = getSerialNumberInput().getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }
    public SelenideElement getSerialNumberProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo"));
    }
    public void verifyDataSN() {
        getNameSerialNumber(2).shouldHave(text("serialnumber90"));
        getQtySerialNumber(2).shouldHave(text("1"));
        getNameSerialNumber(3).shouldHave(text("serialnumber91"));
        getQtySerialNumber(3).shouldHave(text("1"));
        getNameSerialNumber(4).shouldHave(text("serialnumber92"));
        getQtySerialNumber(4).shouldHave(text("1"));
        getNameSerialNumber(5).shouldHave(text("serialnumber93"));
        getQtySerialNumber(5).shouldHave(text("1"));
        getNameSerialNumber(6).shouldHave(text("serialnumber94"));
        getQtySerialNumber(6).shouldHave(text("1"));
        getNameSerialNumber(7).shouldHave(text("serialnumber95"));
        getQtySerialNumber(7).shouldHave(text("1"));
        getNameSerialNumber(8).shouldHave(text("serialnumber96"));
        getQtySerialNumber(8).shouldHave(text("1"));
        getNameSerialNumber(9).shouldHave(text("serialnumber97"));
        getQtySerialNumber(9).shouldHave(text("1"));
        getNameSerialNumber(10).shouldHave(text("serialnumber98"));
        getQtySerialNumber(10).shouldHave(text("1"));
        getNameSerialNumber(11).shouldHave(text("serialnumber99"));
        getQtySerialNumber(11).shouldHave(text("1"));
    }

}
