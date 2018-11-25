package Lists_05.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemMergingList_03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> finalArray = new ArrayList<>();

        List<Integer> numbersOne = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbersTwo = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int counter = 0;

        for (int i = 0; i < Math.min(numbersOne.size(), numbersTwo.size()); i++) {
            finalArray.add(i + counter, numbersOne.get(i));
            finalArray.add(i + 1 + counter, numbersTwo.get(i));
            counter++;
        }

        if (numbersOne.size() > numbersTwo.size()) {
            finalArray.addAll(getRemainingElements(numbersOne, numbersTwo));
        } else if (numbersOne.size() < numbersTwo.size()) {
            finalArray.addAll(getRemainingElements(numbersTwo, numbersOne));
        }

        System.out.println(finalArray.toString().replaceAll("[\\[\\],]", "")); //print list with " " (spaces)
    }

    private static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList) {
        List<Integer> nums = new ArrayList<>();

        for (int i = shorterList.size(); i < longerList.size(); i++)
            nums.add(longerList.get(i));

        return nums;
    }


}
