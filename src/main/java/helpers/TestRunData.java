package helpers;

import config.interfaces.Props;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class TestRunData {

    public static Props props = ConfigFactory.create(Props.class);

    public static Stream<Arguments> gp0001() {
        return Stream.of(Arguments.of(props.grahamUser(), props.grahamPassword())
        );
    }
}
