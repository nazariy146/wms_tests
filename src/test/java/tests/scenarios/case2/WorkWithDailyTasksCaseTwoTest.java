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
    RelocationCardPage relocationCardPage = new RelocationCardPage();
    RelocationTSDCardPage relocationTSDCardPage = new RelocationTSDCardPage();

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
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
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00012 12Series01 Стол12 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","12fragbc");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол13
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00013 31.12.2022 Стол13 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","13fragbc");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол14
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00014 Стол14 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","14fragbc");
        receptionCardPage.verifyData("productInfoSN","00014 Стол14");
        receptionCardPage.inputSN("normal","14", 10);
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол15
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00015 15series01 31.12.2022 Стол15 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","15fragbc");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол16
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00016 16series01 Стол16 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","16fragbc");
        receptionCardPage.inputSN("normal","16", 10);
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол17
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00017 31.12.2022 Стол17 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","17fragbc");
        receptionCardPage.inputSN("normal","17", 10);
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол18
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00018 18series01 31.12.2022 Стол18 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","18fragbc");
        receptionCardPage.inputSN("normal","18", 10);
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол19
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00019 Стол19 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","19fragbc");
        receptionCardPage.inputSN("unique","19", 10);
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол20
        receptionCardPage.inputData("source", "IN.01");
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
        allTasksPage.getWorkTypeTasksQuantity().click();
        accommodationCardPage.andrDriver("source");
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
        accommodationCardPage.verifyData("productInfo", "00013 31.12.2022 Стол13 IN.01 ➡ A.1.1.1.13 Quantity 10 шт");
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
        accommodationCardPage.verifyData("productInfo", "00015 15series01 31.12.2022 Стол15 IN.01 ➡ A.1.1.1.15 Quantity 10 шт");
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
        accommodationCardPage.verifyData("productInfo", "00017 31.12.2022 Стол17 IN.01 ➡ A.1.1.1.17 Quantity 10 шт");
        accommodationCardPage.inputData("product","17fragbc");
        accommodationCardPage.inputData("destination","A.1.1.1.17");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол18
        accommodationCardPage.verifyData("productInfo", "00018 18series01 31.12.2022 Стол18 IN.01 ➡ A.1.1.1.18 Quantity 10 шт");
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
        findRestsPage.andrDriver("product");
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
        findRestsPage.verifyData("seriesInfo", "12Series01");
    //Стол13
        findRestsPage.inputData("product", "13fragbc");
        findRestsPage.verifyData("productInfo", "00013 Стол13");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.13");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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
        findRestsPage.verifyData("seriesInfo", "15series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол16
        findRestsPage.inputData("product", "16fragbc");
        findRestsPage.verifyData("productInfo", "00016 Стол16");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.16");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "16series01");
    //Стол17
        findRestsPage.inputData("product", "17fragbc");
        findRestsPage.verifyData("productInfo", "00017 Стол17");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.17");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол18
        findRestsPage.inputData("product", "18fragbc");
        findRestsPage.verifyData("productInfo", "00018 Стол18");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.18");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "18series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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
        allTasksPage.getStringTasks(2).click();
        inventoryCardPage.andrDriver("product");
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
        inventoryCardPage.inputBatchProperties(true, false,"select","12Series01","");
        inventoryCardPage.verifyData("productInfo", "00012 12Series01 Стол12");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол13
        inventoryCardPage.inputData("source", "A.1.1.1.13");
        inventoryCardPage.inputData("product", "13fragbc");
        inventoryCardPage.inputBatchProperties(false, true, "select","","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "00013 31.12.2022 Стол13");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00013 31.12.2022 Стол13");
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
        inventoryCardPage.inputBatchProperties(true, true,"select","15series01","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "00015 15series01 31.12.2022 Стол15");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00015 15series01 31.12.2022 Стол15");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол16
        inventoryCardPage.inputData("source", "A.1.1.1.16");
        inventoryCardPage.inputData("product", "16fragbc");
        inventoryCardPage.inputBatchProperties(true, false,"select","16series01","");
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
        inventoryCardPage.inputBatchProperties(false, true, "select","","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "00017 31.12.2022 Стол17");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00017 31.12.2022 Стол17");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол18
        inventoryCardPage.inputData("source", "A.1.1.1.18");
        inventoryCardPage.inputData("product", "18fragbc");
        inventoryCardPage.inputBatchProperties(true, true,"select","18series01","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "00018 18series01 31.12.2022 Стол18");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00018 18series01 31.12.2022 Стол18");
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
        allTasksPage.selectFindRestsMenu();
        findRestsPage.andrDriver("product");
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
        findRestsPage.verifyData("seriesInfo", "12Series01");
    //Стол13
        findRestsPage.inputData("product", "13fragbc");
        findRestsPage.verifyData("productInfo", "00013 Стол13");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.13");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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
        findRestsPage.verifyData("seriesInfo", "15series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол16
        findRestsPage.inputData("product", "16fragbc");
        findRestsPage.verifyData("productInfo", "00016 Стол16");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.16");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "16series01");
    //Стол17
        findRestsPage.inputData("product", "17fragbc");
        findRestsPage.verifyData("productInfo", "00017 Стол17");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.17");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол18
        findRestsPage.inputData("product", "18fragbc");
        findRestsPage.verifyData("productInfo", "00018 Стол18");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.18");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "18series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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

    @Test (priority = 5, dependsOnMethods = "processingInventoryTaskTest")
    public void processingRelocationTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Moving");
        allTasksPage.getWorkTypeTasksQuantity().click();
        relocationCardPage.andrDriver("source");
    //Стол11
        relocationCardPage.verifyData("productInfo", "00011 Стол11 A.1.1.1.11 ➡ A.1.1.2.11 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.11");
        relocationCardPage.inputData("product", "11fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.11");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол12
        relocationCardPage.verifyData("productInfo", "00012 12Series01 Стол12 A.1.1.1.12 ➡ A.1.1.2.12 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.12");
        relocationCardPage.inputData("product", "12fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.12");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол13
        relocationCardPage.verifyData("productInfo", "00013 31.12.2022 Стол13 A.1.1.1.13 ➡ A.1.1.2.13 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.13");
        relocationCardPage.inputData("product", "13fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.13");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол14
        relocationCardPage.verifyData("productInfo", "00014 Стол14 A.1.1.1.14 ➡ A.1.1.2.14 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.14");
        relocationCardPage.inputData("product", "14fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.14");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол15
        relocationCardPage.verifyData("productInfo", "00015 15series01 31.12.2022 Стол15 A.1.1.1.15 ➡ A.1.1.2.15 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.15");
        relocationCardPage.inputData("product", "15fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.15");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол16
        relocationCardPage.verifyData("productInfo", "00016 16series01 Стол16 A.1.1.1.16 ➡ A.1.1.2.16 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.16");
        relocationCardPage.inputData("product", "16fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.16");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол17
        relocationCardPage.verifyData("productInfo", "00017 31.12.2022 Стол17 A.1.1.1.17 ➡ A.1.1.2.17 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.17");
        relocationCardPage.inputData("product", "17fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.17");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол18
        relocationCardPage.verifyData("productInfo", "00018 18series01 31.12.2022 Стол18 A.1.1.1.18 ➡ A.1.1.2.18 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.18");
        relocationCardPage.inputData("product", "18fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.18");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол19
        relocationCardPage.verifyData("productInfo", "00019 Стол19 A.1.1.1.19 ➡ A.1.1.2.19 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.19");
        relocationCardPage.inputData("product", "19fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.19");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол20
        relocationCardPage.verifyData("productInfo", "00020 Стол20 A.1.1.1.20 ➡ A.1.1.2.20 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.20");
        relocationCardPage.inputData("product", "20fragbc");
        relocationCardPage.inputData("destination", "A.1.1.2.20");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingRelocationTaskTest")
    public void processingRelocationTSDTaskTest() throws Exception {
        steps.loginAsAdmin();
        relocationTSDCardPage.andrDriver("rightMenu");
        relocationTSDCardPage.clickButton("rightMenu");
        relocationTSDCardPage.clickButton("relocation");
    //Стол11
        relocationTSDCardPage.inputData("source", "A.1.1.2.11");
        relocationTSDCardPage.inputData("product", "11fragbc");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.11 ➡ 00011 Стол11");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.11 ➡ 00011 Стол11 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.11");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.11 ➡ A.1.1.3.11 00011 Стол11 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол12
        relocationTSDCardPage.inputData("source", "A.1.1.2.12");
        relocationTSDCardPage.inputData("product", "12fragbc");
        relocationTSDCardPage.inputBatchProperties(true, false,"select","12series01","");
        relocationTSDCardPage.clickButton("modalDialogOK");
//        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.12 ➡ 00012 12Series01 Стол12");
        relocationTSDCardPage.inputData("qty", "10");
//        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.12 ➡ 00012 12Series01 Стол12 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.12");
//        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.12 ➡ A.1.1.3.12 00012 12Series01 Стол12 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол13
        relocationTSDCardPage.inputData("source", "A.1.1.2.13");
        relocationTSDCardPage.inputData("product", "13fragbc");
        relocationTSDCardPage.inputBatchProperties(false, true,"select", "","31.12.2022");
//        relocationTSDCardPage.verifyData("modalDialogTitle", "Batch properties");
//        relocationTSDCardPage.selectData("shelfLife", "31.12.2022");
//        relocationTSDCardPage.clickButton("modalDialogOK");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.13 ➡ 00013 31.12.2022 Стол13");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.13 ➡ 00013 31.12.2022 Стол13 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.13");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.13 ➡ A.1.1.3.13 00013 31.12.2022 Стол13 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол14
        relocationTSDCardPage.inputData("source", "A.1.1.2.14");
        relocationTSDCardPage.inputData("product", "14fragbc");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.14 ➡ 00014 Стол14");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.14 ➡ 00014 Стол14 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.14");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.14 ➡ A.1.1.3.14 00014 Стол14 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол15
        relocationTSDCardPage.inputData("source", "A.1.1.2.15");
        relocationTSDCardPage.inputData("product", "15fragbc");
        relocationTSDCardPage.inputBatchProperties(true, false,"select","15Series01","");
        relocationTSDCardPage.verifyData("modalDialogTitle", "Batch properties");
        relocationTSDCardPage.selectData("series", "15Series01");
        relocationTSDCardPage.clickButton("modalDialogOK");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.15 ➡ 00015 15Series01 31.12.2022 Стол15");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.15 ➡ 00015 15Series01 31.12.2022 Стол15 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.15");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.15 ➡ A.1.1.3.15 00015 15Series01 31.12.2022 Стол15 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол16
        relocationTSDCardPage.inputData("source", "A.1.1.2.16");
        relocationTSDCardPage.inputData("product", "16fragbc");
        relocationTSDCardPage.inputBatchProperties(true, false,"select","16series01","");
