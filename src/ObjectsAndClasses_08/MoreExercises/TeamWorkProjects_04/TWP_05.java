package ObjectsAndClasses_08.MoreExercises.TeamWorkProjects_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TWP_05 {
    static class Player {
        private String name;
        private String type;
        private String team;

        public Player(String name, String team) {
            this.name = name;
            this.team = team;
        }

        public String getTeam() {
            return team;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

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
                .filter(entry -> entry.getValue().size() > 1)
                .sorted((o1, o2) -> {
                    int result =
                            Integer.compare(o2.getValue().size(), o1.getValue().size());
                    return result != 0 ? result : o1.getKey().compareTo(o2.getKey());
                })
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());

                    Player addLeader = findTheLeader(entry);
                    System.out.printf("- %s%n", addLeader.getName());

                    entry
                            .getValue()
                            .stream()
                            .filter(player -> !player.getType().equals("leader"))
                            .sorted(Comparator.comparing(Player::getName))
                            .forEach(value -> System.out.printf("-- %s%n", value.getName()));
                });

        System.out.println("Teams to disband:");
        team.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() <= 1)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(k -> System.out.printf("%s%n", k.getKey()));
    }

    private static Player findTheLeader(Map.Entry<String, List<Player>> entry) {
        Optional<Player> theLeader =
                entry
                        .getValue()
                        .stream()
                        .filter(ent -> ent.getType().equals("leader"))
                        .findFirst();

        return theLeader.orElse(null);
    }
}
