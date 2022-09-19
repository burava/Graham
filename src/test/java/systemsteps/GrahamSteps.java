package systemsteps;

import io.qameta.allure.Step;
import ru.graham.pages.LoginPage;

import static helpers.CustomUtilities.open;

public interface GrahamSteps<T> {

    @Step("Аутентификация в Graham")
    default T grahamLogInTest(String login, String password) {
        open("https://graham.bellintegrator.com/", LoginPage.class).login(login, password);
        return (T) this;
    }
}
