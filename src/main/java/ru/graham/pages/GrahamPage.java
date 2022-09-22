package ru.graham.pages;

import ru.graham.interfaces.Tables;
import ru.BasePage;

/**
 * Класс PageObject для главной страницы
 */
public abstract class GrahamPage<CurrentPage> extends BasePage<CurrentPage, GrahamPage> implements Tables<CurrentPage> {
    public GrahamPage() {
        System.out.println("Конструктор грэм");
        this.inputFieldXpath = "//div/input[@placeholder= '%s' ]";
        this.selectFieldXpath = "//*[contains(text(), '%s')]";
        // this.textXpath = null;
        this.buttonXpath = "//span[@aria-label = '%s'] | " + "//button[contains(text(),'%s')]";
//        this.linkXpath = null;
//        this.checkboxFieldXpath = null;
    }
}
