package Military_Elite.Interfaces;

import Military_Elite.Resources.Repair;

import java.util.Collection;
import java.util.Set;

public interface IEngineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
    String toString();
}
