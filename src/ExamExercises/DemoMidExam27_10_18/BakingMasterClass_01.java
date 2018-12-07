package ExamExercises.DemoMidExam27_10_18;

import java.util.Scanner;

public class BakingMasterClass_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        double students = Integer.parseInt(sc.nextLine());
        double priceOfFlour = Double.parseDouble(sc.nextLine());
        double priceOfAnEgg = Double.parseDouble(sc.nextLine());
        double priceOfAnApron = Double.parseDouble(sc.nextLine());

        double costOfApronPerStudent = priceOfAnApron * Math.ceil(students + (students * 0.2));
        double costOfEggPerStudent = (priceOfAnEgg * 10) * students;
        double freePack = Math.floor(students / 5);
        double costOfFlourPerStudent = priceOfFlour * students;
        double totCostOfFlour = costOfFlourPerStudent - (freePack * priceOfFlour);

        double totPrice = costOfApronPerStudent + costOfEggPerStudent + totCostOfFlour;

        if (totPrice <= budget) {
            System.out.printf("Items purchased for %.2f$.", totPrice);
        } else {
            System.out.printf("%.2f$ more needed.", totPrice - budget);
        }

    }
}
