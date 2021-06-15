package StackIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer> {
    private List<Integer> list;

    public Stack() {
        this.list = new ArrayList<>();
    }
    public void Push(String s){
        String[] tokens=s.split(", ");
        for (String p:tokens
             ) {
            list.add(Integer.parseInt(p));
        }

    }

    public List<Integer> getList() {
        return list;
    }

    public void Pop(){
        if (list.size()>0){
            list.remove(list.size()-1);
        }else {
            System.out.println("No elements");
        }

    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index=list.size()-1;
            public boolean hasNext() {
                return index>=0;
            }

            @Override
            public Integer next() {
                int n=list.get(index);
                index--;
                return n;
            }
        };
    }
}
