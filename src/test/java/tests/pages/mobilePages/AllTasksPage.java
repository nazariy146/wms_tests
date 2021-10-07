package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static tests.utils.Actions.refreshPage;
import static tests.utils.AssertionUtils.WAIT_TASK_TIMEOUT;
import static tests.utils.AssertionUtils.waitUntilPass;


public class AllTasksPage {
    public SelenideElement getWorkType() {
        return $(By.xpath("//androidx.cardview.widget.CardView[1]")).find(By.id("com.abmcloud:id/text_work_type"));
    }

    public void checkWorkType(String taskTitle) throws Exception {
        $(By.id("com.abmcloud:id/top_app_bar")).shouldBe(visible);
        if (getRelaxMessage().isDisplayed()) {
            waitUntilPass(WAIT_TASK_TIMEOUT, () -> {
                refreshPage($(By.id("com.abmcloud:id/top_app_bar")));
                getWorkType().shouldHave(exactText(taskTitle));
            });
        } else
            getWorkType().shouldHave(exactText(taskTitle));
    }

    public void checkWorkTypesQty(int qty) throws Exception {
        $(By.id("com.abmcloud:id/top_app_bar")).shouldBe(visible);
        if ($$(By.id("com.abmcloud:id/card_view")).size() != qty) {
            waitUntilPass(WAIT_TASK_TIMEOUT, () -> {
                refreshPage($(By.id("com.abmcloud:id/top_app_bar")));
                assertEquals($$(By.id("com.abmcloud:id/card_view")).size(), qty, "Expected quantity of tasks doesn't match actual");
            });
        }
    }

    public SelenideElement getWorkTypeTasksQuantity() {
        return $(By.id("com.abmcloud:id/text_qty"));
    }

    /*public void clickInventoryTypeTaskQuantity() {
        $(By.xpath("//androidx.cardview.widget.CardView[2]")).find(By.id("com.abmcloud:id/text_qty")).click();
    }*/

    public void clickInventoryTypeTaskQuantity() {
        $(By.id("com.abmcloud:id/text_qty")).click();
    }

    public SelenideElement getRelaxMessage() {
        return $(By.id("com.abmcloud:id/relax_view"));
    }

    public void clickMenuIcon() {
        $(By.id("com.abmcloud:id/action_more_menu")).click();
    }

    public void selectFindRestsMenu() {
        clickMenuIcon();
        $(By.id("com.abmcloud:id/design_navigation_view")).shouldBe(visible);
        $(By.id("com.abmcloud:id/design_navigation_view")).find(byId("com.abmcloud:id/find_rests")).click();
    }

    public void selectConsolidateContainerMenu() {
        clickMenuIcon();
        $(By.id("com.abmcloud:id/design_navigation_view")).shouldBe(visible);
        $(By.id("com.abmcloud:id/design_navigation_view")).find(byId("com.abmcloud:id/consolidate_container")).click();
    }

    public void selectRelocation() {
        clickMenuIcon();
        $(By.id("com.abmcloud:id/design_navigation_view")).shouldBe(visible);
        $(By.id("com.abmcloud:id/design_navigation_view")).find(byId("com.abmcloud:id/relocation")).click();
    }

    public SelenideElement getStringTasks(int row) {
        return $(By.xpath("//androidx.cardview.widget.CardView[" + row + "]")).find(By.id("com.abmcloud:id/text_qty"));

    }
}

    /*public void searchTasks (String nameTasks) throws Exception {
        switch (nameTasks) {
            case 1:
                getStringTasks(1, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[1]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
            case 2:
                getStringTasks(2, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[2]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
            case 3:
                getStringTasks(3, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[3]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
            case 4:
                getStringTasks(4, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[4]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
            case 5:
                getStringTasks(5, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[5]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
            case 6:
                getStringTasks(6, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[6]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
            case 7:
                getStringTasks(7, nameTasks);
                $(By.xpath("//androidx.cardview.widget.CardView[7]")).find(By.id("com.abmcloud:id/text_qty")).click();
                break;
        }
    }


}*/
