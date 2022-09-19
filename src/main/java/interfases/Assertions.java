package interfases;

import helpers.CustomUtilities;
import io.qameta.allure.Step;

public interface Assertions<CurrentPage> {

    @Step("Проверить, что значение '{actual}' равно значению '{expected}'")
    default CurrentPage assertEquals(Object expected, Object actual, String message) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual, message);
        CustomUtilities.screenshotPage();
        return (CurrentPage) this;
    }

    @Step("Проверить, что значение '{actual}' не null")
    default CurrentPage assertNotNull(Object actual, String message) {
        org.junit.jupiter.api.Assertions.assertNotNull(actual, message);
        CustomUtilities.screenshotPage();
        return (CurrentPage) this;
    }

    @Step("Проверить, что значение '{actual}' true")
    default CurrentPage assertTrue(boolean check, String message) {
        org.junit.jupiter.api.Assertions.assertTrue(check, message);
        CustomUtilities.screenshotPage();
        return (CurrentPage) this;
    }

}
