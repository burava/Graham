package helpers;

import config.interfaces.Props;
import org.aeonbits.owner.ConfigFactory;

public enum ConfigService {
    INSTANCE;

    private Props props;

    ConfigService() {props = ConfigFactory.create(Props.class);}

    public Props props() {
        return props;
    }
}
