package Exams.MidExam041118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuestsJournal_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] inputJournal = line.split(", ");
        ArrayList<String> journal = new ArrayList<>(Arrays.asList(inputJournal));


        while (true) {
            String cmd = sc.nextLine();
            if (cmd.equals("Retire!")) break;

            String[] command = cmd.split(" - ");
            String action = command[0];
            String journalPeace = command[1];

            switch (action) {
                case "Start":
                    if (!journal.contains(journalPeace)) {
                        journal.add(journalPeace);
                    } else {
                        continue;
                    }
                    break;
                case "Complete":
                    journal.remove(journalPeace);
                    break;
                case "Side Quest":
                    String[] newCommand = command[1].split(":");

                    if ((journal.contains(newCommand[0])) && (!journal.contains(newCommand[1]))) {
                        int index = journal.indexOf(newCommand[0]);
                        journal.add(index + 1, newCommand[1]);
                    }

                    break;
                case "Renew":
                    if (journal.contains(journalPeace)) {
                        String temp = journalPeace;
                        journal.remove(journalPeace);
                        journal.add(temp);
                    }
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < journal.size() - 1; i++) {
            System.out.printf("%s, ", journal.get(i));
        }

        System.out.printf("%s", journal.get(journal.size() - 1));
    }
}
