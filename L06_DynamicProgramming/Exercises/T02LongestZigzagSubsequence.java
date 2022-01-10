package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Exercises;

import java.util.*;

public class T02LongestZigzagSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = Arrays.stream(scanner.nextLine().split("[\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[sequence.length + 1][2];
        int[][] prev = new int[sequence.length + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;
        int[] best = new int[2];

        for (int currentIndex = 0; currentIndex < sequence.length; currentIndex++) {
            int currentNum = sequence[currentIndex];

            for (int prevIndex = currentIndex - 1; prevIndex >= 0; prevIndex--) {
                int prevNum = sequence[prevIndex];

                if (currentNum > prevNum && dp[currentIndex][0] <= dp[prevIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;

                } else if (currentNum < prevNum && dp[currentIndex][1] <= dp[prevIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }

            if (maxLength < dp[currentIndex][0]) {
                maxLength = dp[currentIndex][0];
                best[0] = currentIndex;
                best[1] = 0;

            } else if (maxLength < dp[currentIndex][1]) {
                maxLength = dp[currentIndex][1];
                best[0] = currentIndex;
                best[1] = 1;
            }
        }

        Deque<Integer> sequenceZigZag = new ArrayDeque<>();

        int beginRow = best[0];
        while (beginRow >= 0) {
            sequenceZigZag.push(sequence[beginRow]);
            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }

        while (!sequenceZigZag.isEmpty()) {
            System.out.print(sequenceZigZag.pop() + " ");
        }
    }
}