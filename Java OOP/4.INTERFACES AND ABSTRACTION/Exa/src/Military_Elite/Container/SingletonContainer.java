package Military_Elite.Container;

import Military_Elite.Data.SoldiersData;
import Military_Elite.core.Engine;

public class SingletonContainer {
    private static Engine engine;
    private static SoldiersData soldiersData;

    public static void init() {
            engine = Engine.getInstance();
            soldiersData= SoldiersData.getInstance();
    }
}
