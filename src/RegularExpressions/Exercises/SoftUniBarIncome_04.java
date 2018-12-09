package RegularExpressions.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        double income = 0.0;
        Pattern validateLine = Pattern.compile
        ("([^\\|\\$%.]+)?%(?<name>[A-Z][a-z]+)%([^\\|\\$%.]+)?<(?<product>\\w+)>([^\\|\\$%.]+)?\\|(?<quantity>\\d+)\\|([^0-9\\|\\$%.]+)?(?<price>\\d+\\.?\\d+)\\$([^\\|\\$%.]+)?");

        while (!line.equals("end of shift")) {
            Matcher matcher = validateLine.matcher(line);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                income += quantity * price;
                System.out.printf("%s: %s - %.2f%n",name, product, quantity * price);
            }

            line = sc.nextLine();
        }

        System.out.printf("Total income: %.2f", income);
    }
}
