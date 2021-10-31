package airy.pages;

import airy.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public CalendarComponent calendar = new CalendarComponent();

//для юзабельности стоит использовать scrollTo()

    public RegistrationPage setText(String key, String value) {
        $(key).setValue(value);
        return this;
    }

    public RegistrationPage setTextWithEnter(String key, String value) {
        $(key).setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickOnByText(String key, String value) {
        $(key).$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFileIMG(String key, String nameImg) {
        $(key).uploadFromClasspath("img/"+ nameImg);
        return this;
    }

    public RegistrationPage clickOnTextInWrapper(String id, String wrapper, String value) {
        ClickOnKey click = new ClickOnKey();
        click.clickField(id);
        $(wrapper).$(byText(value)).click();
        return this;
    }


}
