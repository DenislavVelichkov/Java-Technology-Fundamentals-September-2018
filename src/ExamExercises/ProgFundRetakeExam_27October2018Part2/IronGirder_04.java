package ExamExercises.ProgFundRetakeExam_27October2018Part2;

import java.util.*;
import java.util.function.ToIntFunction;

public class IronGirder_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, Integer> townsWithTimes = new HashMap<>();
        Map<String, Integer> townsWithPassengers = new HashMap<>();
        while (!input.equals("Slide rule")) {
            if (input.contains("ambush")) {
                String[] data = input.split(":");
                String town = data[0];
                String[] secondPart = data[1].split("->");

                if (townsWithTimes.containsKey(town)) {
                    townsWithTimes.put(town, 0);
                    townsWithPassengers.put(town,
                            townsWithPassengers.get(town) - Integer.parseInt(secondPart[1]));
                }
            } else {
                String[] data = input.split(":");
                String town = data[0];
                String[] secondPart = data[1].split("->");
                int time = Integer.parseInt(secondPart[0]);
                int passengers = Integer.parseInt(secondPart[1]);

                if (!townsWithTimes.containsKey(town)) {
                    townsWithTimes.put(town, time);
                    townsWithPassengers.put(town, passengers);
                } else {
                    if (townsWithTimes.get(town) > time || townsWithTimes.get(town) == 0) {
                        townsWithTimes.put(town, time);
                    }
                    townsWithPassengers.put(town, townsWithPassengers.get(town) + passengers);
                }
            }

            input = sc.nextLine();
        }

        townsWithTimes.entrySet().stream()
                /*.sorted((o1, o2) -> {
                    int result = o1.getValue().compareTo(o2.getValue());
                    return result != 0 ? result : o1.getKey().compareTo(o2.getKey());
                })*/
                .sorted(Comparator.comparingInt(
                        (ToIntFunction<Map.Entry<String, Integer>>)
                        Map.Entry::getValue).thenComparing(Map.Entry::getKey))

                .forEach(entry -> {
                    if (entry.getValue() != 0 &&
                            townsWithPassengers.get(entry.getKey()) > 0) {
                        System.out.printf("%s -> Time: %d -> Passengers: %d%n",
                                entry.getKey(), entry.getValue(), townsWithPassengers.get(entry.getKey()));
                    }
                });
    }
}
