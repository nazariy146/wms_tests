package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
}
