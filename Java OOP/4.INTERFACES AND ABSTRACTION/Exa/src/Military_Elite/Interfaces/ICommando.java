package Military_Elite.Interfaces;

import Military_Elite.Resources.Mission;
import Military_Elite.Resources.Repair;

import java.util.Collection;

public interface ICommando {
    void addReMission(Mission mission);
    Collection<Mission> getMissions();
    String toString();
}
