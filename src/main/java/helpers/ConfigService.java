package helpers;

import config.interfaces.Props;
import org.aeonbits.owner.ConfigFactory;

public enum ConfigService {
    INSTANCE;

    private Props props;

    public Props props(){
        return props;
    }

}
