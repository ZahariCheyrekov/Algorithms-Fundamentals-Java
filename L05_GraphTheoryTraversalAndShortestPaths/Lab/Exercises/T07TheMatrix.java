package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T07TheMatrix {
    public static char[][] matrix;
    public static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = readData();

        int rows = dimensions[0];
        int cols = dimensions[1];

        readMatrix(rows, cols);

        char fillChar = reader.readLine().charAt(0);

        int[] startPoints = readData();

        int rowIndex = startPoints[0];
        int colIndex = startPoints[1];

        char toBeReplaced = matrix[rowIndex][colIndex];

        fillMatrix(rowIndex, colIndex, fillChar, toBeReplaced);

        StringBuilder output = new StringBuilder();
        for (char[] row : matrix) {
            for (char col : row) {
                output.append(col);
            }
            output.append(System.lineSeparator());
        }

        System.out.print(output);
    }

    private static void fillMatrix(int row, int col, char fillChar, char toBeReplaced) {
        if (!isValid(row, col, toBeReplaced)) {
            return;
        }

        matrix[row][col] = fillChar;

        fillMatrix(row + 1, col, fillChar, toBeReplaced);
        fillMatrix(row - 1, col, fillChar, toBeReplaced);
        fillMatrix(row, col + 1, fillChar, toBeReplaced);
        fillMatrix(row, col - 1, fillChar, toBeReplaced);
    }

    private static boolean isValid(int row, int col, char toBeReplaced) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length) &&
                (matrix[row][col] == toBeReplaced);
    }


    private static void readMatrix(int rows, int cols) throws IOException {
        matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
    }

    private static int[] readData() throws IOException {
        return Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}