package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.logevents.SelenideLogger.step;



public  class TbankTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода на страницу для поиска вакансий")
    void ConditionsTests() {
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
    @DisplayName("Выбор фильра Работа в ИТ" )
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
            $("label[data-qa-type='fitem:option:it'] input").click();
        });

        step("Нажимаем на кнопку 'Показать еще' в модуле 'Направление'", () -> {
            // Кликаем по кнопке "Показать еще"
            $("span[data-qa-type='fitem:specialty:show-more-btn.content']").click();
        });

        step("Прокручиваем страницу до чекбокса 'Тестирование' в разделе 'Направление'", () -> {
            // Прокручиваем страницу до элемента с текстом "Тестирование"
            $("span[data-qa-type='fitem:option:testirovanie.text']").scrollTo();
        });

        step("Выбираем чекбокс 'Тестирование' в модуле 'Направление'", () -> {
            // Находим чекбокс с данным data-qa-type и кликаем по нему
            $("input[data-qa-type='fitem:option:testirovanie.input.input']").click();
        });
        step("Проверяем, что на странице содержится вакансия 'QA-инженер (backend)'", () -> {
            $(".IndependentPfpJobsVacanciesCatalogNew__cards_cK3abZ").shouldHave(text("QA-инженер (backend)"));
        });
    }
    @Test
    @DisplayName("Проверка выбора чекбокса 'Тестирование' и проверка наличия вакансии 'QA-инженер (backend)'")
    void selectRespondTest() {
        step("Открываем страницу с вакансиями", () -> {
            open("/career/vacancies");
        });

        step("Выбираем фильтр 'Работа в ИТ'", () -> {
            $("label[data-qa-type='fitem:option:it'] input").click();
        });

        step("Нажимаем на кнопку 'Показать еще' в модуле 'Направление'", () -> {
            // Кликаем по кнопке "Показать еще"
            $("span[data-qa-type='fitem:specialty:show-more-btn.content']").click();
        });

        step("Прокручиваем страницу до чекбокса 'Тестирование' в разделе 'Направление'", () -> {
            // Прокручиваем страницу до элемента с текстом "Тестирование"
            $("span[data-qa-type='fitem:option:testirovanie.text']").scrollTo();
        });

        step("Выбираем чекбокс 'Тестирование' в модуле 'Направление'", () -> {
            // Находим чекбокс с данным data-qa-type и кликаем по нему
            $("input[data-qa-type='fitem:option:testirovanie.input.input']").click();
        });
        step("Проверяем, что на странице содержится вакансия 'QA-инженер (backend)'", () -> {
            $(".IndependentPfpJobsVacanciesCatalogNew__cards_cK3abZ").shouldHave(text("QA-инженер (backend)"));
        });
        step("Откликаемся на вакансию", () -> {
            // Кликаем по кнопке 'Откликнуться'
            $("span[data-qa-type='uikit/button.content']").click();
        });
    }
}


