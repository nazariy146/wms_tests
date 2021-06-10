package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import tests.pages.mobilePages.LoginPage;
import tests.pages.mobilePages.SettingsPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static tests.utils.ModalDialogs.*;

public class BaseMobileClass implements WebDriverProvider {

    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();

    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(APP_PACKAGE, "com.abmcloud");
        capabilities.setCapability(APP_ACTIVITY, ".MainActivity");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("newCommandTimeout", "600");

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

        getMessageModalDialog().shouldHave(text("No server available"));
        clickErrorDialogOkButton();
        getMessageModalDialog().shouldHave(text("Unable to connect the device under the terms of licensing. Contact your administrator."));
        clickErrorDialogOkButton();
        getMessageModalDialog().shouldHave(text("No server available"));
        clickErrorDialogOkButton();
        getMessageModalDialog().shouldHave(text("No connection string set"));
        clickErrorDialogOkButton();

        settingsPage = loginPage.clickSettingIcon();
        settingsPage.getConnectionStringInput().shouldHave(text("Connection string"));
        settingsPage.getConnectionStringInput().sendKeys("http://dmz.abmretail.com:8080/wms_regress_eleo/hs/TSDExchange");
        settingsPage.getLicenseInput().sendKeys("9999900014");
        settingsPage.getSaveButton().click();
    }

    @BeforeClass
    private void bdUpdateMethod() {
        open("http://dmz.abmretail.com:8080/wms_qa_regress");

        $("#userName").shouldBe(visible, Duration.ofSeconds(10));
        $("#userName").val("Администратор");
        $("#userPassword").val("Password1");
        $("#okButton").click();

        $("#captionbarMore").shouldBe(visible, Duration.ofSeconds(10));
        $("#captionbarMore").click();
        $("#fileSubMenu").hover();
        $("#fileOpen").click();

        File file = new File("src/OpenAndSending.epf");
        $("#fileSelectButton").uploadFile(file);
        $("#fileSelectDialogOk").click();

        $x("//a//span[text()='Clear base']").click();
        $("#msg0").shouldHave(text("База очищена!"));
        $x("//a//span[text()='Sending test1']").click();
        $("#msg1").shouldHave(text("Код статуса: 200 - Запрос отправлен!"), Duration.ofSeconds(10));
        $("#msg2").shouldHave(text("Тело POST, OK, Документ записан (номер WMS - 1)"));
        $("#msg3").shouldHave(text("Документ приход отправлен!"));

        $("#LogoutButton").click();
        $("#LogoutCloseButton").click();
        System.out.println("log out complete");
    }
}