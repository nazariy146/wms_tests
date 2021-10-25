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

    //MNV need to refactor
    private SelenideElement getCellInput() {
        return $(By.id("com.abmcloud:id/editTextControlCell"));
    }
    public SelenideElement getItemInput() {
        return $(By.id("com.abmcloud:id/editTextControlBarcode"));
    }
    public SelenideElement getQuantityInput() {
        return $(By.id("com.abmcloud:id/editTextCCIlQty"));
    }
    public SelenideElement getProductInfo() {
        return $(By.id("com.abmcloud:id/tv_good"));
    }
    public SelenideElement getSeriesInfo() {
        return $(By.id("com.abmcloud:id/tv_series"));
    }
    public SelenideElement getShelfLifeInfo() {
        return $(By.id("com.abmcloud:id/tv_shelflife"));
    }
    public SelenideElement getContainerInfo() {
        return $(By.id("com.abmcloud:id/tv_container"));
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
    private SelenideElement getShipmentStatusButton() {
        return $(By.id("com.abmcloud:id/buttonStatusBuild"));
    }
    public SelenideElement getSerialNumberInput() {
        return $(By.id("com.abmcloud:id/editTextSerialNumber"));
    }
    public SelenideElement getSerialNumberProductInfo() {
        return $(By.id("com.abmcloud:id/textViewInfo"));
    }
    public SelenideElement getProductInfoString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]"));
    }
    public SelenideElement getControlledQtyString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[3]"));
    }
    public SelenideElement getSeriesInfoString1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public SelenideElement getCommitSerialNumberButton() {
        return $(By.id("com.abmcloud:id/buttonSNCommit"));
    }
    public SelenideElement getShelfLifeInfoString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    private SelenideElement getContainerInput() {
        return $(By.id("com.abmcloud:id/editTextControlContainer"));
    }
    public SelenideElement getContainerInfoString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public SelenideElement getQtyString1() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[5]"));
    }
    private SelenideElement getCommitButton() {
        return $(By.id("com.abmcloud:id/buttonCommitControlContainer"));
    }
    public SelenideElement getNameSerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[1]")); } //поле наименования СН в колонке Serial number для формы СН
    public SelenideElement getQtySerialNumber(int string) {
        return $(By.xpath("//android.view.ViewGroup["+string+"]/android.widget.LinearLayout/android.widget.EditText[3]")); } //поле количества СН в колонке Qty fact: для формы СН
    public SelenideElement getAvailableSeriesString1() {
        return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
    }
    public SelenideElement getAvailableSeries() {
        return $(By.id("com.abmcloud:id/textViewSeries"));
    }
    public SelenideElement getSeriesBox() {
        return $(By.id("com.abmcloud:id/et_shelf_life"));
    }
    public SelenideElement getAvailableExpirationDate() {
        return $(By.id("com.abmcloud:id/textViewShelfLife"));
    }
    public SelenideElement getExpirationDateBox() {
        return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
    }
    public SelenideElement getProductInfoString2() {
        return $(By.xpath("//androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView[1]"));
    }
    public SelenideElement getControlledQtyString2() {
        return $(By.xpath("//androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView[3]"));
    }
    public SelenideElement getShelfLifeInfoString2() {
        return $(By.xpath("androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView"));
    }
    public SelenideElement getContainerInfoString2() {
        return $(By.xpath("//androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView"));
    }
    public void selectSeries(String series) {
        $$(By.id("com.abmcloud:id/textViewSeries")).find(exactText(series)).click();
    }
    //MNV need to refactor

    //MNV need to refactor
    public void setCellInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getCellInput().getWrappedDriver();
        getCellInput().click();
        getCellInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setContainerInput(String sourceInput) {
        AndroidDriver driver = (AndroidDriver) getContainerInput().getWrappedDriver();
        getContainerInput().click();
        getContainerInput().val(sourceInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setItemInput(String destinationInput) {
        AndroidDriver driver = (AndroidDriver) getItemInput().getWrappedDriver();
        getItemInput().click();
        getItemInput().val(destinationInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setQuantityInputInput(String destinationInput) {
        AndroidDriver driver = (AndroidDriver) getQuantityInput().getWrappedDriver();
        getQuantityInput().click();
        getQuantityInput().val(destinationInput);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void checkSerialNumberInputText(String text) {
        String serialNumberText = getSerialNumberInput().getText();
        Assert.assertEquals(serialNumberText, text, "SerialNumberInputText is not empty");
    }
    public void setSerialNumberInputSeveralTimes(String serialNumber, int numberOfReps) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        for (int i = 0; i < numberOfReps; i++) {
            getSerialNumberInput().click();
            getSerialNumberInput().val(serialNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
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
    public void clickCommitSerialNumberButton() {
        getCommitSerialNumberButton().click();
    }
    public void clickCommitButton() {
        getCommitButton().click();
    }
    public void scrollElement(SelenideElement element) {
        AndroidDriver driver = (AndroidDriver) element.getWrappedDriver();

        TouchAction touchAction= new TouchAction(driver);

        touchAction.press(point(element.getLocation().x, element.getLocation().y))
                .waitAction(WaitOptions.waitOptions(ofMillis(300)))
                .moveTo(point(element.getLocation().x, element.getLocation().y-854))
                .release().perform();
    }
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
    public void setSerialNumberInput(String serialNumber) {
        AndroidDriver driver = (AndroidDriver) getSerialNumberInput().getWrappedDriver();
        getSerialNumberInput().click();
        getSerialNumberInput().val(serialNumber);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void checkSerialNumberQtyFactInEveryRow(String qtyFact, int qtyOfQtyFactsRows) {
        for(int i = 0; i < qtyOfQtyFactsRows; i++) {
            String text = $(By.xpath ("//android.widget.EditText[3][@bounds='[995,"+(700+i*95)+"][1440,"+(791+i*95)+"]']")).getText();
            Assert.assertEquals(qtyFact, text);
        }
    }
    public void getProductInfoString1(String expectedgetProductInfoString1) {
        String actualProductInfoString1 = getProductInfoString1().getText();
        Assert.assertEquals(actualProductInfoString1, expectedgetProductInfoString1, "Actual shelf life does not match expected shelf life");
    }
    public void setOnOrOffFreeWCSwitcher(boolean state) {
        $(By.id("com.abmcloud:id/checkBoxNotContainer")).shouldBe(visible);
        $(By.id("com.abmcloud:id/checkBoxNotContainer")).click();
    }
    public void getShelfLifeInfoString1(String expectedShelfLifeInfoString1) {
        String actualShelfLifeInfoString1 = getShelfLifeInfoString1().getText();
        Assert.assertEquals(actualShelfLifeInfoString1, expectedShelfLifeInfoString1, "Actual shelf life does not match expected shelf life");
    }
    public void getContainerInfoString1(String expectedContainerInfoString1) {
        String actualContainerInfoString1 = getContainerInfoString1().getText();
        Assert.assertEquals(actualContainerInfoString1, expectedContainerInfoString1, "Actual shelf life does not match expected shelf life");
    }
    public void getControlledQtyString1(String expectedControlledQtyString1) {
        String actualControlledQtyString1 = getControlledQtyString1().getText();
        Assert.assertEquals(actualControlledQtyString1, expectedControlledQtyString1, "Actual shelf life does not match expected shelf life");
    }
    public void getQtyString1(String expectedQtyString1) {
        String actualQtyString1 = getQtyString1().getText();
        Assert.assertEquals(actualQtyString1, expectedQtyString1, "Actual shelf life does not match expected shelf life");
    }
    public void getSeriesInfoString1(String expectedSeriesInfoString1) {
        String actualSeriesInfoString1 = getSeriesInfoString1().getText();
        Assert.assertEquals(actualSeriesInfoString1, expectedSeriesInfoString1, "Actual shelf life does not match expected shelf life");
    }
    public void clickShipmentStatusButton() {
        getShipmentStatusButton().click();
    }
    //MNV need to refactor
}
