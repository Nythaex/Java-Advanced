package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class clazz=BlackBoxInt.class;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Constructor<BlackBoxInt> constructor=clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            BlackBoxInt blackBoxInteger= constructor.newInstance();
            Method [] methods=blackBoxInteger.getClass().getDeclaredMethods();
            String command=reader.readLine();
            Field field=blackBoxInteger.getClass().getDeclaredField("innerValue");
            field.setAccessible(true);
            while(!command.equals("END")){
                String[] token=command.split("_");
                String methodName=token[0];
                int num=Integer.parseInt(token[1]);
                Method method= Arrays.stream(methods).filter(m->m.getName().equals(methodName)).findFirst().get();
                method.setAccessible(true);
                method.invoke(blackBoxInteger,num);
                System.out.println(field.get(blackBoxInteger));

                command=reader.readLine();
            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | IOException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
