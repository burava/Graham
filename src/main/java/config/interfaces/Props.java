package config.interfaces;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Reloadable;

public interface Props extends Reloadable {
    @Config.Key("graham.user")
    @Config.DefaultValue("No value")
    String grahamUser();

    @Config.Key("graham.password")
    @Config.DefaultValue("No value")
    String grahamPassword();
}
