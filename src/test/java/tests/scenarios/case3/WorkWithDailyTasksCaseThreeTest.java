package tests.scenarios.case3;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.Actions.hideKeyboard;
import static tests.utils.ModalDialogs.*;
import static tests.utils.ModalDialogs.clickSetOkYesButton;

public class WorkWithDailyTasksCaseThreeTest extends BaseMobileClass {

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
        //allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("1")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

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
        hideKeyboard(receptionCardPage.getControlItemIcon());
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
        hideKeyboard(receptionCardPage.getControlItemIcon());
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

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("2120021020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 2120021020000"));
        clickErrorDialogOkButton();
        receptionCardPage.setProductInput("2110022020000");
        hideKeyboard(receptionCardPage.getControlItemIcon());
        receptionCardPage.getQuantityInput().shouldHave(exactText("2.000"));

        receptionCardPage.setProductInput("2110023020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The product doesn't match the task: 00023 [series] [use] [shelf_life] Стол23"));
        clickErrorDialogOkButton();
        receptionCardPage.setProductInput("2110022140000");
        hideKeyboard(receptionCardPage.getControlItemIcon());
        receptionCardPage.getQuantityInput().shouldHave(exactText("16.000"));

        hideKeyboard(receptionCardPage.getControlItemIcon());
        receptionCardPage.setProductInput("2110022090000");
        receptionCardPage.clickCommitButton();
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Can not handle19. Remaining 10(excluding factor. admission = 1,5)"));
        clickErrorDialogOkButton();
        hideKeyboard(receptionCardPage.getControlItemIcon());

        receptionCardPage.clearSourceInput();
        receptionCardPage.clearContainerInput();
        receptionCardPage.clearProductInput();
        receptionCardPage.setProductInput("2110022100000");
        hideKeyboard(receptionCardPage.getControlItemIcon());
        receptionCardPage.getQuantityInput().shouldHave(exactText("10.000"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 Стол23 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("2110023020000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.setExpirationDate("01.04.21");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Shelf life 01.04.2021 in the past - are you really holding on an expired product?"));
        clickErrorDialogOkButton();

        receptionCardPage.setExpirationDate("99.99.9999");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Incorrect date value"));
        clickErrorDialogOkButton();

        receptionCardPage.setExpirationDate("31.12.21");
        clickSetOkYesButton();
        hideKeyboard(receptionCardPage.getControlItemIcon());

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 31.12.2021 Стол23 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("2.000"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("2110023055000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.setExpirationDate("30.12.21");
        clickSetOkYesButton();
        hideKeyboard(receptionCardPage.getControlItemIcon());
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 30.12.2021 Стол23 IN.01 Quantity 8 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("5.500"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 Стол23 IN.01 Quantity 2.5 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("2110023025000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.selectExpirationDate("31.12.2021");
        clickSetOkYesButton();
        hideKeyboard(receptionCardPage.getControlItemIcon());
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 31.12.2021 Стол23 IN.01 Quantity 2.5 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("2.500"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 Стол24 IN.01 Quantity 10 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("2110024020000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("24Series01");
        clickSetOkYesButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 24Series01 Стол24 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("2.000"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 Стол24 IN.01 Quantity 8 шт"));
        receptionCardPage.setProductInput("2110024075000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("24Series02");
        clickSetOkYesButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 24Series02 Стол24 IN.01 Quantity 8 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("7.500"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 Стол24 IN.01 Quantity 0.5 шт"));
        receptionCardPage.setProductInput("2110024005000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.selectSeries("24Series02");
        clickSetOkYesButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 24Series02 Стол24 IN.01 Quantity 0.5 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("0.500"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("00025");
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00025 Стол25 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setPalletWeight("2");
        receptionCardPage.setTareQty("5");
        receptionCardPage.setTareWeight("0.2");
        receptionCardPage.setQuantityInput("2");
        receptionCardPage.clickCommitButton();
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The total weight, taking into account the weight of the pallet and the tare weight, cannot be equal to zero."));
        clickErrorDialogOkButton();
        receptionCardPage.setQuantityInput("13");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00026 Стол26 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("00026");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("26series01");
        clickSetOkYesButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setPalletWeight("2");
        receptionCardPage.setTareQty("5");
        receptionCardPage.setTareWeight("0.2");
        receptionCardPage.setQuantityInput("13");
        receptionCardPage.clickCommitButton();

        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00027 Стол27 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("00027");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        clickSetOkYesButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setPalletWeight("2");
        receptionCardPage.setTareQty("5");
        receptionCardPage.setTareWeight("0.2");
        receptionCardPage.setQuantityInput("13");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00028 Стол28 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("00028");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00029 Стол29 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("00029");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("29Series01");
        clickSetOkYesButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00030 Стол30 IN.01 Quantity 10 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("00030");
        receptionCardPage.setParametersHeight("0.1");
        receptionCardPage.setParametersWidth("0.1");
        receptionCardPage.setParametersLength("0.2");
        receptionCardPage.setParametersWeight("0.4");
        clickSetOkYesButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();
    }
}
