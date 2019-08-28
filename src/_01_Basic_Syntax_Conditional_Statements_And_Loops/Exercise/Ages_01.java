package _01_Basic_Syntax_Conditional_Statements_And_Loops.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ages_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int humanAge = Integer.parseInt(reader.readLine());

        if (humanAge >= 0 && humanAge <= 2){
            System.out.println("baby");
        } else if (humanAge <= 13) {
            System.out.println("child");
        }else if (humanAge <= 19) {
            System.out.println("teenager");
        }else if (humanAge <= 65) {
            System.out.println("adult");
        }else
            System.out.println("elder");
    }
}
