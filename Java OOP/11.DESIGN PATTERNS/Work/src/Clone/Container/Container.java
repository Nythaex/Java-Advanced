package Clone.Container;

import Clone.Container.Singleton.Addresses;
import Clone.Core.Engine;

public class Container {
    public static Addresses addresses;
    private static boolean initialized=false;
    public static Engine engine;


    public static Addresses init(){
        if (!initialized){
            addresses= Addresses.getInstance();
            engine=Engine.getInstance();
            initialized=true;
        }
       return addresses;
    }
}
