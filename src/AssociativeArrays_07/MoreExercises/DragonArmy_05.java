package AssociativeArrays_07.MoreExercises;

import java.util.*;

public class DragonArmy_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();

        Map<String, List<Dragon>> dragons = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = line.split(" ");
            String type = tokens[0];
            String name = tokens[1];

            Dragon dragon = new Dragon(type, name);

            if (!tokens[2].equals("null")) {
                Double damage = Double.parseDouble(tokens[2]);
                dragon.setDamage(damage);
            } else if (!tokens[3].equals("null")) {
                Double health = Double.parseDouble(tokens[3]);
                dragon.setHealth(health);
            } else if (!tokens[4].equals("null")) {
                Double armor = Double.parseDouble(tokens[4]);
                dragon.setArmor(armor);
            }

            final boolean[] isPresent = {false};
            for (List<Dragon> dragonsList : dragons.values()) {
                dragonsList.forEach(d -> {
                    if (dragon.name.equals(d.name) &&
                            dragon.type.equals(dragon.type)) {
                        isPresent[0] = true;
                        d.setDamage(dragon.damage);
                        d.setHealth(dragon.health);
                        d.setArmor(dragon.armor);
                    }
                });
            }
            dragons.putIfAbsent(type, new ArrayList<>());

            if (!isPresent[0]) {
                dragons.get(type).add(dragon);
            }
        }

        dragons.forEach((k, v) -> {
            OptionalDouble avgHealt =
                    v.stream().mapToDouble(Dragon::getHealth).average();
            OptionalDouble avgArmor =
                    v.stream().mapToDouble(Dragon::getArmor).average();
            OptionalDouble avgDamage =
                    v.stream().mapToDouble(Dragon::getDamage).average();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    k, avgDamage, avgHealt, avgArmor);

            v.stream().sorted((o1, o2) -> {
                int result = o1.name.compareTo(o2.name);
                return result != 0 ? result : 1;
            }).forEach(d -> {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f",
                        d.name, d.damage, d.health, d.armor);
            });
        });
    }

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getDamage() {
            return damage;
        }

        public void setDamage(Double damage) {
            this.damage = damage;
        }

        public Double getHealth() {
            return health;
        }

        public void setHealth(Double health) {
            this.health = health;
        }

        public Double getArmor() {
            return armor;
        }

        public void setArmor(Double armor) {
            this.armor = armor;
        }
    }
}
