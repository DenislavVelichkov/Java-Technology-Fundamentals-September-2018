package _07_AssociativeArrays.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MOBAChallenger_03 {
    static class Player {
        private String name;
        private Map<String, Integer> tier;

        Player(String name, String tier, Integer points) {
            this();
            this.name = name;
            this.tier.putIfAbsent(tier, 0);
            this.tier.put(tier, points);
        }

        public Player() {
            this.tier = new LinkedHashMap<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getTier() {
            return tier;
        }

        void setTier(String tier, int points) {
            this.tier.putIfAbsent(tier, points);
            this.tier.put(tier, Math.max(this.tier.get(tier), points));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Player> playerPool = new ArrayList<>();

        while (true) {
            String line = reader.readLine();
            if (line.equals("Season end")) break;

            if (line.contains(" -> ")) {
                String[] tokens = line.split(" -> ");
                String playerName = tokens[0];
                String tier = tokens[1];
                int skillPoints = Integer.parseInt(tokens[2]);

                Optional<Player> playerCandidate = playerPool.stream()
                        .filter(player -> player.getName().equals(playerName))
                        .findFirst();
                if (playerCandidate.isPresent()) {
                    Player player = playerCandidate.get();
                    player.setTier(tier, skillPoints);
                } else {
                    Player player = new Player(playerName, tier, skillPoints);
                    playerPool.add(player);
                }

            } else {
                String[] tokens = line.split(" vs ");
                String player1 = tokens[0];
                String player2 = tokens[1];

                Optional<Player> player1ReadyToBattle =
                        playerPool
                                .stream()
                                .filter(player -> player.getName().equals(player1))
                                .findFirst();
                Optional<Player> player2ReadyToBattle =
                        playerPool
                                .stream()
                                .filter(player -> player.getName().equals(player2))
                                .findFirst();

                if (player1ReadyToBattle.isPresent() &&
                        player2ReadyToBattle.isPresent()) {
                    int countA = player1ReadyToBattle.get().getTier()
                            .values().stream().mapToInt(v -> v).sum();
                    int countB = player2ReadyToBattle.get().getTier()
                            .values().stream().mapToInt(v -> v).sum();

                    for (String key : player1ReadyToBattle.get().getTier().keySet()) {
                        if (player2ReadyToBattle.get().getTier().containsKey(key)) {
                            if (countA > countB) {
                                playerPool.remove(player2ReadyToBattle.get());
                            } else if (countA < countB) {
                                playerPool.remove(player1ReadyToBattle.get());
                            }
                        }
                    }
                }
            }
        }

        playerPool.stream()
                .sorted((o1, o2) -> {
                    int count1 =
                            o1.getTier().values()
                            .stream().mapToInt(value -> value).sum();
                    int count2 =
                            o2.getTier().values()
                                    .stream().mapToInt(value -> value).sum();

                    int result = Integer.compare(count2, count1);
                    if (result != 0) return result;
                    else return o2.getName().compareToIgnoreCase(o1.getName());

                })
                .forEach(player -> {
                    int sum = player.getTier().values()
                                    .stream().mapToInt(value -> value).sum();

                    System.out.printf("%s: %d skill%n", player.getName(), sum);
                    player.getTier().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed().thenComparing(Map.Entry.comparingByKey()))
                            .forEach(el -> System.out.printf("- %s <::> %d%n",
                                     el.getKey(), el.getValue()));
                });

    }
}