package airy.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/hw.properties"})
public interface HwConfig extends Config {
    String url();
    String login();
    String password();

}
