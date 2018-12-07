package AssociativeArrays_07.MoreExercises;

import java.util.*;

public class Judge_02 {
     static class Player {
        private String username;
        private String contest;
        private Integer points;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Player> playerList = new ArrayList<>();
        Map<String, Integer> totalPointsDB = new LinkedHashMap<>();

        String line = sc.nextLine();

        while (!line.equals("no more time")) {
            String[] text = line.split(" -> ");

            String username = text[0];
            String module = text[1];
            Integer points = Integer.parseInt(text[2]);


            line = sc.nextLine();
        }
    }
}