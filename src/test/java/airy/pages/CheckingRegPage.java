package airy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckingRegPage {

    private SelenideElement
            checkTable = $(".table-responsive");

    public CheckingRegPage checkResultsValue(String key, String value) {
        checkTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public CheckingRegPage checkHaveText(String key, String value) {
        $(key).shouldHave(text(value));
        return this;
    }

}
