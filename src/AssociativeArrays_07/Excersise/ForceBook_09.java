package AssociativeArrays_07.Excersise;

import java.util.*;

public class ForceBook_09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String forceUser = "";
        String forceSide = "";

        Map<String, ArrayList<String>> journey = new HashMap<>();

        while (!line.equals("Lumpawaroo")) {
            String[] tokens;
            boolean wasThisCurrentCmd = false;

            if (line.contains(" | ")) {
                tokens = line.split(" \\| ");
                forceUser = tokens[1];
                forceSide = tokens[0];
            } else if (line.contains("->")) {
                tokens = line.split(" -> ");
                forceUser = tokens[0];
                forceSide = tokens[1];
                wasThisCurrentCmd = true;
            }

            if (!journey.containsKey(forceSide)) {
                journey.put(forceSide, new ArrayList<>());
            }

            if (!journey.get(forceSide).contains(forceUser)) {
                journey.get(forceSide).add(forceUser);
            }

            if (wasThisCurrentCmd) {
                for (Map.Entry<String, ArrayList<String>> entry : journey.entrySet()) {
                    entry.getValue().remove(forceUser);
                    //check and remove entry from Map
                }

                if (!journey.get(forceSide).contains(forceUser)) {
                    journey.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }
            }

            line = sc.nextLine();
        }

        journey.entrySet().stream()
                .sorted(Map.Entry.<String, ArrayList<String>>comparingByValue(Comparator.comparingInt(ArrayList::size)).reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> {
                    Collections.sort(e.getValue());
                    if (e.getValue().size() > 0) {
                        System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                        e.getValue().forEach(val -> System.out.printf("! %s%n", val));
                    }
                });
    }
}
