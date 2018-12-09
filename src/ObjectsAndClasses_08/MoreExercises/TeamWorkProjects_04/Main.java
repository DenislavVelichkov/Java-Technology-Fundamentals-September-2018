package ObjectsAndClasses_08.MoreExercises.TeamWorkProjects_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, List<Player>> team = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] text = line.split("-");
            String teamLeader = text[0];
            String teamName = text[1];

            if (team.containsKey(teamName)) {
                System.out.printf("Team %s was already created!%n", teamName);
                continue;
            }

            team.putIfAbsent(teamName, new ArrayList<>());
            boolean playerIsPresent = false;

            for (List<Player> value : team.values()) {
                Optional<Player> isPlayerPresent =
                        value.stream()
                                .filter(player -> player.getType().equals(teamLeader))
                                .findFirst();
                if (isPlayerPresent.isPresent()) {
                    System.out.printf("%s cannot create another team!%n",
                            isPlayerPresent.get().getName());
                    playerIsPresent = true;
                    break;
                }
            }

            if (!playerIsPresent) {
                Player player = new Player(teamLeader, teamName);
                team.get(teamName).add(player);
                player.setType("leader");
                System.out.printf("Team %s has been created by %s!%n",
                        teamName, teamLeader);
            }
        }

        while (true) {
            String line = reader.readLine();
            if (line.equals("end of assignment")) break;

            String[] text = line.split("->");
            String user = text[0];
            String teamToJoin = text[1];

            if (!team.containsKey(teamToJoin)) {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
                continue;
            }

            boolean playerIsPresent = false;
            for (List<Player> value : team.values()) {
                Optional<Player> isPlayerPresent =
                        value
                                .stream()
                                .filter(player -> player.getName().equals(user))
                                .findFirst();

                if (isPlayerPresent.isPresent()) {
                    System.out.printf("Member %s cannot join team %s!%n",
                            isPlayerPresent.get().getName(), teamToJoin);
                    playerIsPresent = true;
                    break;
                }
            }

            if (!playerIsPresent) {
                Player player = new Player(user, teamToJoin);
                team.get(teamToJoin).add(player);
                player.setType("minion");
            }
        }

        team.entrySet().stream()
                .sorted((o1, o2) -> {
                    int result =
                            Integer.compare(o2.getValue().size(), o1.getValue().size());
                    return result != 0 ? result : o1.getKey().compareTo(o2.getKey());
                })
                .forEach(entry -> {
                    if (entry.getValue().size() > 1) {
                        System.out.printf("%s%n", entry.getKey());

                        entry
                                .getValue()
                                .stream()
                                .sorted(Comparator.comparing(Player::getName)
                                        .thenComparing(Player::getType))
                                .forEach(value -> {
                                    String teamToCheck = entry.getKey();
                                    if (value.getType().equals("leader") &&
                                            value.getTeam().equals(teamToCheck)) {
                                        System.out.printf("- %s%n",
                                                value.getName());
                                    } else {
                                        System.out.printf("-- %s%n", value.getName());
                                    }
                                });
                    }
                });

        System.out.println("Teams to disband:");
        team.entrySet().stream()
                .sorted((o1, o2) -> {
                    int result = Integer.compare(o2.getValue().size(), o1.getValue().size());
                    if (result != 0) return result;
                    else return o1.getKey().compareTo(o2.getKey());
                })
                .forEach(entry -> {
                    if (entry.getValue().size() <= 1) {
                        System.out.printf("%s%n", entry.getKey());
                    }
                });
    }
}
