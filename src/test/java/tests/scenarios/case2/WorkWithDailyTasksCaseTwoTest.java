package tests.scenarios.case2;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;

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
    InventoryCardPage inventoryCardPage = new InventoryCardPage();

    /**
     * All tests run on Regress/Case2/wms_regress_case2_Reception DB
     * All tests run according to TestNG priority.
     * If test fails - next one will be skipped according to TestNG dependsOnMethods
     */

    @Test
    public void processingReceptionTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Reception");
        //allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00011 000011 Стол11 IN.01 Quantity 10 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("11fragbc");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00012 000012 12Series01 Стол12 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("12fragbc");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00013 000013 31.12.2021 Стол13 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("13fragbc");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00014 000014 Стол14 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("14fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("00014 Стол14"));
        receptionCardPage.setSerialNumberInputSeveralTimes("14serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00015 000015 15series01 31.12.2021 Стол15 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("15fragbc");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00016 000016 16series01 Стол16 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("16fragbc");
        receptionCardPage.setSerialNumberInputSeveralTimes("16serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00017 000017 31.12.2021 Стол17 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("17fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("17serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00018 000018 18series01 31.12.2021 Стол18 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("18fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("18serialnumber01", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00019 000019 Стол19 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("19fragbc");
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.setSerialNumberInputSeveralTimes("19serialnumber01", "19serialnumber02", "19serialnumber03", "19serialnumber04", "19serialnumber05", "19serialnumber06", "19serialnumber07", "19serialnumber08", "19serialnumber09", "19serialnumber10");
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00020 000020 Стол20 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("20fragbc");
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();
    }
}
