package AssociativeArrays_07.Excersise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy_07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, ArrayList<Double>> studentsGrades = new HashMap<>();

        while (n-- > 0) {
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());

            if (!studentsGrades.containsKey(name)) {
                studentsGrades.put(name, new ArrayList<>());
/*                second approach, inner intitializer of the array:
                  new ArrayList<>({
                  {
                  add.(grade);
                  }
              })*/
                studentsGrades.get(name).add(grade);
            } else {
                studentsGrades.get(name).add(grade);
            }
        }

        Map<String, Double> averageStudents = new HashMap<>();
        for (String name : studentsGrades.keySet()) {
            double sum = 0;
            for (int i = 0; i < studentsGrades.get(name).size(); i++) {
                sum += studentsGrades.get(name).get(i);
            }

            double average = sum / studentsGrades.get(name).size();

            if (average >= 4.50) {
                averageStudents.put(name, average);
            }
        }

        averageStudents.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }
}
