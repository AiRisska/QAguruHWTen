package airy.testRegistration.properties;

import airy.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {
    public CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();
        System.out.println("Login "+login);
        System.out.println("Password "+password);
        String message = format("I login as %s with password %s", login, password);
        System.out.println(message);
    }
}
