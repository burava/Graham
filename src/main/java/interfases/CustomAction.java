package interfases;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public interface CustomAction<CurrentPage> {

    @Step("Очистить значение поля")
    default CurrentPage clearField(SelenideElement fieldName) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].value = '';", fieldName);
        return (CurrentPage) this;
    }
}
