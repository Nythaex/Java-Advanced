package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.Archer;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		try {
			Class unitClass=Class.forName(UNITS_PACKAGE_NAME+unitType);
			Constructor<Unit> constructor=unitClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			Unit instance=constructor.newInstance();
			return instance;

		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
				| InstantiationException | InvocationTargetException e) {
			throw new ExecutionControl.NotImplementedException("message");
		}


	}
}
