package tests.scenarios.case1;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.Actions.*;
import static tests.utils.ModalDialogs.*;

public class WorkWithDailyTasksCaseOneTest extends BaseMobileClass {

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
     * All tests run on Regress/Case1/wms_regress_case1_Reception_Inventory DB
     * All tests run according to TestNG priority.
     * If test fails - next one will be skipped according to TestNG dependsOnMethods
     */

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0001 00001 Стол1 IN.01 Quantity 10 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("0001"); // set sku
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00010 00010 Стол10 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("00010"); // set sku
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Стол2 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0002"); // set sku
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("Series2");
        clickSetOkYesButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Series2 Стол2 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 Стол3 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0003"); // set sku
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        clickSetOkYesButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 31.12.2021 Стол3 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0004 00004 Стол4 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0004"); // set sku
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 Стол4"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 Стол5 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0005"); // set sku
        getAlertModalDialog().shouldHave(text("Series / shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.createNewSeries("series5");
        clickSetOkYesButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 series5 31.12.2021 Стол5 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 Стол6 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0006"); // set sku
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("series6");
        clickSetOkYesButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 Стол6"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        hideKeyboard();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 series6 Стол6 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 Стол7 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0007"); // set sku
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        clickSetOkYesButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 Стол7"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        hideKeyboard();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 31.12.2021 Стол7 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 Стол8 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0008"); // set sku000
        getAlertModalDialog().shouldHave(text("Series / shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.createNewSeries("series8");
        clickSetOkYesButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 Стол8"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        hideKeyboard();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 series8 31.12.2021 Стол8 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0009"); // set sku
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 Стол9"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        hideKeyboard();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0001 00001 Стол1 IN.01 ➡ A.1.1.1.1 Quantity 10 шт"));
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.setProductInput("0001"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.1");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Series2 Стол2 IN.01 ➡ A.1.1.1.2 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0002"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.2");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 31.12.2021 Стол3 IN.01 ➡ A.1.1.1.3 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0003"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.3");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0004 00004 Стол4 IN.01 ➡ A.1.1.1.4 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0004"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.4");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 series5 31.12.2021 Стол5 IN.01 ➡ A.1.1.1.5 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0005"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.5");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 series6 Стол6 IN.01 ➡ A.1.1.1.6 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0006"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.6");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 31.12.2021 Стол7 IN.01 ➡ A.1.1.1.7 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0007"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.7");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 series8 31.12.2021 Стол8 IN.01 ➡ A.1.1.1.8 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0008"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.8");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 IN.01 ➡ A.1.1.1.9 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0009"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.9");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00010 00010 Стол10 IN.01 ➡ A.1.1.1.10 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00010"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.10");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();

        allTasksPage.selectFindRestsMenu();

        findRestsPage.checkFreeRemainSwitchState(false);
        //findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG

        findRestsPage.setBarcodeInput("0001"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0001 00001 Стол1"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.1");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0002"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0002 00002 Стол2"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.2");
        findRestsPage.checkProductSeriesInfo("Series2");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0003"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0003 00003 Стол3"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.3");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0004"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0004 00004 Стол4"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.4");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0005"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0005 00005 Стол5"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.5");
        findRestsPage.checkProductSeriesInfo("series5");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0006"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0006 00006 Стол6"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.6");
        findRestsPage.checkProductSeriesInfo("series6");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0007"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0007 00007 Стол7"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.7");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0008"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0008 00008 Стол8"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.8");
        findRestsPage.checkProductSeriesInfo("series8");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0009"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0009 00009 Стол9"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.9");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00010"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00010 00010 Стол10"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.10");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkTypesQty(2);
        allTasksPage.clickInventoryTypeTaskQuantity();

        inventoryCardPage.setCellInput("A.1.1.1.1");
        inventoryCardPage.setProductInput("0001");
        inventoryCardPage.getProductInfo().shouldHave(exactText("0001 00001 Стол1"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("0001 Стол1"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.2");
        inventoryCardPage.setProductInput("0002");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("Series2"));
        inventoryCardPage.getAvailableSeries().click();
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("0002 00002 Series2 Стол2"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0002 Series2 Стол2")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.3");
        inventoryCardPage.setProductInput("0003");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("0003 00003 31.12.2021 Стол3"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0003 31.12.2021 Стол3")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.4");
        inventoryCardPage.setProductInput("0004");
        inventoryCardPage.getProductInfo().shouldHave(exactText("0004 00004 Стол4"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("0004 Стол4"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.5");
        inventoryCardPage.setProductInput("0005");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("series5"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series5"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("0005 00005 series5 31.12.2021 Стол5"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0005 series5 31.12.2021 Стол5")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.6");
        inventoryCardPage.setProductInput("0006");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("series6"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series6"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("0006 00006 series6 Стол6"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0006 series6 Стол6")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.7");
        inventoryCardPage.setProductInput("0007");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("0007 00007 31.12.2021 Стол7"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0007 31.12.2021 Стол7")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.8");
        inventoryCardPage.setProductInput("0008");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("series8"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series8"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("0008 00008 series8 31.12.2021 Стол8"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("0008 series8 31.12.2021 Стол8")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.9");
        inventoryCardPage.setProductInput("0009");
        inventoryCardPage.getProductInfo().shouldHave(exactText("0009 00009 Стол9"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("0009 Стол9"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.10");
        inventoryCardPage.setProductInput("00010");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00010 00010 Стол10"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00010 Стол10"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    }

    @Test (priority = 4, dependsOnMethods = "processingInventoryTaskTest")
    public void checkingFreeAmountAfterProcessingInventoryTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkTypesQty(1);
        allTasksPage.checkWorkType("Selection");
        allTasksPage.selectFindRestsMenu();

        findRestsPage.checkFreeRemainSwitchState(false);
        //findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG

        findRestsPage.setBarcodeInput("0001"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0001 00001 Стол1"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.1");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0002"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0002 00002 Стол2"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.2");
        findRestsPage.checkProductSeriesInfo("Series2");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0003"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0003 00003 Стол3"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.3");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0004"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0004 00004 Стол4"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.4");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0005"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0005 00005 Стол5"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.5");
        findRestsPage.checkProductSeriesInfo("series5");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0006"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0006 00006 Стол6"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.6");
        findRestsPage.checkProductSeriesInfo("series6");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0007"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0007 00007 Стол7"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.7");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0008"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0008 00008 Стол8"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.8");
        findRestsPage.checkProductSeriesInfo("series8");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0009"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0009 00009 Стол9"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.9");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00010"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00010 00010 Стол10"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.10");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }

    @Test (priority = 5, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");

        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0001 00001 Стол1 A.1.1.1.1 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.1");
        selectionCardPage.setProductInput("0001"); // set sku
        selectionCardPage.setDestinationInput("OUT101");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Series2 Стол2 A.1.1.1.2 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.2");
        selectionCardPage.setProductInput("0002"); // set sku
        selectionCardPage.setDestinationInput("OUT102");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 31.12.2021 Стол3 A.1.1.1.3 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.3");
        selectionCardPage.setProductInput("0003"); // set sku
        selectionCardPage.setDestinationInput("OUT103");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0004 00004 Стол4 A.1.1.1.4 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.4");
        selectionCardPage.setProductInput("0004"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 Стол4"));
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT104");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 series5 31.12.2021 Стол5 A.1.1.1.5 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.5");
        selectionCardPage.setProductInput("0005"); // set sku
        selectionCardPage.setDestinationInput("OUT105");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 series6 Стол6 A.1.1.1.6 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.6");
        selectionCardPage.setProductInput("0006"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 Стол6")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT106");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 31.12.2021 Стол7 A.1.1.1.7 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.7");
        selectionCardPage.setProductInput("0007"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 Стол7")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT107");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 series8 31.12.2021 Стол8 A.1.1.1.8 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.8");
        selectionCardPage.setProductInput("0008"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 Стол8")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT108");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 A.1.1.1.9 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.9");
        selectionCardPage.setProductInput("0009"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 Стол9")); //TODO BUG
        selectionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        selectionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT109");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00010 00010 Стол10 A.1.1.1.10 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.10");
        selectionCardPage.setProductInput("00010"); // set sku
        selectionCardPage.setDestinationInput("OUT110");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Контейнер");
    }

    @Test (priority = 6, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT101 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT101");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT102 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT102");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT103 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT103");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT104 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT104");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT105 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT105");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT106 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT106");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT107 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT107");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT108 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT108");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT109 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT109");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT110 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT110");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Control");
    }

    @Test (priority = 7, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT101");
        controlCardPage.getProductInfo().shouldHave(text("0001 Стол1"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT101"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0001");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT102");
        controlCardPage.getProductInfo().shouldHave(text("0002 Стол2"));
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("Series2"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT102"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0002");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("Series2"));
        controlCardPage.getAvailableSeries().click();
        clickSetOkYesButton();
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("Series2"));
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT103");
        controlCardPage.getProductInfo().shouldHave(text("0003 Стол3"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT103"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0003");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT104");
        controlCardPage.getProductInfo().shouldHave(text("0004 Стол4"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT104"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0004");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 Стол4"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT105");
        controlCardPage.getProductInfo().shouldHave(text("0005 Стол5"));
        controlCardPage.getSeriesInfo().shouldHave(text("series5"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT105"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0005");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("series5"));
        controlCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.getSeriesBox().shouldHave(text("series5"));
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT106");
        controlCardPage.getProductInfo().shouldHave(text("0006 Стол6"));
        controlCardPage.getSeriesInfo().shouldHave(text("series6"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT106"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0006");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("series6"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getSeriesBox().shouldHave(text("series6"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 series6 Стол6"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT107");
        controlCardPage.getProductInfo().shouldHave(text("0007 Стол7"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT107"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0007");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 Стол7")); //TODO BUG: incorrect expiration date
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT108");
        controlCardPage.getProductInfo().shouldHave(text("0008 Стол8"));
        controlCardPage.getSeriesInfo().shouldHave(text("series8"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT108"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0008");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("series8"));
        controlCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getSeriesBox().shouldHave(text("series8"));
        controlCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 series8 2021-12-31T00:00:00 Стол8"));
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT109");
        controlCardPage.getProductInfo().shouldHave(text("0009 Стол9"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT109"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0009");
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 Стол9"));
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        controlCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT110");
        controlCardPage.getProductInfo().shouldHave(text("00010 Стол10"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT110"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("00010");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    }

    @Test (priority = 8, dependsOnMethods = "processingControlTaskTest")
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

        packagingCardPage.setCellOrContainerInput("KT1.01.01.01.01");

        packagingCardPage.checkCellProductInfoInRow(1, "OUT101", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(2, "OUT102", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(3, "OUT103", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(4, "OUT104", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(5, "OUT105", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(6, "OUT106", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(7, "OUT107", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(8, "OUT108", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(9, "OUT109", "10", "0.01", "0.01");
        packagingCardPage.checkCellProductInfoInRow(10, "OUT110", "10", "0.01", "0.01");

        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    }

    @Test (priority = 9, dependsOnMethods = "processingPackagingTaskTest")
    public void processingLoadingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Loading");
        allTasksPage.getWorkTypeTasksQuantity().click();

        loadingCardPage.setRouteSheetInput("I000000001");
        loadingCardPage.setGateInput("OUT.01");
        loadingCardPage.checkLoadingInfo("0", "Контрагент1", "0", "10");
        loadingCardPage.setSerialCargoInput("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
        loadingCardPage.checkLoadingInfo("0", "Контрагент1", "10", "0");
        loadingCardPage.clickCommitButton();
    }
}
