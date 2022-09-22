package config.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/props/config.properties"
})

public interface Props extends Config {

    @Key("graham.user.uppercase")
    @DefaultValue("No value")
    String grahamUserUppercase();

    @Key("graham.user.lowercase")
    @DefaultValue("No value")
    String grahamUserLowercase();

    @Key("graham.user")
    @DefaultValue("No value")
    String grahamUser();

    @Key("graham.user.no.exist")
    @DefaultValue("No value")
    String grahamUserNoExist();

    @Key("graham.user.dom")
    @DefaultValue("No value")
    String grahamUserDom();

    @Key("graham.password")
    @DefaultValue("No value")
    String grahamPassword();
}
