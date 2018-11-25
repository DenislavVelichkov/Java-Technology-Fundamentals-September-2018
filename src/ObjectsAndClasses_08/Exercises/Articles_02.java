package ObjectsAndClasses_08.Exercises;

import java.util.Scanner;

class Articles_02 {

    private String title;
    private String content;
    private String author;

    /*Default constructor is generated if there is no other constructor with different parameters.*/
    private Articles_02(String title, String content, String author) {
        this.author = author;
        this.content = content;
        this.title = title;
    }

    /*Good practice is to edit class through its getters and setters*/
    private void edit(String newContent) {
        this.content = newContent;
    }

    private void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    private void rename(String newTitle) {
        this.title = newTitle;
    }

    /*We can override the default toString method with our own code*/
    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
        // this is not a good practice used like this. We could use getter.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split(", ");

        Articles_02 article = new Articles_02(data[0], data[1], data[2]);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split(": ");
            String command = tokens[0];


            switch (command) {
                case "Edit":
                    article.edit(tokens[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(tokens[1]);
                    break;
                default:
                    article.rename(tokens[1]);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
