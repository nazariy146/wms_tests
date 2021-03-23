package tests.steps;

import tests.pages.mobilePages.LoginPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class Steps {

    LoginPage loginPage = new LoginPage();

    public void loginAsAdmin() {
        loginPage.getUserNameInput().shouldBe(enabled).sendKeys("Admin");
        loginPage.getUserPasswordInput().click();
        loginPage.getLoginButton().shouldBe(visible, enabled).click();
    }
}