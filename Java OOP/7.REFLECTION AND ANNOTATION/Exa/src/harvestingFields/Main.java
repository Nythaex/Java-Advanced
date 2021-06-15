package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		Class clazz= harvestingFields.RichSoilLand.class;
		Field[] fields= clazz.getDeclaredFields();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String command=reader.readLine();
		while(!command.equals("HARVEST")){
			final String mod=command;
			if (!command.equals("all")) {

				Arrays.stream(fields).filter(s -> Modifier.toString(s.getModifiers()).equals(mod)).forEach(s -> System.out.println(Modifier.toString(s.getModifiers()) + " " + s.getType().getSimpleName() + " " + s.getName()));
			}else{
				for (Field field:fields
				) {
					System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType().getSimpleName()+" "+field.getName());
				}
			}

			command=reader.readLine();
		}

	}
}
