package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TownInfo_03 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String townName = reader.readLine();
        int population = Integer.parseInt(reader.readLine());
        int sqrKm = Integer.parseInt(reader.readLine());

        System.out.printf("Town %s has population of " +
                "%d and area %d square km.",townName, population, sqrKm);
    }
}
