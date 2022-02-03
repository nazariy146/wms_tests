package tests.web.webCase;

import org.testng.annotations.Test;
import tests.web.webSteps.WebSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WebInterface {

    @Test
    public void webInterface() {
        WebSteps WebSteps = new WebSteps();

        WebSteps.webOpen1C();

        $("#themesCell_theme_0").click();
        $("#cmd_0_0_txt").shouldHave(text("Монитор эффективности склада"));
        $("#cmd_1_0_txt").shouldHave(text("Управление складом"));

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

        $("#themesCell_theme_2").click();
        $("#themesCell_theme_3").click();
        $("#themesCell_theme_4").click();
        $("#themesCell_theme_5").click();
        $("#themesCell_theme_6").click();
        $("#themesCell_theme_7").click();

        $("#themesCell_theme_1").click();
        $("#cmd_0_5_txt").click();
    }
}
