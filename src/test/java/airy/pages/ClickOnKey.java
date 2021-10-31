package airy.pages;

import static com.codeborne.selenide.Selenide.$;

public class ClickOnKey {

    public ClickOnKey clickButton(String key) {
        $(key).click();
        return this;
    }

    public ClickOnKey clickField(String key) {
        $(key).click();
        return this;
    }
}
