package Collection_Hierarchy;

public class MyListImpl extends Collection implements MyList{
    public MyListImpl() {
        super();
    }
    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int add(String element) {
        if (items.size()<maxSize){
            super.items.add(0,element);
        }
        return 0;
    }
    @Override
    public int getUsed() {
        return items.size();
    }
}
