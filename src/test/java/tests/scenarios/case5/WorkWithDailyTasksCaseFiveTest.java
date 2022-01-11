package tests.scenarios.case5;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static tests.utils.ModalDialogs.*;

public class WorkWithDailyTasksCaseFiveTest {
    Steps steps = new Steps();
    AllTasksPage allTasksPage = new AllTasksPage();
    ReceptionCardPage receptionCardPage = new ReceptionCardPage();
    AccommodationCardPage accommodationCardPage = new AccommodationCardPage();
    FindRestsPage findRestsPage = new FindRestsPage();
    SelectionCardPage selectionCardPage = new SelectionCardPage();
    ContainerCardPage containerCardPage = new ContainerCardPage();
    ControlCardPage controlCardPage = new ControlCardPage();
    PackagingCardPage packagingCardPage = new PackagingCardPage();
    LoadingCardPage loadingCardPage = new LoadingCardPage();
    InventoryCardPage inventoryCardPage = new InventoryCardPage();
    RelocationCardPage relocationCardPage = new RelocationCardPage();
    RelocationTSDCardPage relocationTSDCardPage = new RelocationTSDCardPage();

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();
        receptionCardPage.andrDriver("source");
    //Стол41
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00041");
        receptionCardPage.inputBatchProperties(true, false,"input","41Series01","");
        receptionCardPage.verifyData("productInfo", "00041 Стол41 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    }
}
