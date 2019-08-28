package _07_AssociativeArrays.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy_05 {

    static class Dragon {
        private String type;
        private String name;
        private Double damage = 45d;
        private Double health = 250d;
        private Double armor = 10d;

        Dragon(String type, String name) {
            this.type = type;
            this.name = name;
        }

        String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Double getDamage() {
            return damage;
        }

        void setDamage(Double damage) {
            this.damage = damage;
        }

        Double getHealth() {
            return health;
        }

        void setHealth(Double health) {
            this.health = health;
        }

        Double getArmor() {
            return armor;
        }

        void setArmor(Double armor) {
            this.armor = armor;
        }
    }

    public static void main(String[] args) throws IOException {
        final boolean[] isPresent = {false};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String line = reader.readLine();

        Map<String, List<Dragon>> dragons = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = line.split(" ");
            String type = tokens[0];
            String name = tokens[1];

            Dragon dragon = new Dragon(type, name);

            if (!tokens[2].equals("null")) {
                Double damage = Double.parseDouble(tokens[2]);
                dragon.setDamage(damage);
            }
            if (!tokens[3].equals("null")) {
                Double health = Double.parseDouble(tokens[3]);
                dragon.setHealth(health);
            }
            if (!tokens[4].equals("null")) {
                Double armor = Double.parseDouble(tokens[4]);
                dragon.setArmor(armor);
            }

            for (List<Dragon> dragonsList : dragons.values()) {
                dragonsList.forEach(d -> {
                    if (dragon.getName().equals(d.getName()) &&
                            Objects.equals(dragon.getType(), d.getType())) {
                        isPresent[0] = true;
                        d.setDamage(dragon.getDamage());
                        d.setHealth(dragon.getHealth());
                        d.setArmor(dragon.getArmor());
                    }
                });
            }
            dragons.putIfAbsent(type, new ArrayList<>());

            if (!isPresent[0]) {
                dragons.get(type).add(dragon);
            }

            isPresent[0] = false;
            line = reader.readLine();
        }

        dragons.forEach((k, v) -> {
            Double countHealth = (double) v.stream().mapToDouble(Dragon::getHealth).count();
            Double countArmor = (double) v.stream().mapToDouble(Dragon::getArmor).count();
            Double countDmg = (double) v.stream().mapToDouble(Dragon::getDamage).count();
            Double sumDamage = v.stream().mapToDouble(Dragon::getDamage).sum();
            Double sumHealth = v.stream().mapToDouble(Dragon::getHealth).sum();
            Double sumArmor = v.stream().mapToDouble(Dragon::getArmor).sum();
            Double avgDmg = sumDamage / countDmg;
            Double avgHealth = sumHealth / countHealth;
            Double avgArmor = sumArmor / countArmor;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    k, avgDmg, avgHealth, avgArmor);

            v.stream().sorted((o1, o2) -> {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : 1;
            }).forEach(d -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                    d.getName(), d.getDamage(), d.getHealth(), d.getArmor()));
        });
    }
}
