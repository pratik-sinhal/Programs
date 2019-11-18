package generics.exercise11n12;

import java.util.List;
import java.util.Map;

/**
 * Created by pratik_s on 21/9/16.
 */
public class TestNew {
    public static void main(String[] args) {
        // Leveraging type argument inference. Works only with assignment.
        Map<String, List<String>> sls = New.map();
        // Using explicit type specification
        Map<String, List<String>> sls2 = New.<String, List<String>>map();
    }
}
