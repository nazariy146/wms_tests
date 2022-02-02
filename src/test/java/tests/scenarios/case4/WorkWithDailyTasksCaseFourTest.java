package tests.scenarios.case4;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
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
    RelocationCardPage relocationCardPage = new RelocationCardPage();
    RelocationTSDCardPage relocationTSDCardPage = new RelocationTSDCardPage();

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        receptionCardPage.verifyData("productInfo", "00031 Стол31 IN.01 Quantity 10 уп. (5)");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","31FRAGSN31Series013112202200");
        receptionCardPage.inputSN("sn","31", 10);
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол32
        receptionCardPage.verifyData("productInfo", "00032 Стол32 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","32FRAGSN32Series013112202200");
        receptionCardPage.verifyData("productInfoSN", "00032 32Series01 Стол32");
        receptionCardPage.inputSN("sn","32", 10);
        receptionCardPage.verifyData("productInfo", "00032 32series01 Стол32 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол33
        receptionCardPage.verifyData("productInfo", "00033 Стол33 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","33FRAGSN33Series013112202200");
        receptionCardPage.verifyData("productInfoSN", "00033 31.12.2022 Стол33");
        receptionCardPage.inputSN("sn","33", 10);
        receptionCardPage.verifyData("productInfo", "00033 31.12.2022 Стол33 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол34
        receptionCardPage.verifyData("productInfo", "00034 Стол34 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","34FRAGSN34Series013112202200");
        receptionCardPage.inputSN("sn","34", 10);
        receptionCardPage.verifyData("productInfo", "00034 34series01 31.12.2022 Стол34 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол35
        receptionCardPage.verifyData("productInfo", "00035 Стол35 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","35FRAGBC35Series013112202200");
        receptionCardPage.verifyData("productInfo", "00035 Стол35 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол36
        receptionCardPage.verifyData("productInfo", "00036 Стол36 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","36FRAGBC36Series013112202200");
        receptionCardPage.verifyData("productInfo", "00036 36series01 Стол36 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол37
        receptionCardPage.verifyData("productInfo", "00037 Стол37 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","37FRAGBC37Series013112202200");
        receptionCardPage.verifyData("productInfo", "00037 31.12.2022 Стол37 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол38
        receptionCardPage.verifyData("productInfo", "00038 Стол38 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","38FRAGBC38Series013112202200");
        receptionCardPage.verifyData("productInfo", "00038 38series01 31.12.2022 Стол38 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол39
        receptionCardPage.verifyData("productInfo", "00039 Стол39 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","39FRAGSN39Series013112202200");
        receptionCardPage.verifyData("productInfoSN", "00039 39Series01 31.12.2022 Стол39");
        receptionCardPage.inputSN("uniqueSn","39", 9);
        receptionCardPage.verifyData("productInfo", "00039 39series01 31.12.2022 Стол39 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол40
        receptionCardPage.verifyData("productInfo", "00040 Стол40 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        receptionCardPage.verifyData("productInfoSN", "00040 40Series01 31.12.2022 Стол40");
        receptionCardPage.inputSN("qr","40", 7);
        receptionCardPage.verifyData("productInfo", "00040 40series01 31.12.2022 Стол40 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception{
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        accommodationCardPage.verifyData("productInfo", "00031 Стол31 IN.01 ➡ C.1.1.1.1 Quantity 10 уп. (5)");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","31FRAGSN31Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.1");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол32
        accommodationCardPage.verifyData("productInfo", "00032 32series01 Стол32 IN.01 ➡ C.1.1.1.2 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","32FRAGSN32Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.2");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол33
        accommodationCardPage.verifyData("productInfo", "00033 31.12.2022 Стол33 IN.01 ➡ C.1.1.1.3 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","33FRAGSN33Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.3");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол34
        accommodationCardPage.verifyData("productInfo", "00034 34series01 31.12.2022 Стол34 IN.01 ➡ C.1.1.1.4 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","34FRAGSN34Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.4");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол35
        accommodationCardPage.verifyData("productInfo", "00035 Стол35 IN.01 ➡ C.1.1.1.5 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","35FRAGBC35Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.5");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол36
        accommodationCardPage.verifyData("productInfo", "00036 36series01 Стол36 IN.01 ➡ C.1.1.1.6 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","36FRAGBC36Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.6");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол37
        accommodationCardPage.verifyData("productInfo", "00037 31.12.2022 Стол37 IN.01 ➡ C.1.1.1.7 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","37FRAGBC37Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.7");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол38
        accommodationCardPage.verifyData("productInfo", "00038 38series01 31.12.2022 Стол38 IN.01 ➡ C.1.1.1.8 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","38FRAGBC38Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.8");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол39
        accommodationCardPage.verifyData("productInfo", "00039 39series01 31.12.2022 Стол39 IN.01 ➡ C.1.1.1.9 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","39FRAGSN39Series013112202200");
        accommodationCardPage.inputData("destination","C.1.1.1.9");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол40
        accommodationCardPage.verifyData("productInfo", "00040 40series01 31.12.2022 Стол40 IN.01 ➡ C.1.1.1.10 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        //accommodationCardPage.inputData("product","40FRAGSN40Series013112202200");
        accommodationCardPage.inputData("product","40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");//MNV лучше сканировать QR
        accommodationCardPage.inputData("destination","C.1.1.1.10");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
    //Стол31
        findRestsPage.inputData("product", "31FRAGSN31Series013112202200");
        findRestsPage.verifyData("productInfo", "00031 Стол31");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.1");
        findRestsPage.verifyData("qty", "10");
    //Стол32
        findRestsPage.inputData("product", "32FRAGSN32Series013112202200");
        findRestsPage.verifyData("productInfo", "00032 Стол32");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.2");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "32Series01");
    //Стол33
        findRestsPage.inputData("product", "33FRAGSN33Series013112202200");
        findRestsPage.verifyData("productInfo", "00033 Стол33");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.3");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол34
        findRestsPage.inputData("product", "34FRAGSN34Series013112202200");
        findRestsPage.verifyData("productInfo", "00034 Стол34");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.4");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "34Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол35
        findRestsPage.inputData("product", "35FRAGBC35Series013112202200");
        findRestsPage.verifyData("productInfo", "00035 Стол35");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.5");
        findRestsPage.verifyData("qty", "10");
    //Стол36
        findRestsPage.inputData("product", "36FRAGBC36Series013112202200");
        findRestsPage.verifyData("productInfo", "00036 Стол36");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "36Series01");
    //Стол37
        findRestsPage.inputData("product", "37FRAGBC37Series013112202200");
        findRestsPage.verifyData("productInfo", "00037 Стол37");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол38
        findRestsPage.inputData("product", "38FRAGBC38Series013112202200");
        findRestsPage.verifyData("productInfo", "00038 Стол38");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "38Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол39
        findRestsPage.inputData("product", "39FRAGSN39Series013112202200");
        findRestsPage.verifyData("productInfo", "00039 Стол39");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.9");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "39Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол40
        findRestsPage.inputData("product", "40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        findRestsPage.verifyData("productInfo", "00040 Стол40");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.10");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "40Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.getStringTasks(2).click();
    //Стол 31
        inventoryCardPage.inputData("source", "C.1.1.1.1");
        inventoryCardPage.inputData("product", "31FRAGSN31Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00031 Стол31"); MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00031 31Series01 2022-12-31T00:00:00 Стол31"); //MNV TODO bag серия и СГ не должны быть в описании по номенклатуре не ведется учет
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 32
        inventoryCardPage.inputData("source", "C.1.1.1.2");
        inventoryCardPage.inputData("product", "32FRAGSN32Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00032 32Series01 Стол32"); MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00032 32Series01 2022-12-31T00:00:00 Стол32"); //MNV TODO bag СГ не должен быть в описании по номенклатуре не ведется учет
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 33
        inventoryCardPage.inputData("source", "C.1.1.1.3");
        inventoryCardPage.inputData("product", "33FRAGSN33Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00033 2022-12-31T00:00:00 Стол33"); MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00033 33Series01 2022-12-31T00:00:00 Стол33");//MNV TODO bag Серия не должена быть в описании по номенклатуре не ведется учет
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 34
        inventoryCardPage.inputData("source", "C.1.1.1.4");
        inventoryCardPage.inputData("product", "34FRAGSN34Series013112202200");
        inventoryCardPage.verifyData("productInfo", "00034 34Series01 2022-12-31T00:00:00 Стол34");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 35
        inventoryCardPage.inputData("source", "C.1.1.1.5");
        inventoryCardPage.inputData("product", "35FRAGBC35Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00035 Стол35");MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00035 35Series01 2022-12-31T00:00:00 Стол35");//MNV TODO bag Серия и СГ не должена быть в описании по номенклатуре не ведется учет
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 36
        inventoryCardPage.inputData("source", "C.1.1.1.6");
        inventoryCardPage.inputData("product", "36FRAGBC36Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00036 36Series01 Стол36"); MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00036 36Series01 2022-12-31T00:00:00 Стол36"); //MNV TODO bag Серия и СГ не должена быть в описании по номенклатуре не ведется учет
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 37
        inventoryCardPage.inputData("source", "C.1.1.1.7");
        inventoryCardPage.inputData("product", "37FRAGBC37Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00037 2022-12-31T00:00:00 Стол37"); MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00037 37Series01 2022-12-31T00:00:00 Стол37"); //MNV TODO bag Серия не должена быть в описании по номенклатуре не ведется учет
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 38
        inventoryCardPage.inputData("source", "C.1.1.1.8");
        inventoryCardPage.inputData("product", "38FRAGBC38Series013112202200");
        inventoryCardPage.verifyData("productInfo", "00038 38Series01 2022-12-31T00:00:00 Стол38");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 39
        inventoryCardPage.inputData("source", "C.1.1.1.9");
        inventoryCardPage.inputData("product", "39FRAGSN39Series01311220220001");
        inventoryCardPage.verifyData("productInfo", "00039 39Series01 2022-12-31T00:00:00 Стол39");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол 40
        inventoryCardPage.inputData("source", "C.1.1.1.10");
        inventoryCardPage.inputData("product", "40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        inventoryCardPage.verifyData("productInfo", "00040 40Series01 2022-12-31T00:00:00 Стол40");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    }

    @Test (priority = 4, dependsOnMethods = "processingInventoryTaskTest")
    public void checkingFreeAmountTest2() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
    //Стол31
        findRestsPage.inputData("product", "31FRAGSN31Series013112202200");
        findRestsPage.verifyData("productInfo", "00031 Стол31");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.1");
        findRestsPage.verifyData("qty", "10");
    //Стол32
        findRestsPage.inputData("product", "32FRAGSN32Series013112202200");
        findRestsPage.verifyData("productInfo", "00032 Стол32");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.2");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "32Series01");
    //Стол33
        findRestsPage.inputData("product", "33FRAGSN33Series013112202200");
        findRestsPage.verifyData("productInfo", "00033 Стол33");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.3");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол34
        findRestsPage.inputData("product", "34FRAGSN34Series013112202200");
        findRestsPage.verifyData("productInfo", "00034 Стол34");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.4");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "34Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол35
        findRestsPage.inputData("product", "35FRAGBC35Series013112202200");
        findRestsPage.verifyData("productInfo", "00035 Стол35");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.5");
        findRestsPage.verifyData("qty", "10");
    //Стол36
        findRestsPage.inputData("product", "36FRAGBC36Series013112202200");
        findRestsPage.verifyData("productInfo", "00036 Стол36");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "36Series01");
    //Стол37
        findRestsPage.inputData("product", "37FRAGBC37Series013112202200");
        findRestsPage.verifyData("productInfo", "00037 Стол37");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол38
        findRestsPage.inputData("product", "38FRAGBC38Series013112202200");
        findRestsPage.verifyData("productInfo", "00038 Стол38");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "38Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол39
        findRestsPage.inputData("product", "39FRAGSN39Series013112202200");
        findRestsPage.verifyData("productInfo", "00039 Стол39");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.9");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "39Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол40
        findRestsPage.inputData("product", "40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        findRestsPage.verifyData("productInfo", "00040 Стол40");
        findRestsPage.verifyData("sourceInfo", "C.1.1.1.10");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "40Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    }

    @Test (priority = 5, dependsOnMethods = "processingInventoryTaskTest")
    public void processingRelocationTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Moving");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        relocationCardPage.verifyData("productInfo", "00031 Стол31 C.1.1.1.1 ➡ C.1.1.2.1 Quantity 10 уп. (5)");
        relocationCardPage.inputData("source", "C.1.1.1.1");
        relocationCardPage.inputData("product", "31FRAGSN31Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.1");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол32
        relocationCardPage.verifyData("productInfo", "00032 32Series01 Стол32 C.1.1.1.2 ➡ C.1.1.2.2 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.2");
        relocationCardPage.inputData("product", "32FRAGSN32Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.2");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол33
        relocationCardPage.verifyData("productInfo", "00033 31.12.2022 Стол33 C.1.1.1.3 ➡ C.1.1.2.3 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.3");
        relocationCardPage.inputData("product", "33FRAGSN33Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.3");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол34
        relocationCardPage.verifyData("productInfo", "00034 34Series01 31.12.2022 Стол34 C.1.1.1.4 ➡ C.1.1.2.4 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.4");
        relocationCardPage.inputData("product", "34FRAGSN34Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.4");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол35
        relocationCardPage.verifyData("productInfo", "00035 Стол35 C.1.1.1.5 ➡ C.1.1.2.5 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.5");
        relocationCardPage.inputData("product", "35FRAGBC35Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.5");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол36
        relocationCardPage.verifyData("productInfo", "00036 36Series01 Стол36 C.1.1.1.6 ➡ C.1.1.2.6 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.6");
        relocationCardPage.inputData("product", "36FRAGBC36Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.6");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол37
        relocationCardPage.verifyData("productInfo", "00037 31.12.2022 Стол37 C.1.1.1.7 ➡ C.1.1.2.7 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.7");
        relocationCardPage.inputData("product", "37FRAGBC37Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.7");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол38
        relocationCardPage.verifyData("productInfo", "00038 38Series01 31.12.2022 Стол38 C.1.1.1.8 ➡ C.1.1.2.8 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.8");
        relocationCardPage.inputData("product", "38FRAGBC38Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.8");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол39
        relocationCardPage.verifyData("productInfo", "00039 39Series01 31.12.2022 Стол39 C.1.1.1.9 ➡ C.1.1.2.9 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.9");
        relocationCardPage.inputData("product", "39FRAGSN39Series013112202200");
        relocationCardPage.inputData("destination", "C.1.1.2.9");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол40
        relocationCardPage.verifyData("productInfo", "00040 40Series01 31.12.2022 Стол40 C.1.1.1.10 ➡ C.1.1.2.10 Quantity 10 шт");
        relocationCardPage.inputData("source", "C.1.1.1.10");
        relocationCardPage.inputData("product", "40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        relocationCardPage.inputData("destination", "C.1.1.2.10");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingRelocationTaskTest")
    public void processingRelocationTSDTaskTest() throws Exception {
        steps.loginAsAdmin();
        relocationTSDCardPage.clickButton("rightMenu");
        relocationTSDCardPage.clickButton("relocation");
    //Стол31
        relocationTSDCardPage.inputData("source", "C.1.1.2.1");
        relocationTSDCardPage.inputData("product", "31FRAGSN31Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.1 ➡ 00031 Стол31");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.1 ➡ 00031 Стол31 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.1");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.1 ➡ C.1.1.3.1 00031 Стол31 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол32
        relocationTSDCardPage.inputData("source", "C.1.1.2.2");
        relocationTSDCardPage.inputData("product", "32FRAGSN32Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.2 ➡ 00032 32Series01 Стол32");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.2 ➡ 00032 32Series01 Стол32 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.2");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.2 ➡ C.1.1.3.2 00032 32Series01 Стол32 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол33
        relocationTSDCardPage.inputData("source", "C.1.1.2.3");
        relocationTSDCardPage.inputData("product", "33FRAGSN33Series01311220220003");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.3 ➡ 00033 2022-12-31T00:00:00 Стол33");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.3 ➡ 00033 2022-12-31T00:00:00 Стол33 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.3");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.3 ➡ C.1.1.3.3 00033 2022-12-31T00:00:00 Стол33 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол34
        relocationTSDCardPage.inputData("source", "C.1.1.2.4");
        relocationTSDCardPage.inputData("product", "34FRAGSN34Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.4 ➡ 00034 34Series01 2022-12-31T00:00:00 Стол34");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.4 ➡ 00034 34Series01 2022-12-31T00:00:00 Стол34 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.4");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.4 ➡ C.1.1.3.4 00034 34Series01 2022-12-31T00:00:00 Стол34 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол35
        relocationTSDCardPage.inputData("source", "C.1.1.2.5");
        relocationTSDCardPage.inputData("product", "35FRAGBC35Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.5 ➡ 00035 Стол35");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.5 ➡ 00035 Стол35 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.5");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.5 ➡ C.1.1.3.5 00035 Стол35 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол36
        relocationTSDCardPage.inputData("source", "C.1.1.2.6");
        relocationTSDCardPage.inputData("product", "36FRAGBC36Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.6 ➡ 00036 36Series01 Стол36");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.6 ➡ 00036 36Series01 Стол36 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.6");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.6 ➡ C.1.1.3.6 00036 36Series01 Стол36 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол37
        relocationTSDCardPage.inputData("source", "C.1.1.2.7");
        relocationTSDCardPage.inputData("product", "37FRAGBC37Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.7 ➡ 00037 2022-12-31T00:00:00 Стол37");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.7 ➡ 00037 2022-12-31T00:00:00 Стол37 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.7");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.7 ➡ C.1.1.3.7 00037 2022-12-31T00:00:00 Стол37 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол38
        relocationTSDCardPage.inputData("source", "C.1.1.2.8");
        relocationTSDCardPage.inputData("product", "38FRAGBC38Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.8 ➡ 00038 38Series01 2022-12-31T00:00:00 Стол38");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.8 ➡ 00038 38Series01 2022-12-31T00:00:00 Стол38 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.8");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.8 ➡ C.1.1.3.8 00038 38Series01 2022-12-31T00:00:00 Стол38 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол39
        relocationTSDCardPage.inputData("source", "C.1.1.2.9");
        relocationTSDCardPage.inputData("product", "39FRAGSN39Series013112202200");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.9 ➡ 00039 39Series01 2022-12-31T00:00:00 Стол39");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.9 ➡ 00039 39Series01 2022-12-31T00:00:00 Стол39 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.9");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.9 ➡ C.1.1.3.9 00039 39Series01 2022-12-31T00:00:00 Стол39 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол40
        relocationTSDCardPage.inputData("source", "C.1.1.2.10");
        relocationTSDCardPage.inputData("product", "40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.10 ➡ 00040 40Series01 2022-12-31T00:00:00 Стол40");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.10 ➡ 00040 40Series01 2022-12-31T00:00:00 Стол40 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.3.10");
        relocationTSDCardPage.verifyData("productInfo", "C.1.1.2.10 ➡ C.1.1.3.10 00040 40Series01 2022-12-31T00:00:00 Стол40 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    }

    @Test (priority = 7, dependsOnMethods = "processingRelocationTSDTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        selectionCardPage.verifyData("productInfo", "00031 Стол31 C.1.1.3.1 ➡ KT1.01.01.01.01 Quantity 10 уп. (5)");
        selectionCardPage.inputData("source", "C.1.1.3.1");
        selectionCardPage.inputData("product", "31FRAGSN31Series013112202200");
        selectionCardPage.inputSN("sn","31", 10);
        selectionCardPage.inputData("destination", "OUT131");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол32
        selectionCardPage.verifyData("productInfo", "00032 32series01 Стол32 C.1.1.3.2 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.2");
        selectionCardPage.inputData("product", "32FRAGSN32Series013112202200");
        selectionCardPage.inputSN("sn","32", 10);
        selectionCardPage.inputData("destination", "OUT132");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол33
        selectionCardPage.verifyData("productInfo", "00033 31.12.2022 Стол33 C.1.1.3.3 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.3");
        selectionCardPage.inputData("product", "33FRAGSN33Series013112202200");
        selectionCardPage.inputSN("sn","33", 10);
        selectionCardPage.inputData("destination", "OUT133");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол34
        selectionCardPage.verifyData("productInfo", "00034 34series01 31.12.2022 Стол34 C.1.1.3.4 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.4");
        selectionCardPage.inputData("product", "34FRAGSN34Series013112202200");
        selectionCardPage.inputSN("sn","34", 10);
        selectionCardPage.inputData("destination", "OUT134");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол35
        selectionCardPage.verifyData("productInfo", "00035 Стол35 C.1.1.3.5 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.5");
        selectionCardPage.inputData("product", "35FRAGBC35Series013112202200");
        selectionCardPage.inputData("destination", "OUT135");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол36
        selectionCardPage.verifyData("productInfo", "00036 36series01 Стол36 C.1.1.3.6 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.6");
        selectionCardPage.inputData("product", "36FRAGBC36Series013112202200");
        selectionCardPage.inputData("destination", "OUT136");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол37
        selectionCardPage.verifyData("productInfo", "00037 31.12.2022 Стол37 C.1.1.3.7 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.7");
        selectionCardPage.inputData("product", "37FRAGBC37Series013112202200");
        selectionCardPage.inputData("destination", "OUT137");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол38
        selectionCardPage.verifyData("productInfo", "00038 38series01 31.12.2022 Стол38 C.1.1.3.8 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.8");
        selectionCardPage.inputData("product", "38FRAGBC38Series013112202200");
        selectionCardPage.inputData("destination", "OUT138");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол39
        selectionCardPage.verifyData("productInfo", "00039 39series01 31.12.2022 Стол39 C.1.1.3.9 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.9");
        selectionCardPage.inputData("product", "39FRAGSN39Series013112202200");
        selectionCardPage.inputSN("uniqueSn","39", 9);
        selectionCardPage.inputData("destination", "OUT139");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол40
        selectionCardPage.verifyData("productInfo", "00040 40Series01 31.12.2022 Стол40 C.1.1.3.10 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.3.10");
        selectionCardPage.inputData("product", "40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        selectionCardPage.inputSN("qr","40", 7);
        selectionCardPage.inputData("destination", "OUT140");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 8, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Контейнер (Selection)");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        containerCardPage.verifyData("containerInfo", "CON/OUT131 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT131");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол32
        containerCardPage.verifyData("containerInfo", "CON/OUT132 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT132");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол33
        containerCardPage.verifyData("containerInfo", "CON/OUT133 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT133");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол34
        containerCardPage.verifyData("containerInfo", "CON/OUT134 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT134");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол35
        containerCardPage.verifyData("containerInfo", "CON/OUT135 ➡ KT1.01.01.01.01 ");
        containerCardPage.inputData("container", "OUT135");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол36
        containerCardPage.verifyData("containerInfo", "CON/OUT136 ➡ KT1.01.01.01.01 ");
        containerCardPage.inputData("container", "OUT136");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол37
        containerCardPage.verifyData("containerInfo", "CON/OUT137 ➡ KT1.01.01.01.01 ");
        containerCardPage.inputData("container", "OUT137");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол38
        containerCardPage.verifyData("containerInfo", "CON/OUT138 ➡ KT1.01.01.01.01 ");
        containerCardPage.inputData("container", "OUT138");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол39
        containerCardPage.verifyData("containerInfo", "CON/OUT139 ➡ KT1.01.01.01.01 ");
        containerCardPage.inputData("container", "OUT139");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол40
        containerCardPage.verifyData("containerInfo", "CON/OUT140 ➡ KT1.01.01.01.01 ");
        containerCardPage.inputData("container", "OUT140");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    }

    @Test (priority = 9, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT131");
        controlCardPage.verifyData("productInfo", "00031 Стол31");
        controlCardPage.verifyData("containerInfo", "OUT131");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","31FRAGSN31Series013112202200");
        controlCardPage.inputSN("sn","31", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол32
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT132");
        controlCardPage.verifyData("productInfo", "00032 Стол32");
        controlCardPage.verifyData("containerInfo", "OUT132");
        controlCardPage.verifyData("seriesInfo", "32Series01");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","32FRAGSN32Series013112202200");
        controlCardPage.inputSN("sn","32", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол33
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT133");
        controlCardPage.verifyData("productInfo", "00033 Стол33");
        controlCardPage.verifyData("containerInfo", "OUT133");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","33FRAGSN33Series013112202200");
        controlCardPage.inputSN("sn","33", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол34
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT134");
        controlCardPage.verifyData("productInfo", "00034 Стол34");
        controlCardPage.verifyData("containerInfo", "OUT134");
        controlCardPage.verifyData("seriesInfo", "34Series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","34FRAGSN34Series013112202200");
        controlCardPage.inputSN("sn","34", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол35
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT135");
        controlCardPage.verifyData("productInfo", "00035 Стол35");
        controlCardPage.verifyData("containerInfo", "OUT135");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","35FRAGBC35Series013112202200");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол36
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT136");
        controlCardPage.verifyData("productInfo", "00036 Стол36");
        controlCardPage.verifyData("containerInfo", "OUT136");
        controlCardPage.verifyData("seriesInfo", "36Series01");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","36FRAGBC36Series013112202200");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол37
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT137");
        controlCardPage.verifyData("productInfo", "00037 Стол37");
        controlCardPage.verifyData("containerInfo", "OUT137");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","37FRAGBC37Series013112202200");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол38
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT138");
        controlCardPage.verifyData("productInfo", "00038 Стол38");
        controlCardPage.verifyData("containerInfo", "OUT138");
        controlCardPage.verifyData("seriesInfo", "38Series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","38FRAGBC38Series013112202200");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол39
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT139");
        controlCardPage.verifyData("productInfo", "00039 Стол39");
        controlCardPage.verifyData("containerInfo", "OUT139");
        controlCardPage.verifyData("seriesInfo", "39Series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","39FRAGSN39Series013112202200");
        controlCardPage.inputSN("uniqueSn","39", 9);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол40
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT140");
        controlCardPage.verifyData("productInfo", "00040 Стол40");
        controlCardPage.verifyData("containerInfo", "OUT140");
        controlCardPage.verifyData("seriesInfo", "40Series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","40FRAGSN40Series013112202207 40FRAGSN40Series013112202208 40FRAGSN40Series013112202209");
        controlCardPage.inputSN("qr","40", 7);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    }

    @Test (priority = 10, dependsOnMethods = "processingControlTaskTest")
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

        packagingCardPage.setCellOrContainerInput("KT1.01.01.01.01");
        packagingCardPage.checkCellProductInfoInRow2(1, "OUT131", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(2, "OUT132", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(3, "OUT133", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(4, "OUT134", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(5, "OUT135", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(6, "OUT136", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(7, "OUT137", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(8, "OUT138", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(9, "OUT139", "10", "1", "1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(10, "OUT140", "10", "0.1", "10", "1", "1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
    }

    @Test (priority = 11, dependsOnMethods = "processingPackagingTaskTest")
    public void processingLoadingTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Loading");
        allTasksPage.getWorkTypeTasksQuantity().click();

        loadingCardPage.setRouteSheetInput("I000000001");
        loadingCardPage.setGateInput("OUT.01");
        loadingCardPage.checkLoadingInfo("5", "Костенко", "0", "10");
        loadingCardPage.setSerialCargoInput("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
        loadingCardPage.checkLoadingInfo("5", "Костенко", "10", "0");
        loadingCardPage.clickCommitButton();
    }
}