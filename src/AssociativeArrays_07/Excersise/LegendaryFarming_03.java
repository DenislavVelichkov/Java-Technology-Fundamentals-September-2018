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
        boolean isObtrained = false;

        while (!isObtrained) {
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

                        isObtrained = true;
                        break;
                    }

                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }
//First way of sorting hashmaps.
        materialsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
//Second way of sorting hashmaps, Alphabetical ascending order. For descending order reverse (k, v) values
        /*materialsCount.entrySet().stream()
                .sorted((k, v) -> {
                    if (Integer.compare(k.getValue(), v.getValue()) == 0) {
                        return k.getKey().compareTo(v.getKey());
                    } else {
                        return v.getValue() - k.getValue();
                    }
                })*/



        junk.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}
