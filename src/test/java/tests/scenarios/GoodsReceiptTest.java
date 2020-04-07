package tests.scenarios;

import org.testng.annotations.Test;
import tests.BaseClass;
import tests.pages.LoginPage;
import tests.pages.MainTabs.DashboardPage;
import tests.pages.MainTabs.WarehouseOperatorPage;

import static com.codeborne.selenide.Condition.text;

public class GoodsReceiptTest extends BaseClass {

    @Test
    public void createGoodsReceiptDocumentTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginModal().shouldHave(text(LoginPage.MODAL_DIALOG_TEXT));
        DashboardPage dashboardPage = loginPage.loginAsUser();

        WarehouseOperatorPage warehouseOperatorPage = dashboardPage.clickWHOperatorTab();
        warehouseOperatorPage.clickGoodsReceptionLink();
        warehouseOperatorPage.clickCreateGoodsMovementDocumentButton();
        warehouseOperatorPage.selectDocumentType("Приход");
        warehouseOperatorPage.clickSaveIcon();
        warehouseOperatorPage.getConfirmModalDialog().shouldHave(text("Added"));

    }
}
