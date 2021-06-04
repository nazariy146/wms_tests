package tests.scenarios.case2;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static tests.utils.ModalDialogs.*;

public class WorkWithDailyTasksCaseTwoTest extends BaseMobileClass {

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
    ConsolidateContainerPage consolidateContainerPage = new ConsolidateContainerPage();
    InventoryCardPage inventoryCardPage = new InventoryCardPage();

    /**
     * All tests run on Regress/Case2/wms_regress_case2_Reception DB
     * All tests run according to TestNG priority.
     * If test fails - next one will be skipped according to TestNG dependsOnMethods
     */

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Reception");
        //allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00011 000011 Стол11 IN.01 Quantity 10 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("11fragbc");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00012 000012 12Series01 Стол12 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("12fragbc");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00013 000013 31.12.2021 Стол13 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("13fragbc");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00014 000014 Стол14 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("14fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        receptionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00015 000015 15series01 31.12.2021 Стол15 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("15fragbc");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00016 000016 16series01 Стол16 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("16fragbc");
        receptionCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00017 000017 31.12.2021 Стол17 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("17fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00018 000018 18series01 31.12.2021 Стол18 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("18fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00019 000019 Стол19 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("19fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("19serialnumber01", "19serialnumber02", "19serialnumber03", "19serialnumber04", "19serialnumber05", "19serialnumber06", "19serialnumber07", "19serialnumber08", "19serialnumber09", "19serialnumber10");
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00020 000020 Стол20 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("20fragbc");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00011 000011 Стол11 IN.01 ➡ A.1.1.1.11 Quantity 10 шт"));
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.setProductInput("11fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.11");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00012 000012 12Series01 Стол12 IN.01 ➡ A.1.1.1.12 Quantity 10 шт"));
        accommodationCardPage.setProductInput("12fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.12");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00013 000013 31.12.2021 Стол13 IN.01 ➡ A.1.1.1.13 Quantity 10 шт"));
        accommodationCardPage.setProductInput("13fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.13");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00014 000014 Стол14 IN.01 ➡ A.1.1.1.14 Quantity 10 шт"));
        accommodationCardPage.setProductInput("14fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.14");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00015 000015 15series01 31.12.2021 Стол15 IN.01 ➡ A.1.1.1.15 Quantity 10 шт"));
        accommodationCardPage.setProductInput("15fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.15");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00016 000016 16series01 Стол16 IN.01 ➡ A.1.1.1.16 Quantity 10 шт"));
        accommodationCardPage.setProductInput("16fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.16");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00017 000017 31.12.2021 Стол17 IN.01 ➡ A.1.1.1.17 Quantity 10 шт"));
        accommodationCardPage.setProductInput("17fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.17");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00018 000018 18series01 31.12.2021 Стол18 IN.01 ➡ A.1.1.1.18 Quantity 10 шт"));
        accommodationCardPage.setProductInput("18fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.18");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00019 000019 Стол19 IN.01 ➡ A.1.1.1.19 Quantity 10 шт"));
        accommodationCardPage.setProductInput("19fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.19");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00020 000020 Стол20 IN.01 ➡ A.1.1.1.20 Quantity 10 шт"));
        accommodationCardPage.setProductInput("20fragbc");
        accommodationCardPage.setDestinationInput("A.1.1.1.20");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();

        allTasksPage.selectFindRestsMenu();

        findRestsPage.checkFreeRemainSwitchState(false);
        //findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG

        findRestsPage.setBarcodeInput("11fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00011 000011 Стол11"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.11");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("12fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00012 000012 Стол12"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.12");
        findRestsPage.checkProductSeriesInfo("12Series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("13fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00013 000013 Стол13"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.13");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("14fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00014 000014 Стол14"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.14");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("15fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00015 000015 Стол15"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.15");
        findRestsPage.checkProductSeriesInfo("15series01");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("16fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00016 000016 Стол16"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.16");
        findRestsPage.checkProductSeriesInfo("16series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("17fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00017 000017 Стол17"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.17");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("18fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00018 000018 Стол18"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.18");
        findRestsPage.checkProductSeriesInfo("18series01");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("19fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00019 000019 Стол19"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.19");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("20fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00020 000020 Стол20"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.20");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();

        //allTasksPage.checkWorkTypesQty(2);
        allTasksPage.clickInventoryTypeTaskQuantity();

        inventoryCardPage.setCellInput("A.1.1.1.11");
        inventoryCardPage.setProductInput("11fragbc");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00011 000011 Стол11"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00011 Стол11"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.12");
        inventoryCardPage.setProductInput("12fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("12Series01"));
        inventoryCardPage.getAvailableSeries().click();
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00012 000012 12Series01 Стол12"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("00012 12Series01 Стол12)); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.13");
        inventoryCardPage.setProductInput("13fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00013 000013 31.12.2021 Стол13"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("00013 31.12.2021 Стол13")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.14");
        inventoryCardPage.setProductInput("14fragbc");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00014 000014 Стол14"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00014 Стол14"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.15");
        inventoryCardPage.setProductInput("15fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("15series01"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("15series01"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00015 000015 15series01 31.12.2021 Стол15"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("00015 15series01 31.12.2021 Стол15")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.16");
        inventoryCardPage.setProductInput("16fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("16series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("16series01"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00016 000016 16series01 Стол16"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("00016 16series01 Стол16")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.17");
        inventoryCardPage.setProductInput("17fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00017 000017 31.12.2021 Стол17"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("00017 31.12.2021 Стол17")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.18");
        inventoryCardPage.setProductInput("18fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("18series01"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("18series01"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.getProductInfo().shouldHave(exactText("00018 000018 18series01 31.12.2021 Стол18"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        //inventoryPage.getItemViewInfo().shouldHave(text("00018 18series01 31.12.2021 Стол18")); //TODO BUG
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.19");
        inventoryCardPage.setProductInput("19fragbc");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00019 000019 Стол19"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00019 Стол19"));
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();

        inventoryCardPage.setCellInput("A.1.1.1.20");
        inventoryCardPage.setProductInput("20fragbc");
        inventoryCardPage.getProductInfo().shouldHave(exactText("00020 000020 Стол20"));
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.setQtyInput("10");
        inventoryCardPage.getItemViewInfo().shouldHave(text("00020 Стол20"));
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

        findRestsPage.setBarcodeInput("11fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00011 000011 Стол11"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.11");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("12fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00012 000012 Стол12"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.12");
        findRestsPage.checkProductSeriesInfo("12Series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("13fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00013 000013 Стол13"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.13");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("14fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00014 000014 Стол14"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.14");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("15fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00015 000015 Стол15"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.15");
        findRestsPage.checkProductSeriesInfo("15series01");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("16fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00016 000016 Стол16"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.16");
        findRestsPage.checkProductSeriesInfo("16series01");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("17fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00017 000017 Стол17"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.17");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("18fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00018 000018 Стол18"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.18");
        findRestsPage.checkProductSeriesInfo("18series01");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("19fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00019 000019 Стол19"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.19");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("20fragbc");
        findRestsPage.getProductDescription().shouldHave(text("00020 000020 Стол20"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.20");
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

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00011 000011 Стол11 A.1.1.1.11 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.11");
        selectionCardPage.setProductInput("11fragbc");
        selectionCardPage.setDestinationInput("OUT111");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00012 000012 12Series01 Стол12 A.1.1.1.12 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.12");
        selectionCardPage.setProductInput("12fragbc");
        selectionCardPage.setDestinationInput("OUT112");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00013 000013 31.12.2021 Стол13 A.1.1.1.13 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.13");
        selectionCardPage.setProductInput("13fragbc");
        selectionCardPage.setDestinationInput("OUT113");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00014 000014 Стол14 A.1.1.1.14 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.14");
        selectionCardPage.setProductInput("14fragbc");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        selectionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT114");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00015 000015 15series01 31.12.2021 Стол15 A.1.1.1.15 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.15");
        selectionCardPage.setProductInput("15fragbc");
        selectionCardPage.setDestinationInput("OUT115");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00016 000016 16series01 Стол16 A.1.1.1.16 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.16");
        selectionCardPage.setProductInput("16fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00016 Стол16")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT116");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00017 000017 31.12.2021 Стол17 A.1.1.1.17 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.17");
        selectionCardPage.setProductInput("17fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00017 Стол17")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT117");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00018 000018 18series01 31.12.2021 Стол18 A.1.1.1.18 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.18");
        selectionCardPage.setProductInput("18fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00018 Стол18")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT118");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00019 000019 Стол19 A.1.1.1.19 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.19");
        selectionCardPage.setProductInput("19fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00019 Стол19")); //TODO BUG
        selectionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        selectionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        selectionCardPage.setSerialNumberInputSeveralTimes("19serialnumber01", "19serialnumber02", "19serialnumber03", "19serialnumber04", "19serialnumber05", "19serialnumber06", "19serialnumber07", "19serialnumber08", "19serialnumber09", "19serialnumber10");
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT119");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00020 000020 Стол20 A.1.1.1.20 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.20");
        selectionCardPage.setProductInput("20fragbc");
        selectionCardPage.setDestinationInput("OUT120");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Контейнер");
    }

    @Test (priority = 6, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT111 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT111");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT112 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT112");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT113 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT113");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT114 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT114");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT115 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT115");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT116 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT116");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT117 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT117");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT118 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT118");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT119 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT119");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT120 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT120");
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
        controlCardPage.setContainerInput("OUT111");
        controlCardPage.getProductInfo().shouldHave(text("00011 Стол11"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT111"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("11fragbc");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT112");
        controlCardPage.getProductInfo().shouldHave(text("00012 Стол12"));
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("12Series01"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT112"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("12fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("12Series01"));
        controlCardPage.getAvailableSeries().click();
        clickSetOkYesButton();
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("12Series01"));
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT113");
        controlCardPage.getProductInfo().shouldHave(text("00013 Стол13"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT113"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("13fragbc");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT114");
        controlCardPage.getProductInfo().shouldHave(text("00014 Стол14"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT114"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("14fragbc");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT115");
        controlCardPage.getProductInfo().shouldHave(text("00015 Стол15"));
        controlCardPage.getSeriesInfo().shouldHave(text("15series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT115"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("15fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("15series01"));
        controlCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.getSeriesBox().shouldHave(text("15series01"));
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT116");
        controlCardPage.getProductInfo().shouldHave(text("00016 Стол16"));
        controlCardPage.getSeriesInfo().shouldHave(text("16series01"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT116"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("16fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("16series01"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getSeriesBox().shouldHave(text("16series01"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00016 16series01 Стол16"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT117");
        controlCardPage.getProductInfo().shouldHave(text("00017 Стол17"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT117"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("17fragbc");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00017 Стол17")); //TODO BUG: incorrect expiration date
        controlCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT118");
        controlCardPage.getProductInfo().shouldHave(text("00018 Стол18"));
        controlCardPage.getSeriesInfo().shouldHave(text("18series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT118"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("18fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("18series01"));
        controlCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getSeriesBox().shouldHave(text("18series01"));
        controlCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00018 18series01 2021-12-31T00:00:00 Стол18"));
        controlCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT119");
        controlCardPage.getProductInfo().shouldHave(text("00019 Стол19"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT119"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("19fragbc");
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00019 Стол19"));
        controlCardPage.setSerialNumberInputSeveralTimes("19serialnumber01", "19serialnumber02", "19serialnumber03", "19serialnumber04", "19serialnumber05", "19serialnumber06", "19serialnumber07", "19serialnumber08", "19serialnumber09", "19serialnumber10");
        controlCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT120");
        controlCardPage.getProductInfo().shouldHave(text("00020 Стол20"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT120"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("20fragbc");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setOnOrOffFreeWCSwitcher(true);
        controlCardPage.checkAllProductsInfoAndQty(1, "10", "00011 Стол11");
        controlCardPage.checkAllProductsInfoAndQty(2, "10", "00012 Стол12");
        controlCardPage.checkAllProductsInfoAndQty(3, "10", "00013 Стол13");
        controlCardPage.checkAllProductsInfoAndQty(4, "10", "00014 Стол14");
        controlCardPage.checkAllProductsInfoAndQty(5, "10", "00015 Стол15");
        controlCardPage.checkAllProductsInfoAndQty(6, "10", "00016 Стол16");
        controlCardPage.checkAllProductsInfoAndQty(7, "10", "00017 Стол17");
        controlCardPage.checkAllProductsInfoAndQty(8, "10", "00018 Стол18");
        controlCardPage.checkAllProductsInfoAndQty(9, "10", "00019 Стол19");
        controlCardPage.checkAllProductsInfoAndQty(10, "10", "00020 Стол20");
        controlCardPage.clickCommitButton();
    }

    @Test (priority = 8, dependsOnMethods = "processingControlTaskTest")
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

        packagingCardPage.setCellOrContainerInput("OUT111");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT111", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT112");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT112", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT113");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT113", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT114");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT114", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT115");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT115", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT116");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT116", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT117");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT117", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT118");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT118", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT119");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT119", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();

        packagingCardPage.setCellOrContainerInput("OUT120");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT120", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargos will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    }

    @Test (priority = 9, dependsOnMethods = "processingPackagingTaskTest")
    public void processingConsolidateContainerTask() {
        steps.loginAsAdmin();

        allTasksPage.selectConsolidateContainerMenu();

        consolidateContainerPage.setSeveralConsolidateContainer(true);
        consolidateContainerPage.setContainerSeveralTimes("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
        consolidateContainerPage.checkAllProductsInfoAndQty(1, "9990000000012", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(2, "9990000000029", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(3, "9990000000036", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(4, "9990000000043", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(5, "9990000000050", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(6, "9990000000067", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(7, "9990000000074", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(8, "9990000000081", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(9, "9990000000098", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(10, "9990000000104", "Контрагент1 (count 10/countprod. 1) -->");
        consolidateContainerPage.setCreateConsolidateContainer(true);
        consolidateContainerPage.getReceiverInput().shouldBe(disabled);
        consolidateContainerPage.clickConsolidateButton();
    }

    @Test (priority = 10, dependsOnMethods = "processingConsolidateContainerTask")
    public void processingLoadingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Loading");
        allTasksPage.getWorkTypeTasksQuantity().click();

        loadingCardPage.checkAndSelectAvailableRouteSheet("Маршрутный лист 000000001 от", "Чоломбитько Юрій Миколайович");
        loadingCardPage.getRouteSheetInput().shouldHave(exactText("I000000001"));
        loadingCardPage.setGateInput("OUT.01");
        loadingCardPage.checkLoadingInfo("0", "Контрагент1", "0", "1");
        loadingCardPage.setSerialCargoInput("9990000000111");
        loadingCardPage.checkLoadingInfo("0", "Контрагент1", "1", "0");
        loadingCardPage.clickCommitButton();
    }


}
