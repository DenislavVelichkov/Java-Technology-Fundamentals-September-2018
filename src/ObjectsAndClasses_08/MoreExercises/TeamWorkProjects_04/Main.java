package ObjectsAndClasses_08.MoreExercises.TeamWorkProjects_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final boolean[] isPresent = {false};
        int n = Integer.parseInt(reader.readLine());
        Map<String, List<Player>> team = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] text = line.split("-");
            String teamLeader = text[0];
            String teamName = text[1];

            Player player = new Player(teamLeader);
            if (team.containsKey(teamName)) {
                System.out.printf("Team %s was already created!%n", teamName);
                continue;
            }

            team.putIfAbsent(teamName, new ArrayList<>());

            for (Map.Entry<String, List<Player>> entry : team.entrySet()) {
                entry.getValue()
                        .stream()
                        .anyMatch(pl -> {
                            if (pl.getName().equals(teamLeader)) {
                                return isPresent[0] = true;
                            } else {
                                return isPresent[0] = false;
                            }
                        });
            }

            if (isPresent[0]) {
                System.out.printf("%s cannot create another team!%n",
                        player.getName());
            } else {
                team.get(teamName).add(player);
                player.setType("leader");
                System.out.printf("Team %s has been created by %s!%n",
                        teamName, teamLeader);
            }
        }

        isPresent[0] = false;
        while (true) {
            String line = reader.readLine();
            if (line.equals("end of assignment")) break;

            String[] text = line.split("->");
            String user = text[0];
            String teamToJoin = text[1];
            Player player = new Player(user);

            if (!team.containsKey(teamToJoin)) {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
                continue;
            }

            team.values().forEach(players -> {
                for (Player pl : players) {
                    if (pl.getName().equals(user)) {
                        isPresent[0] = true;
                        System.out.printf("Member %s cannot join team %s!%n",
                                user, teamToJoin);
                    }
                }
            });

            if (!isPresent[0]) {
                team.get(teamToJoin).add(player);
                player.setType("minion");
            }
        }

        team.entrySet().stream()
                .sorted((o1, o2) -> {
                    int result =
                            Integer.compare(o2.getValue().size(), o1.getValue().size());
                    if (result != 0) return result;
                    else return 1;
                })
                .sorted(Map.Entry.comparingByKey())
                .forEach(Main::accept);

        System.out.println("Teams to disband:");
        team.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().compareToIgnoreCase(o2.getKey()))
                .forEach(entry -> {
                    if (entry.getValue().size() < 2) {
                        System.out.printf("%s%n", entry.getKey());
                    }
                });
    }

    private static void accept(Map.Entry<String, List<Player>> input) {
        if (!(input.getValue().size() < 2)) {
            System.out.printf("%s%n", input.getKey());

            Optional<Player> toBe =
                    input.getValue()
                            .stream()
                            .filter(player -> player.getType().equals("leader"))
                            .findFirst();

            System.out.printf("- %s%n", toBe.get().getName());

            List<Player> toBe2nd =
                    input.getValue()
                            .stream()
                            .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                            .filter(player -> player.getType().equals("minion"))
                            .collect(Collectors.toList());

            toBe2nd.forEach(player -> {
                System.out.printf("-- %s%n", player.getName());
            });

        }
    }
}
