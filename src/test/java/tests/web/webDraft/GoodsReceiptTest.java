package tests.web.webDraft;

import tests.mobile.mobileUtils.BaseClass;
import tests.web.webPages.DashboardPage;
import tests.web.webPages.WarehouseOperatorPage;

import static com.codeborne.selenide.Condition.text;

public class GoodsReceiptTest extends BaseClass {

    public void createGoodsReceiptDocumentTest() {
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.getLoginModal().shouldHave(text(WebLoginPage.MODAL_DIALOG_TEXT));
        DashboardPage dashboardPage = webLoginPage.loginAsUser();

        WarehouseOperatorPage warehouseOperatorPage = dashboardPage.clickWHOperatorTab();
        warehouseOperatorPage.clickGoodsReceptionLink();
        warehouseOperatorPage.clickCreateGoodsMovementDocumentButton();
        warehouseOperatorPage.selectDocumentType("Приход");
        warehouseOperatorPage.clickSaveIcon();
        warehouseOperatorPage.getConfirmModalDialog().shouldHave(text("Added"));
        warehouseOperatorPage.setGateValue("00.019.1");
        warehouseOperatorPage.setContractorValue("!!! Таранский (сыр)");
        warehouseOperatorPage.addGoods(" Пазл Утенок");
        warehouseOperatorPage.setGoodsQnty("5000");
        warehouseOperatorPage.clickBeginProcessLink();
        warehouseOperatorPage.compareDocumentStateField("Активен");
        warehouseOperatorPage.clickDetailInfoButton();
        warehouseOperatorPage.isOperationsListNotEmpty();
        warehouseOperatorPage.isWHMovementListNotEmpty();
    }
}