//        relocationTSDCardPage.verifyData("modalDialogTitle", "Batch properties");
//        relocationTSDCardPage.selectData("series", "16series01");
//        relocationTSDCardPage.clickButton("modalDialogOK");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.16 ➡ 00016 16series01 Стол16");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.16 ➡ 00016 16series01 Стол16 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.16");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.16 ➡ A.1.1.3.16 00016 16series01 Стол16 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол17
        relocationTSDCardPage.inputData("source", "A.1.1.2.17");
        relocationTSDCardPage.inputData("product", "17fragbc");
        relocationTSDCardPage.inputBatchProperties(false, true,"select", "","31.12.2022");
//        relocationTSDCardPage.verifyData("modalDialogTitle", "Batch properties");
//        relocationTSDCardPage.selectData("shelfLife", "31.12.2022");
//        relocationTSDCardPage.clickButton("modalDialogOK");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.17 ➡ 00017 31.12.2022 Стол17");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.17 ➡ 00017 31.12.2022 Стол17 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.17");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.17 ➡ A.1.1.3.17 00017 31.12.2022 Стол17 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол18
        relocationTSDCardPage.inputData("source", "A.1.1.2.18");
        relocationTSDCardPage.inputData("product", "18fragbc");
        relocationTSDCardPage.inputBatchProperties(true, false,"select","18series01","");
