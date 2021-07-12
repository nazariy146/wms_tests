package tests.scenarios.case4;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.Actions.hideKeyboard;
import static tests.utils.Actions.scrollElement;
import static tests.utils.ModalDialogs.*;
import static tests.utils.ModalDialogs.clickSetOkYesButton;

public class WorkWithDailyTasksCaseFourTest extends BaseMobileClass {

    Steps steps = new Steps();
    AllTasksPage allTasksPage = new AllTasksPage();
    ReceptionCardPage receptionCardPage = new ReceptionCardPage();
    ReceptionCardPage setPalletWeightreceptionCardPage = new ReceptionCardPage();
    AccommodationCardPage accommodationCardPage = new AccommodationCardPage();
    FindRestsPage findRestsPage = new FindRestsPage();
    SelectionCardPage selectionCardPage = new SelectionCardPage();
    ContainerCardPage containerCardPage = new ContainerCardPage();
    ControlCardPage controlCardPage = new ControlCardPage();
    PackagingCardPage packagingCardPage = new PackagingCardPage();
    LoadingCardPage loadingCardPage = new LoadingCardPage();
    InventoryCardPage inventoryCardPage = new InventoryCardPage();

/**
 * All tests run on Regress/DT/Case3/wms_regress_case3_Reception DB
 * All tests run according to TestNG priority.
 * If test fails - next one will be skipped according to TestNG dependsOnMethods
 */
