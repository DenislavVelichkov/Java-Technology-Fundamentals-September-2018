package AssociativeArrays_07.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (Double num : nums) {

            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }

            counts.put(num, counts.get(num) + 1);

        }

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());

        }
    }
}
