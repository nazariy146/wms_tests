package tests.mobile.mobileForm;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.MobileSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MobileFormSerialNumber {
    MobileSteps mobileSteps = new MobileSteps();

    private static SelenideElement getResourceId(String field) {
        switch (field) {
            case "#serialNumber":
                return $(By.id("com.abmcloud:id/editTextSerialNumber"));
            case "#commit":
                return $(By.id("com.abmcloud:id/buttonSNCommit"));
        }
        return null;
    }

    private SelenideElement getXpathTable(int row, int column) {
        return $(By.xpath("//android.view.ViewGroup["+row+"]/android.widget.LinearLayout/android.widget.EditText["+column+"]"));
    }

    public void unique(String SN, int qtySN) {
        SelenideElement resourceId_SerialNumber, resourceId_TableSerialNumber, resourceId_TableQtyFact, resourceId_Commit;
        int tableSerialNumber = 1, tableQty = 2, tableQtyFact = 3;

        resourceId_SerialNumber = getResourceId("#serialNumber");
        resourceId_Commit = getResourceId("#commit");

        for (int i = 0, row = 2; i < qtySN; i++, row++) {
            String nowSN = SN + "serialnumber0" + i;
            resourceId_TableSerialNumber = getXpathTable(row, tableSerialNumber);
            resourceId_TableQtyFact = getXpathTable(row, tableQtyFact);

            mobileSteps.inputData(resourceId_SerialNumber, nowSN);
            mobileSteps.verifyData(resourceId_TableSerialNumber, nowSN);
            mobileSteps.verifyData(resourceId_TableQtyFact, "1");
        }
        mobileSteps.clickButton(resourceId_Commit);
    }

    public void uniqueSn(String SN, int qtySN) {
        SelenideElement resourceId_SerialNumber, resourceId_TableSerialNumber, resourceId_TableQtyFact, resourceId_Commit;
        int tableSerialNumber = 1, tableQty = 2, tableQtyFact = 3;

        resourceId_SerialNumber = getResourceId("#serialNumber");
        resourceId_Commit = getResourceId("#commit");

            for (int i = 1, row = 3; i <= qtySN; i++, row++) {
                String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "0" + i;
                resourceId_TableSerialNumber = getXpathTable(row, tableSerialNumber);
                resourceId_TableQtyFact = getXpathTable(row, tableQtyFact);

                mobileSteps.inputData(resourceId_SerialNumber, nowSN);
                mobileSteps.verifyData(resourceId_TableSerialNumber, nowSN);
                mobileSteps.verifyData(resourceId_TableQtyFact, "1");
            }
        mobileSteps.clickButton(resourceId_Commit);
        }

    public void qr(String SN, int qtySN) {
        SelenideElement resourceId_SerialNumber, resourceId_TableSerialNumber, resourceId_TableQtyFact, resourceId_Commit;
        int tableSerialNumber = 1, tableQty = 2, tableQtyFact = 3;

        resourceId_SerialNumber = getResourceId("#serialNumber");
        resourceId_Commit = getResourceId("#commit");

        for (int i = 0, row = 5; i < qtySN; i++, row++) {
            String nowSN = SN + "FRAGSN" + SN + "Series01" + "31122022" + "0" + i;
            resourceId_TableSerialNumber = getXpathTable(row, tableSerialNumber);
            resourceId_TableQtyFact = getXpathTable(row, tableQtyFact);

            mobileSteps.inputData(resourceId_SerialNumber, nowSN);
            mobileSteps.verifyData(resourceId_TableSerialNumber, nowSN);
            mobileSteps.verifyData(resourceId_TableQtyFact, "1");
            }
        mobileSteps.clickButton(resourceId_Commit);
        }
    }
