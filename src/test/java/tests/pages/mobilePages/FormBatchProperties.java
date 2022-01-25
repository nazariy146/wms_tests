package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormBatchProperties {

    Steps steps = new Steps();

    public static SelenideElement getId(String Field) {
        switch (Field) {
            case "title":
                return $(By.id("com.abmcloud:id/alertTitle"));
            case "ok":
                return $(By.id("android:id/button1"));
            case "series":
                return $(By.id("com.abmcloud:id/et_series"));
            case "shelfLife":
                return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        return null;
    }

    public void input (boolean seriesOn, boolean shelfLifeOn, String dataSeries, String dataShelfLife) {
        SelenideElement idTitle = getId("title");
        SelenideElement idSeries = getId("series");
        SelenideElement idShelfLife = getId("shelfLife");
        SelenideElement idOk = getId("ok");

        steps.verifyData(idTitle, "Batch properties");
            if (seriesOn == true) {
                steps.inputData(idSeries, dataSeries);
            }
            if (shelfLifeOn == true) {
                steps.inputData(idShelfLife, dataShelfLife);
            }
        steps.clickButton(idOk);
    }

    public void select (boolean seriesOn, boolean shelfLifeOn, String series, String shelfLife) {
        SelenideElement idTitle = getId("title");
        SelenideElement idOk = getId("ok");

        steps.verifyData(idTitle, "Batch properties");
            if (seriesOn == true) {
                $$(By.id("com.abmcloud:id/tv_series")).find(exactText(series)).click();
            }
            if (shelfLifeOn == true) {
                $$(By.id("com.abmcloud:id/tv_shelf_life")).find(exactText(shelfLife)).click();
            }
        steps.clickButton(idOk);
    }
}
