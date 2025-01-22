package tests;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.logevents.SelenideLogger.step;



public  class TbankTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода на страницу для поиска вакансий")
    void ConditionsTests() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу 'Карьера'", () -> {
            open("/career");
        });
        step("Нажимаем 'Смотреть вакансии'", () -> {
            $("a[href*='/career/vacancies']").click();
        });
        step("Проверяем, что на странице содержится заголовок 'Вакансии'", () -> {
            $(".Title__title_a1a5J3").shouldHave(text("Вакансии"));
        });
    }

    @Test
    @DisplayName("Выбор фильра Работа в ИТ")
    void selectFilter() {
        step("Открываем страницу 'Карьера'", () -> {
            open("/career");
        });
        step("Нажимаем 'Смотреть вакансии'", () -> {
            $("a[href*='/career/vacancies']").click();
        });
        step("Выбираем фильтр 'Работа в ИТ'", () -> {
            $("label[data-qa-type='fitem:option:it'] input").click();
        });
        step("Проверяем, что на странице содержится заголовок 'Вакансии в ИТ'", () -> {
            $(".Title__title_a1a5J3").shouldHave(text("Вакансии в ИТ"));
        });
    }

    @Test
    @DisplayName("Проверка выбора чекбокса 'Тестирование' и проверка наличия вакансии 'QA-инженер (backend)'")
    void selectTestingCheckboxTest() {
        step("Открываем страницу с вакансиями", () -> {
            open("/career/vacancies");
        });

        step("Выбираем фильтр 'Работа в ИТ'", () -> {
            // Находим и кликаем фильтр 'Работа в ИТ'
            $("label[data-qa-type='fitem:option:it'] input").click();
        });

        step("Нажимаем на кнопку 'Показать еще' в модуле 'Направление'", () -> {
            // Находим кнопку 'Показать еще' и кликаем по ней
            $("[data-qa-type='fitem:specialty:show-more-btn']").click();
        });

        step("Выбираем чекбокс 'Тестирование' в модуле 'Направление'", () -> {
            // Находим чекбокс с профессией 'Тестирование' и кликаем по нему
            $("[data-qa-type='fitem:option:testirovanie.fieldWrapper']").click();
        });
        step("Ищем вакансию 'Инженер по автоматизации тестирования (Java/Kotlin)'", () -> {
            // Ищем вакансию с нужным названием по классу и проверяем наличие текста
            $(".IndependentPfpJobsVacanciesCatalogNew__cards_cK3abZ").shouldHave(text("Инженер по автоматизации тестирования (Java/Kotlin)"));
        });


    }

    @Test
    @DisplayName("Проверка информации на странице  'Инженер по автоматизации тестирования (Java/Kotlin)'")
    void CheckVacancy() {
        step("Открываем страницу с вакансией", () -> {
            open("/career/it/testirovanie/inzhener-po-avtomatizacii-testirovaniya-javakotlin/");
        });
        step("Проверяем, что на странице содержатся разделы 'Описание', 'Обязанности' и 'Требования'", () -> {
            $(".dyzaXu")
                    .shouldHave(text("Описание"))
                    .shouldHave(text("Обязанности"))
                    .shouldHave(text("Требования"))
                    .shouldHave(text("Мы предлагаем"));
        });
    }
    @Test
    @DisplayName("Отклик на вакансию")
    void selectRespondTest() {
        step("Открываем страницу с вакансией", () -> {
            open("/career/it/testirovanie/inzhener-po-avtomatizacii-testirovaniya-javakotlin/");
        });
        step("Нажимаем на кнопку 'Откликнуться'", () -> {
            $("button[data-qa-type='uikit/button']")
                    .shouldHave(text("Откликнуться"))
                    .click();
        });

        step("Проверяем, что на странице появляется форма отклика", () -> {
            $("div[data-qa-type='fb-core/constructor']").shouldBe(visible);
        });
        step("Заполняем поля формы", () -> {

            $("[data-qa-type='uikit/inputFio.value.input']")
                    .sendKeys("Иванов Иван");

            $("input[data-qa-type='uikit/inputAutocomplete.value.input']")
                    .sendKeys("Москва");

            $("[data-qa-type='uikit/dropdown.item']").click();

            $("input[data-qa-type='uikit/input.value.input']")
                    .sendKeys("test@example.com");

            $("input[data-qa-type='uikit/attachFile.input']")
                    .uploadFromClasspath("Melgunova Darya.pdf");
        });
        step("Отправить", () -> {
            $$("[data-qa-type='uikit/button']")
                    .findBy(text("Отправить"))
                    .click();
        });

    }
    }



