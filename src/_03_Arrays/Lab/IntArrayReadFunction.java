package Arrays_03.Lab;


import java.util.Arrays;
import java.util.Scanner;

public class IntArrayReadFunction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//
      //  String values = sc.nextLine();
//
      //  String[] items = values.split(" ");
        //   int[] arr = _03_Arrays.stream(items).mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] arr = Arrays.stream(sc.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        System.out.println(arr);

    }
}
