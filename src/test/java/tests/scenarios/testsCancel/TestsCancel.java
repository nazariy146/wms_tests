/*
package tests.scenarios.testsCancel;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;
import static tests.utils.Actions.backPage;
import static tests.utils.Actions.fieldEnter;

import static com.codeborne.selenide.Condition.*;
import static tests.utils.ModalDialogs.clickSetOkYesButton;
import static tests.utils.ModalDialogs.clickCancelButton;
import static tests.utils.ModalDialogs.getAlertModalDialog;

public class TestsCancel extends BaseMobileClass {
    */
/**
     * Тест на проверку закрытия формы Серий/СГ кнопками Cancel и Esc на разных формах (Задача 1182)
     *//*

    Steps steps = new Steps();
    AllTasksPage allTasksPage = new AllTasksPage();
    ReceptionCardPage receptionCardPage = new ReceptionCardPage();
    InventoryCardPage inventoryCardPage = new InventoryCardPage();
    ControlCardPage controlCardPage = new ControlCardPage();
    RelocationCardPage relocationCardPage = new RelocationCardPage();

    @Test
    */
/**
     * Тест на проверку закрытия формы Серий/СГ кнопками Cancel и Esc на форме Reception
     *//*

    public void testingCancelReception() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().click();
        */
/**
         * Стол21
         *//*

        receptionCardPage.setSourceInput("IN.01");//ввод ячейки Источника
        receptionCardPage.setProductInput("000021");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));//проверка отображенной формы Серии/СГ
        clickCancelButton();//клик на кнопку "Отмена" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        //receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 Стол21 IN.01 Quantity 10 уп. (5)"));//проверка табличной части
        receptionCardPage.setProductInput("000021");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));//проверка отображенной формы Серии/СГ
        backPage(receptionCardPage.buttonCancel());//команда "Back" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        //receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 Стол21 IN.01 Quantity 10 уп.(5)"));//проверка табличной части
        receptionCardPage.setProductInput("000021");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewSeries("21Series01");//указываем Серию номенклатуры
        fieldEnter(receptionCardPage.buttonCancel());//команда "Enter" на форме Серии/СГ
        clickCancelButton();//клик на кнопку "Отмена" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        //receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 Стол21 IN.01 Quantity 10 уп.(5)"));//проверка табличной части
        receptionCardPage.setProductInput("000021");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewSeries("21Series01");
        fieldEnter(receptionCardPage.buttonCancel());//команда "Enter" на форме Серии/СГ
        backPage(receptionCardPage.buttonCancel());//команда "Back" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));
        //receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 Стол21 IN.01 Quantity 10 уп.(5)"));
        receptionCardPage.setProductInput("000021");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewSeries("21Series01");//указываем Серию номенклатуры
        clickSetOkYesButton();//клик на кнопку Ок
        //receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00021 21Series01 Стол21 IN.01 Quantity 10 уп.(5)"));//проверка табличной части
        receptionCardPage.setContainerInput("IN1");//ввод контейнера
        receptionCardPage.setQuantityInput("10");//ввод количества номенклатуры
        receptionCardPage.clickCommitButton();//клик на кнопку Commit (Подтвердить)
        */
/**
         * Стол22
         *//*

        receptionCardPage.setProductInput("000022");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));//проверка отображенной формы Серии/СГ
        clickCancelButton();//клик на кнопку "Отмена" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000022");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));//проверка отображенной формы Серии/СГ
        backPage(receptionCardPage.buttonCancel());//команда "Back" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000022");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewShelfLife("31.12.2021");//ввод СГ номенклатуры
        fieldEnter(receptionCardPage.buttonCancel());//команда "Enter" на форме Серии/СГ
        clickCancelButton();//клик на кнопку "Отмена" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000022");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewShelfLife("31.12.2021");//ввод СГ номенклатуры
        fieldEnter(receptionCardPage.buttonCancel());//команда "Enter" на форме Серии/СГ
        backPage(receptionCardPage.buttonCancel());//команда "Back" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 Стол22 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000022");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Shelf life"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewShelfLife("31.12.2021");//ввод СГ номенклатуры
        clickSetOkYesButton();//клик на кнопку Ок
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00022 31.12.2021 Стол22 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setContainerInput("IN1");//ввод контейнера
        receptionCardPage.setQuantityInput("10");//ввод количества номенклатуры
        receptionCardPage.clickCommitButton();//клик на кнопку Commit (Подтвердить)
        */
