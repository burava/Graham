package ru.graham.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс PageObject для страницы Добавление виджета
 */
public class AddWidgetPage<CurrentPage,AbstractSystemPage> extends GrahamPage<AddWidgetPage> {

    @Step("Метод закрывает окно 'Добавление виджета'")
    public CurrentPage closeAddWidget() {
        $x("//div//h3[contains(text(),'Добавление виджета')]/../button").click();
        return (CurrentPage) this;
    }
}
