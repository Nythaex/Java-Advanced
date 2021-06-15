package Clone;

import Clone.Container.Container;
import Clone.Core.Engine;

import java.io.*;

public class Main {
    static{
        Container.init();
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
