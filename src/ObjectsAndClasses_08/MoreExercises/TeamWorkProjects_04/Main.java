package ObjectsAndClasses_08.MoreExercises.TeamWorkProjects_04;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String text = sc.nextLine();
        Map<String, List<String>> teamAndLeader = new TreeMap<>();
        Map<String, List<String>> teamAndPlayers = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] line = text.split("-");
            String teamLeader = line[0];
            String teamName = line[1];

            teamAndLeader.putIfAbsent(teamName, new ArrayList<>());

            if (!teamAndLeader.get(teamName).contains(teamLeader)) {
                teamAndLeader.get(teamName).add(teamLeader);
                System.out.printf("Team %s has been created by %s!%n",
                        teamName, teamLeader);
            } else {
                System.out.printf("Team %s was already created!%n",
                        teamName);
            }

            text = sc.nextLine();
        }

        while (!text.equals("end of assignment")) {
            String[] line = text.split("->");
            String player = line[0];
            String teamToJoin = line[1];

            if (teamAndLeader.get(teamToJoin).contains(player)) {
                System.out.printf("%s cannot create another team!", player);
            }

            for (Map.Entry<String, List<String>> entry : teamAndPlayers.entrySet()) {
                if (entry.getValue().contains(player)) {
                    System.out.printf("Member %s cannot join team %s!%n",
                            player, teamToJoin);
                } else {
                    teamAndPlayers.get(teamToJoin).add(player);
                }
            }

            if (!teamAndLeader.get(teamToJoin).isEmpty()) {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
            }
            /*if (teamAndPlayers.get(teamToJoin) &&
                    !teamAndPlayers.containsValue(teamAndPlayers.get(teamToJoin))) {
                teamAndPlayers.putIfAbsent(teamToJoin, new ArrayList<>());
                teamAndPlayers.get(teamToJoin).add(player);
            } else {
                System.out.printf("Member %s cannot join team %s!%n",
                        player, teamToJoin);
            }*/

            /*} else {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
            }*/

            text = sc.nextLine();
        }

        teamAndLeader.forEach((k, v) -> {
            System.out.printf("%s%n- %s%n",k ,v);
            teamAndPlayers
                    .entrySet()
                    .stream()
                    .sorted((v1, v2) -> Integer.compare(v2.getValue().size(), v1.getValue().size()))
                    .forEach(p -> System.out.printf("-- %s%n", p));
        });
    }
}
