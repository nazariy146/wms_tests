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
    //Стол11
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","11fragbc");
        receptionCardPage.verifyData("productInfo", "00011 Стол11 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол12
        receptionCardPage.verifyData("productInfo", "00012 12Series01 Стол12 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","12fragbc");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол13
        receptionCardPage.verifyData("productInfo", "00013 31.12.2021 Стол13 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","13fragbc");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол14
        receptionCardPage.verifyData("productInfo", "00014 Стол14 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","14fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.verifyData("productInfoSN","00014 Стол14");
        receptionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("14serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол15
        receptionCardPage.verifyData("productInfo", "00015 15series01 31.12.2021 Стол15 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","15fragbc");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол16
        receptionCardPage.verifyData("productInfo", "00016 16series01 Стол16 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","16fragbc");
        receptionCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("16serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол17
        receptionCardPage.verifyData("productInfo", "00017 31.12.2021 Стол17 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","17fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("17serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол18
        receptionCardPage.verifyData("productInfo", "00018 18series01 31.12.2021 Стол18 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","18fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("18serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол19
        receptionCardPage.verifyData("productInfo", "00019 Стол19 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","19fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("19serialnumber01", "19serialnumber02", "19serialnumber03", "19serialnumber04", "19serialnumber05", "19serialnumber06", "19serialnumber07", "19serialnumber08", "19serialnumber09", "19serialnumber10");
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("19serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(3).shouldHave(exactText("19serialnumber02"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(4).shouldHave(exactText("19serialnumber03"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(5).shouldHave(exactText("19serialnumber04"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(6).shouldHave(exactText("19serialnumber05"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(7).shouldHave(exactText("19serialnumber06"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(8).shouldHave(exactText("19serialnumber07"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(9).shouldHave(exactText("19serialnumber08"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(10).shouldHave(exactText("19serialnumber09"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(11).shouldHave(exactText("19serialnumber10"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол20
        receptionCardPage.verifyData("productInfo", "00020 Стол20 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","20fragbc");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол11
        accommodationCardPage.verifyData("productInfo", "00011 Стол11 IN.01 ➡ A.1.1.1.11 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","11fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.11");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол12
        accommodationCardPage.verifyData("productInfo", "00012 12Series01 Стол12 IN.01 ➡ A.1.1.1.12 Quantity 10 шт");
        accommodationCardPage.inputData("product","12fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.12");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол13
        accommodationCardPage.verifyData("productInfo", "00013 31.12.2021 Стол13 IN.01 ➡ A.1.1.1.13 Quantity 10 шт");
        accommodationCardPage.inputData("product","13fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.13");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол14
        accommodationCardPage.verifyData("productInfo", "00014 Стол14 IN.01 ➡ A.1.1.1.14 Quantity 10 шт");
        accommodationCardPage.inputData("product","14fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.14");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол15
        accommodationCardPage.verifyData("productInfo", "00015 15series01 31.12.2021 Стол15 IN.01 ➡ A.1.1.1.15 Quantity 10 шт");
        accommodationCardPage.inputData("product","15fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.15");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол16
        accommodationCardPage.verifyData("productInfo", "00016 16series01 Стол16 IN.01 ➡ A.1.1.1.16 Quantity 10 шт");
        accommodationCardPage.inputData("product","16fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.16");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол17
        accommodationCardPage.verifyData("productInfo", "00017 31.12.2021 Стол17 IN.01 ➡ A.1.1.1.17 Quantity 10 шт");
        accommodationCardPage.inputData("product","17fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.17");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол18
        accommodationCardPage.verifyData("productInfo", "00018 18series01 31.12.2021 Стол18 IN.01 ➡ A.1.1.1.18 Quantity 10 шт");
        accommodationCardPage.inputData("product","18fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.18");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол19
        accommodationCardPage.verifyData("productInfo", "00019 Стол19 IN.01 ➡ A.1.1.1.19 Quantity 10 шт");
        accommodationCardPage.inputData("product","19fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.19");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол20
        accommodationCardPage.verifyData("productInfo", "00020 Стол20 IN.01 ➡ A.1.1.1.20 Quantity 10 шт");
        accommodationCardPage.inputData("product","20fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.20");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
    //Стол11
        findRestsPage.inputData("product", "11fragbc");
        findRestsPage.verifyData("productInfo", "00011 Стол11");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.11");
        findRestsPage.verifyData("qty", "10");
    //Стол12
        findRestsPage.inputData("product", "12fragbc");
        findRestsPage.verifyData("productInfo", "00012 Стол12");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.12");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "12Series01");
    //Стол13
        findRestsPage.inputData("product", "13fragbc");
        findRestsPage.verifyData("productInfo", "00013 Стол13");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.13");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол14
        findRestsPage.inputData("product", "14fragbc");
        findRestsPage.verifyData("productInfo", "00014 Стол14");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.14");
        findRestsPage.verifyData("qty", "10");
    //Стол15
        findRestsPage.inputData("product", "15fragbc");
        findRestsPage.verifyData("productInfo", "00015 Стол15");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.15");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "15series01");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол16
        findRestsPage.inputData("product", "16fragbc");
        findRestsPage.verifyData("productInfo", "00016 Стол16");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.16");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "16series01");
    //Стол17
        findRestsPage.inputData("product", "17fragbc");
        findRestsPage.verifyData("productInfo", "00017 Стол17");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.17");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол18
        findRestsPage.inputData("product", "18fragbc");
        findRestsPage.verifyData("productInfo", "00018 Стол18");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.18");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "18series01");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол19
        findRestsPage.inputData("product", "19fragbc");
        findRestsPage.verifyData("productInfo", "00019 Стол19");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.19");
        findRestsPage.verifyData("qty", "10");
    //Стол20
        findRestsPage.inputData("product", "20fragbc");
        findRestsPage.verifyData("productInfo", "00020 Стол20");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.20");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();

        //allTasksPage.checkWorkTypesQty(2);
        //allTasksPage.clickInventoryTypeTaskQuantity();
        allTasksPage.getStringTasks(2).click();

    //Стол11
        inventoryCardPage.inputData("source", "A.1.1.1.11");
        inventoryCardPage.inputData("product", "11fragbc");
        inventoryCardPage.verifyData("productInfo", "00011 Стол11");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00011 Стол11");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол12
        inventoryCardPage.inputData("source", "A.1.1.1.12");
        inventoryCardPage.inputData("product", "12fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("12Series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        clickSetOkYesButton();
        inventoryCardPage.verifyData("productInfo", "00012 12Series01 Стол12");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол13
        inventoryCardPage.inputData("source", "A.1.1.1.13");
        inventoryCardPage.inputData("product", "13fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.verifyData("productInfo", "00013 31.12.2021 Стол13");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00013 31.12.2021 Стол13");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол14
        inventoryCardPage.inputData("source", "A.1.1.1.14");
        inventoryCardPage.inputData("product", "14fragbc");
        inventoryCardPage.verifyData("productInfo", "00014 Стол14");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00014 Стол14");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол15
        inventoryCardPage.inputData("source", "A.1.1.1.15");
        inventoryCardPage.inputData("product", "15fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("15series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        clickSetOkYesButton();
        inventoryCardPage.verifyData("productInfo", "00015 15series01 31.12.2021 Стол15");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00015 15series01 31.12.2021 Стол15");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол16
        inventoryCardPage.inputData("source", "A.1.1.1.16");
        inventoryCardPage.inputData("product", "16fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("16series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("16series01"));
        clickSetOkYesButton();
        inventoryCardPage.verifyData("productInfo", "00016 16series01 Стол16");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00016 16series01 Стол16");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол17
        inventoryCardPage.inputData("source", "A.1.1.1.17");
        inventoryCardPage.inputData("product", "17fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.verifyData("productInfo", "00017 31.12.2021 Стол17");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00017 31.12.2021 Стол17");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол18
        inventoryCardPage.inputData("source", "A.1.1.1.18");
        inventoryCardPage.inputData("product", "18fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("18series01"));
        inventoryCardPage.getAvailableExpirationDateZ22().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("18series01"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        inventoryCardPage.verifyData("productInfo", "00018 18series01 31.12.2021 Стол18");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00018 18series01 31.12.2021 Стол18");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол19
        inventoryCardPage.inputData("source", "A.1.1.1.19");
        inventoryCardPage.inputData("product", "19fragbc");
        inventoryCardPage.verifyData("productInfo", "00019 Стол19");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00019 Стол19");
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция"));
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0"));
        inventoryCardPage.clickInventoryButton();
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?"));
        clickSetOkYesButton();
    //Стол20
        inventoryCardPage.inputData("source", "A.1.1.1.20");
        inventoryCardPage.inputData("product", "20fragbc");
        inventoryCardPage.verifyData("productInfo", "00020 Стол20");
        inventoryCardPage.selectQuality("Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00020 Стол20");
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

        //Стол11
        findRestsPage.inputData("product", "11fragbc");
        findRestsPage.verifyData("productInfo", "00011 Стол11");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.11");
        findRestsPage.verifyData("qty", "10");
        //Стол12
        findRestsPage.inputData("product", "12fragbc");
        findRestsPage.verifyData("productInfo", "00012 Стол12");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.12");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "12Series01");
        //Стол13
        findRestsPage.inputData("product", "13fragbc");
        findRestsPage.verifyData("productInfo", "00013 Стол13");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.13");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол14
        findRestsPage.inputData("product", "14fragbc");
        findRestsPage.verifyData("productInfo", "00014 Стол14");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.14");
        findRestsPage.verifyData("qty", "10");
        //Стол15
        findRestsPage.inputData("product", "15fragbc");
        findRestsPage.verifyData("productInfo", "00015 Стол15");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.15");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "15series01");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол16
        findRestsPage.inputData("product", "16fragbc");
        findRestsPage.verifyData("productInfo", "00016 Стол16");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.16");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "16series01");
        //Стол17
        findRestsPage.inputData("product", "17fragbc");
        findRestsPage.verifyData("productInfo", "00017 Стол17");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.17");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол18
        findRestsPage.inputData("product", "18fragbc");
        findRestsPage.verifyData("productInfo", "00018 Стол18");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.18");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "18series01");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол19
        findRestsPage.inputData("product", "19fragbc");
        findRestsPage.verifyData("productInfo", "00019 Стол19");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.19");
        findRestsPage.verifyData("qty", "10");
        //Стол20
        findRestsPage.inputData("product", "20fragbc");
        findRestsPage.verifyData("productInfo", "00020 Стол20");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.20");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 5, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");

        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол11
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00011 Стол11 A.1.1.1.11 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.11");
        selectionCardPage.setProductInput("11fragbc");
        selectionCardPage.setDestinationInput("OUT111");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол12
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00012 12Series01 Стол12 A.1.1.1.12 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.12");
        selectionCardPage.setProductInput("12fragbc");
        selectionCardPage.setDestinationInput("OUT112");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол13
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00013 31.12.2021 Стол13 A.1.1.1.13 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.13");
        selectionCardPage.setProductInput("13fragbc");
        selectionCardPage.setDestinationInput("OUT113");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол14
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00014 Стол14 A.1.1.1.14 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.14");
        selectionCardPage.setProductInput("14fragbc");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        selectionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("14serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT114");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол15
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00015 15series01 31.12.2021 Стол15 A.1.1.1.15 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.15");
        selectionCardPage.setProductInput("15fragbc");
        selectionCardPage.setDestinationInput("OUT115");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол16
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00016 16series01 Стол16 A.1.1.1.16 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.16");
        selectionCardPage.setProductInput("16fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00016 Стол16")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("16serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT116");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол17
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00017 31.12.2021 Стол17 A.1.1.1.17 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.17");
        selectionCardPage.setProductInput("17fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00017 Стол17")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("17serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT117");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол18
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00018 18series01 31.12.2021 Стол18 A.1.1.1.18 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.18");
        selectionCardPage.setProductInput("18fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00018 Стол18")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("18serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT118");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол19
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00019 Стол19 A.1.1.1.19 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.19");
        selectionCardPage.setProductInput("19fragbc"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00019 Стол19")); //TODO BUG
        selectionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        selectionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        selectionCardPage.setSerialNumberInputSeveralTimes("19serialnumber01", "19serialnumber02", "19serialnumber03", "19serialnumber04", "19serialnumber05", "19serialnumber06", "19serialnumber07", "19serialnumber08", "19serialnumber09", "19serialnumber10");
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("19serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(3).shouldHave(exactText("19serialnumber02"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(4).shouldHave(exactText("19serialnumber03"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(5).shouldHave(exactText("19serialnumber04"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(6).shouldHave(exactText("19serialnumber05"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(7).shouldHave(exactText("19serialnumber06"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(8).shouldHave(exactText("19serialnumber07"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(9).shouldHave(exactText("19serialnumber08"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(10).shouldHave(exactText("19serialnumber09"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(11).shouldHave(exactText("19serialnumber10"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT119");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол20
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00020 Стол20 A.1.1.1.20 ➡ KT1.01.01.01.01 Quantity 10 шт"));
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

    //Стол11
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT111 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT111");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол12
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT112 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT112");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол13
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT113 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT113");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол14
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT114 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT114");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол15
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT115 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT115");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол16
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT116 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT116");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол17
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT117 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT117");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол18
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT118 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT118");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол19
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT119 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT119");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол20
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

    //Стол11
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT111");
        controlCardPage.getProductInfo().shouldHave(text("00011 Стол11"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT111"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("11fragbc");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();
    //Стол12
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT112");
        controlCardPage.getProductInfo().shouldHave(text("00012 Стол12"));
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("12Series01"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT112"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("12fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("12Series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        clickSetOkYesButton();
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("12Series01"));
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();
    //Стол13
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT113");
        controlCardPage.getProductInfo().shouldHave(text("00013 Стол13"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT113"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("13fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();
    //Стол14
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
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("14serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();
    //Стол15
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT115");
        controlCardPage.getProductInfo().shouldHave(text("00015 Стол15"));
        controlCardPage.getSeriesInfo().shouldHave(text("15series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT115"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("15fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("15series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();
    //Стол16
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT116");
        controlCardPage.getProductInfo().shouldHave(text("00016 Стол16"));
        controlCardPage.getSeriesInfo().shouldHave(text("16series01"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT116"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("16fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("16series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("16series01"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00016 16series01 Стол16"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("16serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();
    //Стол17
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT117");
        controlCardPage.getProductInfo().shouldHave(text("00017 Стол17"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT117"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("17fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00017 2021-12-31T00:00:00 Стол17")); //TODO BUG: incorrect expiration date
        controlCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("17serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();
    //Стол18
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT118");
        controlCardPage.getProductInfo().shouldHave(text("00018 Стол18"));
        controlCardPage.getSeriesInfo().shouldHave(text("18series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT118"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("18fragbc");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("18series01"));
        inventoryCardPage.getAvailableExpirationDateZ22().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("18series01"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00018 18series01 2021-12-31T00:00:00 Стол18"));
        controlCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("18serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();
    //Стол19
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
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("19serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(3).shouldHave(exactText("19serialnumber02"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(4).shouldHave(exactText("19serialnumber03"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(5).shouldHave(exactText("19serialnumber04"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(6).shouldHave(exactText("19serialnumber05"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(7).shouldHave(exactText("19serialnumber06"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(8).shouldHave(exactText("19serialnumber07"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(9).shouldHave(exactText("19serialnumber08"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(10).shouldHave(exactText("19serialnumber09"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(11).shouldHave(exactText("19serialnumber10"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.clickCommitButton();
    //Стол20
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT120");
        controlCardPage.getProductInfo().shouldHave(text("00020 Стол20"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT120"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("20fragbc");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.clickCommitButton();

        /*controlCardPage.setCellInput("KT1.01.01.01.01");
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
        controlCardPage.clickCommitButton();*/
    }

    @Test (priority = 8, dependsOnMethods = "processingControlTaskTest")
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол11
        packagingCardPage.setCellOrContainerInput("OUT111");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT111", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол12
        packagingCardPage.setCellOrContainerInput("OUT112");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT112", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол13
        packagingCardPage.setCellOrContainerInput("OUT113");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT113", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол14
        packagingCardPage.setCellOrContainerInput("OUT114");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT114", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол15
        packagingCardPage.setCellOrContainerInput("OUT115");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT115", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол16
        packagingCardPage.setCellOrContainerInput("OUT116");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT116", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол17
        packagingCardPage.setCellOrContainerInput("OUT117");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT117", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол18
        packagingCardPage.setCellOrContainerInput("OUT118");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT118", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол19
        packagingCardPage.setCellOrContainerInput("OUT119");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT119", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    //Стол20
        packagingCardPage.setCellOrContainerInput("OUT120");
        packagingCardPage.checkCellProductInfoInRow(1, "OUT120", "10", "0.1", "0.1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    }

    @Test (priority = 9, dependsOnMethods = "processingPackagingTaskTest")
    public void processingConsolidateContainerTask() {
        steps.loginAsAdmin();

        allTasksPage.selectConsolidateContainerMenu();

        /*consolidateContainerPage.setSeveralConsolidateContainer(true);
        consolidateContainerPage.setContainerSeveralTimes("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
        consolidateContainerPage.checkAllProductsInfoAndQty(1, "9990000000012", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(2, "9990000000029", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(3, "9990000000036", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(4, "9990000000043", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(5, "9990000000050", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(6, "9990000000067", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(7, "9990000000074", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(8, "9990000000081", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(9, "9990000000098", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.checkAllProductsInfoAndQty(10, "9990000000104", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.setCreateConsolidateContainer(true);
        consolidateContainerPage.getReceiverInput().shouldBe(disabled);
        consolidateContainerPage.clickConsolidateButton();*/
    }

    @Test (priority = 10, dependsOnMethods = "processingConsolidateContainerTask")
    public void processingLoadingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Loading");
        allTasksPage.getWorkTypeTasksQuantity().click();

        loadingCardPage.checkAndSelectAvailableRouteSheet("Маршрутный лист 000000001 от", "Нікулін Олександр Миколайович");
        loadingCardPage.getRouteSheetInput().shouldHave(exactText("I000000001"));
        loadingCardPage.setGateInput("OUT.01");
        loadingCardPage.checkLoadingInfo("0", "Костенко", "0", "1");
        loadingCardPage.setSerialCargoInput("9990000000111");
        loadingCardPage.checkLoadingInfo("0", "Костенко", "1", "0");
        loadingCardPage.clickCommitButton();
    }
}
