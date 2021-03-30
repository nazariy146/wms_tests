package tests.pages.mobilePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static tests.utils.Actions.refreshPage;
import static tests.utils.AssertionUtils.WAIT_TASK_TIMEOUT;
import static tests.utils.AssertionUtils.waitUntilPass;


public class AllTasksPage {
    public SelenideElement getWorkType() {
        return $(By.id("com.abmcloud:id/text_work_type"));
    }

    public void checkWorkType(String taskTitle) throws Exception {
        $(By.id("com.abmcloud:id/top_app_bar")).shouldBe(visible);
        if (getRelaxMessage().isDisplayed())
        {
            waitUntilPass(WAIT_TASK_TIMEOUT, () -> {
                refreshPage($(By.id("com.abmcloud:id/top_app_bar")));
                assertEquals(getWorkType().getText(), taskTitle, "Expected task doesn't match actual");
            });
        }
        else
            assertEquals(getWorkType().getText(), taskTitle, "Expected task doesn't match actual");
    }

    public SelenideElement getWorkTypeTasksQuantity() {
        return $(By.id("com.abmcloud:id/text_qty"));
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
}
