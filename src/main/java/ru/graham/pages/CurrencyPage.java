package ru.graham.pages;

public class CurrencyPage extends GrahamPage<CurrencyPage>{

    protected static final long TIMEOUT = 600000L;

    protected String textXpath = "//*[contains(text(), '%s')]";
    protected String linkXpath = null;
    protected String buttonXpath = "//button[contains(text(),'%s')]";
    protected String radioButtonXpath = null;
    protected String tabXpath = null;
    protected String inputFieldXpath = null;
    protected String selectFieldXpath = null;
    protected String infoFieldXpath = null;
    protected String checkboxFieldXpath = null;
}
