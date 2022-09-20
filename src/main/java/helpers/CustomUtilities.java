package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class CustomUtilities {

    @Step("Переходим по ссылке: {url}")
    public static <T> T open(String url, Class<T> typePage) {
        return typePage.cast(Selenide.open(url, typePage));
    }

}
