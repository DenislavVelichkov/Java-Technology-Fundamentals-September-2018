package RegularExpressions.Exercises;

import java.util.*;

public class Furniture_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayList<String> trimedList = new ArrayList<>();
        Map<String, Double> boughtList = new LinkedHashMap<>();
        while (!line.equals("Purchase")) {
            String[] text = line.split("[^A-Za-z0-9\\.?\\s]+");

            trimedList.addAll(Arrays.asList(text));
            trimedList.removeIf(String::isEmpty);

            if (trimedList.size() == 3) {
                String furnitureName = trimedList.get(0);
                double price = Double.parseDouble(trimedList.get(1));
                int quantity = Integer.parseInt(trimedList.get(2));

                boughtList.putIfAbsent(furnitureName, 0.0);
                boughtList.put(furnitureName, price * quantity);
            }

            trimedList.clear();
            line = sc.nextLine();
        }

        double sum = 0.0;
        System.out.println("Bought furniture:");
        for (Map.Entry<String, Double> e : boughtList.entrySet()) {
            System.out.printf("%s%n", e.getKey());
            sum += e.getValue();
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
