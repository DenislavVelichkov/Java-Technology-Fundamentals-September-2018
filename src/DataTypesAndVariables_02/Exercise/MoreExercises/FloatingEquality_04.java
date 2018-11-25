package DataTypesAndVariables_02.Exercise.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloatingEquality_04 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double num1 = Double.parseDouble(reader.readLine());
        double num2 = Double.parseDouble(reader.readLine());

        double diff = Math.abs(num1 - num2);
        float eps = 0.000001f;
        boolean isTrue= true;

        if (diff >= eps){
            isTrue = false;
        }

        String special = isTrue + ""; // true with capital letter
        special = (special.charAt(0)+"").toUpperCase() + special.substring(1);
        System.out.println(special);
    }
}
