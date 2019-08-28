package Arrays_03.Lab;

import java.util.Scanner;

public class Yonkov_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[] stuff= new String[size];

        while (true) {
            String positionCandidate = scan.nextLine();

            if (positionCandidate.equals("END")) {
                break;
            }

            int position = Integer.parseInt(positionCandidate);
            String item = scan.nextLine();
            stuff[position] = item;
        }

        String line = scan.nextLine();

    }
}
