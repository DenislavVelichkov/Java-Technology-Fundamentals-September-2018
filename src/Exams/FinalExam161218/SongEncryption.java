package Exams.FinalExam161218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int keyLength;

        while (!line.equals("end")) {
            Pattern pattern = Pattern.compile("^([A-Z])[a-z]+\\s*([a-z'\\s]*):([A-Z]+\\s)+");
            /*([A-Z])[a-z]+\s*([a-z'\s]*):([A-Z]+\s)+*/
            /*(([A-Z]){1}[a-z]+)\s*([a-z'\s]*):([A-Z]+\s)+*/
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] tokens = line.split(":");
                String artist = tokens[0];
                String song = tokens[1];
                keyLength = artist.length();

                String finaleResult =
                        encrypt(artist, keyLength) +
                        "@" +
                        encrypt(song, keyLength);

                System.out.printf("Successful encryption: %s%n", finaleResult);
            } else {
                System.out.println("Invalid input!");
            }

            line = reader.readLine();
        }
    }

    private static String encrypt(String text, int length) {
        StringBuilder str = new StringBuilder();
        char[] tempCharArray = text.toCharArray();

        for (int i = 0; i < tempCharArray.length; i++) {
            if (length + tempCharArray[i] <= 90) {
                int temp = tempCharArray[i] + length;
                str.append((char) temp);
            } else {
                int tempLenth = ((length + text.charAt(i)) - 90) + 65;
                str.append((char) tempLenth);
            }

            if (length + tempCharArray[i] <= 122) {
                int temp = tempCharArray[i] + length;
                str.append((char) temp);
            } else {
                int tempLength = ((length + text.charAt(i)) - 122) + 97;
                str.append((char) tempLength);
            }
        }

        return str.toString();
    }
}
