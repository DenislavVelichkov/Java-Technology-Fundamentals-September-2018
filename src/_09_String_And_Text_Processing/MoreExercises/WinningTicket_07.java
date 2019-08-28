package _09_String_And_Text_Processing.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] tickets = line.split("[\\s,]+");

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].length() == 20) {
                if (validateWinningTicket(tickets[i])) {
                    String leftHalf = tickets[i].substring(0, tickets[i].length() / 2);
                    String rightHalf = tickets[i].substring(tickets[i].length() / 2);
                    Pattern pattern = Pattern.compile("(@{6,})|(#{6,})|(\\${6,})|(\\^{6,})");
                    Matcher matcherForLeftSide = pattern.matcher(leftHalf);
                    Matcher matcherForRightSide = pattern.matcher(rightHalf);

                    if (matcherForLeftSide.find() && matcherForRightSide.find()) {
                        if ((matcherForLeftSide.group().length() < 10) ||
                                (matcherForRightSide.group().length() < 10)) {
                            System.out.printf("ticket \"%s\" - %d%s%n",
                                    tickets[i],
                                    Math.min(matcherForLeftSide.group().length(),
                                            matcherForRightSide.group().length()),
                                    findBetterGroup(matcherForLeftSide.group(),
                                                    matcherForRightSide.group()));

                        } else if ((matcherForLeftSide.group().length() == 10) &&
                                (matcherForRightSide.group().length() == 10)) {
                            System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",
                                    tickets[i], matcherForLeftSide.group().length(),
                                    matcherForRightSide.group().substring(0, 1));

                        } else {
                            System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                        }
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }

    private static String findBetterGroup(String group, String group1) {
        String symbol;
        if (group.length() > group1.length()) {
            symbol = group.substring(0, 1);
        } else {
            symbol = group1.substring(0, 1);
        }
        return symbol;
    }

    private static boolean validateWinningTicket(String ticket) { //Split String in half
        String leftHalf = ticket.substring(0, ticket.length() / 2);
        String rightHalf = ticket.substring(ticket.length() / 2);

        Pattern pattern = Pattern.compile("(@{6,})|(#{6,})|(\\${6,})|(\\^{6,})");
        Matcher matcherForLeftSide = pattern.matcher(leftHalf);
        Matcher matcherForRightSide = pattern.matcher(rightHalf);

        boolean trueForLeftSide = false;
        boolean trueForRightSide = false;

        if (matcherForLeftSide.find()) {
            trueForLeftSide = true;
        }
        if (matcherForRightSide.find()) {
            trueForRightSide = true;
        }
        if (trueForLeftSide && trueForRightSide) {
            return true;
        } else {
            return false;
        }
    }
}
