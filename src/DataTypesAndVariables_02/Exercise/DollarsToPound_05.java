package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DollarsToPound_05 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double gbp = Double.parseDouble(reader.readLine());

        System.out.printf("%.3f",gbp * 1.31);
    }
}
