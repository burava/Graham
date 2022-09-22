package ru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import interfases.Assertions;
import interfases.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Базовый класс для всех страниц. Реализует основные методы взаимодействия со страницей
 *
 * @param <CurrentPage>
 * @param <AbstractSystemPage>
 */

public abstract class BasePage<CurrentPage, AbstractSystemPage> implements Clickable<CurrentPage, AbstractSystemPage>,
        Fields<CurrentPage>, Waits<CurrentPage>, Assertions<CurrentPage> {


    public BasePage() {
        System.out.println("Конструктор base");
    }

    protected static final long TIMEOUT = 6000L;

    protected String textXpath = "//*[contains(text(), '%s')]";
    protected String linkXpath = null;
    protected String buttonXpath = "//*button[contains(text(),'%s')]";
    protected String radioButtonXpath = null;
    protected String tabXpath = null;
    protected String inputFieldXpath = "//*[contains(text(), '%s')]";
    protected String selectFieldXpath = null;
    protected String infoFieldXpath = null;
    protected String checkboxFieldXpath = null;

    /**
     * Метод формирует xpath элемента на основе шаблона и переданных параметров
     *
     * @param xpath          шаблон селектора
     * @param nameParameter  название элемнета
     * @param orderParameter порядковый номер элемента на странице
     * @return xpath конкретного элемента на странице
     */

    protected String formXpath(String xpath, String nameParameter, int orderParameter) {
        String orderXpath = ("(%s)[order_template_placeholder]");
        return xpath != null ? String.format(orderXpath, xpath).replace("%s", nameParameter).replace("order_template_placeholder",
                String.valueOf(orderParameter)) : null;
    }

    /**
     * Метод возвращает web-элемент со страницы xpath
     *
     * @param xpath селектор элемента
     * @return web-элемент
     */
    protected SelenideElement getElement(String xpath) {
        System.out.println(xpath);
        assertNotNull(xpath, "Не определен XPath для поиска элемента");
        return $x(xpath);
    }

    /**
     * Метод возвращает полный текст элемента, коорый содержит переданный текст
     *
     * @param text  текст, по которому будет найден элемент
     * @param saver метод, которому будет передан результат
     * @return экземпляр страницы, у которой вызван метод
     */
    public CurrentPage getText(String text, Consumer<String> saver) {
        getText(text, 1, saver);
        return (CurrentPage) this;
    }

    /**
     * Метод возвращает полный текст элемента, коорый содержит переданный текст
     *
     * @param text  текст, по которому будет найден элемент
     * @param order порядковый номер элемента на странице
     * @param saver метод, которому будет передан результа
     * @return экземпляр страницы, у которой вызван метод
     */
    @Step("Получить текст элемента содержащего текст '{text}'")
    public CurrentPage getText(String text, int order, Consumer<String> saver) {
        System.out.println(text);
        System.out.println(textXpath);
        System.out.println(inputFieldXpath);
        saver.accept(getElement(formXpath(textXpath, text, order)).should(Condition.visible, Duration.ofMillis(TIMEOUT)).getText());
        return (CurrentPage) this;
    }

    public SelenideElement getField(String fieldName) {
        SelenideElement inputField = getElement(formXpath(inputFieldXpath, fieldName, 1));
        System.out.println(inputField);
        if (selectFieldXpath == null) {
            return inputField;
        }
        SelenideElement selectField = getElement(formXpath(selectFieldXpath, fieldName, 1));
        return (inputField.exists() ? inputField : selectField);
    }

    @Step("Очистить значение поля")
    public CurrentPage clearField(SelenideElement fieldName) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].value = '';", fieldName);
        return (CurrentPage) this;
    }

    @Step("Заполнить поле {fieldName} значением {fieldValue}")
    public CurrentPage setFieldValue(String fieldName, String fieldValue) {
        SelenideElement inputField = getElement(formXpath(inputFieldXpath, fieldName, 1)).should(Condition.visible, Duration.ofMillis(TIMEOUT));
        clearField(inputField);
        inputField.setValue(fieldValue);
        return (CurrentPage) this;
    }

    @Step("Получить значение поля {fieldName}")
    public CurrentPage getFieldValue(String fieldName, Consumer<String> saver) {
        saver.accept((getField(fieldName)).should(Condition.visible, Duration.ofMillis(TIMEOUT)).getValue());
        return (CurrentPage) this;
    }

    public CurrentPage clearField(String fieldName) {
        clearField(getField(fieldName));
        return (CurrentPage) this;
    }

    public CurrentPage clickText(String text) {
        clickText(text, 1);
        return (CurrentPage) this;
    }

    public CurrentPage clickText(String text, int order) {
        clickElement(textXpath, text, order);
        return (CurrentPage) this;
    }

    public <SystemPage extends AbstractSystemPage> SystemPage clickText(String text, Class<SystemPage> nextPageType) {
        clickText(text, 1);
        return nextPageType.cast(page(nextPageType));
    }

    public <SystemPage extends AbstractSystemPage> SystemPage clickText(String text, int order, Class<SystemPage> nextPageType) {
        clickText(text, order);
        return nextPageType.cast(page(nextPageType));
    }

    // Методы для нажатия на различные элементы

    public CurrentPage clickElement(String xpath, String elementName) {
        clickElement(xpath, elementName, 1);
        return (CurrentPage) this;
    }

    public CurrentPage clickElement(String xpath, String elementName, int order) {
        getElement(formXpath(xpath, elementName, order)).should(Condition.visible, Duration.ofMillis(TIMEOUT)).click();
        return (CurrentPage) this;
    }

    // методы для нажатия на ссылку

    @Step("Нажать на ссылку содержащую текст '{linkText}'")
    public CurrentPage clickLink(String linkText, int order) {
        clickElement(linkXpath, linkText, order);
        return (CurrentPage) this;
    }

    public CurrentPage clickLink(String linkText) {
        clickLink(linkText, 1);
        return (CurrentPage) this;
    }

    public <SystemPage extends AbstractSystemPage> SystemPage clickLink(String linkText, Class<SystemPage> nextPageType) {
        clickLink(linkText, 1);
        return nextPageType.cast(page(nextPageType));
    }

    public <SystemPage extends AbstractSystemPage> SystemPage clickLink(String linkText, int order, Class<SystemPage> nextPageType) {
        clickLink(linkText, order);
        return nextPageType.cast(page(nextPageType));
    }

    // методы нажатия на кнопку

    @Step("нажать на кнопку '{buttonName}'")
    public CurrentPage clickButton(String buttonName, int order) {
        clickElement(buttonXpath, buttonName, order);
        return (CurrentPage) this;
    }

    public CurrentPage clickButton(String buttonName) {
        clickButton(buttonName, 1);
        return (CurrentPage) this;
    }

    public <SystemPage extends AbstractSystemPage> SystemPage clickButton(String buttonName, Class<SystemPage> nextPageType) {
        clickButton(buttonName, 1);
        return nextPageType.cast(page(nextPageType));
    }

    public <SystemPage extends AbstractSystemPage> SystemPage clickButton(String buttonName, int order, Class<SystemPage> nextPageType) {
        clickButton(buttonName, order);
        return nextPageType.cast(page(nextPageType));
    }

    @Step("Нажать на поле '{fieldName}'")
    public CurrentPage clickField(String fieldName) {
        getField(fieldName).should(Condition.visible, Duration.ofMillis(TIMEOUT)).click();
        return (CurrentPage) this;
    }

}
