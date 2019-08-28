package _09_String_And_Text_Processing.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExtractFile_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();
        List<String> fileInfo = Arrays.asList(path.substring(path.lastIndexOf("\\") + 1).split("\\."));
        String fileName = String.join(".", fileInfo.subList(0, fileInfo.size() - 1));
        String extension = fileInfo.get(fileInfo.size() - 1);

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", extension);
    }
}
