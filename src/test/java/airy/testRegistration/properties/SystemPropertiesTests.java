package airy.testRegistration.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void someTest() {
        //просто забираем значение value
        String value = System.getProperty("value");
        System.out.println(value);
        //выведет null, так как в value нет значения в хранилище System
    }

    @Test
    void someTest1() {
        //забираем значение по ключу value, НО если значения нет (null), то получаем default_value
        String value = System.getProperty("value", "default_value");
        System.out.println(value);
        //выведет default_value, так как в value нет значения в хранилище System
    }

    @Test
    void someTest2() {
        //положим в System по ключу value значение another_value
        System.setProperty("value", "another_value");
        //забираем значение по ключу value
        String value = System.getProperty("value");
        System.out.println(value);
        //выведет another_value
    }

    @Test
    void someTest3() {
        //положим в System по ключу value значение another_value
        System.setProperty("value", "another_value");
        //забираем значение по ключу value, НО если значения нет (null), то получаем default_value
        String value = System.getProperty("value", "default_value");
        System.out.println(value);
        //выведет another_value
    }

    @Test
    @Tag("properties")
    void someTest4() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
        //в терминал (командной строке) gradle clean properties_tests
        //выведет chrome
        //после внесения дополнений в build.gradle если ввести в терминале
        //gradle clean properties_tests -Dbrowser=opera
        //получим вывод: opera
    }
}
