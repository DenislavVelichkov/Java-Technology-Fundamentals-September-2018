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
        int keyLength = 0;

        while (!line.equals("end")) {
            Pattern pattern = Pattern.compile("^([A-Z])[a-z\\s']*:[A-Z\\s]*$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] tokens = line.split(":");

                String artist = tokens[0];
                String song = tokens[1];
                keyLength = artist.length();

                String finalResult =
                        encrypt(artist, keyLength) +
                        "@" +
                        encrypt(song, keyLength);

                System.out.printf("Successful encryption: %s%n", finalResult);
            } else {
                System.out.println("Invalid input!");
            }

            line = reader.readLine();
        }
    }

    private static String encrypt(String text, int length) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == 32 || text.charAt(i) == 44) {
                str.append(" ");
                continue;
            }

            int temp = text.charAt(i) + length;
            if (Character.isUpperCase(text.charAt(i))) {
                if (temp <= 'Z') {
                    str.append((char) temp);
                } else {
                    temp = (temp - 'Z') + 'A' - 1;
                    str.append((char) temp);
                }
            } else {
                if (temp <= 'z') {
                    str.append((char) temp);
                } else {
                    temp = (temp - 'z') + 'a' - 1;
                    str.append((char) temp);
                }
            }
        }

        return str.toString();
    }
}