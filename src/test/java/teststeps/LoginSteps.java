package teststeps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.graham.pages.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginSteps extends Section<LoginSteps> {

    private MainPage mainGrahamPage;
    private String requiredField = "Обязательное поле";

    public LoginSteps() {
        mainGrahamPage = new MainPage();
    }

    @Step("Проверяем имя пользователя")
    public LoginSteps checkUserName(String value) {
        mainGrahamPage
                .getText(value, (name) -> assertEquals(value, name, "Имя пользователя не соответсвует заявленому"));
        return this;
    }

    @Step("Метод проверяет, что поле не пустое")
    public LoginSteps checkFieldIsEmpty(String fieldName) {
        mainGrahamPage
                .getFieldValue(fieldName, (value) -> assertTrue(!value.isEmpty(), "Поле не заполненно"));
        assertNotNull(fieldName, "Поле не заполненно");
        return this;
    }

    @Step("Метод нажимает на кнопку 'Продожить'")
    public LoginSteps clickProceed() {
        mainGrahamPage
                .clickButton("Продолжить");
        return this;
    }

    @Step("Метод проверяет правильность ввода логина")
    public LoginSteps checkLogin(String nameField, String login) {
        mainGrahamPage
                .getFieldValue(nameField, (value) -> assertEquals(login, value, "Не верный логин"));
        return this;
    }

    @Step("Метод наводит курсор на элемент 'Восклицательный знак'")
    public LoginSteps moveExPoint(String login) {
        SelenideElement selenide = $x("//input[@placeholder= '" + login + "']/../div").hover();
        mainGrahamPage
                .getText("Обязательное поле", (name) -> assertEquals(requiredField, name, "Значение не соответсвует заявленому"));
        return this;
    }

    @Step("Метод наводит курсор на элемент 'Восклицательный знак' и проверяет наличие всплывающего окна")
    public LoginSteps moveExPoint(String login, String password) {
        SelenideElement selenide = $x("//input[@placeholder= '" + login + "']/../div").hover();
        mainGrahamPage.getText("Обязательное поле", (name) -> assertEquals(requiredField, name, "Значение не соответсвует заявленому"));
        selenide = $x("//input[@placeholder= '" + password + "']/../div").hover();
        mainGrahamPage.getText("Обязательное поле", (name) -> assertEquals(requiredField, name, "Значение не соответсвует заявленому"));
        return this;
    }
}
