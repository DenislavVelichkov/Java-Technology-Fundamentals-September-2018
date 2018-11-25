package ObjectsAndClasses_08.Exercises.Students_05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();

        while (n-- > 0) {
            String[] data = sc.nextLine().split(" ");
            Student student = new Student(data[0], data[1], Float.parseFloat(data[2]));
            students.add(student);
        }

        students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .forEach(student -> System.out.println(student.toString()));

    }
}
