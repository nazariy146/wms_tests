package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tests.steps.Steps;

import static com.codeborne.selenide.Selenide.$;

public class PackagingForm {
    Steps steps = new Steps();

    public static SelenideElement getId(String Field) {
        switch (Field) {
            case "":
                return $(By.id(""));

        }
        return null;
    }

    public void input (boolean seriesOn, boolean shelfLifeOn, String dataSeries, String dataShelfLife) {
        SelenideElement idTitle = getId("title");
        SelenideElement idSeries = getId("series");
        SelenideElement idShelfLife = getId("shelfLife");
        SelenideElement idOk = getId("ok");

        steps.verifyData(idTitle, "Batch properties");
    }


}
