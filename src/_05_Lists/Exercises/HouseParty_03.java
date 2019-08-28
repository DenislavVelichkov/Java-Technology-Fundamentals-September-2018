package _05_Lists.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<String> partyList = new ArrayList<>();

        while (n-- != 0) {
            String line = scan.nextLine();
            String[] tokens = line.split("\\s+");
            String name = tokens[0];

            if (!line.contains("not")) {
                if (partyList.contains(name)) {
                    System.out.println(name + " is already in the list!");
                } else {
                    partyList.add(name);
                }

            } else {
                if (partyList.contains(name)) {
                    partyList.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");

                }
            }
        }

        for (String s : partyList)
            System.out.printf("%s%n", s);
    }
}
