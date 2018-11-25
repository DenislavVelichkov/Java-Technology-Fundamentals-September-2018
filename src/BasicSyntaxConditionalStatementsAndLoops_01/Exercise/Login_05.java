package BasicSyntaxConditionalStatementsAndLoops_01.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userName = reader.readLine();

        int trialCount = 3;

        while (trialCount != 0) {

            String password = reader.readLine();
            if (password.equals(reverseStr(userName))) {
                System.out.printf("User %s logged in.", userName);
                return;
            }
            else
                System.out.println("Incorrect password. Try again.");
            trialCount--;
        }

        System.out.printf("User %s blocked!", userName);
    }

    private static String reverseStr(String userN) { //Reading String backwards
        int i, length = userN.length();
        StringBuilder reverseStr = new StringBuilder(length);

        for (i = (length - 1); i >= 0; i--) {
            reverseStr.append(userN.charAt(i));
        }

        return reverseStr.toString();
    }
}
