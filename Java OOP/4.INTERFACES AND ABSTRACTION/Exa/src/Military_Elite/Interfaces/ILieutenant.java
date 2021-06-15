package Military_Elite.Interfaces;


import Military_Elite.Soldiers.LieutenantGeneralImpl;
import Military_Elite.Soldiers.PrivateImpl;

import java.util.Set;

public interface ILieutenant {
    void addPrivate(PrivateImpl soldier);
    Set<PrivateImpl> getSet();
    String toString();
}
