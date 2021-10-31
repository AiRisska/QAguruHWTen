package airy;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaRegFormTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void PracticeFormTest() {
        
        open("/automation-practice-form");

        String name = "Irina";
        String family = "Sunny";
        String email = "irina@quru.qa";
        String gender = "Female";
        String mobile = "9123456789";
        String subject = "Arts";
        String hobbyOne = "Reading";
        String hobbyTwo = "Music";
        String address = "Nine street";
        String state = "NCR";
        String city = "Delhi";

        $("#firstName").setValue(name);
        $("#lastName").setValue(family);
        $("#userEmail").setValue(email);

        //$("#gender-radio-2").click();       //не кликабельно
        //$(byText("Female")).click();      // а поинтереснее? А вдруг переименуют? Этот локатор ищет первое такое слово на странице и по нему кликает!
        //$("#gender-radio-2").parent().click();      //parent - поднимемся наверх, используется когда нужный элемент перекрыт другим.
        //но давайте поиск от самого-самого родителя
        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue(mobile);

        // кликнем по полю с датой, чтобы открылся календарь
        $("#dateOfBirthInput").click();
        //брати внимание вместо # стоит точка, так как это класс
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1900");
        // react-datepicker__day react-datepicker__day--028  если на странице календаря есть еще один день с таким числом, то будет выделен первый попавшийся.
        // сократим удалив начало react-datepicker__day
        // 1 способ
        // укажем, что "не это число" через :not()   и в скобках "не содержит в классе react-datepicker__day--outside-month" (то есть то, что отличает число нашего месяца от иного на календаре
        $(".react-datepicker__day--014:not(react-datepicker__day--outside-month)").click();
        // 2 способ через массив элементов $$ (то есть работаем со всеми элементами и возвращает все) делаем фильтр и По первому найденному кликаем.
//        $$(".react-datepicker__day--014").
//                filter(not(cssClass("react-datepicker__day--outside-month"))).first().click();
        // 3 способ но это опасно полная фраза, поэтому...
//        $("[aria-label=\"Choose Tuesday, October 14th, 2021\"]").click();
        // ... используем XPath, где // начало, * означает, что любой элемент (можно указать конкретно div из ф12)
        // contains означает "содержит". //div указан, чтобы показать от какого элемента искать - в нашем случае с самого верха.
        // Знак @ чтобы указать, что aria-label это атрибут. Запятая - это не строгий поиск, а через "содержит" (contains)
//        $x("//div[contains(@aria-label, \"October 14th, 1900\")]").click();

        // Накрутила-то!
//        $("#subjectsInput").click();
//        $("#subjectsInput").sendKeys("English");
//        $("#subjectsInput").pressEnter();
//        $("#subjectsInput").sendKeys("Arts");
//        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue(subject).pressEnter();

        $("#hobbiesWrapper").$(byText(hobbyOne)).click();
        $("#hobbiesWrapper").$(byText(hobbyTwo)).click();

        //мой вариант, но тут загрузка с диска!
//        File picture = new File("C:/5275544.png");
//        $("#uploadPicture").uploadFile(picture);
        // сократи $("#uploadPicture").uploadFile(new File("C:/5275544.png"));
        //Добавим папку resourses-img и в ней создадим файл 1.png
        // Путь указываем без ресоурзес так как это базовая папка
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        //если иначе
        //$("#uploadPicture").uploadFile(new File("src/resources/img/1.png"));

        $("#currentAddress").setValue(address);

        //это не классический элемент, поэтому честно все прокликиваем. Но отловить куда нажать в списке сложно.
        $("#state").click();
        // Найдем родительский элемент stateCity-wrapper и в нем будем искать элемент byText
        $("#stateCity-wrapper").$(byText(state)).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        // Submit кнопка
        $("#submit").click();

        //проверим заголовок появившегося окна
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        //проверим введенные значения. Есть разные способы. Проверим по классу table-responsive - довольно грубый способ
/*
        $(".table-responsive")
               .shouldHave(text(name+" "+family), text(email), text(gender), text(mobile),
                        text("14 October,1900"), text(subject), text(hobbyOne+", "+hobbyTwo), text("1.png"), text(address), text(state+" "+city));
 */
        //сделаем иначе найдем строку с именем Student Name и поднимемся выше и уже в нем найдем имя студента студента
//        $(".table-responsive").$(byText("Student Name")).shouldHave(text(name).text(family));
        //тоже самое но через XPath
//        $x("//td[text()='Student Name']").parent().shouldHave(text(name+" "+family));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobile));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 October,1900"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbyOne+", "+hobbyTwo));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state+" "+city));

        //закроем модальное окно
        $("#closeLargeModal").click();
    }

    @Test
    void emptyFillFormTest() {
        //тест проверят что бордер становится красным если не заполнен
        open("/automation-practice-form");
//        $("#firstName").setValue("Irina");
        $("#submit").click();
        // цвет идет типа #dc3545 его надо указывать в rgb
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}