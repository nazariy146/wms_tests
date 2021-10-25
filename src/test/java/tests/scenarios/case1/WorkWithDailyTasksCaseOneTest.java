package tests.scenarios.case1;

import io.appium.java_client.android.AndroidDriver;
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
    SettingsPage settingsPage = new SettingsPage();

    /**
     * All tests run on Regress/Case1/wms_regress_case1_Reception_Inventory DB
     * All tests run according to TestNG priority.
     * If test fails - next one will be skipped according to TestNG dependsOnMethods
     */

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        //allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();
        settingsPage.andrDriver("source");

    //Стол1
        settingsPage.verifyData("productInfo", "0001 Стол1 IN.01 Quantity 10 шт");
        settingsPage.inputData("source", "IN.01");
        settingsPage.inputData("product","0001");
        settingsPage.inputData("container","IN1");
        settingsPage.inputData("qty","10");
        settingsPage.clickButton("commit");
    //Стол10
        settingsPage.verifyData("productInfo", "00010 Стол10 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","00010");
        settingsPage.inputData("qty","10");
        settingsPage.clickButton("commit");
    //Стол2
        settingsPage.verifyData("productInfo", "0002 Стол2 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0002");
        settingsPage.verifyData("modalDialogTitle", "Batch properties");
        settingsPage.inputData("newSeries","Series2");
        settingsPage.clickButton("modalDialogOK");
        settingsPage.verifyData("productInfo", "0002 Series2 Стол2 IN.01 Quantity 10 шт");
        settingsPage.inputData("qty","10");
        settingsPage.clickButton("commit");
    //Стол3
        settingsPage.verifyData("productInfo", "0003 Стол3 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0003");
        settingsPage.verifyData("modalDialogTitle", "Batch properties");
        settingsPage.inputData("expirationDate","31.12.2021");
        settingsPage.clickButton("modalDialogOK");
        settingsPage.verifyData("productInfo", "0003 31.12.2021 Стол3 IN.01 Quantity 10 шт");
        settingsPage.inputData("qty","10");
        settingsPage.clickButton("commit");
    //Стол4
        settingsPage.verifyData("productInfo", "0004 Стол4 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0004");
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.verifyData("productInfoSN", "0004 Стол4");
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber4"));
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.clickButton("commitSN");
        settingsPage.verifyData("qty", "10");
        settingsPage.clickButton("commit");
    //Стол5
        settingsPage.verifyData("productInfo", "0005 Стол5 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0005");
        settingsPage.verifyData("modalDialogTitle", "Batch properties");
        settingsPage.inputData("newSeries","series5");
        settingsPage.inputData("expirationDate","31.12.2021");
        settingsPage.clickButton("modalDialogOK");
        settingsPage.verifyData("productInfo", "0005 series5 31.12.2021 Стол5 IN.01 Quantity 10 шт");
        settingsPage.inputData("qty","10");
        settingsPage.clickButton("commit");
    //Стол6
        settingsPage.verifyData("productInfo", "0006 Стол6 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0006");
        settingsPage.verifyData("modalDialogTitle", "Batch properties");
        settingsPage.inputData("newSeries","series6");
        settingsPage.clickButton("modalDialogOK");
        settingsPage.verifyData("productInfoSN", "0006 series6 Стол6");
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber6"));
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.clickButton("commitSN");
        settingsPage.verifyData("productInfo", "0006 series6 Стол6 IN.01 Quantity 10 шт");
        settingsPage.verifyData("qty","10");
        settingsPage.clickButton("commit");
    //Стол7
        settingsPage.inputData("product","0007");
        settingsPage.verifyData("modalDialogTitle", "Batch properties");
        settingsPage.inputData("expirationDate","31.12.2021");
        settingsPage.clickButton("modalDialogOK");
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.verifyData("productInfoSN", "0007 31.12.2021 Стол7");
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber7"));
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.clickButton("commitSN");
        settingsPage.verifyData("productInfo", "0007 31.12.2021 Стол7 IN.01 Quantity 10 шт");
        settingsPage.verifyData("qty","10");
        settingsPage.clickButton("commit");
    //Стол8
        settingsPage.verifyData("productInfo", "0008 Стол8 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0008");
        settingsPage.verifyData("modalDialogTitle", "Batch properties");
        settingsPage.inputData("newSeries","series8");
        settingsPage.inputData("expirationDate","31.12.2021");
        settingsPage.clickButton("modalDialogOK");
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.verifyData("productInfoSN", "0008 series8 31.12.2021 Стол8");
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber8"));
        receptionCardPage.setSerialNumberInputSeveralTimes();
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));
        settingsPage.clickButton("commitSN");
        settingsPage.verifyData("productInfo", "0008 series8 31.12.2021 Стол8 IN.01 Quantity 10 шт");
        settingsPage.verifyData("qty","10");
        settingsPage.clickButton("commit");
    //Стол9
        settingsPage.verifyData("productInfo", "0009 Стол9 IN.01 Quantity 10 шт");
        settingsPage.inputData("product","0009");
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.verifyData("productInfoSN", "0009 Стол9");
        receptionCardPage.inputSerialNumbers("serialnumber9", 10);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber90"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(3).shouldHave(exactText("serialnumber91"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(4).shouldHave(exactText("serialnumber92"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(5).shouldHave(exactText("serialnumber93"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(6).shouldHave(exactText("serialnumber94"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(7).shouldHave(exactText("serialnumber95"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(8).shouldHave(exactText("serialnumber96"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(9).shouldHave(exactText("serialnumber97"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(10).shouldHave(exactText("serialnumber98"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(11).shouldHave(exactText("serialnumber99"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        settingsPage.clickButton("commitSN");
        settingsPage.verifyData("productInfo", "0009 Стол9 IN.01 Quantity 10 шт");
        settingsPage.verifyData("qty","10");
        settingsPage.clickButton("commit");
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();
        accommodationCardPage.andrDriver("source");
    //Стол1
        accommodationCardPage.verifyData("productInfo", "0001 Стол1 IN.01 ➡ A.1.1.1.1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0001");
        accommodationCardPage.inputData("destination","A.1.1.1.1");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол2
        accommodationCardPage.verifyData("productInfo", "0002 Series2 Стол2 IN.01 ➡ A.1.1.1.2 Quantity 10 шт");
        accommodationCardPage.inputData("product","0002");
        accommodationCardPage.inputData("destination","A.1.1.1.2");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол3
        accommodationCardPage.verifyData("productInfo", "0003 31.12.2021 Стол3 IN.01 ➡ A.1.1.1.3 Quantity 10 шт");
        accommodationCardPage.inputData("product","0003");
        accommodationCardPage.inputData("destination","A.1.1.1.3");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол4
        accommodationCardPage.verifyData("productInfo", "0004 Стол4 IN.01 ➡ A.1.1.1.4 Quantity 10 шт");
        accommodationCardPage.inputData("product","0004");
        accommodationCardPage.inputData("destination","A.1.1.1.4");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол5
        accommodationCardPage.verifyData("productInfo", "0005 series5 31.12.2021 Стол5 IN.01 ➡ A.1.1.1.5 Quantity 10 шт");
        accommodationCardPage.inputData("product","0005");
        accommodationCardPage.inputData("destination","A.1.1.1.5");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол6
        accommodationCardPage.verifyData("productInfo", "0006 series6 Стол6 IN.01 ➡ A.1.1.1.6 Quantity 10 шт");
        accommodationCardPage.inputData("product","0006");
        accommodationCardPage.inputData("destination","A.1.1.1.6");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол7
        accommodationCardPage.verifyData("productInfo", "0007 31.12.2021 Стол7 IN.01 ➡ A.1.1.1.7 Quantity 10 шт");
        accommodationCardPage.inputData("product","0007");
        accommodationCardPage.inputData("destination","A.1.1.1.7");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол8
        accommodationCardPage.verifyData("productInfo", "0008 series8 31.12.2021 Стол8 IN.01 ➡ A.1.1.1.8 Quantity 10 шт");
        accommodationCardPage.inputData("product","0008");
        accommodationCardPage.inputData("destination","A.1.1.1.8");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол9
        accommodationCardPage.verifyData("productInfo", "0009 Стол9 IN.01 ➡ A.1.1.1.9 Quantity 10 шт");
        accommodationCardPage.inputData("product","0009");
        accommodationCardPage.inputData("destination","A.1.1.1.9");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол10
        accommodationCardPage.verifyData("productInfo", "00010 Стол10 IN.01 ➡ A.1.1.1.10 Quantity 10 шт");
        accommodationCardPage.inputData("product","00010");
        accommodationCardPage.inputData("destination","A.1.1.1.10");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
        findRestsPage.andrDriver("product");
    //Стол1
        findRestsPage.inputData("product", "0001");
        findRestsPage.verifyData("productInfo", "0001 Стол1");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.1");
        findRestsPage.verifyData("qty", "10");
    //Стол2
        findRestsPage.inputData("product", "0002");
        findRestsPage.verifyData("productInfo", "0002 Стол2");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.2");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "Series2");
    //Стол3
        findRestsPage.inputData("product", "0003");
        findRestsPage.verifyData("productInfo", "0003 Стол3");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.3");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол4
        findRestsPage.inputData("product", "0004");
        findRestsPage.verifyData("productInfo", "0004 Стол4");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.4");
        findRestsPage.verifyData("qty", "10");
    //Стол5
        findRestsPage.inputData("product", "0005");
        findRestsPage.verifyData("productInfo", "0005 Стол5");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.5");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "series5");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол6
        findRestsPage.inputData("product", "0006");
        findRestsPage.verifyData("productInfo", "0006 Стол6");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "series6");
    //Стол7
        findRestsPage.inputData("product", "0007");
        findRestsPage.verifyData("productInfo", "0007 Стол7");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол8
        findRestsPage.inputData("product", "0008");
        findRestsPage.verifyData("productInfo", "0008 Стол8");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "series8");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол9
        findRestsPage.inputData("product", "0009");
        findRestsPage.verifyData("productInfo", "0009 Стол9");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.9");
        findRestsPage.verifyData("qty", "10");
    //Стол10
        findRestsPage.inputData("product", "00010");
        findRestsPage.verifyData("productInfo", "00010 Стол10");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.10");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.getStringTasks(2).click();
        inventoryCardPage.andrDriver("product");
    //Стол1
        inventoryCardPage.inputData("source", "A.1.1.1.1");
        inventoryCardPage.inputData("product", "0001");
        inventoryCardPage.verifyData("productInfo", "0001 Стол1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0001 Стол1");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол2
        inventoryCardPage.inputData("source", "A.1.1.1.2");
        inventoryCardPage.inputData("product", "0002");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("Series2"));
        inventoryCardPage.getAvailableSeries(2).click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "0002 Series2 Стол2");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0002 Series2 Стол2");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол3
        inventoryCardPage.inputData("source", "A.1.1.1.3");
        inventoryCardPage.inputData("product", "0003");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "0003 31.12.2021 Стол3");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0003 31.12.2021 Стол3");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол4
        inventoryCardPage.inputData("source", "A.1.1.1.4");
        inventoryCardPage.inputData("product", "0004");
        inventoryCardPage.verifyData("productInfo", "0004 Стол4");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0004 Стол4");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол5
        inventoryCardPage.inputData("source", "A.1.1.1.5");
        inventoryCardPage.inputData("product", "0005");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("series5"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series5"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "0005 series5 31.12.2021 Стол5");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0005 series5 31.12.2021 Стол5");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол6
        inventoryCardPage.inputData("source", "A.1.1.1.6");
        inventoryCardPage.inputData("product", "0006");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("series6"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series6"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "0006 series6 Стол6");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0006 series6 Стол6");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол7
        inventoryCardPage.inputData("source", "A.1.1.1.7");
        inventoryCardPage.inputData("product", "0007");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "0007 31.12.2021 Стол7");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0007 31.12.2021 Стол7");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол8
        inventoryCardPage.inputData("source", "A.1.1.1.8");
        inventoryCardPage.inputData("product", "0008");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("series8"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series8"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "0008 series8 31.12.2021 Стол8");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0008 series8 31.12.2021 Стол8");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол9
        inventoryCardPage.inputData("source", "A.1.1.1.9");
        inventoryCardPage.inputData("product", "0009");
        inventoryCardPage.verifyData("productInfo", "0009 Стол9");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0009 Стол9");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол10
        inventoryCardPage.inputData("source", "A.1.1.1.10");
        inventoryCardPage.inputData("product", "00010");
        inventoryCardPage.verifyData("productInfo", "00010 Стол10");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00010 Стол10");
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

        findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG
        //Стол1
        findRestsPage.inputData("product", "0001");
        findRestsPage.verifyData("productInfo", "0001 Стол1");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.1");
        findRestsPage.verifyData("qty", "10");
        //Стол2
        findRestsPage.inputData("product", "0002");
        findRestsPage.verifyData("productInfo", "0002 Стол2");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.2");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "Series2");
        //Стол3
        findRestsPage.inputData("product", "0003");
        findRestsPage.verifyData("productInfo", "0003 Стол3");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.3");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол4
        findRestsPage.inputData("product", "0004");
        findRestsPage.verifyData("productInfo", "0004 Стол4");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.4");
        findRestsPage.verifyData("qty", "10");
        //Стол5
        findRestsPage.inputData("product", "0005");
        findRestsPage.verifyData("productInfo", "0005 Стол5");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.5");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "series5");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол6
        findRestsPage.inputData("product", "0006");
        findRestsPage.verifyData("productInfo", "0006 Стол6");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "series6");
        //Стол7
        findRestsPage.inputData("product", "0007");
        findRestsPage.verifyData("productInfo", "0007 Стол7");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол8
        findRestsPage.inputData("product", "0008");
        findRestsPage.verifyData("productInfo", "0008 Стол8");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "series8");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол9
        findRestsPage.inputData("product", "0009");
        findRestsPage.verifyData("productInfo", "0009 Стол9");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.9");
        findRestsPage.verifyData("qty", "10");
        //Стол10
        findRestsPage.inputData("product", "00010");
        findRestsPage.verifyData("productInfo", "00010 Стол10");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.10");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 5, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();
        selectionCardPage.andrDriver("source");
    //Стол1
        selectionCardPage.verifyData("productInfo", "0001 Стол1 A.1.1.1.1 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.1");
        selectionCardPage.inputData("product", "0001");
        selectionCardPage.inputData("destination", "OUT101");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол2
        selectionCardPage.verifyData("productInfo", "0002 Series2 Стол2 A.1.1.1.2 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.2");
        selectionCardPage.inputData("product", "0002");
        selectionCardPage.inputData("destination", "OUT102");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол3
        selectionCardPage.verifyData("productInfo", "0003 31.12.2021 Стол3 A.1.1.1.3 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.3");
        selectionCardPage.inputData("product", "0003");
        selectionCardPage.inputData("destination", "OUT103");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол4
        selectionCardPage.verifyData("productInfo", "0004 Стол4 A.1.1.1.4 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.4");
        selectionCardPage.inputData("product", "0004");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 Стол4"));
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber4"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT104");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол5
        selectionCardPage.verifyData("productInfo", "0005 series5 31.12.2021 Стол5 A.1.1.1.5 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.5");
        selectionCardPage.inputData("product", "0005");
        selectionCardPage.inputData("destination", "OUT105");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол6
        selectionCardPage.verifyData("productInfo", "0006 series6 Стол6 A.1.1.1.6 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.6");
        selectionCardPage.inputData("product", "0006");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 Стол6")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber6"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT106");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол7
        selectionCardPage.verifyData("productInfo", "0007 31.12.2021 Стол7 A.1.1.1.7 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.7");
        selectionCardPage.inputData("product", "0007");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 Стол7")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber7"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT107");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол8
        selectionCardPage.verifyData("productInfo", "0008 series8 31.12.2021 Стол8 A.1.1.1.8 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.8");
        selectionCardPage.inputData("product", "0008");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 Стол8")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber8"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT108");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол9
        selectionCardPage.verifyData("productInfo", "0009 Стол9 A.1.1.1.9 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.9");
        selectionCardPage.inputData("product", "0009");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 Стол9")); //TODO BUG
        selectionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        selectionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber90"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(3).shouldHave(exactText("serialnumber91"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(4).shouldHave(exactText("serialnumber92"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(5).shouldHave(exactText("serialnumber93"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(6).shouldHave(exactText("serialnumber94"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(7).shouldHave(exactText("serialnumber95"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(8).shouldHave(exactText("serialnumber96"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(9).shouldHave(exactText("serialnumber97"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(10).shouldHave(exactText("serialnumber98"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(11).shouldHave(exactText("serialnumber99"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.inputData("destination", "OUT109");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол10
        selectionCardPage.verifyData("productInfo", "00010 Стол10 A.1.1.1.10 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.1.10");
        selectionCardPage.inputData("product", "00010");
        selectionCardPage.inputData("destination", "OUT110");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол1
        containerCardPage.verifyData("containerInfo", "CON/OUT101 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT101");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол2
        containerCardPage.verifyData("containerInfo", "CON/OUT102 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT102");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол3
        containerCardPage.verifyData("containerInfo", "CON/OUT103 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT103");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол4
        containerCardPage.verifyData("containerInfo", "CON/OUT104 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT104");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол5
        containerCardPage.verifyData("containerInfo", "CON/OUT105 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT105");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол6
        containerCardPage.verifyData("containerInfo", "CON/OUT106 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT106");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол7
        containerCardPage.verifyData("containerInfo", "CON/OUT107 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT107");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол8
        containerCardPage.verifyData("containerInfo", "CON/OUT108 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT108");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол9
        containerCardPage.verifyData("containerInfo", "CON/OUT109 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT109");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол10
        containerCardPage.verifyData("containerInfo", "CON/OUT110 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT110");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    }

    @Test (priority = 7, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол1
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
    //Стол2
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT102");
        controlCardPage.getProductInfo().shouldHave(text("0002 Стол2"));
        //controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("Series2"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT102"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0002");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries(2).shouldHave(text("Series2"));
        inventoryCardPage.getAvailableSeries(2).click();
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол3
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT103");
        controlCardPage.getProductInfo().shouldHave(text("0003 Стол3"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT103"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0003");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate2().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate2().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол4
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
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber4"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол5
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT105");
        controlCardPage.getProductInfo().shouldHave(text("0005 Стол5"));
        controlCardPage.getSeriesInfo().shouldHave(text("series5"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT105"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0005");
        inventoryCardPage.getAvailableSeries().shouldHave(text("series5"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series5"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол6
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT106");
        controlCardPage.getProductInfo().shouldHave(text("0006 Стол6"));
        controlCardPage.getSeriesInfo().shouldHave(text("series6"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT106"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0006");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("series6"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series6"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 series6 Стол6"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber6"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол7
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT107");
        controlCardPage.getProductInfo().shouldHave(text("0007 Стол7"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT107"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0007");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 2021-12-31T00:00:00 Стол7")); //TODO BUG: incorrect expiration date
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber7"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол8
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT108");
        controlCardPage.getProductInfo().shouldHave(text("0008 Стол8"));
        controlCardPage.getSeriesInfo().shouldHave(text("series8"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT108"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("0008");
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Batch properties"));
        inventoryCardPage.getAvailableSeries().shouldHave(text("series8"));
        inventoryCardPage.getAvailableExpirationDateZ22().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.getSeriesBox().shouldHave(text("series8"));
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        clickSetOkYesButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 series8 2021-12-31T00:00:00 Стол8"));
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber8"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол9
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
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("serialnumber90"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(3).shouldHave(exactText("serialnumber91"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(4).shouldHave(exactText("serialnumber92"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(5).shouldHave(exactText("serialnumber93"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(6).shouldHave(exactText("serialnumber94"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(7).shouldHave(exactText("serialnumber95"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(8).shouldHave(exactText("serialnumber96"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(9).shouldHave(exactText("serialnumber97"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(10).shouldHave(exactText("serialnumber98"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(11).shouldHave(exactText("serialnumber99"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    //Стол10
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

        packagingCardPage.checkCellProductInfoInRow2(1, "OUT101", "10", "0.66", "0.66", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(2, "OUT102", "10", "0.66", "0.66", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(3, "OUT103", "10", "0.66", "0.66", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(4, "OUT104", "10", "0.66", "0.66", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(5, "OUT105", "10", "0.66", "0.66", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(6, "OUT106", "10", "0.66", "0.66", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(7, "OUT107", "10", "0.66", "0.66", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(8, "OUT108", "10", "0.66", "0.66", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(9, "OUT109", "10", "0.66", "0.66", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(10, "OUT110", "10", "0.66", "0.66", "1", "1");

        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));

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
        loadingCardPage.checkLoadingInfo("5", "Костенко", "0", "10");
        loadingCardPage.setSerialCargoInput("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
        loadingCardPage.checkLoadingInfo("5", "Костенко", "10", "0");
        loadingCardPage.clickCommitButton();
    }
}
