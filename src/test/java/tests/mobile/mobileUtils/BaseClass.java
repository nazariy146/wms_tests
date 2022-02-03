package tests.mobile.mobileUtils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tests.web.webPages.DashboardPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseClass {

    @Parameters({"browserType", "envURL"})
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(@Optional("chrome") String browserType, @Optional("http://193.105.70.234:3780/vefremov_chudo_copy") String envURL) {
        Configuration.browserSize = "1400x1024";

        if(browserType.toLowerCase().equals("firefox"))
        {
            com.codeborne.selenide.Configuration.browser = "firefox";
        }

        else {
            com.codeborne.selenide.Configuration.browser = "chrome";
        }
        open(envURL);
    }

    public static class WebLoginPage  {

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
}
