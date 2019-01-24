package AssociativeArrays_07.Excersise;

import java.util.*;

public class LegendaryFarming_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> materialsCount = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        materialsCount.put("fragments", 0);
        materialsCount.put("motes", 0);
        materialsCount.put("shards", 0);
        boolean isObtained = false;

        while (!isObtained) {
            String[] materials = sc.nextLine().split(" ");

            for (int i = 0; i < materials.length - 1; i += 2) {
                int quantity = Integer.parseInt(materials[i]);
                String material = materials[i + 1].toLowerCase();

                if (material.equals("motes") || material.equals("shards")
                        || material.equals("fragments")) {
                    materialsCount.put(material, materialsCount.get(material) + quantity);

                    if (materialsCount.get(material) >= 250) {
                        materialsCount.put(material, materialsCount.get(material) - 250);

                        if (material.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        } else if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else {
                            System.out.println("Valanyr obtained!");
                        }

                        isObtained = true;
                        break;
                    }

                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }

        materialsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}
