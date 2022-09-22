import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import teststeps.LoginSteps;

public class LoginTests extends BaseTest {

    @DisplayName("Авторизация пользователя")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("helpers.TestRunData#gp0001")
    void gp0001(String login, String password) {
        new LoginSteps()
                .grahamLogInTest(login, password)
                .checkLogin("Логин", login)
                .checkFieldIsEmpty("Пароль")
                .clickProceed()
                .checkUserName("Бурима Алексей");
    }

    @DisplayName("Запрет Авторизации")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("helpers.TestRunData#gp0002")
    void gp0002(String login, String password) {
        new LoginSteps()
                .grahamLogInTest(login, password)
                .clickProceed()
                .moveExPoint("Логин");
    }

    @DisplayName("Запрет Авторизации")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("helpers.TestRunData#gp0002_2")
    void gp0002_2(String login, String password) {
        new LoginSteps()
                .grahamLogInTest(login, password)
                .clickProceed()
                .moveExPoint("Логин", "Пароль");
    }
}