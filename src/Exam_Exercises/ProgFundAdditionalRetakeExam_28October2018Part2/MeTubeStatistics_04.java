package Exam_Exercises.ProgFundAdditionalRetakeExam_28October2018Part2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> videosWithViews = new HashMap<>();
        Map<String, Integer> videosWithLikes = new HashMap<>();

        String input = sc.nextLine();

        while (!input.equals("stats time")) {
            if (input.contains("-")) {
                String[] tokens = input.split("-");
                String video = tokens[0];
                int views = Integer.parseInt(tokens[1]);

                if (!videosWithViews.containsKey(video)) {
                    videosWithViews.put(video, views);
                    videosWithLikes.put(video, 0);
                } else {
                    videosWithViews.put(video, videosWithViews.get(video) + views);
                }
            } else {
                String[] tokens = input.split(":");
                String video = tokens[1];

                if (tokens[0].equals("like")) {
                    if (videosWithLikes.containsKey(video)) {
                        videosWithLikes.put(video, videosWithLikes.get(video) + 1);
                    }
                } else {
                    if (videosWithLikes.containsKey(video)) {
                        videosWithLikes.put(video, videosWithLikes.get(video) - 1);
                    }
                }
            }

            input = sc.nextLine();
        }

        String sortCriteria = sc.nextLine();

        if (sortCriteria.equals("by views")) {
            videosWithViews.entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .forEach(entry -> {
                        System.out.printf("%s - %d views - %d likes%n",
                                entry.getKey(),
                                entry.getValue(),
                                videosWithLikes.get(entry.getKey()));

                    });
        } else {
                videosWithLikes.entrySet().stream()
                        .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                        .forEach(entry -> {
                            System.out.printf("%s - %d views - %d likes%n",
                                    entry.getKey(),
                                    videosWithViews.get(entry.getKey()),
                                    entry.getValue());

                        });
        }

    }
}
