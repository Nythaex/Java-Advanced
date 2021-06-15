package Jar;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements;
    public Jar(){
        elements=new ArrayDeque<>();
    }
    public void add(T entity){
        elements.push(entity);
    }
    public T remove(){
        return elements.pop();
    }
}
