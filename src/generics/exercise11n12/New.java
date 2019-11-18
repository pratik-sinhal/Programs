package generics.exercise11n12;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pratik_s on 21/9/16.
 */
public class New {
    public static <K,V> Map<K,V> map() {
        return new HashMap<K, V>();
    }
}
