package Generic_Swap_Method;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void addElement(T element){
        this.list.add(element);
    }

    public void swap(int index,int valueIndex){
        T firstValue=this.list.get(index);
        this.list.set(index,this.list.get(valueIndex));
        this.list.set(valueIndex,firstValue);
    }

    @Override
    public String toString() {
        StringBuilder printer=new StringBuilder();
        for (T p:list
             ) {
            printer.append(p.getClass().getName()+": "+p);
            printer.append(System.lineSeparator());
        }
        return printer.toString();
    }
}
