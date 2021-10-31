package airy;

import airy.pages.components.CalendarComponent;
import com.github.javafaker.Faker;

import static airy.utils.RandomUtils.*;

public class TestData {
// public static добавлены, чтобы можно было импортировать в другой файл (класс)
    private static Faker faker = new Faker();
// с локализацией Faker fake = new Faker(new Locale("ru"));
    public static String name = faker.name().firstName();
    public static String family = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String gender = randomGender();
    public static String mobile= faker.number().digits(10).toString();
    public static String subject = "Arts";
    public static String hobbyOne = "Reading";
    public static String hobbyTwo = "Music";
    public static String address = faker.address().fullAddress();
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String yearBirth = yearBirthString();
    public static String monthBirth = randomMonth();
    public static String dayBirth = CalendarComponent.dayBirth();
    public static String nameFile = "1.png";
//далее в другом классе import static V.less.testRegistration.TestData.*;   чтобы использовать параметры отсюда

}
