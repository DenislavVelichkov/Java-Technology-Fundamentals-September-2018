package Arrays_03.Lab;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class EqualArrays_06 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] array2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxLength = 0;
        int sum = 0;

        if (array1.length >= array2.length) {
            maxLength = array1.length;
        } else {
            maxLength = array2.length;
        }

        for (int i = 0; i < maxLength; i++) {
            sum += array1[i];
                if (array1[i] != array2[i]) {
                    System.out.printf("_03_Arrays are not identical. Found difference at %TopInteger_05_Ver2 index.", i);
                    return;
            }
        }
        System.out.printf("_03_Arrays are identical. Sum: %TopInteger_05_Ver2", sum);
    }
}
