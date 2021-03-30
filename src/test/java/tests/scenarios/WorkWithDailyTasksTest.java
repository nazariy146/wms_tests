package tests.scenarios;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.*;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;

public class WorkWithDailyTasksTest extends BaseMobileClass {

    Steps steps = new Steps();
    AllTasksPage allTasksPage = new AllTasksPage();
    ReceptionCardPage receptionCardPage = new ReceptionCardPage();
    AccommodationCardPage accommodationCardPage = new AccommodationCardPage();
    FindRestsPage findRestsPage = new FindRestsPage();
    SelectionCardPage selectionCardPage = new SelectionCardPage();
    ContainerCardPage containerCardPage = new ContainerCardPage();
    ControlCardPage controlCardPage = new ControlCardPage();
    PackagingPage packagingPage = new PackagingPage();

    @Test
    public void processingReceptionTasksTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Reception");
        allTasksPage.getWorkTypeTasksQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0001 ШТУЧНЫЙ 00001 Стол1 IN.01 Quantity 10 шт"));
        receptionCardPage.setSourceInput("IN.01");
        receptionCardPage.setProductInput("0001"); // set sku
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00010 ШТУЧНЫЙ 00010 Стол10 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("00010"); // set sku
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Стол2 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0002"); // set sku
        receptionCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("Series2");
        receptionCardPage.clickSetButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Series2 Стол2 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 Стол3 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0003"); // set sku
        receptionCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.clickSetButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 31.12.2021 Стол3 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0004 00004 Стол4 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0004"); // set sku
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 Стол4"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 Стол5 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0005"); // set sku
        receptionCardPage.getAlertDialog().shouldHave(text("Series / shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.createNewSeries("series5");
        receptionCardPage.clickSetButton();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 series5 31.12.2021 Стол5 IN.01 Quantity 10 шт"));
        receptionCardPage.setQuantityInput("10");
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 Стол6 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0006"); // set sku
        receptionCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Series"));
        receptionCardPage.createNewSeries("series6");
        receptionCardPage.clickSetButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 Стол6"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.clearContainerInput();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 series6 Стол6 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 Стол7 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0007"); // set sku
        receptionCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.clickSetButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 Стол7"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.clearContainerInput();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 31.12.2021 Стол7 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 Стол8 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0008"); // set sku000
        receptionCardPage.getAlertDialog().shouldHave(text("Series / shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.createNewSeries("series8");
        receptionCardPage.clickSetButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 Стол8"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.clearContainerInput();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 series8 31.12.2021 Стол8 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 IN.01 Quantity 10 шт"));
        receptionCardPage.setProductInput("0009"); // set sku
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 Стол9"));
        receptionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        receptionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        receptionCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        receptionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        receptionCardPage.checkSerialNumberInputText("");
        receptionCardPage.clickCommitSerialNumberButton();
        receptionCardPage.clearContainerInput();
        receptionCardPage.getContainerInput().click();
        receptionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 IN.01 Quantity 10 шт"));
        receptionCardPage.setContainerInput("IN1");
        receptionCardPage.getQuantityInput().shouldHave(text("10"));
        receptionCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Accommodation");
    }

    @Test (priority = 1, dependsOnMethods = "processingReceptionTasksTest")
    public void processingAccommodationTasksTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Accommodation");
        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0001 ШТУЧНЫЙ 00001 Стол1 IN.01 ➡ A.1.1.1.1 Quantity 10 шт"));
        accommodationCardPage.setSourceInput("IN1");
        accommodationCardPage.setProductInput("0001"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.1");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Series2 Стол2 IN.01 ➡ A.1.1.1.2 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0002"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.2");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 31.12.2021 Стол3 IN.01 ➡ A.1.1.1.3 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0003"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.3");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0004 00004 Стол4 IN.01 ➡ A.1.1.1.4 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0004"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.4");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 series5 31.12.2021 Стол5 IN.01 ➡ A.1.1.1.5 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0005"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.5");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 series6 Стол6 IN.01 ➡ A.1.1.1.6 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0006"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.6");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 31.12.2021 Стол7 IN.01 ➡ A.1.1.1.7 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0007"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.7");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 series8 31.12.2021 Стол8 IN.01 ➡ A.1.1.1.8 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0008"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.8");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 IN.01 ➡ A.1.1.1.9 Quantity 10 шт"));
        accommodationCardPage.setProductInput("0009"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.9");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        accommodationCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00010 ШТУЧНЫЙ 00010 Стол10 IN.01 ➡ A.1.1.1.10 Quantity 10 шт"));
        accommodationCardPage.setProductInput("00010"); // set sku
        accommodationCardPage.setDestinationInput("A.1.1.1.10");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Selection");
    }

    @Test (priority = 2, dependsOnMethods = "processingAccommodationTasksTest")
    public void checkingFreeAmountTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");
        allTasksPage.selectFindRestsMenu();

        findRestsPage.checkFreeRemainSwitchState(false);
        //findRestsPage.setOnOrOffFreeRemainSwitcher(true); //TODO BUG

        findRestsPage.setBarcodeInput("0001"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0001 ШТУЧНЫЙ 00001 Стол1"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.1");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0002"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0002 00002 Стол2"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.2");
        findRestsPage.checkProductSeriesInfo("Series2");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0003"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0003 00003 Стол3"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.3");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0004"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0004 00004 Стол4"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.4");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0005"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0005 00005 Стол5"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.5");
        findRestsPage.checkProductSeriesInfo("series5");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0006"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0006 00006 Стол6"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.6");
        findRestsPage.checkProductSeriesInfo("series6");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0007"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0007 00007 Стол7"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.7");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0008"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0008 00008 Стол8"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.8");
        findRestsPage.checkProductSeriesInfo("series8");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0009"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0009 00009 Стол9"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.9");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00010"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00010 ШТУЧНЫЙ 00010 Стол10"));
        findRestsPage.checkFreeRemainSwitchState(true); //TODO BUG
        findRestsPage.checkProductLocationInfo("A.1.1.1.10");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }

    @Test (priority = 3, dependsOnMethods = "processingAccommodationTasksTest")
    public void processingSelectionTasksTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Selection");
        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getWorkTypeTasksQuantity().click();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0001 ШТУЧНЫЙ 00001 Стол1 A.1.1.1.1 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.1");
        selectionCardPage.setProductInput("0001"); // set sku
        selectionCardPage.setDestinationInput("OUT101");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0002 00002 Series2 Стол2 A.1.1.1.2 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.2");
        selectionCardPage.setProductInput("0002"); // set sku
        selectionCardPage.setDestinationInput("OUT102");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0003 00003 31.12.2021 Стол3 A.1.1.1.3 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.3");
        selectionCardPage.setProductInput("0003"); // set sku
        selectionCardPage.setDestinationInput("OUT103");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0004 00004 Стол4 A.1.1.1.4 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.4");
        selectionCardPage.setProductInput("0004"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 Стол4"));
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT104");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0005 00005 series5 31.12.2021 Стол5 A.1.1.1.5 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.5");
        selectionCardPage.setProductInput("0005"); // set sku
        selectionCardPage.setDestinationInput("OUT105");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0006 00006 series6 Стол6 A.1.1.1.6 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.6");
        selectionCardPage.setProductInput("0006"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 Стол6")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT106");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0007 00007 31.12.2021 Стол7 A.1.1.1.7 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.7");
        selectionCardPage.setProductInput("0007"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 Стол7")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT107");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0008 00008 series8 31.12.2021 Стол8 A.1.1.1.8 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.8");
        selectionCardPage.setProductInput("0008"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 Стол8")); //TODO BUG
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT108");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("0009 00009 Стол9 A.1.1.1.9 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.9");
        selectionCardPage.setProductInput("0009"); // set sku
        selectionCardPage.getSerialNumberInput().shouldBe(visible);
        selectionCardPage.checkSerialNumberInputText("");
        //selectionCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 Стол9")); //TODO BUG
        selectionCardPage.getCommitSerialNumberButton().shouldBe(visible);
        selectionCardPage.getCancelSerialNumberButton().shouldBe(visible);
        selectionCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        selectionCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        selectionCardPage.checkSerialNumberInputText("");
        selectionCardPage.clickCommitSerialNumberButton();
        selectionCardPage.setDestinationInput("OUT109");
        selectionCardPage.getQuantityInput().shouldHave(text("10"));
        selectionCardPage.clickCommitButton();

        selectionCardPage.getProductDescription().shouldBe(visible).shouldHave(text("00010 ШТУЧНЫЙ 00010 Стол10 A.1.1.1.10 ➡ KT1.01.01.01.01 Quantity 10 шт"));
        selectionCardPage.setSourceInput("A.1.1.1.10");
        selectionCardPage.setProductInput("00010"); // set sku
        selectionCardPage.setDestinationInput("OUT110");
        selectionCardPage.setQuantityInput("10");
        selectionCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Контейнер");
    }

    @Test (priority = 4, dependsOnMethods = "processingSelectionTasksTest")
    public void processingContainerTasksTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Контейнер");
        allTasksPage.getWorkTypeTasksQuantity().click();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT101 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT101");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT102 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT102");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT103 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT103");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT104 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT104");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT105 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT105");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT106 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT106");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT107 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT107");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT108 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT108");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT109 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT109");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        containerCardPage.getContainerDescription().shouldHave(text("CON/OUT110 ➡ KT1.01.01.01.01"));
        containerCardPage.setContainerInput("OUT110");
        containerCardPage.setDestinationInput("KT1.01.01.01.01");
        containerCardPage.clickCommitButton();

        allTasksPage.checkWorkType("Control");
    }

    @Test (priority = 5, dependsOnMethods = "processingContainerTasksTest")
    public void processingControlTasksTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Control");
        allTasksPage.getWorkTypeTasksQuantity().click();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT101");
        controlCardPage.getProductInfo().shouldHave(text("0001 Стол1"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT101"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0001");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT102");
        controlCardPage.getProductInfo().shouldHave(text("0002 Стол2"));
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("Series2"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT102"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0002");
        controlCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("Series2"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.clickAlertDialogOkButton();
        controlCardPage.getSeriesInfo().shouldBe(visible).shouldHave(text("Series2"));
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT103");
        controlCardPage.getProductInfo().shouldHave(text("0003 Стол3"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT103"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0003");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT104");
        controlCardPage.getProductInfo().shouldHave(text("0004 Стол4"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT104"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0004");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0004 0001-01-01T00:00:00 Стол4"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber4", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT105");
        controlCardPage.getProductInfo().shouldHave(text("0005 Стол5"));
        controlCardPage.getSeriesInfo().shouldHave(text("series5"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT105"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0005");
        controlCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("series5"));
        controlCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.getSeriesBox().shouldHave(text("series5"));
        controlCardPage.clickAlertDialogOkButton();
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT106");
        controlCardPage.getProductInfo().shouldHave(text("0006 Стол6"));
        controlCardPage.getSeriesInfo().shouldHave(text("series6"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT106"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0006");
        controlCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("series6"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getSeriesBox().shouldHave(text("series6"));
        controlCardPage.clickAlertDialogOkButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0006 series6 0001-01-01T00:00:00 Стол6"));
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber6", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT107");
        controlCardPage.getProductInfo().shouldHave(text("0007 Стол7"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT107"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0007");
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0007 0001-01-01T00:00:00 Стол7")); //TODO BUG: incorrect expiration date
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber7", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT108");
        controlCardPage.getProductInfo().shouldHave(text("0008 Стол8"));
        controlCardPage.getSeriesInfo().shouldHave(text("series8"));
        controlCardPage.getShelfLifeInfo().shouldHave(text("31.12.2021"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT108"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0008");
        controlCardPage.getAlertDialog().shouldBe(visible).shouldHave(text("Series / shelf life"));
        controlCardPage.getAvailableSeries().shouldHave(text("series8"));
        controlCardPage.getAvailableExpirationDate().shouldHave(text("31.12.2021"));
        controlCardPage.getAvailableSeries().click();
        controlCardPage.getSeriesBox().shouldHave(text("series8"));
        controlCardPage.getExpirationDateBox().shouldHave(text("31.12.2021"));
        controlCardPage.clickAlertDialogOkButton();
        controlCardPage.getSerialNumberInput().shouldBe(visible);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0008 series8 2021-12-31T00:00:00 Стол8"));
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber8", 10);
        controlCardPage.checkSerialNumberQtyFactInEveryRow("10", 1);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT109");
        controlCardPage.getProductInfo().shouldHave(text("0009 Стол9"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT109"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("0009");
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.getSerialNumberProductInfo().shouldHave(exactText("0009 0001-01-01T00:00:00 Стол9"));
        controlCardPage.setSerialNumberInputSeveralTimes("serialnumber90", "serialnumber91", "serialnumber92", "serialnumber93", "serialnumber94", "serialnumber95", "serialnumber96", "serialnumber97", "serialnumber98", "serialnumber99");
        controlCardPage.checkSerialNumberQtyFactInEveryRow("1", 10);
        controlCardPage.checkSerialNumberInputText("");
        controlCardPage.clickCommitSerialNumberButton();
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();

        controlCardPage.setCellInput("KT1.01.01.01.01");
        controlCardPage.setContainerInput("OUT110");
        controlCardPage.getProductInfo().shouldHave(text("00010 Стол10"));
        controlCardPage.getContainerInfo().shouldHave(text("OUT110"));
        controlCardPage.getControlledQty().shouldHave(text("0"));
        controlCardPage.getQty().shouldHave(text("10"));
        controlCardPage.setItemInput("00010");
        controlCardPage.setQuantityInputInput("10");
        controlCardPage.getControlledQty().shouldNotBe(visible);
        controlCardPage.clickCommitButton();
    }

    @Test (priority = 6, dependsOnMethods = "processingControlTasksTest")
    public void processingPackagingTaskTest() throws Exception {
        steps.loginAsAdmin();

        allTasksPage.checkWorkType("Packaging");
        allTasksPage.getWorkTypeTasksQuantity().click();

        packagingPage.setCellOrContainerInput("KT1.01.01.01.01");

        packagingPage.checkCellProductInfoInRow(1, "OUT101", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(2, "OUT102", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(3, "OUT103", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(4, "OUT104", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(5, "OUT105", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(6, "OUT106", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(7, "OUT107", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(8, "OUT108", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(9, "OUT109", "10", "0.01", "0.01");
        packagingPage.checkCellProductInfoInRow(10, "OUT110", "10", "0.01", "0.01");

    }
}
