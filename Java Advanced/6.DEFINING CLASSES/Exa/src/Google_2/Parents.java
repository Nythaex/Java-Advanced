package Google_2;

import java.util.ArrayList;
import java.util.List;

public class Parents {
    private List<String> parents;

    public Parents() {
        parents = new ArrayList<>();
    }

    public List<String> getParents() {
        return this.parents;
    }
    public void addPok(String s){
       parents.add(s);
    }
}
