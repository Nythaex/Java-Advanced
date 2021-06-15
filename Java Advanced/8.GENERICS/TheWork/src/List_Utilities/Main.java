package List_Utilities;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        Collections.addAll(list,3,3,4,1,2,5);
        System.out.println(ListUtils.getMax(list));
        List<String>lista=new ArrayList<>();
        Collections.addAll(lista,"as23f","asset","ae1f","gq");
        System.out.println(ListUtils.getMin(lista));
    }
}
