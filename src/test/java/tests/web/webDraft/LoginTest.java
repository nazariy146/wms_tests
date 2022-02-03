package tests.web.webDraft;

import tests.mobile.mobileUtils.BaseClass;
import tests.web.webPages.DashboardPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static tests.web.webPages.DashboardPage.DASHBOARD_MAIN_TITLE_TEXT;

public class LoginTest extends BaseClass {

    public void successfulLoginTest() {
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.getLoginModal().shouldHave(text(WebLoginPage.MODAL_DIALOG_TEXT));

        DashboardPage dashboardPage = webLoginPage.loginAsUser();
        dashboardPage.getMainFormTitle().shouldHave(text(DASHBOARD_MAIN_TITLE_TEXT), Duration.ofSeconds(10));
    }
}
