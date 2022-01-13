package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T04SumWithUnlimitedAmountOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(scanner.nextLine());

        int[] dp = new int[targetSum + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= targetSum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[targetSum]);
    }
}