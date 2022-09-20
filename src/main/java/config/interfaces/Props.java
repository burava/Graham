package config.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/props/config.properties"
})

public interface Props extends Config {

    @Key("graham.user")
    @DefaultValue("No value")
    String grahamUser();

    @Key("graham.password")
    @DefaultValue("No value")
    String grahamPassword();
}
