package AssociativeArrays_07.MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class Judge_02 {
    static class Player {
        private String username;
        private String contest;
        private Integer points;

        public Player(String username, String contest, int points) {
            this.username = username;
            this.contest = contest;
            this.points = points;

        }

        public Player() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getContest() {
            return contest;
        }

        public void setContest(String contest) {
            this.contest = contest;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = Math.max(this.points, points);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Player>> contestDB = new LinkedHashMap<>();
        Map<String, Integer> totalPointsDB = new LinkedHashMap<>();

        String line = sc.nextLine();

        while (!line.equals("no more time")) {
            String[] text = line.split(" -> ");

            String username = text[0];
            String contest = text[1];
            Integer points = Integer.parseInt(text[2]);


            contestDB.putIfAbsent(contest, new ArrayList<>());

            for (Map.Entry<String, List<Player>> entry : contestDB.entrySet()) {
                Optional<Player> playerToAdd =
                        entry.getValue().stream()
                                .filter(player -> player.getUsername().equals(username) &&
                                        player.getContest().equals(contest))
                                .findFirst();
                if (playerToAdd.isPresent()) {
                    playerToAdd.get().setPoints(points);
//                    contestDB.get(entry.getKey()).add(playerToAdd.get());
                    int pointsDifference =
                            Math.max(totalPointsDB.get(playerToAdd.get().getUsername()),
                                    playerToAdd.get().getPoints());

                    totalPointsDB.put(playerToAdd.get().getUsername(),
                            totalPointsDB.get(playerToAdd.get().getUsername()) + pointsDifference);
                }
            }

            Player newPlayer = new Player(username, contest, points);
            contestDB.get(contest).add(newPlayer);
            totalPointsDB.putIfAbsent(newPlayer.getUsername(), 0);

            for (Map.Entry<String, Integer> entry : totalPointsDB.entrySet()) {
                if (entry.getKey().equals(newPlayer.getUsername())) {
                    totalPointsDB.put(newPlayer.getUsername(),
                            totalPointsDB.get(newPlayer.getUsername()) +
                                    newPlayer.getPoints());
                    break;
                }
            }

            line = sc.nextLine();
        }

        contestDB.entrySet().stream()
                 .sorted((o1, o2) -> {
                     int result = Integer.compare(o2.getValue().size(), o1.getValue().size());
                     if (result != 0) return result;
                     else return 1;
                 })
                .forEach(entry -> {
                    System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());

                   List<Player>sortedEntry = entry.getValue().stream()
                            .sorted((o1, o2) -> {
                                int result = Integer.compare(o2.getPoints(), o1.getPoints());
                                if (result != 0) return result;
                                else return o1.getUsername().compareToIgnoreCase(o2.getUsername());
                            })
                            .collect(Collectors.toList());

                   int counter = 1;
                    for (Player player : sortedEntry) {
                        System.out.printf("%d. %s <::> %d%n",
                                counter++, player.getUsername(), player.getPoints());
                    }
                });

        Map<String, Integer> sortedTotalPoints = new LinkedHashMap<>();
        totalPointsDB.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    sortedTotalPoints.putIfAbsent(entry.getKey(), 0);
                    sortedTotalPoints.put(entry.getKey(), entry.getValue());
                });

        System.out.println("Individual Standings:");
        int counter = 1;
        for (Map.Entry<String, Integer> entry : sortedTotalPoints.entrySet()) {
            System.out.printf("%d. %s -> %d%n",
                    counter++, entry.getKey(), entry.getValue());
        }
    }
}