/**
         * Стол23
         *//*

        receptionCardPage.setProductInput("000023");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        clickCancelButton();//клик на кнопку "Отмена" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 Стол23 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000023");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        backPage(receptionCardPage.buttonCancel());//команда "Back" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 Стол23 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000023");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewShelfLife("31.12.2021");//ввод СГ номенклатуры
        receptionCardPage.createNewSeries("23Series01");//ввод Серии номенклатуры
        fieldEnter(receptionCardPage.buttonCancel());//команда "Enter" на форме Серии/СГ
        clickCancelButton();//клик на кнопку "Отмена" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 Стол23 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000023");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewShelfLife("31.12.2021");//ввод СГ номенклатуры
        receptionCardPage.createNewSeries("23Series01");//ввод Серии номенклатуры
        fieldEnter(receptionCardPage.buttonCancel());//команда "Enter" на форме Серии/СГ
        backPage(receptionCardPage.buttonCancel());//команда "Back" на форме Серии/СГ
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        receptionCardPage.fieldProduct().shouldHave(text("Product"));//проверка поля "Product" на отсутствие ШК/артикула
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 Стол23 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setProductInput("000023");//ввод ШК номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        receptionCardPage.createNewShelfLife("31.12.2021");//ввод СГ номенклатуры
        receptionCardPage.createNewSeries("23Series01");//ввод Серии номенклатуры
        clickSetOkYesButton();//клик на кнопку Ок
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00023 23Series01 31.12.2021 Стол23 IN.01 Quantity 10 шт"));//проверка табличной части
        receptionCardPage.setContainerInput("IN1");//ввод контейнера
        receptionCardPage.setQuantityInput("10");//ввод количества номенклатуры
        receptionCardPage.clickCommitButton();//клик на кнопку Commit (Подтвердить)
    }

    @Test (priority = 1)
    */
/**
     * Тест на проверку закрытия формы Серий/СГ кнопками Cancel и Esc на форме Relocation (Перемещение через ТСД)
     *//*

    public void testingCancelRelocation() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.selectRelocation();

        relocationCardPage.setSourceInput("B.1.1.1.1");//ввод ячейки Истоника
        relocationCardPage.textDescription().shouldHave(text("B.1.1.1.1 ➡"));//проверка табличной части
        relocationCardPage.setProductInput("00021");//ввод артикула номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        clickCancelButton();//клик на кнопку Cancel
        relocationCardPage.getProductInput().shouldHave(exactText(""));//проверка на пустоту поля Product
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        relocationCardPage.textDescription().shouldHave(text("B.1.1.1.1 ➡ 00021 Стол21"));//проверка табличной части
        relocationCardPage.setProductInput("00021");//ввод артикула номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        backPage(getAlertModalDialog());//закрытие формы Серии/СГ кнопкой Back (Esc)
        relocationCardPage.getProductInput().shouldHave(exactText(""));//проверка на пустоту поля Product
        getAlertModalDialog().shouldBe(disappear);//проверка на отсутствие формы Серии/СГ
        relocationCardPage.textDescription().shouldHave(text("B.1.1.1.1 ➡ 00021 Стол21"));//проверка табличной части
        backPage(relocationCardPage.textDescription());//закрытие формы Relocation (Перемещение через ТСД)
    }

    @Test (priority = 2)
    */
/**
     * Тест на проверку закрытия формы Серий/СГ кнопками Cancel и Esc на форме SelectionControl (ОтгрузкаКонтроль)
     *//*

    public void testingCancelSelectionControl() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();

        controlCardPage.setCellInput("KT1.01.01.01.02");//ввод ячейки Источника
        controlCardPage.setContainerInput("OUT213");//ввод контейнера
        controlCardPage.getProductInfo().shouldHave(text("00027 Стол27"));//проверка табличной части
        controlCardPage.getContainerInfo().shouldHave(text("OUT213"));//проверка табличной части
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("7"));
        controlCardPage.setItemInput("00027");//ввод артикула номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка на отображение формы Серии/СГ
        clickCancelButton();//коик на кнопку Cancel (Отмена)
        controlCardPage.getItemInput().shouldHave(text("Item"));//проверка на пустоту поля Item
        controlCardPage.getProductInfo().shouldHave(text("00027 Стол27"));//проверка табличной части
        controlCardPage.getContainerInfo().shouldHave(text("OUT213"));//проверка табличной части
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("7"));
        controlCardPage.setItemInput("00027");//ввод артикула номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка на отображение формы Серии/СГ
        backPage(getAlertModalDialog());//закрытие формы Серии/СГ кнопкой Back (Esc)
        controlCardPage.getItemInput().shouldHave(text("Item"));//проверка на пустоту поля Item
        controlCardPage.getProductInfo().shouldHave(text("00027 Стол27"));//проверка табличной части
        controlCardPage.getContainerInfo().shouldHave(text("OUT213"));//проверка табличной части
        controlCardPage.getControlledQty(1).shouldHave(text("0"));
        controlCardPage.getQty(1).shouldHave(text("7"));
        backPage(controlCardPage.getItemInput());//закрытие формы Control
    }

    @Test (priority = 3)
    */
/**
     * Тест на проверку закрытия формы Серий/СГ кнопками Cancel и Esc на форме Inventory
     *//*

    public void testingCancelInventory() throws Exception {
        steps.loginAsAdmin();
        allTasksPage.clickInventoryTypeTaskQuantity();

        inventoryCardPage.setCellInput("B.1.1.1.2");//ввод ячейки Источника
        inventoryCardPage.setProductInput("00022");//ввод артикула номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        clickCancelButton();//клик на кнопку Cancel
        inventoryCardPage.getProductInput().shouldHave(exactText(""));//проверка на пустоту поля Product
        inventoryCardPage.setProductInput("00022");//ввод артикула номенклатуры
        getAlertModalDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));//проверка отображенной формы Серии/СГ
        backPage(getAlertModalDialog());//закрытие формы Серии/СГ кнопкой Back (Esc)
        backPage(inventoryCardPage.getProductInput());//закрытие формы Inventory
    }
}
*/
