package tests.scenarios.case3;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.Actions.hideKeyboard;
import static tests.utils.Actions.scrollElement;
import static tests.utils.ModalDialogs.*;
import static tests.utils.ModalDialogs.clickSetOkYesButton;

public class WorkWithDailyTasksCaseThreeTest extends BaseMobileClass {

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

    /**
     * All tests run on Regress/DT/Case3/wms_regress_case3_Reception DB
     * All tests run according to TestNG priority.
     * If test fails - next one will be skipped according to TestNG dependsOnMethods
     */

    @Test
    public void processingNegativeReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол21
        receptionCardPage.verifyData("productInfo", "00021 Стол21 IN.01 Quantity 10 уп. (5)");
        receptionCardPage.inputData("source", "IN.02");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The control box does not match the task"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("source", "IN");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The control box does not match the task"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("source", "000021");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The control box does not match the task"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("source", "IN.01");
        getMessageModalDialog().shouldNotBe(visible);
        receptionCardPage.inputData("product","IN.01");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN.01"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("product","IN");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("product","00001");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 00001"));
        clickErrorDialogOkButton();
        receptionCardPage.checkAmountAndPackaging("1.0", "10");
        receptionCardPage.inputData("product","00002102");
        getMessageModalDialog().shouldNotBe(visible);
        receptionCardPage.inputData("container","IN.01");
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Not found on the CC Container:IN.01"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("container","00001");
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Not found on the CC Container:00001"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("container","00002102");
        receptionCardPage.checkAmountAndPackaging("5.0", "2");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Not found on the CC Container:00002102"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","3");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Can not handle15. Remaining 10"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldNotBe(visible);
    //Стол22
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("container","IN1");

        receptionCardPage.verifyData("productInfo", "00022 Стол22 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","2120021020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 2120021020000"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("product","2110022020000");
        receptionCardPage.verifyData("qty", "2.000");
        receptionCardPage.inputData("product","2110023020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The product doesn't match the task: 00023 [series] [use] [shelf_life] Стол23"));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("product","2110022140000");
        receptionCardPage.verifyData("qty", "16.000");
        receptionCardPage.inputData("product","2110022090000");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Can not handle19. Remaining 10"));
        clickErrorDialogOkButton();
        receptionCardPage.clickButton("clearProductInput");
        receptionCardPage.clickButton("clearProductInput");
        receptionCardPage.inputData("product","2110022100000");
        //receptionCardPage.getQuantityInput().shouldHave(exactText("10.000"));
        receptionCardPage.verifyData("qty", "20.000");//TODO bag необходимо очищать кл-во после очистки продакт
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
    //Стол23
        receptionCardPage.verifyData("productInfo", "00023 Стол23 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","2110023020000");
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("expirationDate","01.04.21");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Shelf life 01.04.2021 in the past - are you really holding on an expired product?"));
        clickErrorDialogOkButton();
        clickErrorDialogOkButton();//TODO bag
        //добавлена защита от дурака, ввести 99.99.9999 нет возможности
