package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Exercises;

import java.util.Scanner;

public class T06WordDifferences {
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] first = scanner.nextLine().toCharArray();
        char[] second = scanner.nextLine().toCharArray();

        dp = new int[first.length + 1][second.length + 1];

        for (int i = 0; i <= first.length; i++) {
            for (int j = 0; j <= second.length; j++) {

                if (i == 0) {
                    dp[i][j] = j;

                } else if (j == 0) {
                    dp[i][j] = i;

                } else if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }

        System.out.println("Deletions and Insertions: " + dp[first.length][second.length]);
    }
}