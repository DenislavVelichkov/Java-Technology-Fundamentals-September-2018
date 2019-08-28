package Arrays_03.Lab;


import java.util.Scanner;

public class StringToIntArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String values = sc.nextLine();

        String[] items = values.split(" ");
        int[] arr = new int[items.length]; //Take the number of String chars and makes new array with same length

        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]); // appends the numeric value of the string elements in new int array
            System.out.println(arr[i] + " ");
        }
    }
}
