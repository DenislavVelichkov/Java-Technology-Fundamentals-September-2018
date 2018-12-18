package AssociativeArrays_07.Excersise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ForceBook_09 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        String forceUser = "";
        String forceSide = "";
        Map<String, ArrayList<String>> journey = new LinkedHashMap<>();

        while (!line.equals("Lumpawaroo")) {
            String[] tokens;
            boolean wasThisCurrentCmd = false;

            if (line.contains("|")) {
                tokens = line.split(" \\| ");
                forceUser = tokens[1];
                forceSide = tokens[0];
            } else if (line.contains("->")) {
                tokens = line.split(" -> ");
                forceUser = tokens[0];
                forceSide = tokens[1];
                wasThisCurrentCmd = true;
            }

            boolean doesHeAExist = false;
            journey.putIfAbsent(forceSide, new ArrayList<>());

            if (wasThisCurrentCmd) {
                for (Map.Entry<String, ArrayList<String>> entry : journey.entrySet()) {
                    if (entry.getValue().remove(forceUser)) {
                        break;
                    }
                }

                journey.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }

            for (Map.Entry<String, ArrayList<String>> entr : journey.entrySet()) {
                if (entr.getValue().contains(forceUser)) {
                    doesHeAExist = true;
                    break;
                }
            }

            if (doesHeAExist) {
                line = reader.readLine();
                continue;
            } else {
                journey.get(forceSide).add(forceUser);
            }

            line = reader.readLine();
        }

        journey.entrySet().stream()
                .sorted((o1, o2) -> {
                    int result = Integer.compare(o2.getValue().size(), o1.getValue().size());
                    return result != 0 ? result : o1.getKey().compareTo(o2.getKey());
                })
                .forEach(e -> {
                    if (e.getValue().size() > 0) {
                        System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                        e.getValue()
                                .stream()
                                .sorted(String::compareTo)
                                .forEach(val -> System.out.printf("! %s%n", val));
                    }
                });
    }
}
