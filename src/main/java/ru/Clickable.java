package ru;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;

public interface Clickable<CurrentPage, AbstractSystemPage> {

    Condition CLICKABLE = and("can be clicked", visible, enabled);

    /**
     * Метод нажимает на web-элемент
     *
     * @param xpath       шаблон xpath селектор
     * @param elementName название элемента
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickElement(String xpath, String elementName);

    /**
     * Метод нажимает на web-элемент
     *
     * @param xpath       шаблон xpath селектор
     * @param elementName название жлемнета
     * @param order       порядковый номер элемента на странице
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickElement(String xpath, String elementName, int order);

    /**
     * Метода нажиает на элемент содержащий текст
     *
     * @param text текст
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickText(String text);

    /**
     * Метода нажиает на элемент содержащий текст
     *
     * @param text  текст
     * @param order порядковый номер элемента на странице
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickText(String text, int order);

    /**
     * Метода нажиает на элемент содержащий текст
     *
     * @param text         текст
     * @param nextPageType тип следующей страницы системы
     * @return экземляр класса следующей страницы системы
     */
    <SystemPage extends AbstractSystemPage> SystemPage clickText(String text, Class<SystemPage> nextPageType);

    /**
     * Метода нажиает на элемент содержащий текст
     *
     * @param text         текст
     * @param order        порядковый номер элемента на странице
     * @param nextPageType тип следующей страницы системы
     * @return экземпляр класса следующей страницы системы
     */
    <SystemPage extends AbstractSystemPage> SystemPage clickText(String text, int order, Class<SystemPage> nextPageType);

    /**
     * Метода нажиает на ссылку содержащий текст
     *
     * @param link текст ссылки
     * @return экземпляр страницы, у которой вызваниметод
     */
    CurrentPage clickLink(String link);

    /**
     * Метода нажиает на ссылку содержащий текст
     *
     * @param link  текст
     * @param order порядковый номер элемента на странице
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickLink(String link, int order);

    /**
     * Метода нажиает на ссылку содержащий текст
     *
     * @param link         текст
     * @param nextPageType тип следующей страницы системы
     * @return экземпляр класса следующей страницы системы
     */
    <SystemPage extends AbstractSystemPage> SystemPage clickLink(String link, Class<SystemPage> nextPageType);

    /**
     * Метода нажиает на ссылку содержащий текст
     *
     * @param link         текст
     * @param order        порядковый номер элемента на странице
     * @param nextPageType тип следующей страницы системы
     * @param <SystemPage> экземпляр класса следующей страницы
     * @return экземпляр класса следующей страницы системы
     */
    <SystemPage extends AbstractSystemPage> SystemPage clickLink(String link, int order, Class<SystemPage> nextPageType);


    /**
     * Метод нажимает на кнопку
     *
     * @param buttonName название кнопки
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickButton(String buttonName);

    /**
     * Метож нажимает на кнопку
     *
     * @param buttonName название кнопки
     * @param order      порядковый номер элемента на странице
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickButton(String buttonName, int order);

    /**
     * Метод нажимает на кнопку
     *
     * @param buttonName   название кнопки
     * @param nextPageType тип следующей страницы системы
     * @return экземпляр класса следующей страницы
     */
    <SystemPage extends AbstractSystemPage> SystemPage clickButton(String buttonName, Class<SystemPage> nextPageType);

    /**
     * Метод нажимает на кнопку
     *
     * @param buttonName   название кнопки
     * @param order        порядковый номер элемента на странице
     * @param nextPageType тип следующей страницы системы
     * @return экземпляр класса следующей страницы
     */
    <SystemPage extends AbstractSystemPage> SystemPage clickButton(String buttonName, int order, Class<SystemPage> nextPageType);

    /**
     * Метод нажимает на поле
     *
     * @param fieldName назавние поля
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage clickField(String fieldName);
}
