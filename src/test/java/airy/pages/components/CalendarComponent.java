package airy.pages.components;

import airy.TestData;
import com.github.javafaker.Faker;

import static airy.utils.RandomUtils.maxDayInMonth;
import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent extends TestData {

    public static String dayBirth() {
        Faker faker = new Faker();
        int dayB = faker.number().numberBetween(1, maxDayInMonth(monthBirth));
        if (dayB<10) {
            return dayBirth="0"+String.valueOf(dayB);
        } else {
            return dayBirth = String.valueOf(dayB);
        }
    }
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
/*        String selector = ".react-datepicker__day--0%s:not(react-datepicker__day--outside-month)";
        $(String.format(selector,day)).click();
        String selector1 = ".react-datepicker__%s-select";
        $(String.format(selector1,"month")).selectOption(month);
        $(String.format(selector1,"year")).selectOption(year);
*/        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+ day
                +":not(react-datepicker__day--outside-month)").click();

    }
}

