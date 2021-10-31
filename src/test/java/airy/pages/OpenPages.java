package airy.pages;

import static com.codeborne.selenide.Selenide.open;

public class OpenPages {
    CheckingRegPage check = new CheckingRegPage();
    //для юзабельности стоит использовать scrollTo()
    public void openRegistration(String title) {
        open("https://demoqa.com/automation-practice-form");
        check.checkHaveText(".practice-form-wrapper", title);
    }
}

