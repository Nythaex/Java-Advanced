package Military_Elite.Data;

import Military_Elite.Soldiers.PrivateImpl;

import java.util.HashMap;
import java.util.Map;

public class SoldiersData {
    private static SoldiersData instance;
    private static boolean initialize = false;
    private Map<String, PrivateImpl> privateSoldiers;


    private SoldiersData() {
        privateSoldiers = new HashMap<>();
    }

    public Map<String, PrivateImpl> getPrivateSoldiers() {
        return privateSoldiers;
    }

    public static SoldiersData getInstance() {
        if (!initialize) {
            instance = new SoldiersData();
            initialize = true;
        }
        return instance;
    }
}
