package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static helpers.CustomDate.getDateNow;

public class CustomUtilities {

    @Step("Переходим по ссылке: {url}")
    public static <T> T open(String url, Class<T> typePage) {
        return typePage.cast(Selenide.open(url, typePage));
    }

}
