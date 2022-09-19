package ru;

import com.codeborne.selenide.SelenideElement;

import java.util.function.Consumer;

public interface Fields<CurrentPage> {

    /**
     * Метод возвращает web-элемент поля по названию
     *
     * @param fieldName название поля
     * @return web-элемент
     */
    SelenideElement getField(String fieldName);

    /**
     * Метод получает значение поля
     *
     * @param fieldName название поля
     * @param saver метод, которому будет передано значение поля
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage getFieldValue(String fieldName, Consumer<String> saver);

    /**
     * Метод устанавливает значение в поле
     *
     * @param fieldName название поля
     * @param fieldValue значение, которое необходимо установить
     * @return экземпляр страницы, у которой вызван метод
     */
    CurrentPage setFieldValue(String fieldName, String fieldValue);

    /**
     * Метод очищает поле
     *
     * @param fieldName название поля
     * @return экземпляр страницы, у котрой вызван метод
     */
    CurrentPage clearField(String fieldName);

}
