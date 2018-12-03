package AssociativeArrays_07.MoreExercises.Snowwhite_04_WIthClass;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Dwarf> dwarves = new ArrayList<>();
        Map<String, Integer> countsByColor = new HashMap<>();

        String line = sc.nextLine();

        while (!line.equals("Once upon a time")) {
            String[] tokens = line.split(" <:> ");
            String name = tokens[0];
            String color = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            Optional<Dwarf> dwarfCandidate = dwarves.stream()
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
                dwarves.add(dwarf);
            }

            line = sc.nextLine();
        }

        dwarves.sort((dwarf1, dwarf2) -> {
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

        dwarves.forEach(dwarf -> System.out.printf("(%s) %s <-> %d%n",
                dwarf.getColor(), dwarf.getName(), dwarf.getPhysics()));
    }
}