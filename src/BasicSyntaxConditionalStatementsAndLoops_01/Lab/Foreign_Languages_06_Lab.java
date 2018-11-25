package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Foreign_Languages_06_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();

        if (country.equals("USA") || country.equals("England")) {
            System.out.println("English");
        } else if (country.equals("Argentina") || country.equals("Mexico") || country.equals("Spain")) {
            System.out.println("Spanish");
        } else {
            System.out.println("unknown");
        }
    }
}

