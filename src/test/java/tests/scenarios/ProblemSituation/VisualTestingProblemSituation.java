package tests.scenarios.ProblemSituation;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.AllTasksPage;
import tests.pages.mobilePages.ProblemSituationCardPage;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.text;

public class VisualTestingProblemSituation extends BaseMobileClass {
    /**
     * Тест на проверку отображения информации на ТСД в операции "Проблемная ситуация" (Задача 1236)
     */
    Steps steps = new Steps();
    AllTasksPage allTasksPage = new AllTasksPage();
    ProblemSituationCardPage problemSituationCardPage = new ProblemSituationCardPage();

    @Test

    public void testingProblemsituasion  () throws Exception {
        steps.loginAsAdmin();
        allTasksPage.getStringTasks(4).click();

        problemSituationCardPage.textViewDescription().shouldHave(text("Брак, 15.06.2021 16:22:49 00022 Стол22 Кол.:1, шт Admin"));
    }
}
