package AssociativeArrays_07.MoreExercises;

import java.util.*;

public class Judge_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> contest = new LinkedHashMap<>();
        Map<String, Integer> totalPointsDB = new LinkedHashMap<>();
        String line = sc.nextLine();

        while (!line.equals("no more time")) {
            String[] text = line.split(" -> ");

            String username = text[0];
            String module = text[1];
            Integer points = Integer.parseInt(text[2]);

            contest.putIfAbsent(module, new LinkedHashMap<>());
            int pointsDifference = 0;

            if (!contest.containsKey(module)) {
                contest.get(module).putIfAbsent(username, 0);
                contest.get(module).put(username, points);
                totalPointsDB.putIfAbsent(username, 0);
                totalPointsDB.put(username, points);

                if (contest.get(module).containsValue(username)) {
                    int currentPoints = contest.get(module).get(username);
                    int pointsToAdd = currentPoints < points ? points : currentPoints;
                    contest.get(module).put(username, pointsToAdd);
                }

//                pointsDifference = points - currentPoints <= 0 ? points - currentPoints : 0;

                line = sc.nextLine();
            }

            if (!contest.containsKey(module)) {
                int finalPointsDifference = pointsDifference;
                contest.values().forEach(map -> {
                    if (map.containsKey(username)) {
                        totalPointsDB.put(username,
                                (totalPointsDB.get(username) + finalPointsDifference));
                    }
                });
            }

        }
/*
        contest.values().forEach(users -> {
            for (User user : users) {
                contest.values().forEach(e -> {
                    e.stream()
                            .filter(o -> {
                                if (user.getName().equals(o.getName())) {
                                    Objects.equals(user.getPoints(), o.getPoints());
                                    return true;
                                }
                                return false;
                            })  .findFirst()
                                .ifPresent(user1 -> user1.setTotalPoints(
                                    user1.getTotalPoints() + user.getPoints() + user1.getPoints()));

                });
            }
        });

        contest.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n",
                    key, value.size());

            value.sort((o1, o2) -> {
                int result = o2.getPoints().compareTo(o1.getPoints());
                return result != 0 ? result : 1;
            });

            for (int i = 0; i < value.size(); i++) {
                System.out.printf("%d. %s <::> %d%n",
                        i + 1,
                        value.get(i).getName(),
                        value.get(i).getPoints());
            }
        });

        contest.values().forEach(finalist::addAll);
        finalist.sort((o1, o2) -> {
            int result = o2.getTotalPoints().compareTo(o1.getTotalPoints());
            if (result != 0) return result;
            else return 1;
        });

        int counter = 1;
        System.out.println("Individual standings:");

        for (User user : finalist) {
            System.out.printf("%d. %s -> %d%n",
                    counter++,
                    user.getName(),
                    user.getTotalPoints());
        }
*/

    }
}