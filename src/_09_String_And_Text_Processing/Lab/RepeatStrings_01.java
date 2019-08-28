    package _09_String_And_Text_Processing.Lab;

    import java.util.Scanner;

    public class RepeatStrings_01 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            StringBuilder stringBuilder = new StringBuilder();
            String[] words = sc.nextLine().split(" ");

            for (String word : words) {
                int count = word.length();
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(word);
                }
            }
            System.out.println(stringBuilder);
        }
    }
