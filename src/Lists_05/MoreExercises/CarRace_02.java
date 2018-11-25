package Lists_05.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> track = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());

        int trackLength = track.size() / 2 ;
        double formulaONE = 0.0;
        double formulaTWO = 0.0;

        for (int i = 0; i < trackLength; i++) {
            formulaONE += Double.parseDouble(track.get(i));
            if (Double.parseDouble(track.get(i)) == 0) {
                formulaONE *= 0.8;
            }
        }

        for (int i = track.size() - 1; i > trackLength; i--) {
            formulaTWO += Double.parseDouble(track.get(i));
            if (Double.parseDouble(track.get(i)) == 0) {
                formulaTWO *= 0.8;
            }
        }

        boolean whoIsTheFastest = formulaONE < formulaTWO;
        System.out.printf("The winner is %s with total time: %.1f"
                , whoIsTheFastest ? "left":"right", whoIsTheFastest ? formulaONE:formulaTWO);

    }
}
