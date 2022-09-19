package helpers;

import config.interfaces.Props;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestRunData {

    public static Stream<Arguments> gp0001() {
        return Stream.of(Arguments.of("ABurima","add2X8s4f8")
        );
    }
}
