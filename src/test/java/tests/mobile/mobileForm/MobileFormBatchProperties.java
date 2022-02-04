package tests.mobile.mobileForm;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.MobileSteps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MobileFormBatchProperties {
    MobileSteps mobileSteps = new MobileSteps();

    public static SelenideElement getResourceId(String Field) {
        switch (Field) {
            case "#title":
                return $(By.id("com.abmcloud:id/alertTitle"));
            case "#ok":
                return $(By.id("android:id/button1"));
            case "#series":
                return $(By.id("com.abmcloud:id/et_series"));
            case "#shelfLife":
                return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        return null;
    }

    public void input (boolean seriesOn, boolean shelfLifeOn, String dataSeries, String dataShelfLife) {
        SelenideElement resourceId_Title, resourceId_Series, resourceId_ShelfLife, resourceId_Ok;

        resourceId_Title = getResourceId("#title");
        resourceId_Series = getResourceId("#series");
        resourceId_ShelfLife = getResourceId("#shelfLife");
        resourceId_Ok = getResourceId("#ok");

        mobileSteps.verifyData(resourceId_Title, "Batch properties");
            if (seriesOn == true) {
                mobileSteps.inputData(resourceId_Series, dataSeries);
            }
            if (shelfLifeOn == true) {
                mobileSteps.inputData(resourceId_ShelfLife, dataShelfLife);
            }
        mobileSteps.clickButton(resourceId_Ok);
    }

    public void select (boolean seriesOn, boolean shelfLifeOn, String series, String shelfLife) {
        SelenideElement idTitle = getResourceId("#title");
        SelenideElement idOk = getResourceId("#ok");

        mobileSteps.verifyData(idTitle, "Batch properties");
            if (seriesOn == true) {
                $$(By.id("com.abmcloud:id/tv_series")).find(exactText(series)).click();
            }
            if (shelfLifeOn == true) {
                $$(By.id("com.abmcloud:id/tv_shelf_life")).find(exactText(shelfLife)).click();
            }
        mobileSteps.clickButton(idOk);
    }
}
