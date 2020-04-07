package tests.scenarios;

import org.testng.annotations.Test;
import tests.BaseClass;
import tests.pages.MainTabs.DashboardPage;
import tests.pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static tests.pages.MainTabs.DashboardPage.DASHBOARD_MAIN_TITLE_TEXT;

public class LoginTest extends BaseClass {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginModal().shouldHave(text(LoginPage.MODAL_DIALOG_TEXT));

        DashboardPage dashboardPage = loginPage.loginAsUser();
        dashboardPage.getMainFormTitle().waitUntil(text(DASHBOARD_MAIN_TITLE_TEXT), DashboardPage.DASHBOARD_TIMEOUT);
    }
}
