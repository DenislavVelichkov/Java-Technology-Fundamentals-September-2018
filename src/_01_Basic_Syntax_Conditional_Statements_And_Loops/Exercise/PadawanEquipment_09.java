package _01_Basic_Syntax_Conditional_Statements_And_Loops.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadawanEquipment_09 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double money = Double.parseDouble(reader.readLine());
        int studentsCount = Integer.parseInt(reader.readLine());
        double lightSaberPrice = Double.parseDouble(reader.readLine());
        double robePrice = Double.parseDouble(reader.readLine());
        double beltPrice = Double.parseDouble(reader.readLine());

        double freeBelts = studentsCount / 6;

        double neededEquipment = (lightSaberPrice * (studentsCount + Math.ceil((studentsCount * 0.1)))) +
                (robePrice * studentsCount) +
                beltPrice * (studentsCount - freeBelts);

        if (money < neededEquipment) {
            System.out.printf("Ivan Cho will need %.2flv more.", neededEquipment - money);

        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", neededEquipment);
        }
    }
}
