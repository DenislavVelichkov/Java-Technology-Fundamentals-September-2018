package Lists_05.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> coursePlan = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
        String command = sc.nextLine();

        while (!command.equals("course start")) {
            String[] tempCmd = command.split(":");
            String action = tempCmd[0];

            switch (action) {
                case "Add":
                    if (!coursePlan.contains(tempCmd[1])) {
                        coursePlan.add(tempCmd[1]);
                    }

                    break;
                case "Insert":
                    if (!coursePlan.contains(tempCmd[1])) {
                        if (Integer.parseInt(tempCmd[2]) >= 0 && Integer.parseInt(tempCmd[2]) <= coursePlan.size()) {
                            coursePlan.add(Integer.parseInt(tempCmd[2]), tempCmd[1]);
                        }
                    }

                    break;
                case "Remove":
                    int tempIndex = coursePlan.indexOf(tempCmd[1]);

                    if (checkForExercise(coursePlan, tempCmd[1])) {
                        coursePlan.remove(tempIndex);
                        coursePlan.remove(tempCmd[1] + "-Exercise");
                    } else {
                        coursePlan.remove(tempCmd[1]);
                    }

                    break;
                case "Swap":
                    if (coursePlan.contains(tempCmd[1]) && coursePlan.contains(tempCmd[2])) {
                        coursePlan = swapElements(coursePlan, tempCmd[1], tempCmd[2]);
                    }

                    break;
                case "Exercise":
                    int getLessonIndex = coursePlan.indexOf(tempCmd[1]);

                    if (coursePlan.contains(tempCmd[1])) {
                        if (!checkForExercise(coursePlan, tempCmd[1])) {
                            coursePlan.add(getLessonIndex + 1, tempCmd[1] + "-Exercise");
                        }
                    } else if (!coursePlan.contains(tempCmd[1]) && checkForExercise(coursePlan, tempCmd[1])) {
                        int index = coursePlan.indexOf(tempCmd[1] + "-Exercise");
                        coursePlan.add(index - 1, tempCmd[1]);
                    } else {
                        coursePlan.add(tempCmd[1]);
                        coursePlan.add(tempCmd[1] + "-Exercise");
                    }

                    break;
            }


            command = sc.nextLine();
        }
        for (int i = 0; i < coursePlan.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, coursePlan.get(i));
        }
    }

    private static List<String> swapElements(List<String> coursePlan, String tempCmd1, String tempCmd2) {
        int indexOf1stLesson = coursePlan.indexOf(tempCmd1);
        int indexOf2ndLesson = coursePlan.indexOf(tempCmd2);

        String tempElmnt = tempCmd1;
        coursePlan.set(indexOf1stLesson, tempCmd2);
        coursePlan.set(indexOf2ndLesson, tempElmnt);

        if (coursePlan.contains(tempCmd1 + "-Exercise")) {
            int index = coursePlan.indexOf(tempCmd1 + "-Exercise");

            coursePlan.add(indexOf2ndLesson + 1, tempCmd1 + "-Exercise");
            coursePlan.remove(index + 1);
        } else if (coursePlan.contains(tempCmd2 + "-Exercise")) {
            int index = coursePlan.indexOf(tempCmd2 + "-Exercise");

            coursePlan.add(indexOf1stLesson + 1, tempCmd2 + "-Exercise");
            coursePlan.remove(index + 1);
        }

        return coursePlan;
    }

    private static boolean checkForExercise(List<String> coursePlan, String cmd) {
        return coursePlan.contains(cmd + "-Exercise");
    }

}