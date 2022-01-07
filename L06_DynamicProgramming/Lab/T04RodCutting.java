package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T04RodCutting {
    public static int[] bestPrices;
    public static int[] prevIndex;
    public static int[] prices;
    public static int[] bestCombo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        prices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int length = Integer.parseInt(scanner.nextLine());

        bestPrices = new int[length + 1];
        prevIndex = new int[length + 1];
        bestCombo = new int[length + 1];

        int best = cutRod(length);
        System.out.println(best);

        reconstructSolution(length);
    }

    private static int cutRod(int length) {
        for (int i = 1; i <= length; i++) {
            int currentBest;
            for (int j = 1; j <= i; j++) {
                currentBest = Math.max(bestPrices[i], prices[j] + bestPrices[i - j]);

                if (currentBest > bestPrices[i]) {
                    bestPrices[i] = currentBest;
                    bestCombo[i] = j;
                }
            }
        }
        return bestPrices[length];
    }

    private static void reconstructSolution(int length) {
        while (length - bestCombo[length] != 0) {
            System.out.print(bestCombo[length] + " ");
            length = length - bestCombo[length];
        }
        System.out.println(bestCombo[length]);
    }
}