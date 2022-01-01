package M04_AlgorithmsFundamentals.L01_RecursionAndBacktracking.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T01RecursiveArraySum {
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = findSum(0);
        System.out.println(sum);
    }

    private static int findSum(int index) {
        if (index >= numbers.length) {
            return 0;
        }

        return numbers[index] + findSum(index + 1);
    }
}
