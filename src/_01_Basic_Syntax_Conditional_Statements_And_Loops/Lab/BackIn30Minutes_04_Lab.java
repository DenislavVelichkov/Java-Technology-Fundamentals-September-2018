package _01_Basic_Syntax_Conditional_Statements_And_Loops.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackIn30Minutes_04_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hours = Integer.parseInt(reader.readLine());
        int min = Integer.parseInt(reader.readLine()) + 30;


        if (min >= 60) {
            hours++;
            min = min - 60;
            if (hours > 23) {
                hours = 0;
            }
        }
        if (min < 10) {
            System.out.println(hours + ":0" + min);
        } else {
            System.out.println(hours + ":" + min);
        }
    }
}
