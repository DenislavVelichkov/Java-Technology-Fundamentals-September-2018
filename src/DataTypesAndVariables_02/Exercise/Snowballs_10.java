package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snowballs_10 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int snowballsCount = Integer.parseInt(reader.readLine());

        int snowQuantity = 0;
        int snowTime = 0;
        int snowQuality = 0;
        double snowValue = 0;
        double highestValue = 0;

        for (int i = 1; i <= snowballsCount; i++) {
            int snowballSnow = Integer.parseInt(reader.readLine());
            int snowballTime = Integer.parseInt(reader.readLine());
            int snowballQuality = Integer.parseInt(reader.readLine());

            double snowballValue = Math.pow((float)(snowballSnow / snowballTime), snowballQuality);

            if (highestValue < snowballValue) {
                highestValue = snowballValue;

                snowQuality = snowballQuality;
                snowQuantity = snowballSnow;
                snowTime = snowballTime;
                snowValue = highestValue;

            }
        }

        System.out.printf("%TopInteger_05_Ver2 : %TopInteger_05_Ver2 = %.0f (%TopInteger_05_Ver2)", snowQuantity, snowTime, snowValue, snowQuality);
    }
}

