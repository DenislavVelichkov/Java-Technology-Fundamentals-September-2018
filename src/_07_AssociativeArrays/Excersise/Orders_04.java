package _07_AssociativeArrays.Excersise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        Map<String, Double> productAndPrice = new LinkedHashMap<>();
        Map<String, Integer> productAndQuantity = new HashMap<>();

        while (!command.equals("buy")) {
            String[] tokens = command.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);
            productAndPrice.putIfAbsent(product, 0.0);
            productAndQuantity.putIfAbsent(product, 0);

            if (productAndPrice.get(product) != price){
                productAndPrice.put(product, price);
            }

            productAndQuantity.put(product, productAndQuantity.get(product) + quantity);


            command = sc.nextLine();
        }

        productAndPrice
                .forEach((k, v) -> {
                    System.out.printf("%s -> %.2f%n", k, v * productAndQuantity.get(k));
                });
    }
}
