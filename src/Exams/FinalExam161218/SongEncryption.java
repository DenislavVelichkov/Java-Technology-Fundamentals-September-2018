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

        while (!line.equals("End")) {
            Pattern pattern = Pattern.compile("[A-Z][a-z]+\\s?[A-Z]?[a-z]+\\'?[a-z]+:[A-Z]+\\s?[A-Z]+\\s?[A-Z]+\\s?");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] tokens = line.split(":");
                String artist = tokens[0];
                String song = tokens[1];


                String finaleResult = encryptArtist(artist, keyLength) + "@" + encryptSong(song, keyLength);

                System.out.printf("Successful encryption: %s%n", finaleResult);
            } else {
                System.out.println("Invalid input!");
                line = reader.readLine();
                continue;
            }

            line = reader.readLine();
        }
    }

    private static String encryptSong(String song, int length) {
//        List<Character> tempList = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < song.length(); i++) {
            if (song.charAt(i) == 32 || song.charAt(i) == 44) {
                continue;
            }
            if (length + song.charAt(i) <= 90 || length + song.charAt(i) <= 122) {
                int temp = song.charAt(i) + length;
                str.append((char) temp);
            } else {
                if (length + song.charAt(i) > 122) {
                    int tempLenth = ((length + song.charAt(i)) - 122) + 97;
                    str.append((char) tempLenth);
                }
                if (length + song.charAt(i) > 90) {
                    int tempLenth = ((length + song.charAt(i)) - 90) + 65;
                    str.append((char) tempLenth);
                }
            }
        }

        return str.toString();
    }

    private static String encryptArtist(String artist, int length) {
//        List<Character> tempList = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < artist.length(); i++) {
            if (length + artist.charAt(i) <= 90 || length + artist.charAt(i) <= 122) {
                int temp = artist.charAt(i) + length;
                str.append((char) temp);
            } else {
                if (length + artist.charAt(i) > 122) {
                    int tempLenth = ((length + artist.charAt(i)) - 122) + 97;
                    str.append((char) tempLenth);

                }
                if (length + artist.charAt(i) > 90) {
                    int tempLenth = ((length + artist.charAt(i)) - 90) + 65;
                    str.append((char) tempLenth);

                }
            }
        }
        return str.toString();
    }
}
