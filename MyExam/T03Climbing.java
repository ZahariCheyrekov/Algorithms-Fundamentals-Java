package M04_AlgorithmsFundamentals.MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T03Climbing {
    public static int[][] dp;
    public static int[][] matrix;
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        matrix = new int[rows][cols];
        dp = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(reader.readLine().split("[\\s]+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = matrix[0][0];

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }

        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + matrix[row][col];
            }
        }

        output(rows - 1, cols - 1);

        int row = rows - 1;
        int col = cols - 1;

        while (row > 0 || col > 0) {
            int top = -1;

            if (row > 0) {
                top = dp[row - 1][col];
            }

            int left = -1;

            if (col > 0) {
                left = dp[row][col - 1];

            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            output(row, col);
        }

        System.out.println(dp[rows - 1][cols - 1]);
        System.out.println(String.join(" ", path.toString()
                .replaceAll("[\\[\\],]", "")));
    }

    private static void output(int row, int col) {
        path.add(matrix[row][col]);
    }
}