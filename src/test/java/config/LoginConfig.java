package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/${env}.properties"})
public interface LoginConfig extends Config {

    @DefaultValue("Вася.Пупкин.01")
    String userName();

}
