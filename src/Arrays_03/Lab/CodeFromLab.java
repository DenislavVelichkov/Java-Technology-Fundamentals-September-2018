package Arrays_03.Lab;

import java.util.Scanner;

public class CodeFromLab {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String firstText = sc.nextLine();
//        String[] firstTextArray = firstText.split(" ");
//        int firstLength = firstTextArray.length;
//        char[] first = new char[firstLength];
//        for (int i = 0; i < first.length; i++) {
//            String element = firstTextArray[i];
//            char firstCharacter = element.charAt(0);
//            first[i] = firstCharacter;
//        }
//
//        String secondText = sc.nextLine();
//        String[] secondTextArray = secondText.split(" ");
//        char[] second = new char[secondTextArray.length];
//        for (int i = 0; i < second.length; i++) {
//            second[i] = secondTextArray[i].charAt(0);
//        }
//
//        int smallestLength = Math.min(first.length, second.length);
//        char[] smallest = first.length <= second.length
//                ? first
//                : second;
//
//        char[] biggest = first.length > second.length
//                ? first
//                : second;
//
//        for (int i = 0; i < smallestLength; i++) {
//            if (first[i] < second[i]) {
//                break;
//            }
//            if (second[i] < first[i]) {
//                smallest = second;
//                biggest = first;
//                break;
//            }
//        }
//
//        for (int i = 0; i < smallest.length; i++) {
//            System.out.print(smallest[i]);
//        }
//        System.out.println();
//        for (int i = 0; i < biggest.length; i++) {
//            System.out.print(biggest[i]);
//        }
//    }


            Scanner sc = new Scanner(System.in);

            String input = sc.nextLine();
            String[] moneyCandidate = input.split(" ");
            int moneyLength = moneyCandidate.length;
            double[] money = new double[moneyLength];

            for (int i = 0; i < moneyLength; i++) {
                String coinCandidate = moneyCandidate[i]; // "200.22"
                double coin = Double.parseDouble(coinCandidate); // 200.22
                money[i] = coin;
            }


            int startPosition = Integer.parseInt(sc.nextLine());
            double sum = money[startPosition];

            String direction = sc.nextLine();

            while (!direction.equals("END")) {
                if (direction.equals("L")) {
                    if (startPosition == 0) {
                        System.out.println("Cannot move left. Please move right.");
                    } else {
                        startPosition = startPosition - 1;
                        sum += money[startPosition];
                    }
                } else if (direction.equals("R")) {
                    if (startPosition == money.length - 1) {
                        System.out.println("Cannot move right. Please move left.");
                    } else {
                        startPosition = startPosition + 1;
                        sum += money[startPosition];
                    }
                } else {
                    System.out.println("Invalid direction");
                }
                direction = sc.nextLine();
            }

            System.out.println(sum);
        }
    }