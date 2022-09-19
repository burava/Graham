package systemsteps;

import io.qameta.allure.Step;
import ru.graham.pages.LoginPage;

import static helpers.CustomUtilities.open;

public interface GrahamSteps<T> {

    @Step("Аутентификация в Graham")
    default T grahamAuthenticateWIth(String login, String password) {
        open("https://graham.bellintegrator.com/", LoginPage.class).login(login, password);
        return (T) this;
    }

    @Step("Аутентификация в Graham с ролью")
    default T grahamLogIn() {
        grahamAuthenticateWIth("ABurima","add2X8s4f8");
        return (T) this;

    }
    @Step("Аутентификация в Graham с ролью")
    default T grahamLogInTest(String login, String password) {
        grahamAuthenticateWIth(login,password);
        return (T) this;

    }
}
