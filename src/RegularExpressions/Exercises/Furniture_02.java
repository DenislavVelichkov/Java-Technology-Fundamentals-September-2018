package RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Pattern pattern = Pattern.compile(">>(?<item>.*)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)");
        double sum = 0.0;

        System.out.println("Bought furniture:");
        while (!line.equals("Purchase")) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String furnitureName = matcher.group("item");
                double price = Double.parseDouble(matcher.group("price"));
                double quantity = Double.parseDouble(matcher.group("quantity"));

                System.out.printf("%s%n", furnitureName);
                sum += price * quantity;
            }

            line = sc.nextLine();
        }

        System.out.printf("Total money spend: %.2f", sum);
    }
}
