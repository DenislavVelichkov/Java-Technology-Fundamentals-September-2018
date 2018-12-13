package ExamExercises.ProgFundRetakeExam_27October2018Part1;

import java.util.Scanner;

public class Hogswatch_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int homesToVisit = Integer.parseInt(sc.nextLine());
        int totalAmountOfPresents = Integer.parseInt(sc.nextLine());
        int visitedHomes = 0;
        int presentsInStock = totalAmountOfPresents;
        int timesHeWentBack = 0;
        int presentsHeTookInAddition = 0;

        while (homesToVisit-- > 0) {
            int numOfSocks = Integer.parseInt(sc.nextLine());
            presentsInStock -= numOfSocks;

            if (presentsInStock < 0) {
                int socksDifference = Math.abs(presentsInStock);
                timesHeWentBack++;

                presentsInStock = (socksDifference + (totalAmountOfPresents /
                        (visitedHomes + 1)) * homesToVisit) - socksDifference ;
                presentsHeTookInAddition += (socksDifference + (totalAmountOfPresents /
                        (visitedHomes + 1)) * homesToVisit);
            }

            visitedHomes++;
        }

        if (timesHeWentBack == 0) {
            System.out.println(presentsInStock);
        } else {
            System.out.println(timesHeWentBack);
            System.out.println(presentsHeTookInAddition);
        }
    }
}
