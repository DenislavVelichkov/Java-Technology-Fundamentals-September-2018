package Arrays_03.MoreExcersises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LongestIncreasingSequence_04 {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split(" ");
        int[] sequence = Arrays.stream(str).mapToInt(x -> Integer.parseInt(x)).toArray();

        List<Integer> longestSeq = FindLongestIncreasingSequence(sequence);

        System.out.println("Longest increasing subsequently (LIS)");
        System.out.println("Sequence:" + " " + longestSeq);
    }

    private static List<Integer> FindLongestIncreasingSequence(int[] sequence) {
        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];
        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            length[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i] && length[j] >= length[i]) {
                    length[i] = 1 + length[j];
                    prev[i] = j;
                }
            }

            if (length[i] > maxLength) {
                maxLength = length[i];
                lastIndex = i;
            }
        }

        List<Integer> longestSeq = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            longestSeq.set(i, (sequence[lastIndex]));
            lastIndex = prev[lastIndex];
        }

        return longestSeq;
    }
}
