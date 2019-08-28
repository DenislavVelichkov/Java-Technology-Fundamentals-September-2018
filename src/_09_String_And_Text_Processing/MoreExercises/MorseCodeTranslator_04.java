package _09_String_And_Text_Processing.MoreExercises;

import java.util.Scanner;

public class MorseCodeTranslator_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" \\| ");
        StringBuilder words = new StringBuilder();

        for (int i = 0; i < line.length; i++) {
            String[] letters = line[i].split(" ");

            words.append(translate(letters)).append(" ");


        }
        System.out.print(words + " ");
    }

    private static String translate(String[] letters) {
        String word = "";
        for (int i = 0; i < letters.length; i++) {

            if (letters[i].equals(".-")) {
                word += "A";
            } else if (letters[i].equals("-...")) {
                word += "B";
            } else if (letters[i].equals("-.-.")) {
                word += "C";
            } else if (letters[i].equals("-..")) {
                word += "D";
            } else if (letters[i].equals(".")) {
                word += "E";
            } else if (letters[i].equals("..-.")) {
                word += "F";
            } else if (letters[i].equals("--.")) {
                word += "G";
            } else if (letters[i].equals("....")) {
                word += "H";
            } else if (letters[i].equals("..")) {
                word += "I";
            } else if (letters[i].equals(".---")) {
                word += "J";
            } else if (letters[i].equals("-.-")) {
                word += "K";
            } else if (letters[i].equals(".-..")) {
                word += "L";
            } else if (letters[i].equals("--")) {
                word += "M";
            } else if (letters[i].equals("-.")) {
                word += "N";
            } else if (letters[i].equals("---")) {
                word += "O";
            } else if (letters[i].equals(".--.")) {
                word += "P";
            } else if (letters[i].equals("--.-")) {
                word += "Q";
            } else if (letters[i].equals(".-.")) {
                word += "R";
            } else if (letters[i].equals("...")) {
                word += "S";
            } else if (letters[i].equals("-")) {
                word += "T";
            } else if (letters[i].equals("..-")) {
                word += "U";
            } else if (letters[i].equals("...-")) {
                word += "V";
            } else if (letters[i].equals(".--")) {
                word += "W";
            } else if (letters[i].equals("-..-")) {
                word += "X";
            } else if (letters[i].equals("-.--")) {
                word += "Y";
            } else if (letters[i].equals("--..")) {
                word += "Z";
            }


        }
        return word;
    }
}
