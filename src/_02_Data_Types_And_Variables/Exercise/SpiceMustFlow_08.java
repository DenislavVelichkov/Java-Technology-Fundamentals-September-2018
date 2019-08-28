package _02_Data_Types_And_Variables.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiceMustFlow_08 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long extractedSpicePerDay = Integer.parseInt(reader.readLine());
        long daysCounter =  0L;
        long startingYield = extractedSpicePerDay;
        long totSpiceExtracted = 0L;

        while (startingYield >= 100) {
            daysCounter++;
            extractedSpicePerDay -= 26;
            startingYield -= 10;
            totSpiceExtracted += extractedSpicePerDay;
            extractedSpicePerDay = startingYield;

        }

        totSpiceExtracted -= 26;

        if (totSpiceExtracted < 0)
            totSpiceExtracted = 0;

        System.out.printf("%d%n", daysCounter);
        System.out.printf("%d", totSpiceExtracted);
    }
}
