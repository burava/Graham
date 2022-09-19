package teststeps;

import io.qameta.allure.Step;
import ru.graham.pages.MainPage;

public class LoginSteps extends Section<LoginSteps> {
    private MainPage mainGrahamPage;

    public LoginSteps() {
        mainGrahamPage = new MainPage();
    }

    @Step("Проврека на существование пользователя")
    public LoginSteps checkExistUser(String name) {
        mainGrahamPage
                .getField("//font[contains(text(),'" + name + "')]");
        assertNotNull(name, "Пользователь не найден");
        return this;
    }

    @Step("Проверяем имя пользователя")
    public LoginSteps checkUserName(String value) {
        mainGrahamPage
                .getText(value, (name) -> assertEquals(value, name, "Имя пользователя не соответсвует заявленому"));
        return this;
    }

    @Step("проверить значение")
    public LoginSteps actual1(String value) {
        mainGrahamPage
                .clickButton(value, 1);
        return this;
    }

    @Step("проверить значение")
    public LoginSteps actual2(String value) {
        mainGrahamPage

                .getText("Добавление виджета", (name) -> assertEquals(value, name, "ок"));
        return this;
    }
}