//        relocationTSDCardPage.verifyData("modalDialogTitle", "Batch properties");
//        relocationTSDCardPage.selectData("series", "18series01");
//        relocationTSDCardPage.clickButton("modalDialogOK");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.18 ➡ 00018 18series01 31.12.2022 Стол18");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.18 ➡ 00018 18series01 31.12.2022 Стол18 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.18");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.18 ➡ A.1.1.3.18 00018 18series01 31.12.2022 Стол18 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол19
        relocationTSDCardPage.inputData("source", "A.1.1.2.19");
        relocationTSDCardPage.inputData("product", "19fragbc");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.19 ➡ 00019 Стол19");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.19 ➡ 00019 Стол19 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.19");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.19 ➡ A.1.1.3.19 00019 Стол19 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол20
        relocationTSDCardPage.inputData("source", "A.1.1.2.20");
        relocationTSDCardPage.inputData("product", "20fragbc");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.20 ➡ 00020 Стол20");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.20 ➡ 00020 Стол20 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.20");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.20 ➡ A.1.1.3.20 00020 Стол20 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    }

    @Test (priority = 7, dependsOnMethods = "processingRelocationTSDTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();
        selectionCardPage.andrDriver("source");
    //Стол11
        selectionCardPage.verifyData("productInfo", "00011 Стол11 A.1.1.3.11 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.11");
        selectionCardPage.inputData("product", "11fragbc");
        selectionCardPage.inputData("destination", "OUT111");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол12
        selectionCardPage.verifyData("productInfo", "00012 12Series01 Стол12 A.1.1.3.12 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.12");
        selectionCardPage.inputData("product", "12fragbc");
        selectionCardPage.inputData("destination", "OUT112");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол13
        selectionCardPage.verifyData("productInfo", "00013 31.12.2022 Стол13 A.1.1.3.13 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.13");
        selectionCardPage.inputData("product", "13fragbc");
        selectionCardPage.inputData("destination", "OUT113");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол14
        selectionCardPage.verifyData("productInfo", "00014 Стол14 A.1.1.3.14 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.14");
        selectionCardPage.inputData("product", "14fragbc");
        selectionCardPage.inputSN("normal","14serialnumber01", 10);
        selectionCardPage.inputData("destination", "OUT114");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол15
        selectionCardPage.verifyData("productInfo", "00015 15series01 31.12.2022 Стол15 A.1.1.3.15 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.15");
        selectionCardPage.inputData("product", "15fragbc");
        selectionCardPage.inputData("destination", "OUT115");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол16
        selectionCardPage.verifyData("productInfo", "00016 16series01 Стол16 A.1.1.3.16 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.16");
        selectionCardPage.inputData("product", "16fragbc");
        selectionCardPage.inputSN("normal","16serialnumber01", 10);
        selectionCardPage.inputData("destination", "OUT116");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол17
        selectionCardPage.verifyData("productInfo", "00017 31.12.2022 Стол17 A.1.1.3.17 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.17");
        selectionCardPage.inputData("product", "17fragbc");
        selectionCardPage.inputSN("normal","17serialnumber01", 10);
        selectionCardPage.inputData("destination", "OUT117");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол18
        selectionCardPage.verifyData("productInfo", "00018 18series01 31.12.2022 Стол18 A.1.1.3.18 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.18");
        selectionCardPage.inputData("product", "18fragbc");
        selectionCardPage.inputSN("normal","18serialnumber01", 10);
        selectionCardPage.inputData("destination", "OUT118");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол19
        selectionCardPage.verifyData("productInfo", "00019 Стол19 A.1.1.3.19 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.19");
        selectionCardPage.inputData("product", "19fragbc");
        selectionCardPage.inputSN("unique","19serialnumber0", 10);
        selectionCardPage.inputData("destination", "OUT119");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол20
        selectionCardPage.verifyData("productInfo", "00020 Стол20 A.1.1.3.20 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.20");
        selectionCardPage.inputData("product", "20fragbc");
        selectionCardPage.inputData("destination", "OUT120");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 8, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();
        containerCardPage.andrDriver("containerInfo");
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
        containerCardPage.clickButton("commit");
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

    @Test (priority = 9, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();
        controlCardPage.andrDriver("source");
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
        controlCardPage.inputBatchProperties(true, false,"select","12Series01","");
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
        controlCardPage.inputBatchProperties(false, true, "select","","31.12.2022");
        controlCardPage.inputData("qty","10");
        controlCardPage.clickButton("commit");
    //Стол14
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT114");
        controlCardPage.verifyData("productInfo", "00014 Стол14");
        controlCardPage.verifyData("containerInfo", "OUT114");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","14fragbc");
        controlCardPage.inputSN("normal","14", 10);
        controlCardPage.clickButton("commit");
    //Стол15
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT115");
        controlCardPage.verifyData("productInfo", "00015 Стол15");
        controlCardPage.verifyData("containerInfo", "OUT115");
        controlCardPage.verifyData("seriesInfo", "15series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","15fragbc");
        controlCardPage.inputBatchProperties(true, false,"select","15series01","");
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
        controlCardPage.inputBatchProperties(true, false,"select","16series01","");
        controlCardPage.inputSN("normal","16", 10);
        controlCardPage.clickButton("commit");
    //Стол17
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT117");
        controlCardPage.verifyData("productInfo", "00017 Стол17");
        controlCardPage.verifyData("containerInfo", "OUT117");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","17fragbc");
        controlCardPage.inputBatchProperties(false, true, "select","","31.12.2022");
        controlCardPage.inputSN("normal","17", 10);
        controlCardPage.clickButton("commit");
    //Стол18
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT118");
        controlCardPage.verifyData("productInfo", "00018 Стол18");
        controlCardPage.verifyData("containerInfo", "OUT118");
        controlCardPage.verifyData("seriesInfo", "18series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","18fragbc");
        controlCardPage.inputBatchProperties(true, true,"select","18series01","31.12.2022");
        controlCardPage.inputSN("normal","18", 10);
        controlCardPage.clickButton("commit");
    //Стол19
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT119");
        controlCardPage.verifyData("productInfo", "00019 Стол19");
        controlCardPage.verifyData("containerInfo", "OUT119");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","19fragbc");
        controlCardPage.inputSN("unique","19serialnumber0", 10);
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
    }

    @Test (priority = 10, dependsOnMethods = "processingControlTaskTest")
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

    @Test (priority = 11, dependsOnMethods = "processingPackagingTaskTest")
    public void processingConsolidateContainerTask() {
        steps.loginAsAdmin();
        allTasksPage.selectConsolidateContainerMenu();
        consolidateContainerPage.setSeveralConsolidateContainer(true);
        consolidateContainerPage.setContainerSeveralTimes("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
//        consolidateContainerPage.checkAllProductsInfoAndQty(1, "9990000000012", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(2, "9990000000029", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(3, "9990000000036", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(4, "9990000000043", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(5, "9990000000050", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(6, "9990000000067", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(7, "9990000000074", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(8, "9990000000081", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(9, "9990000000098", "Костенко (count 10/countprod. 1) -->");
//        consolidateContainerPage.checkAllProductsInfoAndQty(10, "9990000000104", "Костенко (count 10/countprod. 1) -->");
        consolidateContainerPage.setCreateConsolidateContainer(true);
        consolidateContainerPage.getReceiverInput().shouldBe(disabled);
        consolidateContainerPage.clickConsolidateButton();
    }

    @Test (priority = 12, dependsOnMethods = "processingConsolidateContainerTask")
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
