package Collection_Hierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{


    public AddRemoveCollection() {
        super();
    }
    @Override
    public String remove() {
        return items.remove(items.size()-1);
    }

    @Override
    public int add(String element) {
        if (items.size()<maxSize){
            super.items.add(0,element);
        }
        return 0;
    }

}
