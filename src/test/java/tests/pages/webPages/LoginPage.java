package tests.pages.webPages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String MODAL_DIALOG_TEXT = "Specify the user name and password of a 1C";
    private String USERNAME = "Администратор";
    private String PASSWORD = "Password1";

    public SelenideElement getLoginModal() {
        return $("#authWindow");
    }

    public SelenideElement getSplashModal() {
        return $("#splash");
    }

    public DashboardPage loginAsUser() {
        getPasswordInput().val(PASSWORD);
        getUserInput().shouldBe(visible, Duration.ofSeconds(10)).val(USERNAME);
        clickOkLoginButton();
        getSplashModal().shouldBe(not(visible), Duration.ofSeconds(10));
        return new DashboardPage();
    }

    private SelenideElement getUserInput() {
        return $("#userName");
    }

    private SelenideElement getPasswordInput() {
        return $("#userPassword");
    }

    private void clickOkLoginButton() {
        $("#okButton").click();
    }
}
