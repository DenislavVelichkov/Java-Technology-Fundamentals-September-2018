package ExamExercises.DemoMidExam27_10_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BakingFactory_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        int bestBatchQuality = -100;
        int bestLength = 0;
        double bestAvg = 0;
        List<String> bestBatch = new ArrayList<>();

        while (!command.equals("Bake It!")) {
            String[] currentBatch = command.split("#");

            int totalQuality = getTotalQuality(currentBatch);
            double avg = getAvgQuality(currentBatch);

            if (totalQuality > bestBatchQuality) {
                bestBatchQuality = totalQuality;
                bestBatch = Arrays.asList(currentBatch);
                bestLength = currentBatch.length;
                bestAvg = avg;

            } else if (totalQuality == bestBatchQuality) {

                if (avg > bestAvg) {
                       bestAvg = avg;
                       bestLength = currentBatch.length;
                       bestBatch = Arrays.asList(currentBatch);
                } else if (currentBatch.length < bestLength) {
                    bestLength = currentBatch.length;
                    bestBatch = Arrays.asList(currentBatch);
                }

            }

            command = sc.nextLine();
        }

        System.out.println("Best Batch quality: " + bestBatchQuality);
        for (String index : bestBatch) {
            System.out.printf("%s ", index);
        }

    }

    private static int getTotalQuality(String[] currentBatch) {
        int totalQ = 0;
        for (int i = 0; i < currentBatch.length; i++) {
            totalQ += Integer.parseInt(currentBatch[i]);
        }

        return totalQ;
    }

    private static double getAvgQuality(String[] tokens) {
        double avg = 0;

        for (int i = 0; i < tokens.length; i++) {
            avg += Double.parseDouble(tokens[i]);
        }

        avg /= tokens.length;
        return avg;
    }
}
