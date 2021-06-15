package Generic_CountMethod;

import java.util.List;

public class Box {
    public static<T extends Comparable> int count(List<T> list,T item){
       int count=0;
        for (T p:list
             ) {
            if (p.compareTo(item)>0){
                count++;
            }
        }
        return count;
    }
}
