package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertMetersToKilometers_04 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double meters = Integer.parseInt(reader.readLine());

        System.out.printf("%.2f",meters / 1000);
    }
}
