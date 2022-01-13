package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Exercises;

import java.util.Scanner;

public class T01BinomialCoefficients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        long[][] dp = new long[n + 1][k + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= Math.min(row, k); col++) {
                if (col == 0 || col == row) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row - 1][col - 1];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}