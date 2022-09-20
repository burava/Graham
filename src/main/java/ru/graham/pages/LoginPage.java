package ru.graham.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    /**
     * Осуществляет вход в систему под пользователем
     *
     * @param username учетное имя пользователя для входа в систему
     * @param password учетный пароль пользователя для входа в систему
     * @return возвращает класс, последующего перехода в систему
     */
    @Step("Входим в Graham под пользователем")
    public MainPage login(String username, String password) {
        $x("//button[contains(text(), 'Хорошо')]").click();
        $x("//input[@name = 'login']").setValue(username);
        $x("//input[@name = 'password']").setValue(password);
        $x("//button[contains(text(), 'Продолжить')]").click();
        return Selenide.page(MainPage.class);
    }

}
