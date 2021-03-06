package tests.mobile.mobilePagesRefactor;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import tests.mobile.mobileSteps.MobileSteps;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ReceptionCardPage {
    MobileSteps mobileSteps = new MobileSteps();

    AndroidDriver driver;

    public static SelenideElement getIdField(String Field) {
        if (Field == "source"){
            return $(By.id("com.abmcloud:id/editTextControlSource"));
        }
        else if (Field == "product"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "productInfo"){
            //return $(By.id("com.abmcloud:id/textViewControlDescription")); -MNV release4 need dell
            return $(By.id("com.abmcloud:id/textViewDescription")); //- release5
        }
        else if (Field == "container"){
            return $(By.id("com.abmcloud:id/editTextControlDestination"));
        }
        else if (Field == "qty"){
            return $(By.id("com.abmcloud:id/editTextControlQty"));
        }
        else if (Field == "commit"){
            return $(By.id("com.abmcloud:id/buttonControlCommit"));
        }
        else if (Field == "newShelfLife"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        else if (Field == "expirationDate"){
            return $(By.id("com.abmcloud:id/et_shelf_life"));
        }
        else if (Field == "serialNumberInputText"){ //MNV после Рефакторинга удалить
            return $(By.id("com.abmcloud:id/editTextSerialNumber"));
        }
        else if (Field == "commitSN"){ //MNV после Рефакторинга удалить
            return $(By.id("com.abmcloud:id/buttonSNCommit"));
        }
        else if (Field == "palletWeight"){
            return $(By.id("com.abmcloud:id/editTextPalletWeight"));
        }
        else if (Field == "tareQty"){
            return $(By.id("com.abmcloud:id/editTextTareQty"));
        }
        else if (Field == "tareWeight"){
            return $(By.id("com.abmcloud:id/editTextTareWeight"));
        }
        else if (Field == "heightSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_height"));
        }
        else if (Field == "widthSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_width"));
        }
        else if (Field == "lenghtSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_length"));
        }
        else if (Field == "newSeries"){
            return $(By.id("com.abmcloud:id/et_series"));
        }
        else if (Field == "createNewShelfLife"){
            return $(By.id("com.abmcloud:id/textBoxShelfLifeLP"));
        }
        else if (Field == "getProductDescription"){
            return $(By.id("com.abmcloud:id/textViewControlDescriptionLayout"));
        }
        else if (Field == "productInfoSN"){
            return $(By.id("com.abmcloud:id/textViewInfo"));
        }
        else if (Field == "cancelSN"){
            SelenideElement a = $(By.id("com.abmcloud:id/buttonSNCancel"));
            return $(By.id("com.abmcloud:id/buttonSNCancel"));
        }
        else if (Field == "cancel"){
            return $(By.id("android:id/button2"));
        }
        else if (Field == "fieldProduct"){
            return $(By.id("com.abmcloud:id/editTextControlBoxBarcode"));
        }
        else if (Field == "modalDialogTitle"){
            return $(By.id("com.abmcloud:id/alertTitle"));
        }
        else if (Field == "modalDialogOK"){
            return $(By.id("android:id/button1"));
        }
        else if (Field == "modalDialogErrorOK"){
            return $(By.id("android:id/button2"));
        }
        else if (Field == "modalDialogMessage"){
            return $(By.id("android:id/message"));
        }
        else if (Field == "editBarcode"){
            return $(By.id("com.abmcloud:id/ib_edit"));
        }
        else if (Field == "selectBarcode"){
            return $(By.id("com.abmcloud:id/tv_barcode"));
        }
        else if (Field == "weightSKU"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_weight"));
        }
        else if (Field == "clearProductInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[1]"));
        }
        else if (Field == "clearContainerInput"){
            return $(By.xpath("(//android.widget.ImageButton[@content-desc=\"Clear text\"])[2]"));
        }
        else if (Field == "unitAmount"){
            return $(By.id("android:id/text1"));
        }
        else if (Field == "packaging"){
            return $(By.id("com.abmcloud:id/labelHintControl"));
        }
        else if (Field == "package"){
            return $(By.id("com.abmcloud:id/tv_packing"));
        }
        else if (Field == "newSku"){
            return $(By.id("com.abmcloud:id/ib_add"));
        }
        else if (Field == "palletFlag"){
            return $(By.id("com.abmcloud:id/sw_pallet"));
        }
        else if (Field == "pallet"){
            return $(By.id("com.abmcloud:id/et_pallet"));
        }
        else if (Field == "palletEdit"){
            return $(By.id("com.abmcloud:id/ib_pallet"));
        }
        else if (Field == "layerFlag"){
            return $(By.id("com.abmcloud:id/sw_layer"));
        }
        else if (Field == "layer"){
            return $(By.id("com.abmcloud:id/et_layer"));
        }
        else if (Field == "boxFlag"){
            return $(By.id("com.abmcloud:id/sw_box"));
        }
        else if (Field == "box"){
            return $(By.id("com.abmcloud:id/et_box"));
        }
        else if (Field == "boxEdit"){
            return $(By.id("com.abmcloud:id/ib_box"));
        }
        else if (Field == "groupFlag"){
            return $(By.id("com.abmcloud:id/sw_group"));
        }
        else if (Field == "group"){
            return $(By.id("com.abmcloud:id/et_group"));
        }
        else if (Field == "groupEdit"){
            return $(By.id("com.abmcloud:id/ib_group"));
        }
        else if (Field == "BaseFlag"){
            return $(By.id("com.abmcloud:id/sw_base"));
        }
        else if (Field == "base"){
            return $(By.id("com.abmcloud:id/et_base"));
        }
        else if (Field == "skuQty"){
            return $(By.id("com.abmcloud:id/et_unit_parameters_ratio"));
        }
        else if (Field == "skuName"){
            return $(By.id("com.abmcloud:id/tv_base_unit"));
        }
        else if (Field == "skuName"){
            return $(By.id("com.abmcloud:id/textinput_placeholder"));
        }
        else if (Field == "multiplicity"){  //eleo коеф.кратности ед. измерения
            return $(By.id("android:id/text1"));
        }
        else if (Field == "ChoiceOFmultiplicity"){  //eleo выбор второго коеф.измер. из списка
            return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]"));
        }
        else if (Field == "ChoicePacking"){ //eleo вызов списка доступных упаковок
            return $(By.id("com.abmcloud:id/tv_packing"));
        }
        else if (Field == "Packing42-5-4-2-1"){ //eleo //eleo выбор из списка упаковки 42-5-4-2-1
            return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]"));
        }
        else if (Field == "Choice43-5-4-3-1"){  //eleo выбор упаковки для удаления
            return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.TextView"));
        }
        else if (Field == "DeletePacking"){
            return $(By.id("com.abmcloud:id/ib_remove"));
        }
        else if (Field == "Choice43-5-4-2-1"){  //eleo выбор упаковки для редактирования
            return $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.TextView"));
        }
        else if (Field == "EditPacking"){  //eleo кнопка редактирования упаковки
            return $(By.id("com.abmcloud:id/ib_edit"));
        }
        else if (Field == "EditGroup"){  //eleo кнопка редактирования состовляющей "group" упаковки
            return $(By.id("com.abmcloud:id/ib_group"));
        }
        else if (Field == "Barcode"){   //eleo выбор поля создания штрихкода
            return $(By.id("com.abmcloud:id/et_unit_parameters_barcode"));
        }
        return null;
    }

    public void inputData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.click();
        ID.val(source);
        mobileSteps.mobileDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void verifyData(String field, String source) {
        SelenideElement ID = getIdField(field);
        ID.shouldBe(visible, Duration.ofSeconds(25));
        ID.shouldHave(text(source));
    }

    public void clickButton(String button) {
        getIdField(button).click();
    }

    //MNV need to refactor
    public void checkAmountAndPackaging(String amount, String packaging) {
        verifyData("unitAmount", amount);
        verifyData("packaging", packaging);
    }
    public void inputWidth (String field) {
        SelenideElement ID = getIdField(field);
        ID.click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void selectModalDialog(String field, String source) {
        getIdField(field).click();
        SelenideElement Element1 = $$(By.id("android:id/text1")).find(exactText(source));
        Element1.getId();
        Element1.getClass();
        Element1.click();
    }
    //MNV need to refactor

    //MNV need to dell
    //MNV need to dell
}