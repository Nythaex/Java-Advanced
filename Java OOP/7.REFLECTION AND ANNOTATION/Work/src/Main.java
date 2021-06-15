import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.InterfaceAddress;
import java.util.*;

public class Main {
    public static class comperator implements Comparator<Method>{

        @Override
        public int compare(Method o1, Method o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }
    public static void main(String[] args) {
        Class myClass = MyMethods.class;
        Method [] methods= myClass.getMethods();
        for (int i = 0; i <= methods.length - 1; i++) {
            Annotation annotation=methods[i].getDeclaredAnnotation(Author.class);
            if (annotation!=null) {
                System.out.println(annotation.toString());
            }

        }

        Class clazz=Reflection.class;

        try {
            Method[] declaredMethods = clazz.getDeclaredMethods();
            Set<Method> getters=new TreeSet<>(new comperator());
            Set<Method> setters=new TreeSet<>(new comperator());
            Field [] classFields=clazz.getDeclaredFields();
            Set<Field> fields=new HashSet<>();
            for (Field m:classFields
            ) {
              fields.add(m);
            }

            for (Method m:declaredMethods
                 ) {
                if (m.getName().contains("get")){
                    getters.add(m);
                }else if (m.getName().contains("set")){
                    setters.add(m);
                }
            }


            fields.stream().sorted(Comparator.comparing(Field::getName)).filter(s->!Modifier.isPrivate(s.getModifiers()))
                    .forEach(s-> System.out.println(s.getName()+" must be private!"));

            for (Method m:getters
            ) {
                if (!Modifier.isPublic(m.getModifiers())){
                    System.out.println(m.getName()+" have to be public!");
                };
            }
            for (Method m:setters
            ) {
                if (!Modifier.isPrivate(m.getModifiers())){
                    System.out.println(m.getName()+" have to be private!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
