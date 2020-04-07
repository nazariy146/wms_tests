package tests.pages.MainTabs;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WarehouseOperatorPage {
    public static final long WH_OPERATOR_TIMEOUT = Duration.ofSeconds(10).toMillis();

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

    public void setGateValue(String gate) {
        $("#form2_Ворота_i0").val(gate);
    }

    public void setContractorValue(String contractor) {
        $("#form2_Ворота_i0").val(contractor);
    }
}