//        receptionCardPage.inputData("expirationDate","99.99.9999");
//        getMessageModalDialog().shouldBe(visible).shouldHave(text("Incorrect date value"));
//        clickErrorDialogOkButton();
        receptionCardPage.inputData("expirationDate","31.12.21");
        clickSetOkYesButton();
        receptionCardPage.verifyData("productInfo", "00023 31.12.2021 Стол23 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("qty", "2.000");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","2110023055000");
        receptionCardPage.clickButton("cancel");//TODO
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("expirationDate","30.12.21");
        clickSetOkYesButton();
        receptionCardPage.verifyData("productInfo", "00023 30.12.2021 Стол23 IN.01 Quantity 8 шт");
        receptionCardPage.verifyData("qty", "5.500");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
        receptionCardPage.verifyData("productInfo", "00023 Стол23 IN.01 Quantity 2.5 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","2110023025000");
        receptionCardPage.clickButton("cancel");//TODO
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("expirationDate","31.12.2021");
        clickSetOkYesButton();
        receptionCardPage.verifyData("productInfo", "00023 31.12.2021 Стол23 IN.01 Quantity 2.5 шт");
        receptionCardPage.verifyData("qty", "2.500");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
    //Стол24
        receptionCardPage.verifyData("productInfo", "00024 Стол24 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","2110024020000");
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("newSeries","24Series01");
        clickSetOkYesButton();
        receptionCardPage.verifyData("productInfo", "00024 24Series01 Стол24 IN.01 Quantity 10 шт");
        receptionCardPage.verifyData("qty", "2.000");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
        receptionCardPage.verifyData("productInfo", "00024 Стол24 IN.01 Quantity 8 шт");
        receptionCardPage.inputData("product","2110024075000");
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("newSeries","24Series02");
        clickSetOkYesButton();
        receptionCardPage.verifyData("productInfo", "00024 24Series02 Стол24 IN.01 Quantity 8 шт");
        receptionCardPage.verifyData("qty", "7.500");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
        receptionCardPage.verifyData("productInfo", "00024 Стол24 IN.01 Quantity 0.5 шт");
        receptionCardPage.inputData("product","2110024005000");
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("newSeries","24Series02");
        clickSetOkYesButton();
        receptionCardPage.verifyData("productInfo", "00024 24Series02 Стол24 IN.01 Quantity 0.5 шт");
        receptionCardPage.verifyData("qty", "0.500");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.clickButton("commit");
    //Стол25
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00025");
        receptionCardPage.verifyData("productInfo", "00025 Стол25 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("palletWeight", "2");
        receptionCardPage.inputData("tareQty", "5");
        receptionCardPage.inputData("tareWeight", "0.2");
        receptionCardPage.inputData("qty","2");
        receptionCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The total weight, taking into account the weight of the pallet and the tare weight, cannot be equal to zero."));
        clickErrorDialogOkButton();
        receptionCardPage.inputData("qty","13");
        receptionCardPage.clickButton("commit");
    //Стол26
        receptionCardPage.verifyData("productInfo", "00026 Стол26 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","00026");
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("newSeries","26series01");
        clickSetOkYesButton();
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("palletWeight", "2");
        receptionCardPage.inputData("tareQty", "5");
        receptionCardPage.inputData("tareWeight", "0.2");
        receptionCardPage.inputData("qty","13");
        receptionCardPage.clickButton("commit");
    //Стол27
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00027 Стол27 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","00027");
        receptionCardPage.clickButton("cancel");//TODO
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("expirationDate","31.12.2021");
        clickSetOkYesButton();
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("palletWeight", "2");
        receptionCardPage.inputData("tareQty", "5");
        receptionCardPage.inputData("tareWeight", "0.2");
        receptionCardPage.inputData("qty","13");
        receptionCardPage.clickButton("commit");
    //Стол28
        receptionCardPage.verifyData("productInfo", "00028 Стол28 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","00028");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол29
        receptionCardPage.verifyData("productInfo", "00029 Стол29 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","00029");
        receptionCardPage.verifyData("modalDialogTitle", "Batch properties");
        receptionCardPage.inputData("newSeries","29Series01");
        clickSetOkYesButton();
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол30
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.verifyData("productInfo", "00030 Стол30 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","00030");
        receptionCardPage.verifyData("modalDialogTitle", "SKU info");
        receptionCardPage.clickButton("selectBarcode");//MNV_доработать выбор ШК
        receptionCardPage.clickButton("editBarcode");
        //receptionCardPage.inputData("widthSKU","0.1");//MNV_доработать ввод
        receptionCardPage.inputData("lenghtSKU","0.2");
        receptionCardPage.inputData("heightSKU","0.1");
        receptionCardPage.inputData("weightSKU","0.4");
        clickSetOkYesButton();
        clickSetOkYesButton();
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    }

    @Test (priority = 1, dependsOnMethods = "processingNegativeReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception{
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол21
        accommodationCardPage.inputData("source","IN.02");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Source does not match the task"));
        clickErrorDialogOkButton();
        accommodationCardPage.verifyData("productInfo", "00021 Стол21 IN.01 ➡ R.1.1.1.1 Quantity 10 уп. (5)");
        accommodationCardPage.inputData("source","IN");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Source does not match the task"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("source","IN.01");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Source does not match the task"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("source","IN1");
        getMessageModalDialog().shouldNotBe(visible);
        accommodationCardPage.inputData("product","IN.01");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN.01"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("product","IN");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: IN"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("product","00001");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 00001"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("product","00002102");
        getMessageModalDialog().shouldNotBe(visible);
        accommodationCardPage.inputData("destination","A.1.1.1.1");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Location was changed. Continue?"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("destination","B.1.1.1.1");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Location was changed. Continue?"));
        clickSetOkYesButton();
        accommodationCardPage.checkAmountAndPackaging("5.0", "2");
        accommodationCardPage.inputData("qty","3");
        accommodationCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("It is impossible to confirm15. Remaining 10"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("qty","2");
        accommodationCardPage.clickButton("commit");
        getMessageModalDialog().shouldNotBe(visible);
    //Стол22
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.verifyData("productInfo", "00022 Стол22 IN.01 ➡ B.1.1.1.2 Quantity 10 шт");
        accommodationCardPage.inputData("product","2120021020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("Couldn't find the product by code: 2120021020000"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("product","2110022020000");
        accommodationCardPage.verifyData("qty","2.000");
        accommodationCardPage.inputData("product","2110023020000");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("The entered BC does not correspond to the current task!"));
        clickErrorDialogOkButton();
        accommodationCardPage.inputData("product","2110022140000");
        accommodationCardPage.verifyData("qty","16.000");
        accommodationCardPage.inputData("destination","B.1.1.1.2");
        accommodationCardPage.clickButton("commit");
        getMessageModalDialog().shouldBe(visible).shouldHave(text("It is impossible to confirm16. Remaining 10"));
        clickErrorDialogOkButton();
        accommodationCardPage.clearQuantityInput();//TODO bag нет возможности очистить келичество, крестик не активен
        accommodationCardPage.inputData("product","2110022100000");
        accommodationCardPage.verifyData("qty","10.000");
        accommodationCardPage.clickButton("commit");
    //Стол23
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.verifyData("productInfo", "00023 30.12.2021 Стол23 IN.01 ➡ B.1.1.1.3 Quantity 5.5 шт");
        accommodationCardPage.inputData("product","2110023055000");
        accommodationCardPage.inputData("destination","B.1.1.1.3");
        accommodationCardPage.clickButton("commit");
    //Стол23
        accommodationCardPage.verifyData("productInfo", "00023 31.12.2021 Стол23 IN.01 ➡ B.1.1.1.3 Quantity 4.5 шт");
        accommodationCardPage.inputData("product","2110023045000");
        accommodationCardPage.inputData("destination","B.1.1.1.3");
        accommodationCardPage.clickButton("commit");
    //Стол24
        accommodationCardPage.verifyData("productInfo", "00024 24Series01 Стол24 IN.01 ➡ B.1.1.1.4 Quantity 2 шт");
        accommodationCardPage.inputData("product","2110024020000");
        accommodationCardPage.inputData("destination","B.1.1.1.4");
        accommodationCardPage.clickButton("commit");
    //Стол24
        accommodationCardPage.verifyData("productInfo", "00024 24Series02 Стол24 IN.01 ➡ B.1.1.1.4 Quantity 8 шт");
        accommodationCardPage.inputData("product","2110024080000");
        accommodationCardPage.inputData("destination","B.1.1.1.4");
        accommodationCardPage.clickButton("commit");
    //Стол25
        accommodationCardPage.verifyData("productInfo", "00025 Стол25(0.2) IN.01 ➡ B.1.1.1.5 Quantity 10 шт");
        accommodationCardPage.inputData("product","00025");
        accommodationCardPage.inputData("destination","B.1.1.1.5");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол26
        accommodationCardPage.verifyData("productInfo", "00026 26series01 Стол26(0.2) IN.01 ➡ B.1.1.1.6 Quantity 10 шт");
        accommodationCardPage.inputData("product","00026");
        accommodationCardPage.inputData("destination","B.1.1.1.6");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол27
        accommodationCardPage.verifyData("productInfo", "00027 31.12.2021 Стол27(0.2) IN.01 ➡ B.1.1.1.7 Quantity 10 шт");
        accommodationCardPage.inputData("product","00027");
        accommodationCardPage.inputData("destination","B.1.1.1.7");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол28
        accommodationCardPage.verifyData("productInfo", "00028 Стол28 IN.01 ➡ B.1.1.1.8 Quantity 10 шт");
        accommodationCardPage.inputData("product","00028");
        accommodationCardPage.inputData("destination","B.1.1.1.8");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол29
        accommodationCardPage.verifyData("productInfo", "00029 29Series01 Стол29 IN.01 ➡ B.1.1.1.9 Quantity 10 шт");
        accommodationCardPage.inputData("product","00029");
        accommodationCardPage.inputData("destination","B.1.1.1.9");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол30
        accommodationCardPage.verifyData("productInfo", "00030 Стол30 IN.01 ➡ B.1.1.1.10 Quantity 10 шт");
        accommodationCardPage.inputData("product","00030");
        accommodationCardPage.inputData("destination","B.1.1.1.10");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
        }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
    //Стол21
        findRestsPage.inputData("product", "00002102");
        findRestsPage.verifyData("productInfo", "00021 Стол21");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.1");
        findRestsPage.verifyData("qty", "10");
    //Стол22
        findRestsPage.inputData("product", "2110022020000");
        findRestsPage.verifyData("productInfo", "00022 Стол22");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.2");
        findRestsPage.verifyData("qty", "10");
    //Стол23
        findRestsPage.inputData("product", "2110023055000");
        findRestsPage.verifyData("productInfo", "00023 Стол23");
        findRestsPage.checkLocationString1("B.1.1.1.3");
        findRestsPage.checkPartyInfoString1("30.12.2021");
        findRestsPage.getQuantityString1().shouldHave(exactText("5.5"));
        findRestsPage.checkLocationString2("B.1.1.1.3");
        findRestsPage.checkPartyInfoString2("31.12.2021");
        findRestsPage.getQuantityString2().shouldHave(exactText("4.5"));
    //Стол24
        findRestsPage.inputData("product", "00024");
        findRestsPage.verifyData("productInfo", "00024 Стол24");
        findRestsPage.checkLocationString1("B.1.1.1.4");
        findRestsPage.checkPartyInfoString1("24Series01");
        findRestsPage.getQuantityString1().shouldHave(exactText("2"));
        findRestsPage.checkLocationString2("B.1.1.1.4");
        findRestsPage.checkPartyInfoString2("24Series02");
        findRestsPage.getQuantityString2().shouldHave(exactText("8"));
    //Стол25
        findRestsPage.inputData("product", "00025");
        findRestsPage.verifyData("productInfo", "00025 Стол25");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.5");
        findRestsPage.verifyData("qty", "10");
    //Стол26
        findRestsPage.inputData("product", "00026");
        findRestsPage.verifyData("productInfo", "00026 Стол26");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "26series01");
    //Стол27
        findRestsPage.inputData("product", "00027");
        findRestsPage.verifyData("productInfo", "00027 Стол27");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
    //Стол28
        findRestsPage.inputData("product", "00028");
        findRestsPage.verifyData("productInfo", "00028 Стол28");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
    //Стол29
        findRestsPage.inputData("product", "00029");
        findRestsPage.verifyData("productInfo", "00029 Стол29");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.9");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "29Series01");
    //Стол30
        findRestsPage.inputData("product", "00030");
        findRestsPage.verifyData("productInfo", "00030 Стол30");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.10");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.getStringTasks(2).click();

    //Стол21
        inventoryCardPage.inputData("source", "B.1.1.1.1");
        inventoryCardPage.inputData("product", "00002102");
        inventoryCardPage.verifyData("productInfo", "00021 Стол21");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.getProductUnit().shouldHave(exactText("5.0"));
        inventoryCardPage.inputData("qty","2");
        inventoryCardPage.verifyData("itemViewInfo", "00021 Стол21");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол22
        inventoryCardPage.inputData("source", "B.1.1.1.2");
        inventoryCardPage.inputData("product", "2110022100000");
        inventoryCardPage.verifyData("productInfo", "00022 Стол22");
        inventoryCardPage.selectData("quality", "Кондиция");
        //inventoryCardPage.getProductQuantity().shouldHave(exactText("10.000"));
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "00022 Стол22");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол23
        inventoryCardPage.inputData("source", "B.1.1.1.3");
        inventoryCardPage.inputData("product", "2110023055000");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("30.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("30.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00023 30.12.2021 Стол23");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("qty", "5.500");
        inventoryCardPage.inputData("qty","5.5");
        inventoryCardPage.verifyData("itemViewInfo", "00023 30.12.2021 Стол23");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "5.5");
    //Стол23
        inventoryCardPage.inputData("product", "2110023045000");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDateZ23().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDateZ23().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00023 31.12.2021 Стол23");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("qty", "4.500");
        inventoryCardPage.inputData("qty","4.5");
        inventoryCardPage.verifyData("itemViewInfo", "00023 31.12.2021 Стол23");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "4.5");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол24
        inventoryCardPage.inputData("source", "B.1.1.1.4");
        inventoryCardPage.inputData("product", "2110024020000");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries1().shouldHave(text("24Series01"));
        inventoryCardPage.getAvailableSeries1().click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00024 24Series01 Стол24");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("qty", "2.000");
        inventoryCardPage.inputData("qty","2");
        inventoryCardPage.verifyData("itemViewInfo", "0002 Series2 Стол2");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "2.0");
    //Стол24
        inventoryCardPage.inputData("product", "2110024080000");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries2().shouldHave(text("24Series02"));
        inventoryCardPage.getAvailableSeries2().click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00024 24Series02 Стол24");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.verifyData("qty", "8.000");
        inventoryCardPage.inputData("qty","8");
        inventoryCardPage.verifyData("itemViewInfo", "0002 Series2 Стол2");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "8.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол25
        inventoryCardPage.inputData("source", "B.1.1.1.5");
        inventoryCardPage.inputData("product", "00025");
        inventoryCardPage.verifyData("productInfo", "00025 Стол25");
        inventoryCardPage.inputData("palletWeight", "2");
        inventoryCardPage.inputData("tareQty", "5");
        inventoryCardPage.inputData("tareWeight", "0.2");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","13");
        inventoryCardPage.verifyData("itemViewInfo", "00025 Стол25");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол26
        inventoryCardPage.inputData("source", "B.1.1.1.6");
        inventoryCardPage.inputData("product", "00026");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("26series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00026 26Series01 Стол26");
        inventoryCardPage.inputData("palletWeight", "2");
        inventoryCardPage.inputData("tareQty", "5");
        inventoryCardPage.inputData("tareWeight", "0.2");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","13");
        inventoryCardPage.verifyData("itemViewInfo", "0002 Series2 Стол2");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол27
        inventoryCardPage.inputData("source", "B.1.1.1.7");
        inventoryCardPage.inputData("product", "00027");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00027 31.12.2021 Стол27");
        inventoryCardPage.inputData("palletWeight", "2");
        inventoryCardPage.inputData("tareQty", "5");
        inventoryCardPage.inputData("tareWeight", "0.2");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","13");
        inventoryCardPage.verifyData("itemViewInfo", "0003 31.12.2021 Стол3");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол28
        inventoryCardPage.inputData("source", "B.1.1.1.8");
        inventoryCardPage.inputData("product", "00028");
        inventoryCardPage.verifyData("productInfo", "00028 Стол28");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        //inventoryCardPage.getItemViewInfo().shouldHave(text("0004 Стол4"));
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол29
        inventoryCardPage.inputData("source", "B.1.1.1.9");
        inventoryCardPage.inputData("product", "00029");
        inventoryCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries().shouldHave(text("29series01"));
        inventoryCardPage.getAvailableSeries().click();
        inventoryCardPage.clickButton("ok");
        inventoryCardPage.verifyData("productInfo", "00029 29Series01 Стол29");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0002 Series2 Стол2");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    //Стол30
        inventoryCardPage.inputData("source", "B.1.1.1.10");
        inventoryCardPage.inputData("product", "00030");
        inventoryCardPage.verifyData("productInfo", "00030 Стол30");
        inventoryCardPage.selectData("quality", "Кондиция");
        inventoryCardPage.inputData("qty","10");
        inventoryCardPage.verifyData("itemViewInfo", "0004 Стол4");
        inventoryCardPage.verifyData("qualityInfo", "Кондиция");
        inventoryCardPage.verifyData("qtyViewInfo", "10.0");
        inventoryCardPage.clickButtonAndConfirm("inventory");
    }

    @Test (priority = 4, dependsOnMethods = "processingInventoryTaskTest")
    public void checkingFreeAmountAfterProcessingInventoryTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
        //Стол21
        findRestsPage.inputData("product", "00002102");
        findRestsPage.verifyData("productInfo", "00021 Стол21");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.1");
        findRestsPage.verifyData("qty", "10");
        //Стол22
        findRestsPage.inputData("product", "2110022020000");
        findRestsPage.verifyData("productInfo", "00022 Стол22");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.2");
        findRestsPage.verifyData("qty", "10");
        //Стол23
        findRestsPage.inputData("product", "2110023055000");
        findRestsPage.verifyData("productInfo", "00023 Стол23");
        findRestsPage.checkLocationString1("B.1.1.1.3");
        findRestsPage.checkPartyInfoString1("30.12.2021");
        findRestsPage.getQuantityString1().shouldHave(exactText("5.5"));
        findRestsPage.checkLocationString2("B.1.1.1.3");
        findRestsPage.checkPartyInfoString2("31.12.2021");
        findRestsPage.getQuantityString2().shouldHave(exactText("4.5"));
        //Стол24
        findRestsPage.inputData("product", "00024");
        findRestsPage.verifyData("productInfo", "00024 Стол24");
        findRestsPage.checkLocationString1("B.1.1.1.4");
        findRestsPage.checkPartyInfoString1("24Series01");
        findRestsPage.getQuantityString1().shouldHave(exactText("2"));
        findRestsPage.checkLocationString2("B.1.1.1.4");
        findRestsPage.checkPartyInfoString2("24Series02");
        findRestsPage.getQuantityString2().shouldHave(exactText("8"));
        //Стол25
        findRestsPage.inputData("product", "00025");
        findRestsPage.verifyData("productInfo", "00025 Стол25");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.5");
        findRestsPage.verifyData("qty", "10");
        //Стол26
        findRestsPage.inputData("product", "00026");
        findRestsPage.verifyData("productInfo", "00026 Стол26");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.6");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "26series01");
        //Стол27
        findRestsPage.inputData("product", "00027");
        findRestsPage.verifyData("productInfo", "00027 Стол27");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.7");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("ShelfLifeInfoString1", "31.12.2021");
        //Стол28
        findRestsPage.inputData("product", "00028");
        findRestsPage.verifyData("productInfo", "00028 Стол28");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.8");
        findRestsPage.verifyData("qty", "10");
        //Стол29
        findRestsPage.inputData("product", "00029");
        findRestsPage.verifyData("productInfo", "00029 Стол29");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.9");
        findRestsPage.verifyData("qty", "10");
        findRestsPage.verifyData("SeriesInfoString1", "29Series01");
        //Стол30
        findRestsPage.inputData("product", "00030");
        findRestsPage.verifyData("productInfo", "00030 Стол30");
        findRestsPage.verifyData("sourceInfo", "B.1.1.1.10");
        findRestsPage.verifyData("qty", "10");
    }

    @Test (priority = 5, dependsOnMethods = "processingAccommodationTaskTest")
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол21
        selectionCardPage.verifyData("productInfo", "00021 Стол21 B.1.1.1.1 ➡ KT1.01.01.01.01 Quantity 10 уп. (5)");
        selectionCardPage.inputData("source", "B.1.1.1.1");
        selectionCardPage.inputData("product", "00021");
        selectionCardPage.inputData("destination", "OUT121");
        selectionCardPage.inputData("qty", "2");
        selectionCardPage.clickButton("commit");
    //Стол22
        selectionCardPage.verifyData("productInfo", "00022 Стол22 B.1.1.1.2 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.2");
        selectionCardPage.inputData("product", "2110022100000");
        selectionCardPage.inputData("destination", "OUT122");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол23
        selectionCardPage.verifyData("productInfo", "00023 30.12.2021 Стол23 B.1.1.1.3 ➡ KT1.01.01.01.01 Quantity 5.5 шт");
        selectionCardPage.inputData("source", "B.1.1.1.3");
        selectionCardPage.inputData("product", "2110023055000");
        selectionCardPage.inputData("destination", "OUT123");
        selectionCardPage.inputData("qty", "5.5");
        selectionCardPage.clickButton("commit");
    //Стол23
        selectionCardPage.verifyData("productInfo", "00023 31.12.2021 Стол23 B.1.1.1.3 ➡ KT1.01.01.01.01 Quantity 4.5 шт");
        selectionCardPage.inputData("source", "B.1.1.1.3");
        selectionCardPage.inputData("product", "2110023045000");
        selectionCardPage.inputData("destination", "OUT123");
        selectionCardPage.inputData("qty", "4.5");
        selectionCardPage.clickButton("commit");
    //Стол24
        selectionCardPage.verifyData("productInfo", "00024 24Series01 Стол24 B.1.1.1.4 ➡ KT1.01.01.01.01 Quantity 2 шт");
        selectionCardPage.inputData("source", "B.1.1.1.4");
        selectionCardPage.inputData("product", "2110024020000");
        selectionCardPage.inputData("destination", "OUT124");
        selectionCardPage.inputData("qty", "2");
        selectionCardPage.clickButton("commit");
    //Стол24
        selectionCardPage.verifyData("productInfo", "00024 24Series02 Стол24 B.1.1.1.4 ➡ KT1.01.01.01.01 Quantity 8 шт");
        selectionCardPage.inputData("source", "B.1.1.1.4");
        selectionCardPage.inputData("product", "2110024080000");
        selectionCardPage.inputData("destination", "OUT124");
        selectionCardPage.inputData("qty", "8");
        selectionCardPage.clickButton("commit");
    //Стол25
        selectionCardPage.verifyData("productInfo", "00025 Стол25(0.2) B.1.1.1.5 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.5");
        selectionCardPage.inputData("product", "00025");
        selectionCardPage.inputData("destination", "OUT125");
        selectionCardPage.inputData("qty", "12");
        selectionCardPage.inputData("tareQty", "10");
        selectionCardPage.clickButton("commit");
    //Стол26
        selectionCardPage.verifyData("productInfo", "00026 26series01 Стол26(0.2) B.1.1.1.6 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.6");
        selectionCardPage.inputData("product", "OUT126");
        selectionCardPage.inputData("destination", "");
        selectionCardPage.inputData("qty", "12");
        selectionCardPage.inputData("tareQty", "10");
        selectionCardPage.clickButton("commit");
    //Стол27
        selectionCardPage.verifyData("productInfo", "00027 31.12.2021 Стол27(0.2) B.1.1.1.7 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.7");
        selectionCardPage.inputData("product", "00027");
        selectionCardPage.inputData("destination", "OUT127");
        selectionCardPage.inputData("qty", "12");
        selectionCardPage.inputData("tareQty", "10");
        selectionCardPage.clickButton("commit");
    //Стол28
        selectionCardPage.verifyData("productInfo", "00028 Стол28 B.1.1.1.8 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.8");
        selectionCardPage.inputData("product", "00028");
        selectionCardPage.inputData("destination", "OUT128");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол29
        selectionCardPage.verifyData("productInfo", "00029 29Series01 Стол29 B.1.1.1.9 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.9");
        selectionCardPage.inputData("product", "00029");
        selectionCardPage.inputData("destination", "OUT129");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    //Стол30
        selectionCardPage.verifyData("productInfo", "00030 Стол30 B.1.1.1.10 ➡ KT1.01.01.01.01 Quantity 10 шт");
        selectionCardPage.inputData("source", "B.1.1.1.10");
        selectionCardPage.inputData("product", "00030");
        selectionCardPage.inputData("destination", "OUT130");
        selectionCardPage.inputData("qty", "10");
        selectionCardPage.clickButton("commit");
    }

    @Test (priority = 6, dependsOnMethods = "processingSelectionTaskTest")
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол21
        containerCardPage.verifyData("containerInfo", "CON/OUT121 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT121");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол22
        containerCardPage.verifyData("containerInfo", "CON/OUT122 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT122");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол23
        containerCardPage.verifyData("containerInfo", "CON/OUT123 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT123");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");;
    //Стол24
        containerCardPage.verifyData("containerInfo", "CON/OUT124 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT124");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол25
        containerCardPage.verifyData("containerInfo", "CON/OUT125 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT125");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол26
        containerCardPage.verifyData("containerInfo", "CON/OUT126 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT126");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол27
        containerCardPage.verifyData("containerInfo", "CON/OUT127 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT127");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол28
        containerCardPage.verifyData("containerInfo", "CON/OUT128 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT128");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол29
        containerCardPage.verifyData("containerInfo", "CON/OUT129 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT129");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    //Стол30
        containerCardPage.verifyData("containerInfo", "CON/OUT130 ➡ KT1.01.01.01.01");
        containerCardPage.inputData("container", "OUT130");
        containerCardPage.inputData("destination", "KT1.01.01.01.01");
        containerCardPage.clickButton("commit");
    }

    @Test (priority = 7, dependsOnMethods = "processingContainerTaskTest")
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол21
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT121");
        controlCardPage.verifyData("productInfo", "00021 Стол21");
        controlCardPage.verifyData("containerInfo", "OUT121");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00021");
        controlCardPage.inputData("qty","10"); //Почему 10 шт.? Упаковка 2 уп. * 5
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол22
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT122");
        controlCardPage.verifyData("productInfo", "00022 Стол22");
        controlCardPage.verifyData("containerInfo", "OUT122");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","2110022100000 ");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол23
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT123");
        controlCardPage.verifyData("productInfo", "00023 Стол23");
        controlCardPage.verifyData("containerInfo", "OUT123");
        controlCardPage.getShelfLifeInfoString1().shouldHave(text("30.12.2021"));
        controlCardPage.getContainerInfoString1().shouldHave(text("OUT123"));
        controlCardPage.getControlledQtyString1().shouldHave(text("0"));
        controlCardPage.getQtyString1().shouldHave(text("5.5"));
        controlCardPage.inputData("product","2110023055000");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("30.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("30.12.2021"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("product","2110023045000");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDateZ23().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDateZ23().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.clickButton("commit");
    //Стол24
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT124");
        controlCardPage.verifyData("productInfo", "00024 Стол24");
        controlCardPage.verifyData("containerInfo", "OUT124");
        controlCardPage.getSeriesInfoString1().shouldHave(text("24Series01"));
        controlCardPage.getControlledQtyString1().shouldHave(text("0"));
        controlCardPage.getQtyString1().shouldHave(text("2"));
        controlCardPage.inputData("product","00024");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries1().shouldHave(text("24Series01"));
        inventoryCardPage.getAvailableSeries1().click();
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("qty","2");
    //Стол24
        controlCardPage.verifyData("productInfo", "00024 Стол24");
        controlCardPage.verifyData("containerInfo", "OUT124");
        controlCardPage.getSeriesInfoString1().shouldHave(text("24Series02"));
        controlCardPage.getControlledQtyString1().shouldHave(text("0"));
        controlCardPage.getQtyString1().shouldHave(text("8"));
        controlCardPage.inputData("product","00024");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries2().shouldHave(text("24Series02"));
        inventoryCardPage.getAvailableSeries2().click();
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("qty","8");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол25
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT125");
        controlCardPage.verifyData("productInfo", "00025 Стол25");
        controlCardPage.verifyData("containerInfo", "OUT125");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00025");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол26
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT126");
        controlCardPage.verifyData("productInfo", "00026 Стол26");
        controlCardPage.verifyData("containerInfo", "OUT126");
        controlCardPage.verifyData("seriesInfo", "26series01");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00026");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries1().shouldHave(text("26series01"));
        inventoryCardPage.getAvailableSeries1().click();
        controlCardPage.clickButton("commitSN");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол27
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT127");
        controlCardPage.verifyData("productInfo", "00027 Стол27");
        controlCardPage.verifyData("containerInfo", "OUT127");;
        controlCardPage.verifyData("shelfLifeInfo", "31.12.2021");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00027");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        inventoryCardPage.getAvailableExpirationDate().click();
        inventoryCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол28
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT128");
        controlCardPage.verifyData("productInfo", "00028 Стол28");
        controlCardPage.verifyData("containerInfo", "OUT128");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00028");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол29
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT129");
        controlCardPage.verifyData("productInfo", "00029 Стол29");
        controlCardPage.verifyData("containerInfo", "OUT129");
        controlCardPage.verifyData("seriesInfo", "29Series01");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00029");
        controlCardPage.verifyData("modalDialogTitle", "Batch properties");
        inventoryCardPage.getAvailableSeries1().shouldHave(text("29series01"));
        inventoryCardPage.getAvailableSeries1().click();
        controlCardPage.clickButton("commitSN");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    //Стол30
        controlCardPage.inputData("source", "KT1.01.01.01.01");
        controlCardPage.inputData("container","OUT130");
        controlCardPage.verifyData("productInfo", "00030 Стол30");
        controlCardPage.verifyData("containerInfo", "OUT130");
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.inputData("product","00030");
        controlCardPage.inputData("qty","10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.clickButton("commit");
    }

    @Test (priority = 8, dependsOnMethods = "processingControlTaskTest")
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

        packagingCardPage.setCellOrContainerInput("KT1.01.01.01.01");

        packagingCardPage.checkCellProductInfoInRow2(1, "OUT121", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(2, "OUT122", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(3, "OUT123", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(4, "OUT124", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(5, "OUT125", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(6, "OUT126", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(7, "OUT127", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(8, "OUT128", "10", "0.1", "0.1", "1", "1");
        //элементы не видны на форме
        //packagingCardPage.checkCellProductInfoInRow2(9, "OUT129", "10", "0.1", "0.1", "1", "1");
        //packagingCardPage.checkCellProductInfoInRow2(10, "OUT130", "10", "0.02", "0.02", "1", "1");
        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
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
