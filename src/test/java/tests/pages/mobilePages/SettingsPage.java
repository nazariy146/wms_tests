package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {
    public SelenideElement getConnectionStringInput() {
        return $(By.id("com.abmcloud:id/editTextCStr"));
    }

    public SelenideElement getLicenseInput() {
        return $(By.id("com.abmcloud:id/editTextLicenseNumber"));
    }

    public SelenideElement getSaveButton() {
        return $(By.id("com.abmcloud:id/buttonSave"));
    }
}
