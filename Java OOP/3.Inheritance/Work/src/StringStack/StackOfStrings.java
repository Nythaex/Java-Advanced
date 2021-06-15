package StringStack;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<String>();
    }
    public  void push(String str){
        this.data.add(str);
    }
    public String pop(){
        return  data.remove(data.size() - 1);
    }
    public String peek(){
        return  data.get(data.size() - 1);
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
}
