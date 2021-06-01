package tests.scenarios.case3;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.Actions.hideKeyboard;
import static tests.utils.Actions.scrollElement;
import static tests.utils.ModalDialogs.*;
import static tests.utils.ModalDialogs.clickSetOkYesButton;

public class WorkWithDailyTasksCaseThreeTest extends BaseMobileClass {

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

        //Стол21
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

        //Стол22
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("2120021020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 2120021020000"));
        clickErrorDialogOkButton();
        receptionCardPage.setProductInput("2110022020000");
        receptionCardPage.getQuantityInput().shouldHave(exactText("2.000"));

        receptionCardPage.setProductInput("2110023020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The product doesn't match the task: 00023 [series] [use] [shelf_life] Стол23"));
        clickErrorDialogOkButton();
        receptionCardPage.setProductInput("2110022140000");
        receptionCardPage.getQuantityInput().shouldHave(exactText("16.000"));

        receptionCardPage.setProductInput("2110022090000");
        receptionCardPage.clickCommitButton();
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Can not handle19. Remaining 10(excluding factor. admission = 1,5)"));
        clickErrorDialogOkButton();

        receptionCardPage.clearSourceInput();
        receptionCardPage.clearContainerInput();
        receptionCardPage.clearProductInput();
        receptionCardPage.setProductInput("2110022100000");
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

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 31.12.2021 Стол23 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(exactText("2.000"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.clickCommitButton();

        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("2110023055000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.setExpirationDate("30.12.21");
        clickSetOkYesButton();
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

    @Test (priority = 1, dependsOnMethods = "processingNegativeReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception{
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();

        //Стол21
        accommodationCardPage.setSourceInput("IN.02");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Source does not match the task"));
        clickErrorDialogOkButton();
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 Стол21 IN.01 ➡ R.1.1.1.1 Quantity 10 уп. (5)"));
        accommodationCardPage.setSourceInput("IN");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Source does not match the task"));
        clickErrorDialogOkButton();
        accommodationCardPage.setSourceInput("IN.01");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Source does not match the task"));
        clickErrorDialogOkButton();
        accommodationCardPage.setSourceInput("IN1");//positive test
        getMessageModalDialog().shouldNotBe(visible);

        accommodationCardPage.setProductInput("IN.01");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN.01"));
        clickErrorDialogOkButton();
        accommodationCardPage.setProductInput("IN");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN"));
        clickErrorDialogOkButton();
        accommodationCardPage.setProductInput("00001");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 00001"));
        clickErrorDialogOkButton();
        accommodationCardPage.setProductInput("00002102");//positive test
        getMessageModalDialog().shouldNotBe(visible);

        accommodationCardPage.setDestinationInput("A.1.1.1.1");//negative test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Location was changed. Continue?"));
        clickErrorDialogOkButton();
        accommodationCardPage.setDestinationInput("B.1.1.1.1");//positive test
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Location was changed. Continue?"));
        clickSetOkYesButton();
        accommodationCardPage.checkAmountAndPackaging("5.0", "2");

        accommodationCardPage.setQuantityInput("3");//negative test
        accommodationCardPage.clickCommitButton();
        getMessageModalDialog().shouldBe(visible).shouldHave(text("It is impossible to confirm15. Remaining 10"));
        clickErrorDialogOkButton();
        accommodationCardPage.setQuantityInput("2");//positive test
        accommodationCardPage.clickCommitButton();
        getMessageModalDialog().shouldNotBe(visible);

        //Стол22
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 ➡ B.1.1.1.2 Quantity 10 шт"));
        accommodationCardPage.setProductInput("2120021020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 2120021020000"));
        clickErrorDialogOkButton();
        accommodationCardPage.setProductInput("2110022020000");
        accommodationCardPage.getQuantityInput().shouldHave(exactText("2.000"));

        accommodationCardPage.setProductInput("2110023020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The entered BC does not correspond to the current task!"));
        clickErrorDialogOkButton();
        accommodationCardPage.setProductInput("2110022140000");
        accommodationCardPage.getQuantityInput().shouldHave(exactText("16.000"));
        accommodationCardPage.setDestinationInput("B.1.1.1.2");
        accommodationCardPage.clickCommitButton();
        getMessageModalDialog().shouldBe(visible).shouldHave(text("It is impossible to confirm16. Remaining 10"));
        clickErrorDialogOkButton();

        accommodationCardPage.clearQuantityInput();
        accommodationCardPage.setProductInput("2110022100000");
        accommodationCardPage.getQuantityInput().shouldHave(exactText("10.000"));
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 30.12.2021 Стол23 IN.01 ➡ B.1.1.1.3 Quantity 5.5 шт"));
        accommodationCardPage.setProductInput("2110023055000");
        accommodationCardPage.setDestinationInput("B.1.1.1.3");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 31.12.2021 Стол23 IN.01 ➡ B.1.1.1.3 Quantity 4.5 шт"));
        accommodationCardPage.setProductInput("2110023045000");
        accommodationCardPage.setDestinationInput("B.1.1.1.3");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 24Series01 Стол24 IN.01 ➡ B.1.1.1.4 Quantity 2 шт"));
        accommodationCardPage.setProductInput("2110024020000");
        accommodationCardPage.setDestinationInput("B.1.1.1.4");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00024 24Series02 Стол24 IN.01 ➡ B.1.1.1.4 Quantity 8 шт"));
        accommodationCardPage.setProductInput("2110024080000");
        accommodationCardPage.setDestinationInput("B.1.1.1.4");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00025 Стол25(0.2) IN.01 ➡ B.1.1.1.5 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00025");
        accommodationCardPage.setDestinationInput("B.1.1.1.5");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00026 26series01 Стол26(0.2) IN.01 ➡ B.1.1.1.6 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00026");
        accommodationCardPage.setDestinationInput("B.1.1.1.6");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00027 31.12.2021 Стол27(0.2) IN.01 ➡ B.1.1.1.7 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00027");
        accommodationCardPage.setDestinationInput("B.1.1.1.7");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00028 Стол28 IN.01 ➡ B.1.1.1.8 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00028");
        accommodationCardPage.setDestinationInput("B.1.1.1.8");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00029 29Series01 Стол29 IN.01 ➡ B.1.1.1.9 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00029");
        accommodationCardPage.setDestinationInput("B.1.1.1.9");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00030 Стол30 IN.01 ➡ B.1.1.1.10 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00030");
        accommodationCardPage.setDestinationInput("B.1.1.1.10");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();

        allTasksPage.selectFindRestsMenu();

        findRestsPage.checkFreeRemainSwitchState(false);
        //findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG

        findRestsPage.setBarcodeInput("00002102"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00021 Стол21"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.1");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("2110022020000"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00022 Стол22"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.2");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("2110023055000"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00023 Стол23"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkLocationString1("B.1.1.1.3");
        findRestsPage.checkPartyInfoString1("30-12-2021");
        findRestsPage.getQuantityString1().shouldHave(exactText("5.5"));
        findRestsPage.checkLocationString2("B.1.1.1.3");
        findRestsPage.checkPartyInfoString2("31-12-2021");
        findRestsPage.getQuantityString2().shouldHave(exactText("4.5"));

        findRestsPage.setBarcodeInput("00024");
        findRestsPage.getProductDescription().shouldHave(text("00024 Стол24"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkLocationString1("B.1.1.1.4");
        findRestsPage.checkPartyInfoString1("24Series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getQuantityString1().shouldHave(exactText("2"));
        findRestsPage.checkLocationString2("B.1.1.1.4");
        findRestsPage.checkPartyInfoString2("24Series02");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getQuantityString2().shouldHave(exactText("8"));

        findRestsPage.setBarcodeInput("00025");
        findRestsPage.getProductDescription().shouldHave(text("00025 Стол25"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.5");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00026"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00026 Стол26"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.6");
        findRestsPage.checkProductSeriesInfo("26series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00027"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00027 Стол27"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.7");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00028"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00028 Стол28"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.8");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00029"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00029 Стол29"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.9");
        findRestsPage.checkProductSeriesInfo("29Series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00030"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00030 Стол30"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.10");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }

    @Test (priority = 3)
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Inventory");

        allTasksPage.getWorkTypeTasksQuantity();//.shouldHave(text("5")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        inventoryCardPage.setCellInput("B.1.1.1.1");
        inventoryCardPage.setProductInput("00002102");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00021 Стол21"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.getProductUnit().shouldHave(exactText("×5"));
        inventoryCardPage.setQtyInput("2");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00021 Стол21"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.2");
        inventoryCardPage.setProductInput("2110022100000");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00022 Стол22"));
        inventoryCardPage.selectQuality("Кондиция");
        //inventoryCardPage.getProductQuantity().shouldHave(exactText("10.000"));
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00022 Стол22"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.3");
        inventoryCardPage.setProductInput("2110023055000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate1().shouldHave(text("30.12.2021"));
        inventoryCardPage.getAvailableExpirationDate1().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("30.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00023 30.12.2021 Стол23"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.getProductQuantity().shouldHave(exactText("5.500"));
        inventoryCardPage.setQtyInput("5.5");
        //inventoryPage.getItemViewInfo().shouldHave(text("00023 30.12.2021 Стол23")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("5.5"));

        inventoryCardPage.setProductInput("2110023045000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00023 31.12.2021 Стол23"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.getProductQuantity().shouldHave(exactText("4.500"));
        inventoryCardPage.setQtyInput("4.5");
        //inventoryPage.getItemViewInfo().shouldHave(text("00023 31.12.2021 Стол23")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("4.5"));

        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.4");
        inventoryCardPage.setProductInput("2110024020000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries1().shouldHave(text("24Series01"));
        inventoryCardPage.getAvailableSeries1().click();
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00024 24Series01 Стол24"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.getProductQuantity().shouldHave(exactText("2.000"));
        inventoryCardPage.setQtyInput("2");
        //inventoryPage.getItemViewInfo().shouldHave(text("0002 Series2 Стол2")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("2.0"));

        inventoryCardPage.setProductInput("2110024080000");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries2().shouldHave(text("24Series02"));
        inventoryCardPage.getAvailableSeries2().click();
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00024 24Series02 Стол24"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.getProductQuantity().shouldHave(exactText("8.000"));
        inventoryCardPage.setQtyInput("8");
        //inventoryPage.getItemViewInfo().shouldHave(text("0002 Series2 Стол2")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("8.0"));

        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.5");
        inventoryCardPage.setProductInput("00025");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00025 Стол25"));
        inventoryCardPage.setPalletWeight("2");
        inventoryCardPage.setTareQty("5");
        inventoryCardPage.setTareWeight("0.2");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("13");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00025 Стол25"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.6");
        inventoryCardPage.setProductInput("00026");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("26series01"));
        inventoryCardPage.getAvailableSeries().click();
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00026 26Series01 Стол26"));
        inventoryCardPage.setPalletWeight("2");
        inventoryCardPage.setTareQty("5");
        inventoryCardPage.setTareWeight("0.2");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("13");
        //inventoryPage.getItemViewInfo().shouldHave(text("0002 Series2 Стол2")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.7");
        inventoryCardPage.setProductInput("00027");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00027 31.12.2021 Стол27"));
        inventoryCardPage.setPalletWeight("2");
        inventoryCardPage.setTareQty("5");
        inventoryCardPage.setTareWeight("0.2");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("13");
        //inventoryPage.getItemViewInfo().shouldHave(text("0003 31.12.2021 Стол3")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.8");
        inventoryCardPage.setProductInput("00028");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00028 Стол28"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryCardPage.getItemViewInfo().shouldHave(text("0004 Стол4"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.9");
        inventoryCardPage.setProductInput("00029");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("29series01"));
        inventoryCardPage.getAvailableSeries().click();
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00029 29Series01 Стол29"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0002 Series2 Стол2")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("B.1.1.1.10");
        inventoryCardPage.setProductInput("00030");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00030 Стол30"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryCardPage.getItemViewInfo().shouldHave(text("0004 Стол4"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

    }

    @Test (priority = 4, dependsOnMethods = "processingInventoryTaskTest")
    public void checkingFreeAmountTest2() {
        steps.loginAsAdmin();

        allTasksPage.selectFindRestsMenu();

        findRestsPage.checkFreeRemainSwitchState(false);
        //findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG

        findRestsPage.setBarcodeInput("00021");
        findRestsPage.getProductDescription().shouldHave(text("00021 Стол21"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.1");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00022");
        findRestsPage.getProductDescription().shouldHave(text("00022 Стол22"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.2");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00023");
        findRestsPage.getProductDescription().shouldHave(text("00023 Стол23"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkLocationString1("B.1.1.1.3");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkPartyInfoString1("30-12-2021");
        findRestsPage.getQuantityString1().shouldHave(exactText("5.5"));

        findRestsPage.setBarcodeInput("00023");
        findRestsPage.getProductDescription().shouldHave(text("00023 Стол23"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkLocationString2("B.1.1.1.3");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkPartyInfoString2("31-12-2021");
        findRestsPage.getQuantityString2().shouldHave(exactText("4.5"));

        findRestsPage.setBarcodeInput("00024");
        findRestsPage.getProductDescription().shouldHave(text("00024 Стол24"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkLocationString1("B.1.1.1.4");
        findRestsPage.checkPartyInfoString1("24Series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getQuantityString1().shouldHave(exactText("2"));

        findRestsPage.setBarcodeInput("00024");
        findRestsPage.getProductDescription().shouldHave(text("00024 Стол24"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkLocationString2("B.1.1.1.4");
        findRestsPage.checkPartyInfoString2("24Series02");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getQuantityString2().shouldHave(exactText("8"));

        findRestsPage.setBarcodeInput("00025");
        findRestsPage.getProductDescription().shouldHave(text("00025 Стол25"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.5");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00026"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00026 Стол26"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("B.1.1.1.6");
        findRestsPage.checkProductSeriesInfo("26series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00027"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00027 Стол27"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.7");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00028"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00028 Стол28"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.8");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00029"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00029 Стол29"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.9");
        findRestsPage.checkProductSeriesInfo("29Series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00030"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00030 Стол30"));
        findRestsPage.checkProductLocationInfo("B.1.1.1.10");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }
}
