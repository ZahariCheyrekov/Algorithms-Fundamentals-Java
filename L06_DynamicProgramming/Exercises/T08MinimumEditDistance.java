package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Exercises;

import java.util.Scanner;

public class T08MinimumEditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int replace = Integer.parseInt(scanner.nextLine());
        int insert = Integer.parseInt(scanner.nextLine());
        int delete = Integer.parseInt(scanner.nextLine());

        char[] first = scanner.nextLine().toCharArray();
        char[] second = scanner.nextLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int i = 1; i <= second.length; i++) {
            dp[0][i] = dp[0][i - 1] + insert;
        }

        for (int i = 1; i <= first.length; i++) {
            dp[i][0] = dp[i - 1][0] + delete;
        }

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    int costInsert = dp[i][j - 1] + insert;
                    int costReplace = dp[i - 1][j - 1] + replace;
                    int costDelete = dp[i - 1][j] + delete;
                    dp[i][j] = Math.min(costInsert, Math.min(costReplace, costDelete));
                }
            }
        }

        System.out.println("Minimum edit distance: " + dp[first.length][second.length]);
    }
}