package AssociativeArrays_07.Excersise;

import java.util.*;

public class AMinerTask_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer > resourcesAndQuantity = new LinkedHashMap<>();

        while (true) {
            String resource = sc.nextLine();

            if (resource.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(sc.nextLine());

            resourcesAndQuantity.putIfAbsent(resource, 0);
            resourcesAndQuantity.put(resource,resourcesAndQuantity.get(resource) + quantity);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : resourcesAndQuantity.entrySet()) {
            System.out.printf("%s -> %s%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

    }
}
