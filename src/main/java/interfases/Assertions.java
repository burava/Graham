package interfases;

import io.qameta.allure.Step;

public interface Assertions<CurrentPage> {

    @Step("Проверить, что значение '{actual}' равно значению '{expected}'")
    default CurrentPage assertEquals(Object expected, Object actual, String message) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual, message);
        return (CurrentPage) this;
    }

    @Step("Проверить, что значение '{actual}' не null")
    default CurrentPage assertNotNull(Object actual, String message) {
        org.junit.jupiter.api.Assertions.assertNotNull(actual, message);
        return (CurrentPage) this;
    }
}
