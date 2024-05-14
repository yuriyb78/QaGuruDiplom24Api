package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "system:properties",
        "classpath:test_data/${data}.properties",
        "classpath:test_data/user-data.properties"})
public interface LoginConfig extends Config {

    String userName();

}
