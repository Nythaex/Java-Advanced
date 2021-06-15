package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator implements Iterable<String>  {
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            int index1;
            @Override
            public boolean hasNext() {
                return index1 <list.size();
            }

            @Override
            public String next() {
                String p=list.get(index1);
                index1++;
                return p;
            }
        };
    }
    private int index;
    private List<String> list;

    public ListyIterator(List<String>list) {
        this.list = list.stream().skip(1).collect(Collectors.toList());
    }
    public boolean Move(){
        index++;
        if (index<list.size()){
            return true;
        }else {
            index--;
        }
        return false;
    }
    public void Print(){
        try {
            System.out.println(list.get(index));
        }catch (Exception ex){
            System.out.println("Invalid Operation!");
        }
    }
    public boolean HasNext(){
       return index+1<list.size();
    }
}
