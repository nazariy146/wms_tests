package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import tests.pages.mobilePages.LoginPage;
import tests.pages.mobilePages.SettingsPage;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;

public class BaseMobileClass implements WebDriverProvider {

    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();

    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "b966497");
        capabilities.setCapability(APP_PACKAGE, "com.abmcloud");
        capabilities.setCapability(APP_ACTIVITY, ".MainActivity");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "500");

        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUp() {
        closeWebDriver();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.browser = BaseMobileClass.class.getName();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        open();

        loginPage.getAlertMessage().shouldHave(text("No server available"));
        loginPage.getOkAlertButton().click();
        loginPage.getAlertMessage().shouldHave(text("Unable to connect the device under the terms of licensing. Contact your administrator."));
        loginPage.getOkAlertButton().click();
        loginPage.getAlertMessage().shouldHave(text("No server available"));
        loginPage.getOkAlertButton().click();
        loginPage.getAlertMessage().shouldHave(text("No connection string set"));
        loginPage.getOkAlertButton().click();

        settingsPage = loginPage.clickSettingIcon();
        settingsPage.getConnectionStringInput().shouldHave(text("Connection string"));
        settingsPage.getConnectionStringInput().sendKeys("http://dmz.abmretail.com:8080/wms_qa_regress/hs/TSDExchange");
        settingsPage.getLicenseInput().sendKeys("9999900011");
        settingsPage.getSaveButton().click();
    }
}