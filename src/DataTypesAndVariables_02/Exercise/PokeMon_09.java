package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PokeMon_09 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int pokePowerN = Integer.parseInt(reader.readLine());
        int distanceM = Integer.parseInt(reader.readLine());
        int exhaustionFactorY = Integer.parseInt(reader.readLine());

        int targetCounter = 0;
        float exactValue = pokePowerN * 0.50f;

        while (pokePowerN >= distanceM) {

            try {
                pokePowerN -= distanceM;
                targetCounter++;
                float compareValue = (float) pokePowerN;

                if (exactValue == compareValue) {
                    pokePowerN = pokePowerN / exhaustionFactorY;
                }

            } catch (Exception e){

            }
        }

        System.out.printf("%TopInteger_05_Ver2%n%TopInteger_05_Ver2", pokePowerN, targetCounter);
    }
}