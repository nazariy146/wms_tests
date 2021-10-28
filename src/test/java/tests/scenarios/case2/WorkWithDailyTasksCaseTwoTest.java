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
        receptionCardPage.andrDriver("source");
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
        receptionCardPage.verifyData("productInfoSN","00014 Стол14");
        receptionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("14serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
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
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол17
        receptionCardPage.verifyData("productInfo", "00017 31.12.2021 Стол17 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","17fragbc");
        receptionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("17serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол18
        receptionCardPage.verifyData("productInfo", "00018 18series01 31.12.2021 Стол18 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","18fragbc");
        receptionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("18serialnumber01"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол19
        receptionCardPage.verifyData("productInfo", "00019 Стол19 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","19fragbc");
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
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
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
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00011 Стол11");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол12
        inventoryCardPage.inputData("source", "A.1.1.1.12");
        inventoryCardPage.inputData("product", "12fragbc");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("12Series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00012 12Series01 Стол12");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол13
        inventoryCardPage.inputData("source", "A.1.1.1.13");
        inventoryCardPage.inputData("product", "13fragbc");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00013 31.12.2021 Стол13");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00013 31.12.2021 Стол13");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол14
        inventoryCardPage.inputData("source", "A.1.1.1.14");
        inventoryCardPage.inputData("product", "14fragbc");
        inventoryCardPage.verifyData("productInfo", "00014 Стол14");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00014 Стол14");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол15
        inventoryCardPage.inputData("source", "A.1.1.1.15");
        inventoryCardPage.inputData("product", "15fragbc");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("15series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00015 15series01 31.12.2021 Стол15");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00015 15series01 31.12.2021 Стол15");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол16
        inventoryCardPage.inputData("source", "A.1.1.1.16");
        inventoryCardPage.inputData("product", "16fragbc");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("16series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("16series01"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00016 16series01 Стол16");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00016 16series01 Стол16");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол17
        inventoryCardPage.inputData("source", "A.1.1.1.17");
        inventoryCardPage.inputData("product", "17fragbc");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00017 31.12.2021 Стол17");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00017 31.12.2021 Стол17");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол18
        inventoryCardPage.inputData("source", "A.1.1.1.18");
        inventoryCardPage.inputData("product", "18fragbc");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("18series01"));
        inventoryCardPage.getAvailableExpirationDateZ22().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("18series01"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00018 18series01 31.12.2021 Стол18");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00018 18series01 31.12.2021 Стол18");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол19
        inventoryCardPage.inputData("source", "A.1.1.1.19");
        inventoryCardPage.inputData("product", "19fragbc");
        inventoryCardPage.verifyData("productInfo", "00019 Стол19");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00019 Стол19");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол20
        inventoryCardPage.inputData("source", "A.1.1.1.20");
        inventoryCardPage.inputData("product", "20fragbc");
        inventoryCardPage.verifyData("productInfo", "00020 Стол20");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00020 Стол20");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
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
        selectionCardPage.verifyData("productInfo", "00011 Стол11 A.1.1.1.11 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.11");
        selectionCardPage.inputData("product", "11fragbc");
        selectionCardPage.inputData("destination", "OUT111");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол12
        selectionCardPage.verifyData("productInfo", "00012 12Series01 Стол12 A.1.1.1.12 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.12");
        selectionCardPage.inputData("product", "12fragbc");
        selectionCardPage.inputData("destination", "OUT112");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол13
        selectionCardPage.verifyData("productInfo", "00013 31.12.2021 Стол13 A.1.1.1.13 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.13");
        selectionCardPage.inputData("product", "13fragbc");
        selectionCardPage.inputData("destination", "OUT113");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол14
        selectionCardPage.verifyData("productInfo", "00014 Стол14 A.1.1.1.14 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.14");
        selectionCardPage.inputData("product", "14fragbc");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        selectionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("14serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT114");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол15
        selectionCardPage.verifyData("productInfo", "00015 15series01 31.12.2021 Стол15 A.1.1.1.15 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.15");
        selectionCardPage.inputData("product", "15fragbc");
        selectionCardPage.inputData("destination", "OUT115");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол16
        selectionCardPage.verifyData("productInfo", "00016 16series01 Стол16 A.1.1.1.16 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.16");
        selectionCardPage.inputData("product", "16fragbc");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00016 Стол16")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("16serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT116");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол17
        selectionCardPage.verifyData("productInfo", "00017 31.12.2021 Стол17 A.1.1.1.17 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.17");
        selectionCardPage.inputData("product", "17fragbc");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00017 Стол17")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("17serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT117");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол18
        selectionCardPage.verifyData("productInfo", "00018 18series01 31.12.2021 Стол18 A.1.1.1.18 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.18");
        selectionCardPage.inputData("product", "18fragbc");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00018 Стол18")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("18serialnumber01"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT118");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол19
        selectionCardPage.verifyData("productInfo", "00019 Стол19 A.1.1.1.19 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.19");
        selectionCardPage.inputData("product", "19fragbc");
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
        selectionCardPage.inputData("destination", "OUT119");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол20
        selectionCardPage.verifyData("productInfo", "00020 Стол20 A.1.1.1.20 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.20");
        selectionCardPage.inputData("product", "20fragbc");
        selectionCardPage.inputData("destination", "OUT120");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол11
        containerCardPage.verifyData("containerInfo", "CON/OUT111 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT111");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол12
        containerCardPage.verifyData("containerInfo", "CON/OUT112 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT112");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол13
        containerCardPage.verifyData("containerInfo", "CON/OUT113 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT113");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол14
        containerCardPage.verifyData("containerInfo", "CON/OUT114 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT114");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол15
        containerCardPage.verifyData("containerInfo", "CON/OUT115 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT115");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол16
        containerCardPage.verifyData("containerInfo", "CON/OUT116 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT116");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол17
        containerCardPage.verifyData("containerInfo", "CON/OUT117 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT117");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол18
        containerCardPage.verifyData("containerInfo", "CON/OUT118 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT118");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
    //Стол19
        containerCardPage.verifyData("containerInfo", "CON/OUT119 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT119");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол20
        containerCardPage.verifyData("containerInfo", "CON/OUT120 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT120");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    }

    @Test (priority = 7, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол11
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT111");
        controlCardPage.verifyData("productInfo", "00011 Стол11");
        controlCardPage.verifyData("containerInfo", "OUT111");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","11fragbc");
        controlCardPage.inputData("qty","10");
        controlCardPage.clickButton("commit");
    //Стол12
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT112");
        controlCardPage.verifyData("productInfo", "00012 Стол12");
        controlCardPage.verifyData("containerInfo", "OUT112");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","12fragbc");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("12Series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        controlCardPage.clickButton("commitSN");
        controlCardPage.verifyData("seriesInfo", "12Series01");
        controlCardPage.inputData("qty","10");
        controlCardPage.clickButton("commit");
    //Стол13
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT113");
        controlCardPage.verifyData("productInfo", "00013 Стол13");
        controlCardPage.verifyData("containerInfo", "OUT113");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","13fragbc");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("qty","10");
        controlCardPage.clickButton("commit");
    //Стол14
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT114");
        controlCardPage.verifyData("productInfo", "OUT114");
        controlCardPage.verifyData("containerInfo", "OUT114");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","14fragbc");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("14serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickButton("commitSN");
        controlCardPage.clickButton("commit");
    //Стол15
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT115");
        controlCardPage.verifyData("productInfo", "00015 Стол15");
        controlCardPage.verifyData("containerInfo", "OUT115");
        controlCardPage.verifyData("seriesInfo", "15series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2021");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","15fragbc");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("15series01"));
        inventoryCardPage.getAvailableSeries(2).click();
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("qty","10");
        controlCardPage.clickButton("commit");
    //Стол16
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT116");
        controlCardPage.verifyData("productInfo", "00016 Стол16");
        controlCardPage.verifyData("containerInfo", "OUT116");
        controlCardPage.verifyData("seriesInfo", "16series01");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","16fragbc");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("16series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("16series01"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00016 16series01 Стол16"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("16serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickButton("commitSN");
        controlCardPage.clickButton("commit");
    //Стол17
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT117");
        controlCardPage.verifyData("productInfo", "00017 Стол17");
        controlCardPage.verifyData("containerInfo", "OUT117");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2021");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","17fragbc");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00017 2021-12-31T00:00:00 Стол17")); //TODO BUG: incorrect expiration date
        controlCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("17serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickButton("commitSN");
        controlCardPage.clickButton("commit");
    //Стол18
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT118");
        controlCardPage.verifyData("productInfo", "00018 Стол18");
        controlCardPage.verifyData("containerInfo", "OUT118");
        controlCardPage.verifyData("seriesInfo", "");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2021");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","18fragbc");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("18series01"));
        inventoryCardPage.getAvailableExpirationDateZ22().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("18series01"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00018 18series01 2021-12-31T00:00:00 Стол18"));
        controlCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("18serialnumber01"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickButton("commitSN");
        controlCardPage.clickButton("commit");
    //Стол19
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT119");
        controlCardPage.verifyData("productInfo", "00019 Стол19");
        controlCardPage.verifyData("containerInfo", "OUT119");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","19fragbc");
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
        controlCardPage.clickButton("commitSN");
        controlCardPage.clickButton("commit");
    //Стол20
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT120");
        controlCardPage.verifyData("productInfo", "00020 Стол20");
        controlCardPage.verifyData("containerInfo", "OUT120");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","20fragbc");
        controlCardPage.inputData("qty","10");
        controlCardPage.clickButton("commit");

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
        controlCardPage.clickButton("commit");*/
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
