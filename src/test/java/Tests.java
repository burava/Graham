import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import teststeps.LoginSteps;

public class Tests extends BaseTest {

    @Test
    @DisplayName("Проверка 1")
    public void firstTest() {
        new LoginSteps().grahamLogIn()
                .checkUserName("Бурима Алексей")
                .actual1("Добавить виджет")
                .actual2("Добавление виджета");
    }

    @Test
    @DisplayName("Проверка 2")
    void secondTest() {
        new LoginSteps().grahamLogIn()
                .checkUserName("Бурима Алексей")
                .actual1("Добавить виджет")
                .actual2("Добавление невиджета");
    }

    @Test
    @DisplayName("Проверка 3")
    void thirdTest() {
        new LoginSteps().grahamLogIn()
                .checkUserName("Бурима Александр")
                .actual1("Добавить виджет")
                .actual2("Добавление невиджета");
    }


}
