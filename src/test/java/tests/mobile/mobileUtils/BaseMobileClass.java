package tests.mobile.mobileUtils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import tests.mobile.mobilePagesRefactor.LoginPage;
import tests.mobile.mobilePagesRefactor.SettingsPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static tests.mobile.mobileUtils.ModalDialogs.*;

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
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");//MNV не сбрасывать данные приложения
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
        clickErrorDialogOkButton();

        settingsPage = loginPage.clickSettingIcon();
        settingsPage.getConnectionStringInput().shouldHave(text("Connection string"));
        settingsPage.getConnectionStringInput().sendKeys("http://dmz.abmretail.com:8080/wms_regress_mikn/hs/TSDExchange");
        settingsPage.getLicenseInput().sendKeys("wms_regress_mikn");
        settingsPage.getSaveButton().click();
    }

    //@BeforeClass
    public void bdUpdateMethod() {
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
    //@BeforeClass
    public void webInterface() {

        $("#cmd_0_0_txt").shouldBe(visible, Duration.ofSeconds(10));
        $("#cmd_0_0_txt").shouldHave(text("Монитор эффективности склада"));
        $("#cmd_1_0_txt").shouldHave(text("Управление складом"));

        $("#themesCell_theme_1").click();
        $("#cmd_0_0_txt").shouldHave(text("Контроль поставки"));
        $("#cmd_0_1_txt").shouldHave(text("РМ Возврата товаров"));
        $("#cmd_0_2_txt").shouldHave(text("Учет дополнительных работ"));
        $("#cmd_0_3_txt").shouldHave(text("Прием товара"));
        $("#cmd_0_4_txt").shouldHave(text("Проблемная ситуация"));
        $("#cmd_0_5_txt").shouldHave(text("Рекламация"));
        $("#cmd_0_6_txt").shouldHave(text("Анализ загруженности склада"));
        $("#cmd_0_7_txt").shouldHave(text("Загруженность склада"));
        $("#cmd_0_8_txt").shouldHave(text("Изменения статусов номенклатуры"));
        $("#cmd_0_9_txt").shouldHave(text("К отбору"));
        $("#cmd_0_10_txt").shouldHave(text("Логирование изменения движений"));
        $("#cmd_0_11_txt").shouldHave(text("Назначенные ресурсы документам"));
        $("#cmd_0_12_txt").shouldHave(text("Резерв размещения"));
        $("#cmd_1_0_txt").shouldHave(text("Генератор временных контейнеров"));
        $("#cmd_1_1_txt").shouldHave(text("Контроль поставки"));
        $("#cmd_1_2_txt").shouldHave(text("Дополнительные обработки"));
        $("#cmd_1_3_txt").shouldHave(text("Дополнительные отчеты"));
        $("#cmd_1_4_txt").shouldHave(text("Поиск документов по контейнеру / грузоместу"));
        $("#cmd_1_5_txt").shouldHave(text("Учет дополнительных работ"));
        $("#cmd_1_6_txt").shouldHave(text("Распределение позиций между ресурсами"));

        $("#themesCell_theme_2").click();
        $("#themesCell_theme_3").click();
        $("#themesCell_theme_4").click();
        $("#themesCell_theme_5").click();
        $("#themesCell_theme_6").click();
        $("#themesCell_theme_7").click();

        $("#themesCell_theme_1").click();
        $("#cmd_0_5_txt").click();
    }
}