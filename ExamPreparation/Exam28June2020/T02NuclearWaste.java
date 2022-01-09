package M04_AlgorithmsFundamentals.ExamPreparation.Exam28June2020;

import java.util.*;

public class T02NuclearWaste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequenceFlasks = Arrays.stream(scanner.nextLine().split("[\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        int transportNumber = Integer.parseInt(scanner.nextLine());

        int cost = minCost(sequenceFlasks, transportNumber);

        System.out.println("Cost: " + cost);
    }

    public static int minCost(int[] cost, int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            int min_cost = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++)
                if (j < cost.length && cost[j] != -1) {
                    min_cost = Math.min(min_cost, cost[j] + dp[i - j - 1]);
                }
            dp[i] = min_cost;
        }

        return dp[num];
    }
}