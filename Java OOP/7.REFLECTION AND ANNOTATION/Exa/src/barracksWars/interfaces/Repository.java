package barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	boolean removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
