package Arrays_03.Lab;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class EvenAndOddSubstraction_05 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arrayOfNum = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < arrayOfNum.length; i++) {
            if (arrayOfNum[i] % 2 == 0) {
                evenSum += arrayOfNum[i];
            } else {
                oddSum += arrayOfNum[i];
            }

        }
        System.out.printf("%TopInteger_05_Ver2", evenSum - oddSum);
    }
}
