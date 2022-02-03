package tests.web.webPages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class WebDashboardPage {
    public static final long DASHBOARD_TIMEOUT = Duration.ofSeconds(10).toMillis();

    public static final String DASHBOARD_MAIN_TITLE_TEXT = "СЕВА КОПИЯ --ЧМ-- СЕВА КОПИЯ / Администратор";

    public SelenideElement getMainFormTitle() {
        return $("#mainFormTitle");
    }

    public WarehouseOperatorPage clickWHOperatorTab() {
        getWHOperatorTab().click();
        return new WarehouseOperatorPage();
    }

    private SelenideElement getWHOperatorTab() {
        return $("#inner_1");
    }

}
