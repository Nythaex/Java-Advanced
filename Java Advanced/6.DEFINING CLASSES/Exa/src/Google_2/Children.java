package Google_2;

import java.util.ArrayList;
import java.util.List;

public class Children {
    private List<String> children;

    public Children() {
        this.children = new ArrayList<>();
    }

    public List<String> getChildren() {
        return this.children;
    }
    public void addPok(String s){
        children.add(s);
    }


}
