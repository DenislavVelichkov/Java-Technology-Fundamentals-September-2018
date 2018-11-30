package StringAndTextProcessing_09.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureFinder_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        List<String> decryptionKey = Arrays.asList(line.split(" "));
        StringBuilder stringBuilder = new StringBuilder();
        int keyIterator = 0;

        while (true) {
            String input = sc.nextLine();
            if (input.equals("find")) break;
            List<String> sypher = Arrays.asList(input.split(""));

            for (int i = 0; i < sypher.size(); i++) {
                char asciiInt = (char) (sypher.get(i).charAt(0) -
                        Integer.parseInt(decryptionKey.get(keyIterator)));

                String character = String.valueOf(asciiInt);
                stringBuilder.append(character);

                if ((keyIterator == decryptionKey.size() - 1) ||
                        (decryptionKey.size() > input.length())) {
                    keyIterator = 0;
                } else {
                    keyIterator++;
                }

            }
            String[] tokens = stringBuilder.toString().split("&");
            int locationStartIndex = tokens[2].indexOf("<");
            int locationEndIndex = tokens[2].indexOf(">");
            String location = tokens[2].substring(locationStartIndex + 1, locationEndIndex);
            System.out.printf("Found %s at %s%n", tokens[1], location);

            stringBuilder = new StringBuilder();
            keyIterator = 0;
        }
    }
}
