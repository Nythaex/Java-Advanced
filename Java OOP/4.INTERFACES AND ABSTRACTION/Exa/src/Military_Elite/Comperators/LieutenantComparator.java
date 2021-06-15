package Military_Elite.Comperators;

import Military_Elite.Soldiers.LieutenantGeneralImpl;
import Military_Elite.Soldiers.PrivateImpl;
import Military_Elite.Soldiers.SoldierImpl;

import java.util.Comparator;

public class LieutenantComparator implements Comparator<SoldierImpl> {


    @Override
    public int compare(SoldierImpl o1, SoldierImpl o2) {
        return Integer.compare(o2.getID(), o1.getID());
    }
}
