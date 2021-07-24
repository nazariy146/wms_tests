package tests.scenarios.case4;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.Actions.hideKeyboard;
import static tests.utils.Actions.scrollElement;
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
 * All tests run on Regress/DT/Case3/wms_regress_case3_Reception DB
 * All tests run according to TestNG priority.
 * If test fails - next one will be skipped according to TestNG dependsOnMethods
 */

    @Test
    public void processingNegativeReceptionTaskTest() throws Exception {
    steps.loginAsAdmin();

    allTasksPage.checkWorkType("Reception");
    allTasksPage.getWorkTypeTasksQuantity().click();

        //Стол31
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00031 Стол31 IN.01 Quantity 10 уп. (5)"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("31FRAGSN31Series0131122021");
        receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00031 Стол31"));
        receptionCardPage.setSerialNumberInputSeveralTimes("31FRAGSN31Series0131122021", 9);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 0);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        //Стол32
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00032 Стол32 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("32FRAGSN32Series0131122021");
        receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00032 Стол32"));
        receptionCardPage.setSerialNumberInputSeveralTimes("32FRAGSN32Series0131122021", 9);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 0);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00032 32series01 Стол32 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        //Стол33
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00033 Стол33 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("33FRAGSN33Series0131122021");
        receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00033 Стол33"));
        receptionCardPage.setSerialNumberInputSeveralTimes("33FRAGSN33Series0131122021", 9);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 0);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00033 31.12.2021 Стол33 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        //Стол34
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00034 Стол34 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("34FRAGSN34Series0131122021");
        receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00034 Стол34"));
        receptionCardPage.setSerialNumberInputSeveralTimes("34FRAGSN34Series0131122021", 9);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 0);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00034 34series01 31.12.2021 Стол34 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        //Стол35
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00035 Стол35 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("35FRAGBC35Series0131122021");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        //Стол36
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00036 Стол36 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("36FRAGBC36Series0131122021");
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00036 36series01 Стол36 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        //Стол37
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00037 Стол37 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("37FRAGBC37Series0131122021");
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00037 31.12.2021 Стол37 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        //Стол38
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00038 Стол38 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("38FRAGBC38Series0131122021");
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00038 38series01 31.12.2021 Стол38 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        //Стол39
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00039 Стол39 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("39FRAGSN39Series013112202101");
        receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00039 Стол39"));
        receptionCardPage.setSerialNumberInputSeveralTimes("39FRAGSN39Series013112202102", "39FRAGSN39Series013112202103", "39FRAGSN39Series013112202104", "39FRAGSN39Series013112202105", "39FRAGSN39Series013112202106", "39FRAGSN39Series013112202107", "39FRAGSN39Series013112202108", "39FRAGSN39Series013112202109", "39FRAGSN39Series013112202110");
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 0);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00039 39series01 31.12.2021 Стол39 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        //Стол40
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00040 Стол40 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("40FRAGSN40Series013112202101 40FRAGSN40Series013112202102 40FRAGSN40Series013112202103");
        receptionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00040 Стол40"));
        receptionCardPage.setSerialNumberInputSeveralTimes("40FRAGSN40Series013112202104 40FRAGSN40Series013112202105 40FRAGSN40Series013112202106 40FRAGSN40Series013112202107 40FRAGSN40Series013112202108 40FRAGSN40Series013112202109 40FRAGSN40Series013112202110");
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 0);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00040 40series01 31.12.2021 Стол40 IN.01 Quantity 10 шт"));
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();
    }


    @Test (priority = 1, dependsOnMethods = "processingNegativeReceptionTaskTest")
    public void processingAccommodationTaskTest() throws Exception{
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        allTasksPage.getWorkTypeTasksQuantity().click();

        //Стол31
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00031 Стол31 IN.01 ➡ C.1.1.1.1 Quantity 10 уп. (5)"));
        accommodationCardPage.setProductInput("31FRAGSN31Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.1");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол32
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00032 32series01 Стол32 IN.01 ➡ C.1.1.1.2 Quantity 10 шт"));
        accommodationCardPage.setProductInput("32FRAGSN32Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.2");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол33
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00033 31.12.2021 Стол33 IN.01 ➡ C.1.1.1.3 Quantity 10 шт"));
        accommodationCardPage.setProductInput("33FRAGSN33Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.3");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол34
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00034 34series01 31.12.2021 Стол34 IN.01 ➡ C.1.1.1.4 Quantity 10 шт"));
        accommodationCardPage.setProductInput("34FRAGSN34Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.4");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол35
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00035 Стол35 IN.01 ➡ C.1.1.1.5 Quantity 10 шт"));
        accommodationCardPage.setProductInput("35FRAGBC35Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.5");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол36
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00036 36series01 Стол36 IN.01 ➡ C.1.1.1.6 Quantity 10 шт"));
        accommodationCardPage.setProductInput("36FRAGBC36Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.6");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол37
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00037 31.12.2021 Стол37 IN.01 ➡ C.1.1.1.7 Quantity 10 шт"));
        accommodationCardPage.setProductInput("37FRAGBC37Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.7");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол38
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00038 38series01 31.12.2021 Стол38 IN.01 ➡ C.1.1.1.8 Quantity 10 шт"));
        accommodationCardPage.setProductInput("38FRAGBC38Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.8");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол39
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00039 39series01 31.12.2021 Стол39 IN.01 ➡ C.1.1.1.9 Quantity 10 шт"));
        accommodationCardPage.setProductInput("39FRAGSN39Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.9");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        //Стол40
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00040 40series01 31.12.2021 Стол40 IN.01 ➡ C.1.1.1.10 Quantity 10 шт"));
        accommodationCardPage.setProductInput("40FRAGSN40Series0131122021");
        accommodationCardPage.setDestinationInput("C.1.1.1.10");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();
    }

    /**
     * Тест на проверку формы FindRests (НайтиНаОстатках) для номенклатур Стол31-40
     */
    @Test (priority = 2, dependsOnMethods = "processingAccommodationTaskTest")
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
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол34
        findRestsPage.setBarcodeInput("34FRAGSN34Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00034 Стол34")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.4"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("34Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
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
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол38
        findRestsPage.setBarcodeInput("38FRAGBC38Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00038 Стол38")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.8"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("38Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол39
        findRestsPage.setBarcodeInput("39FRAGSN39Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00039 Стол39")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.9"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("39Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол40
        findRestsPage.setBarcodeInput("40FRAGSN40Series013112202101 "+"40FRAGSN40Series013112202102 "+"40FRAGSN40Series013112202103"); //ввод QR-code в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00040 Стол40")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.10"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("40Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    }

    /**
     * Тест на проверку формы Inventory (Инвентаризация) для номенклатур Стол31-40
     */
    @Test (priority = 3)
    public void processingInventoryTaskTest() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Inventory");
        allTasksPage.getWorkTypeTasksQuantity().click();

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
    }

    /**
     * Повторный тест на проверку формы FindRests (НайтиНаОстатках) после инвентуры для номенклатур Стол31-40
     */
    @Test (priority = 4, dependsOnMethods = "processingInventoryTaskTest")
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
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол34
        findRestsPage.setBarcodeInput("34FRAGSN34Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00034 Стол34")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.4"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("34Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
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
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол38
        findRestsPage.setBarcodeInput("38FRAGBC38Series0131122021"); //ввод ШК в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00038 Стол38")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.8"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("38Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол39
        findRestsPage.setBarcodeInput("39FRAGSN39Series0131122021"); //ввод СН в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00039 Стол39")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.9"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("39Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)

        //Стол40
        findRestsPage.setBarcodeInput("40FRAGSN40Series013112202101 "+"40FRAGSN40Series013112202102 "+"40FRAGSN40Series013112202103"); //ввод QR-code в поле Barcode
        findRestsPage.getProductDescription().shouldHave(text("00040 Стол40")); //проверка табличной части (наименование номенклатуры)
        findRestsPage.checkProductLocationInfo("C.1.1.1.10"); //проверка табличной части (ячейка)
        findRestsPage.getProductSeriesInfo().shouldHave(exactText("40Series01"));//проверка табличной части (Серии)
        findRestsPage.getProductShelfLifeInfo().shouldHave(exactText("31-12-2021"));//проверка табличной части (СГ)
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));//проверка табличной части (количество)
    }
}