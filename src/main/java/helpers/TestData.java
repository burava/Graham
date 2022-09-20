package helpers;

import java.util.HashMap;

public class TestData<K,V> extends HashMap<K,V> {
    public <T extends V> T get(Object o, Class<T> valueType){
        return valueType.cast(super.get(o));
    }
}
