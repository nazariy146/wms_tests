package tests.mobile.mobileCase.case5;

import org.testng.annotations.Test;
import tests.mobile.mobileForm.mobileFormBatchProperties;
import tests.mobile.mobileUtils.BaseMobileClass;
import tests.mobile.mobilePages.*;
import tests.mobile.mobileSteps.mobileSteps;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static tests.mobile.mobileUtils.ModalDialogs.*;

public class WorkWithDailyTasksCaseFiveTest extends BaseMobileClass{
    mobileSteps mobileSteps = new mobileSteps();
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
    mobileFormBatchProperties mobileFormBatchProperties = new mobileFormBatchProperties();

    @Test
    public void processingReceptionTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол41
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00041");
        mobileFormBatchProperties.input(true,true,"41Series01","31.12.2022");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","41");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "41");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00041 41Series01 31.12.2022 Стол41 IN.01 Quantity 10 шт");    //Eleo - иногда падает на этом месте тест (Не успевает обновлятся форма)
        receptionCardPage.verifyData("package", "41-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол42
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00042");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","42");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "42");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","42");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","2");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "2");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00042 Стол42 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "42-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("multiplicity");
        receptionCardPage.clickButton("ChoiceOFmultiplicity");
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");

        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00042");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00042 Стол42 IN.01 Quantity 4 шт");
        receptionCardPage.clickButton("ChoicePacking");
        receptionCardPage.clickButton("Packing42-5-4-2-1");
        receptionCardPage.verifyData("package", "42-5-4-2-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("multiplicity");
        receptionCardPage.clickButton("ChoiceOFmultiplicity");
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");
    //Стол43
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00043");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","43");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "43");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","43");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","2");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "2");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.clickButton("Choice43-5-4-3-1");
        receptionCardPage.clickButton("DeletePacking");
        receptionCardPage.clickButton("modalDialogOK");
        receptionCardPage.clickButton("Choice43-5-4-2-1");
        receptionCardPage.clickButton("EditPacking");
        receptionCardPage.inputData("group","10");
        receptionCardPage.clickButton("modalDialogOK");
        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "10");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00043 Стол43 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "43-5-4-10-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол44
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00044");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","44");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","5");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "5");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("Barcode");
        receptionCardPage.inputData("Barcode","4400000000001");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "44");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00044 Стол44 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","4400000000001");
        receptionCardPage.verifyData("package", "44-5-4-5-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");
    //Стол45
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00045");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","45");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "45");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00045 Стол45 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "45-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол46
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","2110046100000");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","46");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "46");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00046 Стол46 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "46-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол47
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","2110047100000");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","47");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "47");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00047 Стол47 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "47-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","1");
        receptionCardPage.inputData("qty", "10");
        receptionCardPage.clickButton("commit");
    //Стол48
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","48SnPack00");
        Thread.sleep(5000);
        receptionCardPage.clickButton("commitSN");                                                              //Eleo - Необходима проверка опознанных СН в таб. части.

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","48");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "48");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00048 Стол48 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "48-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол49
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","49FRAGSN49Series013112202200");
        receptionCardPage.inputSN("sn","49", 10);

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","49");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "49");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00049 Стол49 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "49-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.verifyData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол50
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00050");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","50");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","5");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","4");
        receptionCardPage.clickButton("groupFlag");
        receptionCardPage.inputData("group","3");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "3");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "4");
        receptionCardPage.verifyData("skuName", "ящик");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "New unit");
        receptionCardPage.verifyData("skuQty", "50");
        receptionCardPage.verifyData("skuName", "паллета");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");
        Thread.sleep(2000);
        receptionCardPage.clickButton("modalDialogOK");

        Thread.sleep(2000);
        receptionCardPage.verifyData("productInfo", "00050 Стол50 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "50-5-4-3-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("palletWeight", "2");
        receptionCardPage.inputData("tareQty", "5");
        receptionCardPage.inputData("tareWeight", "0.2");
        receptionCardPage.inputData("qty","13");
        receptionCardPage.clickButton("commit");
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception{
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол41
        accommodationCardPage.verifyData("productInfo", "00041 41Series01 31.12.2022 Стол41 IN.01 ➡ A.1.1.1.41 Packing 41-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00041");
        accommodationCardPage.inputData("destination","A.1.1.1.41");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол42
        accommodationCardPage.verifyData("productInfo", "00042 Стол42 IN.01 ➡ A.1.1.1.42 Packing 42-5-4-3-1 Quantity 6 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00042");
        accommodationCardPage.inputData("destination","A.1.1.1.42");
        accommodationCardPage.inputData("qty","6");
        accommodationCardPage.clickButton("commit");
    //Стол42
        accommodationCardPage.verifyData("productInfo", "00042 Стол42 IN.01 ➡ A.1.1.1.42 Packing 42-5-4-2-1 Quantity 4 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00042");
        accommodationCardPage.inputData("destination","A.1.1.1.42");
        accommodationCardPage.inputData("qty","4");
        accommodationCardPage.clickButton("commit");
    //Стол43
        accommodationCardPage.verifyData("productInfo", "00043 Стол43 IN.01 ➡ A.1.1.1.43 Packing 43-5-4-10-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00043");
        accommodationCardPage.inputData("destination","A.1.1.1.43");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол44
        accommodationCardPage.verifyData("productInfo", "00044 Стол44 IN.01 ➡ A.1.1.1.44 Packing 44-5-4-5-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00044");
        accommodationCardPage.inputData("destination","A.1.1.1.44");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол45
        accommodationCardPage.verifyData("productInfo", "00045 Стол45 IN.01 ➡ A.1.1.1.45 Packing 45-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00045");
        accommodationCardPage.inputData("destination","A.1.1.1.45");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол46
        accommodationCardPage.verifyData("productInfo", "00046 Стол46 IN.01 ➡ A.1.1.1.46 Packing 46-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","2110046100000");
        accommodationCardPage.inputData("destination","A.1.1.1.46");
        accommodationCardPage.verifyData("qty","10.000");
        accommodationCardPage.clickButton("commit");
    //Стол47
        accommodationCardPage.verifyData("productInfo", "00047 Стол47 IN.01 ➡ A.1.1.1.47 Packing 47-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","2110047100000");
        accommodationCardPage.inputData("destination","A.1.1.1.47");
        accommodationCardPage.verifyData("qty","1");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол48
        accommodationCardPage.verifyData("productInfo", "00048 Стол48 IN.01 ➡ A.1.1.1.48 Packing 48-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00048");
        accommodationCardPage.inputData("destination","A.1.1.1.48");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол49
        accommodationCardPage.verifyData("productInfo", "00049 Стол49 IN.01 ➡ A.1.1.1.49 Packing 49-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","49FRAGSN49Series013112202200");
        accommodationCardPage.inputData("destination","A.1.1.1.49");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол50
        accommodationCardPage.verifyData("productInfo", "00050 Стол50(0.2) IN.01 ➡ A.1.1.1.50 Packing 50-5-4-3-1 Quantity 10 шт");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","00050");
        accommodationCardPage.inputData("destination","A.1.1.1.50");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        mobileSteps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
    //Стол41
        findRestsPage.inputData("product", "00041");
        findRestsPage.verifyData("productInfo", "00041 Стол41");
        findRestsPage.verifyData("seriesInfo", "41Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.41");
        findRestsPage.verifyData("qty", "10");
    //Стол42
        findRestsPage.inputData("product", "00042");
        findRestsPage.verifyData("productInfo", "00042 Стол42");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.42");
        findRestsPage.verifyData("qty", "10");
    //Стол43
        findRestsPage.inputData("product", "00043");
        findRestsPage.verifyData("productInfo", "00043 Стол43");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.43");
        findRestsPage.verifyData("qty", "10");
    //Стол44
        findRestsPage.inputData("product", "00044");
        findRestsPage.verifyData("productInfo", "00044 Стол44");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.44");
        findRestsPage.verifyData("qty", "10");
    //Стол45
        findRestsPage.inputData("product", "00045");
        findRestsPage.verifyData("productInfo", "00045 Стол45");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.45");
        findRestsPage.verifyData("qty", "10");
    //Стол46
        findRestsPage.inputData("product", "00046");
        findRestsPage.verifyData("productInfo", "00046 Стол46");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.46");
        findRestsPage.verifyData("qty", "10");
    //Стол47
        findRestsPage.inputData("product", "00047");
        findRestsPage.verifyData("productInfo", "00047 Стол47");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.47");
        findRestsPage.verifyData("qty", "10");
    //Стол48
        findRestsPage.inputData("product", "00048");
        findRestsPage.verifyData("productInfo", "00048 Стол48");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.48");
        findRestsPage.verifyData("qty", "10");
    //Стол49
        findRestsPage.inputData("product", "00049");
        findRestsPage.verifyData("productInfo", "00049 Стол49");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.49");
        findRestsPage.verifyData("qty", "10");
    //Стол50
        findRestsPage.inputData("product", "00050");
        findRestsPage.verifyData("productInfo", "00050 Стол50");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.50");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.getStringTasks(2).click();
    //Стол41
        inventoryCardPage.inputData("source", "A.1.1.1.41");
        inventoryCardPage.inputData("product", "00041");
        mobileFormBatchProperties.select(true, true,"41Series01","31.12.2022");
        inventoryCardPage.verifyData("productInfo", "00041 41series01 31.12.2022 Стол41");
        inventoryCardPage.verifyData("ChoicePacking", "41-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол42
        inventoryCardPage.inputData("source", "A.1.1.1.42");
        inventoryCardPage.inputData("product", "00042");
        inventoryCardPage.verifyData("ChoicePacking", "42-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("productInfo", "00042 Стол42");
        inventoryCardPage.inputData("qty","6");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "6.0");
        //TODO необходимо доработать проверку проинвентаризированных строк в таб. части
        inventoryCardPage.inputData("product", "00042");
        inventoryCardPage.clickButton("ChoicePacking");
        inventoryCardPage.clickButton("Packing42-5-4-2-1");
        inventoryCardPage.verifyData("ChoicePacking", "42-5-4-2-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("productInfo", "00042 Стол42");
        inventoryCardPage.inputData("qty","4");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "4.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол43
        inventoryCardPage.inputData("source", "A.1.1.1.43");
        inventoryCardPage.inputData("product", "00043");
        inventoryCardPage.verifyData("productInfo", "00043 Стол43");
        inventoryCardPage.verifyData("ChoicePacking", "43-5-4-10-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол44
        inventoryCardPage.inputData("source", "A.1.1.1.44");
        inventoryCardPage.inputData("product", "00044");
        inventoryCardPage.verifyData("productInfo", "00044 Стол44");
        inventoryCardPage.verifyData("ChoicePacking", "44-5-4-5-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол45
        inventoryCardPage.inputData("source", "A.1.1.1.45");
        inventoryCardPage.inputData("product", "00045");
        inventoryCardPage.verifyData("productInfo", "00045 Стол45");
        inventoryCardPage.verifyData("ChoicePacking", "45-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол46
        inventoryCardPage.inputData("source", "A.1.1.1.46");
        inventoryCardPage.inputData("product", "2110046100000");
        inventoryCardPage.verifyData("productInfo", "00046 Стол46");
        inventoryCardPage.verifyData("ChoicePacking", "46-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("qty","10.000");
        inventoryCardPage.clickButton("AddInv");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол47
        inventoryCardPage.inputData("source", "A.1.1.1.47");
        inventoryCardPage.inputData("product", "2110047100000");
        inventoryCardPage.verifyData("productInfo", "00047 Стол47");
        inventoryCardPage.verifyData("ChoicePacking", "47-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("qty","1.000");
        inventoryCardPage.inputData("qty", "10");
        inventoryCardPage.clickButton("AddInv");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол48
        inventoryCardPage.inputData("source", "A.1.1.1.48");
        inventoryCardPage.inputData("product", "00048");
        inventoryCardPage.verifyData("productInfo", "00048 Стол48");
        inventoryCardPage.verifyData("ChoicePacking", "48-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол49
        inventoryCardPage.inputData("source", "A.1.1.1.49");
        inventoryCardPage.inputData("product", "49FRAGSN49Series013112202200");
        //inventoryCardPage.verifyData("productInfo", "00049 Стол49"); MNV TODO правильно
        inventoryCardPage.verifyData("productInfo", "00049 49Series01 2022-12-31T00:00:00 Стол49"); //MNV TODO bag серия и СГ не должны быть в описании по номенклатуре не ведется учет
        inventoryCardPage.verifyData("ChoicePacking", "49-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол50
        inventoryCardPage.inputData("source", "A.1.1.1.50");
        inventoryCardPage.inputData("product", "00050");
        inventoryCardPage.verifyData("productInfo", "00050 Стол50");
        inventoryCardPage.verifyData("ChoicePacking", "50-5-4-3-1");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("palletWeight", "2");
        inventoryCardPage.inputData("tareQty", "5");
        inventoryCardPage.inputData("tareWeight", "0.2");
        inventoryCardPage.inputData("qty","13");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    }

    @Test (priority = 4, dependsOnMethods = "processingInventoryTaskTest")
    public void checkingFreeAmountTest2() {
        mobileSteps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
    //Стол41
        findRestsPage.inputData("product", "00041");
        findRestsPage.verifyData("productInfo", "00041 Стол41");
        findRestsPage.verifyData("seriesInfo", "41Series01");
        findRestsPage.verifyData("shelfLifeInfo", "31.12.2022");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.41");
        findRestsPage.verifyData("qty", "10");
    //Стол42
        findRestsPage.inputData("product", "00042");
        findRestsPage.verifyData("productInfo", "00042 Стол42");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.42");
        findRestsPage.verifyData("qty", "10");
    //Стол43
        findRestsPage.inputData("product", "00043");
        findRestsPage.verifyData("productInfo", "00043 Стол43");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.43");
        findRestsPage.verifyData("qty", "10");
    //Стол44
        findRestsPage.inputData("product", "00044");
        findRestsPage.verifyData("productInfo", "00044 Стол44");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.44");
        findRestsPage.verifyData("qty", "10");
    //Стол45
        findRestsPage.inputData("product", "00045");
        findRestsPage.verifyData("productInfo", "00045 Стол45");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.45");
        findRestsPage.verifyData("qty", "10");
    //Стол46
        findRestsPage.inputData("product", "00046");
        findRestsPage.verifyData("productInfo", "00046 Стол46");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.46");
        findRestsPage.verifyData("qty", "10");
    //Стол47
        findRestsPage.inputData("product", "00047");
        findRestsPage.verifyData("productInfo", "00047 Стол47");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.47");
        findRestsPage.verifyData("qty", "10");
    //Стол48
        findRestsPage.inputData("product", "00048");
        findRestsPage.verifyData("productInfo", "00048 Стол48");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.48");
        findRestsPage.verifyData("qty", "10");
    //Стол49
        findRestsPage.inputData("product", "00049");
        findRestsPage.verifyData("productInfo", "00049 Стол49");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.49");
        findRestsPage.verifyData("qty", "10");
    //Стол50
        findRestsPage.inputData("product", "00050");
        findRestsPage.verifyData("productInfo", "00050 Стол50");
        findRestsPage.verifyData("sourceInfo", "A.1.1.1.50");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 5, dependsOnMethods = "processingInventoryTaskTest")
    public void processingRelocationTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Moving");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол41
        relocationCardPage.verifyData("productInfo", "00041 41Series01 31.12.2022 Стол41 A.1.1.1.41 ➡ B.1.1.1.41 Packing 41-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.41");
        relocationCardPage.inputData("product", "00041");
        relocationCardPage.inputData("destination", "B.1.1.1.41");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол42
        relocationCardPage.verifyData("productInfo", "00042 Стол42 A.1.1.1.42 ➡ B.1.1.1.42 Packing 42-5-4-3-1 Quantity 6 шт");
        relocationCardPage.inputData("source", "A.1.1.1.42");
        relocationCardPage.inputData("product", "00042");
        relocationCardPage.inputData("destination", "B.1.1.1.42");
        relocationCardPage.inputData("qty", "6");
        relocationCardPage.verifyData("qty", "6");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "6");
        relocationCardPage.clickButton("commit");
    //Стол42
        relocationCardPage.verifyData("productInfo", "00042 Стол42 A.1.1.1.42 ➡ B.1.1.1.42 Packing 42-5-4-2-1 Quantity 4 шт");
        relocationCardPage.inputData("source", "A.1.1.1.42");
        relocationCardPage.inputData("product", "00042");
        relocationCardPage.inputData("destination", "B.1.1.1.42");
        relocationCardPage.inputData("qty", "4");
        relocationCardPage.verifyData("qty", "4");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "4");
        relocationCardPage.clickButton("commit");
    //Стол43
        relocationCardPage.verifyData("productInfo", "00043 Стол43 A.1.1.1.43 ➡ B.1.1.1.43 Packing 43-5-4-10-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.43");
        relocationCardPage.inputData("product", "00043");
        relocationCardPage.inputData("destination", "B.1.1.1.43");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол44
        relocationCardPage.verifyData("productInfo", "00044 Стол44 A.1.1.1.44 ➡ B.1.1.1.44 Packing 44-5-4-5-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.44");
        relocationCardPage.inputData("product", "00044");
        relocationCardPage.inputData("destination", "B.1.1.1.44");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол45
        relocationCardPage.verifyData("productInfo", "00045 Стол45 A.1.1.1.45 ➡ B.1.1.1.45 Packing 45-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.45");
        relocationCardPage.inputData("product", "00045");
        relocationCardPage.inputData("destination", "B.1.1.1.45");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол46
        relocationCardPage.verifyData("productInfo", "00046 Стол46 A.1.1.1.46 ➡ B.1.1.1.46 Packing 46-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.46");
        relocationCardPage.inputData("product", "2110046100000");
        relocationCardPage.inputData("destination", "B.1.1.1.46");
        relocationCardPage.verifyData("qty", "10.000");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол47
        relocationCardPage.verifyData("productInfo", "00047 Стол47 A.1.1.1.47 ➡ B.1.1.1.47 Packing 47-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.47");
        relocationCardPage.inputData("product", "2110047100000");
        relocationCardPage.inputData("destination", "B.1.1.1.47");
        relocationCardPage.verifyData("qty", "1.000");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол48
        relocationCardPage.verifyData("productInfo", "00048 Стол48 A.1.1.1.48 ➡ B.1.1.1.48 Packing 48-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.48");
        relocationCardPage.inputData("product", "00048");
        relocationCardPage.inputData("destination", "B.1.1.1.48");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол49
        relocationCardPage.verifyData("productInfo", "00049 Стол49 A.1.1.1.49 ➡ B.1.1.1.49 Packing 49-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.49");
        relocationCardPage.inputData("product", "49FRAGSN49Series013112202200");
        relocationCardPage.inputData("destination", "B.1.1.1.49");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    //Стол50
        relocationCardPage.verifyData("productInfo", "00050 Стол50(0.2) A.1.1.1.50 ➡ B.1.1.1.50 Packing 50-5-4-3-1 Quantity 10 шт");
        relocationCardPage.inputData("source", "A.1.1.1.50");
        relocationCardPage.inputData("product", "00050");
        relocationCardPage.inputData("destination", "B.1.1.1.50");
        relocationCardPage.inputData("tareQty", "5");
        relocationCardPage.inputData("tareWeight", "0.2");
        relocationCardPage.inputData("qty", "10");
        relocationCardPage.verifyData("qty", "10");
        relocationCardPage.verifyData("unitAmount", "1.0");
        relocationCardPage.verifyData("unitPackaging", "10");
        relocationCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingRelocationTaskTest")
    public void processingRelocationTSDTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        relocationTSDCardPage.clickButton("rightMenu");
        relocationTSDCardPage.clickButton("relocation");
    //Стол41
        relocationTSDCardPage.inputData("source", "B.1.1.1.41");
        relocationTSDCardPage.inputData("product", "00041");
        mobileFormBatchProperties.select(true, true,"41Series01","31.12.2022");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.41 ➡ 00041 41Series01 31.12.2022 Стол41");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.41 ➡ 00041 41Series01 31.12.2022 Стол41 Quantity 10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.41");
        relocationTSDCardPage.verifyData("dataPacking", "41-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.41 ➡ C.1.1.1.41 00041 41Series01 31.12.2022 Стол41 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол42
        relocationTSDCardPage.inputData("source", "B.1.1.1.42");
        relocationTSDCardPage.inputData("product", "00042");
        relocationTSDCardPage.clickButton("dataPacking");
        relocationTSDCardPage.clickButton("packing42-5-4-3-1");
        relocationTSDCardPage.inputData("qty", "6");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.42");
        relocationTSDCardPage.verifyData("dataPacking", "42-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.42 ➡ C.1.1.1.42 00042 Стол42 Quantity 6");
        relocationTSDCardPage.clickButton("moving");
    //Стол42
        relocationTSDCardPage.inputData("source", "B.1.1.1.42");
        relocationTSDCardPage.inputData("product", "00042");
        relocationTSDCardPage.clickButton("dataPacking");
        relocationTSDCardPage.clickButton("packing42-5-4-2-1");
        relocationTSDCardPage.inputData("qty", "4");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.42");
        relocationTSDCardPage.verifyData("dataPacking", "42-5-4-2-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.42 ➡ C.1.1.1.42 00042 Стол42 Quantity 4");
        relocationTSDCardPage.clickButton("moving");
    //Стол43
        relocationTSDCardPage.inputData("source", "B.1.1.1.43");
        relocationTSDCardPage.inputData("product", "00043");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.43");
        relocationTSDCardPage.verifyData("dataPacking", "43-5-4-10-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.43 ➡ C.1.1.1.43 00043 Стол43 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол44
        relocationTSDCardPage.inputData("source", "B.1.1.1.44");
        relocationTSDCardPage.inputData("product", "00044");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.44");
        relocationTSDCardPage.verifyData("dataPacking", "44-5-4-5-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.44 ➡ C.1.1.1.44 00044 Стол44 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол45
        relocationTSDCardPage.inputData("source", "B.1.1.1.45");
        relocationTSDCardPage.inputData("product", "00045");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.45");
        relocationTSDCardPage.verifyData("dataPacking", "45-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.45 ➡ C.1.1.1.45 00045 Стол45 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол46
        relocationTSDCardPage.inputData("source", "B.1.1.1.46");
        relocationTSDCardPage.inputData("product", "2110046100000");
        relocationTSDCardPage.verifyData("qty", "10.0");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.46");
        relocationTSDCardPage.verifyData("dataPacking", "46-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.46 ➡ C.1.1.1.46 00046 Стол46 Quantity 10.0");
        relocationTSDCardPage.clickButton("moving");
    //Стол47
        relocationTSDCardPage.inputData("source", "B.1.1.1.47");
        relocationTSDCardPage.inputData("product", "2110047100000");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.47");
        relocationTSDCardPage.verifyData("dataPacking", "47-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.47 ➡ C.1.1.1.47 00047 Стол47 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол48
        relocationTSDCardPage.inputData("source", "B.1.1.1.48");
        relocationTSDCardPage.inputData("product", "00048");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.48");
        relocationTSDCardPage.verifyData("dataPacking", "48-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.48 ➡ C.1.1.1.48 00048 Стол48 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол49
        relocationTSDCardPage.inputData("source", "B.1.1.1.49");
        relocationTSDCardPage.inputData("product", "49FRAGSN49Series013112202200");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.49");
        relocationTSDCardPage.verifyData("dataPacking", "49-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.49 ➡ C.1.1.1.49 00049 Стол49 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    //Стол50
        relocationTSDCardPage.inputData("source", "B.1.1.1.50");
        relocationTSDCardPage.inputData("product", "00050");
        relocationTSDCardPage.inputData("qty", "10");
        relocationTSDCardPage.inputData("destination", "C.1.1.1.50");
        relocationTSDCardPage.verifyData("dataPacking", "50-5-4-3-1");
        relocationTSDCardPage.verifyData("productInfo", "B.1.1.1.50 ➡ C.1.1.1.50 00050 Стол50 Quantity 10");
        relocationTSDCardPage.clickButton("moving");
    }

    @Test (priority = 7, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол41
        selectionCardPage.verifyData("productInfo", "00041 41Series01 31.12.2022 Стол41 C.1.1.1.41 ➡ KT1.01.01.01.01 Packing 41-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.41");
        selectionCardPage.inputData("product", "00041");
        selectionCardPage.inputData("destination", "OUT141");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол42
        selectionCardPage.verifyData("productInfo", "00042 Стол42 C.1.1.1.42 ➡ KT1.01.01.01.01 Packing 42-5-4-3-1 Quantity 6 шт");
        selectionCardPage.inputData("source", "C.1.1.1.42");
        selectionCardPage.inputData("product", "00042");
        selectionCardPage.inputData("destination", "OUT142");
        selectionCardPage.inputData("qty", "6");
        selectionCardPage.clickButton("commit");
    //Стол42
        selectionCardPage.verifyData("productInfo", "00042 Стол42 C.1.1.1.42 ➡ KT1.01.01.01.01 Packing 42-5-4-2-1 Quantity 4 шт");
        selectionCardPage.inputData("source", "C.1.1.1.42");
        selectionCardPage.inputData("product", "00042");
        selectionCardPage.inputData("destination", "OUT142");
        selectionCardPage.inputData("qty", "4");
        selectionCardPage.clickButton("commit");
    //Стол43
        selectionCardPage.verifyData("productInfo", "00043 Стол43 C.1.1.1.43 ➡ KT1.01.01.01.01 Packing 43-5-4-10-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.43");
        selectionCardPage.inputData("product", "00043");
        selectionCardPage.inputData("destination", "OUT143");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол44
        selectionCardPage.verifyData("productInfo", "00044 Стол44 C.1.1.1.44 ➡ KT1.01.01.01.01 Packing 44-5-4-5-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.44");
        selectionCardPage.inputData("product", "00044");
        selectionCardPage.inputData("destination", "OUT144");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол45
        selectionCardPage.verifyData("productInfo", "00045 Стол45 C.1.1.1.45 ➡ KT1.01.01.01.01 Packing 45-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.45");
        selectionCardPage.inputData("product", "00045");
        selectionCardPage.inputData("destination", "OUT145");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол46
        selectionCardPage.verifyData("productInfo", "00046 Стол46 C.1.1.1.46 ➡ KT1.01.01.01.01 Packing 46-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.46");
        selectionCardPage.inputData("product", "2110046100000");
        selectionCardPage.inputData("destination", "OUT146");
        selectionCardPage.verifyData("qty", "10.000");
        selectionCardPage.clickButton("commit");
    //Стол47
        selectionCardPage.verifyData("productInfo", "00047 Стол47 C.1.1.1.47 ➡ KT1.01.01.01.01 Packing 47-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.47");
        selectionCardPage.inputData("product", "2110047100000");
        selectionCardPage.inputData("destination", "OUT147");
        selectionCardPage.verifyData("qty", "1.000");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол48
        selectionCardPage.verifyData("productInfo", "00048 Стол48 C.1.1.1.48 ➡ KT1.01.01.01.01 Packing 48-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.48");
        selectionCardPage.inputData("product", "00048"); //TODO bug не распознает 48SnPack00
        selectionCardPage.inputSN("unique","48", 10);
        selectionCardPage.inputData("destination", "OUT148");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол49
        selectionCardPage.verifyData("productInfo", "00049 Стол49 C.1.1.1.49 ➡ KT1.01.01.01.01 Packing 49-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.49");
        selectionCardPage.inputData("product","49FRAGSN49Series013112202200");
        selectionCardPage.inputSN("sn","49", 10);
        selectionCardPage.inputData("destination", "OUT149");
        selectionCardPage.verifyData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол50
        selectionCardPage.verifyData("productInfo", "00050 Стол50(0.2) C.1.1.1.50 ➡ KT1.01.01.01.01 Packing 50-5-4-3-1 Quantity 10 шт");
        selectionCardPage.inputData("source", "C.1.1.1.50");
        selectionCardPage.inputData("product", "00050");
        selectionCardPage.inputData("destination", "OUT150");
        selectionCardPage.inputData("qty", "12");
        selectionCardPage.inputData("tareQty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 8, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Контейнер (Selection)");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол41
        containerCardPage.verifyData("containerInfo", "CON/OUT141 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT141");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол42
        containerCardPage.verifyData("containerInfo", "CON/OUT142 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT142");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол43
        containerCardPage.verifyData("containerInfo", "CON/OUT143 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT143");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол44
        containerCardPage.verifyData("containerInfo", "CON/OUT144 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT144");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол45
        containerCardPage.verifyData("containerInfo", "CON/OUT145 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT145");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол46
        containerCardPage.verifyData("containerInfo", "CON/OUT146 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT146");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол47
        containerCardPage.verifyData("containerInfo", "CON/OUT147 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT147");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол48
        containerCardPage.verifyData("containerInfo", "CON/OUT148 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT148");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол49
        containerCardPage.verifyData("containerInfo", "CON/OUT149 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT149");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол50
        containerCardPage.verifyData("containerInfo", "CON/OUT150 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT150");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    }

    @Test (priority = 9, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        mobileSteps.loginAsAdmin();
        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол41
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT141");
        controlCardPage.verifyData("productInfo", "00041 Стол41");
        controlCardPage.verifyData("seriesInfo", "41Series01");
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2022");
        controlCardPage.verifyData("containerInfo", "OUT141");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00041");
        mobileFormBatchProperties.select(true, true,"41Series01","31.12.2022");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол42
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT142");
        controlCardPage.verifyData("productInfo", "00042 Стол42");
        controlCardPage.verifyData("containerInfo", "OUT142");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00042");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол43
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT143");
        controlCardPage.verifyData("productInfo", "00043 Стол43");
        controlCardPage.verifyData("containerInfo", "OUT143");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00043");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол44
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT144");
        controlCardPage.verifyData("productInfo", "00044 Стол44");
        controlCardPage.verifyData("containerInfo", "OUT144");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00044");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол45
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT145");
        controlCardPage.verifyData("productInfo", "00045 Стол45");
        controlCardPage.verifyData("containerInfo", "OUT145");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00045");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол46
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT146");
        controlCardPage.verifyData("productInfo", "00046 Стол46");
        controlCardPage.verifyData("containerInfo", "OUT146");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","2110046100000");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол47
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT147");
        controlCardPage.verifyData("productInfo", "00047 Стол47");
        controlCardPage.verifyData("containerInfo", "OUT147");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","2110047100000");
        controlCardPage.getControlledQty(1).shouldHave(text("1"));
        controlCardPage.inputData("qty","9");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол48
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT148");
        controlCardPage.verifyData("productInfo", "00048 Стол48");
        controlCardPage.verifyData("containerInfo", "OUT148");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00048");
        controlCardPage.inputSN("unique","48", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол49
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT149");
        controlCardPage.verifyData("productInfo", "00049 Стол49");
        controlCardPage.verifyData("containerInfo", "OUT149");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","49FRAGSN49Series013112202200");
        controlCardPage.inputSN("sn","49", 10);
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickButton("commit");
    //Стол50
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT150");
        controlCardPage.verifyData("productInfo", "00050 Стол50");
        controlCardPage.verifyData("containerInfo", "OUT150");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00050");
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
        packagingCardPage.checkCellProductInfoInRow2(1, "OUT141", "10", "0.1", "50", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(2, "OUT142", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(3, "OUT143", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(4, "OUT144", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(5, "OUT145", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(6, "OUT146", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(7, "OUT147", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(8, "OUT148", "10", "0.1", "10", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(9, "OUT149", "10", "1", "1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(10, "OUT150", "10", "0.1", "10", "1", "1");

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