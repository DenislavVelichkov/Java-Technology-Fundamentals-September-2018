package _08_Objects_And_Classes.Exercises.Articles2_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split(", ");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }

        String line = sc.nextLine();
        switch (line) {
            case "title":
                articles.stream()
                        .sorted(Comparator.comparing(Article::getTitle))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "content":
                articles.stream()
                        .sorted(Comparator.comparing(Article::getContent))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "author":
                articles.stream()
                        .sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            default:
                break;
        }
    }
}
