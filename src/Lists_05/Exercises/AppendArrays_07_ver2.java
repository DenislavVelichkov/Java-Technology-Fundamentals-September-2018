package Lists_05.Exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppendArrays_07_ver2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.stream(scan.nextLine()
                .split("\\|")).map(String::trim)
                .collect(Collectors.toList());
        Collections.reverse(input);
        input.stream().map(e -> Arrays.stream(e.split("\\s")))
                .flatMap(Function.identity())
                .toString().replace(" ", "");
//                .forEach(e -> System.out.print(e + " "));
    }
}
