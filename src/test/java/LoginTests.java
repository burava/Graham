import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import teststeps.LoginSteps;

public class LoginTests extends BaseTest {

    @DisplayName("Авторизация")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("helpers.TestRunData#gp0001")
    void gp0001(String login,String password){
        new LoginSteps()
                .grahamLogInTest(login,password)
                .checkUserName("Бурима Алексей");
    }
}