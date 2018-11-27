package StringAndTextProcessing_09.MoreExercises;

import java.util.*;

public class HTML_05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String article = sc.nextLine();
        String title = sc.nextLine();
        String line = sc.nextLine();
        List<String> comments = new ArrayList<>();

        while (!line.equals("end of comments")) {
            comments.add(line);
            line = sc.nextLine();
        }

        System.out.printf("<h1>%n  %s%n</h1>%n", article);
        System.out.printf("<article>%n  %s%n</article>%n", title);
        comments.forEach(e -> {
            System.out.printf("<div>%n  %s%n</div>%n", e);
        });
    }
}
