package AssociativeArrays_07.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MOBAChallenger_03 {
    static class Player {
        private String name = "";
        private Map<String, Integer> tier;
        private Map<String, Integer> sortedTier;

        Player(String name, String tier, Integer skillPoints) {
            this();
            this.name = name;
            this.tier.putIfAbsent(tier, 0);
            this.tier.put(tier, skillPoints);
        }

        Player() {
            this.tier = new LinkedHashMap<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Map<String, Integer> getTier() {
            sortedTier = sortTier(tier);
            return tier;
        }

        private Map<String, Integer> sortTier(Map<String, Integer> tier) {
            Map<String, Integer> sortedMap = new LinkedHashMap<>();

            tier
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue((o1, o2) -> {
                        int result = Integer.compare(o2, o1);
                        if (result != 0) return result;
                        else return 1;
                    }).thenComparing(Map.Entry.comparingByKey()))
                    .forEach(o -> {
                        sortedMap.putIfAbsent(o.getKey(), 0);
                        sortedMap.put(o.getKey(), o.getValue());
                    });
            return sortedMap;
        }

        void setTier(String name, Integer skillPoints) {
            this.tier.putIfAbsent(name, 0);
            this.tier.put(name, skillPoints);
        }

        Map<String, Integer> getSortedTier() {
            return sortedTier;
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

                boolean isPlayerPresent = false;
                for (Player pl : playerPool) {
                    if (pl.getName().contains(playerName)) {
                        for (Map.Entry<String, Integer> entry : pl.getTier().entrySet()) {
                            if (entry.getKey().contains(tier)) {
                                if (entry.getValue() <= skillPoints) {
                                    pl.setTier(entry.getKey(), skillPoints);
                                }
                            } else {
                                pl.setTier(tier, skillPoints);
                                isPlayerPresent = true;
                                break;
                            }
                        }
                    }
                }

                if (!isPlayerPresent) {
                    Player user = new Player(playerName, tier, skillPoints);
                    playerPool.add(user);
                }

            } else {
                String[] tokens = line.split(" vs ");
                String player1 = tokens[0];
                String player2 = tokens[1];

                List<Player> battle = new ArrayList<>();
                for (Player player : playerPool) {
                    if (player.getName().contains(player1)) {
                        battle.add(player);
                    }
                    if (player.getName().contains(player2)) {
                        battle.add(player);
                    }
                }

                if (battle.size() != 2) continue;

                Player plA = battle.get(0);
                Player plB = battle.get(1);
               /* int strLength =
                        Math.max(battle.get(0).getTier().size(),
                                battle.get(1).getTier().size());*/

                /*if (plA.getTier().size() == strLength) {*/
                for (Map.Entry<String, Integer> entry : plA.getTier().entrySet()) {
                    if (plB.getTier().containsKey(entry.getKey())) {
                        int count1 = plA.getTier().values().stream().mapToInt(v -> v).sum();
                        int count2 = plB.getTier().values().stream().mapToInt(v -> v).sum();

                        if (count1 > count2) {
                            playerPool.remove(plB);
                        } else if (count1 < count2) {
                            playerPool.remove(plA);
                        }

                    }
                }
            }
                /*} else {
                    plA.getTier().forEach((key, value) -> {
                        if (plB.getTier().containsKey(key)) {
                            int count1 = plA.getTier().values().stream().mapToInt(v -> value).sum();
                            int count2 = plB.getTier().values().stream().mapToInt(v -> value).sum();

                            if (count1 > count2) {
                                playerPool.remove(plB);
                            }
                            if (count1 < count2) {
                                playerPool.remove(plA);
                            }

                        }
                    });
                }*/

        }

        playerPool.stream()
                    .sorted((o1, o2) -> {
                    int count1 = o1.getTier().values().stream().mapToInt(value -> value).sum();
                    int count2 = o2.getTier().values().stream().mapToInt(value -> value).sum();

                    int result = Integer.compare(count2, count1);
                    if (result != 0) return result;
                    else return o1.getName().compareToIgnoreCase(o2.getName());

                })
                .forEach(player -> {
                    int sum = player.getTier().values().stream().mapToInt(value -> value).sum();
                    System.out.printf("%s: %d skill%n", player.getName(), sum);
                    player.getSortedTier().forEach((s, integer) -> System.out.printf("- %s <::> %d%n", s, integer));
                });

    }
}
/**/