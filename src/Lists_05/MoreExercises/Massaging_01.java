package Lists_05.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Massaging_01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());
        List<Integer> indexStorage = new ArrayList<>();

        int i = 0;

        while (i < numbers.size()) {
            int sumOfElementsDigits = calcSum(numbers.get(i).toString());
            int massageIndex = 0;
            int iterationsCount = 0;


            while (true) {
                iterationsCount++;
                massageIndex++;

                if (massageIndex == text.size() - 1) {
                    massageIndex = -1;
                }

                if (iterationsCount == sumOfElementsDigits) break;

            }

            indexStorage.add(massageIndex);
            i++;
        }


        for (int j = 0; j < indexStorage.size(); j++) {
            System.out.printf("%s", text.get(indexStorage.get(j)));
            text.remove(text.get(indexStorage.get(j)));

        }
    }


    private static int calcSum(String integers) {
        int sum = 0;
        String[] tempArr = integers.split("");

        for (String aTempArr : tempArr) {
            sum += Integer.parseInt(aTempArr);
        }

        return sum;
    }
}
