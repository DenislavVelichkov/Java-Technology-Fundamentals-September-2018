package _01_Basic_Syntax_Conditional_Statements_And_Loops.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vacation_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int peopleCount = Integer.parseInt(reader.readLine());
        String peopleGroup = reader.readLine();
        String vacPeriod = reader.readLine();
//Wrong condition and Judge problem. !!!
        double totExpences = 0;
        double discount = 0;
        double groupOverload;
        boolean flag = false;

        switch (peopleGroup) {
            case "Students":
                switch (vacPeriod) {
                    case "Friday":
                        if (peopleCount >= 30) {
                            totExpences = peopleCount * 8.45;
                            discount = totExpences * 0.85;
                            flag = true;
                        } else
                            totExpences = peopleCount * 8.45;
                        break;

                    case "Saturday":
                        if (peopleCount >= 30) {
                            totExpences = peopleCount * 9.80;
                            discount = totExpences * 0.85;
                            flag = true;
                        } else
                            totExpences = peopleCount * 9.80;
                        break;

                    case "Sunday":
                        if (peopleCount >= 30) {
                            totExpences = peopleCount * 10.46;
                            discount = totExpences * 0.85;
                            flag = true;
                        } else
                            totExpences = peopleCount * 10.46;
                        break;
                }
                break;
            case "Business":
                switch (vacPeriod) {
                    case "Friday":
                        if (peopleCount >= 100) {
                            totExpences = peopleCount * 10.90;
                            discount = totExpences - 10 * 10.90;
                            flag = true;
                        } else
                            totExpences = peopleCount * 10.90;
                        break;

                    case "Saturday":
                        if (peopleCount >= 100) {
                            totExpences = peopleCount * 15.60;
                            discount = totExpences - 10 * 15.60;
                            flag = true;
                        } else
                            totExpences = peopleCount * 15.60;
                        break;

                    case "Sunday":
                        if (peopleCount >= 100) {
                            totExpences = peopleCount * 16;
                            discount = totExpences - 10 * 16;
                            flag = true;

                        } else
                            totExpences = peopleCount * 16;
                        break;
                }
                break;
            case "Regular":
                switch (vacPeriod) {
                    case "Friday":
                        if (peopleCount >= 10 && peopleCount <= 20) {
                            totExpences = peopleCount * 15;
                            discount = totExpences - totExpences * 0.05;
                            flag = true;

                        } else
                            totExpences = peopleCount * 15;

                        //  if (peopleCount % 20 == 0) {
                        //      discount = totExpences - totExpences * (peopleCount / 20 * 0.05);
                        //      flag = true;
                        //  }
                        break;

                    case "Saturday":
                        if (peopleCount >= 10 && peopleCount <= 20) {
                            totExpences = peopleCount * 20;
                            discount = totExpences - totExpences * 0.05;
                            flag = true;

                        } else
                            totExpences = peopleCount * 20;
                        //  if (peopleCount % 20 == 0) {
                        //      discount = totExpences - totExpences * (peopleCount / 20 * 0.05);
                        //      flag = true;
                        //  }
                        break;

                    case "Sunday":
                        if (peopleCount >= 10 && peopleCount <= 20) {
                            totExpences = peopleCount * 22.50;
                            discount = totExpences - totExpences * 0.05;
                            flag = true;

                        } else
                            totExpences = peopleCount * 22.50;
                        //     if (peopleCount % 20 == 0) {
                        //         discount = totExpences - totExpences * (peopleCount / 20 * 0.05);
                        //         flag = true;
                        break;
                }
                break;
            default:
                break;
        }
        if (flag)
            System.out.printf("Total price: %.2f", discount);
        else
            System.out.printf("Total price: %.2f", totExpences);
    }
}
