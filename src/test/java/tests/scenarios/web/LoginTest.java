package tests.scenarios.web;

import tests.BaseClass;
import tests.pages.webPages.DashboardPage;
import tests.pages.webPages.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static tests.pages.webPages.DashboardPage.DASHBOARD_MAIN_TITLE_TEXT;

public class LoginTest extends BaseClass {

    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginModal().shouldHave(text(LoginPage.MODAL_DIALOG_TEXT));

        DashboardPage dashboardPage = loginPage.loginAsUser();
        dashboardPage.getMainFormTitle().shouldHave(text(DASHBOARD_MAIN_TITLE_TEXT), Duration.ofSeconds(10));
    }
}
