package _01_Basic_Syntax_Conditional_Statements_And_Loops.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Devisibleby3_08_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 3; i <= 100; i += 3) {
            System.out.println(i);
        }
    }
}
