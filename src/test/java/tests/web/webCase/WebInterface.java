package tests.web.webCase;

import org.testng.annotations.Test;
import tests.web.webSteps.WebSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WebInterface {

    @Test
    public void webInterface() {
        WebSteps webSteps = new WebSteps();
        WebInterface webInterface = new WebInterface();

        webSteps.webOpen1C();                       //запуск 1с
        this.menuQuick();                   //меню Главное
        this.menuReceiving();               //меню Приход
        this.menuShipment();                //меню Отгрузка
        this.menuInventory();               //меню Запасы
        this.menuReports();                 //меню Отчеты
        this.menuBilling();                 //меню Биллинг
        this.menuCrossTransit();            //меню Кросс транзит
        this.menuTransportDelivery();       //меню Доставка
        this.menuDirectories();             //меню Справочники
        this.menuSettings();                //меню Администрирование
        this.menuExchange();                //меню Обмен УС
        this.menuDevelopment();             //меню Разработка
    }                   //старт проверки интерфейса

    public void menuQuick(){                        //меню Главное
        $("#themesCell_theme_0").click();
        $("#cmd_0_0_txt").shouldHave(text("Монитор эффективности склада"));
        $("#cmd_1_0_txt").shouldHave(text("Управление складом"));
    }                       //меню Главное

    public void menuReceiving () { //меню Приход
        $("#themesCell_theme_1").click();
        $("#cmd_0_0_txt").shouldHave(text("Контроль поставки"));
        $("#cmd_0_1_txt").shouldHave(text("РМ Возврата товаров"));
        $("#cmd_0_2_txt").shouldHave(text("Учет дополнительных работ"));
        $("#cmd_0_3_txt").shouldHave(text("Прием товара"));
        $("#cmd_0_4_txt").shouldHave(text("Проблемная ситуация"));
        $("#cmd_0_5_txt").shouldHave(text("Рекламация"));
        $("#cmd_0_6_txt").shouldHave(text("Анализ загруженности склада"));
        $("#cmd_0_7_txt").shouldHave(text("Загруженность склада"));
        $("#cmd_0_8_txt").shouldHave(text("Изменения статусов номенклатуры"));
        $("#cmd_0_9_txt").shouldHave(text("К отбору"));
        $("#cmd_0_10_txt").shouldHave(text("Логирование изменения движений"));
        $("#cmd_0_11_txt").shouldHave(text("Назначенные ресурсы документам"));
        $("#cmd_0_12_txt").shouldHave(text("Резерв размещения"));
        $("#cmd_1_0_txt").shouldHave(text("Генератор временных контейнеров"));
        $("#cmd_1_1_txt").shouldHave(text("Контроль поставки"));
        $("#cmd_1_2_txt").shouldHave(text("Дополнительные обработки"));
        $("#cmd_1_3_txt").shouldHave(text("Дополнительные отчеты"));
        $("#cmd_1_4_txt").shouldHave(text("Поиск документов по контейнеру / грузоместу"));
        $("#cmd_1_5_txt").shouldHave(text("Учет дополнительных работ"));
        $("#cmd_1_6_txt").shouldHave(text("Распределение позиций между ресурсами"));
    }                 //меню Приход

    public void menuShipment(){ //меню Отгрузка
        $("#themesCell_theme_2").click();

    }                    //меню Отгрузка

    public void menuInventory(){
        $("#themesCell_theme_3").click();

    }                   //меню Запасы

    public void menuReports(){ //меню Отчеты
        $("#themesCell_theme_4").click();


    }                     //меню Отчеты

    public void menuBilling(){ //меню Биллинг
        $("#themesCell_theme_5").click();





    }                     //меню Биллинг

    public void menuCrossTransit(){ //меню Кросс транзит
        $("#themesCell_theme_6").click();




    }                //меню Кросс транзит

    public void menuTransportDelivery(){ //меню Доставка
        $("#themesCell_theme_7").click();




    }           //меню Доставка

    public void menuDirectories(){ //меню Справочники





    }                    //меню Справочники

    public void menuSettings(){ //меню Администрирование




    }                       //меню Администрирование

    public void menuExchange(){ //меню Обмен УС




    }                       //меню Обмен УС

    public void menuDevelopment(){ //меню Разработка




    }                    //меню Разработка

}
