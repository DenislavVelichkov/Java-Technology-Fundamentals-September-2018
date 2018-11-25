package DataTypesAndVariables_02.Exercise.MoreExercises;

import java.util.Scanner;

public class FromLeftToTheRight_02 {

    public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);

                int linesCount = Integer.parseInt(scan.nextLine());

                for (int i = 0; i < linesCount; i++) {
                    String[] input = scan.nextLine().split(" ");

                    long leftSide = Long.parseLong(input[0]);
                    long rightSide = Long.parseLong(input[1]);

                    if (leftSide >= rightSide) {
                        printNumber(leftSide);

                    } else {
                        printNumber(rightSide);
                    }

                }


            }

            private static void printNumber(long number) {
                long sum = 0;
                while (number != 0) {
                    sum += Math.abs(number % 10);
                    number /= 10;

                }
                System.out.println(sum);

            }
        }