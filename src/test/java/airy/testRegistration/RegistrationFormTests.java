package airy.testRegistration;

import airy.TestBase;
import airy.pages.CheckingRegPage;
import airy.pages.ClickOnKey;
import airy.pages.OpenPages;
import airy.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static airy.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    OpenPages open = new OpenPages();
    RegistrationPage registrationPage = new RegistrationPage();
    CheckingRegPage check = new CheckingRegPage();
    ClickOnKey button = new ClickOnKey();

    @Test
    void practiceFormTest() {
        step ("Открыть страницу регистрационной формы", () -> {
            open.openRegistration("Student Registration Form");
        });

        step("Заполнить данные", () -> {
        registrationPage
                .setText("#firstName", name)
                .setText("#lastName", family)
                .setText("#userEmail", email)
                .setText("#userNumber", mobile)
                .setText("#currentAddress", address);
        registrationPage.calendar.setDate(dayBirth,monthBirth,yearBirth);
        registrationPage.setTextWithEnter("#subjectsInput", subject);
        registrationPage
                .clickOnByText("#genterWrapper", gender)
                .clickOnByText("#hobbiesWrapper", hobbyOne)
                .clickOnByText("#hobbiesWrapper", hobbyTwo);
//        registrationPage.uploadFileIMG("#uploadPicture", nameFile);
        registrationPage
                .clickOnTextInWrapper("#state", "#stateCity-wrapper", state)
                .clickOnTextInWrapper("#city","#stateCity-wrapper", city);
        });

        step("Нажать Submit", () -> {
        button.clickButton("#submit");
        });

        step("Проверка названия итоговой формы", () -> {
        check.checkHaveText(".modal-title", "Thanks for submitting the form");
        });

        step("Проверка заполнения", () -> {
        check.checkResultsValue("Student Name", name+" "+ family)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", mobile)
                .checkResultsValue("Date of Birth", dayBirth+" "+ monthBirth+","+ yearBirth)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobbyOne+", "+ hobbyTwo)
//                .checkResultsValue("Picture", nameFile)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state+" "+ city);
        });
        step("Закрыть модальное окно", () -> {
        button.clickButton("#closeLargeModal");
        });
    }
}
