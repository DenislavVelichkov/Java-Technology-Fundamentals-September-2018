package Arrays_03.Exercises;

import java.util.Scanner;

public class KaminoFactory_09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        int bestLength = 0;
        String bestDna = "";
        int bestIndex = 0;
        int bestSum = 0;
        int bestCounter = 0;
        int counter = 0;
        while (!line.equals("Clone them!")) {
            counter++;
            //010101111
            String sequence = line.replaceAll("!",     // removes symbol from string 0!1!0!0!1 = 01001
                    "");

            String[] dnas = sequence.split("0");
            //111111
            int maxLength = 0;
            int sum = 0;
            String bestLocalDna = "";
            for (int i = 0; i < dnas.length; i++) {
                if (dnas[i].length() > maxLength) {
                    maxLength = dnas[i].length();            //Взимаме най- голямата дължина на елементите на масива от 1-ци
                    bestLocalDna = dnas[i];
                }
                sum += dnas[i].length();                     // Най- голямата сума от 1-ци в DNA поредността
            }
            int beginIndex = sequence.indexOf(bestLocalDna); //Взимаме индекса на най- дългия String

            if (maxLength > bestLength) {
                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;
            } else if ((maxLength == bestLength) &&
                        ((beginIndex < bestIndex) ||
                        (sum > bestSum))) {
                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;
            } else if (counter == 1) {
                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;
            }

            line = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestCounter, bestSum);

        for (int i = 0; i < bestDna.length(); i++) {
            System.out.print(bestDna.charAt(i) + " ");
        }
        System.out.println();

    }
}