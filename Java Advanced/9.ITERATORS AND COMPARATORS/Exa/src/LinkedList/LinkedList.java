package LinkedList;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private T[] linkedList;

    public LinkedList() {
        this.linkedList =(T[]) new Object[0];
    }

    public void Add(T element) {
        T[] second = (T[]) new Object[linkedList.length+1];
        for (int i = 0; i < second.length - 1; i++) {
         second[i]=linkedList[i];
        }
        this.linkedList=second;
        this.linkedList[linkedList.length-1]=element;
    }
    public void Remove(T element) {
        boolean found = false;
        for (T t:linkedList
             ) {
            if (t==element){
                found=true;
            }
        }
        if (!found){
            return;
        }
        T[] second = (T[]) new Object[0];
        if (linkedList.length!=0){
            second = (T[]) new Object[linkedList.length-1];
        }
       found = false;
        int secondIndex = 0;
        for (int i = 0; i <= linkedList.length - 1; i++) {
            if (linkedList[i]==element&&!found){
                found=true;
                continue;
            }
            second[secondIndex]=linkedList[i];
            secondIndex++;
        }
        this.linkedList=second;
    }
    public int count() {
        return linkedList.length;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index1;
            @Override
            public boolean hasNext() {
                return index1 <linkedList.length;
            }

            @Override
            public T next() {
                T p=linkedList[index1];
                index1++;
                return p;
            }
        };
    }


}
