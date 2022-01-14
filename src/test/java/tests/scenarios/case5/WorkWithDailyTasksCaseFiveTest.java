package tests.scenarios.case5;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static tests.utils.ModalDialogs.*;

public class WorkWithDailyTasksCaseFiveTest extends BaseMobileClass{
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
    RelocationCardPage relocationCardPage = new RelocationCardPage();
    RelocationTSDCardPage relocationTSDCardPage = new RelocationTSDCardPage();

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();
        receptionCardPage.andrDriver("source");
    //Стол41
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00041");
        receptionCardPage.inputBatchProperties(true, false,"input","41Series01","");
        receptionCardPage.verifyData("productInfo", "00041 Стол41 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол42
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00042");
        receptionCardPage.inputBatchProperties(false, true,"input","","31.12.2022");
        receptionCardPage.verifyData("productInfo", "00042 Стол42 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "10-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.selectModalDialog("unitAmount","10.0");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол44
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00044");
        receptionCardPage.verifyData("productInfo", "00044 Стол44 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "10-5-2-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол45
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00045");

        receptionCardPage.clickButton("newSku");
        receptionCardPage.clickButton("palletFlag");
        receptionCardPage.inputData("pallet","10");
        receptionCardPage.clickButton("layerFlag");
        receptionCardPage.inputData("layer","4");
        receptionCardPage.clickButton("boxFlag");
        receptionCardPage.inputData("box","5");
        receptionCardPage.clickButton("modalDialogOK");

        receptionCardPage.verifyData("modalDialogTitle", "шт");
        receptionCardPage.verifyData("skuQty", "1");
        receptionCardPage.verifyData("skuName", "блок");
        receptionCardPage.inputData("widthSKU","0.1");
        receptionCardPage.inputData("lenghtSKU","0.1");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","1");
        receptionCardPage.clickButton("modalDialogOK");


        receptionCardPage.verifyData("productInfo", "00045 Стол44 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("package", "10-5-2-1");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    }
}
