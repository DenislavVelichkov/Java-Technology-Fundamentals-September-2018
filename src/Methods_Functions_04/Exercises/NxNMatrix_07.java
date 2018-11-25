package Methods_Functions_04.Exercises;

        import java.util.Scanner;

public class NxNMatrix_07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        matrix(n, String.valueOf(n));
    }

    private static void matrix(int s, String string) {

        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= s; j++) {
                System.out.printf("%s " , string);
            }
            System.out.println();
        }
    }
}
