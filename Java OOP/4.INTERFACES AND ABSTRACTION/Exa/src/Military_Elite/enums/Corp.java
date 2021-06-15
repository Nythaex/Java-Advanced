package Military_Elite.enums;

import java.util.HashMap;
import java.util.Map;

public enum Corp {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private static Map<String,Corp> corps=new HashMap<>();
    private String normalCase;
    private static boolean registered=false;
    Corp(String normalCase) {
        this.normalCase = normalCase;
    }

    public String getNormalCase() {
        return normalCase;
    }
    public static Corp getCorp(String normalCase) {
        if (!registered){
            register();
            registered=true;
        }
        return corps.get(normalCase);
    }

    private static void register() {
        corps.put(AIRFORCES.getNormalCase(), AIRFORCES);
        corps.put(MARINES.getNormalCase(), MARINES);
    }
}
