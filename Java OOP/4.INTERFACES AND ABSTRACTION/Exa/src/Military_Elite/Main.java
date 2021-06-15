package Military_Elite;

import Military_Elite.Container.SingletonContainer;
import Military_Elite.core.Engine;

import java.io.IOException;

public class Main {
    static{
        SingletonContainer.init();
    }
    public static void main(String[] args) {
        Engine engine=Engine.getInstance();
        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
