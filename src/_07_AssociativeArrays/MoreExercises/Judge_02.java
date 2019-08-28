package _07_AssociativeArrays.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Judge_02 {
    static class Player {
        private String username;
        private String contest;
        private Integer points;

        Player(String username, String contest, Integer points) {
            this.username = username;
            this.contest = contest;
            this.points = points;
        }

        String getUsername() {
            return username;
        }

        String getContest() {
            return contest;
        }

        Integer getPoints() {
            return points;
        }

        void setPoints(Integer points) {
            this.points = Math.max(this.points, points);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Player>> contestDB = new LinkedHashMap<>();
        Map<String, Integer> totalPointsDB = new LinkedHashMap<>();
        String line = reader.readLine();

        while (!line.equals("no more time")) {
            String[] text = line.split(" -> ");

            String username = text[0];
            String contest = text[1];
            Integer points = Integer.parseInt(text[2]);


            contestDB.putIfAbsent(contest, new ArrayList<>());
            final boolean[] playerIsPresent = {false};

            contestDB.forEach((key, value) -> {
                Optional<Player> playerToChangeStats =
                        value.stream()
                                .filter(player -> player.getUsername().equals(username) &&
                                        player.getContest().equals(contest))
                                .findFirst();

                if (playerToChangeStats.isPresent()) {
                    playerToChangeStats.get().setPoints(points);

                    int differenceInPoints = playerToChangeStats.get().getPoints() -
                            totalPointsDB.get(playerToChangeStats.get().getUsername());
                    int pointsDifference = differenceInPoints < 0 ? 0 : differenceInPoints;

                    totalPointsDB.put(playerToChangeStats.get().getUsername(),
                            totalPointsDB.get(
                                    playerToChangeStats.get().getUsername()) + pointsDifference);
                    playerIsPresent[0] = true;
                }
            });

            if (!playerIsPresent[0]) {
                Player newPlayer = new Player(username, contest, points);
                contestDB.get(contest).add(newPlayer);
                totalPointsDB.putIfAbsent(newPlayer.getUsername(), 0);
                totalPointsDB.put(newPlayer.getUsername(),
                        (newPlayer.getPoints() + totalPointsDB.get(newPlayer.getUsername())));
            }

            line = reader.readLine();
        }

        final int[] counter = new int[1];
        contestDB.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());

            counter[0] = 0;
            value.stream()
                    .sorted((o1, o2) -> {
                        int result = Integer.compare(o2.getPoints(), o1.getPoints());
                        if (result != 0) return result;
                        else return o1.getUsername().compareTo(o2.getUsername());
                    })
                    .forEach(player -> System.out.printf("%d. %s <::> %d%n",
                            ++counter[0], player.getUsername(), player.getPoints()));
        });

        System.out.println("Individual standings:");
        counter[0] = 0;
        totalPointsDB.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.printf("%d. %s -> %d%n",
                        ++counter[0], entry.getKey(), entry.getValue()));
    }
}