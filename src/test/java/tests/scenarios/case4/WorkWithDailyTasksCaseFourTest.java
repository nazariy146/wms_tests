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

    /**
     * Тест на проверку формы Reception (ПриемКонтроль) для номенклатур Стол31-40
     */

    @Test
    public void processingReceptionTaskTest() throws Exception {
    steps.loginAsAdmin();

    allTasksPage.checkWorkType("Reception"); // Поиск заданий Reception из общего списка доступных заданий на ТСД
    allTasksPage.getWorkTypeTasksQuantity().click(); // Выбор нужного нам задания (Reception)

    //Стол31
        receptionCardPage.verifyData("productInfo", "00031 Стол31 IN.01 Quantity 10 уп. (5)");
        receptionCardPage.inputData("source", "IN.01");
        receptionCardPage.inputData("product","31FRAGSN31Series0131122021");
        receptionCardPage.verifyData("productInfoSN", "00031 Стол31");
        receptionCardPage.setSerialNumberInputSeveralTimes("31FRAGSN31Series0131122021", 9); // Ввод в поле SerialNumber идентичных СН поочередно в количестве 9 шт
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("31FRAGSN31Series0131122021"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.inputData("container","IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10")); // Проверка введенного количества СН в поле Quantity
        receptionCardPage.clickButton("commit");
    //Стол32
        receptionCardPage.verifyData("productInfo", "00032 Стол32 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","32FRAGSN32Series0131122021");
        receptionCardPage.verifyData("productInfoSN", "00032 32Series01 Стол32");
        receptionCardPage.setSerialNumberInputSeveralTimes("32FRAGSN32Series0131122021", 9);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("32FRAGSN32Series0131122021"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.verifyData("productInfo", "00032 32series01 Стол32 IN.01 Quantity 10 шт");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол33
        receptionCardPage.verifyData("productInfo", "00033 Стол33 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","33FRAGSN33Series0131122021");
        receptionCardPage.verifyData("productInfoSN", "00033 31.12.2021 Стол33");
        receptionCardPage.setSerialNumberInputSeveralTimes("33FRAGSN33Series0131122021", 9);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("33FRAGSN33Series0131122021"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.verifyData("productInfo", "00033 31.12.2021 Стол33 IN.01 Quantity 10 шт");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол34
        receptionCardPage.verifyData("productInfo", "00034 Стол34 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","34FRAGSN34Series0131122021");
        receptionCardPage.verifyData("productInfoSN", "00034 34Series01 31.12.2021 Стол34");
        receptionCardPage.setSerialNumberInputSeveralTimes("34FRAGSN34Series0131122021", 9);
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("34FRAGSN34Series0131122021"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.verifyData("productInfo", "00034 34series01 31.12.2021 Стол34 IN.01 Quantity 10 шт");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол35
        receptionCardPage.verifyData("productInfo", "00035 Стол35 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","35FRAGBC35Series0131122021");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол36
        receptionCardPage.verifyData("productInfo", "00036 Стол36 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","36FRAGBC36Series0131122021");
        receptionCardPage.verifyData("productInfo", "00036 36series01 Стол36 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол37
        receptionCardPage.verifyData("productInfo", "00037 Стол37 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","37FRAGBC37Series0131122021");
        receptionCardPage.verifyData("productInfo", "00037 31.12.2021 Стол37 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол38
        receptionCardPage.verifyData("productInfo", "00038 Стол38 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","38FRAGBC38Series0131122021");
        receptionCardPage.verifyData("productInfo", "00038 38series01 31.12.2021 Стол38 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("qty","10");
        receptionCardPage.clickButton("commit");
    //Стол39
        receptionCardPage.verifyData("productInfo", "00039 Стол39 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","39FRAGSN39Series013112202101");
        receptionCardPage.verifyData("productInfoSN", "00039 39Series01 31.12.2021 Стол39");
        receptionCardPage.setSerialNumberInputSeveralTimes("39FRAGSN39Series013112202102", "39FRAGSN39Series013112202103", "39FRAGSN39Series013112202104", "39FRAGSN39Series013112202105", "39FRAGSN39Series013112202106", "39FRAGSN39Series013112202107", "39FRAGSN39Series013112202108", "39FRAGSN39Series013112202109", "39FRAGSN39Series013112202110");
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("39FRAGSN39Series013112202101"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(3).shouldHave(exactText("39FRAGSN39Series013112202102"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(4).shouldHave(exactText("39FRAGSN39Series013112202103"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(5).shouldHave(exactText("39FRAGSN39Series013112202104"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(6).shouldHave(exactText("39FRAGSN39Series013112202105"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(7).shouldHave(exactText("39FRAGSN39Series013112202106"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(8).shouldHave(exactText("39FRAGSN39Series013112202107"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(9).shouldHave(exactText("39FRAGSN39Series013112202108"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(10).shouldHave(exactText("39FRAGSN39Series013112202109"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        //receptionCardPage.getNameSerialNumber(11).shouldHave(exactText("39FRAGSN39Series013112202110"));//проверка СН в колонке Serial Number
        //receptionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.verifyData("productInfo", "00039 39series01 31.12.2021 Стол39 IN.01 Quantity 10 шт");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    //Стол40
        receptionCardPage.verifyData("productInfo", "00040 Стол40 IN.01 Quantity 10 шт");
        receptionCardPage.inputData("product","40FRAGSN40Series013112202101 40FRAGSN40Series013112202102 40FRAGSN40Series013112202103");
        receptionCardPage.verifyData("productInfoSN", "00040 40Series01 31.12.2021 Стол40");
        receptionCardPage.setSerialNumberInputSeveralTimes("40FRAGSN40Series013112202104 40FRAGSN40Series013112202105 40FRAGSN40Series013112202106 40FRAGSN40Series013112202107 40FRAGSN40Series013112202108 40FRAGSN40Series013112202109 40FRAGSN40Series013112202110");
        receptionCardPage.getNameSerialNumber(2).shouldHave(exactText("40FRAGSN40Series013112202101"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(3).shouldHave(exactText("40FRAGSN40Series013112202102"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(4).shouldHave(exactText("40FRAGSN40Series013112202103"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(5).shouldHave(exactText("40FRAGSN40Series013112202104"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(6).shouldHave(exactText("40FRAGSN40Series013112202105"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(7).shouldHave(exactText("40FRAGSN40Series013112202106"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(8).shouldHave(exactText("40FRAGSN40Series013112202107"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.getNameSerialNumber(9).shouldHave(exactText("40FRAGSN40Series013112202108"));//проверка СН в колонке Serial Number
        receptionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        receptionCardPage.getNameSerialNumber(10).shouldHave(exactText("40FRAGSN40Series013112202109"));//проверка СН в колонке Serial Number
//        receptionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        receptionCardPage.getNameSerialNumber(11).shouldHave(exactText("40FRAGSN40Series013112202110"));//проверка СН в колонке Serial Number
//        receptionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickButton("commitSN");
        receptionCardPage.verifyData("productInfo", "00040 40series01 31.12.2021 Стол40 IN.01 Quantity 10 шт");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickButton("commit");
    }

    /**
     * Тест на проверку формы Accommodation (ПриемРазмещение) для номенклатур Стол31-40
     */

    @Test (priority = 1)
    public void processingAccommodationTaskTest() throws Exception{
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();
    //Стол31
        accommodationCardPage.verifyData("productInfo", "00031 Стол31 IN.01 ➡ C.1.1.1.1 Quantity 10 уп. (5)");
        accommodationCardPage.inputData("source","IN1");
        accommodationCardPage.inputData("product","31FRAGSN31Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.1");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол32
        accommodationCardPage.verifyData("productInfo", "00032 32series01 Стол32 IN.01 ➡ C.1.1.1.2 Quantity 10 шт");
        accommodationCardPage.inputData("product","32FRAGSN32Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.2");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол33
        accommodationCardPage.verifyData("productInfo", "00033 31.12.2021 Стол33 IN.01 ➡ C.1.1.1.3 Quantity 10 шт");
        accommodationCardPage.inputData("product","33FRAGSN33Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.3");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол34
        accommodationCardPage.verifyData("productInfo", "00034 34series01 31.12.2021 Стол34 IN.01 ➡ C.1.1.1.4 Quantity 10 шт");
        accommodationCardPage.inputData("product","34FRAGSN34Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.4");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол35
        accommodationCardPage.verifyData("productInfo", "00035 Стол35 IN.01 ➡ C.1.1.1.5 Quantity 10 шт");
        accommodationCardPage.inputData("product","35FRAGBC35Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.5");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол36
        accommodationCardPage.verifyData("productInfo", "00036 36series01 Стол36 IN.01 ➡ C.1.1.1.6 Quantity 10 шт");
        accommodationCardPage.inputData("product","36FRAGBC36Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.6");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол37
        accommodationCardPage.verifyData("productInfo", "00037 31.12.2021 Стол37 IN.01 ➡ C.1.1.1.7 Quantity 10 шт");
        accommodationCardPage.inputData("product","37FRAGBC37Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.7");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол38
        accommodationCardPage.verifyData("productInfo", "00038 38series01 31.12.2021 Стол38 IN.01 ➡ C.1.1.1.8 Quantity 10 шт");
        accommodationCardPage.inputData("product","38FRAGBC38Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.8");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол39
        accommodationCardPage.verifyData("productInfo", "00039 39series01 31.12.2021 Стол39 IN.01 ➡ C.1.1.1.9 Quantity 10 шт");
        accommodationCardPage.inputData("product","39FRAGSN39Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.9");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    //Стол40
        accommodationCardPage.verifyData("productInfo", "00040 40series01 31.12.2021 Стол40 IN.01 ➡ C.1.1.1.10 Quantity 10 шт");
        accommodationCardPage.inputData("product","40FRAGSN40Series0131122021");
        accommodationCardPage.inputData("destination","C.1.1.1.10");
        accommodationCardPage.inputData("qty","10");
        accommodationCardPage.clickButton("commit");
    }

    /**
     * Тест на проверку формы FindRests (НайтиНаОстатках) для номенклатур Стол31-40
     */

    @Test (priority = 2)
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
        //findRestsPage.setOnOrOffFreeRemainSwitcher(false); //вкл переключателя Free remain

    //Стол31
        findRestsPage.setBarcodeInput("31FRAGSN31Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00031 Стол31")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.1"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол32
        findRestsPage.setBarcodeInput("32FRAGSN32Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00032 Стол32")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.2"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("32Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол33
        findRestsPage.setBarcodeInput("33FRAGSN33Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00033 Стол33")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.3"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол34
        findRestsPage.setBarcodeInput("34FRAGSN34Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00034 Стол34")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.4"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("34Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол35
        findRestsPage.setBarcodeInput("35FRAGBC35Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00035 Стол35")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.5"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол36
        findRestsPage.setBarcodeInput("36FRAGBC36Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00036 Стол36")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.6"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("36Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол37
        findRestsPage.setBarcodeInput("37FRAGBC37Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00037 Стол37")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.7"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол38
        findRestsPage.setBarcodeInput("38FRAGBC38Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00038 Стол38")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.8"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("38Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол39
        findRestsPage.setBarcodeInput("39FRAGSN39Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00039 Стол39")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.9"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("39Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол40
        findRestsPage.setBarcodeInput("40FRAGSN40Series013112202101 "+"40FRAGSN40Series013112202102 "+"40FRAGSN40Series013112202103"); //ввод QR-code в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00040 Стол40")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.10"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("40Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    }

    /**
     * Тест на проверку формы Inventory (Инвентаризация) для номенклатур Стол31-40
     */

    @Test (priority = 3)
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.getStringTasks(2).click();
     /**
     * Обычная Инвентаризация для номенклатур Стол31-40
     */

     //Стол 31
        inventoryCardPage.setCellInput("C.1.1.1.1"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("31FRAGSN31Series0131122021"); //ввод СН номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00031 Стол31")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00031 Стол31")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 32
        inventoryCardPage.setCellInput("C.1.1.1.2"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("32FRAGSN32Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00032 32Series01 Стол32")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00032 32Series01 Стол32")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 33
        inventoryCardPage.setCellInput("C.1.1.1.3"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("33FRAGSN33Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00033 2021-12-31T00:00:00 Стол33")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00033 2021-12-31T00:00:00 Стол33")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 34
        inventoryCardPage.setCellInput("C.1.1.1.4"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("34FRAGSN34Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00034 34Series01 2021-12-31T00:00:00 Стол34")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00034 34Series01 2021-12-31T00:00:00 Стол34")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 35
        inventoryCardPage.setCellInput("C.1.1.1.5"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("35FRAGBC35Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00035 Стол35")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00035 Стол35")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 36
        inventoryCardPage.setCellInput("C.1.1.1.6"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("36FRAGBC36Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00036 36Series01 Стол36")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00036 36Series01 Стол36")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 37
        inventoryCardPage.setCellInput("C.1.1.1.7"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("37FRAGBC37Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00037 2021-12-31T00:00:00 Стол37")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00037 2021-12-31T00:00:00 Стол37")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 38
        inventoryCardPage.setCellInput("C.1.1.1.8"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("38FRAGBC38Series0131122021"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00038 38Series01 2021-12-31T00:00:00 Стол38")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00038 38Series01 2021-12-31T00:00:00 Стол38")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 39
        inventoryCardPage.setCellInput("C.1.1.1.9"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("39FRAGSN39Series013112202101"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00039 39Series01 2021-12-31T00:00:00 Стол39")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00039 39Series01 2021-12-31T00:00:00 Стол39")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
     //Стол 40
        inventoryCardPage.setCellInput("C.1.1.1.10"); //ввод ШК ячейки
        inventoryCardPage.setProductInput("40FRAGSN40Series013112202101 "+"40FRAGSN40Series013112202102 "+"40FRAGSN40Series013112202103"); //ввод ШК номенклатуры
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00040 40Series01 2021-12-31T00:00:00 Стол40")); //проверка поля наименования номенклатуры на форме Инвентуры
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setQtyInput("10"); //ввод количества номенклатуры
        //inventoryCardPage.getItemViewInfo().shouldHave(text("00040 40Series01 2021-12-31T00:00:00 Стол40")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(text("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton(); //клик на кнопку Ок
        /*
     /**
     * Инвентаризация по СН для номенклатур Стол31-34, 39-40
     */
        /*

        //Стол31
        inventoryCardPage.setCellInput("C.1.1.1.1"); //ввод ШК ячейки
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setProductInput("31FRAGSN31Series0131122021"); //ввод СН номенклатуры
        //inventoryCardPage.getTextViewInfo().shouldHave(exactText("00031 Стол31")); //проверка поля наименования номенклатуры на форме СН
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("31FRAGSN31Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.setSerialNumberInputSeveralTimes("31FRAGSN31Series0131122021", 9); //ввод СН 9 раз в поле Serial number
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("31FRAGSN31Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("10")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.getButtonCommit().click(); //клик на кнопку Commit на форме СН
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00031 Стол31")); //проверка поля наименования номенклатуры на форме Инвентуры
        //inventoryCardPage.getItemViewInfo().shouldHave(exactText("00031 Стол31")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(exactText("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton();  //клик на кнопку Ок

        //Стол32
        inventoryCardPage.setCellInput("C.1.1.1.2"); //ввод ШК ячейки
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setProductInput("32FRAGSN32Series0131122021"); //ввод СН номенклатуры
        //inventoryCardPage.getTextViewInfo().shouldHave(exactText("00032 32Series01 Стол32")); //проверка поля наименования номенклатуры на форме СН
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("32FRAGSN32Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.setSerialNumberInputSeveralTimes("32FRAGSN32Series0131122021", 9); //ввод СН 9 раз в поле Serial number
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("32FRAGSN32Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("10")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.getButtonCommit().click(); //клик на кнопку Commit на форме СН
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00032 32Series01 Стол32")); //проверка поля наименования номенклатуры на форме Инвентуры
        //inventoryCardPage.getItemViewInfo().shouldHave(exactText("00032 32Series01 Стол32")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(exactText("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton();  //клик на кнопку Ок

        //Стол33
        inventoryCardPage.setCellInput("C.1.1.1.3"); //ввод ШК ячейки
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setProductInput("33FRAGSN33Series0131122021"); //ввод СН номенклатуры
        //inventoryCardPage.getTextViewInfo().shouldHave(exactText("00033 2021-12-31T00:00:00 Стол33")); //проверка поля наименования номенклатуры на форме СН
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("33FRAGSN33Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.setSerialNumberInputSeveralTimes("33FRAGSN33Series0131122021", 9); //ввод СН 9 раз в поле Serial number
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("33FRAGSN33Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("10")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.getButtonCommit().click(); //клик на кнопку Commit на форме СН
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00033 2021-12-31T00:00:00 Стол33")); //проверка поля наименования номенклатуры на форме Инвентуры
        //inventoryCardPage.getItemViewInfo().shouldHave(exactText("00033 2021-12-31T00:00:00 Стол33")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(exactText("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton();  //клик на кнопку Ок

        //Стол34
        inventoryCardPage.setCellInput("C.1.1.1.4"); //ввод ШК ячейки
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setProductInput("34FRAGSN34Series0131122021"); //ввод СН номенклатуры
        //inventoryCardPage.getTextViewInfo().shouldHave(exactText("00034 34Series01 2021-12-31T00:00:00 Стол34")); //проверка поля наименования номенклатуры на форме СН
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("34FRAGSN34Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.setSerialNumberInputSeveralTimes("34FRAGSN34Series0131122021", 9); //ввод СН 9 раз в поле Serial number
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("34FRAGSN34Series0131122021")); //проверка СН в колонке Serial number
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("10")); // проверка количества СН в колонке Qty fact:
        inventoryCardPage.getButtonCommit().click(); //клик на кнопку Commit на форме СН
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00034 34Series01 2021-12-31T00:00:00 Стол34")); //проверка поля наименования номенклатуры на форме Инвентуры
        //inventoryCardPage.getItemViewInfo().shouldHave(exactText("00034 34Series01 2021-12-31T00:00:00 Стол34")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(exactText("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton();  //клик на кнопку Ок

        //Стол39
        inventoryCardPage.setCellInput("C.1.1.1.9"); //ввод ШК ячейки
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setProductInput("39FRAGSN39Series013112202101"); //ввод СН номенклатуры
        //inventoryCardPage.getTextViewInfo().shouldHave(exactText("00039 39Series01 2021-12-31T00:00:00 Стол39")); //проверка поля наименования номенклатуры на форме СН
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("39FRAGSN39Series013112202101")); //проверка СН в колонке Serial number (Строка 1)
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 1)
        inventoryCardPage.setSerialNumberInputSeveralTimes("39FRAGSN39Series013112202102", "39FRAGSN39Series013112202103", "39FRAGSN39Series013112202104", "39FRAGSN39Series013112202105", "39FRAGSN39Series013112202106", "39FRAGSN39Series013112202107", "39FRAGSN39Series013112202108", "39FRAGSN39Series013112202109", "39FRAGSN39Series013112202110");
        inventoryCardPage.getTextViewCSNSerialNumber(3).shouldHave(exactText("39FRAGSN39Series013112202102")); //проверка СН в колонке Serial number (Строка 2)
        inventoryCardPage.getQtySerialNumber(3).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 2)
        inventoryCardPage.getTextViewCSNSerialNumber(4).shouldHave(exactText("39FRAGSN39Series013112202103")); //проверка СН в колонке Serial number (Строка 3)
        inventoryCardPage.getQtySerialNumber(4).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 3)
        inventoryCardPage.getTextViewCSNSerialNumber(5).shouldHave(exactText("39FRAGSN39Series013112202104")); //проверка СН в колонке Serial number (Строка 4)
        inventoryCardPage.getQtySerialNumber(5).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 4)
        inventoryCardPage.getTextViewCSNSerialNumber(6).shouldHave(exactText("39FRAGSN39Series013112202105")); //проверка СН в колонке Serial number (Строка 5)
        inventoryCardPage.getQtySerialNumber(6).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 5)
        inventoryCardPage.getTextViewCSNSerialNumber(7).shouldHave(exactText("39FRAGSN39Series013112202106")); //проверка СН в колонке Serial number (Строка 6)
        inventoryCardPage.getQtySerialNumber(7).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 6)
        inventoryCardPage.getTextViewCSNSerialNumber(8).shouldHave(exactText("39FRAGSN39Series013112202107")); //проверка СН в колонке Serial number (Строка 7)
        inventoryCardPage.getQtySerialNumber(8).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 7)
        inventoryCardPage.getTextViewCSNSerialNumber(9).shouldHave(exactText("39FRAGSN39Series013112202108")); //проверка СН в колонке Serial number (Строка 8)
        inventoryCardPage.getQtySerialNumber(9).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 8)
        inventoryCardPage.getTextViewCSNSerialNumber(10).shouldHave(exactText("39FRAGSN39Series013112202109")); //проверка СН в колонке Serial number (Строка 9)
        inventoryCardPage.getQtySerialNumber(10).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 9)
        inventoryCardPage.getTextViewCSNSerialNumber(11).shouldHave(exactText("39FRAGSN39Series013112202110")); //проверка СН в колонке Serial number (Строка 10)
        inventoryCardPage.getQtySerialNumber(11).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 10)
        inventoryCardPage.getButtonCommit().click(); //клик на кнопку Commit на форме СН
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00039 39Series01 2021-12-31T00:00:00 Стол39")); //проверка поля наименования номенклатуры на форме Инвентуры
        //inventoryCardPage.getItemViewInfo().shouldHave(exactText("00039 39Series01 2021-12-31T00:00:00 Стол39")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(exactText("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton();  //клик на кнопку Ок

        //Стол 40
        inventoryCardPage.setCellInput("C.1.1.1.10"); //ввод ШК ячейки
        inventoryCardPage.selectQuality("Кондиция"); //выбор статуса номенклатуры
        inventoryCardPage.setProductInput("40FRAGSN40Series013112202101 "+"40FRAGSN40Series013112202102 "+"40FRAGSN40Series013112202103"); //ввод QR-code
        //inventoryCardPage.getTextViewInfo().shouldHave(exactText("00040 40Series01 2021-12-31T00:00:00 Стол40")); //проверка поля наименования номенклатуры на форме СН
        inventoryCardPage.getTextViewCSNSerialNumber(2).shouldHave(exactText("40FRAGSN40Series013112202101")); //проверка СН в колонке Serial number (Строка 1)
        inventoryCardPage.getQtySerialNumber(2).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 1)
        inventoryCardPage.getTextViewCSNSerialNumber(3).shouldHave(exactText("40FRAGSN40Series013112202102")); //проверка СН в колонке Serial number (Строка 2)
        inventoryCardPage.getQtySerialNumber(3).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 2)
        inventoryCardPage.getTextViewCSNSerialNumber(4).shouldHave(exactText("40FRAGSN40Series013112202103")); //проверка СН в колонке Serial number (Строка 3)
        inventoryCardPage.getQtySerialNumber(4).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 3)
        inventoryCardPage.setSerialNumberOrQRcode("40FRAGSN40Series013112202104 "+"40FRAGSN40Series013112202105 "+"40FRAGSN40Series013112202106"); //ввод QR-code
        inventoryCardPage.getTextViewCSNSerialNumber(5).shouldHave(exactText("40FRAGSN40Series013112202104")); //проверка СН в колонке Serial number (Строка 4)
        inventoryCardPage.getQtySerialNumber(5).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 4)
        inventoryCardPage.getTextViewCSNSerialNumber(6).shouldHave(exactText("40FRAGSN40Series013112202105")); //проверка СН в колонке Serial number (Строка 5)
        inventoryCardPage.getQtySerialNumber(6).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 5)
        inventoryCardPage.getTextViewCSNSerialNumber(7).shouldHave(exactText("40FRAGSN40Series013112202106")); //проверка СН в колонке Serial number (Строка 6)
        inventoryCardPage.getQtySerialNumber(7).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 6)
        inventoryCardPage.setSerialNumberOrQRcode("40FRAGSN40Series013112202107 "+"40FRAGSN40Series013112202108 "+"40FRAGSN40Series013112202109 "+"40FRAGSN40Series013112202110"); //ввод QR-code
        inventoryCardPage.getTextViewCSNSerialNumber(8).shouldHave(exactText("40FRAGSN40Series013112202107")); //проверка СН в колонке Serial number (Строка 7)
        inventoryCardPage.getQtySerialNumber(8).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 7)
        inventoryCardPage.getTextViewCSNSerialNumber(9).shouldHave(exactText("40FRAGSN40Series013112202108")); //проверка СН в колонке Serial number (Строка 8)
        inventoryCardPage.getQtySerialNumber(9).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 8)
        inventoryCardPage.getTextViewCSNSerialNumber(10).shouldHave(exactText("40FRAGSN40Series013112202109")); //проверка СН в колонке Serial number (Строка 9)
        inventoryCardPage.getQtySerialNumber(10).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 9)
        inventoryCardPage.getTextViewCSNSerialNumber(11).shouldHave(exactText("40FRAGSN40Series013112202110")); //проверка СН в колонке Serial number (Строка 10)
        inventoryCardPage.getQtySerialNumber(11).shouldHave(exactText("1")); // проверка количества СН в колонке Qty fact: (Строка 10)
        inventoryCardPage.getButtonCommit().click(); //клик на кнопку Commit на форме СН
        //inventoryCardPage.getProductInfo().shouldHave(exactText("00040 40Series01 2021-12-31T00:00:00 Стол40")); //проверка поля наименования номенклатуры на форме Инвентуры
        //inventoryCardPage.getItemViewInfo().shouldHave(exactText("00040 40Series01 2021-12-31T00:00:00 Стол40")); //проверка поля наименования номенклатуры в колонке Item
        inventoryCardPage.getQualityViewInfo().shouldHave(exactText("Кондиция")); //проверка статуса номенклатуры в колонке Quality
        inventoryCardPage.getQtyViewInfo().shouldHave(exactText("10.0")); //проверка количества в колонке Qty
        inventoryCardPage.clickInventoryButton(); //клик на кнопку Inventory
        getMessageModalDialog().shouldHave(text("Complete Cell Inventory?")); //получения диалогового окна
        clickSetOkYesButton();  //клик на кнопку Ок

         */


    }

    /**
     * Повторный тест на проверку формы FindRests (НайтиНаОстатках) после инвентуры для номенклатур Стол31-40
     */

    @Test (priority = 4)
    public void checkingFreeAmountTest2() {
        steps.loginAsAdmin();
        allTasksPage.selectFindRestsMenu();
        //findRestsPage.setOnOrOffFreeRemainSwitcher(false); //вкл переключателя Free remain

    //Стол31
        findRestsPage.setBarcodeInput("31FRAGSN31Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00031 Стол31")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.1"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол32
        findRestsPage.setBarcodeInput("32FRAGSN32Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00032 Стол32")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.2"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("32Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол33
        findRestsPage.setBarcodeInput("33FRAGSN33Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00033 Стол33")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.3"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол34
        findRestsPage.setBarcodeInput("34FRAGSN34Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00034 Стол34")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.4"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("34Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол35
        findRestsPage.setBarcodeInput("35FRAGBC35Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00035 Стол35")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.5"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол36
        findRestsPage.setBarcodeInput("36FRAGBC36Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00036 Стол36")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.6"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("36Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);//проверка табличной части (отстутствие СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол37
        findRestsPage.setBarcodeInput("37FRAGBC37Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00037 Стол37")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.7"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);//проверка табличной части (отстутствие Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол38
        findRestsPage.setBarcodeInput("38FRAGBC38Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00038 Стол38")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.8"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("38Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол39
        findRestsPage.setBarcodeInput("39FRAGSN39Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00039 Стол39")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.9"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("39Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    //Стол40
        findRestsPage.setBarcodeInput("40FRAGSN40Series013112202101 "+"40FRAGSN40Series013112202102 "+"40FRAGSN40Series013112202103"); //ввод QR-code в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00040 Стол40")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.10"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("40Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31.12.2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    }

    /**
     * Тест на проверку формы Selection (ОтгрузкаОтбор) для номенклатур Стол31-40
     */

    @Test (priority = 5)
    public void processingSelectionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол31
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00031 Стол31 C.1.1.1.1 ➡ KT1.01.01.01.01 Quantity 10 уп. (5)"));
        selectionCardPage.setSourceInput("C.1.1.1.1");
        selectionCardPage.setProductInput("31FRAGSN31Series0131122021");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00031 Стол31"));
        selectionCardPage.setSerialNumberInputSeveralTimes("31FRAGSN31Series0131122021", 9);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("31FRAGSN31Series0131122021"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT131");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол32
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00032 32series01 Стол32 C.1.1.1.2 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.2");
        selectionCardPage.setProductInput("32FRAGSN32Series0131122021");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
    //   selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00032 32series01 Стол32"));
        selectionCardPage.setSerialNumberInputSeveralTimes("32FRAGSN32Series0131122021", 9);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("32FRAGSN32Series0131122021"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT132");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол33
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00033 31.12.2021 Стол33 C.1.1.1.3 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.3");
        selectionCardPage.setProductInput("33FRAGSN33Series0131122021");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
    //   selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00033 31.12.2021 Стол33"));
        selectionCardPage.setSerialNumberInputSeveralTimes("33FRAGSN33Series0131122021", 9);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("33FRAGSN33Series0131122021"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT133");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол34
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00034 34series01 31.12.2021 Стол34 C.1.1.1.4 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.4");
        selectionCardPage.setProductInput("34FRAGSN34Series0131122021");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
    //   selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00034 34series01 31.12.2021 Стол34"));
        selectionCardPage.setSerialNumberInputSeveralTimes("34FRAGSN34Series0131122021", 9);
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("34FRAGSN34Series0131122021"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT134");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол35
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00035 Стол35 C.1.1.1.5 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.5");
        selectionCardPage.setProductInput("35FRAGBC35Series0131122021");
        selectionCardPage.setDestinationInput("OUT135");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол36
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00036 36series01 Стол36 C.1.1.1.6 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.6");
        selectionCardPage.setProductInput("36FRAGBC36Series0131122021");
        selectionCardPage.setDestinationInput("OUT136");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол37
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00037 31.12.2021 Стол37 C.1.1.1.7 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.7");
        selectionCardPage.setProductInput("37FRAGBC37Series0131122021");
        selectionCardPage.setDestinationInput("OUT137");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол38
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00038 38series01 31.12.2021 Стол38 C.1.1.1.8 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.8");
        selectionCardPage.setProductInput("38FRAGBC38Series0131122021");
        selectionCardPage.setDestinationInput("OUT138");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();
    //Стол39
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00039 39series01 31.12.2021 Стол39 C.1.1.1.9 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.9");
        selectionCardPage.setProductInput("39FRAGSN39Series013112202101");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
    //    selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00039 39series01 31.12.2021 Стол39"));
        selectionCardPage.setSerialNumberInputSeveralTimes("39FRAGSN39Series013112202102", "39FRAGSN39Series013112202103", "39FRAGSN39Series013112202104", "39FRAGSN39Series013112202105", "39FRAGSN39Series013112202106", "39FRAGSN39Series013112202107", "39FRAGSN39Series013112202108", "39FRAGSN39Series013112202109", "39FRAGSN39Series013112202110");
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("39FRAGSN39Series013112202101"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(3).shouldHave(exactText("39FRAGSN39Series013112202102"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(4).shouldHave(exactText("39FRAGSN39Series013112202103"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(5).shouldHave(exactText("39FRAGSN39Series013112202104"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(6).shouldHave(exactText("39FRAGSN39Series013112202105"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(7).shouldHave(exactText("39FRAGSN39Series013112202106"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(8).shouldHave(exactText("39FRAGSN39Series013112202107"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(9).shouldHave(exactText("39FRAGSN39Series013112202108"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(10).shouldHave(exactText("39FRAGSN39Series013112202109"));//проверка СН в колонке Serial Number
//        selectionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        selectionCardPage.getNameSerialNumber(11).shouldHave(exactText("39FRAGSN39Series013112202110"));//проверка СН в колонке Serial Number
//        selectionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT139");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    //Стол40
        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00040 40series01 31.12.2021 Стол40 C.1.1.1.10 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("C.1.1.1.10");
        selectionCardPage.setProductInput("40FRAGSN40Series013112202101 40FRAGSN40Series013112202102 40FRAGSN40Series013112202103");
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
    //    receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00040 40series01 31.12.2021 Стол40"));
        receptionCardPage.setSerialNumberInputSeveralTimes("40FRAGSN40Series013112202104 40FRAGSN40Series013112202105 40FRAGSN40Series013112202106 40FRAGSN40Series013112202107 40FRAGSN40Series013112202108 40FRAGSN40Series013112202109 40FRAGSN40Series013112202110");
        selectionCardPage.getNameSerialNumber(2).shouldHave(exactText("40FRAGSN40Series013112202101"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(3).shouldHave(exactText("40FRAGSN40Series013112202102"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(4).shouldHave(exactText("40FRAGSN40Series013112202103"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(5).shouldHave(exactText("40FRAGSN40Series013112202104"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(6).shouldHave(exactText("40FRAGSN40Series013112202105"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(7).shouldHave(exactText("40FRAGSN40Series013112202106"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(8).shouldHave(exactText("40FRAGSN40Series013112202107"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.getNameSerialNumber(9).shouldHave(exactText("40FRAGSN40Series013112202108"));//проверка СН в колонке Serial Number
        selectionCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        selectionCardPage.getNameSerialNumber(10).shouldHave(exactText("40FRAGSN40Series013112202109"));//проверка СН в колонке Serial Number
//        selectionCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        selectionCardPage.getNameSerialNumber(11).shouldHave(exactText("40FRAGSN40Series013112202110"));//проверка СН в колонке Serial Number
//        selectionCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT140");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();
    }

    /**
     * Тест на проверку формы Container (ОтгрузкаКонтейнер) для номенклатур Стол31-40
     */

    @Test (priority = 6)
    public void processingContainerTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол31
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT131 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT131");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();
    //Стол32
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT132 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT132");
        containerCardPage.clickCommitButton();
    //Стол33
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT133 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT133");
        containerCardPage.clickCommitButton();
    //Стол34
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT134 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT134");
        containerCardPage.clickCommitButton();
    //Стол35
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT135 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT135");
        containerCardPage.clickCommitButton();
    //Стол36
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT136 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT136");
        containerCardPage.clickCommitButton();
    //Стол37
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT137 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT137");
        containerCardPage.clickCommitButton();
    //Стол38
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT138 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT138");
        containerCardPage.clickCommitButton();
    //Стол39
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT139 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT139");
        containerCardPage.clickCommitButton();
    //Стол40
        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT140 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT140");
        containerCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Control");
    }

    /**
     * Тест на проверку формы Control (ОтгрузкаКонтроль) для номенклатур Стол31-40
     */

    @Test (priority = 7)
    public void processingControlTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();

    //Стол31
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT131");
        controlCardPage.getProductInfo().shouldHave(text("00031 Стол31"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT131"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("31FRAGSN31Series0131122021");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00031 Стол31"));
        controlCardPage.setSerialNumberInputSeveralTimes("31FRAGSN31Series0131122021", 9);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("31FRAGSN31Series0131122021"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол32
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT132");
        controlCardPage.getProductInfo().shouldHave(text("00032 Стол32"));
        controlCardPage.getSeriesInfo().shouldHave(text("32Series01"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT132"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("32FRAGSN32Series0131122021");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00032 32Series01 Стол32"));
        controlCardPage.setSerialNumberInputSeveralTimes("32FRAGSN32Series0131122021", 9);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("32FRAGSN32Series0131122021"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол33
        controlCardPage.setCellInput("KT1.01.01.01.01"); //Проблема с Разбором СГ в СН!!!!!!!!!!!!!!!
        controlCardPage.setContainerInput("OUT133");
        controlCardPage.getProductInfo().shouldHave(text("00033 Стол33"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT133"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("33FRAGSN33Series0131122021");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00033 31.12.2021 Стол33"));
        controlCardPage.setSerialNumberInputSeveralTimes("33FRAGSN33Series0131122021", 9);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("33FRAGSN33Series0131122021"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол34
        controlCardPage.setCellInput("KT1.01.01.01.01"); //Проблема с Разбором СГ в СН!!!!!!!!!!!!!!! Если ввожу СН без СГ - открывается форма СерииСГ(не должна)
        controlCardPage.setContainerInput("OUT134");
        controlCardPage.getProductInfo().shouldHave(text("00034 Стол34"));
        controlCardPage.getSeriesInfo().shouldHave(text("34Series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT134"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("34FRAGSN34Series0131122021");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00034 34Series01 31.12.2021 Стол34"));
        controlCardPage.setSerialNumberInputSeveralTimes("34FRAGSN34Series0131122021", 9);
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("34FRAGSN34Series0131122021"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("10"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол35
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT135");
        controlCardPage.getProductInfo().shouldHave(text("00035 Стол35"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT135"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("35FRAGBC35Series0131122021");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол36
        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT136");
        controlCardPage.getProductInfo().shouldHave(text("00036 Стол36"));
        controlCardPage.getSeriesInfo().shouldHave(text("36Series01"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT136"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("36FRAGBC36Series0131122021");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол37
        controlCardPage.setCellInput("KT1.01.01.01.01"); //Проблема с Разбором СГ в Фрагменте ШК!!!!!!!!!!!!!!!
        controlCardPage.setContainerInput("OUT137");
        controlCardPage.getProductInfo().shouldHave(text("00037 Стол37"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT137"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("37FRAGBC37Series0131122021");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол38
        controlCardPage.setCellInput("KT1.01.01.01.01"); //Проблема с Разбором СГ в Фрагменте ШК!!!!!!!!!!!!!!!
        controlCardPage.setContainerInput("OUT138");
        controlCardPage.getProductInfo().shouldHave(text("00038 Стол38"));
        controlCardPage.getSeriesInfo().shouldHave(text("38Series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT138"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("38FRAGBC38Series0131122021");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол39
        controlCardPage.setCellInput("KT1.01.01.01.01"); //Проблема с Разбором СГ в СН!!!!!!!!!!!!!!!
        controlCardPage.setContainerInput("OUT139");
        controlCardPage.getProductInfo().shouldHave(text("00039 Стол39"));
        controlCardPage.getSeriesInfo().shouldHave(text("39Series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT139"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("39FRAGSN39Series013112202101");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00039 39Series01 31.12.2021 Стол39"));
        controlCardPage.setSerialNumberInputSeveralTimes("39FRAGSN39Series013112202102", "39FRAGSN39Series013112202103", "39FRAGSN39Series013112202104", "39FRAGSN39Series013112202105", "39FRAGSN39Series013112202106", "39FRAGSN39Series013112202107", "39FRAGSN39Series013112202108", "39FRAGSN39Series013112202109", "39FRAGSN39Series013112202110");
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("39FRAGSN39Series013112202101"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(3).shouldHave(exactText("39FRAGSN39Series013112202102"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(4).shouldHave(exactText("39FRAGSN39Series013112202103"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(5).shouldHave(exactText("39FRAGSN39Series013112202104"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(6).shouldHave(exactText("39FRAGSN39Series013112202105"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(7).shouldHave(exactText("39FRAGSN39Series013112202106"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(8).shouldHave(exactText("39FRAGSN39Series013112202107"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(9).shouldHave(exactText("39FRAGSN39Series013112202108"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(10).shouldHave(exactText("39FRAGSN39Series013112202109"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        controlCardPage.getNameSerialNumber(11).shouldHave(exactText("39FRAGSN39Series013112202110"));//проверка СН в колонке Serial Number
//        controlCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    //Стол40
        controlCardPage.setCellInput("KT1.01.01.01.01"); //Проблема с Разбором СГ в СН!!!!!!!!!!!!!!!
        controlCardPage.setContainerInput("OUT140");
        controlCardPage.getProductInfo().shouldHave(text("00040 Стол40"));
        controlCardPage.getSeriesInfo().shouldHave(text("40Series01"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT140"));
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.setItemInput("40FRAGSN40Series013112202101 40FRAGSN40Series013112202102 40FRAGSN40Series013112202103");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("00040 40Series01 31.12.2021 Стол40"));
        controlCardPage.setSerialNumberInputSeveralTimes("40FRAGSN40Series013112202104 40FRAGSN40Series013112202105 40FRAGSN40Series013112202106 40FRAGSN40Series013112202107 40FRAGSN40Series013112202108 40FRAGSN40Series013112202109 40FRAGSN40Series013112202110");
        controlCardPage.getNameSerialNumber(2).shouldHave(exactText("40FRAGSN40Series013112202101"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(2).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(3).shouldHave(exactText("40FRAGSN40Series013112202102"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(3).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(4).shouldHave(exactText("40FRAGSN40Series013112202103"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(4).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(5).shouldHave(exactText("40FRAGSN40Series013112202104"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(5).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(6).shouldHave(exactText("40FRAGSN40Series013112202105"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(6).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(7).shouldHave(exactText("40FRAGSN40Series013112202106"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(7).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(8).shouldHave(exactText("40FRAGSN40Series013112202107"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(8).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(9).shouldHave(exactText("40FRAGSN40Series013112202108"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(9).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.getNameSerialNumber(10).shouldHave(exactText("40FRAGSN40Series013112202109"));//проверка СН в колонке Serial Number
        controlCardPage.getQtySerialNumber(10).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
//        controlCardPage.getNameSerialNumber(11).shouldHave(exactText("40FRAGSN40Series013112202110"));//проверка СН в колонке Serial Number
//        controlCardPage.getQtySerialNumber(11).shouldHave(exactText("1"));//проверка количества СН в колонке Qty fact:
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty(1).shouldNotBe(visible);
        controlCardPage.getQty(1).shouldHave(text("10"));
        controlCardPage.clickCommitButton();
    }

    /**
     * Тест на проверку формы Packaging (Упаковка) для номенклатур Стол31-40
     */

    @Test (priority = 8)
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

        packagingCardPage.setCellOrContainerInput("KT1.01.01.01.01");

        packagingCardPage.checkCellProductInfoInRow2(1, "OUT131", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(2, "OUT132", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(3, "OUT133", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(4, "OUT134", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(5, "OUT135", "10", "0.1", "0.1", "1", "1");
        packagingCardPage.checkCellProductInfoInRow2(6, "OUT136", "10", "0.1", "0.1", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(7, "OUT137", "10", "0.1", "0.1", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(8, "OUT138", "10", "0.1", "0.1", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(9, "OUT139", "10", "1", "1", "1", "1");
//        packagingCardPage.checkCellProductInfoInRow2(10, "OUT140", "10", "0.1", "0.1", "1", "1");

        packagingCardPage.clickCreateCargoButton();
        getMessageModalDialog().shouldHave(text("Cargo slots will be created. Continue?"));
        clickSetOkYesButton();
    }

    /**
     * Тест на проверку формы Loading (Погрузка) для номенклатур Стол31-40
     */

    @Test (priority = 9)
    public void processingLoadingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Loading");
        allTasksPage.getWorkTypeTasksQuantity().click();

        loadingCardPage.setRouteSheetInput("I000000001");
        loadingCardPage.setGateInput("OUT.01");
//        loadingCardPage.checkLoadingInfo("5", "Костенко", "0", "10"); // Приоритет может менятся
        loadingCardPage.setSerialCargoInput("9990000000012", "9990000000029", "9990000000036", "9990000000043", "9990000000050", "9990000000067", "9990000000074", "9990000000081", "9990000000098", "9990000000104");
//        loadingCardPage.checkLoadingInfo("5", "Костенко", "10", "0"); // Приоритет может менятся
        loadingCardPage.clickCommitButton();
    }
}