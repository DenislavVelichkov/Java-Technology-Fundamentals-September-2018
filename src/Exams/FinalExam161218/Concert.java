package Exams.FinalExam161218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Concert {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cmd = reader.readLine();
        Map<String, List<String>> band = new LinkedHashMap<>();
        Map<String, Integer> times = new LinkedHashMap<>();
        int totalTime = 0;

        while (!cmd.equals("start of concert")) {
            String[] cmdLine = cmd.split("; ");
            String command = cmdLine[0];
            String bandName = cmdLine[1];

            String[] bandMembers;
//            if (cmdLine[2].contains(",")) {
            bandMembers = cmdLine[2].split(",\\s+");
//            } else {
//                bandMembers = cmdLine[2].split("\\s+");
//            }

            switch (command) {
                case "Add":
                    if (!band.containsKey(bandName)) {
                        band.put(bandName, new ArrayList<>());
                        for (String bandMember : bandMembers) {
                            if (!band.get(bandName).contains(bandMember))
                                band.get(bandName).add(bandMember);
                        }

                    } else {
                        for (String futureMember : bandMembers) {
                            if (!band.get(bandName).contains(futureMember)) {
                                band.get(bandName).add(futureMember);
                            }
                        }
                    }

                    break;
                case "Play":
                    totalTime += Integer.parseInt(cmdLine[2]);
                    times.putIfAbsent(bandName, 0);
                    times.put(bandName, times.get(bandName) + Integer.parseInt(cmdLine[2]));
                    break;
                default:
                    break;
            }


            cmd = reader.readLine();
        }

        System.out.println("Total time: " + totalTime);
        times.entrySet().stream()
                .sorted((o1, o2) -> {
                    int result = Integer.compare(o2.getValue(), o1.getValue());
                    return result != 0 ? result : o1.getKey().compareTo(o2.getKey());
                })
                .forEach(en -> {
                    System.out.printf("%s -> %d%n", en.getKey(), en.getValue());
                });


        cmd = reader.readLine();
        System.out.printf("%s%n", cmd);

        band.get(cmd).forEach(s -> {
            System.out.printf("=> %s%n", s);
        });
    }
}
