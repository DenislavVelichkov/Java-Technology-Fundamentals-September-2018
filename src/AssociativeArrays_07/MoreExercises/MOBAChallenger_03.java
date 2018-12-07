package AssociativeArrays_07.MoreExercises;

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
                        playerPool.stream().filter(player -> player.getName().equals(player1))
                                .findFirst();
                Optional<Player> player2ReadyToBattle =
                        playerPool.stream().filter(player -> player.getName().equals(player2))
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
                    int count1 = o1.getTier().values().stream().mapToInt(value -> value).sum();
                    int count2 = o2.getTier().values().stream().mapToInt(value -> value).sum();

                    int result = Integer.compare(count2, count1);
                    if (result != 0) return result;
                    else return o2.getName().compareToIgnoreCase(o1.getName());

                })
                .forEach(player -> {
                    int sum =
                            player.getTier().values().stream().mapToInt(value -> value).sum();

                    System.out.printf("%s: %d skill%n", player.getName(), sum);
                    player.getTier().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed().thenComparing(Map.Entry.comparingByKey()))
                            .forEach(el -> System.out.printf("- %s <::> %d%n",
                                     el.getKey(), el.getValue()));
                });

    }
}
/*namespace _04.MOBAChallenger
{
    class MOBAChallenger
    {
        static void Main(string[] args)
        {
            Dictionary<string, PlayerPosition> players =
                new Dictionary<string, PlayerPosition>();
            string input = string.Empty;
            while ((input = Console.ReadLine()) != "Season end")
            {
                string[] tokens = input.Split(new string[] { " -> " },
                    StringSplitOptions.RemoveEmptyEntries);
                if (tokens.Length == 3)
                {
                    string player = tokens[0];
                    string position = tokens[1];
                    int skill = int.Parse(tokens[2]);
                    if (!players.ContainsKey(player))
                    {
                        players.Add(player, new PlayerPosition());
                    }
                    players[player].AddPosition(position, skill);
                }
                else
                {
                    tokens = input.Split(new string[] { " vs " },
                    StringSplitOptions.RemoveEmptyEntries);
                    string player1 = tokens[0];
                    string player2 = tokens[1];
                    if (players.ContainsKey(player1) &&
                        players.ContainsKey(player2) &&
                        (HaveCommonPositions(players, player1, player2)))
                    {
                        if (players[player1].TotalSkill > players[player2].TotalSkill)
                        {
                            players.Remove(player2);
                        }
                        else if (players[player1].TotalSkill < players[player2].TotalSkill)
                        {
                            players.Remove(player1);
                        }
                    }
                }
            }
            foreach (KeyValuePair<string, PlayerPosition> player in players
                .OrderByDescending(x => x.Value.TotalSkill)
                .ThenBy(x => x.Key))
            {
                Console.WriteLine($"{player.Key}: {player.Value.TotalSkill} skill");
                foreach (KeyValuePair<string, int> position in player
                    .Value
                    .Positions
                    .OrderByDescending(x => x.Value)
                    .ThenBy(x => x.Key))
                {
                    Console.WriteLine($"- {position.Key} <::> {position.Value}");
                }
            }
        }

        private static bool HaveCommonPositions(
            Dictionary<string, PlayerPosition> players,
            string player1, string player2)
        {
            foreach (KeyValuePair<string, int> position1 in players[player1].Positions)
            {
                foreach (KeyValuePair<string, int> position2 in players[player2].Positions)
                {
                    if (position1.Key == position2.Key)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    class PlayerPosition
    {
        public Dictionary<string, int> Positions { get; set; }
        public int TotalSkill { get; set; }
        public PlayerPosition()
        {
            Positions = new Dictionary<string, int>();
        }
        public void AddPosition(string position, int skill)
        {
            if (!Positions.ContainsKey(position))
            {
                Positions.Add(position, skill);
                TotalSkill += skill;
            }
            else if (Positions.ContainsKey(position) &&
                Positions[position] < skill)
            {
                TotalSkill -= Positions[position];
                TotalSkill += skill;
                Positions[position] = skill;
            }
        }
    }
}*/