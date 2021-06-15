package barracksWars.core;

import barracksWars.core.commands.AddCommand;
import barracksWars.core.commands.FightCommand;
import barracksWars.core.commands.ReportCommand;
import barracksWars.core.commands.RetireCommand;
import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		String result=null;

		try {
			Class clazz =Class.forName("barracksWars.core.commands."+commandName.toUpperCase(Locale.ROOT).charAt(0)+commandName.substring(1)+"Command");
			Constructor<Executable> declaredConstructor = clazz.getDeclaredConstructor(String[].class,Repository.class,UnitFactory.class);
			declaredConstructor.setAccessible(true);
			Executable command = declaredConstructor.newInstance(data,repository,unitFactory);
			Method method =command.getClass().getDeclaredMethod("execute");
			method.setAccessible(true);
			result=method.invoke(command).toString();



		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
