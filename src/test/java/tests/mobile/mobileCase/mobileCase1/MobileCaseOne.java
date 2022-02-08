package tests.mobile.mobileCase.mobileCase1;

import org.testng.annotations.Test;
import tests.mobile.mobileForm.MobileFormBatchProperties;
import tests.mobile.mobileForm.*;
import tests.mobile.mobileUtils.BaseMobileClass;
import tests.mobile.mobilePagesRefactor.*;
import tests.mobile.mobileSteps.MobileSteps;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static tests.mobile.mobileUtils.ModalDialogs.*;

public class MobileCaseOne extends BaseMobileClass {
    MobileSteps mobileSteps = new MobileSteps();
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
    RelocationCardPage relocationCardPage = new RelocationCardPage();
    RelocationTSDCardPage relocationTSDCardPage = new RelocationTSDCardPage();
    MobileFormBatchProperties mobileFormBatchProperties = new MobileFormBatchProperties();
    MobileFormSerialNumber mobileFormSerialNumber = new MobileFormSerialNumber();

    @Test
    public void processingReceptionTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол1
        receptionCardPage.verifyData("productInfo", "0001 Стол1 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0001");
        receptionCardPage.verifyData("productInfo", "0001 Стол1 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол10
        receptionCardPage.verifyData("productInfo", "00010 Стол10 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00010");
        receptionCardPage.verifyData("productInfo", "00010 Стол10 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол2
        receptionCardPage.verifyData("productInfo", "0002 Стол2 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0002");
        mobileFormBatchProperties.input(true,false,"02series01","");
        receptionCardPage.verifyData("productInfo", "0002 02series01 Стол2 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол3
        receptionCardPage.verifyData("productInfo", "0003 Стол3 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0003");
        mobileFormBatchProperties.input(false,true,"","31.12.2022");
        receptionCardPage.verifyData("productInfo", "0003 31.12.2022 Стол3 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол4
        receptionCardPage.verifyData("productInfo", "0004 Стол4 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0004");
        receptionCardPage.verifyData("productInfoSN", "0004 Стол4");
        mobileFormSerialNumber.normal("04", 10);
        receptionCardPage.verifyData("productInfo", "0004 Стол4 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол5
        receptionCardPage.verifyData("productInfo", "0005 Стол5 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0005");
        mobileFormBatchProperties.input(true, true,"05series01","31.12.2022");
        receptionCardPage.verifyData("productInfo", "0005 05series01 31.12.2022 Стол5 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол6
        receptionCardPage.verifyData("productInfo", "0006 Стол6 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0006");
        mobileFormBatchProperties.input(true,false,"06series01","");
        receptionCardPage.verifyData("productInfoSN", "0006 06series01 Стол6");
        mobileFormSerialNumber.normal("06", 10);
        receptionCardPage.verifyData("productInfo", "0006 06series01 Стол6 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол7
        receptionCardPage.verifyData("productInfo", "0007 Стол7 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0007");
        mobileFormBatchProperties.input(false,true,"","31.12.2022");
        receptionCardPage.verifyData("productInfoSN", "0007 31.12.2022 Стол7");
        mobileFormSerialNumber.normal("07", 10);
        receptionCardPage.verifyData("productInfo", "0007 31.12.2022 Стол7 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол8
        receptionCardPage.verifyData("productInfo", "0008 Стол8 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0008");
        mobileFormBatchProperties.input(true,true,"08series01","31.12.2022");
        receptionCardPage.verifyData("productInfoSN", "0008 08series01 31.12.2022 Стол8");
        mobileFormSerialNumber.normal("08", 10);
        receptionCardPage.verifyData("productInfo", "0008 08series01 31.12.2022 Стол8 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол9
        receptionCardPage.verifyData("productInfo", "0009 Стол9 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","0009");
        receptionCardPage.verifyData("productInfoSN", "0009 Стол9");
        mobileFormSerialNumber.unique("09", 10);
        receptionCardPage.verifyData("productInfo", "0009 Стол9 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол1
        accommodationCardPage.verifyData("productInfo", "0001 Стол1 IN.01 ➡ A.1.1.1.1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0001");
        accommodationCardPage.inputData("destination","A.1.1.1.1");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол2
        accommodationCardPage.verifyData("productInfo", "0002 02series01 Стол2 IN.01 ➡ A.1.1.1.2 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0002");
        accommodationCardPage.inputData("destination","A.1.1.1.2");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол3
        accommodationCardPage.verifyData("productInfo", "0003 31.12.2022 Стол3 IN.01 ➡ A.1.1.1.3 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0003");
        accommodationCardPage.inputData("destination","A.1.1.1.3");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол4
        accommodationCardPage.verifyData("productInfo", "0004 Стол4 IN.01 ➡ A.1.1.1.4 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0004");
        accommodationCardPage.inputData("destination","A.1.1.1.4");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол5
        accommodationCardPage.verifyData("productInfo", "0005 05series01 31.12.2022 Стол5 IN.01 ➡ A.1.1.1.5 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0005");
        accommodationCardPage.inputData("destination","A.1.1.1.5");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол6
        accommodationCardPage.verifyData("productInfo", "0006 06series01 Стол6 IN.01 ➡ A.1.1.1.6 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0006");
        accommodationCardPage.inputData("destination","A.1.1.1.6");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол7
        accommodationCardPage.verifyData("productInfo", "0007 31.12.2022 Стол7 IN.01 ➡ A.1.1.1.7 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0007");
        accommodationCardPage.inputData("destination","A.1.1.1.7");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол8
        accommodationCardPage.verifyData("productInfo", "0008 08series01 31.12.2022 Стол8 IN.01 ➡ A.1.1.1.8 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0008");
        accommodationCardPage.inputData("destination","A.1.1.1.8");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол9
        accommodationCardPage.verifyData("productInfo", "0009 Стол9 IN.01 ➡ A.1.1.1.9 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","0009");
        accommodationCardPage.inputData("destination","A.1.1.1.9");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол10
        accommodationCardPage.verifyData("productInfo", "00010 Стол10 IN.01 ➡ A.1.1.1.10 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00010");
        accommodationCardPage.inputData("destination","A.1.1.1.10");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        mobileSteps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
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
        findRestsPage.verifyData("seriesInfo", "02series01");
    //Стол3
        findRestsPage.inputData("product", "0003");
        findRestsPage.verifyData("productInfo", "0003 Стол3");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.3");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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
        findRestsPage.verifyData("seriesInfo", "05series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол6
        findRestsPage.inputData("product", "0006");
        findRestsPage.verifyData("productInfo", "0006 Стол6");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "06series01");
    //Стол7
        findRestsPage.inputData("product", "0007");
        findRestsPage.verifyData("productInfo", "0007 Стол7");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол8
        findRestsPage.inputData("product", "0008");
        findRestsPage.verifyData("productInfo", "0008 Стол8");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "08series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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
        mobileSteps.loginAsAdmin();
        allTasksPage.getStringTasks(2).click();
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
        mobileFormBatchProperties.select(true, false,"02series01","");
        inventoryCardPage.verifyData("productInfo", "0002 02series01 Стол2");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0002 02series01 Стол2");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол3
        inventoryCardPage.inputData("source", "A.1.1.1.3");
        inventoryCardPage.inputData("product", "0003");
        mobileFormBatchProperties.select(false,true,"","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "0003 31.12.2022 Стол3");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0003 31.12.2022 Стол3");
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
        mobileFormBatchProperties.select(true,true,"05series01","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "0005 05series01 31.12.2022 Стол5");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0005 05series01 31.12.2022 Стол5");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол6
        inventoryCardPage.inputData("source", "A.1.1.1.6");
        inventoryCardPage.inputData("product", "0006");
        mobileFormBatchProperties.select(true,false,"06series01","");
        inventoryCardPage.verifyData("productInfo", "0006 06series01 Стол6");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0006 06series01 Стол6");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол7
        inventoryCardPage.inputData("source", "A.1.1.1.7");
        inventoryCardPage.inputData("product", "0007");
        mobileFormBatchProperties.select(false,true,"","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "0007 31.12.2022 Стол7");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0007 31.12.2022 Стол7");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол8
        inventoryCardPage.inputData("source", "A.1.1.1.8");
        inventoryCardPage.inputData("product", "0008");
        mobileFormBatchProperties.select(true,true,"08series01","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "0008 08series01 31.12.2022 Стол8");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0008 08series01 31.12.2022 Стол8");
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
        mobileSteps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
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
        findRestsPage.verifyData("seriesInfo", "02series01");
    //Стол3
        findRestsPage.inputData("product", "0003");
        findRestsPage.verifyData("productInfo", "0003 Стол3");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.3");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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
        findRestsPage.verifyData("seriesInfo", "05series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол6
        findRestsPage.inputData("product", "0006");
        findRestsPage.verifyData("productInfo", "0006 Стол6");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "06series01");
    //Стол7
        findRestsPage.inputData("product", "0007");
        findRestsPage.verifyData("productInfo", "0007 Стол7");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
    //Стол8
        findRestsPage.inputData("product", "0008");
        findRestsPage.verifyData("productInfo", "0008 Стол8");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("seriesInfo", "08series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
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

    @Test (priority = 5, dependsOnMethods = "processingInventoryTaskTest")
    public void processingRelocationTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Moving");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол1
        relocationCardPage.verifyData("productInfo", "0001 Стол1 A.1.1.1.1 ➡ A.1.1.2.1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.1");
        relocationCardPage.inputData("product", "0001");
        relocationCardPage.inputData("destination", "A.1.1.2.1");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол2
        relocationCardPage.verifyData("productInfo", "0002 02series01 Стол2 A.1.1.1.2 ➡ A.1.1.2.2 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.2");
        relocationCardPage.inputData("product", "0002");
        relocationCardPage.inputData("destination", "A.1.1.2.2");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол3
        relocationCardPage.verifyData("productInfo", "0003 31.12.2022 Стол3 A.1.1.1.3 ➡ A.1.1.2.3 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.3");
        relocationCardPage.inputData("product", "0003");
        relocationCardPage.inputData("destination", "A.1.1.2.3");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол4
        relocationCardPage.verifyData("productInfo", "0004 Стол4 A.1.1.1.4 ➡ A.1.1.2.4 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.4");
        relocationCardPage.inputData("product", "0004");
        relocationCardPage.inputData("destination", "A.1.1.2.4");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол5
        relocationCardPage.verifyData("productInfo", "0005 05series01 31.12.2022 Стол5 A.1.1.1.5 ➡ A.1.1.2.5 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.5");
        relocationCardPage.inputData("product", "0005");
        relocationCardPage.inputData("destination", "A.1.1.2.5");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол6
        relocationCardPage.verifyData("productInfo", "0006 06series01 Стол6 A.1.1.1.6 ➡ A.1.1.2.6 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.6");
        relocationCardPage.inputData("product", "0006");
        relocationCardPage.inputData("destination", "A.1.1.2.6");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол7
        relocationCardPage.verifyData("productInfo", "0007 31.12.2022 Стол7 A.1.1.1.7 ➡ A.1.1.2.7 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.7");
        relocationCardPage.inputData("product", "0007");
        relocationCardPage.inputData("destination", "A.1.1.2.7");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол8
        relocationCardPage.verifyData("productInfo", "0008 08series01 31.12.2022 Стол8 A.1.1.1.8 ➡ A.1.1.2.8 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.8");
        relocationCardPage.inputData("product", "0008");
        relocationCardPage.inputData("destination", "A.1.1.2.8");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол9
        relocationCardPage.verifyData("productInfo", "0009 Стол9 A.1.1.1.9 ➡ A.1.1.2.9 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.9");
        relocationCardPage.inputData("product", "0009");
        relocationCardPage.inputData("destination", "A.1.1.2.9");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол10
        relocationCardPage.verifyData("productInfo", "00010 Стол10 A.1.1.1.10 ➡ A.1.1.2.10 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.10");
        relocationCardPage.inputData("product", "00010");
        relocationCardPage.inputData("destination", "A.1.1.2.10");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingRelocationTaskTest")
    public void processingRelocationTSDTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        relocationTSDCardPage.clickButton("rightMenu");
        relocationTSDCardPage.clickButton("relocation");
    //Стол1
        relocationTSDCardPage.inputData("source", "A.1.1.2.1");
        relocationTSDCardPage.inputData("product", "0001");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.1 ➡ 0001 Стол1");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.1 ➡ 0001 Стол1 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.1");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.1 ➡ A.1.1.3.1 0001 Стол1 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол2
        relocationTSDCardPage.inputData("source", "A.1.1.2.2");
        relocationTSDCardPage.inputData("product", "0002");
        mobileFormBatchProperties.select(true,false,"02series01","");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.2 ➡ 0002 02series01 Стол2");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.2 ➡ 0002 02series01 Стол2 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.2");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.2 ➡ A.1.1.3.2 0002 02series01 Стол2 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол3
        relocationTSDCardPage.inputData("source", "A.1.1.2.3");
        relocationTSDCardPage.inputData("product", "0003");
        mobileFormBatchProperties.select(false,true,"","31.12.2022");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.3 ➡ 0003 31.12.2022 Стол3 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.3");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.3 ➡ A.1.1.3.3 0003 31.12.2022 Стол3 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол4
        relocationTSDCardPage.inputData("source", "A.1.1.2.4");
        relocationTSDCardPage.inputData("product", "0004");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.4 ➡ 0004 Стол4");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.4 ➡ 0004 Стол4 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.4");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.4 ➡ A.1.1.3.4 0004 Стол4 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол5
        relocationTSDCardPage.inputData("source", "A.1.1.2.5");
        relocationTSDCardPage.inputData("product", "0005");
        mobileFormBatchProperties.select(true, true,"05series01","31.12.2022");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.5 ➡ 0005 05series01 31.12.2022 Стол5");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.5 ➡ 0005 05series01 31.12.2022 Стол5 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.5");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.5 ➡ A.1.1.3.5 0005 05series01 31.12.2022 Стол5 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол6
        relocationTSDCardPage.inputData("source", "A.1.1.2.6");
        relocationTSDCardPage.inputData("product", "0006");
        mobileFormBatchProperties.select(true,false,"06series01","");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.6 ➡ 0006 06series01 Стол6");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.6 ➡ 0006 06series01 Стол6 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.6");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.6 ➡ A.1.1.3.6 0006 06series01 Стол6 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол7
        relocationTSDCardPage.inputData("source", "A.1.1.2.7");
        relocationTSDCardPage.inputData("product", "0007");
        mobileFormBatchProperties.select(false,true,"","31.12.2022");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.7 ➡ 0007 31.12.2022 Стол7");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.7 ➡ 0007 31.12.2022 Стол7 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.7");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.7 ➡ A.1.1.3.7 0007 31.12.2022 Стол7 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол8
        relocationTSDCardPage.inputData("source", "A.1.1.2.8");
        relocationTSDCardPage.inputData("product", "0008");
        mobileFormBatchProperties.select(true,true,"08series01","31.12.2022");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.8 ➡ 0008 08series01 31.12.2022 Стол8");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.8 ➡ 0008 08series01 31.12.2022 Стол8 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.8");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.8 ➡ A.1.1.3.8 0008 08series01 31.12.2022 Стол8 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол9
        relocationTSDCardPage.inputData("source", "A.1.1.2.9");
        relocationTSDCardPage.inputData("product", "0009");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.9 ➡ 0009 Стол9");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.9 ➡ 0009 Стол9 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.9");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.9 ➡ A.1.1.3.9 0009 Стол9 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол10
        relocationTSDCardPage.inputData("source", "A.1.1.2.10");
        relocationTSDCardPage.inputData("product", "00010");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.10 ➡ 00010 Стол10");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.10 ➡ 00010 Стол10 Quantity 10");
        relocationTSDCardPage.inputData("destination", "A.1.1.3.10");
        relocationTSDCardPage.verifyData("productInfo", "A.1.1.2.10 ➡ A.1.1.3.10 00010 Стол10 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    }

    @Test (priority = 7, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол1
        selectionCardPage.verifyData("productInfo", "0001 Стол1 A.1.1.3.1 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.1");
        selectionCardPage.inputData("product", "0001");
        selectionCardPage.inputData("destination", "OUT101");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол2
        selectionCardPage.verifyData("productInfo", "0002 02series01 Стол2 A.1.1.3.2 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.2");
        selectionCardPage.inputData("product", "0002");
        selectionCardPage.inputData("destination", "OUT102");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол3
        selectionCardPage.verifyData("productInfo", "0003 31.12.2022 Стол3 A.1.1.3.3 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.3");
        selectionCardPage.inputData("product", "0003");
        selectionCardPage.inputData("destination", "OUT103");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол4
        selectionCardPage.verifyData("productInfo", "0004 Стол4 A.1.1.3.4 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.4");
        selectionCardPage.inputData("product", "0004");
        mobileFormSerialNumber.normal("04", 10);
        selectionCardPage.inputData("destination", "OUT104");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол5
        selectionCardPage.verifyData("productInfo", "0005 05series01 31.12.2022 Стол5 A.1.1.3.5 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.5");
        selectionCardPage.inputData("product", "0005");
        selectionCardPage.inputData("destination", "OUT105");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол6
        selectionCardPage.verifyData("productInfo", "0006 06series01 Стол6 A.1.1.3.6 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.6");
        selectionCardPage.inputData("product", "0006");
        mobileFormSerialNumber.normal("06", 10);
        selectionCardPage.inputData("destination", "OUT106");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол7
        selectionCardPage.verifyData("productInfo", "0007 31.12.2022 Стол7 A.1.1.3.7 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.7");
        selectionCardPage.inputData("product", "0007");
        mobileFormSerialNumber.normal("07", 10);
        selectionCardPage.inputData("destination", "OUT107");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол8
        selectionCardPage.verifyData("productInfo", "0008 08series01 31.12.2022 Стол8 A.1.1.3.8 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.8");
        selectionCardPage.inputData("product", "0008");
        mobileFormSerialNumber.normal("08", 10);
        selectionCardPage.inputData("destination", "OUT108");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол9
        selectionCardPage.verifyData("productInfo", "0009 Стол9 A.1.1.3.9 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.9");
        selectionCardPage.inputData("product", "0009");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        mobileFormSerialNumber.unique("09", 10);
        selectionCardPage.inputData("destination", "OUT109");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол10
        selectionCardPage.verifyData("productInfo", "00010 Стол10 A.1.1.3.10 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "A.1.1.3.10");
        selectionCardPage.inputData("product", "00010");
        selectionCardPage.inputData("destination", "OUT110");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 8, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Контейнер (Selection)");
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

    @Test (priority = 9, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол1
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT101");
        controlCardPage.verifyData("productInfo", "0001 Стол1");
        controlCardPage.verifyData("containerInfo", "OUT101");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0001");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол2
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT102");
        controlCardPage.verifyData("productInfo", "0002 Стол2");
        controlCardPage.verifyData("containerInfo", "OUT102");
        controlCardPage.verifyData("seriesInfo", "02series01");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0002");
        mobileFormBatchProperties.select(true,false,"02series01","");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол3
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT103");
        controlCardPage.verifyData("productInfo", "0003 Стол3");
        controlCardPage.verifyData("containerInfo", "OUT103");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0003");
        mobileFormBatchProperties.select(false,true,"","31.12.2022");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол4
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT104");
        controlCardPage.verifyData("productInfo", "0004 Стол4");
        controlCardPage.verifyData("containerInfo", "OUT104");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0004");
        mobileFormSerialNumber.normal("04", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол5
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT105");
        controlCardPage.verifyData("productInfo", "0005 Стол5");
        controlCardPage.verifyData("seriesInfo", "05series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.verifyData("containerInfo", "OUT105");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0005");
        mobileFormBatchProperties.select(true, true,"05series01","31.12.2022");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол6
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT106");
        controlCardPage.verifyData("productInfo", "0006 Стол6");
        controlCardPage.verifyData("seriesInfo", "06series01");
        controlCardPage.verifyData("containerInfo", "OUT106");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0006");
        mobileFormBatchProperties.select(true,false,"06series01","");
        mobileFormSerialNumber.normal("06", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол7
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT107");
        controlCardPage.verifyData("productInfo", "0007 Стол7");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.verifyData("containerInfo", "OUT107");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0007");
        mobileFormBatchProperties.select(false,true,"","31.12.2022");
        mobileFormSerialNumber.normal("07", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол8
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT108");
        controlCardPage.verifyData("productInfo", "0008 Стол8");
        controlCardPage.verifyData("seriesInfo", "08series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.verifyData("containerInfo", "OUT108");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0008");
        mobileFormBatchProperties.select(true,true,"08series01","31.12.2022");
        mobileFormSerialNumber.normal("08", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол9
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT109");
        controlCardPage.verifyData("productInfo", "0009 Стол9");
        controlCardPage.verifyData("containerInfo", "OUT109");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","0009");
        mobileFormSerialNumber.unique("09", 10);
        controlCardPage.clickButton("commit");
    //Стол10
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT110");
        controlCardPage.verifyData("productInfo", "00010 Стол10");
        controlCardPage.verifyData("containerInfo", "OUT110");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00010");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    }

    @Test (priority = 10, dependsOnMethods = "processingControlTaskTest")
    public void processingPackagingTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();



        packagingCardPage.setCellOrContainerInput("KT1.01.01.01.01");
        packagingCardPage.checkCellProductInfoInRow2(1, "OUT101", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(2, "OUT102", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(3, "OUT103", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(4, "OUT104", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(5, "OUT105", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(6, "OUT106", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(7, "OUT107", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(8, "OUT108", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(9, "OUT109", "10", "0.66", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(10, "OUT110", "10", "0.66", "10", "1", "1");

        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));

        clickSetOkYesButton();
        getMessageModalDialog().shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("We've created cargo bays"));
        clickErrorDialogOkButton();
    }

    @Test (priority = 11, dependsOnMethods = "processingPackagingTaskTest")
    public void processingLoadingTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
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
