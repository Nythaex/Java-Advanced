import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String, Map<String, Dragon>> collection = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);
            Dragon dragon = new Dragon(name, damage, health, armor);
            collection.putIfAbsent(type, new TreeMap<>());
            collection.get(type).put(name, dragon);
        }
        for (Map.Entry<String, Map<String, Dragon>> entry : collection.entrySet()) {
            double health = 0;
            double damage = 0;
            double armor = 0;
            for (Map.Entry<String, Dragon> stringDragonEntry : entry.getValue().entrySet()) {
                health += stringDragonEntry.getValue().getHealth();
                damage += stringDragonEntry.getValue().getDamage();
                armor += stringDragonEntry.getValue().getArmor();
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), damage / entry.getValue().size(),
                    health / entry.getValue().size(), armor / entry.getValue().size());
            entry.getValue().entrySet().stream().forEach(dragon ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), dragon.getValue().
                            getDamage(), dragon.getValue().getHealth(), dragon.getValue().getArmor()
                    ));
        }


    }

    static class Dragon {
        String name;
        int damage;
        int health;
        int armor;

        public Dragon(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }
}
