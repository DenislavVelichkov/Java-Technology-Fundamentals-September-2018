package _07_AssociativeArrays.Excersise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] command = sc.nextLine().split(" ");

        Map<String, String> userAndLcense = new LinkedHashMap<>();

        while (n-- > 0) {
            String action = command[0];
            String name = command[1];

            if (action.equals("register")) {
                String licensePlate = command[2];

                userAndLcense.putIfAbsent(name, "");
                if (userAndLcense.get(name).equals(licensePlate)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);
                } else {
                    userAndLcense.put(name, licensePlate);
                    System.out.printf("%s registered %s successfully%n", name, licensePlate);
                }
            } else if (action.equals("unregister")) {
                if (userAndLcense.containsKey(name)) {
                    userAndLcense.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                } else {
                    System.out.printf("ERROR: user %s not found%n", name);
                }
            }
            if (n == 0) break;
            command = sc.nextLine().split(" ");
        }

        userAndLcense.entrySet().forEach(u -> System.out.printf("%s => %s%n", u.getKey(), u.getValue()));
    }
}
