package tests.scenarios;

import org.testng.annotations.Test;
import tests.BaseMobileClass;
import tests.pages.mobilePages.AccommodationCardPage;
import tests.pages.mobilePages.AllTasksPage;
import tests.pages.mobilePages.FindRestsPage;
import tests.pages.mobilePages.ReceptionCardPage;
import tests.steps.Steps;

import static com.codeborne.selenide.Condition.*;

public class WorkWithDailyTasksTest extends BaseMobileClass {

    Steps steps = new Steps();
    AllTasksPage allTasksPage = new AllTasksPage();
    ReceptionCardPage receptionCardPage = new ReceptionCardPage();
    AccommodationCardPage accommodationCardPage = new AccommodationCardPage();
    FindRestsPage findRestsPage = new FindRestsPage();

    @Test
    public void processingReceptionTasksTest() {
        steps.loginAsAdmin();

        allTasksPage.getReceptionWorkType().shouldHave(text("Reception"));
        allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getReceptionQuantity().click();

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
        receptionCardPage.setProductInput("0008"); // set sku
        receptionCardPage.getAlertDialog().shouldHave(text("Series / shelf life"));
        receptionCardPage.getExpirationDateInput().sendKeys("31.12.2021");
        receptionCardPage.createNewSeries("series8");
        receptionCardPage.clickSetButton();
        receptionCardPage.getSerialNumberInput().shouldBe(visible);
        receptionCardPage.checkSerialNumberInputText("");
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

        allTasksPage.getReceptionWorkType().shouldHave(text("Accommodation"));
    }

    @Test (priority = 1)
    public void processingAccommodationTasksTest() {
        steps.loginAsAdmin();

        allTasksPage.getReceptionWorkType().shouldHave(text("Accommodation"));
        //allTasksPage.getReceptionQuantity().shouldHave(text("10")); // by default 10
        allTasksPage.getReceptionQuantity().click();

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
        accommodationCardPage.setProductInput("00010"); // set barcode
        accommodationCardPage.setDestinationInput("A.1.1.1.10");
        accommodationCardPage.setQuantityInput("10");
        accommodationCardPage.clickCommitButton();

        allTasksPage.getRelaxMessage().shouldBe(visible).shouldHave(text("There is no available tasks for you."));
    }

    @Test (priority = 2)
    public void checkingFreeAmountTest() {
        steps.loginAsAdmin();

        allTasksPage.getRelaxMessage().shouldBe(visible).shouldHave(text("There is no available tasks for you."));
        allTasksPage.selectFindRestsMenu();

        findRestsPage.setBarcodeInput("0001"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0001 ШТУЧНЫЙ 00001 Стол1"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.1");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0002"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0002 00002 Стол2"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.2");
        findRestsPage.checkProductSeriesInfo("Series2");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0003"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0003 00003 Стол3"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.3");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0004"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0004 00004 Стол4"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.4");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0005"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0005 00005 Стол5"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.5");
        findRestsPage.checkProductSeriesInfo("series5");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0006"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0006 00006 Стол6"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.6");
        findRestsPage.checkProductSeriesInfo("series6");
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0007"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0007 00007 Стол7"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.7");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0008"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0008 00008 Стол8"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.8");
        findRestsPage.checkProductSeriesInfo("series8");
        findRestsPage.checkProductShelfLifeInfo("31-12-2021");
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("0009"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("0009 00009 Стол9"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.9");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));

        findRestsPage.setBarcodeInput("00010"); // set sku
        findRestsPage.getProductDescription().shouldHave(text("00010 ШТУЧНЫЙ 00010 Стол10"));
        findRestsPage.checkProductLocationInfo("A.1.1.1.10");
        findRestsPage.getProductSeriesInfo().shouldNotBe(visible);
        findRestsPage.getProductShelfLifeInfo().shouldNotBe(visible);
        findRestsPage.getProductQuantity().shouldHave(exactText("10"));
    }

}
