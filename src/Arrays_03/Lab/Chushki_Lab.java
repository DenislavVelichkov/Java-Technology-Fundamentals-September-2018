package Arrays_03.Lab;

import java.util.Scanner;

public class Chushki_Lab {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        String[] stuff = new String[size];


        while(true) {
            String positionCandidate = sc.nextLine();
            if (positionCandidate.equals("END")) {
                break;
            }
            int positionToSet = Integer.parseInt(positionCandidate);
            String item = sc.nextLine();
            if (positionToSet > stuff.length-1 || positionToSet < 0) {
                System.out.println("Invalid position. Try again.");
            } else {
                stuff[positionToSet] = item;
            }
        }

        String line = sc.nextLine();

        while (!line.equals("END")) {
            int positionToGet = Integer.parseInt(line);
            if (positionToGet < 0 || positionToGet > stuff.length - 1) {
                System.out.println("Invalid position. Try again.");
            } else {
                String item = stuff[positionToGet];
                if (item != null) {
                    System.out.println(item.substring(
                            Math.min(3, item.length() - 1),
                            Math.min(5, item.length()))
                    );
                } else {
                    System.out.println("Invalid item. You have never set one on that position.");
                }
            }
            line = sc.nextLine();
        }

    }
}