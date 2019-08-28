package Arrays_03.Lab;

public class DemoAllNumbersAreOne {

    public static void main(String[] args) {

        int[] x = new int[10];
        for (int i = 1; i < x.length; i++) {
            if (i % 2 == 0) {
                x[i] = 2 * (x[i - 1] + x[i - 2]);
            }else {
                x[i] = 1;
            }
        }
    }
}
