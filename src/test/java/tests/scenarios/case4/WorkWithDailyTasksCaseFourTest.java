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

@Test
public void processingNegativeReceptionTaskTest() throws Exception {
    steps.loginAsAdmin();

    allTasksPage.checkWorkType("Reception");
    allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("10")); // by default 10
    allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол31
    receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 Стол21 IN.01 Quantity 10 уп. (5)"));
    receptionCardPage.setSourceInput("IN.02");
    getMessageModalDialog().shouldBe(visible).shouldHave(text("The control box does not match the task"));
    clickErrorDialogOkButton();
    receptionCardPage.setSourceInput("IN");
    getMessageModalDialog().shouldBe(visible).shouldHave(text("The control box does not match the task"));
    clickErrorDialogOkButton();
    receptionCardPage.setSourceInput("000021");
    getMessageModalDialog().shouldBe(visible).shouldHave(text("The control box does not match the task"));
    clickErrorDialogOkButton();
    receptionCardPage.setSourceInput("IN.01");
    getMessageModalDialog().shouldNotBe(visible);

    receptionCardPage.setProductInput("IN.01");
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN.01"));
    clickErrorDialogOkButton();
    receptionCardPage.setProductInput("IN");
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN"));
    clickErrorDialogOkButton();
    receptionCardPage.setProductInput("00001");
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 00001"));
    clickErrorDialogOkButton();
    receptionCardPage.checkAmountAndPackaging("1.0", "10");
    receptionCardPage.setProductInput("00002102");
    getMessageModalDialog().shouldNotBe(visible);

    receptionCardPage.setContainerInput("IN.01");
    receptionCardPage.setQuantityInput("2");
    receptionCardPage.clickCommitButton();
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Not found on the CC Container:IN.01"));
    clickErrorDialogOkButton();
    receptionCardPage.setContainerInput("00001");
    receptionCardPage.setQuantityInput("2");
    receptionCardPage.clickCommitButton();
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Not found on the CC Container:00001"));
    clickErrorDialogOkButton();
    receptionCardPage.setContainerInput("00002102");
    receptionCardPage.checkAmountAndPackaging("5.0", "2");
    receptionCardPage.setQuantityInput("2");
    receptionCardPage.clickCommitButton();
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Not found on the CC Container:00002102"));
    clickErrorDialogOkButton();
    receptionCardPage.setContainerInput("IN1");
    receptionCardPage.setQuantityInput("3");
    receptionCardPage.clickCommitButton();
    getMessageModalDialog().shouldBe(visible).shouldHave(text("Can not handle15. Remaining 10"));
    clickErrorDialogOkButton();
    receptionCardPage.setQuantityInput("2");
    receptionCardPage.clickCommitButton();
    getMessageModalDialog().shouldNotBe(visible);


}
}