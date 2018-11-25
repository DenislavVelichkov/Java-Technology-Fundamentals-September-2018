package Lists_05.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10_ver2 {

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
                        coursePlan.add(Integer.parseInt(tempCmd[2]), tempCmd[1]);
                    }

                    break;
                case "Remove":
                    int tempIndex = coursePlan.indexOf(tempCmd[1]);

                    if (checkForExercise(coursePlan, tempIndex)) {
                        coursePlan.remove(tempCmd[1]);
                    } else {
                        coursePlan.remove(tempCmd[1]);
                    }

                    break;
                case "Swap":
                    int indexOfLessonAndEx1 = getCmdIndex(coursePlan, tempCmd[1]);
                    int indexOfLessonAndEx2 = getCmdIndex(coursePlan, tempCmd[2]);
                    String tempCmdWithEx1 = "";
                    String tempCmdWithEx2 = "";

                    if (indexOfLessonAndEx1 != -1) {
                        tempCmdWithEx1 = coursePlan.get(indexOfLessonAndEx1);
                    } else if (indexOfLessonAndEx2 != -1) {
                        tempCmdWithEx2 = coursePlan.get(indexOfLessonAndEx2);
                    }

                    if (coursePlan.contains(tempCmdWithEx1) && coursePlan.contains(tempCmdWithEx2)) {
                        coursePlan = swapElementsWithExercise(coursePlan, tempCmdWithEx1, tempCmdWithEx2);
                    } else if (coursePlan.contains(tempCmd[1]) && coursePlan.contains(tempCmd[2])) {
                        coursePlan = swapElementsWithoutExercise(coursePlan, tempCmd[1], tempCmd[2]);
                    } else if (coursePlan.contains(tempCmd[1]) && coursePlan.contains(tempCmdWithEx2)) {
                        coursePlan = swapElementsBiPolar(coursePlan, tempCmd[1], tempCmd[2], tempCmdWithEx2);
                    } else if (coursePlan.contains(tempCmd[2]) && coursePlan.contains(tempCmdWithEx1)) {
                        coursePlan = swapElementsBiPolar2(coursePlan, tempCmd[2], tempCmd[1], tempCmdWithEx1);
                    }

                    break;
                case "Exercise":
                    int getLessonIndex = coursePlan.indexOf(tempCmd[1]);
                    if (coursePlan.contains(tempCmd[1]) && !checkForExercise(coursePlan, getLessonIndex)) {
                        coursePlan.add(getLessonIndex + 1, tempCmd[1] + "-Exercise");
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

    private static List<String> swapElementsBiPolar2(List<String> coursePlan, String s, String s1, String tempCmdWithEx1) {
        int indexOf2ndLesson = coursePlan.indexOf(s);
        int indexOf1stLesson = coursePlan.indexOf(s1);
        int indexOf2stLessonEx = coursePlan.indexOf(tempCmdWithEx1);
        String temp1 = s;

        coursePlan.set(indexOf1stLesson, s1);
        coursePlan.set(indexOf2ndLesson, s);
        coursePlan.add(indexOf1stLesson + 1, tempCmdWithEx1);
        coursePlan.remove(indexOf2stLessonEx);

        return coursePlan;
    }

    private static List<String> swapElementsBiPolar(List<String> coursePlan, String tempCmd, String tempCmd2, String cmdWithEx2) {
        int indexOf1stLesson = coursePlan.indexOf(tempCmd);
        int indexOf2ndLesson = coursePlan.indexOf(tempCmd2);
        int indexOf2stLessonEx = coursePlan.indexOf(cmdWithEx2);
        String temp1 = tempCmd;

        coursePlan.set(indexOf1stLesson, tempCmd2);
        coursePlan.set(indexOf2ndLesson, temp1);
        coursePlan.add(indexOf1stLesson + 1, cmdWithEx2);
        coursePlan.remove(indexOf2stLessonEx);


        return coursePlan;
    }

    private static List<String> swapElementsWithExercise(List<String> coursePlan, String s, String s1) {
        int indexOf1stLesson = coursePlan.indexOf(s) + 1;
        int indexOf2ndLesson = coursePlan.indexOf(s1) + 1;

        String tempElmnt = s;
        coursePlan.set(indexOf1stLesson, s1);
        coursePlan.set(indexOf2ndLesson, tempElmnt);
        return coursePlan;
    }

    private static List<String> swapElementsWithoutExercise(List<String> coursePlan, String tempCmd1, String tempCmd2) {
        int indexOf1stLesson = coursePlan.indexOf(tempCmd1);
        int indexOf2ndLesson = coursePlan.indexOf(tempCmd2);

        String tempElmnt = tempCmd1;
        coursePlan.set(indexOf1stLesson, tempCmd2);
        coursePlan.set(indexOf2ndLesson, tempElmnt);

        if (coursePlan.contains(tempCmd1 + "-Exercise")) {
            int index = coursePlan.indexOf(tempCmd1 + "-Exercise");
            coursePlan.add(indexOf2ndLesson + 1, tempCmd1 + "-Exercise");
            coursePlan.remove(index + 1);
        } else {
            if (coursePlan.contains(tempCmd2 + "-Exercise")) {
                int index = coursePlan.indexOf(tempCmd2 + "-Exercise");
                coursePlan.add(indexOf1stLesson + 1, tempCmd2 + "-Exercise");
                coursePlan.remove(index + 1);
            }
        }
        return coursePlan;
    }

        private static int getCmdIndex (List < String > coursePlan, String s){
            if (coursePlan.contains(s + "-Exercise")) {
                return coursePlan.indexOf(s + "-Exercise");
            }
            return -1;
        }

        private static boolean checkForExercise (List < String > coursePlan,int index){
            return coursePlan.get(index).contains("-Exercise");
        }

}