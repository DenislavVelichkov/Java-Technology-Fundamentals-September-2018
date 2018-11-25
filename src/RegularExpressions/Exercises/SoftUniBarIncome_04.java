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

        while (!line.equals("end of shift")) {
            Pattern validateLine = Pattern.compile
            ("(?<name>%[A-Z][a-z]+%)([^\\|\\$\\%\\.]+)?(?<product><[A-Za-z0-9\\.?_-]+>)(?<quantity>([^\\|\\$\\%\\.0-9]+)?\\|[0-9\\.?]+\\|)(?<price>([^\\|\\$\\%\\.0-9]+)?([0-9\\.?]+))(\\$)");
            Matcher matcher = validateLine.matcher(line);

            String name = "";
            String product = "";
            int quantity = 0;
            double price = 0.0;
            boolean flag = false;

            while (matcher.find()) {
                flag = true;

                name = Arrays.toString(matcher.group
                ("name").split("\\%+")).trim().replaceAll("[, \\[\\]]", "");

                product = Arrays.toString(matcher.group
                ("product").split("[<>]+")).trim().replaceAll("[, \\[\\]]", "");

                quantity = Integer.parseInt(Arrays.toString(matcher.group
                ("quantity").split("([\\|\\|])|([^\\|\\$\\%\\.0-9]+)")).trim().replaceAll("[, \\[\\]]", ""));

                price = Double.parseDouble(Arrays.toString(matcher.group
                ("price").split("[^\\|\\$\\%\\.0-9]+|\\$")).trim().replaceAll("[, \\[\\]]", ""));
            }

            if (flag) {
                income += quantity * price;
                System.out.printf("%s: %s - %.2f%n",name, product, quantity * price);
            }

            line = sc.nextLine();
        }

        System.out.printf("Total income: %.2f", income);
    }
}
