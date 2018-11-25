package DataTypesAndVariables_02.Exercise.MoreExercises;

import java.util.Scanner;

public class RefactoringPrimeChecker_05 {

    public static void main(String[] args) {

        Scanner chetec = new Scanner(System.in);

        int doSomething = Integer.parseInt(chetec.nextLine());

        for (int i = 2; i <= doSomething; i++) {
            boolean isTrue = true;
            for (int delitel = 2; delitel < i; delitel++) {
                if (i % delitel == 0) {
                    isTrue = false;
                    break;
                }
            }
            System.out.printf("%TopInteger_05_Ver2 -> %b%n", i, isTrue);
        }

    }
}
