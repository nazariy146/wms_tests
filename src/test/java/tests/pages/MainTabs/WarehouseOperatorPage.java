package tests.pages.MainTabs;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.ByText;
import static com.codeborne.selenide.Selenide.*;

public class WarehouseOperatorPage {
    public static final long WH_OPERATOR_TIMEOUT = Duration.ofSeconds(5).toMillis();

    public void clickGoodsReceptionLink() {
        getGoodsReceptionLink().click();
        $("#VW_page1caption").waitUntil(text("Монитор оператора приемки"), WH_OPERATOR_TIMEOUT);
    }

    private SelenideElement getGoodsReceptionLink() {
        $("#item_11").waitUntil(visible, WH_OPERATOR_TIMEOUT);
        return $x("//*[@id='item_11']//*[@class='ellipsis']");
    }

    public void clickCreateGoodsMovementDocumentButton() {
        getCreateGoodsMovementDocumentButton().click();
        $("#VW_page2caption").waitUntil(text("Движения товаров (create)"), WH_OPERATOR_TIMEOUT);
    }

    private SelenideElement getCreateGoodsMovementDocumentButton() {
        return $("#form1_СписокДокументыСоздать");
    }

    public void selectDocumentType(String docType) {
        $("#form2_ВидДокументаДвижения_CB").click();
        $("#editDropDown").find(new ByText(docType)).click();
    }

    public void clickSaveIcon() {
        $("#form2_ФормаЗаписать").click();
    }

    public SelenideElement getConfirmModalDialog() {
        return $x("//div[@class='confirm']");
    }

    public String getConfirmDocumentNumber() {
        String number = "";
        Pattern p = Pattern.compile("([\\d\\,]+)\\s.*$"); //regex to get generated receipt number
        Matcher m = p.matcher($x("//a[@class='hover-line']").getText());
        if (m.find()) {
            number = m.group(1);
        }
        return number;
    }

    public void setGateValue(String gate) {
        $("#form2_Ворота_CB").click();
        $("#editDropDown").find(new ByText(gate)).click();
    }

    public void setContractorValue(String contractor) {
        $("#form2_Контрагент_CB").click();
        $x("//div[@id='form3_Список']").waitUntil(visible, WH_OPERATOR_TIMEOUT);
        $x("//div[@id='form3_Список']//*[@class='gridContent']//div[text()='"+contractor+"']").doubleClick();
    }

    public void addGoods(String goods) {
        $("#form2_ДокументыДвиженияДобавить").click();
        $("#form2_ДокументыДвиженияНоменклатура_CB").click();
        $x("//*[@id='form4_Список_div']//div[text()='"+goods+"']").doubleClick();
    }

    public void setGoodsQnty(String qnty) {
        $x("//*[text()='Количество']").getCssValue("colindex");
        $x("//*[@id='grid_form2_ДокументыДвижения']//*[@class='gridContent']//div[@colindex='5']").waitUntil(visible, WH_OPERATOR_TIMEOUT).doubleClick();
        $x("//*[@id='form2_ДокументыДвиженияКоличество_i0']").waitUntil(visible, WH_OPERATOR_TIMEOUT).sendKeys(qnty);
    }

    public void clickBeginProcessLink() {
        $("#form2_ФормаНачатьОбработку").click();
        $("#form2_ФормаНачатьОбработку").waitUntil(enabled, WH_OPERATOR_TIMEOUT);
    }

    public void compareDocumentStateField(String state) {
        Assert.assertEquals($("#form2_СостояниеДокументаДвижения_i0").getAttribute("value"), state, "Wrong document state");
    }

    public void clickDetailInfoButton() {
        $("#form2_ДокументыДвиженияПодробно").click();
    }

    public void isOperationsListNotEmpty() {
        $x("//*[@id='form2_ОперацииНадТоваром']//*[@class='gridRow']").waitUntil(visible, WH_OPERATOR_TIMEOUT);
        Assert.assertTrue($$x("//*[@id='form2_ОперацииНадТоваром']//*[@class='gridRow']").size() > 5);
    }
    public void isWHMovementListNotEmpty() {
        Assert.assertTrue($$x("//*[@id='grid_form2_ДвижениеПоСкладуСписок']//*[@class='gridRow gridRowOdd gridCurrentRow']").size() == 1);
    }
}
