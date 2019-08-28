package _07_AssociativeArrays.MoreExercises;

import java.util.*;

public class Snowwhite_04_WithClass_Ver3 {

    static class Dwarf {
        private String name;
        private String color;
        private int physics;

        public Dwarf(String name, String color, int physics) {
            this.name = name;
            this.color = color;
            this.physics = physics;
        }

        public void setPhysics(int physics) {
            this.physics = Math.max(physics, this.getPhysics());
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public int getPhysics() {
            return physics;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Dwarf> dwarfs = new ArrayList<>();
        Map<String, Integer> countsByColor = new HashMap<>();

        String line = sc.nextLine();

        while (!line.equals("Once upon a time")) {
            String[] tokens = line.split(" <:> ");
            String name = tokens[0];
            String color = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            Optional<Dwarf> dwarfCandidate = dwarfs.stream()
                    .filter(dwarf -> dwarf.getName().equals(name) &&
                            dwarf.getColor().equals(color))
                    .findFirst();

            if (dwarfCandidate.isPresent()) {
                Dwarf dwarf = dwarfCandidate.get();
                dwarf.setPhysics(physics);
            } else {
                Dwarf dwarf = new Dwarf(name, color, physics);
                countsByColor.putIfAbsent(color, 0);
                countsByColor.put(color, countsByColor.get(color) + 1);
                dwarfs.add(dwarf);
            }

            line = sc.nextLine();
        }

        dwarfs.sort((dwarf1, dwarf2) -> {
            int physics2 = dwarf2.getPhysics();
            int physics1 = dwarf1.getPhysics();
            if (physics1 == physics2) {
                return countsByColor.get(dwarf2.getColor())
                        .compareTo(
                       countsByColor.get(dwarf1.getColor())
                );
            }
            return Integer.compare(physics2, physics1);
        });

        dwarfs.forEach(dwarf -> System.out.printf("(%s) %s <-> %d%n",
                dwarf.getColor(), dwarf.getName(), dwarf.getPhysics()));
    }
}