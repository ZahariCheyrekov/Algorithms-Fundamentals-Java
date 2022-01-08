package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T07ConnectingCables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cables = Arrays.stream(scanner.nextLine().split("[\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] dest = new int[cables.length];

        for (int i = 0; i < dest.length; i++) {
            dest[i] = i + 1;
        }

        int[][] dp = new int[cables.length + 1][cables.length + 1];

        for (int row = 1; row <= cables.length; row++) {
            for (int col = 1; col <= cables.length; col++) {
                if (cables[col - 1] == dest[row - 1]) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        System.out.println("Maximum pairs connected: " + dp[cables.length][cables.length]);
    }
}