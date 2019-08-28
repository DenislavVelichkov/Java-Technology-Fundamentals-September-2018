package _07_AssociativeArrays.Excersise;

import java.util.*;

public class CompanyUsers_08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        Map<String, ArrayList<String>> companyAndIds = new TreeMap<>();

        while (!command.equals("End")) {
            String[] token = command.split("->");
            String company = token[0];
            String id = token[1];
            companyAndIds.putIfAbsent(company, new ArrayList<>());

            if (!companyAndIds.get(company).contains(id)) {
                companyAndIds.get(company).add(id);
            }

            command = sc.nextLine();
        }

        companyAndIds
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey().trim());

                    entry.getValue()
                            .stream()
                            .forEach(e -> System.out.printf("--%s%n", e));
                });
    }
}